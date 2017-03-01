/*
 * Copyright 2017 Kieren Hinch
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
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
        this.message = this.message + message + "\n";
    }
    
    public Boolean isValid() {
        return valid;
    }
    
    public String getmessage() {
        return message;
    }
    
}
