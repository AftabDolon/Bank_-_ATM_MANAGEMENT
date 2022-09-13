/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.atm.management;

import java.awt.Image;
import java.awt.print.PrinterException;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.*;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Administrator
 */
public class Report extends javax.swing.JFrame {

    Connection con;
    Statement stm;
    PreparedStatement pprds;
    String sqls;
    ResultSet rs2;
    ResultSet rs;
    ResultModel rsm = new ResultModel();
    int id;

//    public Object getCnic;
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/inventory";

    /**
     * Creates new form Report
     */
    public Report() {
        initComponents();
//        from.setVisible(false);
//        dateChooserFrom.setVisible(false);
//        dateChooserTo.setVisible(false);
//        to.setVisible(false);
//        showReport.setVisible(false);
//        catagory.setVisible(false);
//        export.setVisible(false);
    }

    public Report(int id) {
        initComponents();
        this.id = id;
    }

    public void myDriver() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, "root", "admin");
        } catch (ClassNotFoundException cnf) {
            System.out.println(cnf);
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, sqle);
        }
    }

    public void setRecordsTotable() {
        myDriver();
        String report = "";
        if (catagory.getSelectedIndex() == 1) {
            report = "employees";
            SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
            String fromDate = dateFormat.format(dateChooserFrom.getDate());
            String toDate = dateFormat.format(dateChooserTo.getDate());

            try {
                String sqls = "select id as 'User ID', concat(first_name, ' ', last_name) as Name, mobile as Mobile, NID, email as Email, address as Address from " + report + " where date between ? and ?";
                PreparedStatement pprds2 = con.prepareStatement(sqls);
                pprds2.setString(1, fromDate);
                pprds2.setString(2, toDate);
                rs2 = pprds2.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            rsm.setResultSet(rs2);
        } else if (catagory.getSelectedIndex() == 2) {
            report = "account";
            SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
            String fromDate = dateFormat.format(dateChooserFrom.getDate());
            String toDate = dateFormat.format(dateChooserTo.getDate());

            try {
                String sqls = "select cnic as CNIC, name as Name, deposite as Deposite, acc_no as 'Account No.', card as Card, pin as PIN from " + report + " where date between ? and ?";
                pprds = con.prepareStatement(sqls);
                pprds.setString(1, fromDate);
                pprds.setString(2, toDate);
                rs = pprds.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            rsm.setResultSet(rs);
        } else if (catagory.getSelectedIndex() == 3) {
            report = "account";
            try {
                String sqls = "select count(acc_no) as 'Total Account' ,sum(deposite) as 'Total Balance' from account";
                pprds = con.prepareStatement(sqls);

                rs = pprds.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rsm.setResultSet(rs);
        }
//        System.out.println(report);

//        Float amountTotal = 0.0f;
//
//        try {
//            
//
//            pprds = con.prepareStatement("select * from "+report+" where date between ? and ?");
//            pprds.setString(1, fromDate);
//            pprds.setString(2, toDate);
//            pprds.setString(3, course_name);
//            rs = pprds.executeQuery();
//
//            while (rs.next()) {
//                int receiptNo = rs.getInt("reciept_no");
//                String rollNo = rs.getString("roll_no");
//                String studentName = rs.getString("student_name");
//                String courseName = rs.getString("course_name");
//                float amount = rs.getFloat("total_amount");
//                String remark = rs.getString("remark");
//
//                amountTotal = amountTotal + amount;
//
//                Object[] obj = {receiptNo, rollNo, studentName, courseName, amount, remark};
//                model = (DefaultTableModel) tbl_feesDetails.getModel();
//                model.addRow(obj);
//
//            }
//            lbl_course.setText(course_name);
//            lbl_totalAmount.setText(amountTotal.toString());
//            lbl_totalAmountWord.setText(NumberToWordsConverter.convert(amountTotal.intValue()));
//        } catch (Exception e) {
//            e.printStackTrace();
    }

    void showReport() {
        myDriver();
        try {
            String sqls = "select * from userinfo order by logout_time desc";
            PreparedStatement ps2 = con.prepareStatement(sqls);
            rs = ps2.executeQuery();
            DefaultTableModel model = (DefaultTableModel) dataview.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                String uid = rs.getString("user_id");
                String name = rs.getString("name");
                String login = rs.getString("login_time");
                String logout = rs.getString("logout_time");
                String emp_date = rs.getString("creation_date");
                String SenderTableData[] = {uid, name, emp_date, login, logout};
                model.addRow(SenderTableData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
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

        panel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        report = new javax.swing.JPanel();
        catagory = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        data = new javax.swing.JTable();
        gr = new javax.swing.JButton();
        showReport = new javax.swing.JButton();
        dateChooserFrom = new com.toedter.calendar.JDateChooser();
        dateChooserTo = new com.toedter.calendar.JDateChooser();
        from = new javax.swing.JLabel();
        to = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        export = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        dataview = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        Heading = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        FirstName = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        LastName = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        AccountID = new javax.swing.JTextField();
        MobileNumber = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        PIN = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        NIDNumber = new javax.swing.JTextField();
        path = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        icon = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setBackground(new java.awt.Color(107, 116, 121));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bank/atm/management/image/report.png"))); // NOI18N
        jButton3.setText("Reports");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 104, 139, -1));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bank/atm/management/image/clock.png"))); // NOI18N
        jButton4.setText("UserLogin");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bank/atm/management/image/logout.png"))); // NOI18N
        jButton5.setText("Logout");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        panel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 375, 139, -1));

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bank/atm/management/image/setting.png"))); // NOI18N
        jButton6.setText("Settings");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        panel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 283, 139, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bank/atm/management/image/back2.jpg"))); // NOI18N
        panel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -1, 160, 530));

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        report.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                reportComponentResized(evt);
            }
        });
        report.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        catagory.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        catagory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Employees", "Account Open", "Total Balance" }));
        report.add(catagory, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 220, -1, -1));

        data.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        data.setModel(rsm);
        data.setRowHeight(30);
        jScrollPane1.setViewportView(data);

        report.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 930, 150));

        gr.setBackground(new java.awt.Color(34, 153, 84));
        gr.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        gr.setForeground(new java.awt.Color(255, 255, 255));
        gr.setText("+  Generate Report");
        gr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grActionPerformed(evt);
            }
        });
        report.add(gr, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, 36));

        showReport.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        showReport.setText("Show Report");
        showReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showReportActionPerformed(evt);
            }
        });
        report.add(showReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 460, -1, 35));
        report.add(dateChooserFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 160, -1));
        report.add(dateChooserTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 330, 161, -1));

        from.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        from.setText("From");
        report.add(from, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, -1, -1));

        to.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        to.setText("To");
        report.add(to, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, -1, -1));

        jPanel4.setBackground(new java.awt.Color(52, 152, 219));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("View Reports");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        );

        report.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, -1, -1));

        export.setBackground(new java.awt.Color(255, 255, 255));
        export.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        export.setForeground(new java.awt.Color(153, 163, 164));
        export.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bank/atm/management/image/excel.png"))); // NOI18N
        export.setText("Export Report");
        export.setToolTipText("");
        export.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        export.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exportMouseClicked(evt);
            }
        });
        report.add(export, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Noakhali Bank");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("We provide Digital Banking Facility");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3)))
                .addContainerGap(754, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        report.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1040, 120));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(report, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(report, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jTabbedPane2.addTab("tab1", jPanel11);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(107, 186, 239));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("User Login");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("User Creation And User Login/Logout Time");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        dataview.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dataview.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "User Name", "Creation Date", "Last Login Time", "Last Logout Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        dataview.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dataview.setRowHeight(30);
        jScrollPane3.setViewportView(dataview);

        jLabel14.setBackground(new java.awt.Color(204, 204, 204));
        jLabel14.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(178, 186, 187));
        jLabel14.setText("SHOW 10 ROWS");

        jTextField2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(204, 204, 204));
        jTextField2.setText("Search.....");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 163, 164));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bank/atm/management/image/export.png"))); // NOI18N
        jLabel11.setText("Export");
        jLabel11.setToolTipText("");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 163, 164));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bank/atm/management/image/printer.png"))); // NOI18N
        jLabel12.setText("Print");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGap(67, 67, 67)
                .addComponent(jLabel11)
                .addGap(46, 46, 46)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 496, Short.MAX_VALUE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Noakhali Bank");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("We provide Digital Banking Facility");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("tab2", jPanel12);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Noakhali Bank");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("We provide Digital Banking Facility");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel13)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bank/atm/management/image/icons8-circled-user-male-skin-type-1-2-100 (2).png"))); // NOI18N

        Heading.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 36)); // NOI18N
        Heading.setForeground(new java.awt.Color(0, 0, 255));
        Heading.setText("Update User Information");

        jLabel16.setText("First Name");

        FirstName.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N

        jLabel17.setText("Last Name");

        LastName.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N

        jLabel18.setText("Account ID");

        AccountID.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        AccountID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountIDActionPerformed(evt);
            }
        });

        MobileNumber.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N

        jLabel19.setText("Mobile Number");

        jLabel20.setText("PIN");

        PIN.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N

        jLabel21.setText("NID Number");

        NIDNumber.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N

        jButton7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton7.setText("Upload Image");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel22.setText("Email");

        email.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N

        jLabel24.setText("Address");

        address.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N

        jButton1.setBackground(new java.awt.Color(23, 224, 238));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Heading)
                .addGap(339, 339, 339))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(MobileNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(PIN, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jButton7)
                                .addGap(18, 18, 18)
                                .addComponent(path, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(141, 141, 141)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel17)
                        .addComponent(jLabel21)
                        .addComponent(jLabel18)
                        .addComponent(LastName)
                        .addComponent(AccountID)
                        .addComponent(NIDNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(450, 450, 450)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Heading)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LastName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AccountID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NIDNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MobileNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PIN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(path, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab3", jPanel1);

        jPanel10.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, -29, 1030, 730));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bank/atm/management/image/bank sign2.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        myDriver();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        String Date = sdf.format(new Date());
        SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");
        Date date = new Date();
        String newDate = df.format(date);
        String time = (date.getHours()) + ":" + (date.getMinutes()) + ":" + (date.getSeconds());
        try {
            String sqls = "update userinfo set logout_time='" + Date + " " + time + "' where user_id=" + id;
            PreparedStatement pst3 = con.prepareStatement(sqls);
            pst3.execute();
            this.setVisible(false);
            dispose();
            new Login().setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jTabbedPane2.setSelectedIndex(1);
        showReport();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTabbedPane2.setSelectedIndex(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void grActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grActionPerformed
        from.setVisible(true);
        dateChooserFrom.setVisible(true);
        dateChooserTo.setVisible(true);
        to.setVisible(true);
        showReport.setVisible(true);
        catagory.setVisible(true);
        export.setVisible(true);
    }//GEN-LAST:event_grActionPerformed

    private void showReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showReportActionPerformed
        setRecordsTotable();
    }//GEN-LAST:event_showReportActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        try {
            dataview.print();
        } catch (PrinterException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel12MouseClicked

    private void exportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportMouseClicked
        FileOutputStream excelFOU = null;
        BufferedOutputStream excelBOU = null;
        XSSFWorkbook excelTableExport = null;
        JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\Administrator\\Desktop");
        excelFileChooser.setDialogTitle("Save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelChoose = excelFileChooser.showSaveDialog(null);
        if (excelChoose == JFileChooser.APPROVE_OPTION) {
            try {

                excelTableExport = new XSSFWorkbook();
                XSSFSheet excelSheet = excelTableExport.createSheet("Report Sheet");
                for (int i = 0; i < data.getRowCount(); i++) {
                    XSSFRow excelRow = excelSheet.createRow(i);
                    for (int j = 0; j < data.getColumnCount(); j++) {
                        XSSFCell excelCell = excelRow.createCell(j);
                        excelCell.setCellValue(data.getValueAt(i, j).toString());
                    }
                }
                excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                excelBOU = new BufferedOutputStream(excelFOU);
                excelTableExport.write(excelBOU);
                JOptionPane.showMessageDialog(null, "Successfully Export this Report");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (excelFOU != null) {
                        excelFOU.close();
                    }
                    if (excelBOU != null) {
                        excelBOU.close();
                    }
                    if (excelTableExport != null) {
                        excelTableExport.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

//JFileChooser j = new JFileChooser("C:\\Users\\Administrator\\Desktop");
//        int i = j.showSaveDialog(this);
//        
//        if (i == 0) {
//            try {
//                PrintWriter p = new PrintWriter(j.getSelectedFile() + ".csv");
//
//                p.println(data.getColumnName(0) + "," + data.getColumnName(1) + "," + data.getColumnName(2) + "," + data.getColumnName(3) + "," + data.getColumnName(4)+ "," + data.getColumnName(5));
//
//                for (int x = 0; x < data.getRowCount(); x++) {
//                    p.println(data.getValueAt(x, 0) + "," + data.getValueAt(x, 1) + "," + data.getValueAt(x, 2) + "," + data.getValueAt(x, 3) + "," + data.getValueAt(x, 4)+ "," + data.getValueAt(x, 5));
//                }
//                p.flush();
//                JOptionPane.showMessageDialog(null, "Successfully Export this Report");
//            } catch (Exception ex) {
//                System.out.println(ex.toString());
//            }
//        }
    }//GEN-LAST:event_exportMouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
//        FileOutputStream excelFOU = null;
//        BufferedOutputStream excelBOU = null;
//        XSSFWorkbook excelTableExport = null;
//        JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\Administrator\\Desktop");
//        excelFileChooser.setDialogTitle("Save As");
//        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
//        excelFileChooser.setFileFilter(fnef);
//        int excelChoose = excelFileChooser.showSaveDialog(null);
//        if (excelChoose == JFileChooser.APPROVE_OPTION) {
//            try {
//
//                excelTableExport = new XSSFWorkbook();
//                XSSFSheet excelSheet = excelTableExport.createSheet("Report Sheet");
//                for (int i = 0; i < dataview.getRowCount(); i++) {
//                    XSSFRow excelRow = excelSheet.createRow(i);
//                    for (int j = 0; j < dataview.getColumnCount(); j++) {
//                        XSSFCell excelCell = excelRow.createCell(j);
//                        excelCell.setCellValue(dataview.getValueAt(i, j).toString());
//                    }
//                }
//                excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
//                excelBOU = new BufferedOutputStream(excelFOU);
//                excelTableExport.write(excelBOU);
//                JOptionPane.showMessageDialog(null, "Successfully Export this Report");
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            } finally {
//                try {
//                    if (excelFOU != null) {
//                        excelFOU.close();
//                    }
//                    if (excelBOU != null) {
//                        excelBOU.close();
//                    }
//                    if (excelTableExport != null) {
//                        excelTableExport.close();
//                    }
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
//            }
//        }

        JFileChooser j = new JFileChooser("C:\\Users\\Administrator\\Desktop");
        int i = j.showSaveDialog(this);

        if (i == 0) {
            try {
                PrintWriter p = new PrintWriter(j.getSelectedFile() + ".csv");

                p.println(dataview.getColumnName(0) + "," + dataview.getColumnName(1) + "," + dataview.getColumnName(2) + "," + dataview.getColumnName(3) + "," + dataview.getColumnName(4));

                for (int x = 0; x < dataview.getRowCount(); x++) {
                    p.println(dataview.getValueAt(x, 0) + "," + dataview.getValueAt(x, 1) + "," + dataview.getValueAt(x, 2) + "," + dataview.getValueAt(x, 3) + "," + dataview.getValueAt(x, 4));
                }
                p.flush();
                JOptionPane.showMessageDialog(null, "Successfully Export this Report");
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }


    }//GEN-LAST:event_jLabel11MouseClicked

    private void reportComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_reportComponentResized
        from.setVisible(false);
        dateChooserFrom.setVisible(false);
        dateChooserTo.setVisible(false);
        to.setVisible(false);
        showReport.setVisible(false);
        catagory.setVisible(false);
        export.setVisible(false);
    }//GEN-LAST:event_reportComponentResized

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jTabbedPane2.setSelectedIndex(2);
    }//GEN-LAST:event_jButton6ActionPerformed
    public void scale(JLabel lbl, String image_name) {
        ImageIcon icon1 = new ImageIcon(image_name);
        Image img = icon1.getImage();
        Image imageScale = img.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scale = new ImageIcon(imageScale);
        icon.setIcon(scale);
    }
    private void AccountIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccountIDActionPerformed
        myDriver();
        try {
            String sqls = "select * from employees where id=" + Integer.parseInt(AccountID.getText()) + "";
            PreparedStatement pst = con.prepareStatement(sqls);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

//                ProfileName.setText(rs.getString("First_Name") + " " + rs.getString("Last_Name"));
//                AccountID.setText(rs.getString("id"));
                FirstName.setText(rs.getString("First_Name"));
                LastName.setText(rs.getString("Last_Name"));
                NIDNumber.setText(rs.getString("NID"));
                MobileNumber.setText(rs.getString("mobile"));
                email.setText(rs.getString("email"));
                address.setText(rs.getString("address"));
                PIN.setText(rs.getString("password"));
                path.setText(rs.getString("image"));
                scale(icon, "E:\\Document File\\" + rs.getString("image"));

            }
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_AccountIDActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        JFileChooser chooser = new JFileChooser("C:\\Users\\Administrator\\Desktop");
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        icon.setIcon(new ImageIcon(f.toString()));
        filename = f.getAbsolutePath();
        path.setText(f.getName());
        scale(icon, f.toString());
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        myDriver();
        try{
            sqls="update employees set first_name=?, last_name=?, mobile=?, NID=?, address=?, password=?, image=?, email=? where id="+Integer.parseInt(AccountID.getText())+"";
            pprds=con.prepareStatement(sqls);
            pprds.setString(1, FirstName.getText());
            pprds.setString(2, LastName.getText());
            pprds.setString(3, MobileNumber.getText());
            pprds.setString(4, NIDNumber.getText());
            pprds.setString(5, address.getText());
            pprds.setString(6, PIN.getText());
            pprds.setString(7, path.getText());
            pprds.setString(8, email.getText());
            pprds.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully User Information Updated");
            FirstName.setText("");
            LastName.setText("");
            MobileNumber.setText("");
            NIDNumber.setText("");
            address.setText("");
            PIN.setText("");
            path.setText("");
            email.setText("");
            scale(icon, "E:\\Document File\\" + "");
            AccountID.setText("");
        }catch(SQLException sqles){
            JOptionPane.showMessageDialog(null, sqles);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Report().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AccountID;
    private javax.swing.JTextField FirstName;
    private javax.swing.JLabel Heading;
    private javax.swing.JTextField LastName;
    private javax.swing.JTextField MobileNumber;
    private javax.swing.JTextField NIDNumber;
    private javax.swing.JTextField PIN;
    private javax.swing.JTextField address;
    private javax.swing.JComboBox<String> catagory;
    private javax.swing.JTable data;
    private javax.swing.JTable dataview;
    private com.toedter.calendar.JDateChooser dateChooserFrom;
    private com.toedter.calendar.JDateChooser dateChooserTo;
    private javax.swing.JTextField email;
    private javax.swing.JLabel export;
    private javax.swing.JLabel from;
    private javax.swing.JButton gr;
    private javax.swing.JLabel icon;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
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
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel panel1;
    private javax.swing.JTextField path;
    private javax.swing.JPanel report;
    private javax.swing.JButton showReport;
    private javax.swing.JLabel to;
    // End of variables declaration//GEN-END:variables

    String filename = null;
}
