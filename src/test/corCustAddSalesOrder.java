/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import adt.*;
import entity.*;

/**
 *
 * @author ASUS
 */
public class corCustAddSalesOrder extends javax.swing.JFrame {

    customerInt<CorporateCustomer> corCust = new LinkedCustomer();
    customerInt<Customer> cust = new LinkedCustomer();
    staffInt<Staff> staffList = new LinkedStaff();
    ProductListInterface<Product> productList = new ProductLList<>();
    PromoListInterface<Promotion> promoList = new PromoLList<>();
    OrderInterface<Delivery> orderList = new OrderLList<>();
    OrderInterface<PickUp> pickUpList = new OrderLList<>();
    OrderInterface<SalesOrder> salesOrderList = new OrderLList<>();
    
    CorporateCustomer currentCorCust = new CorporateCustomer();
    
    public OrderInterface<SalesOrder> list = new OrderLList<>();
    /**
     * Creates new form StaffDeleteProduct
     */
    public corCustAddSalesOrder() {
        initComponents();
        StoreTable();
        retrieveProdID();
        incrementID();
    }
    
    public corCustAddSalesOrder(CorporateCustomer currentCorCust,
                                customerInt<Customer> cust,
                                customerInt<CorporateCustomer> corCust,
                                staffInt<Staff> staffList,
                                ProductListInterface<Product> productList,
                                PromoListInterface<Promotion> promoList,
                                OrderInterface<Delivery> orderList,
                                OrderInterface<PickUp> pickUpList,
                                OrderInterface<SalesOrder> salesOrderList){
        this.currentCorCust = currentCorCust;
        this.cust = cust;
        this.corCust = corCust;
        this.staffList = staffList;
        this.productList = productList;
        this.promoList = promoList;
        this.orderList = orderList;
        this.pickUpList = pickUpList;
        this.salesOrderList = salesOrderList;
        initComponents();
        StoreTable();
        retrieveProdID();
        incrementID();
    }
    
    private void incrementID(){
        jtfID.setText("OR" + String.format("%03d",orderList.getNumberOfEntries()+1));
    }
    
    public void retrieveProdID(){
       
        for(int i = 0; i < productList.getNumberOfEntries(); i++){
            String prod = productList.getEntry(i + 1).getId();
            jcbProdID.addItem("" + (prod));
        }
        
    }

    public void StoreTable(){
       DefaultTableModel model = (DefaultTableModel) jtbProduct.getModel();
       //ListInterface<SalesOrder> list = new OrderLList<>();
       Object rowData[] = new Object[6];
       
       for(int i =0;i< productList.getNumberOfEntries();i++){
           rowData[0] = productList.getEntry(i+1).getId();
           rowData[1] = productList.getEntry(i+1).getName();
           rowData[2] = productList.getEntry(i+1).getProductType();
           rowData[3] = productList.getEntry(i+1).getProductDesc();
           rowData[4] = productList.getEntry(i+1).getPrice();
           rowData[5] = productList.getEntry(i+1).getQuantity();
           
           model.addRow(rowData);
    }
}

    private void calculateTotal(){
        for(int i=0; i<productList.getNumberOfEntries(); i++){
            String selectedProdID = jcbProdID.getSelectedItem().toString();
            if(selectedProdID.equals(productList.getEntry(i+1).getId())){
                double price = productList.getEntry(i+1).getPrice();
                double needQty = Double.parseDouble(jtfQuan.getText());
                if(needQty >= 0 && needQty <= productList.getEntry(i+1).getQuantity()){
                    double total = price * needQty;
                    jtfPrice.setText("" + total);
                }else{
                    JOptionPane.showMessageDialog(this,"The quantity you need is exceed the available quantity","Exceed Quantty", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private boolean isEmpty(){
        String str = "";
        
        if(jtaDesc.getText().equals("")){
            str += "\nDescription";
        }
        if(jtfDate.getText().equals("")){
            str += "\nDate";
        }
        if(jtfTime.getText().equals("")){
            str += "\nTime";
        }
        if(jtfQuan.getText().equals("")){
            str += "\nQuantity";
        }
        if(jtfPrice.getText().equals("")){
            str += "\nTotal Price";
        }
        
        if(!str.equals("")){
            JOptionPane.showMessageDialog(this,"The following text field" + str + "\nCannot be blank","Cannot be blank", JOptionPane.WARNING_MESSAGE);
            return true;
        }
        
        return false;
    }

    private boolean isWithinLimit(){
        boolean within = false;
        double remainLimit = currentCorCust.getRemainLimit();
        double totalPrice = Double.parseDouble(jtfPrice.getText());
        CorporateCustomer updatedCorCust = currentCorCust;
        
        if(remainLimit >= totalPrice){
            updatedCorCust.setRemainLimit(remainLimit - totalPrice);
            within = corCust.updateCreditLimit(currentCorCust, updatedCorCust);
            JOptionPane.showMessageDialog(this,"You credit limit still have: " + updatedCorCust.getRemainLimit(),"Remain Limit", JOptionPane.INFORMATION_MESSAGE);
            currentCorCust = updatedCorCust;
        }else{
            JOptionPane.showMessageDialog(this,"The order is exceed your credit limit","Exceed Limit", JOptionPane.WARNING_MESSAGE);
        }
        
        return within;
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
        jLabel1 = new javax.swing.JLabel();
        jbBack = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblStaffID = new javax.swing.JLabel();
        jtfID = new javax.swing.JTextField();
        lblProductID = new javax.swing.JLabel();
        lblProductName = new javax.swing.JLabel();
        jtfDate = new javax.swing.JTextField();
        lblPrice = new javax.swing.JLabel();
        jtfPrice = new javax.swing.JTextField();
        lblQuan = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaDesc = new javax.swing.JTextArea();
        jtfQuan = new javax.swing.JTextField();
        jbtAdd = new javax.swing.JButton();
        lblCatog = new javax.swing.JLabel();
        jtfTime = new javax.swing.JTextField();
        Image = new javax.swing.JLabel();
        jlblRM = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbProdID = new javax.swing.JComboBox<>();
        jbCalculate = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbProduct = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Fiore Flowershop");

        jbBack.setText("Back");
        jbBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbBack)
                .addGap(148, 148, 148)
                .addComponent(jLabel1)
                .addContainerGap(360, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBack))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        lblStaffID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblStaffID.setText("Order ID        :");

        jtfID.setEditable(false);
        jtfID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtfID.setForeground(new java.awt.Color(102, 102, 102));
        jtfID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblProductID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblProductID.setText("Description     :");

        lblProductName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblProductName.setText("Date             :");

        jtfDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtfDate.setForeground(new java.awt.Color(102, 102, 102));
        jtfDate.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblPrice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPrice.setText("Total Price    :");

        jtfPrice.setEditable(false);
        jtfPrice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtfPrice.setForeground(new java.awt.Color(102, 102, 102));
        jtfPrice.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jtfPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPriceActionPerformed(evt);
            }
        });

        lblQuan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblQuan.setText("Quantitie(s)   :");

        jtaDesc.setColumns(20);
        jtaDesc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtaDesc.setForeground(new java.awt.Color(102, 102, 102));
        jtaDesc.setRows(5);
        jScrollPane2.setViewportView(jtaDesc);

        jtfQuan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtfQuan.setForeground(new java.awt.Color(102, 102, 102));
        jtfQuan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jtfQuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfQuanActionPerformed(evt);
            }
        });

        jbtAdd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtAdd.setText("Add Sales Order");
        jbtAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAddActionPerformed(evt);
            }
        });

        lblCatog.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCatog.setText("Time            :");

        jtfTime.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtfTime.setForeground(new java.awt.Color(102, 102, 102));

        jlblRM.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlblRM.setText("RM");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Product ID     :");

        jbCalculate.setText("Calculate Total");
        jbCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCalculateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblPrice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlblRM)
                        .addGap(3, 3, 3)
                        .addComponent(jtfPrice))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProductID)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblProductName)
                                .addGap(18, 18, 18)
                                .addComponent(jtfDate, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Image, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblCatog)
                                .addGap(18, 18, 18)
                                .addComponent(jtfTime, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jbtAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jcbProdID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(lblStaffID)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblQuan)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbCalculate)
                                    .addComponent(jtfQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStaffID)
                    .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbProdID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblProductID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductName)
                    .addComponent(jtfDate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCatog)
                    .addComponent(jtfTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuan)
                    .addComponent(jtfQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbCalculate)
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrice)
                    .addComponent(jtfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblRM))
                .addGap(39, 39, 39)
                .addComponent(jbtAdd)
                .addGap(58, 58, 58)
                .addComponent(Image, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 102));
        jPanel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jtbProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Product Type", "Description", "Price(RM)", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtbProduct);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addGap(223, 223, 223))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPriceActionPerformed

    private void jtfQuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfQuanActionPerformed
        // TODO add your handling code here:
        calculateTotal();
    }//GEN-LAST:event_jtfQuanActionPerformed

    private void jbtAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAddActionPerformed
        if(!isEmpty()){
            int yesno = JOptionPane.showConfirmDialog(null, "Do you want to add the sales order?", "ARE YOU SURE???", JOptionPane.YES_NO_OPTION);
            if(yesno == JOptionPane.YES_OPTION){
                if(isWithinLimit()){
                    SalesOrder nlist = new SalesOrder(jtfID.getText(), jtaDesc.getText(), jtfDate.getText(), jtfTime.getText(), Integer.parseInt(jtfQuan.getText()), Double.parseDouble(jtfPrice.getText()), "Unpaid",currentCorCust); 
                    salesOrderList.add(nlist);
                    incrementID();
                    for(int i=0; i < salesOrderList.getNumberOfEntries(); i++){
                        String s = "\nOrder ID: "+ salesOrderList.getEntry(i+1).getId()+ "\nDescription: "+ salesOrderList.getEntry(i+1).getDesc()+ "\nDate: "+ salesOrderList.getEntry(i+1).getDate()+ "\nTime: "+ salesOrderList.getEntry(i+1).getTime()+ "\nQuantity: "+ salesOrderList.getEntry(i+1).getQuantity()+ "\nTotal Price(RM): "+ salesOrderList.getEntry(i+1).getPrice()+ "\n";
                        JOptionPane.showMessageDialog(null, s, "HELLO WORLD!", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                }
            }
        }
    }//GEN-LAST:event_jbtAddActionPerformed

    private void jbBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBackActionPerformed
        // TODO add your handling code here:
        new CorporateCustomerHomepage(currentCorCust, cust, corCust, staffList, productList, promoList,orderList,pickUpList,salesOrderList).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jbBackActionPerformed

    private void jbCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCalculateActionPerformed
        // TODO add your handling code here:
        calculateTotal();
    }//GEN-LAST:event_jbCalculateActionPerformed

    
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
            java.util.logging.Logger.getLogger(corCustAddSalesOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(corCustAddSalesOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(corCustAddSalesOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(corCustAddSalesOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new corCustAddSalesOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbBack;
    private javax.swing.JButton jbCalculate;
    private javax.swing.JButton jbtAdd;
    private javax.swing.JComboBox<String> jcbProdID;
    private javax.swing.JLabel jlblRM;
    private javax.swing.JTextArea jtaDesc;
    private javax.swing.JTable jtbProduct;
    private javax.swing.JTextField jtfDate;
    private javax.swing.JTextField jtfID;
    private javax.swing.JTextField jtfPrice;
    private javax.swing.JTextField jtfQuan;
    private javax.swing.JTextField jtfTime;
    private javax.swing.JLabel lblCatog;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblProductID;
    private javax.swing.JLabel lblProductName;
    private javax.swing.JLabel lblQuan;
    private javax.swing.JLabel lblStaffID;
    // End of variables declaration//GEN-END:variables
}
