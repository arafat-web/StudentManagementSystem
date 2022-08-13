package student.information.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ManageStudents extends javax.swing.JFrame {

    /**
     * Creates new form ManageData
     */
    ViewCourse viewCourse = new ViewCourse();

    public ManageStudents() {
        initComponents();
        jtableCustom();
        try {
            updateSelected();
            fetchDept();
        } catch (SQLException ex) {
            Logger.getLogger(ManageStudents.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/edit_profile_64px.png")));

        } catch (Exception ex) {
            System.out.println(ex);
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
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DataTable = new javax.swing.JTable();
        search = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        deleteButton = new keeptoo.KButton();
        deptOption = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manage Data");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edit_profile_64px_white.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Manage Data");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(947, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        DataTable.setBorder(new javax.swing.border.MatteBorder(null));
        DataTable.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        DataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Phone", "Session", "Department", "Date of Birth", "Gender", "Address", "Completed Course", "Incomplete Course", "Total Bill", "Total Paid", "Total Due"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DataTable.setFillsViewportHeight(true);
        DataTable.setGridColor(new java.awt.Color(0, 0, 0));
        DataTable.setShowHorizontalLines(true);
        DataTable.setShowVerticalLines(true);
        DataTable.getTableHeader().setReorderingAllowed(false);
        DataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DataTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DataTable);
        if (DataTable.getColumnModel().getColumnCount() > 0) {
            DataTable.getColumnModel().getColumn(0).setMinWidth(1);
            DataTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            DataTable.getColumnModel().getColumn(0).setMaxWidth(100);
            DataTable.getColumnModel().getColumn(1).setResizable(false);
            DataTable.getColumnModel().getColumn(1).setPreferredWidth(120);
            DataTable.getColumnModel().getColumn(4).setPreferredWidth(120);
            DataTable.getColumnModel().getColumn(7).setPreferredWidth(180);
        }

        search.setBackground(new java.awt.Color(255, 255, 255));
        search.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        search.setForeground(new java.awt.Color(0, 0, 0));
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchKeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("Search");

        deleteButton.setText("Delete");
        deleteButton.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        deleteButton.setkHoverColor(new java.awt.Color(153, 153, 153));
        deleteButton.setkHoverEndColor(java.awt.Color.red);
        deleteButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        deleteButton.setkHoverStartColor(new java.awt.Color(255, 102, 0));
        deleteButton.setkStartColor(java.awt.Color.red);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        deptOption.setBackground(new java.awt.Color(255, 255, 255));
        deptOption.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        deptOption.setForeground(new java.awt.Color(0, 0, 0));
        deptOption.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        deptOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptOptionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(deptOption, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, Short.MAX_VALUE)
                            .addComponent(deptOption, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(search))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_searchActionPerformed
//    deptOption.addActionListener(new ActionListener(){
//        public void actionPerformed(ActionEvent e){
//            
//        }
//    });

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        deleteData();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_searchKeyTyped

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        try {
            // TODO add your handling code here:

            searchStudent();
        } catch (SQLException ex) {
            Logger.getLogger(ManageStudents.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchKeyReleased

    private void deptOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deptOptionActionPerformed
        // TODO add your handling code here:

        updateSelected();

    }//GEN-LAST:event_deptOptionActionPerformed

    private void DataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataTableMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            DefaultTableModel model = (DefaultTableModel) DataTable.getModel();
            int selectedRowIndex = DataTable.getSelectedRow();

            String completedCourse = model.getValueAt(selectedRowIndex, 8).toString()
                    .replace(",", "<br>");
            String incompletedCourse = model.getValueAt(selectedRowIndex, 9).toString()
                    .replace(",", "<br>");

            viewCourse.viewdata.setText(
                    "  <table width=100% border=1>\n"
                    + " <tr>\n"
                    + "    <td><big><b>Name</b></big></td>\n"
                    + "    <td><big><b>Department</b></big></td>\n"
                    + "  </tr>\n"
                    + "    \n"
                    + "      <tr>\n"
                    + "    <td><big>" + model.getValueAt(selectedRowIndex, 1).toString() + "</big></td>\n"
                    + "    <td><big>" + model.getValueAt(selectedRowIndex, 4).toString() + "</big></td>\n"
                    + "  </tr>\n"
                    + "    \n"
                    + "      <tr>\n"
                    + "    <td><big><b>Completed Course</b></big></td>\n"
                    + "    <td><big><b>Incompleted Course</b></big></td>\n"
                    + "  </tr>\n"
                    + "    \n"
                    + "      <tr>\n"
                    + "    <td><big>" + completedCourse + "</big></td>\n"
                    + "    <td><big>" + incompletedCourse + "</big></td>\n"
                    + "  </tr>\n"
                    + "   \n"
                    + "</table>"
            );
            viewCourse.setVisible(true);
        }

    }//GEN-LAST:event_DataTableMouseClicked

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
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DataTable;
    private keeptoo.KButton deleteButton;
    private javax.swing.JComboBox<String> deptOption;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
    public void updateTable(String name) throws SQLException {

        Connection conn = DatabaseConnection.ConnectDb();
        String url = "";
        if (name.equals("All")) {
            url = "Select id, name, phone, session, dept, dob, gender, address, completedcourse, incompletecourse, totalbill, totalpaid, totaldue from studentsdata";
        } else {
            url = "Select id, name, phone, session, dept, dob, gender, address, completedcourse, incompletecourse, totalbill, totalpaid, totaldue from studentsdata where dept ='" + name + "'";
        }

        try {
            PreparedStatement pstm = conn.prepareStatement(url);
            ResultSet rs = pstm.executeQuery();
            DefaultTableModel model = (DefaultTableModel) DataTable.getModel();
            Object[] colData = new Object[13];
            int rowCount = model.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            while (rs.next()) {
                colData[0] = rs.getString("id");
                colData[1] = rs.getString("name");
                colData[2] = rs.getString("phone");
                colData[3] = rs.getString("session");
                colData[4] = rs.getString("dept");
                colData[5] = rs.getString("dob");
                colData[6] = rs.getString("gender");
                colData[7] = rs.getString("address");
                colData[8] = rs.getString("completedcourse");
                colData[9] = rs.getString("incompletecourse");
                colData[10] = rs.getString("totalbill");
                colData[11] = rs.getString("totalpaid");
                colData[12] = rs.getString("totaldue");
                model.addRow(colData);

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    private void jtableCustom() {

        JTableHeader header = DataTable.getTableHeader();
        header.setBackground(Color.GREEN);
        header.setForeground(Color.BLACK);
        header.setFont(new Font("TOHOMA", Font.BOLD, 18));
        DataTable.setGridColor(Color.LIGHT_GRAY);
        DataTable.setRowHeight(25);

    }

    public void searchStudent() throws SQLException {

        Connection con = DatabaseConnection.ConnectDb();
        PreparedStatement ps;
        updateSelected();
        if (search.getText().equals("")) {
            updateSelected();
        } else {

            ps = con.prepareStatement("SELECT * FROM `studentsdata` WHERE  name LIKE '%" + search.getText() + "%'");

            ResultSet rs = ps.executeQuery();
            DefaultTableModel model = (DefaultTableModel) DataTable.getModel();

            Object[] colData = new Object[13];
            int rowCount = model.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                model.removeRow(i);
            }
            while (rs.next()) {

                colData[0] = rs.getString("id");
                colData[1] = rs.getString("name");
                colData[2] = rs.getString("phone");
                colData[3] = rs.getString("session");
                colData[4] = rs.getString("dept");
                colData[5] = rs.getString("dob");
                colData[6] = rs.getString("gender");
                colData[7] = rs.getString("address");
                colData[8] = rs.getString("completedcourse");
                colData[9] = rs.getString("incompletecourse");
                colData[10] = rs.getString("totalbill");
                colData[11] = rs.getString("totalpaid");
                colData[12] = rs.getString("totaldue");
                model.addRow(colData);
            }

        }
    }

    private void deleteData() {
        DefaultTableModel model = (DefaultTableModel) DataTable.getModel();

        if (DataTable.getSelectedRow() == -1) {

            if (DataTable.getRowCount() == 0) {

                PopUp popUp = new PopUp();
                popUp.setVisible(true);
                popUp.setHeader.setText("Error!");
                popUp.setHeader.setForeground(Color.red);
                popUp.setMsg.setText("No data to delete.");

            } else {
                PopUp popUp = new PopUp();
                popUp.setVisible(true);
                popUp.setHeader.setText("Error!");
                popUp.setHeader.setForeground(Color.red);
                popUp.setMsg.setText("Select a Row to delete.");
            }
        } else {
            int row = DataTable.getSelectedRow();
            String getID = DataTable.getValueAt(row, 0).toString();
            //System.out.println(getroll);
            String sql = "delete from studentsdata where id='" + getID + "'";
            try {

                Connection conn = DatabaseConnection.ConnectDb();
                PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.execute();
                PopUp popUp = new PopUp();
                popUp.setVisible(true);
                popUp.setHeader.setText("Success!");
                popUp.setHeader.setForeground(Color.green);
                popUp.setMsg.setText("Data Deleted!");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            model.removeRow(DataTable.getSelectedRow());
        }
    }

    private void fetchDept() throws SQLException {

        Connection conn = DatabaseConnection.ConnectDb();
        String url = "Select name from deptdata";

        PreparedStatement pstm = conn.prepareStatement(url);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            deptOption.addItem(rs.getString("name"));
        }

    }

    private void updateSelected() {
        if (deptOption.getSelectedItem().equals("All")) {
            try {
                updateTable("All");
            } catch (SQLException ex) {

            }
        } else {
            try {
                String items = deptOption.getSelectedItem().toString();
                updateTable(items);
            } catch (SQLException ex) {

            }
        }
    }
}
