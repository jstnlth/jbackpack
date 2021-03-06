/**
 * MacOSXSetupHelpFrame.java
 *
 * Copyright (C) 2010 imedias
 *
 * This file is part of JBackpack.
 *
 * JBackpack is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 3 of the License, or (at your option) any
 * later version.
 *
 * JBackpack is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * Created on 27.07.2010, 17:53:35
 */
package ch.fhnw.jbackpack;

import java.awt.Cursor;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.event.HyperlinkEvent;

/**
 * A frame showing rdiff-backup installation help for Mac OS X
 *
 * @author Ronny Standtke <ronny.standtke@fhnw.ch>
 */
public class MacOSXSetupHelpFrame extends javax.swing.JFrame {

    private static final Logger LOGGER =
            Logger.getLogger(MacOSXSetupHelpFrame.class.getName());

    /**
     * Creates new form MacOSXSetupHelpFrame
     */
    public MacOSXSetupHelpFrame() {
        initComponents();
        errorLabel.setIcon(IconManager.ERROR_ICON);

        ResourceBundle bundle =
                ResourceBundle.getBundle("ch/fhnw/jbackpack/Strings");

        Class thisClass = getClass();

        // load installation help from file
        String installationFileName =
                bundle.getString("Mac_OS_X_Installation_File");
        URL fileURL = thisClass.getResource(installationFileName);
        try {
            editorPane.setPage(fileURL);
        } catch (IOException ex) {
            LOGGER.log(Level.WARNING,
                    "could not load Mac OS X Installation file", ex);
        }

        pack();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        errorLabel = new javax.swing.JLabel();
        editorPane = new javax.swing.JEditorPane();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ch/fhnw/jbackpack/Strings"); // NOI18N
        setTitle(bundle.getString("MacOSXSetupHelpFrame.title")); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        errorLabel.setText(bundle.getString("MacOSXSetupHelpFrame.errorLabel.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        getContentPane().add(errorLabel, gridBagConstraints);

        editorPane.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        editorPane.setBorder(null);
        editorPane.setContentType(bundle.getString("MacOSXSetupHelpFrame.editorPane.contentType")); // NOI18N
        editorPane.setEditable(false);
        editorPane.addHyperlinkListener(new javax.swing.event.HyperlinkListener() {
            public void hyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {
                editorPaneHyperlinkUpdate(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        getContentPane().add(editorPane, gridBagConstraints);

        okButton.setText(bundle.getString("MacOSXSetupHelpFrame.okButton.text")); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 0);
        getContentPane().add(okButton, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void editorPaneHyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {//GEN-FIRST:event_editorPaneHyperlinkUpdate
        if (evt.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {

            try {
                Desktop.getDesktop().browse(evt.getURL().toURI());
            } catch (URISyntaxException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }

            // disable and change cursor for a short time so that the user
            // has a visible feedback until the browser is open
            final JEditorPane source = (JEditorPane) evt.getSource();
            Thread guiThread = new Thread() {

                @Override
                public void run() {
                    source.setEnabled(false);
                    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                    try {
                        // just a wild guess
                        Thread.sleep(4000);
                    } catch (InterruptedException ex) {
                        LOGGER.log(Level.SEVERE, null, ex);
                    }
                    source.setEnabled(true);
                    setCursor(Cursor.getPredefinedCursor(
                            Cursor.DEFAULT_CURSOR));
                }
            };
            guiThread.start();
        }

    }//GEN-LAST:event_editorPaneHyperlinkUpdate

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_okButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane editorPane;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
}
