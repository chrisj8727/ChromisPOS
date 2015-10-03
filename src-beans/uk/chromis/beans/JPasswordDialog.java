//    Chromis POS  - The New Face of Open Source POS
//    Copyright (c) 2015 
//    http://www.chromis.co.uk
//
//    This file is part of Chromis POS
//
//     Chromis POS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    Chromis POS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with Chromis POS.  If not, see <http://www.gnu.org/licenses/>.

package uk.chromis.beans;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import javax.swing.Icon;
import javax.swing.JFrame;

/**
 *
 *   
 */
public class JPasswordDialog extends javax.swing.JDialog {
    
    // private static ResourceBundle m_Intl;
    private static LocaleResources m_resources;

    private String m_sPassword;
        
    /** Creates new form JCalendarDialog
     * @param parent
     * @param modal */
    public JPasswordDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);            
        init();
    }
    /** Creates new form JCalendarDialog
     * @param parent
     * @param modal */
    public JPasswordDialog(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);            
        init();
    }    
    
    private void init() {
        
        if (m_resources == null) {
            m_resources = new LocaleResources();
            m_resources.addBundleName("beans_messages");
        }
        
        initComponents();        
        getRootPane().setDefaultButton(jcmdOK);   
        
        m_jpassword.addEditorKeys(m_jKeys);
        m_jpassword.reset();
        m_jpassword.activate();
        
        m_jPanelTitle.setBorder(RoundedBorder.createGradientBorder());

        m_sPassword = null;
    }
    
    private void setTitle(String title, String message, Icon icon) {
        setTitle(title);
        m_lblMessage.setText(message);
        m_lblMessage.setIcon(icon);
    }
    
    private static Window getWindow(Component parent) {
        if (parent == null) {
            return new JFrame();
        } else if (parent instanceof Frame || parent instanceof Dialog) {
            return (Window) parent;
        } else {
            return getWindow(parent.getParent());
        }
    }

    /**
     *
     * @param parent
     * @param title
     * @return
     */
    public static String showEditPassword(Component parent, String title) {
        return showEditPassword(parent, title, null, null);
    }

    /**
     *
     * @param parent
     * @param title
     * @param message
     * @return
     */
    public static String showEditPassword(Component parent, String title, String message) {
        return showEditPassword(parent, title, message, null);
    }

    /**
     *
     * @param parent
     * @param title
     * @param message
     * @param icon
     * @return
     */
    public static String showEditPassword(Component parent, String title, String message, Icon icon) {
        
        Window window = getWindow(parent);      
        
        JPasswordDialog myMsg;
        if (window instanceof Frame) { 
            myMsg = new JPasswordDialog((Frame) window, true);
        } else {
            myMsg = new JPasswordDialog((Dialog) window, true);
        }
        
        myMsg.setTitle(title, message, icon);
        myMsg.setVisible(true);
        return myMsg.m_sPassword;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jcmdOK = new javax.swing.JButton();
        jcmdCancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanelGrid = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        m_jKeys = new uk.chromis.editor.JEditorKeys();
        jPanel4 = new javax.swing.JPanel();
        m_jpassword = new uk.chromis.editor.JEditorPassword();
        m_jPanelTitle = new javax.swing.JPanel();
        m_lblMessage = new javax.swing.JLabel();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeWindow(evt);
            }
        });

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jcmdOK.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcmdOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uk/chromis/images/ok.png"))); // NOI18N
        jcmdOK.setText(m_resources.getString("button.ok")); // NOI18N
        jcmdOK.setMargin(new java.awt.Insets(8, 16, 8, 16));
        jcmdOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmdOKActionPerformed(evt);
            }
        });
        jPanel1.add(jcmdOK);

        jcmdCancel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcmdCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uk/chromis/images/cancel.png"))); // NOI18N
        jcmdCancel.setText(m_resources.getString("button.cancel")); // NOI18N
        jcmdCancel.setMargin(new java.awt.Insets(8, 16, 8, 16));
        jcmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmdCancelActionPerformed(evt);
            }
        });
        jPanel1.add(jcmdCancel);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        m_jKeys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jKeysActionPerformed(evt);
            }
        });
        jPanel3.add(m_jKeys);

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel4.setLayout(new java.awt.BorderLayout());

        m_jpassword.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel4.add(m_jpassword, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel4);

        jPanelGrid.add(jPanel3);

        jPanel2.add(jPanelGrid, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        m_jPanelTitle.setLayout(new java.awt.BorderLayout());

        m_lblMessage.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, java.awt.Color.darkGray), javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        m_jPanelTitle.add(m_lblMessage, java.awt.BorderLayout.CENTER);

        getContentPane().add(m_jPanelTitle, java.awt.BorderLayout.NORTH);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-258)/2, (screenSize.height-428)/2, 258, 428);
    }// </editor-fold>//GEN-END:initComponents

    private void jNumberKeys21KeyPerformed(uk.chromis.beans.JNumberEvent evt) {//GEN-FIRST:event_jNumberKeys21KeyPerformed
 
    }//GEN-LAST:event_jNumberKeys21KeyPerformed

    private void jcmdOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmdOKActionPerformed
          
        m_sPassword = m_jpassword.getPassword(); 
        setVisible(false);
        dispose();     
        
    }//GEN-LAST:event_jcmdOKActionPerformed

    private void jcmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmdCancelActionPerformed

        setVisible(false);
        dispose();    
        
    }//GEN-LAST:event_jcmdCancelActionPerformed

    private void closeWindow(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeWindow

        setVisible(false);
        dispose();
        
    }//GEN-LAST:event_closeWindow

    private void m_jKeysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jKeysActionPerformed
    }//GEN-LAST:event_m_jKeysActionPerformed
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelGrid;
    private javax.swing.JButton jcmdCancel;
    private javax.swing.JButton jcmdOK;
    private uk.chromis.editor.JEditorKeys m_jKeys;
    private javax.swing.JPanel m_jPanelTitle;
    private uk.chromis.editor.JEditorPassword m_jpassword;
    private javax.swing.JLabel m_lblMessage;
    // End of variables declaration//GEN-END:variables
    
}
