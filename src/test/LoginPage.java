/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.swing.JOptionPane;

import adt.*;
import entity.*;

/**
 *
 * @author user
 */
public class LoginPage extends javax.swing.JFrame {

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
    
    Customer custDetail = new Customer();
    CorporateCustomer corCustDetail = new CorporateCustomer();
    Staff staffDetail = new Staff();
    
    String userName = null;
    /**
     * Creates new form LoginPage
     */
    public LoginPage() {
        initComponents();
        initializeData();
    }
    
    public LoginPage(customerInt<Customer> cust,
                     customerInt<CorporateCustomer> corCust,
                     staffInt<Staff> staffList,
                     ProductListInterface<Product> productList,
                     PromoListInterface<Promotion> promoList,
                     OrderInterface<Delivery> orderList,
                     OrderInterface<PickUp> pickUpList,
                     OrderInterface<SalesOrder> salesOrderList){
        this.cust = cust;
        this.corCust = corCust;
        this.staffList = staffList;
        this.productList = productList;
        this.promoList = promoList;
        this.orderList = orderList;
        this.pickUpList = pickUpList;
        this.salesOrderList = salesOrderList;
        initComponents();
        
    }
    
    private void initializeData(){
        CorporateCustomer YipKinLit = new CorporateCustomer("CR0001","Yip Kin Lit","0167543323","kid","KID001","Kid sdn Bhd",100,"kid@hotmail.com",50);
        CorporateCustomer KeeWoiChen = new CorporateCustomer("CR0002","Kee Woi Chen","0129656667","wawayu","WWY001","Wawayu Sdn Bhd",500,"wawayu@gmail.com",300);
        cust.register(new Customer("CU0001","Chua Dong Zhuo","0192107830","lucky"));
        cust.register(new Customer("CU0002","Jack Soh Boon Keat","0187656564","iampro"));
        corCust.register(YipKinLit);
        corCust.register(KeeWoiChen);
        staffList.addNew(new Staff("OW0001","Lee Mun Kit","Owner","0184680577","lmk123"));
        staffList.addNew(new Staff("ST0002","Lo Jit Peng","Staff","0166633904","ljp123"));
        staffList.addNew(new Staff("ST0003","Chong Chee Bin","Staff","0195035833","ccb123"));
        productList.addProd(new Product("P001","Rose","Fresh Flowers","Collect on current day morning 100% pure and fresh",50.0,5));
        productList.addProd(new Product("P002","Sun Flowers","Fresh Flowers","Collect on current day morning 100% pure and fresh",10.0,2));
        productList.addProd(new Product("P003","Moon Flowers","Fresh Flowers","Collect on current day morning 100% pure and fresh",10.0,2));
        promoList.addPromo(new Promotion("PM001","Lucky November","Fresh Flowers","buy more than 3 items and show to staff at counter to get a free fresh flower"));
        promoList.addPromo(new Promotion("PM002","Lucky Sunday","Fresh Flowers","buy more than 3 items and show to staff at counter to get a free fresh flower"));
        salesOrderList.add(new SalesOrder("SO001", "Tsukiyomi Ryunosuke, testing..", "01/12/2018", "12:30", 4, 25.00, "Unpaid",YipKinLit));
        salesOrderList.add(new SalesOrder("SO002", "Lee Mun Kit, testing..", "12/12/2018", "10:00", 2, 13.00, "Unpaid",KeeWoiChen));
    }
    
    private boolean verifyUser(){
        boolean verify = false;
        String code = (jtfID.getText()).substring(0, 2);
        if(code.equals("CU")){
            verify = verifyCust();
        }
        else if(code.equals("CR")){
            verify = verifyCorCust();
        }
        else if(code.equals("ST")){
            verify = verifyStaff();
        }
        else if(code.equals("OW")){
            verify = verifyOwner();
        }
        
        return verify;
    }
    
    private boolean verifyCorCust(){
        boolean match = false;
        String userId = jtfID.getText();
        String userPassword = jpfPass.getText();
        
        for(int i=0;i<corCust.getLength();i++){
            String id = corCust.getAt(i).getCustID();
            String password = corCust.getAt(i).getPassword();
            double creditLimit = corCust.getAt(i).getCreditLimit();
            
            if(id.equals(userId) && password.equals(userPassword) && creditLimit != -1){
                userName = corCust.getAt(i).getCustName();
                match = true;
                
                corCustDetail = corCust.getAt(i);
            }else if(id.equals(userId) && password.equals(userPassword) && creditLimit == -1){
                JOptionPane.showMessageDialog(this,"The staff not yet approve your registeration","Not approve", JOptionPane.ERROR_MESSAGE);
            }
        }
        return match;
    }
    
    private boolean verifyCust(){
        boolean match = false;
        String userId = jtfID.getText();
        String userPassword = jpfPass.getText();
        
        for(int i=0;i<cust.getLength();i++){
            String id = cust.getAt(i).getCustID();
            String password = cust.getAt(i).getPassword();
            
            if(id.equals(userId) && password.equals(userPassword)){
                userName = cust.getAt(i).getCustName();
                match = true;
                
                custDetail = cust.getAt(i);
            }
        }
        return match;
    }
    
    private boolean verifyStaff(){
        boolean match = false;
        String userId = jtfID.getText();
        String userPassword = jpfPass.getText();
        
        for(int i=0;i<staffList.getLength();i++){
            String id = staffList.getAt(i).getStaffID();
            String password = staffList.getAt(i).getStaffPass();
            
            if(id.equals(userId) && password.equals(userPassword)){
                userName = staffList.getAt(i).getStaffName();
                match = true;
                
                staffDetail = staffList.getAt(i);
            }
        }
        return match;
    }
    
    private boolean verifyOwner(){
        boolean match = false;
        String userId = jtfID.getText();
        String userPassword = jpfPass.getText();
        
        for(int i=0;i<staffList.getLength();i++){
            String id = staffList.getAt(i).getStaffID();
            String password = staffList.getAt(i).getStaffPass();
            
            if(id.equals(userId) && password.equals(userPassword)){
                userName = staffList.getAt(i).getStaffName();
                match = true;
                
                staffDetail = staffList.getAt(i);
            }
        }
        return match;
    }
    
    private void goToNextPage(){
        String code = (jtfID.getText()).substring(0, 2);
        if(code.equals("CU")){
            new CustomerHomepage(custDetail,cust,corCust,staffList,productList,promoList,orderList,pickUpList,salesOrderList).setVisible(true);
        }
        else if(code.equals("CR")){
            new CorporateCustomerHomepage(corCustDetail,cust,corCust,staffList,productList,promoList,orderList,pickUpList,salesOrderList).setVisible(true);
        }
        else if(code.equals("ST")){
            //new Homepage(staffDetail,cust,corCust,staffList,productList,promoList,orderList,pickUpList,salesOrderList).setVisible(true);
        }
        else if(code.equals("OW")){
            new OwnerHomepage(staffDetail,cust,corCust,staffList,productList,promoList,orderList,pickUpList,salesOrderList).setVisible(true);
        }
        this.setVisible(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfID = new javax.swing.JTextField();
        jpfPass = new javax.swing.JPasswordField();
        jbLogin = new javax.swing.JButton();
        jbCust = new javax.swing.JButton();
        jbCorCust = new javax.swing.JButton();
        jlblSignIn = new javax.swing.JLabel();
        jlblSignUp = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ID:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Password:");

        jtfID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jpfPass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jpfPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpfPassActionPerformed(evt);
            }
        });

        jbLogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbLogin.setText("Login");
        jbLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLoginActionPerformed(evt);
            }
        });

        jbCust.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbCust.setText("Customer");
        jbCust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCustActionPerformed(evt);
            }
        });

        jbCorCust.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbCorCust.setText("Corporate Customer");
        jbCorCust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCorCustActionPerformed(evt);
            }
        });

        jlblSignIn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlblSignIn.setText("Sign In");

        jlblSignUp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblSignUp.setText("or Sign Up as");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(355, 355, 355)
                        .addComponent(jlblSignIn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(337, 337, 337)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblSignUp)
                            .addComponent(jbLogin)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfID, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                                    .addComponent(jpfPass)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbCust, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                                .addComponent(jbCorCust, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jlblSignIn)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jpfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jbLogin)
                .addGap(43, 43, 43)
                .addComponent(jlblSignUp)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCust, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCorCust, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(165, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLoginActionPerformed
        // TODO add your handling code here:
        if(verifyUser()){
            JOptionPane.showMessageDialog(this,"Welcome " + userName,"Login" , JOptionPane.INFORMATION_MESSAGE);
            goToNextPage();
        }
        else{
            JOptionPane.showMessageDialog(this,"Maybe your id or passwrod is incorrect","Cannot Login", JOptionPane.WARNING_MESSAGE);
            jpfPass.setText("");
            jpfPass.grabFocus();
        }
    }//GEN-LAST:event_jbLoginActionPerformed

    private void jbCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCustActionPerformed
        // TODO add your handling code here:
        new CustomerRegistration(cust, corCust, staffList, productList, promoList,orderList,pickUpList,salesOrderList).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jbCustActionPerformed

    private void jbCorCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCorCustActionPerformed
        // TODO add your handling code here:
        new CorporateCustomerRegistration(cust, corCust, staffList, productList, promoList,orderList,pickUpList,salesOrderList).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jbCorCustActionPerformed

    private void jpfPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpfPassActionPerformed
        // TODO add your handling code here:
        if(verifyUser()){
            JOptionPane.showMessageDialog(this,"Welcome " + userName,"Login" , JOptionPane.INFORMATION_MESSAGE);
            goToNextPage();
        }
        else{
            JOptionPane.showMessageDialog(this,"Maybe your id or passwrod is incorrect","Cannot Login", JOptionPane.WARNING_MESSAGE);
            jpfPass.setText("");
            jpfPass.grabFocus();
        }
    }//GEN-LAST:event_jpfPassActionPerformed

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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbCorCust;
    private javax.swing.JButton jbCust;
    private javax.swing.JButton jbLogin;
    private javax.swing.JLabel jlblSignIn;
    private javax.swing.JLabel jlblSignUp;
    private javax.swing.JPasswordField jpfPass;
    private javax.swing.JTextField jtfID;
    // End of variables declaration//GEN-END:variables
}
