/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khinch.netbeansdoxygenplugin;

/**
 * \todo Write doc for Validator class
 * @author kieren
 */
public class Validator {
    
    private Boolean valid;
    private String message;
    
    public Validator(Boolean valid, String message) {
        this.valid = valid;
        this.message = message;
    }
    
    public void setValid(Boolean valid) {
        this.valid = valid; 
    }
    
    public void appendMessage(String message) {
        this.message = this.message + "\n" + message;
    }
    
    public Boolean isValid() {
        return valid;
    }
    
    public String getmessage() {
        return message;
    }
    
}
