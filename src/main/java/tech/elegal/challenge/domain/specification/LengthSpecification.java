package tech.elegal.challenge.domain.specification;

public class LengthSpecification implements PasswordSpecification
{
    private final int passwordLength;

    public LengthSpecification( int passwordLength )
    {
        this.passwordLength = passwordLength;
    }

    @Override
    public boolean isSatisfiedBy( String password )
    {
        return password.matches( String.format( ".{%s,}", passwordLength ) );
    }
}
