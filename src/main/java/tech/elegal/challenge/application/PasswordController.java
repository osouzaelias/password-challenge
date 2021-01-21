package tech.elegal.challenge.application;

import tech.elegal.challenge.domain.PasswordException;
import tech.elegal.challenge.domain.entity.Password;
import tech.elegal.challenge.domain.factory.ChallengePasswordFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/password" )
public class PasswordController
{
    @PostMapping( "/" )
    public ResponseEntity isValid( @RequestBody String passwordData )
    {
        try
        {
            Password password = ChallengePasswordFactory.create( passwordData );
            return ResponseEntity.status( HttpStatus.OK ).body( password.isValid() );
        }
        catch ( PasswordException ex )
        {
            return ResponseEntity.status( HttpStatus.UNPROCESSABLE_ENTITY )
                                 .body( ex.getMessage() );
        }
        catch ( Exception ex )
        {
            return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR )
                                 .body( "Ocorreu um erro inesperado. Por favor, tente novamente." );
        }
    }
}
