package tech.elegal.challenge.domain.specification;

public class UpperCaseSpecification implements PasswordSpecification
{
    @Override
    public boolean isSatisfiedBy( String password )
    {
        return password.matches( ".*[A-Z].*" );
    }
}
