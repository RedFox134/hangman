/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.io.IOException;
import java.util.Scanner;

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
        String noose[][] = { 
            {"-","-","-","-","|"," ","\n"} ,
            {"|"," "," "," "," "," ","\n"} ,
            {"|"," "," "," "," "," ","\n"} ,
            {"|"," "," "," "," "," ","\n"} ,
            {"|"," "," "," "," "," ","\n"} ,
            {"="," "," ","","","",""} ,
            {"","","","","","",""}//Makes the array length long enough to print out the new line character
        };
        //Display Title
        System.out.println("Hang Man v0.0.1");
        //Display noose
        for( int i = 0; i < noose.length; i++ )
            for( int j = 0; j < noose.length; j++ )
                System.out.print(noose[i][j]);
        //pick random word
        String wordToGuess = "test";
        //Need to impletment the above to actually pull from a list of words, but for now can be a constant to get the game working
        //display blank spaces "_" for each letter
        String blankSpaces = "_";
        String hiddenWord = "";
        for ( int i = 0; i < wordToGuess.length(); i++ )
            hiddenWord += blankSpaces;
        System.out.println( hiddenWord );
        //Game Menu
        System.out.println( "Type (Y) to start a game or (N) to exit." );
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        boolean startGame = false;
        if ( input.equalsIgnoreCase("Y") )
            startGame = true;
        else if ( input.equalsIgnoreCase("N") )
            startGame = false;
        else
        {
            System.out.print("I'm sorry, but we did not understand your request"
                    + ".  Please try again.");
            //recursive call to start method again?
        }
        
        boolean letter = false;
        boolean word = false;
        while( hiddenWord.contains("_") && startGame )
        {
            //take user input, input can be single character or word
            System.out.println("Please enter a letter or the word you would "
                    + "like to guess: ");
            input = scanner.next();
            //check if letter or word
            if ( input.length() > 1 )
            {
                letter = false;
                word = true;
            }
            else if ( input.length() == 1)
            {
                letter = true;
                word = false;
            }
            //if letter check if it matches any
            boolean incorrectGuess = false;
            int incorrectGuessCounter = 0;
            if ( letter )
                for ( int i = 0; i < wordToGuess.length(); i++ )
                {
                    if ( wordToGuess.charAt( i ) == input.charAt( 0 ) )
                    {
                        //if it does match replace _ with the letter
                        hiddenWord = hiddenWord.substring(0, i) + input 
                                + hiddenWord.substring(i+1, hiddenWord.length());
                        incorrectGuess = false;
                    } else
                    {
                        incorrectGuess = true;
                        incorrectGuessCounter++;
                    }
                }
            else if ( word )
                if ( wordToGuess.compareToIgnoreCase( input ) == 0 )
                {
                    hiddenWord = input;
                    incorrectGuess = false;
                } else
                {
                    incorrectGuess = true;
                    incorrectGuessCounter++;
                }
            if ( incorrectGuess )
                if ( incorrectGuessCounter == 1 )
                    
                
            System.out.println( hiddenWord );
            //each time noose is updated clear screen and draw new noose
            //if it does replace "_" with letter
            //if it doesn't add body part to noose
            //if word check if word matches
            //if it does they win
            //if it doesn't add two body parts
            //check to see if player is hung
            //if hung display word and game over
            //if not prompt for new input
        }
        if ( hiddenWord.contains( "_" ) )
        {
            
        } else
            System.out.println("Congratulations!  You Win!");
        //clears screen in a command prompt window
        //does not appear to work in the netbeans console though >:(
        //this only works on windows and should probably be put in a try catch
        //Source: https://stackoverflow.com/questions/2979383/java-clear-the-console
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
    
}
