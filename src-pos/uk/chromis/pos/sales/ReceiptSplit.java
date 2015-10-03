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

package uk.chromis.pos.sales;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import javax.swing.JFrame;
import uk.chromis.pos.customers.DataLogicCustomers;
import uk.chromis.pos.forms.AppLocal;
import uk.chromis.pos.forms.DataLogicSales;
import uk.chromis.pos.ticket.TicketInfo;
import uk.chromis.pos.ticket.TicketLineInfo;

/**
 *
 * @author  adrianromero
 */
public class ReceiptSplit extends javax.swing.JDialog {
    
    private boolean accepted;
    
    SimpleReceipt receiptone;
    SimpleReceipt receipttwo;
    
    /** Creates new form ReceiptSplit
     * @param parent */
    protected ReceiptSplit(java.awt.Frame parent) {
        super(parent, true);
    }
    /** Creates new form ReceiptSplit
     * @param parent */
    protected ReceiptSplit(java.awt.Dialog parent) {
        super(parent, true);
    } 
    
    private void init(String ticketline, DataLogicSales dlSales, DataLogicCustomers dlCustomers, TaxesLogic taxeslogic) {
        
        initComponents();        
        getRootPane().setDefaultButton(m_jButtonOK); 
        
        receiptone = new SimpleReceipt(ticketline, dlSales, dlCustomers, taxeslogic);
        receiptone.setCustomerEnabled(false);
        jPanel5.add(receiptone, BorderLayout.CENTER);
        
        receipttwo = new SimpleReceipt(ticketline, dlSales, dlCustomers, taxeslogic);
        jPanel3.add(receipttwo, BorderLayout.CENTER);
    }
    
    /**
     *
     * @param parent
     * @param ticketline
     * @param dlSales
     * @param dlCustomers
     * @param taxeslogic
     * @return
     */
    public static ReceiptSplit getDialog(Component parent, String ticketline, DataLogicSales dlSales, DataLogicCustomers dlCustomers, TaxesLogic taxeslogic) {
         
        Window window = getWindow(parent);
        
        ReceiptSplit myreceiptsplit;
        
        if (window instanceof Frame) { 
            myreceiptsplit = new ReceiptSplit((Frame) window);
        } else {
            myreceiptsplit = new ReceiptSplit((Dialog) window);
        }
        
        myreceiptsplit.init(ticketline, dlSales, dlCustomers, taxeslogic);         
        
        return myreceiptsplit;
    }

    /**
     *
     * @param parent
     * @return
     */
    protected static Window getWindow(Component parent) {
        if (parent == null) {
            return new JFrame();
        } else if (parent instanceof Frame || parent instanceof Dialog) {
            return (Window)parent;
        } else {
            return getWindow(parent.getParent());
        }
    }
    
    /**
     *
     * @param ticket
     * @param ticket2
     * @param ticketext
     * @return
     */
    public boolean showDialog(TicketInfo ticket, TicketInfo ticket2, Object ticketext) {

        receiptone.setTicket(ticket, ticketext);
        receipttwo.setTicket(ticket2, ticketext);
        
        setVisible(true);    
        return accepted;
    }    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        m_jButtonCancel = new javax.swing.JButton();
        m_jButtonOK = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jBtnToRightAll = new javax.swing.JButton();
        jBtnToRightOne = new javax.swing.JButton();
        jBtnToLeftOne = new javax.swing.JButton();
        jBtnToLeftAll = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(AppLocal.getIntString("caption.split")); // NOI18N
        setResizable(false);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        m_jButtonCancel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        m_jButtonCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uk/chromis/images/cancel.png"))); // NOI18N
        m_jButtonCancel.setText(AppLocal.getIntString("Button.Cancel")); // NOI18N
        m_jButtonCancel.setFocusPainted(false);
        m_jButtonCancel.setFocusable(false);
        m_jButtonCancel.setMargin(new java.awt.Insets(8, 16, 8, 16));
        m_jButtonCancel.setRequestFocusEnabled(false);
        m_jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jButtonCancelActionPerformed(evt);
            }
        });
        jPanel2.add(m_jButtonCancel);

        m_jButtonOK.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        m_jButtonOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uk/chromis/images/ok.png"))); // NOI18N
        m_jButtonOK.setText(AppLocal.getIntString("Button.OK")); // NOI18N
        m_jButtonOK.setFocusPainted(false);
        m_jButtonOK.setFocusable(false);
        m_jButtonOK.setMargin(new java.awt.Insets(8, 16, 8, 16));
        m_jButtonOK.setRequestFocusEnabled(false);
        m_jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jButtonOKActionPerformed(evt);
            }
        });
        jPanel2.add(m_jButtonOK);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jPanel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel5.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jPanel5);

        jPanel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jBtnToRightAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uk/chromis/images/2rightarrow.png"))); // NOI18N
        jBtnToRightAll.setToolTipText("Split All Line Items");
        jBtnToRightAll.setFocusPainted(false);
        jBtnToRightAll.setFocusable(false);
        jBtnToRightAll.setMargin(new java.awt.Insets(8, 14, 8, 14));
        jBtnToRightAll.setRequestFocusEnabled(false);
        jBtnToRightAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnToRightAllActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        jPanel4.add(jBtnToRightAll, gridBagConstraints);

        jBtnToRightOne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uk/chromis/images/1rightarrow.png"))); // NOI18N
        jBtnToRightOne.setToolTipText("Split only one of the Line Items");
        jBtnToRightOne.setFocusPainted(false);
        jBtnToRightOne.setFocusable(false);
        jBtnToRightOne.setMargin(new java.awt.Insets(8, 14, 8, 14));
        jBtnToRightOne.setRequestFocusEnabled(false);
        jBtnToRightOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnToRightOneActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel4.add(jBtnToRightOne, gridBagConstraints);

        jBtnToLeftOne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uk/chromis/images/1leftarrow.png"))); // NOI18N
        jBtnToLeftOne.setToolTipText("Un-Split only one of the Line Items");
        jBtnToLeftOne.setFocusPainted(false);
        jBtnToLeftOne.setFocusable(false);
        jBtnToLeftOne.setMargin(new java.awt.Insets(8, 14, 8, 14));
        jBtnToLeftOne.setRequestFocusEnabled(false);
        jBtnToLeftOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnToLeftOneActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel4.add(jBtnToLeftOne, gridBagConstraints);

        jBtnToLeftAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uk/chromis/images/2leftarrow.png"))); // NOI18N
        jBtnToLeftAll.setToolTipText("Un-Split All Line Items");
        jBtnToLeftAll.setFocusPainted(false);
        jBtnToLeftAll.setFocusable(false);
        jBtnToLeftAll.setMargin(new java.awt.Insets(8, 14, 8, 14));
        jBtnToLeftAll.setRequestFocusEnabled(false);
        jBtnToLeftAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnToLeftAllActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel4.add(jBtnToLeftAll, gridBagConstraints);

        jPanel1.add(jPanel4);

        jPanel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel3.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jPanel3);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-730)/2, (screenSize.height-470)/2, 730, 470);
    }// </editor-fold>//GEN-END:initComponents

    private void m_jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jButtonOKActionPerformed

        if (receipttwo.getTicket().getLinesCount() > 0) {
            accepted = true;
            dispose();
        }

    }//GEN-LAST:event_m_jButtonOKActionPerformed

    private void m_jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jButtonCancelActionPerformed
        
        dispose();
        
    }//GEN-LAST:event_m_jButtonCancelActionPerformed

    private void jBtnToRightAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnToRightAllActionPerformed
       
        TicketLineInfo[] lines = receiptone.getSelectedLines();
        if (lines != null) {
            receipttwo.addSelectedLines(lines);
        }
            
}//GEN-LAST:event_jBtnToRightAllActionPerformed

    private void jBtnToRightOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnToRightOneActionPerformed
        
        TicketLineInfo[] lines = receiptone.getSelectedLinesUnit();
        if (lines != null) {
            receipttwo.addSelectedLines(lines);
        }

}//GEN-LAST:event_jBtnToRightOneActionPerformed

    private void jBtnToLeftOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnToLeftOneActionPerformed
      
        TicketLineInfo[] lines = receipttwo.getSelectedLinesUnit();
        if (lines != null) {
            receiptone.addSelectedLines(lines);
        }
       
}//GEN-LAST:event_jBtnToLeftOneActionPerformed

    private void jBtnToLeftAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnToLeftAllActionPerformed
       
        TicketLineInfo[] lines = receipttwo.getSelectedLines();
        if (lines != null) {
            receiptone.addSelectedLines(lines);
        }

}//GEN-LAST:event_jBtnToLeftAllActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnToLeftAll;
    private javax.swing.JButton jBtnToLeftOne;
    private javax.swing.JButton jBtnToRightAll;
    private javax.swing.JButton jBtnToRightOne;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton m_jButtonCancel;
    private javax.swing.JButton m_jButtonOK;
    // End of variables declaration//GEN-END:variables
    
}
