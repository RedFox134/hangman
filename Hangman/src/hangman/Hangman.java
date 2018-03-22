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
        boolean hung = false;
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
        boolean incorrectGuess = false;
        int incorrectGuessCounter = 0;
        while( hiddenWord.contains("_") && startGame && !hung )
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
            if ( letter )
                for ( int i = 0; i < wordToGuess.length(); i++ )
                {
                    if ( wordToGuess.charAt( i ) == input.charAt( 0 ) )
                    {
                        //if it does match replace _ with the letter
                        hiddenWord = hiddenWord.substring(0, i) + input 
                                + hiddenWord.substring(i+1, hiddenWord.length());
                        incorrectGuess = false;
                        letter = false;
                        break;
                    }
                    //if it doesn't add body part
                    else
                    {
                        incorrectGuess = true;
                        letter = false;
                    }
                }
            else if ( word )
                //if word matches
                if ( wordToGuess.compareToIgnoreCase( input ) == 0 )
                {
                    //if it does they win
                    hiddenWord = input;
                    incorrectGuess = false;
                    word = false;
                    break;
                } 
                //if it doesn't add a body part
                else
                {
                    incorrectGuess = true;
                    word = false;
                }
            //if it doesn't add body part to noose
            if ( incorrectGuess )
            {
                incorrectGuessCounter++;
                if ( incorrectGuessCounter == 1 )
                    noose[1][4] = "O";
                else if ( incorrectGuessCounter == 2 )
                    noose[2][4] = "|";
                else if ( incorrectGuessCounter == 3 )
                    noose[2][3] = "\\";
                else if ( incorrectGuessCounter == 4 )
                    noose[2][5] = "/";
                else if ( incorrectGuessCounter == 5 )
                    noose[3][4] = "|";
                else if (incorrectGuessCounter == 6 )
                    noose[4][3] = "/";
                else if (incorrectGuessCounter == 7 )
                {
                    noose[4][5] = "\\";
                    hung = true;
                }
            }
            //each time noose is updated clear screen and draw new noose
            //clears screen in a command prompt window
            //does not appear to work in the netbeans console though >:(
            //this only works on windows and should probably be put in a try catch
            //Source: https://stackoverflow.com/questions/2979383/java-clear-the-console
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            for( int i = 0; i < noose.length; i++ )
                for( int j = 0; j < noose.length; j++ )
                    System.out.print(noose[i][j]);
            System.out.println( hiddenWord );
            //if hung display word and game over
            if ( hiddenWord.contains( "_" ) && hung )
            {
                System.out.println( "You were hung!" );
                System.out.println( "The hiddenWord was: " + wordToGuess );
                System.out.println( "Better luck next time!" );
            }
            else if ( !hiddenWord.contains( "_" ) )
                System.out.println("Congratulations!  You Win!");
            //check to restart game or not
            if ( hung || !hiddenWord.contains( "_" ));
            {
                while ( hung )
                {
                    System.out.print( "Start a new game? (Y) or (N): " );
                    input = scanner.next();
                    //if not prompt for new input
                    if ( input.compareToIgnoreCase( "y" ) == 0 )
                    {
                        hung = false;
                        startGame = true;
                        noose = new String[][] { 
                            {"-","-","-","-","|"," ","\n"} ,
                            {"|"," "," "," "," "," ","\n"} ,
                            {"|"," "," "," "," "," ","\n"} ,
                            {"|"," "," "," "," "," ","\n"} ,
                            {"|"," "," "," "," "," ","\n"} ,
                            {"="," "," ","","","",""} ,
                            {"","","","","","",""}//Makes the array length long enough to print out the new line character
                        };
                    }
                    else if ( input.compareToIgnoreCase( "n" ) == 0 )
                    {
                        hung = false;
                        startGame = false;
                    }
                    else
                        System.out.println("I'm sorry, but we did not "
                                + "recoginize that input.  Please enter either "
                                + "Y for yes or N for no.");
                }
            }
        }
        //clears screen in a command prompt window
        //does not appear to work in the netbeans console though >:(
        //this only works on windows and should probably be put in a try catch
        //Source: https://stackoverflow.com/questions/2979383/java-clear-the-console
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
    
}
