/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khinch.netbeansdoxygenplugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.netbeans.api.project.Project;
import org.openide.*;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.filesystems.FileObject;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.util.Utilities;

/**
 *
 * @author kieren
 */
@ActionID(category = "Project", id = "org.khinch.netbeansdoxygenplugin.ContextActionBuildDocs")
@ActionRegistration(displayName = "Run Doxygen")
@ActionReferences({
    @ActionReference(path = "Menu/File"),
    @ActionReference(path = "Projects/Actions")
})
public class ContextActionBuildDocs implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        // Get current project directory
        Lookup lookup = Utilities.actionsGlobalContext();
        Project project = lookup.lookup(Project.class); // We can assume this is never null, since we got here through the project menu
        FileObject projectDir = project.getProjectDirectory();
        String projectLocation = projectDir.getPath();
        
        ClassWithoutAName classWithoutAName = new ClassWithoutAName(projectLocation);
        
        // Validate inputs
        Validator inputsValid = classWithoutAName.validateSettings();
        if(!inputsValid.isValid()) {
            JOptionPane.showMessageDialog(null, inputsValid.getmessage() + " Please check the settings panel.");
        }
        
        // Go!
        classWithoutAName.generateDocs();
        
//        try {
//            CommandUtils.runCommand(projectLocation);
//        } catch (IOException ex) {
//            Exceptions.printStackTrace(ex);
//        }
//        JOptionPane.showMessageDialog(null, projectLocation);
        
    }
}