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

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import org.openide.util.Exceptions;
import org.openide.util.NbPreferences;

/**
 * \todo \li name this class \li write this doc
 *
 * @author kieren
 */
public class ClassWithoutAName {

    private static final String FILESEPARATOR = Constants.FILESEPARATOR;
    private static final String LINESEPARATOR = Constants.LINESEPARATOR;

    private final String PROJECTDIRECTORY;
    private final String PROJECTNAME;
    private final String DOXYGENBINARY;
    private final String OUTPUTDIRECTORY;
    private final String DOXYFILE;
    private final String SOURCEDIRECTORY;
    private final String LOGO;

    private final Boolean SOURCEDIRECTORYRECURSIVE;
    private final Boolean OUTPUTHTML;
    private final Boolean OUTPUTLATEX;
    private final Boolean OUTPUTMAN;
    private final Boolean OUTPUTRTF;
    private final Boolean OUTPUTXML;

    private String outputDirectoryPath;
    private String doxyfilePath;
    private String sourceDirectoryPath;
    private String logoPath;
    private String doxyfileContent;

    /**
     * \todo Write doc for ClassWithoutAName constructor. Hopefully after it's been given a sensible name.
     *
     * @param projectDirectory
     * @param projectName
     */
    public ClassWithoutAName(String projectDirectory, String projectName) {
        this.PROJECTDIRECTORY = projectDirectory;
        this.PROJECTNAME = projectName;
        DOXYGENBINARY = NbPreferences.forModule(DoxygenSettingsPanel.class).get("textFieldDoxygenBinary", "");
        OUTPUTDIRECTORY = NbPreferences.forModule(DoxygenSettingsPanel.class).get("textFieldOutputDirectory", "");
        DOXYFILE = NbPreferences.forModule(DoxygenSettingsPanel.class).get("textFieldDoxyfile", "");
        SOURCEDIRECTORY = NbPreferences.forModule(DoxygenSettingsPanel.class).get("textFieldSourceDirectory", "");
        LOGO = NbPreferences.forModule(DoxygenSettingsPanel.class).get("textFieldLogo", "");
        SOURCEDIRECTORYRECURSIVE = NbPreferences.forModule(DoxygenSettingsPanel.class).getBoolean("checkboxRecursiveSource", true);
        OUTPUTHTML = NbPreferences.forModule(DoxygenSettingsPanel.class).getBoolean("checkboxHtml", true);
        OUTPUTLATEX = NbPreferences.forModule(DoxygenSettingsPanel.class).getBoolean("checkboxLatex", true);
        OUTPUTMAN = NbPreferences.forModule(DoxygenSettingsPanel.class).getBoolean("checkboxManPage", false);
        OUTPUTRTF = NbPreferences.forModule(DoxygenSettingsPanel.class).getBoolean("checkboxRtf", false);
        OUTPUTXML = NbPreferences.forModule(DoxygenSettingsPanel.class).getBoolean("checkboxXml", false);
    }

    /**
     * \todo write doc for this method
     *
     * @return
     */
    public Validator validateMandatorySettings() {

        Validator validator = new Validator(true, "");
        File doxygenBinaryFile;

        // Ensure that Doxygen binary field is not null or empty, and that a file exists with the supplied path
        if (DOXYGENBINARY == null | DOXYGENBINARY.isEmpty()) {
            validator.setValid(false);
            validator.appendMessage("Path to Doxygen binary file is empty.");
        } else {
            doxygenBinaryFile = new File(DOXYGENBINARY);
            if (!doxygenBinaryFile.exists()) {
                validator.setValid(false);
                validator.appendMessage("Path to Doxygen binary file is invalid.");
            }
        }

        // Ensure that output directory field is not null or empty
        if (OUTPUTDIRECTORY == null | OUTPUTDIRECTORY.isEmpty()) {
            validator.setValid(false);
            validator.appendMessage("Path to output directory is empty.");
        }

        //! \todo check to make sure path is actually the doxygen binary. Call "doxygen --help" and parse the first line or two for something useful
        return validator; // If all is well this returns "true" with no message. Otherwise, it returns false with all issues found. 
    }

    /**
     * \todo write document for generateDocs method (Oh! The irony.)
     *
     * Discussion: input stream overrides vs Doxyfile overrides (spaces getting stripped from inputs by doxygen binary)
     *
     * Wiki: escape the override by adding a second parameter at the end of the file
     *
     */
    public void generateDocs() {

        buildPaths();
        File doxyfile = new File(doxyfilePath);
        if (!doxyfile.exists()) {
            try {
                generateDoxyfile();
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
        loadDoxyfile();

        // Load contents of Doxyfile. This should hopefully never exception if the validator has been successfully called.
        //! \todo Update this method to take account of other variable paths. E.g. CSS file, header, footer etc. 
        // Edit the doxyfile to apply the project specific overrides
        overrideSetting("OUTPUT_DIRECTORY", outputDirectoryPath);
        overrideSetting("INPUT", sourceDirectoryPath);
        if (SOURCEDIRECTORYRECURSIVE) {
            overrideSetting("RECURSIVE", "YES");
        }

        if (logoPath != null) {
            overrideSetting("PROJECT_LOGO", logoPath);
        }

        if (OUTPUTHTML) {
            overrideSetting("GENERATE_HTML", "YES");
        } else {
            overrideSetting("GENERATE_HTML", "NO");
        }

        if (OUTPUTLATEX) {
            overrideSetting("GENERATE_LATEX", "YES");
        } else {
            overrideSetting("GENERATE_LATEX", "NO");
        }

        if (OUTPUTMAN) {
            overrideSetting("GENERATE_MAN", "YES");
        } else {
            overrideSetting("GENERATE_MAN", "NO");
        }

        if (OUTPUTRTF) {
            overrideSetting("GENERATE_RTF", "YES");
        } else {
            overrideSetting("GENERATE_RTF", "NO");
        }

        if (OUTPUTXML) {
            overrideSetting("GENERATE_XML", "YES");
        } else {
            overrideSetting("GENERATE_XML", "NO");
        }
        // end overrides

        // Output debug info for anyone that's interested
        System.out.println("Project directory: " + PROJECTDIRECTORY);
        System.out.println("Doxygen binary: " + DOXYGENBINARY);
        System.out.println("Doxyfile: " + doxyfilePath);
        System.out.println("Output directory: " + outputDirectoryPath);
        System.out.println("Source directory: " + sourceDirectoryPath);

        try {
            /*
            This command should end up being the same as:
            'cat Doxyfile | doxygen -'
            See here for more info: http://www.stack.nl/~dimitri/doxygen/manual/faq.html#faq_cmdline
            */
            runDoxygen();
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    private void buildPaths() {

        outputDirectoryPath = PROJECTDIRECTORY + FILESEPARATOR + OUTPUTDIRECTORY; // We know this should be valid, as the validator should have been called
        doxyfilePath = buildRelativePath(DOXYFILE, "Doxyfile");           // If either of these two are empty, they are set to a default value
        sourceDirectoryPath = buildRelativePath(SOURCEDIRECTORY, "src");  // <----

        if (LOGO != null && !LOGO.isEmpty()) // If this one is null or empty do nothing, as there is no logo to provide
        {
            logoPath = PROJECTDIRECTORY + FILESEPARATOR + LOGO;
        }

        //! \todo normalise these paths to remove redundant information if possible
    }

    /**
     * If the supplied file path suffix is null, resort to the default suffix and build a path using the project directory as the prefix.
     *
     * @param suffix
     * @param defaultSuffix
     * @return
     */
    private String buildRelativePath(String suffix, String defaultSuffix) {
        String result;
        if (suffix != null && !suffix.isEmpty()) {
            result = PROJECTDIRECTORY + FILESEPARATOR + suffix;
        } else {
            result = PROJECTDIRECTORY + FILESEPARATOR + defaultSuffix;
        }
        return result;
    }

    private void loadDoxyfile() {
        try {
            doxyfileContent = new String(Files.readAllBytes(Paths.get(doxyfilePath)));
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    private void generateDoxyfile() throws IOException {
        // doxygen -g <config-file>
        CommandUtils.runCommand(DOXYGENBINARY, new String[]{"-g", doxyfilePath}, null);
    }

    private void overrideSetting(String key, String value) {
        doxyfileContent = doxyfileContent.replaceFirst("(?m)^" + key + "[ \t]*=.*$", key + " = " + value);
    }
    
    private void runDoxygen() throws IOException {
        CommandUtils.runCommand(DOXYGENBINARY, new String[]{"-"}, doxyfileContent);
    }
}
