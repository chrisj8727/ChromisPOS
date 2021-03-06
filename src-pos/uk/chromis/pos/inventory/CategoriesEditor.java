//    Chromis POS  - The New Face of Open Source POS
//    Copyright (c) 2015 
//    http://www.chromis.co.uk liquibase
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
package uk.chromis.pos.inventory;

import com.bric.swing.ColorPicker;
import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import uk.chromis.basic.BasicException;
import uk.chromis.data.gui.ComboBoxValModel;
import uk.chromis.data.gui.JMessageDialog;
import uk.chromis.data.gui.MessageInf;
import uk.chromis.data.loader.SentenceExec;
import uk.chromis.data.loader.SentenceList;
import uk.chromis.data.user.DirtyManager;
import uk.chromis.data.user.EditorRecord;
import uk.chromis.format.Formats;
import uk.chromis.pos.forms.AppLocal;
import uk.chromis.pos.forms.AppView;
import uk.chromis.pos.forms.DataLogicSales;

/**
 *
 * @author adrianromero
 */
public final class CategoriesEditor extends JPanel implements EditorRecord {

    private SentenceList m_sentcat;
    private ComboBoxValModel m_CategoryModel;

    private SentenceExec m_sentadd;
    private SentenceExec m_sentdel;
    private Border border;
    private Object m_id;

    /**
     * Creates new form JPanelCategories
     *
     * @param app
     * @param dirty
     */
    public CategoriesEditor(AppView app, DirtyManager dirty) {

        DataLogicSales dlSales = (DataLogicSales) app.getBean("uk.chromis.pos.forms.DataLogicSales");

        initComponents();

        // El modelo de categorias
        m_sentcat = dlSales.getCategoriesList();
        m_CategoryModel = new ComboBoxValModel();

        m_sentadd = dlSales.getCatalogCategoryAdd();
        m_sentdel = dlSales.getCatalogCategoryDel();

        m_jName.getDocument().addDocumentListener(dirty);
        m_jCategory.addActionListener(dirty);
        m_jImage.addPropertyChangeListener("image", dirty);
        m_jCatNameShow.addActionListener(dirty);

// Added JDL 13.04.13
        m_jTextTip.getDocument().addDocumentListener(dirty);

// Added JDL 15.02.15 colour for button borders        
        m_jbtnColour.getDocument().addDocumentListener(dirty);

// get the default border
        border = m_jbtnColour.getBorder();

        writeValueEOF();
    }

    /**
     *
     */
    @Override
    public void refresh() {

        List a;

        try {
            a = m_sentcat.list();
        } catch (BasicException eD) {
            MessageInf msg = new MessageInf(MessageInf.SGN_NOTICE, AppLocal.getIntString("message.cannotloadlists"), eD);
            msg.show(this);
            a = new ArrayList();
        }

        a.add(0, null); // The null item
        m_CategoryModel = new ComboBoxValModel(a);
        m_jCategory.setModel(m_CategoryModel);

        if ("".equals(m_jbtnColour.getText())) {
            m_jbtnColour.setBorder(border);
        } else {
            m_jbtnColour.setBorder(BorderFactory.createLineBorder(new Color((int) Integer.decode(m_jbtnColour.getText())), 3));
        }

    }

    /**
     *
     */
    @Override
    public void writeValueEOF() {
        m_id = null;
        m_jName.setText(null);
        m_CategoryModel.setSelectedKey(null);
        m_jImage.setImage(null);
        m_jName.setEnabled(false);
        m_jCategory.setEnabled(false);
        m_jImage.setEnabled(false);
        m_jCatalogDelete.setEnabled(false);
        m_jCatalogAdd.setEnabled(false);
        m_jTextTip.setText(null);
        m_jTextTip.setEnabled(false);
        m_jCatNameShow.setSelected(false);
        m_jCatNameShow.setEnabled(false);
        m_jbtnColour.setText(null);
        m_jbtnColour.setEnabled(false);

    }

    /**
     *
     */
    @Override
    public void writeValueInsert() {
        m_id = UUID.randomUUID().toString();
        m_jName.setText(null);
        m_CategoryModel.setSelectedKey(null);
        m_jImage.setImage(null);
        m_jName.setEnabled(true);
        m_jCategory.setEnabled(true);
        m_jImage.setEnabled(true);
        m_jCatalogDelete.setEnabled(false);
        m_jCatalogAdd.setEnabled(false);
        m_jTextTip.setText(null);
        m_jTextTip.setEnabled(true);
        m_jCatNameShow.setSelected(true);
        m_jCatNameShow.setEnabled(true);
        m_jbtnColour.setText(null);
        m_jbtnColour.setEnabled(true);
        m_jbtnColour.setBorder(border);
    }

    /**
     *
     * @param value
     */
    @Override
    public void writeValueDelete(Object value) {
        Object[] cat = (Object[]) value;
        m_id = cat[0];
        m_jName.setText(Formats.STRING.formatValue(cat[1]));
        m_CategoryModel.setSelectedKey(cat[2]);
        m_jImage.setImage((BufferedImage) cat[3]);
        m_jTextTip.setText(Formats.STRING.formatValue(cat[4]));
        m_jCatNameShow.setSelected(((Boolean) cat[5]).booleanValue());
        m_jbtnColour.setText(Formats.STRING.formatValue(cat[6]));
        m_jName.setEnabled(false);
        m_jCategory.setEnabled(false);
        m_jImage.setEnabled(false);
        m_jCatalogDelete.setEnabled(false);
        m_jCatalogAdd.setEnabled(false);
        m_jTextTip.setEnabled(false);
        m_jCatNameShow.setEnabled(false);
        m_jbtnColour.setEnabled(false);

    }

    /**
     *
     * @param value
     */
    @Override
    public void writeValueEdit(Object value) {
        Object[] cat = (Object[]) value;
        m_id = cat[0];
        m_jName.setText(Formats.STRING.formatValue(cat[1]));
        m_CategoryModel.setSelectedKey(cat[2]);
        m_jImage.setImage((BufferedImage) cat[3]);
        m_jTextTip.setText(Formats.STRING.formatValue(cat[4]));
        m_jCatNameShow.setSelected(((Boolean) cat[5]));
        m_jbtnColour.setText(Formats.STRING.formatValue(cat[6]));
        m_jName.setEnabled(true);
        m_jCategory.setEnabled(true);
        m_jImage.setEnabled(true);
        m_jCatalogDelete.setEnabled(true);
        m_jCatalogAdd.setEnabled(true);
        m_jTextTip.setEnabled(true);
        m_jCatNameShow.setEnabled(true);
        m_jbtnColour.setEnabled(true);

        if ("".equals(m_jbtnColour.getText())) {
            m_jbtnColour.setBorder(border);
        } else {
            m_jbtnColour.setBorder(BorderFactory.createLineBorder(new Color((int) Integer.decode(m_jbtnColour.getText())), 3));
        }
    }

    /**
     *
     * @return @throws BasicException
     */
    @Override
    public Object createValue() throws BasicException {

        Object[] cat = new Object[7];

        cat[0] = m_id;
        cat[1] = m_jName.getText();
        cat[2] = m_CategoryModel.getSelectedKey();
        cat[3] = m_jImage.getImage();
        cat[4] = m_jTextTip.getText();
        cat[5] = Boolean.valueOf(m_jCatNameShow.isSelected());
        cat[6] = m_jbtnColour.getText();

        return cat;
    }

    /**
     *
     * @return
     */
    @Override
    public Component getComponent() {
        return this;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel2 = new javax.swing.JLabel();
        m_jName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        m_jImage = new uk.chromis.data.gui.JImageEditor();
        m_jCatalogAdd = new javax.swing.JButton();
        m_jCatalogDelete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        m_jCategory = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        m_jTextTip = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        m_jCatNameShow = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jColorChooser = new javax.swing.JButton();
        m_jbtnColour = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        setLayout(null);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText(AppLocal.getIntString("Label.Name")); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(20, 30, 80, 25);

        m_jName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        add(m_jName);
        m_jName.setBounds(200, 30, 180, 25);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText(AppLocal.getIntString("label.image")); // NOI18N
        add(jLabel3);
        jLabel3.setBounds(20, 200, 80, 15);
        add(m_jImage);
        m_jImage.setBounds(200, 200, 250, 190);

        m_jCatalogAdd.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        m_jCatalogAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uk/chromis/images/editnew.png"))); // NOI18N
        m_jCatalogAdd.setText(AppLocal.getIntString("button.catalogadd")); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("pos_messages"); // NOI18N
        m_jCatalogAdd.setToolTipText(bundle.getString("button.catalogadd")); // NOI18N
        m_jCatalogAdd.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        m_jCatalogAdd.setMargin(new java.awt.Insets(2, 4, 2, 14));
        m_jCatalogAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jCatalogAddActionPerformed(evt);
            }
        });
        add(m_jCatalogAdd);
        m_jCatalogAdd.setBounds(540, 40, 80, 30);

        m_jCatalogDelete.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        m_jCatalogDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uk/chromis/images/editdelete.png"))); // NOI18N
        m_jCatalogDelete.setText(AppLocal.getIntString("button.catalogdel")); // NOI18N
        m_jCatalogDelete.setToolTipText(bundle.getString("button.catalogdel")); // NOI18N
        m_jCatalogDelete.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        m_jCatalogDelete.setMargin(new java.awt.Insets(2, 4, 2, 14));
        m_jCatalogDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jCatalogDeleteActionPerformed(evt);
            }
        });
        add(m_jCatalogDelete);
        m_jCatalogDelete.setBounds(540, 78, 80, 33);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText(AppLocal.getIntString("label.prodcategory")); // NOI18N
        add(jLabel5);
        jLabel5.setBounds(20, 60, 80, 25);

        m_jCategory.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        add(m_jCategory);
        m_jCategory.setBounds(200, 60, 180, 25);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 204));
        jLabel4.setText("{");
        add(jLabel4);
        jLabel4.setBounds(510, 34, 30, 70);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText(bundle.getString("label.texttip")); // NOI18N
        add(jLabel6);
        jLabel6.setBounds(20, 95, 100, 15);

        m_jTextTip.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        add(m_jTextTip);
        m_jTextTip.setBounds(200, 90, 180, 25);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText(bundle.getString("label.subcategorytitle")); // NOI18N
        add(jLabel7);
        jLabel7.setBounds(20, 130, 130, 15);

        m_jCatNameShow.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        m_jCatNameShow.setSelected(true);
        add(m_jCatNameShow);
        m_jCatNameShow.setBounds(195, 130, 30, 21);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText(bundle.getString("label.CatalogueStatusYes")); // NOI18N
        add(jLabel8);
        jLabel8.setBounds(390, 64, 110, 20);

        jColorChooser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uk/chromis/images/ColourPick.png"))); // NOI18N
        jColorChooser.setMaximumSize(new java.awt.Dimension(24, 24));
        jColorChooser.setMinimumSize(new java.awt.Dimension(24, 24));
        jColorChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jColorChooserActionPerformed(evt);
            }
        });
        add(jColorChooser);
        jColorChooser.setBounds(300, 155, 30, 30);
        add(m_jbtnColour);
        m_jbtnColour.setBounds(200, 160, 90, 20);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText(bundle.getString("Button.Bordercolour")); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(20, 160, 170, 20);
    }// </editor-fold>//GEN-END:initComponents

    private void m_jCatalogDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jCatalogDeleteActionPerformed

        try {
            m_sentdel.exec(m_id);
// JG 3 Oct 2013 - simple toggle Category state         
// TODO replace with ToggleButton
            m_jCatalogDelete.setEnabled(false);
            m_jCatalogAdd.setEnabled(true);
            jLabel8.setText(AppLocal.getIntString("label.CatalogueStatusNo"));
        } catch (BasicException e) {
            JMessageDialog.showMessage(this, new MessageInf(MessageInf.SGN_WARNING, AppLocal.getIntString("message.cannotexecute"), e));
        }

    }//GEN-LAST:event_m_jCatalogDeleteActionPerformed

    private void m_jCatalogAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jCatalogAddActionPerformed

        try {
            Object param = m_id;
            m_sentdel.exec(param); // primero borramos
            m_sentadd.exec(param); // y luego insertamos lo que queda
// JG 3 Oct 2013 - simple toggle Category state
// TODO replace with ToggleButton            
            m_jCatalogAdd.setEnabled(false);
            m_jCatalogDelete.setEnabled(true);
            jLabel8.setText(AppLocal.getIntString("label.CatalogueStatusYes"));

        } catch (BasicException e) {
            JMessageDialog.showMessage(this, new MessageInf(MessageInf.SGN_WARNING, AppLocal.getIntString("message.cannotexecute"), e));
        }

    }//GEN-LAST:event_m_jCatalogAddActionPerformed

    private void jColorChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jColorChooserActionPerformed
        ColorPicker col = new ColorPicker();
        col.setColor(Color.white);
        JOptionPane.showMessageDialog(null, col, "Select Border Colour", JOptionPane.PLAIN_MESSAGE);
        Color newColor = col.getColor();
        String sColor = "0x" + Integer.toHexString(0x100 | newColor.getRed()).substring(1).toUpperCase()
                + Integer.toHexString(0x100 | newColor.getGreen()).substring(1).toUpperCase()
                + Integer.toHexString(0x100 | newColor.getBlue()).substring(1).toUpperCase();
        m_jbtnColour.setText(sColor);

        m_jbtnColour.setBorder(BorderFactory.createLineBorder(new Color((int) Integer.decode(sColor)), 3));

    }//GEN-LAST:event_jColorChooserActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jColorChooser;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JCheckBox m_jCatNameShow;
    private javax.swing.JButton m_jCatalogAdd;
    private javax.swing.JButton m_jCatalogDelete;
    private javax.swing.JComboBox m_jCategory;
    private uk.chromis.data.gui.JImageEditor m_jImage;
    private javax.swing.JTextField m_jName;
    private javax.swing.JTextField m_jTextTip;
    private javax.swing.JTextField m_jbtnColour;
    // End of variables declaration//GEN-END:variables

}
