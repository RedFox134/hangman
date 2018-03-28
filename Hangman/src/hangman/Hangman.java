/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.io.IOException;

/**
 *
 * @author alexp
 */
public class Hangman {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws IOException, 
            InterruptedException 
    {
        //Load Game
        Noose noose = new Noose();
        System.out.println("Hang Man v0.0.1");
        noose.printNoose();
        WordToGuess wordToGuess = new WordToGuess();
        wordToGuess.printHiddenWordToGuess();
        //Game Menu
        System.out.println(" Type (Y) to start a game or (N) to exit.");
        boolean incorrectGuess, startGame;
        startGame = false;
        Input input = new Input();
        while( !startGame )
        {
            input.setInput();
            if ( input.getInput().equalsIgnoreCase( "Y" ) )
            startGame = true;
            else if ( input.getInput().equalsIgnoreCase( "N" ) )
            {
                startGame = false;
                break;
            }
            else
            {
                System.out.println("I'm sorry,  but we did not understand your"
                    + " request.  Please enter either (Y) for yes or (N) for no"
                    + "");
                System.out.println(" Type (Y) to start a game or (N) to exit.");
            }
        }
        while( wordToGuess.getHiddenWordToGuess().contains("_") 
                && startGame && !noose.isHung() )
        {
            //take user input, input can be single character or word
            System.out.print("Please enter a letter or the word you would like"
                    + " to guess: ");
            input.setInput();
            //check if letter or word
            //if letter check if it matches any
            //if it does match replace _ with the letter
            //if it doesn't, add body part
            //if word matches
            //if it doesn't add a body part
            incorrectGuess = wordToGuess.checkGuess( input.getInput() );
            //if it doesn't add body part to noose
            if ( !incorrectGuess )
            {
                noose.incrementIncorrectGuessCounter();
                noose.updateNoose();
            }
            //each time noose is updated clear screen and draw new noose
            //clears screen in a command prompt window
            //does not appear to work in the netbeans console though >:(
            //this only works on windows and should probably be put in a try catch
            //Source: https://stackoverflow.com/questions/2979383/java-clear-the-console
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            noose.printNoose();
            wordToGuess.printHiddenWordToGuess();
            //if hung display word and game over
            if ( wordToGuess.getHiddenWordToGuess().contains( "_" ) 
                    && noose.isHung() )
            {
                System.out.println( "You were hung!" );
                System.out.println( "The hidden word was: " 
                        + wordToGuess.getWordToGuess() );
                System.out.println( "Better luck next time!" );
            }
            else if ( !wordToGuess.getHiddenWordToGuess().contains( "_" ) )
                System.out.println("Congratulations!  You Win!");
            //check to restart game or not
            while ( noose.isHung() || 
                    !wordToGuess.getHiddenWordToGuess().contains( "_" ) )
            {
                System.out.print( "Start a new game? (Y) or (N): " );
                input.setInput();
                //if not prompt for new input
                if ( input.getInput().compareToIgnoreCase( "y" ) == 0 )
                {
                    noose = new Noose();
                    startGame = true;
                    wordToGuess = new WordToGuess();
                }
                else if ( input.getInput().compareToIgnoreCase( "n" ) == 0 )
                {
                    noose = new Noose();
                    startGame = false;
                    break;
                }
                else
                    System.out.println("I'm sorry, but we did not "
                            + "recoginize that input.  Please enter either "
                            + "Y for yes or N for no.");
            }
        }
        //clears screen in a command prompt window
        //does not appear to work in the netbeans console though >:(
        //this only works on windows and should probably be put in a try catch
        //Source: https://stackoverflow.com/questions/2979383/java-clear-the-console
        //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
    
}
