package hangman;

import java.util.Scanner;

/**
 * @author E064958
 */
public class Input 
{
    private final Scanner scanner;
    private String input;
    
    /**
     * Default Constructor
     */
    public Input()
    {
        scanner = new Scanner( System.in );
        input = "";
    }
    
    /**
     * Gets and assigns input value
     */
    public void setInput()
    {
        input = scanner.nextLine().toLowerCase();
    }
    
    /**
     * Returns the entered input
     * @return String
     */
    public String getInput()
    {
        return input;
    }
}
