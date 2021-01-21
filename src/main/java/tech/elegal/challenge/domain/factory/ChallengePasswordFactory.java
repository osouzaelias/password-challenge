package tech.elegal.challenge.domain.factory;

import tech.elegal.challenge.domain.PasswordException;
import tech.elegal.challenge.domain.entity.Password;
import tech.elegal.challenge.domain.specification.*;

public class ChallengePasswordFactory
{
    public static Password create( String senha ) throws PasswordException
    {
        return new Password( senha,
                             new DigitSpecification(),
                             new LengthSpecification( 9 ),
                             new LowerCaseSpecification(),
                             new RepeatedCharacterSpecification( 0 ),
                             new UpperCaseSpecification(),
                             new SpecialCharacterSpecification( "!@#$%^&*()-+" ) );
    }
}
