/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.khinch.netbeansdoxygenplugin;

import javax.swing.JFileChooser;
import org.openide.util.NbPreferences;

/**
 * 
 * \todo
 * \li Use document listeners to replace repaint() calls 
 */

final class DoxygenSettingsPanel extends javax.swing.JPanel {

    private final DoxygenSettingsOptionsPanelController controller;

    DoxygenSettingsPanel(DoxygenSettingsOptionsPanelController controller) {
        this.controller = controller;
        initComponents();
        // TODO listen to changes in form fields and call controller.changed()
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelDoxygenBinary = new javax.swing.JLabel();
        textFieldDoxygenBinary = new javax.swing.JTextField();
        buttonDoxygenBinaryBrowser = new javax.swing.JButton();
        labelDoxyfile = new javax.swing.JLabel();
        labelOutputDirectory = new javax.swing.JLabel();
        textFieldDoxyfile = new javax.swing.JTextField();
        textFieldOutputDirectory = new javax.swing.JTextField();
        buttonDoxyfileBrowser = new javax.swing.JButton();
        buttonOutputDirectoryBrowser = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.jPanel1.border.title"))); // NOI18N
        jPanel1.setName("Settings"); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(labelDoxygenBinary, org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.labelDoxygenBinary.text")); // NOI18N

        textFieldDoxygenBinary.setText(org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.textFieldDoxygenBinary.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(buttonDoxygenBinaryBrowser, org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.buttonDoxygenBinaryBrowser.text")); // NOI18N
        buttonDoxygenBinaryBrowser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDoxygenBinaryBrowserActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(labelDoxyfile, org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.labelDoxyfile.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(labelOutputDirectory, org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.labelOutputDirectory.text")); // NOI18N

        textFieldDoxyfile.setText(org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.textFieldDoxyfile.text")); // NOI18N

        textFieldOutputDirectory.setText(org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.textFieldOutputDirectory.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(buttonDoxyfileBrowser, org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.buttonDoxyfileBrowser.text")); // NOI18N
        buttonDoxyfileBrowser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDoxyfileBrowserActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(buttonOutputDirectoryBrowser, org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.buttonOutputDirectoryBrowser.text")); // NOI18N
        buttonOutputDirectoryBrowser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOutputDirectoryBrowserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDoxygenBinary)
                    .addComponent(labelDoxyfile)
                    .addComponent(labelOutputDirectory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(textFieldOutputDirectory, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonOutputDirectoryBrowser))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(textFieldDoxygenBinary, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDoxygenBinaryBrowser))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(textFieldDoxyfile, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDoxyfileBrowser)))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDoxygenBinary)
                    .addComponent(textFieldDoxygenBinary, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDoxygenBinaryBrowser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDoxyfile)
                    .addComponent(textFieldDoxyfile, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDoxyfileBrowser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelOutputDirectory)
                    .addComponent(textFieldOutputDirectory, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonOutputDirectoryBrowser))
                .addContainerGap(160, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.Settings.AccessibleContext.accessibleName")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * \todo 
     * \li set chooser starting dir to the last used dir, or the path in the text box 
     * 
     *
     * @param evt
     */
    private void buttonDoxygenBinaryBrowserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDoxygenBinaryBrowserActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Doxygen binary");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        // Show the file selection dialogue and only fill-down to the text field if the file exists
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            if (chooser.getSelectedFile().exists()) {
                textFieldDoxygenBinary.setText(chooser.getSelectedFile().getAbsolutePath());
                textFieldDoxygenBinary.repaint(); // until I wrap my head around DocumentListeners, this will do
            }
        }
    }//GEN-LAST:event_buttonDoxygenBinaryBrowserActionPerformed

    /**
     *
     * \todo \li set chooser starting dir to the current project's dir + "documentation" if it exists, and just the project dir otherwise
     *
     * @param evt
     */
    private void buttonDoxyfileBrowserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDoxyfileBrowserActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Doxyfile");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        // Show the file selection dialogue and only fill-down to the text field if the file exists
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            if (chooser.getSelectedFile().exists()) {
                textFieldDoxyfile.setText(chooser.getSelectedFile().getAbsolutePath());
                textFieldDoxyfile.repaint(); // until I wrap my head around DocumentListeners, this will do
            }
        }
    }//GEN-LAST:event_buttonDoxyfileBrowserActionPerformed

    /**
     *
     * \todo \li set chooser starting dir to the current project's dir + "documentation" if it exists, and just the project dir otherwise
     *
     * @param evt
     */
    private void buttonOutputDirectoryBrowserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOutputDirectoryBrowserActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Output directory");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // We only want directories for the option

        // Show the file selection dialogue and only fill-down to the text field if the selection is a directory
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            if (chooser.getSelectedFile().isDirectory()) {
                textFieldOutputDirectory.setText(chooser.getSelectedFile().getAbsolutePath());
                textFieldOutputDirectory.repaint(); // until I wrap my head around DocumentListeners, this will do
            }

        }
    }//GEN-LAST:event_buttonOutputDirectoryBrowserActionPerformed

    void load() {
        textFieldDoxygenBinary.setText(NbPreferences.forModule(DoxygenSettingsPanel.class).get("textFieldDoxygenBinary", ""));
        textFieldDoxyfile.setText(NbPreferences.forModule(DoxygenSettingsPanel.class).get("textFieldDoxyfile", ""));
        textFieldOutputDirectory.setText(NbPreferences.forModule(DoxygenSettingsPanel.class).get("textFieldOutputDirectory", ""));
    }

    void store() {
        NbPreferences.forModule(DoxygenSettingsPanel.class).put("textFieldDoxygenBinary", textFieldDoxygenBinary.getText());
        NbPreferences.forModule(DoxygenSettingsPanel.class).put("textFieldDoxyfile", textFieldDoxyfile.getText());
        NbPreferences.forModule(DoxygenSettingsPanel.class).put("textFieldOutputDirectory", textFieldOutputDirectory.getText());
    }

    /**
     * This was auto-generated but doesn't seem to get implicitly called at any point. 
     * 
     * \todo Populate the method and call it from ... somewhere
     * 
     * @return 
     */
    boolean valid() {
        // TODO check whether form is consistent and complete
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDoxyfileBrowser;
    private javax.swing.JButton buttonDoxygenBinaryBrowser;
    private javax.swing.JButton buttonOutputDirectoryBrowser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelDoxyfile;
    private javax.swing.JLabel labelDoxygenBinary;
    private javax.swing.JLabel labelOutputDirectory;
    private javax.swing.JTextField textFieldDoxyfile;
    private javax.swing.JTextField textFieldDoxygenBinary;
    private javax.swing.JTextField textFieldOutputDirectory;
    // End of variables declaration//GEN-END:variables
}
