/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import DAO.*;
import Issue.Issueforstudent;

/**
 *
 * @author Soi Lan Tron
 */
public class BookManage extends javax.swing.JInternalFrame {

    /**
     * Creates new form BM
     */
    public BookManage() {
        initComponents();
        loadBooks();
        randomID();
//        jLabel8.setText("Welcome"  +LoginAdmin.uname);
    }

//    PreparedStatement pstmt;
//    Connection con;
//
//    // bồn nước     // bon nuoc
//    ResultSet rs;
    DefaultTableModel dtm;

    private void randomID() {
        // creading a random number method
        Random rand = new Random();
        int n = rand.nextInt(10000) + 1;
        String val = String.valueOf(n);
//        String ra=("ISBN" + val);
        // invoiceno in jtextField to display random number
        txtISBN.setText("ISBN" + val);
//        System.out.println(ra);

    }

    private void createTableBook() {
        dtm = new DefaultTableModel();
        dtm.addColumn("Call Number");
        dtm.addColumn("ISBN");
        dtm.addColumn("Book Title");
        dtm.addColumn("Author Name");

        tblBook.setModel(dtm);
    }

    private void clearControls() {
        txtCall.setText("");
        txtISBN.setText("");
        txtTitle.setText("");
        txtAuthor.setText("");
    }

    private void loadBooks() {
        try {
            createTableBook();
            obj.setConnection();

            obj.pstmt = obj.conn.prepareStatement("SELECT * FROM BOOK");

            // select thi excutequeries
            // update - delete thi excuteupdate
            obj.rs = obj.pstmt.executeQuery();
            while (obj.rs.next()) {
                // muon do du lieu len jTable thi dung Vector OR mang 2 chieu
                Vector v = new Vector();
                v.add(0, obj.rs.getString(1));
                v.add(1, obj.rs.getString(2));
                v.add(2, obj.rs.getString(3));
                v.add(3, obj.rs.getString(4));

                dtm.addRow(v);

            }

        } catch (SQLException ex) {
            Logger.getLogger(BookManage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    private void BindingControl(java.awt.event.MouseEvent evt) {
//        try {
//            setConnection();
//            pstmt = con.prepareStatement("SELECT * FROM Book");
//            rs = pstmt.executeQuery();
//            if (rs.next()) {
//                int row = tblBook.getSelectedRow();
//                txtCall.setText(tblBook.getValueAt(row, 0).toString());
//                txtISBN.setText(tblBook.getValueAt(row, 1).toString());
//                txtTitle.setText(tblBook.getValueAt(row, 2).toString());
//                txtAuthor.setText(tblBook.getValueAt(row, 3).toString());
//            }
//            // TODO add your handling code here:
//        } catch (SQLException ex) {
//            Logger.getLogger(BookManage.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    // tạo doi tuong ket noi
//    private void setConnection() {
//        try {
//            // Load va dang ky Driver (sql server)
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            // Thiet lap ket noi
//            con = DriverManager.getConnection("jdbc:sqlserver://localhost;database=LibDB", "sa", "123");
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(BookManage.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(BookManage.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
    ConnectToSqlServer obj = new ConnectToSqlServer();

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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCall = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtISBN = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAuthor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        btnNew = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBook = new javax.swing.JTable();
        txtSearchByTitle = new javax.swing.JTextField();
        btnFilter = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnISS = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Book Management System");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(251, 251, 251))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 51, 153));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Add New Book\n"));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel2.setText("Call Number");

        txtCall.setEditable(false);

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel3.setText("ISBN");

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel4.setText("Title");

        txtAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAuthorActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel5.setText("Author");

        btnNew.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCall)
            .addComponent(txtISBN)
            .addComponent(txtTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
            .addComponent(txtAuthor)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnNew)
                .addGap(40, 40, 40)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelete)
                .addGap(44, 44, 44))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtCall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addGap(0, 27, Short.MAX_VALUE))
        );

        tblBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBookMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBook);

        txtSearchByTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchByTitleKeyReleased(evt);
            }
        });

        btnFilter.setText("Filter");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Search book");

        btnISS.setText("Issue Book for student");
        btnISS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnISSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtSearchByTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnFilter))
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(btnISS)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearchByTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFilter))
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnISS)))
                .addGap(178, 178, 178))
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAuthorActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        if (txtTitle.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Title is required");
            txtISBN.requestFocus();
            return;
        } else if (txtAuthor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Author is required");
            txtAuthor.requestFocus();
        } else {
            try {
                obj.setConnection();
                // tAO DOI TUONG THU THI
                obj.pstmt = obj.conn.prepareStatement("INSERT Book VALUES(?, ?, ?)");
                obj.pstmt.setString(1, txtISBN.getText());
                obj.pstmt.setString(2, txtTitle.getText());
                obj.pstmt.setString(3, txtAuthor.getText());

                // Xac nhan co luu hay khong
                if (evt.getSource() == this.btnNew) {
                    int mess = JOptionPane.showConfirmDialog(this, "Are you sure ?", "Add New", JOptionPane.YES_NO_OPTION);

                    if (mess == JOptionPane.YES_OPTION) {

                        // TODO add your handling code here:
                        //Thuc thi va luu ket qua vao database
                        obj.pstmt.executeUpdate();
                        // Hien thi thong bao
                        JOptionPane.showMessageDialog(this, "Add book complete");
                        loadBooks();

                        clearControls();
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(BookManage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            obj.setConnection();
            obj.pstmt = obj.conn.prepareStatement("UPDATE Book SET ISBN=?,Title=?,Author=? WHERE CallNumber=?");
            obj.pstmt.setString(1, txtISBN.getText());
            obj.pstmt.setString(2, txtTitle.getText());
            obj.pstmt.setString(3, txtAuthor.getText());
            obj.pstmt.setString(4, txtCall.getText());

            obj.pstmt.executeUpdate();
            JOptionPane.showConfirmDialog(this, "Update book completed");
            loadBooks();
            clearControls();

            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(BookManage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            obj.setConnection();
            obj.pstmt = obj.conn.prepareStatement("DELETE FROM Book WHERE CallNumber=?");
            obj.pstmt.setString(1, txtCall.getText());

            if (evt.getSource() == this.btnDelete) {
                int mess = JOptionPane.showConfirmDialog(this, "Are you sure ?", "Delete Book", JOptionPane.OK_CANCEL_OPTION);
                if (mess == JOptionPane.OK_OPTION) {
                    //thực thi và lưu kết quả trong DB
                    obj.pstmt.executeUpdate();
                    //Hiển thị thông báo
                    JOptionPane.showMessageDialog(this, "Deleted Book Completed");
                    loadBooks();

                    clearControls();
                }
            }
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(BookManage.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBookMouseClicked
        try {
            obj.setConnection();
            obj.pstmt = obj.conn.prepareStatement("SELECT * FROM Book");
            obj.rs = obj.pstmt.executeQuery();
            if (obj.rs.next()) {
                int row = tblBook.getSelectedRow();
                txtCall.setText(tblBook.getValueAt(row, 0).toString());
                txtISBN.setText(tblBook.getValueAt(row, 1).toString());
                txtTitle.setText(tblBook.getValueAt(row, 2).toString());
                txtAuthor.setText(tblBook.getValueAt(row, 3).toString());
            }
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(BookManage.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tblBookMouseClicked

    private void txtSearchByTitleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchByTitleKeyReleased
        try {
            DAO.bookAccess.searchByTitle(txtSearchByTitle.getText());
            createTableBook();
            while (DAO.bookAccess.crs.next()) {
                Vector v = new Vector();
                v.add(0, DAO.bookAccess.crs.getString("CallNumber"));
                v.add(1, DAO.bookAccess.crs.getString("ISBN"));
                v.add(2, DAO.bookAccess.crs.getString("Title"));
                v.add(3, DAO.bookAccess.crs.getString("Author"));
                dtm.addRow(v);
            }
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(BookManage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtSearchByTitleKeyReleased

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        obj.setConnection();
        try {
//            DAO.bookAccess.searchByTitle(txtSearchByTitle.getText());
            createTableBook();
            obj.pstmt = obj.conn.prepareStatement("SELECT * FROM BOOK WHERE Title like '%" + txtSearchByTitle.getText() + "%'");

            obj.rs = obj.pstmt.executeQuery();
            while (obj.rs.next()) {
                Vector v = new Vector();
                v.add(0, obj.rs.getString("CallNumber"));
                v.add(1, obj.rs.getString("ISBN"));
                v.add(2, obj.rs.getString("Title"));
                v.add(3, obj.rs.getString("Author"));
                dtm.addRow(v);

//                obj.pstmt.executeQuery();
                //Hiển thị thông báo
                JOptionPane.showMessageDialog(this, "search Book Completed");
                loadBooks();
                clearControls();
            }
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(BookManage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFilterActionPerformed

    private void btnISSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnISSActionPerformed

        this.dispose();

        
        Issue.Issueforstudent iss = new Issueforstudent();
        iss.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnISSActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnISS;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBook;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtCall;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtSearchByTitle;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
