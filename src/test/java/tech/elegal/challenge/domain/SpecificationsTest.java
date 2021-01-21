package tech.elegal.challenge.domain;

import tech.elegal.challenge.domain.entity.Password;
import tech.elegal.challenge.domain.factory.ChallengePasswordFactory;
import tech.elegal.challenge.domain.specification.PasswordSpecification;
import tech.elegal.challenge.domain.specification.RepeatedCharacterSpecification;
import tech.elegal.challenge.domain.specification.SpecialCharacterSpecification;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
class SpecificationsTest
{
    // <editor-fold desc="[ CARACTERES ESPECIAIS ]">

    @Test
    void passwordWithBracket()
    {
        PasswordSpecification spec = new SpecialCharacterSpecification( "!@#$%^&*()-+" );
        assertFalse( spec.isSatisfiedBy( "AbTp9]fok" ) );
    }

    @Test
    void passwordWithBraces()
    {
        PasswordSpecification spec = new SpecialCharacterSpecification( "!@#$%^&*()-+" );
        assertFalse( spec.isSatisfiedBy( "AbTp9{fok" ) );
    }

    //</editor-fold>

    // <editor-fold desc="[ MÁXIMO DE CARACTERES REPETIDOS ]">

    @Test
    void passwordWithMaximumOf2CharactersRepeated()
    {
        PasswordSpecification spec = new RepeatedCharacterSpecification( 2 );
        assertTrue( spec.isSatisfiedBy( "AAbTp9@fok" ) );
    }

    @Test
    void passwordWithMaximumOf3CharactersRepeated()
    {
        PasswordSpecification spec = new RepeatedCharacterSpecification( 3 );
        assertFalse( spec.isSatisfiedBy( "AAAccTp9@fokXXXX" ) );
    }

    @Test
    void noRepeatedCharacters()
    {
        PasswordSpecification spec = new RepeatedCharacterSpecification( 0 );
        assertFalse( spec.isSatisfiedBy( "AAbTp9@fok" ) );
    }

    //</editor-fold>

    @Test
    void withAllConditions() throws PasswordException
    {
        Password password = ChallengePasswordFactory.create( "AbTp9!fok" );
        assertTrue( password.isValid() );
    }
}