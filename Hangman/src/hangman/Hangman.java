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
    public static void main(String[] args) throws IOException, InterruptedException 
    {
        //Load Game
        Noose noose = new Noose();
        WordToGuess wordToGuess = new WordToGuess();
        boolean startGame;
        startGame = false;
        Input input = new Input();
        Guesses guesses = new Guesses();
        
       //Start Menu
        System.out.println("Hang Man v0.0.2");
        noose.printNoose();
        wordToGuess.printHiddenWordToGuess();
        System.out.println(" Type (Y) to start a game or (N) to exit.");
        
        //Start Game
        while( !startGame )
        {
            input.setInput();
            if ( input.getInput().equalsIgnoreCase( "Y" ) )
                startGame = true;
            else if ( input.getInput().equalsIgnoreCase( "N" ) )
                break;
            else
            {
                //clears screen in a command prompt window
                //does not appear to work in the netbeans console though >:(
                //this only works on windows and should probably be put in a try 
                //catch
                //Source: 
                //https://stackoverflow.com/questions/2979383/java-clear-the-console
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start()
                        .waitFor();
                System.out.println("I'm sorry,  but we did not understand your"
                    + " request.  Please enter either (Y) for yes or (N) for no"
                    + "");
                System.out.println(" Type (Y) to start a game or (N) to exit.");
            }
        }
        while( wordToGuess.getHiddenWordToGuess().contains("_") 
                && startGame && !noose.isHung() )
        {
            /**
             * clears screen in a command prompt window
             * does not appear to work in the netbeans console though >:( 
             * this only works on windows 
             * and should probably be put in a try catch 
             * Source: 
             * https://stackoverflow.com/questions/2979383/java-clear-the-console
             */
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start()
                    .waitFor();
            //take user input, input can be single character or word
            if ( guesses.isGuesses() )
                guesses.printGuess();
            noose.printNoose();
            wordToGuess.printHiddenWordToGuess();
            System.out.print("Please enter a letter or the word you would like"
                    + " to guess: ");
            input.setInput();
            guesses.addGuess( input.getInput() );
            if ( !wordToGuess.checkGuess( input.getInput() ) )
            {
                noose.incrementIncorrectGuessCounter();
                noose.updateNoose();
            }
            if ( wordToGuess.getHiddenWordToGuess().contains( "_" ) 
                    && noose.isHung() )
                System.out.println( "You were hung!"
                        + "\nThe hidden word was: " 
                        + wordToGuess.getWordToGuess() 
                        + "\nBetter luck next time!" );
            else if ( !wordToGuess.getHiddenWordToGuess().contains( "_" ) )
            {
                /**
                 * clears screen in a command prompt window
                 * does not appear to work in the netbeans console though  
                 * this only works on windows 
                 * and should probably be put in a try catch 
                 * Source: 
                 * https://stackoverflow.com/questions/2979383/java-clear-the-console
                */
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                guesses.printGuess();;
                noose.printNoose();
                wordToGuess.printHiddenWordToGuess();
                System.out.println("Congratulations!  You Win!");
            }
            while ( noose.isHung() || 
                    !wordToGuess.getHiddenWordToGuess().contains( "_" ) )
            {
                System.out.print( "Start a new game? (Y) or (N): " );
                input.setInput();
                if ( input.getInput().compareToIgnoreCase( "y" ) == 0 )
                {
                    noose = new Noose();
                    wordToGuess = new WordToGuess();
                    guesses = new Guesses();
                }
                else if ( input.getInput().compareToIgnoreCase( "n" ) == 0 )
                    break;
                else
                {
                    /**
                     * clears screen in a command prompt window
                     * does not appear to work in the netbeans console though  
                     * this only works on windows 
                     * and should probably be put in a try catch 
                     * Source: 
                     * https://stackoverflow.com/questions/2979383/java-clear-the-console
                     */
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    System.out.println("I'm sorry, but we did not "
                            + "recoginize that input.  Please enter either "
                            + "Y for yes or N for no.");
                }
            }
        }
    }
    
}
