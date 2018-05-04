package hangman;

/**
 * @author E064958
 */
public class Guesses 
{
    private String guesses;
    
    /**
     * Default Constructor.
     */
    public Guesses()
    {
        guesses = "";
    }
    
    /**
     * Prints out all guesses.
     */
    public void printGuess()
    {
        System.out.println( "Guesses: " + guesses );
    }
    
    /**
     * Add guess to string.
     * @param s String of all guesses delimited by a comma
     */
    public void addGuess( String s )
    {
        if ( guesses.isEmpty() )
            guesses += s;
        else
            guesses += ", " + s;
    }
    
    /**
     * Checks if the string is empty.
     * @return Boolean
     */
    public boolean isEmpty()
    {
        return guesses.isEmpty();
    }
    
}
