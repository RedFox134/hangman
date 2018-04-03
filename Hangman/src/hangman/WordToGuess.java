/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author E064958
 */
public class WordToGuess 
{
    private String word;
    private String hiddenWord;
    private String words[];
    private FileReader fr;
    private BufferedReader br;
    private String line;
    private int arraySize;
    
    /**
     * Default constructor.
     */
    public WordToGuess() throws IOException
    {
        setWordListSize();
        words = new String[ arraySize ];
        word = pickWord();
        hiddenWord = "";
        hideWord();
    }
    
    /**
     * Returns the word to be guessed with the yet to be guessed letters replaced
     * by "_", and the guessed correctly letters showing.
     * @return String
     */
    public String getHiddenWordToGuess()
    {
        return hiddenWord;
    }
    
    /**
     * Sets the hiddenWord to have an equal number of "_" as there are letters
     * in word.
     */
    private void hideWord()
    {
        for ( int i = 0; i < word.length(); i++ )
            hiddenWord += "_";
    }
    
    /**
     * Prints out the word to be guessed with the yet to be guessed letters 
     * replaced with "_", and the correctly guessed letters showing.
     */
    public void printHiddenWordToGuess()
    {
        System.out.println( hiddenWord );
    }
    
    /**
     * Checks to see if the players input matches the word to be guessed or a 
     * letter in the word to be guessed.
     * @param guess String
     * @return boolean
     */
    public boolean checkGuess( String guess )
    {
        if ( guess.length() > 1 )
            if ( word.compareToIgnoreCase( guess ) == 0 )
            {
                hiddenWord = guess;
                return true;
            }
            else
                return false;
        else if ( guess.length() == 1)
            for ( int i = 0; i < word.length(); i++ )
                if ( word.charAt( i ) == guess.charAt( 0 ) )
                {
                    //Add check if the letter has already been guessed once.
                    if ( hiddenWord.charAt( i ) == guess.charAt( 0 ) )
                        return false;
                    int j = i;
                    while ( j < word.length() )
                    {
                        //this should get it's own method eventually
                        if ( word.charAt( j ) == guess.charAt( 0 ) )
                            hiddenWord = hiddenWord.substring(0, j) + guess 
                                + hiddenWord.substring(j+1, 
                                        hiddenWord.length());
                        j++;
                    }
                    return true;
                }
        return false;
    }
    
    /**
     * Returns the word to be guessed with all letters showing.
     * @return String
     */
    public String getWordToGuess()
    {
        return word;
    }
    
    /**
     * Prints the word to be guessed with all letters showing.
     */
    public void printWordToGuess()
    {
        System.out.println( word );
    }
    
    /**
     * Reads words from a file into an array.
     * @return String
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private String pickWord()throws FileNotFoundException, IOException
    {
        setWordListSize();
        words = new String[ arraySize ];
        fr = new FileReader( Hangman.class.getResource( "test.txt" ).getFile() );
//"C:\\test.txt");
        br = new BufferedReader( fr );
        int count = 0;
        line = br.readLine();
        while ( line != null )
        {
            words[ count++ ] = line;
            line = br.readLine();
        }
        return words[ ( int )( Math.random() * arraySize ) ];
    }
    
    /**
     * Runs through the list of words and counts how many there are.  Sets the 
     * arraySize value equal to how many words were counted.
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private void setWordListSize() throws FileNotFoundException, IOException
    {
        fr = new FileReader( "C:\\test.txt");
        br = new BufferedReader( fr );
        int count = 0;
        line = br.readLine();
        while ( line != null )
        {
            count++;
            line = br.readLine();
        }
        arraySize = count;
    }
}
