/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import adt.*;
import entity.*;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class CorporateCustomerApprove extends javax.swing.JFrame {

    customerInt<CorporateCustomer> corCust = new LinkedCustomer();
    customerInt<Customer> cust = new LinkedCustomer();
    staffInt<Staff> staffList = new LinkedStaff();
    ProductListInterface<Product> productList = new ProductLList<>();
    PromoListInterface<Promotion> promoList = new PromoLList<>();
    OrderInterface<Delivery> orderList = new OrderLList<>();
    OrderInterface<PickUp> pickUpList = new OrderLList<>();
    OrderInterface<SalesOrder> salesOrderList = new OrderLList<>();
    ManageOrderInterface<PickUp> manageOrderList = new ManageOrderList<>();
    ManageOrderInterface<Delivery> manageDeliveryList = new ManageOrderList<>();
    
    Staff currentStaff = new Staff();
    CorporateCustomer selectedCorCust = new CorporateCustomer();
    
    /**
     * Creates new form CorporateCustomerApprove
     */
    public CorporateCustomerApprove() {
        initComponents();
        
        refreshCorCust();
    }

    public CorporateCustomerApprove(Staff currentStaff,
                                    customerInt<Customer> cust,
                                    customerInt<CorporateCustomer> corCust,
                                    staffInt<Staff> staffList,
                                    ProductListInterface<Product> productList,
                                    PromoListInterface<Promotion> promoList,
                                    OrderInterface<Delivery> orderList,
                                    OrderInterface<PickUp> pickUpList,
                                    OrderInterface<SalesOrder> salesOrderList,
                                    ManageOrderInterface<PickUp> manageOrderList,
                                    ManageOrderInterface<Delivery> manageDeliveryList){
        this.currentStaff = currentStaff;
        this.cust = cust;
        this.corCust = corCust;
        this.staffList = staffList;
        this.productList = productList;
        this.promoList = promoList;
        this.orderList = orderList;
        this.pickUpList = pickUpList;
        this.salesOrderList = salesOrderList;
        this.manageOrderList = manageOrderList;
        this.manageDeliveryList = manageDeliveryList;
        initComponents();
        refreshCorCust();
    }
    
    //refresh the corporate customer not yet approve and show in the ID jComboBox
    private void refreshCorCust(){
        jcbID.removeAllItems();
        
        if(corCust.isEmpty()){
            jcbID.addItem("None");
        }else{
            
            for(int i =0;i<corCust.getLength();i++){
                if(corCust.getAt(i).getCreditLimit() == -1){
                    jcbID.addItem(corCust.getAt(i).getCustID()); 
                }
            }
            
        }
    }
    
    private void showSelectedCorCust(){
        
        if(jcbID.getSelectedItem().equals("None")){
            JOptionPane.showMessageDialog(this, "No corporate customer register", "No register", JOptionPane.WARNING_MESSAGE);
            clearText();
        }else{
            String selectedID = jcbID.getSelectedItem().toString();
            for(int i=0;i<corCust.getLength();i++){
                String id = corCust.getAt(i).getCustID();
                if(id.equals(selectedID)){
                    selectedCorCust = corCust.getAt(i);
                }
            }
            
            jtfName.setText(selectedCorCust.getCustName());
            jtfContactNo.setText(selectedCorCust.getContactNo());
            jtfCompanyID.setText(selectedCorCust.getCompanyID());
            jtfCompanyName.setText(selectedCorCust.getCompanyName());
            jtfEmail.setText(selectedCorCust.getEmail());
            jtfCreditLimit.setText("0");
        }
    }
    
    private boolean isSetCorrect(){
        boolean correct = false;
        
        if(!jtfCreditLimit.getText().equals("")){
            if(isNumeric(jtfCreditLimit.getText())){
                double creditLimit = Double.parseDouble(jtfCreditLimit.getText());
                if(creditLimit >= 10 && creditLimit <= 1000){
                    correct = true;
                }else{
                    JOptionPane.showMessageDialog(this,"Credit Limit cannot be less than 10 and not exceed 1000", "Not in range", JOptionPane.WARNING_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Credit Limit cannot be blank", "Text field blank", JOptionPane.WARNING_MESSAGE);
        }
        return correct;
    }
    
    private boolean isNumeric(String str){
        try{
            double test = Double.parseDouble(str);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this,"Credit Limit must be numeric", "Not numeric", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    private boolean setCreditLimit(){
        double creditLimit = Double.parseDouble(jtfCreditLimit.getText());
        CorporateCustomer updatedCorCust = selectedCorCust;
        
        updatedCorCust.setCreditLimit(creditLimit);
        updatedCorCust.setRemainLimit(creditLimit);
        
        JOptionPane.showMessageDialog(this, updatedCorCust, "Approved customer info", JOptionPane.INFORMATION_MESSAGE);
        return corCust.updateCreditLimit(selectedCorCust, updatedCorCust);
    }
    
    private void clearText(){
        jtfName.setText("");
        jtfContactNo.setText("");
        jtfCompanyID.setText("");
        jtfCompanyName.setText("");
        jtfEmail.setText("");
        jtfCreditLimit.setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlbCompanyName = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlblCorporateCustID = new javax.swing.JLabel();
        jcbID = new javax.swing.JComboBox<>();
        jlblName = new javax.swing.JLabel();
        jtfName = new javax.swing.JTextField();
        jlblContactNo = new javax.swing.JLabel();
        jtfContactNo = new javax.swing.JTextField();
        jlblCompanyID = new javax.swing.JLabel();
        jtfCompanyID = new javax.swing.JTextField();
        jlblCompanyName = new javax.swing.JLabel();
        jtfCompanyName = new javax.swing.JTextField();
        jlblEmail = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jlblCreditLimit = new javax.swing.JLabel();
        jtfCreditLimit = new javax.swing.JTextField();
        jbApprove = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();
        jbBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 255));

        jlbCompanyName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlbCompanyName.setText("Fiore Flowershop");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(276, 276, 276)
                .addComponent(jlbCompanyName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jlbCompanyName)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Approve Corporate Customer");

        jlblCorporateCustID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblCorporateCustID.setText("Corporate Customer ID:");
        jlblCorporateCustID.setPreferredSize(new java.awt.Dimension(189, 22));

        jcbID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbIDActionPerformed(evt);
            }
        });

        jlblName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblName.setText("Name:");

        jtfName.setEditable(false);
        jtfName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jlblContactNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblContactNo.setText("Contact Number:");

        jtfContactNo.setEditable(false);
        jtfContactNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jlblCompanyID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblCompanyID.setText("Company ID:");

        jtfCompanyID.setEditable(false);
        jtfCompanyID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jlblCompanyName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblCompanyName.setText("Company Name:");

        jtfCompanyName.setEditable(false);
        jtfCompanyName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jlblEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblEmail.setText("Email:");

        jtfEmail.setEditable(false);
        jtfEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jlblCreditLimit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlblCreditLimit.setText("Credit Limit:");

        jtfCreditLimit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jbApprove.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbApprove.setText("Approve");
        jbApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbApproveActionPerformed(evt);
            }
        });

        jbCancel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbCancel.setText("Cancel");
        jbCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelActionPerformed(evt);
            }
        });

        jbBack.setText("Back");
        jbBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(jLabel1)
                .addContainerGap(266, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfCompanyID, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfCreditLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jbBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jlblCreditLimit)
                                .addComponent(jlblEmail)
                                .addComponent(jlblCompanyName)
                                .addComponent(jlblCompanyID)
                                .addComponent(jlblContactNo)
                                .addComponent(jlblName)
                                .addComponent(jcbID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlblCorporateCustID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(183, 183, 183))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(jbApprove, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(169, 169, 169))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlblCorporateCustID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jbBack)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblName)
                .addGap(4, 4, 4)
                .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblContactNo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblCompanyID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfCompanyID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblCompanyName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblCreditLimit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfCreditLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbApprove)
                    .addComponent(jbCancel))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbApproveActionPerformed
        // TODO add your handling code here:
        if(isSetCorrect()){
            if(setCreditLimit()){
                new Homepage(currentStaff, cust, corCust, staffList, productList, promoList,orderList,pickUpList,salesOrderList, manageOrderList, manageDeliveryList).setVisible(true);
                this.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(this,"The approve is failed please try again later", "Approve failed", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbApproveActionPerformed

    private void jbCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelActionPerformed
        // TODO add your handling code here:
        clearText();
    }//GEN-LAST:event_jbCancelActionPerformed

    private void jbBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBackActionPerformed
        // TODO add your handling code here:
        new Homepage(currentStaff, cust, corCust, staffList, productList, promoList,orderList,pickUpList,salesOrderList, manageOrderList, manageDeliveryList).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jbBackActionPerformed

    private void jcbIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbIDActionPerformed
            // TODO add your handling code here:
            showSelectedCorCust();
            refreshCorCust();
    }//GEN-LAST:event_jcbIDActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CorporateCustomerApprove.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CorporateCustomerApprove.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CorporateCustomerApprove.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CorporateCustomerApprove.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CorporateCustomerApprove().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbApprove;
    private javax.swing.JButton jbBack;
    private javax.swing.JButton jbCancel;
    private javax.swing.JComboBox<String> jcbID;
    private javax.swing.JLabel jlbCompanyName;
    private javax.swing.JLabel jlblCompanyID;
    private javax.swing.JLabel jlblCompanyName;
    private javax.swing.JLabel jlblContactNo;
    private javax.swing.JLabel jlblCorporateCustID;
    private javax.swing.JLabel jlblCreditLimit;
    private javax.swing.JLabel jlblEmail;
    private javax.swing.JLabel jlblName;
    private javax.swing.JTextField jtfCompanyID;
    private javax.swing.JTextField jtfCompanyName;
    private javax.swing.JTextField jtfContactNo;
    private javax.swing.JTextField jtfCreditLimit;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfName;
    // End of variables declaration//GEN-END:variables
}
