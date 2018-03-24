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
public class WordToGuess 
{
    private String word;
    private String hiddenWord;
    
    /**
     * Default constructor.
     */
    public WordToGuess()
    {
        word = "test";//Need to build of list to pull a random word from.
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
}
