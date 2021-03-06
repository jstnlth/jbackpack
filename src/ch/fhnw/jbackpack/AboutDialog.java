/*
 * AboutDialog.java
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
 * A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Created on 28. Oktober 2006, 12:10
 */
package ch.fhnw.jbackpack;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Frame;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.event.HyperlinkEvent;

/**
 *
 * @author Ronny.Standtke@gmx.net
 */
public class AboutDialog extends javax.swing.JDialog {

    private final static Logger LOGGER =
            Logger.getLogger(AboutDialog.class.getName());

    /**
     * Creates new form AboutDialog
     *
     * @param parent the parent frame
     */
    public AboutDialog(Frame parent) {
        super(parent, true);

        initComponents();

        ResourceBundle bundle =
                ResourceBundle.getBundle("ch/fhnw/jbackpack/Strings");

        // update dialog title
        String versionString = bundle.getString("JBackpack_Version");
        String title = MessageFormat.format(
                bundle.getString("ProgramTitle"), versionString);
        versionLabel.setText(title);

        Class thisClass = getClass();

        // load about infos from file
        String aboutFileName = bundle.getString("About_Message_File");
        URL fileURL = thisClass.getResource(aboutFileName);
        try {
            creditsEditorPane.setPage(fileURL);
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE,
                    "could not load file with \"about\" info", ex);
        }

        // load license from file
        String licenseFileName = bundle.getString("License_File");
        fileURL = thisClass.getResource(licenseFileName);
        try {
            licenseEditorPane.setPage(fileURL);
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "could not load license file", ex);
        }

        setLocationRelativeTo(parent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        versionLabel = new javax.swing.JLabel();
        tabbedPane = new javax.swing.JTabbedPane();
        creditsScrollPane = new javax.swing.JScrollPane();
        creditsEditorPane = new javax.swing.JEditorPane();
        licenseScrollPane = new javax.swing.JScrollPane();
        licenseEditorPane = new javax.swing.JEditorPane();
        okButtonPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ch/fhnw/jbackpack/Strings"); // NOI18N
        setTitle(bundle.getString("AboutDialog.title")); // NOI18N

        versionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        versionLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ch/fhnw/jbackpack/icons/64x64/backpack.png"))); // NOI18N
        versionLabel.setText(bundle.getString("ProgramTitle")); // NOI18N

        creditsEditorPane.setContentType(bundle.getString("AboutDialog.creditsEditorPane.contentType")); // NOI18N
        creditsEditorPane.setEditable(false);
        creditsEditorPane.addHyperlinkListener(new javax.swing.event.HyperlinkListener() {
            public void hyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {
                creditsEditorPaneHyperlinkUpdate(evt);
            }
        });
        creditsScrollPane.setViewportView(creditsEditorPane);

        tabbedPane.addTab(bundle.getString("AboutDialog.creditsScrollPane.TabConstraints.tabTitle"), creditsScrollPane); // NOI18N

        licenseEditorPane.setContentType(bundle.getString("AboutDialog.licenseEditorPane.contentType")); // NOI18N
        licenseEditorPane.setEditable(false);
        licenseEditorPane.addHyperlinkListener(new javax.swing.event.HyperlinkListener() {
            public void hyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {
                licenseEditorPaneHyperlinkUpdate(evt);
            }
        });
        licenseScrollPane.setViewportView(licenseEditorPane);

        tabbedPane.addTab(bundle.getString("AboutDialog.licenseScrollPane.TabConstraints.tabTitle"), licenseScrollPane); // NOI18N

        okButton.setText(bundle.getString("AboutDialog.okButton.text")); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        okButtonPanel.add(okButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tabbedPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                    .addComponent(okButtonPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                    .addComponent(versionLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(versionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(okButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void licenseEditorPaneHyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {//GEN-FIRST:event_licenseEditorPaneHyperlinkUpdate
        openLink(evt);
    }//GEN-LAST:event_licenseEditorPaneHyperlinkUpdate

    private void creditsEditorPaneHyperlinkUpdate(javax.swing.event.HyperlinkEvent evt) {//GEN-FIRST:event_creditsEditorPaneHyperlinkUpdate
        openLink(evt);
    }//GEN-LAST:event_creditsEditorPaneHyperlinkUpdate

    private void openLink(HyperlinkEvent hyperlinkEvent) {
        if (hyperlinkEvent.getEventType()
                == HyperlinkEvent.EventType.ACTIVATED) {

            try {
                Desktop.getDesktop().browse(hyperlinkEvent.getURL().toURI());
            } catch (URISyntaxException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }

            // disable and change cursor for a short time so that the user
            // has a visible feedback until the browser is open
            final JEditorPane source = (JEditorPane) hyperlinkEvent.getSource();
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
    }

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        dispose();
        setVisible(false);
    }//GEN-LAST:event_okButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane creditsEditorPane;
    private javax.swing.JScrollPane creditsScrollPane;
    private javax.swing.JEditorPane licenseEditorPane;
    private javax.swing.JScrollPane licenseScrollPane;
    private javax.swing.JButton okButton;
    private javax.swing.JPanel okButtonPanel;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JLabel versionLabel;
    // End of variables declaration//GEN-END:variables
}
