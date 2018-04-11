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
public class Noose 
{
    private String noose[][];
    private boolean hung;
    private int incorrectGuessCounter;
    
    /**
     * Default class constructor
     */
    public Noose()
    {
        noose = new String[][] 
        { 
            {"-","-","-","-","|"," ","\n"} ,
            {"|"," "," "," "," "," ","\n"} ,
            {"|"," "," "," "," "," ","\n"} ,
            {"|"," "," "," "," "," ","\n"} ,
            {"|"," "," "," "," "," ","\n"} ,
            {"="," "," ","","","",""} ,
            //Makes the array length long enough to print out the new line character
            {"","","","","","",""}
        };
        hung = false;
        incorrectGuessCounter = 0;
    }
    
    /**
     * Adds the head to the noose.
     */
    private void addHead()
    {
        noose[1][4] = "O";
    }
    
    /**
     * Adds the neck to the noose.
     */
    private void addNeck()
    {
        noose[2][4] = "|";
    }
    
    /**
     * Adds the left arm to the noose.
     */
    private void addLeftArm()
    {
        noose[2][3] = "\\";
    }
    
    /**
     * Adds the right arm to the noose.
     */
    private void addRightArm()
    {
        noose[2][5] = "/";
    }
    
    /**
     * Adds the torso/body to the noose.
     */
    private void addTorso()
    {
        noose[3][4] = "|";
    }
    
    /**
     * Adds the left leg to the noose.
     */
    private void addLeftLeg()
    {
        noose[4][3] = "/";
    }
    
    /**
     * Adds the right leg to the noose.
     */
    private void addRightLeg()
    {
        noose[4][5] = "\\";
    }
    
    /**
     * Checks if the player is hung.
     * @return boolean
     */
    public boolean isHung()
    {
        return hung;
    }
    
    /**
     * Increments the counter used to decide which body part to add to the 
     * noose.
     */
    public void incrementIncorrectGuessCounter()
    {
        incorrectGuessCounter++;
    }
    
    /**
     * Resets the counter to 0 for when a new game is started/new noose is to 
     * be displayed.
     */
    public void clearIncorrectGuessCounter()
    {
        incorrectGuessCounter = 0;
    }
    
    /**
     * Logic to decide which body part to add to the noose based on the number 
     * of incorrect guesses.  If all body parts are displayed then player is 
     * hung.
     */
    public void updateNoose()
    {
        switch (incorrectGuessCounter) 
        {
            case 1:
                addHead();
                break;
            case 2:
                addLeftArm();
                break;
            case 3:
                addRightArm();
                break;
            case 4:
                addTorso();
                break;
            case 5:
                addLeftLeg();
                break;
            case 6:
                addRightLeg();
                setHung( true );
                break;
            default:
                break;
        }
    }
    
    /**
     * Sets the boolean status to true or false for if the player is hung.
     * @param h boolean
     */
    private void setHung( boolean h )
    {
        hung = h;
    }
    
    /**
     * Outputs the noose in it's latest state.
     */
    public void printNoose()
    {
        for ( int i = 0; i < noose.length; i++ )
            for ( int j = 0; j < noose.length; j++ )
                System.out.print( noose[ i ][ j ] );
    }
}
