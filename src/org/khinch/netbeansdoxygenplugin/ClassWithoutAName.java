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
    private static final String SOURCEPATH = FILESEPARATOR + "src";
    
    private String doxyfilePath;
    private String outputDirectoryPath;
    private String sourceDirectoryPath;

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
     * 
     * Discussion: input stream overrides vs Doxyfile overrides (spaces getting stripped from inputs by doxygen binary)
     * 
     * Wiki: escape the override by adding a second parameter at the end of the file
     * 
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
        
        // Edit the doxyfile to apply the project specific overrides
        doxyfileContent = doxyfileContent.replaceFirst("^OUTPUT_DIRECTORY[ \t]*=.*$", "OUTPUT_DIRECTORY=" + outputDirectoryPath);
        doxyfileContent = doxyfileContent.replaceFirst("^INPUT[ \t]=.*$", "OUTPUT_DIRECTORY=" + sourceDirectoryPath);
        
        
        // end overrides
        
        // Potentially override other stuff like CSS files, HTML headers, HTML footers here. Maybe use a hashmap for these?
        
        // Output debug info for anyone that's interested
        System.out.println("Project directory: " + PROJECTDIRECTORY);
        System.out.println("Doxygen binary: " + DOXYGENBINARY);
        System.out.println("Doxyfile: " + doxyfilePath);
        System.out.println("Output directory: " + outputDirectoryPath);
        System.out.println("Source directory: " + sourceDirectoryPath);
        
        /*
        This command should end up being the same as:
        ( cat Doxyfile ) | doxygen -
        See here for more info: http://www.stack.nl/~dimitri/doxygen/manual/faq.html#faq_cmdline
        */
        try {
            CommandUtils.runCommand(DOXYGENBINARY, "-", doxyfileContent);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
    
    private void buildPaths() {
        doxyfilePath = PROJECTDIRECTORY + FILESEPARATOR + DOXYFILE;
        outputDirectoryPath = PROJECTDIRECTORY + FILESEPARATOR + OUTPUTDIRECTORY;
        sourceDirectoryPath = PROJECTDIRECTORY + FILESEPARATOR + SOURCEPATH;
        
        //! \todo normalise these paths to remove redundant information if possible
    }

}
