/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import adt.*;
import entity.*;

/**
 *
 * @author user
 */
public class GenerateInvoice extends javax.swing.JFrame {

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
    
    /**
     * Creates new form GenerateInvoice
     */
    public GenerateInvoice() {
        initComponents();
    }

    public GenerateInvoice(Staff currentStaff,
                           customerInt<Customer> cust,
                           customerInt<CorporateCustomer> corCust,
                           staffInt<Staff> staffList,
                           ProductListInterface<Product> productList,
                           PromoListInterface<Promotion> promoList,
                           OrderInterface<Delivery> orderList,
                           OrderInterface<PickUp> pickUpList,
                           OrderInterface<SalesOrder> salesOrderList,
                           ManageOrderInterface<PickUp> manageOrderList,
                           ManageOrderInterface<Delivery> manageDeliveryList) {
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
        clearAll();
        setCorCustID();
    }
    
    private void setCorCustID(){
        for(int i=0;i<corCust.getLength();i++){
            jcbCorCustID.addItem(corCust.getAt(i).getCustID());
        }
    }
    
    private void refreshTable(){
        try{
            DefaultTableModel model = (DefaultTableModel)jtOrder.getModel();
            Object rowData[] = new Object[8];
            double totalPrice = 0;
            double sum = 0;
            model.setRowCount(0);
            
            String selectCorCustID = jcbCorCustID.getSelectedItem().toString();
            String sFromDate = "7/" + selectedMonth() + "/2018";
            String sToDate = "6/" + nextMonth();
            Date fromDate = new SimpleDateFormat("dd/MM/yyyy").parse(sFromDate);
            Date toDate = new SimpleDateFormat("dd/MM/yyyy").parse(sToDate);
            
            for(int i=0;i<salesOrderList.getNumberOfEntries();i++){
                Date orderDate = new SimpleDateFormat("dd/MM/yyyy").parse(salesOrderList.getEntry(i+1).getDate());
                String corCustID = salesOrderList.getEntry(i+1).getCorCust().getCustID();
                
                //orderDate compare the fromDate and toDate
                if(orderDate.compareTo(fromDate) >= 0 && orderDate.compareTo(toDate) <= 0){
                    if(selectCorCustID.equals(corCustID)){
                        totalPrice = (salesOrderList.getEntry(i+1).getQuantity()) * (salesOrderList.getEntry(i+1).getPrice());
                    
                        rowData[0] = salesOrderList.getEntry(i+1).getId();
                        rowData[1] = salesOrderList.getEntry(i+1).getDesc();
                        rowData[2] = corCustID;
                        rowData[3] = salesOrderList.getEntry(i+1).getDate();
                        rowData[4] = salesOrderList.getEntry(i+1).getTime();
                        rowData[5] = salesOrderList.getEntry(i+1).getQuantity();
                        rowData[6] = salesOrderList.getEntry(i+1).getPrice();
                        rowData[7] = totalPrice;
                    
                        sum += totalPrice;
                        model.addRow(rowData);
                    }
                }
            }
            jtfTotalAmount.setText("RM" + String.format("%.2f", sum));
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Date has problem","Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void showCorCustInfo(){
        String selectCorCustID = jcbCorCustID.getSelectedItem().toString();
        
        for(int i=0;i<corCust.getLength();i++){
            String corCustID = corCust.getAt(i).getCustID();
            if(corCustID.equals(selectCorCustID)){
                jtfName.setText(corCust.getAt(i).getCompanyName());
                jtfEmail.setText(corCust.getAt(i).getEmail());
            }
        }
        
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
        jlblCompanyName = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jlblMonth = new javax.swing.JLabel();
        jlblCustID = new javax.swing.JLabel();
        jcbCorCustID = new javax.swing.JComboBox<>();
        jcbMonth = new javax.swing.JComboBox<>();
        jlblCorporateCustName = new javax.swing.JLabel();
        jtfName = new javax.swing.JTextField();
        jlblEmail = new javax.swing.JLabel();
        jlblInvoice = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtOrder = new javax.swing.JTable();
        jlblTotalAmount = new javax.swing.JLabel();
        jtfTotalAmount = new javax.swing.JTextField();
        jbGenerate = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();
        jbBack = new javax.swing.JButton();
        jtfEmail = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 255));

        jlblCompanyName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlblCompanyName.setText("Fiore FlowerShop");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(288, Short.MAX_VALUE)
                .addComponent(jlblCompanyName)
                .addGap(278, 278, 278))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jlblCompanyName)
                .addGap(29, 29, 29))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 102));

        jlblMonth.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlblMonth.setText("Month:");

        jlblCustID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlblCustID.setText("Corporate Customer ID:");

        jcbCorCustID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jcbCorCustID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCorCustIDActionPerformed(evt);
            }
        });

        jcbMonth.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jcbMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        jcbMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMonthActionPerformed(evt);
            }
        });

        jlblCorporateCustName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlblCorporateCustName.setText("Corporate Customer Name:");

        jtfName.setEditable(false);
        jtfName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jlblEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlblEmail.setText("Corporate Customer Address:");

        jlblInvoice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlblInvoice.setText("Invoice Information");

        jtOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Description", "Cor Cust ID", "Date", "Time", "Quantity", "Price", "Total Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtOrder);

        jlblTotalAmount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlblTotalAmount.setText("Total Amount:");

        jtfTotalAmount.setEditable(false);
        jtfTotalAmount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jbGenerate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbGenerate.setText("Generate Invoice and Send it");
        jbGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGenerateActionPerformed(evt);
            }
        });

        jbCancel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbCancel.setText("Cancel");
        jbCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelActionPerformed(evt);
            }
        });

        jbBack.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbBack.setText("Back");
        jbBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBackActionPerformed(evt);
            }
        });

        jtfEmail.setEditable(false);
        jtfEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlblTotalAmount)
                        .addGap(18, 18, 18)
                        .addComponent(jtfTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jbBack)
                                .addGap(182, 182, 182)
                                .addComponent(jlblInvoice))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jlblEmail)
                                    .addComponent(jlblCorporateCustName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfName, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(jtfEmail)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jlblCustID)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jcbCorCustID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jlblMonth)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jcbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(100, 100, 100)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(45, 45, 45)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jbGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(jbCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblInvoice)
                    .addComponent(jbBack))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblMonth)
                    .addComponent(jcbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblCustID)
                    .addComponent(jcbCorCustID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblCorporateCustName)
                    .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlblEmail)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblTotalAmount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGenerate)
                    .addComponent(jbCancel))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jcbCorCustIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCorCustIDActionPerformed
        // TODO add your handling code here:
        showCorCustInfo();
        refreshTable();
    }//GEN-LAST:event_jcbCorCustIDActionPerformed

    private void jbGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGenerateActionPerformed
        // TODO add your handling code here:
        clearAll();
        JOptionPane.showMessageDialog(null,"Success generate Invoice and Send it","Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jbGenerateActionPerformed

    private void jcbMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMonthActionPerformed
        // TODO add your handling code here:
        refreshTable();
    }//GEN-LAST:event_jcbMonthActionPerformed

    private void jbCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelActionPerformed
        // TODO add your handling code here:
        clearAll();
    }//GEN-LAST:event_jbCancelActionPerformed

    private void jbBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBackActionPerformed
        // TODO add your handling code here:
        new Homepage(currentStaff, cust, corCust, staffList, productList, promoList,orderList,pickUpList,salesOrderList, manageOrderList, manageDeliveryList).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jbBackActionPerformed
    
    private void clearAll(){
        DefaultTableModel model = (DefaultTableModel)jtOrder.getModel();
        model.setRowCount(0);
        jtfTotalAmount.setText("");
        jtfName.setText("");
        jtfEmail.setText("");
    }
    
    private int selectedMonth(){
        int selectedMonth = 1;
        String month = jcbMonth.getSelectedItem().toString();
        if(month.equals("January")){
            selectedMonth = 1;
        }
        else if(month.equals("February")){
            selectedMonth = 2;
        }
        else if(month.equals("March")){
            selectedMonth = 3;
        }
        else if(month.equals("April")){
            selectedMonth = 4;
        }
        else if(month.equals("May")){
            selectedMonth = 5;
        }
        else if(month.equals("June")){
            selectedMonth = 6;
        }
        else if(month.equals("July")){
            selectedMonth = 7;
        }
        else if(month.equals("August")){
            selectedMonth = 8;
        }
        else if(month.equals("September")){
            selectedMonth = 9;
        }
        else if(month.equals("October")){
            selectedMonth = 10;
        }
        else if(month.equals("November")){
            selectedMonth = 11;
        }
        else if(month.equals("December")){
            selectedMonth = 12;
        }
        return selectedMonth;
    }
    
    private String nextMonth(){
        String month = "1/2018";
        int getMonth = selectedMonth();
        if(getMonth == 1 || getMonth == 2 || getMonth == 3 || getMonth == 4 || getMonth == 5 || getMonth == 6 ||
           getMonth == 7 || getMonth == 8 || getMonth == 9 || getMonth == 11){
            getMonth = getMonth + 1;
            month = getMonth + "/2018";
        }else if(getMonth == 12){
            month = "1/2019";
        }
        return month;
    }
    
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
            java.util.logging.Logger.getLogger(GenerateInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerateInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerateInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerateInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenerateInvoice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbBack;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbGenerate;
    private javax.swing.JComboBox<String> jcbCorCustID;
    private javax.swing.JComboBox<String> jcbMonth;
    private javax.swing.JLabel jlblCompanyName;
    private javax.swing.JLabel jlblCorporateCustName;
    private javax.swing.JLabel jlblCustID;
    private javax.swing.JLabel jlblEmail;
    private javax.swing.JLabel jlblInvoice;
    private javax.swing.JLabel jlblMonth;
    private javax.swing.JLabel jlblTotalAmount;
    private javax.swing.JTable jtOrder;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfName;
    private javax.swing.JTextField jtfTotalAmount;
    // End of variables declaration//GEN-END:variables
}
