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
public class Guesses 
{
    private String guesses;
    
    public Guesses()
    {
        guesses = "";
    }
    
    public void printGuess()
    {
        System.out.println( "Guesses: " + guesses );
    }
    
    public void addGuess( String s )
    {
        if ( guesses.isEmpty() )
            guesses += s;
        else
            guesses += ", " + s;
    }
    
    public boolean isGuesses()
    {
        return !guesses.isEmpty();
    }
    
}
