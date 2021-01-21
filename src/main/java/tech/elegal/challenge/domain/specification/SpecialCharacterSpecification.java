package tech.elegal.challenge.domain.specification;

public class SpecialCharacterSpecification implements PasswordSpecification
{
    private final String characterAllowed;

    public SpecialCharacterSpecification( String characterAllowed )
    {
        this.characterAllowed = characterAllowed;
    }

    @Override
    public boolean isSatisfiedBy( String password )
    {
        return password.matches( String.format( "^[a-zA-Z0-9%s ]+$", characterAllowed ) ) &&
                password.matches( String.format( ".*[%s].*", characterAllowed ) );
    }
}
