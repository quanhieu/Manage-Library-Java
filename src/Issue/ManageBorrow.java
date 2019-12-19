/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Issue;

import DAO.ConnectToSqlServer;
import Report.TestReport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author Soi Lan Tron
 */
public class ManageBorrow extends javax.swing.JInternalFrame {

    /**
     * Creates new form MB
     */
    public ManageBorrow() {
        initComponents();
        loadBookBorrow();
        loadDate();
    }
    // them gia tri vao DefaultTableModel bang 2 cach: 1 bang vector --- 2 mang 2 chieu voi Array
    DefaultTableModel dtm;
//    Connection conn;
//    PreparedStatement pstmt;
//    ResultSet rs;

       private void loadDate() {
        // https://stackoverflow.com/questions/4772425/change-date-format-in-a-java-string
        String CurDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
//        String CurDate = new SimpleDateFormat("MMM d,yyyy").format(new Date());
        lblCurDate.setText("" + CurDate);

    }
    private void createTableBorrow() {
        dtm = new DefaultTableModel();
        dtm.addColumn("Student Id");

        dtm.addColumn("Student Name");
        dtm.addColumn("Call Number");

        dtm.addColumn("ISBN");
        dtm.addColumn("Book Title");

        dtm.addColumn("Check out Date");
        dtm.addColumn("Issue Date");
        dtm.addColumn("Due Date");
        dtm.addColumn("Issue Status");

        jTable1.setModel(dtm);

    }

    private void setResizeTable() {
        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
        TableColumn columnID = jTable1.getColumnModel().getColumn(1);
        columnID.setPreferredWidth(80);
        TableColumn columnSName = jTable1.getColumnModel().getColumn(2);
        columnID.setPreferredWidth(100);
        TableColumn columnCNumber = jTable1.getColumnModel().getColumn(3);
        columnID.setPreferredWidth(120);
        TableColumn columnISBN = jTable1.getColumnModel().getColumn(4);
        columnID.setPreferredWidth(120);
        TableColumn columnTitle = jTable1.getColumnModel().getColumn(5);
        columnID.setPreferredWidth(120);
//        TableColumn columnCODate = jTable1.getColumnModel().getColumn(1);
//        columnID.setPreferredWidth(120);
        TableColumn columnIStatus = jTable1.getColumnModel().getColumn(6);
        columnID.setPreferredWidth(120);
        TableColumn columnDDate = jTable1.getColumnModel().getColumn(7);
        columnID.setPreferredWidth(120);
        TableColumn columnIDate = jTable1.getColumnModel().getColumn(8);
        columnID.setPreferredWidth(120);

    }

    private void loadBookBorrow() {
        obj.setConnection();
        try {
            //loai dang ki driver
            createTableBorrow();
            setResizeTable();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // tao doi tuong ket noi
            obj.conn = DriverManager.getConnection("jdbc:sqlserver://localhost;database=LibDB", "sa", "123");
            // tao doi tuong thuc thi
            obj.pstmt = obj.conn.prepareStatement("SELECT * FROM dbo.vStudentBook");
            //thuc thi doi tuong
            // luu ket qua vao doi tuong resultSet
            obj.rs = obj.pstmt.executeQuery();
            // lay recore tu resulset ra
            while (obj.rs.next()) {
                // tao vector de luu tung recore
                Vector v = new Vector();
                // add revore vao dector
                v.add(0, obj.rs.getString(1));
                v.add(1, obj.rs.getString(2));
                v.add(2, obj.rs.getString(3));
                v.add(3, obj.rs.getString(4));
                v.add(4, obj.rs.getString(5));
                v.add(5, obj.rs.getString(6));
                v.add(6, obj.rs.getString(7));
                v.add(7, obj.rs.getString(8));
                v.add(8, obj.rs.getString(9));
                // dua du lieu vao voi tham so ben trong la mot Vector
                dtm.addRow(v);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageBorrow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageBorrow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    ConnectToSqlServer obj = new ConnectToSqlServer();
//    private void setConn() {
//        try {
//            //loai dang ki driver
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            // tao doi tuong ket noi
//            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;database=LibDB", "sa", "123");
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ManageBorrow.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(ManageBorrow.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnReport = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtFromDate = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        txtToDate = new com.toedter.calendar.JDateChooser();
        btnFilter = new javax.swing.JButton();
        lblCurDate = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Report");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(277, 277, 277)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(102, 51, 153));

        btnReport.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnReport.setText("Print");
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("From DueDate");

        txtFromDate.setDateFormatString("dd/MM/yyyy");

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("To DueDate");

        txtToDate.setDateFormatString("dd/MM/yyyy");

        btnFilter.setText("Filter");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        lblCurDate.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lblCurDate.setForeground(new java.awt.Color(255, 255, 255));
        lblCurDate.setText("x");
        lblCurDate.setBorder(null);

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Current Date");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(55, 55, 55)
                        .addComponent(txtFromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtToDate, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnFilter)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(32, 32, 32)
                .addComponent(lblCurDate, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(293, 293, 293))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(297, 297, 297)
                .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurDate)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFromDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnFilter))
                    .addComponent(txtToDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReport)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        String fromDate = new SimpleDateFormat("dd/MM/yyyy").format(txtFromDate.getDate()).toString();
        String toDate = new SimpleDateFormat("dd/MM/yyyy").format(txtToDate.getDate()).toString();
//        String fromDate = new SimpleDateFormat("MMM d,yyyy").format(txtFromDate.getDate()).toString();
//        String toDate = new SimpleDateFormat("MMM d,yyyy").format(txtToDate.getDate()).toString();
        try {

            createTableBorrow();
            obj.setConnection();
            // tao doi tuong thuc thi
            //            pstmt = conn.prepareStatement("SELECT *, CONVERT(varchar(50), [DueDate]) FROM  dbo.vStudentBook WHERE [DueDate] BETWEEN '"+new SimpleDateFormat("dd/MM/yyyy").format(txtFromDate.getDate())
            //                                            +"' AND '"+new SimpleDateFormat("dd/MM/yyyy").format(txtToDate.getDate())+"' ");
            obj.pstmt = obj.conn.prepareStatement("SELECT *, CONVERT(varchar(50), [DueDate]) from vStudentBook where DueDate BETWEEN '" + fromDate + "' AND '" + toDate + "' ");
            //thuc thi doi tuong
            // luu ket qua vao doi tuong resultSet
            obj.rs = obj.pstmt.executeQuery();
            // lay recore tu resulset ra
            while (obj.rs.next()) {
                // tao vector de luu tung recore
                Vector v = new Vector();
                // add revore vao dector
                v.add(0, obj.rs.getString(1));
                v.add(1, obj.rs.getString(2));
                v.add(2, obj.rs.getString(3));
                v.add(3, obj.rs.getString(4));
                v.add(4, obj.rs.getString(5));
                v.add(5, obj.rs.getString(6));
                v.add(6, obj.rs.getString(7));
                v.add(7, obj.rs.getString(8));
                v.add(8, obj.rs.getString(9));
                // dua du lieu vao voi tham so ben trong la mot Vector
                dtm.addRow(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManageBorrow.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnFilterActionPerformed

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed

        try {
            int row = jTable1.getSelectedRow();
            String opt = dtm.getValueAt(row, 0).toString();

            obj.setConnection();
            String sql = "SELECT * FROM vStudentBook WHERE StudentId='" + opt + "'";
            HashMap jparam = new HashMap();
            JasperDesign jdesign = JRXmlLoader.load("src\\Report\\ReportBorrow.jrxml");

            JRDesignQuery jquery = new JRDesignQuery();
            jquery.setText(sql);
            jdesign.setQuery(jquery);
            JasperReport jreport;
            jreport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint = JasperFillManager.fillReport(jreport, jparam, obj.conn);
            //show print
            net.sf.jasperreports.view.JRViewer jrview = new net.sf.jasperreports.view.JRViewer(jprint);
            JFrame jf = new JFrame("Report");
            jf.add(jrview);
            jf.setSize(1200, 1200);
            jf.setLocationRelativeTo(null);
            jf.setVisible(true);
            jf.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);

            // System.out.println(opt);
        } catch (JRException ex) {
            Logger.getLogger(TestReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnReport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCurDate;
    private com.toedter.calendar.JDateChooser txtFromDate;
    private com.toedter.calendar.JDateChooser txtToDate;
    // End of variables declaration//GEN-END:variables
}
