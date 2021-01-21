package tech.elegal.challenge.domain.specification;

public class LowerCaseSpecification implements PasswordSpecification
{
    @Override
    public boolean isSatisfiedBy( String password )
    {
        return password.matches( ".*[a-z].*" );
    }
}
