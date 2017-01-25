/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khinch.netbeansdoxygenplugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.openide.util.Exceptions;
import org.openide.util.NbPreferences;

/**
 * \todo \li name this class \li write this doc
 * @author kieren
 */
public class ClassWithoutAName {

    private final String PROJECTDIRECTORY;
    private final String DOXYGENBINARY;
    private final String DOXYFILE;
    private final String OUTPUTDIRECTORY;
    private static final String FILESEPARATOR = Constants.FILESEPARATOR;
    private static final String LINESEPARATOR = Constants.LINESEPARATOR;
    
    private String doxyfilePath;
    private String outputDirectoryPath;

    public ClassWithoutAName(String projectDirectory) {
        this.PROJECTDIRECTORY = projectDirectory;
        DOXYGENBINARY = NbPreferences.forModule(DoxygenSettingsPanel.class).get("textFieldDoxygenBinary", "");
        DOXYFILE = NbPreferences.forModule(DoxygenSettingsPanel.class).get("textFieldDoxyfile", "");
        OUTPUTDIRECTORY = NbPreferences.forModule(DoxygenSettingsPanel.class).get("textFieldOutputDirectory", "");
    }

    /**
     * \todo write doc
     * @return 
     */
    public Validator validateSettings() {
        
        // Check inputs are not null or empty
        if(DOXYGENBINARY == null | DOXYGENBINARY.isEmpty()) {
            return new Validator(false, "Path to Doxygen binary file is empty.");
        }
        if(DOXYFILE == null | DOXYFILE.isEmpty()) {
            return new Validator(false, "Path to Doxyfile is empty.");
        }
        if(OUTPUTDIRECTORY == null | OUTPUTDIRECTORY.isEmpty()) {
            return new Validator(false, "Path to output directory is empty.");
        }
        
        // Check all paths exist
        buildPaths();
        File doxygenBinaryFile = new File(DOXYGENBINARY);
        File doxyfileFile = new File(doxyfilePath);
        File outputDirectoryFile = new File(outputDirectoryPath);
        
        if(!doxygenBinaryFile.exists()) {
            return new Validator(false, "Path to Doxygen binary file is invald.");
        }
        if(!doxyfileFile.exists()) {
            return new Validator(false, "Path to Doxyfile file is invald.");
        }
        if(!outputDirectoryFile.exists()) {
            return new Validator(false, "Path to Doxyfile file is invald.");
        }
        
        //! \todo check to make sure path is actually the doxygen binary. Call "doxygen --help" and parse the first line or two for something useful
        
        return new Validator(true, null); // No message needed if all is well.
    }
    
    /**
     * \todo doc for generateDocs (Oh! The irony.)
     */
    public void generateDocs() {
        
        // Load contents of Doxyfile. This should hopefully never exception if the validator has been successfully called.
        String doxyfileContent = "";
        try {
            doxyfileContent = new String(Files.readAllBytes(Paths.get(doxyfilePath))); 
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex); // 
        }
        
        //! \todo Update this method to take account of other variable paths. E.g. CSS file, header, footer etc. 
        
        // Build the overrides for project specific files. Start with a newline to make sure first override gets picked up. All subsequent overrides 
        // should end with a newline too. 
        StringBuilder overrides = new StringBuilder();
        overrides.append(LINESEPARATOR); 
        
        // Override output directory
        overrides.append("OUTPUT_DIRECTORY=");
        overrides.append(outputDirectoryPath);
        overrides.append(LINESEPARATOR);
        
        // Potentially override other stuff like CSS files, HTML headers, HTML footers here
        
        // Output debug info for anyone that's interested
        System.out.println("Project directory: " + PROJECTDIRECTORY);
        System.out.println("Doxygen binary: " + DOXYGENBINARY);
        System.out.println("Doxyfile: " + DOXYFILE);
        System.out.println("Output directory: " + OUTPUTDIRECTORY);
        
        /*
        This command should end up being the same as:
        ( cat Doxyfile ; echo <param_overrides> ) | doxygen -
        See here for more info: http://www.stack.nl/~dimitri/doxygen/manual/faq.html#faq_cmdline
        */
        try {
            CommandUtils.runCommand(DOXYGENBINARY, "-", doxyfileContent + overrides.toString());
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
    
    private void buildPaths() {
        doxyfilePath = PROJECTDIRECTORY + FILESEPARATOR + DOXYFILE;
        outputDirectoryPath = PROJECTDIRECTORY + FILESEPARATOR + OUTPUTDIRECTORY;
        
        //! \todo normalise these paths to remove redundant information if possible
    }

}
