/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solid.spintax.exceptions;

/**
 * <i>InvalidBracesSpintaxException</i>
 * <p>
 * @author Solid Security
 * @author Jacob Fuehne
 * @since 2.2.0
 */
public class InvalidBracesSpintaxException  extends Exception{
    private String errorMessage = "";
    public InvalidBracesSpintaxException(){
        errorMessage = "\nERROR: Spintax has unbalanced open braces.\n";
    }
    
    public String toString(){
        return errorMessage; 
    }
}