/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import adt.LList;
import adt.ListInterface;
import entity.Order;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jitpe
 */
public class CancelOrder extends javax.swing.JFrame {
    public ListInterface<Order> list = new LList<>();
    
    /**
     * Creates new form AddOrder
     */
    public CancelOrder() {
        initComponents();
        addRowToTable();
    }

//    public class Order{
//        public String id;
//        public String name;
//        public String desc;
//        public double price;
//        public String orderType;
//        public String flowerType;
//    
//        public Order(String id, String name, String desc, double price, String orderType, String flowerType){
//            this.id = id;
//            this.name = name;
//            this.desc = desc;
//            this.price = price;
//            this.orderType = orderType;
//            this.flowerType = flowerType;
//        }
//    }
    
    public ListInterface OrderList(){
        //ListInterface<Order> list = new LList<>();
        Order o1 = new Order("FR0000", "Orchid", "Very beautiful flower", 6.05, "Delivery", "bouquet");
        Order o2 = new Order("FA0001", "Rose", "very romantic", 30.25, "Pickup", "floral arrangement");
        Order o3 = new Order("FB0002", "Lily", "Very special flower", 10.95, "Delivery", "fresh flowers");
        Order o4 = new Order("FK0003", "Sunflower", "Very ...", 5.55, "Pickup ", "bouquet");
        //Order o5 = new Order("FB0004", "Dongzhuo", "Sad", 8.65, "set", "flower.jpg");
        //Order o6 = new Order("FA0005", "JackBoon", "Nothing gonna change my love for u", 99.99, "alacart", "flower.jpg");
        
        list.add(o1);
        list.add(o2); 
        list.add(o3);
        list.add(o4);
        //order.add(o5);
        //order.add(o6);
        return list;
    }
    
    public void addRowToTable(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        Object rowData[] = new Object[6];
        
        for(int i=0; i<list.getNumberOfEntries(); i++){
            rowData[0] = list.getEntry(i+1).getId();
            rowData[1] = list.getEntry(i+1).getName();
            rowData[2] = list.getEntry(i+1).getDesc();
            rowData[3] = list.getEntry(i+1).getPrice();
            rowData[4] = list.getEntry(i+1).getOrderType();
            rowData[5] = list.getEntry(i+1).getFlowerType();
            
            model.addRow(rowData);
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
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jbtDelete = new javax.swing.JButton();
        jtfCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jtfID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 0, 204));

        jLabel2.setBackground(new java.awt.Color(255, 152, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Fiore Flowershop");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 0));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Description", "Price(RM)", "Order Type", "Flower Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
        }

        jbtDelete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbtDelete.setText("Delete");
        jbtDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDeleteActionPerformed(evt);
            }
        });

        jtfCancel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtfCancel.setText("Cancel");
        jtfCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(jbtDelete)
                .addGap(97, 97, 97)
                .addComponent(jtfCancel)
                .addContainerGap(192, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 328, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtDelete)
                    .addComponent(jtfCancel))
                .addGap(21, 21, 21))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText(" Select a ID to Cancel the Order");

        jtfID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDeleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        //ListInterface<Order> list = OrderList();
        
        int yes = JOptionPane.showConfirmDialog(null, "Do you want to delete the order?", "TENRYU", JOptionPane.YES_NO_OPTION);
        if(yes == JOptionPane.YES_OPTION){
            for(int i=0; i<list.getNumberOfEntries(); i++){
                if(jtfID.getText().equals(list.getEntry(i+1).getId())){
                    model.removeRow(selectedIndex());
                    //JOptionPane.showMessageDialog(null, "Invalid ID", "ERROR", JOptionPane.ERROR_MESSAGE);
                    //break;
                }
                /*else{
                    JOptionPane.showMessageDialog(null, "Invalid ID", "ERROR", JOptionPane.ERROR_MESSAGE);
                    break;
                    //model.removeRow(i);
                }*/
                
            }
        }
        else{
            jtfID.setText("");
        }
    }//GEN-LAST:event_jbtDeleteActionPerformed

    public int selectedIndex(){
        //ListInterface<Order> order = new LList<>();
        int index = -1;
        
        for(int i=0; i<list.getNumberOfEntries(); i++){
            if(jtfID.getText().equals(list.getEntry(i+1).getId())){
                index = i;
            }
        }
        return index;
    }
    
    private void jtfCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCancelActionPerformed

    private void jtfIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfIDActionPerformed

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
            java.util.logging.Logger.getLogger(CancelOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CancelOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CancelOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CancelOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new CancelOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtDelete;
    private javax.swing.JButton jtfCancel;
    private javax.swing.JTextField jtfID;
    // End of variables declaration//GEN-END:variables
}