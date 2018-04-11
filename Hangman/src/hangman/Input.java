/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.util.Scanner;

/**
 *
 * @author E064958
 */
public class Input 
{
    private final Scanner scanner;
    private String input;
    
    public Input()
    {
        scanner = new Scanner( System.in );
        input = "";
    }
    
    public void setInput()
    {
        input = scanner.nextLine();
    }
    public String getInput()
    {
        return input;
    }
}
