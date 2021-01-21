package tech.elegal.challenge.domain.specification;

public class RepeatedCharacterSpecification implements PasswordSpecification
{
    private final int maximumRepetition;

    public RepeatedCharacterSpecification( int maximumRepetition )
    {
        if (maximumRepetition == 0)
            maximumRepetition++;

        this.maximumRepetition = maximumRepetition;
    }

    @Override
    public boolean isSatisfiedBy( String password )
    {
        int max = 1;
        for ( int i = 1; i < password.length(); i++ )
        {
            int count = 1;
            while ( i < password.length() && password.charAt( i - 1 ) == password.charAt( i ) )
            {
                count++;
                i++;
                max = Math.max( count, max );
            }
        }

        return max == maximumRepetition;
    }
}
