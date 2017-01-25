/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khinch.netbeansdoxygenplugin;

/**
 *
 * @author kieren
 */
public class Validator {
    
    private final Boolean VALID;
    private final String MESSAGE;
    
    public Validator(Boolean valid, String message) {
        VALID = valid;
        MESSAGE = message;
    }
    
    public Boolean isValid() {
        return VALID;
    }
    
    public String getmessage() {
        return MESSAGE;
    }
    
}
