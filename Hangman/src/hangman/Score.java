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
    
    public Score()
    {
        score = 0;
    }
    
    private void incrementScore()
    {
        score++;
    }
    
    private void decrementScore()
    {
        score--;
    }
    
    public void updateScore(int num)
    {
        if ( num < 0 )
            score=- num;
        else
            score=+ num;
    }
    
    public int getScore()
    {
        return score;
    }
}
