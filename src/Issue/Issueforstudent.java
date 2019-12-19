/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Issue;

import DAO.ConnectToSqlServer;
import GUI.LoginForm;
import GUI.StudentManage;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Windows 10 TIMT
 */
public class Issueforstudent extends javax.swing.JFrame {

    /**
     * Creates new form is
     */
    public Issueforstudent() {
        initComponents();
           loadCombobox();

//        loadTableStudents();

        loadBooks();

        loadDate();

        loadTableIssue();
        
        loadStudentName();

    }
//    PreparedStatement pstmt;
//    Connection conn;
//    ResultSet rs;
    DefaultComboBoxModel dcm;
    DefaultTableModel dtm;

    private void loadDate() {
        // https://stackoverflow.com/questions/4772425/change-date-format-in-a-java-string
//        String CurDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
//        String CurDate = new SimpleDateFormat("MMM d,yyyy").format(new Date());
//        lblCurDate.setText("" + CurDate);

        Date date = new Date();
        txtCurDate.setDate(date);

    }
    
    ConnectToSqlServer obj = new ConnectToSqlServer();
//    private void setConnection() {
//
//        try {
//            // load dang ki drive
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            // thiet lap ket noi thong qua lop drive manage = get conection
//            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;database=LibDb", "sa", "123");
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(StudentManage.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(StudentManage.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

    private void loadStudentName(){
                if (LoginForm.stdName != null) {
            txtName.setText(LoginForm.stdName);
        }

    }
    private void loadCombobox() {
        dcm = new DefaultComboBoxModel();
        try {
            obj.setConnection();
            //tao doi tuong thuc thi thong qua lop prepareStatement
            obj.pstmt = obj.conn.prepareStatement("SELECT * FROM major");

            // lay toan bo du lieu trong bang Major luu vao resultSet
            obj.rs = obj.pstmt.executeQuery();
            // luu lan luoc bang phuong thuc next
            while (obj.rs.next()) {
                // sau do lay cot 1 cua resultSet roi add vo  // getString(1)  or 2 deu dc
                dcm.addElement(obj.rs.getString(1));
                cbxMajor.setModel(dcm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Issueforstudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//
//    private void loadTableStudents() {
//        dtm = new DefaultTableModel();
//        dtm.addColumn("StudentId");
//        dtm.addColumn("StudentName");
//        //   dtm.addColumn("Password");
//        dtm.addColumn("Address");
//        dtm.addColumn("PhoneNumber");
//        dtm.addColumn("majorId");
//        // tao bang
//        tblStudent.setModel(dtm);
//        // goi ket noi
//        obj.setConnection();
//        try {
//            // tao doi tuong thuc thi pre
//            obj.pstmt = obj.conn.prepareStatement("SELECT * FROM  Student");
//            // thuc thi
//            obj.rs = obj.pstmt.executeQuery();
//
//            // lay het recore nay den recore khac
//            while (obj.rs.next()) {
//                // bo vo mot Vector
//                Vector v = new Vector();
//                v.add(0, obj.rs.getString(1));
//                v.add(1, obj.rs.getString(2));
//                v.add(2, obj.rs.getString(4));
//                v.add(3, obj.rs.getString(5));
//                v.add(4, obj.rs.getString(6));
//
//                //  day vo Vecotr - moi dong trong vector 
//                dtm.addRow(v);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(StudentManage.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

//    private void createTableStudent() {
//        dtm = new DefaultTableModel();
//        dtm.addColumn("StudentId");
//        dtm.addColumn("StudentName");
//        dtm.addColumn("Address");
//        dtm.addColumn("PhoneNumber");
//        dtm.addColumn("majorId");
//
//        tblStudent.setModel(dtm);
//    }

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
            Logger.getLogger(Issueforstudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadTableIssue() {
        dtm = new DefaultTableModel();
        dtm.addColumn("StudentId");
        dtm.addColumn("CallNumber");
        //   dtm.addColumn("Password");
        dtm.addColumn("IssueDate");
        dtm.addColumn("DueDate");
        dtm.addColumn("IssueStatus");
        dtm.addColumn("CheckOutDate");
        // tao bang
        tblStudentBook.setModel(dtm);
        // goi ket noi
        obj.setConnection();
        try {
            // tao doi tuong thuc thi pre
            obj.pstmt = obj.conn.prepareStatement("SELECT * FROM  StudentBook");
            // thuc thi
            obj.rs = obj.pstmt.executeQuery();

            // lay het recore nay den recore khac
            while (obj.rs.next()) {
                // bo vo mot Vector
                Vector ve = new Vector();
                ve.add(0, obj.rs.getString(1));
                ve.add(1, obj.rs.getString(2));
                ve.add(2, obj.rs.getString(3));
                ve.add(3, obj.rs.getString(4));
                ve.add(4, obj.rs.getString(5));
                ve.add(5, obj.rs.getString(6));

                //  day vo Vecotr - moi dong trong vector 
                dtm.addRow(ve);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Issueforstudent.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbxMajor = new javax.swing.JComboBox<>();
        btnSearchId = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAuthor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnSearchBook = new javax.swing.JButton();
        txtCall = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtISBN = new javax.swing.JTextField();
        txtIssueDate = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtDueDate = new com.toedter.calendar.JDateChooser();
        btnIssue = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBook = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblStudentBook = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        txtCurDate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel15.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("ISSUE FOR STUDENT");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(374, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(102, 51, 153));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 52, 52)), "Student Detail", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 24), new java.awt.Color(108, 122, 137))); // NOI18N

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel6.setText("Student ID:");

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel7.setText("Student Name");

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel8.setText("Address");

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane2.setViewportView(txtAddress);

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel9.setText("Phone");

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel10.setText("Major ID");

        cbxMajor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxMajor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMajorActionPerformed(evt);
            }
        });

        btnSearchId.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnSearchId.setText("Search");
        btnSearchId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtId)
                            .addComponent(cbxMajor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPhone)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                            .addComponent(txtName))
                        .addGap(18, 18, 18)
                        .addComponent(btnSearchId))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(7, 7, 7)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                    .addGap(334, 334, 334)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearchId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbxMajor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(160, 160, 160))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel6)
                    .addGap(38, 38, 38)
                    .addComponent(jLabel7)
                    .addContainerGap(365, Short.MAX_VALUE)))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 160, 133)), "Book Detail", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 24), new java.awt.Color(249, 105, 14))); // NOI18N
        jPanel1.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel4.setText("Title");

        txtTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTitleKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel5.setText("Author");

        txtAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAuthorActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel2.setText("Call Number");

        btnSearchBook.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnSearchBook.setText("Search");
        btnSearchBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchBookActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel3.setText("ISBN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCall)
                                .addGap(22, 22, 22)))
                        .addComponent(btnSearchBook)
                        .addGap(16, 16, 16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtISBN, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                            .addComponent(txtAuthor, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTitle, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSearchBook)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        txtIssueDate.setDateFormatString("dd/MM/yyyy");

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Date Of Issue");

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Return Date");

        txtDueDate.setDateFormatString("dd/MM/yyyy");

        btnIssue.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btnIssue.setText("Issue");
        btnIssue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIssueActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Issue Status");

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
        jScrollPane3.setViewportView(tblBook);

        jLabel19.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Choice book");

        tblStudentBook.setModel(new javax.swing.table.DefaultTableModel(
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
        tblStudentBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentBookMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblStudentBook);

        jLabel21.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText(" Book Issue");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Process", " " }));

        jLabel22.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Current Date");

        txtCurDate.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 893, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel19)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(46, 46, 46)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(36, 36, 36)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel11)
                                                .addComponent(jLabel1))
                                            .addGap(59, 59, 59)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtIssueDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtDueDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel17)
                                                .addComponent(jLabel22))
                                            .addGap(63, 63, 63)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(btnIssue, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                                .addComponent(txtCurDate, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(398, 398, 398)
                            .addComponent(jLabel21))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, Short.MAX_VALUE))
                .addGap(2, 2, 2)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtIssueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(txtDueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22)
                            .addComponent(txtCurDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(btnIssue))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxMajorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMajorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxMajorActionPerformed

    private void btnSearchIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchIdActionPerformed
        String esql = "SELECT * FROM STUDENT WHERE StudentId=?";
        try {
            obj.pstmt = obj.conn.prepareStatement(esql);
            obj.pstmt.setString(1, txtId.getText());
            obj.rs = obj.pstmt.executeQuery();
            if (obj.rs.next()) {
                String add1 = obj.rs.getString("StudentName");
                txtName.setText(add1);
                String add2 = obj.rs.getString("Address");
                txtAddress.setText(add2);
                String add3 = obj.rs.getString("PhoneNumber");
                txtPhone.setText(add3);
                String add4 = obj.rs.getString("majorId");
                cbxMajor.setSelectedItem(add4);
                obj.rs.close();
                obj.pstmt.close();

            } else {
                JOptionPane.showMessageDialog(null, "Student Id Not Found");
            }

            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(Issueforstudent.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                obj.rs.close();
                obj.pstmt.close();
            } catch (Exception e) {

            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchIdActionPerformed

    private void txtTitleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTitleKeyReleased
        try {
            DAO.bookAccess.searchByTitle(txtTitle.getText());
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
            Logger.getLogger(Issueforstudent.class
                .getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTitleKeyReleased

    private void txtAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAuthorActionPerformed

    private void btnSearchBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchBookActionPerformed
        String sql = "SELECT * FROM BOOK WHERE CallNumber=?";
        try {
            obj.pstmt = obj.conn.prepareStatement(sql);
            obj.pstmt.setString(1, txtCall.getText());
            obj.rs = obj.pstmt.executeQuery();
            if (obj.rs.next()) {
                String add1 = obj.rs.getString("ISBN");
                txtISBN.setText(add1);
                String add2 = obj.rs.getString("Title");
                txtTitle.setText(add2);
                String add3 = obj.rs.getString("Author");
                txtAuthor.setText(add3);
                obj.rs.close();
                obj.pstmt.close();

            } else {
                JOptionPane.showMessageDialog(null, "Book Id Not Found");
            }

            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(Issueforstudent.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                obj.rs.close();
                obj.pstmt.close();
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_btnSearchBookActionPerformed

    private void btnIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIssueActionPerformed
        String sql = "INSERT INTO STUDENTBOOK(StudentId, CallNumber, IssueDate, DueDate, IssueStatus) VALUES(?, ?, ?, ?, ?)";
        try {
            // TODO add your handling code here:
            obj.pstmt = obj.conn.prepareStatement(sql);
            obj.pstmt.setString(1, txtId.getText());
            obj.pstmt.setString(2, txtCall.getText());
            obj.pstmt.setString(3, ((JTextField) txtIssueDate.getDateEditor().getUiComponent()).getText());
            obj.pstmt.setString(4, ((JTextField) txtDueDate.getDateEditor().getUiComponent()).getText());
            obj.pstmt.setString(5, jComboBox1.getSelectedItem().toString());

            obj.pstmt.execute();
            JOptionPane.showMessageDialog(null, "Book Issued");

            loadTableIssue();

        } catch (SQLException ex) {
            Logger.getLogger(Issueforstudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIssueActionPerformed

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
            Logger.getLogger(Issueforstudent.class
                .getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tblBookMouseClicked

    private void tblStudentBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentBookMouseClicked
        obj.setConnection();

        try {
            obj.pstmt = obj.conn.prepareStatement("SELECT * FROM StudentBook");
            obj.rs = obj.pstmt.executeQuery();
            // dung if vi chi chon mot dong roi byding len tung con tro tuong ung
            if (obj.rs.next()) {
                int row = tblStudentBook.getSelectedRow();

                txtId.setText(tblStudentBook.getValueAt(row, 0).toString());
                txtCall.setText(tblStudentBook.getValueAt(row, 1).toString());
                //                txtIssueDate.setText(tblStudentBook.getValueAt(row, 2).toString());
                //                txtDueDate.setText(tblStudentBook.getValueAt(row, 3).toString());
                DefaultTableModel model = (DefaultTableModel) tblStudentBook.getModel();
                Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse((String) model.getValueAt(row, 2));
                Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse((String) model.getValueAt(row, 3));
                txtIssueDate.setDate(date1);
                txtDueDate.setDate(date2);
                jComboBox1.setSelectedItem(tblStudentBook.getValueAt(row, 4).toString());

            }
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(Issueforstudent.class.getName()).log(Level.SEVERE, null, ex);
        }catch (ParseException ex) {
            Logger.getLogger(Issueforstudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
        
        // TODO add your handling code here:
    }//GEN-LAST:event_tblStudentBookMouseClicked

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
            java.util.logging.Logger.getLogger(Issueforstudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Issueforstudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Issueforstudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Issueforstudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Issueforstudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIssue;
    private javax.swing.JButton btnSearchBook;
    private javax.swing.JButton btnSearchId;
    private javax.swing.JComboBox<String> cbxMajor;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblBook;
    private javax.swing.JTable tblStudentBook;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtCall;
    private com.toedter.calendar.JDateChooser txtCurDate;
    private com.toedter.calendar.JDateChooser txtDueDate;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtId;
    private com.toedter.calendar.JDateChooser txtIssueDate;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
