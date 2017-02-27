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
        labelOutputDirectory = new javax.swing.JLabel();
        labelDoxyfile = new javax.swing.JLabel();
        textFieldOutputDirectory = new javax.swing.JTextField();
        textFieldDoxyfile = new javax.swing.JTextField();
        labelSourceDirectory = new javax.swing.JLabel();
        textFieldSourceDirectory = new javax.swing.JTextField();
        checkboxRecursiveSource = new javax.swing.JCheckBox();
        textFieldLogo = new javax.swing.JTextField();
        labelLogo = new javax.swing.JLabel();
        checkboxHtml = new javax.swing.JCheckBox();
        checkboxLatex = new javax.swing.JCheckBox();
        checkboxManPage = new javax.swing.JCheckBox();
        checkboxRtf = new javax.swing.JCheckBox();
        checkboxXml = new javax.swing.JCheckBox();
        labelMandatoryFieldIndicator = new javax.swing.JLabel();
        labelnstructions1 = new javax.swing.JLabel();
        labelnstructions2 = new javax.swing.JLabel();
        labelnstructions3 = new javax.swing.JLabel();
        labelnstructions4 = new javax.swing.JLabel();
        labelnstructions5 = new javax.swing.JLabel();

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

        org.openide.awt.Mnemonics.setLocalizedText(labelOutputDirectory, org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.labelOutputDirectory.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(labelDoxyfile, org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.labelDoxyfile.text")); // NOI18N

        textFieldOutputDirectory.setText(org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.textFieldOutputDirectory.text")); // NOI18N

        textFieldDoxyfile.setText(org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.textFieldDoxyfile.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(labelSourceDirectory, org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.labelSourceDirectory.text")); // NOI18N

        textFieldSourceDirectory.setText(org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.textFieldSourceDirectory.text")); // NOI18N

        checkboxRecursiveSource.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(checkboxRecursiveSource, org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.checkboxRecursiveSource.text")); // NOI18N

        textFieldLogo.setText(org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.textFieldLogo.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(labelLogo, org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.labelLogo.text")); // NOI18N

        checkboxHtml.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(checkboxHtml, org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.checkboxHtml.text")); // NOI18N

        checkboxLatex.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(checkboxLatex, org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.checkboxLatex.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(checkboxManPage, org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.checkboxManPage.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(checkboxRtf, org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.checkboxRtf.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(checkboxXml, org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.checkboxXml.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDoxygenBinary)
                            .addComponent(labelOutputDirectory)
                            .addComponent(labelDoxyfile)
                            .addComponent(labelSourceDirectory)
                            .addComponent(labelLogo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldDoxyfile, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textFieldDoxygenBinary, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonDoxygenBinaryBrowser))
                            .addComponent(textFieldOutputDirectory, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textFieldSourceDirectory, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkboxRecursiveSource))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(checkboxHtml)
                        .addGap(18, 18, 18)
                        .addComponent(checkboxLatex)
                        .addGap(18, 18, 18)
                        .addComponent(checkboxManPage)
                        .addGap(18, 18, 18)
                        .addComponent(checkboxRtf)
                        .addGap(18, 18, 18)
                        .addComponent(checkboxXml)))
                .addContainerGap(130, Short.MAX_VALUE))
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
                    .addComponent(labelOutputDirectory)
                    .addComponent(textFieldOutputDirectory, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDoxyfile)
                    .addComponent(textFieldDoxyfile, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldSourceDirectory, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSourceDirectory)
                    .addComponent(checkboxRecursiveSource))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLogo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkboxHtml)
                    .addComponent(checkboxLatex)
                    .addComponent(checkboxManPage)
                    .addComponent(checkboxRtf)
                    .addComponent(checkboxXml))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.openide.awt.Mnemonics.setLocalizedText(labelMandatoryFieldIndicator, org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.labelMandatoryFieldIndicator.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(labelnstructions1, org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.labelnstructions1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(labelnstructions2, org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.labelnstructions2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(labelnstructions3, org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.labelnstructions3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(labelnstructions4, org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.labelnstructions4.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(labelnstructions5, org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.labelnstructions5.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMandatoryFieldIndicator)
                    .addComponent(labelnstructions1)
                    .addComponent(labelnstructions2)
                    .addComponent(labelnstructions3)
                    .addComponent(labelnstructions4)
                    .addComponent(labelnstructions5))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelMandatoryFieldIndicator)
                .addGap(18, 18, 18)
                .addComponent(labelnstructions1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelnstructions2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelnstructions3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelnstructions4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelnstructions5)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(DoxygenSettingsPanel.class, "DoxygenSettingsPanel.Settings.AccessibleContext.accessibleName")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * \todo 
     * \li set chooser starting dir to the last used dir, or the path in the text box 
     * 
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

    void load() {
        textFieldDoxygenBinary.setText(NbPreferences.forModule(DoxygenSettingsPanel.class).get("textFieldDoxygenBinary", ""));
        textFieldOutputDirectory.setText(NbPreferences.forModule(DoxygenSettingsPanel.class).get("textFieldOutputDirectory", ""));
        textFieldDoxyfile.setText(NbPreferences.forModule(DoxygenSettingsPanel.class).get("textFieldDoxyfile", ""));
        textFieldSourceDirectory.setText(NbPreferences.forModule(DoxygenSettingsPanel.class).get("textFieldSourceDirectory", ""));
        textFieldLogo.setText(NbPreferences.forModule(DoxygenSettingsPanel.class).get("textFieldLogo", ""));
        checkboxRecursiveSource.setSelected(NbPreferences.forModule(DoxygenSettingsPanel.class).getBoolean("checkboxRecursiveSource", true));
        checkboxHtml.setSelected(NbPreferences.forModule(DoxygenSettingsPanel.class).getBoolean("checkboxHtml", true));
        checkboxLatex.setSelected(NbPreferences.forModule(DoxygenSettingsPanel.class).getBoolean("checkboxLatex", true));
        checkboxManPage.setSelected(NbPreferences.forModule(DoxygenSettingsPanel.class).getBoolean("checkboxManPage", false));
        checkboxRtf.setSelected(NbPreferences.forModule(DoxygenSettingsPanel.class).getBoolean("checkboxRtf", false));
        checkboxXml.setSelected(NbPreferences.forModule(DoxygenSettingsPanel.class).getBoolean("checkboxXml", false));
    }

    void store() {
        NbPreferences.forModule(DoxygenSettingsPanel.class).put("textFieldDoxygenBinary", textFieldDoxygenBinary.getText());
        NbPreferences.forModule(DoxygenSettingsPanel.class).put("textFieldDoxyfile", textFieldDoxyfile.getText());
        NbPreferences.forModule(DoxygenSettingsPanel.class).put("textFieldOutputDirectory", textFieldOutputDirectory.getText());
        NbPreferences.forModule(DoxygenSettingsPanel.class).put("textFieldSourceDirectory", textFieldSourceDirectory.getText());
        NbPreferences.forModule(DoxygenSettingsPanel.class).put("textFieldLogo", textFieldLogo.getText());
        NbPreferences.forModule(DoxygenSettingsPanel.class).putBoolean("checkboxRecursiveSource", checkboxRecursiveSource.isSelected());
        NbPreferences.forModule(DoxygenSettingsPanel.class).putBoolean("checkboxHtml", checkboxHtml.isSelected());
        NbPreferences.forModule(DoxygenSettingsPanel.class).putBoolean("checkboxLatex", checkboxLatex.isSelected());
        NbPreferences.forModule(DoxygenSettingsPanel.class).putBoolean("checkboxManPage", checkboxManPage.isSelected());
        NbPreferences.forModule(DoxygenSettingsPanel.class).putBoolean("checkboxRtf", checkboxRtf.isSelected());
        NbPreferences.forModule(DoxygenSettingsPanel.class).putBoolean("checkboxXml", checkboxXml.isSelected());
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
    private javax.swing.JButton buttonDoxygenBinaryBrowser;
    private javax.swing.JCheckBox checkboxHtml;
    private javax.swing.JCheckBox checkboxLatex;
    private javax.swing.JCheckBox checkboxManPage;
    private javax.swing.JCheckBox checkboxRecursiveSource;
    private javax.swing.JCheckBox checkboxRtf;
    private javax.swing.JCheckBox checkboxXml;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelDoxyfile;
    private javax.swing.JLabel labelDoxygenBinary;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelMandatoryFieldIndicator;
    private javax.swing.JLabel labelOutputDirectory;
    private javax.swing.JLabel labelSourceDirectory;
    private javax.swing.JLabel labelnstructions1;
    private javax.swing.JLabel labelnstructions2;
    private javax.swing.JLabel labelnstructions3;
    private javax.swing.JLabel labelnstructions4;
    private javax.swing.JLabel labelnstructions5;
    private javax.swing.JTextField textFieldDoxyfile;
    private javax.swing.JTextField textFieldDoxygenBinary;
    private javax.swing.JTextField textFieldLogo;
    private javax.swing.JTextField textFieldOutputDirectory;
    private javax.swing.JTextField textFieldSourceDirectory;
    // End of variables declaration//GEN-END:variables
}
