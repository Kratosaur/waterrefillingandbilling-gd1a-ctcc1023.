import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class Water extends javax.swing.JFrame {


    public Connection connection;
    static final String user = "root";
    static final String pass = "";
    public static int cost;
    PreparedStatement pst;
    Statement st;
    ResultSet rs;

    
    public Water() {
        initComponents();
        Connection();
        
    }
    
    public void Connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/casestudy", user, pass);
            System.out.println("Connection Established");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void calculateChange() {
        try {
            int quantity = Integer.parseInt(txtQuantity.getText());
            int cashing = Integer.parseInt(txtCash.getText());
            int total = quantity * cost;
            int rpt = cashing - total;
            
            if (cashing >= total){
                String sql = "INSERT INTO items (quantity, cost, cashing, rpt) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, quantity);
            statement.setInt(2, total);
            statement.setInt(3, cashing);
            statement.setInt(4, rpt);
            statement.executeUpdate();
            Walangalaman.setText(String.valueOf(rpt));
            
            }else{
                Walangalaman.setText("invalid");
            }

            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTable() {
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM items");

            DefaultTableModel Cart = (DefaultTableModel) Table.getModel();
            Cart.setRowCount(0);

            int row = rs.getRow();

            while (rs.next()) {

                Object o[] = {rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)};
                Cart.addRow(o);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public void emptyTable() {
        txtQuantity.setText("");
        txtCash.setText("");
        Walangalaman.setText("");
        try {
            st = connection.createStatement();
            String query = "DELETE FROM items";
            int deletedRows = st.executeUpdate(query);

            if (deletedRows > 0) {
                System.out.println("Deleted All Rows In The Table Successfully...");
            } else {
                System.out.println("Table already empty.");
            }
        } catch (SQLException s) {
            System.out.println("Deleted All Rows In  Table Error. ");
            s.printStackTrace();
        }
    }
        
public void emptyText() {
    txtQuantity.setText("");
        txtCash.setText("");
        Walangalaman.setText("");

}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        checkbox1 = new java.awt.Checkbox();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblCash = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        Bottle3 = new javax.swing.JButton();
        Bottle1 = new javax.swing.JButton();
        Bottle2 = new javax.swing.JButton();
        txtCash = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Walangalaman = new javax.swing.JLabel();
        btnCalcu1 = new javax.swing.JButton();
        Change = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255), 4));

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Baskerville Old Face", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("AquaLaguna");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(227, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(212, 212, 212))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        checkbox1.setLabel("checkbox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255), 5));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255), 4));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCash.setFont(new java.awt.Font("Wide Latin", 2, 10)); // NOI18N
        lblCash.setText("Cash:");
        jPanel3.add(lblCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 60, 30));

        lblQuantity.setFont(new java.awt.Font("Wide Latin", 2, 10)); // NOI18N
        lblQuantity.setText("Quantity:");
        jPanel3.add(lblQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 80, 30));

        Bottle3.setBackground(new java.awt.Color(0, 204, 204));
        Bottle3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/output-onlinepngtools.png"))); // NOI18N
        Bottle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bottle3ActionPerformed(evt);
            }
        });
        jPanel3.add(Bottle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, -1));

        Bottle1.setBackground(new java.awt.Color(0, 204, 204));
        Bottle1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/output-onlinepngtools.png"))); // NOI18N
        Bottle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bottle1ActionPerformed(evt);
            }
        });
        jPanel3.add(Bottle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        Bottle2.setBackground(new java.awt.Color(0, 204, 204));
        Bottle2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/output-onlinepngtools.png"))); // NOI18N
        Bottle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bottle2ActionPerformed(evt);
            }
        });
        jPanel3.add(Bottle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, -1));

        txtCash.setEditable(false);
        txtCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCashActionPerformed(evt);
            }
        });
        jPanel3.add(txtCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 100, 30));

        txtQuantity.setEditable(false);
        jPanel3.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 100, 30));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255), 4));

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Baskerville Old Face", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("AquaLaguna");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 230, 40));

        btnClear.setFont(new java.awt.Font("Wide Latin", 1, 14)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel3.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 160, 40));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jLabel1.setText("$150");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, -1, -1));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jLabel2.setText("$75");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, -1));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jLabel8.setText("750 ml.");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, -1));

        Walangalaman.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jPanel3.add(Walangalaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 60, 30));

        btnCalcu1.setFont(new java.awt.Font("Wide Latin", 1, 14)); // NOI18N
        btnCalcu1.setText("Calculate");
        btnCalcu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcu1ActionPerformed(evt);
            }
        });
        jPanel3.add(btnCalcu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 160, 40));

        Change.setFont(new java.awt.Font("Wide Latin", 2, 12)); // NOI18N
        Change.setText("Change");
        jPanel3.add(Change, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 80, 20));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jLabel4.setText("500 ml.");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jLabel6.setText("$20");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jLabel10.setText("1 gallon");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 360, 370));

        jPanel6.setBackground(new java.awt.Color(0, 204, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255), 4));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Table.setBackground(new java.awt.Color(153, 255, 255));
        Table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 204, 255)));
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Quantity", "Total", "Cash", "Receipt"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 430, 310));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255), 4));

        jLabel9.setBackground(new java.awt.Color(204, 204, 204));
        jLabel9.setFont(new java.awt.Font("Baskerville Old Face", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("AquaLaguna");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 230, 40));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 450, 370));

        jPanel9.setBackground(new java.awt.Color(0, 204, 204));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255), 4));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255), 4));

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Baskerville Old Face", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("AquaLaguna");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 240, 40));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 830, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Bottle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bottle3ActionPerformed
        cost = 150;
        txtQuantity.setEditable(true);
        txtCash.setEditable(true);
    }//GEN-LAST:event_Bottle3ActionPerformed

    private void Bottle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bottle1ActionPerformed
        cost = 20;
         txtQuantity.setEditable(true);
        txtCash.setEditable(true);
    }//GEN-LAST:event_Bottle1ActionPerformed

    private void Bottle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bottle2ActionPerformed
        cost = 75;
         txtQuantity.setEditable(true);
        txtCash.setEditable(true);
    }//GEN-LAST:event_Bottle2ActionPerformed

    private void txtCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCashActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCashActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        emptyText();
        updateTable();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnCalcu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcu1ActionPerformed
         calculateChange(); 
        updateTable();
    }//GEN-LAST:event_btnCalcu1ActionPerformed

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
            java.util.logging.Logger.getLogger(Water.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Water.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Water.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Water.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Water().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bottle1;
    private javax.swing.JButton Bottle2;
    private javax.swing.JButton Bottle3;
    private javax.swing.JLabel Change;
    private javax.swing.JTable Table;
    private javax.swing.JLabel Walangalaman;
    private javax.swing.JButton btnCalcu1;
    private javax.swing.JButton btnClear;
    private java.awt.Checkbox checkbox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCash;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JTextField txtCash;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
