/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

/**
 *
 * @author E064958
 */
public class GameMenu 
{
    private boolean startGame;
    private Input input;
    
    /**
     * Default Constructor
     */
    public GameMenu()
    {
        startGame = false;
        input = new Input();
    }
    
    .placeholder
    /**
     * Not sure if input should be in this class.  Might be out of scope...
     * plus have to then figure out how to use the entered input back in the 
     * main class... Might need to either handle input in the Hangman class 
     * creating an input object to handle input, but instance stored in main
     * Hangman class.  Otherwise I need to create methods to get the input from
     * this class, but again I think that's out of the scope of this class.  As 
     * this class should just handle the menu...that or enterLetter method
     * shouldn't be in this class...
     * @return 
     */
    public String StartGame()
    {
        System.out.println(" Type (Y) to start a game or (N) to exit.");
        input.setInput();
        if ( input.getInput().equalsIgnoreCase( "Y" ) )
            startGame = true;
        else if ( input.getInput().equalsIgnoreCase( "N" ) )
            startGame = false;
        else
        {
            System.out.println("I'm sorry,  but we did not understand your "
                    + "request.  Please enter either (Y) for yes or (N) for no"
                    + "");
            this.StartGame();
        }
        return input.getInput();
    }
    
    public void EnterLetter()
    {
        System.out.print("Please enter a letter or the word you would like to"
                + " guess: ");
    }
    
    public void EndGame()
    {
        startGame = false;
    }
    
    public boolean CheckGameStart()
    {
        return startGame;
    }
}
