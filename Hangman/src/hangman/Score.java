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
public class Score 
{
    int score;
    
    /**
     * Default Constructor
     * Initializes score to 0.
     */
    public Score()
    {
        score = 0;
    }
    
    /**
     * Increments score by 1.
     */
    private void incrementScore()
    {
        score++;
    }
    
    /**
     * Decrements score be 1.
     */
    private void decrementScore()
    {
        score--;
    }
    
    /**
     * Increments or decrements score by 1 based on positive or negative value
     * given.
     * @param num Integer
     */
    public void updateScore(int num)
    {
        if ( num < 0 )
            decrementScore();
        else if ( num > 0)
            incrementScore();
    }
    
    /**
     * Returns the current score.
     * @return Integer
     */
    public int getScore()
    {
        return score;
    }
    
    /**
     * Prints out the score as a string.
     */
    public void printScore()
    {
        System.out.println("Score: " + score);
    }
}
