package tech.elegal.challenge.domain.entity;

import tech.elegal.challenge.domain.PasswordException;
import tech.elegal.challenge.domain.specification.PasswordSpecification;

import java.util.Arrays;

public class Password
{
    private final String passwordData;
    private final PasswordSpecification[] specifications;

    public Password( String senha, PasswordSpecification... specifications ) throws PasswordException
    {
        if ( senha == null )
            throw new PasswordException( "A senha não pôde ser validada." );

        if ( specifications == null || specifications.length == 0 )
            throw new PasswordException( "A senha não pôde ser validada." );

        this.specifications = specifications;
        this.passwordData = senha;
    }

    public boolean isValid()
    {
        return Arrays.stream( specifications )
                     .allMatch( spec -> spec.isSatisfiedBy( getPasswordData() ) );
    }

    public String getPasswordData()
    {
        return passwordData;
    }
}