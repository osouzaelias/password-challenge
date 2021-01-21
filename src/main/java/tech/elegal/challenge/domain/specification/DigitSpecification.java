package tech.elegal.challenge.domain.specification;

public class DigitSpecification implements PasswordSpecification
{
    @Override
    public boolean isSatisfiedBy( String password )
    {
        return password.matches( ".*[0-9].*" );
    }
}
