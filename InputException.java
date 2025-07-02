/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management;

/**
 *
 * @author ahmed
 */
public class InputException extends Exception {
    String message="";
    public InputException() {
    }

    public InputException(String message) {
        this.message = message;
    }
    
    @Override
    public String toString(){
        if (!message.equals("")){
            return message + " is invalid or empty !";
        } else {
            return "There's incorrect input or empty field !";
        }
    }
}
