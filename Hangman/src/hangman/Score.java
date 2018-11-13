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
    int points;
    
    /**
     * Default Constructor
     * Initializes score to 0.
     */
    public Score()
    {
        score = 0;
        points = 0;
    }
    
    /**
     * Constructor accepting an integer value to represent the maximum points 
     * that can be earned for the word in question.
     * @param p Integer
     */
    public Score(int p)
    {
        score = 0;
        points = p;
    }
    
    /**
     * Increments score by 1 and decrements available points.
     */
    public void incrementScore()
    {
        score++;
        points--;
    }
    
    /**
     * Decrements score by 1.  If score is 0 or less then sets score to 0.
     */
    public void decrementScore()
    {
        if( score <= 0 )
            score = 0;
        else
            score--;
    }
    
    /**
     * Increments or decrements score by 1 based on positive or negative value
     * given.
     * @param num Integer
     */
    public void updateScore(int num)
    {
        score += num;
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
    
    /**
     * Adds the remaining possible points to the score.
     */
    public void winScore()
    {
        score += points;
    }
    
    /**
     * Subtracts the remaining points from the score.  If score would be less
     * than 0 then sets score to 0.
     */
    public void loseScore()
    {
        if ( score <= 0 || score - points <= 0 )
            score = 0;
        else
            score -= points;
    }
}
