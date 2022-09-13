/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.atm.management.image;

import bank.atm.management.LinkedList;
import bank.atm.management.Login;
import bank.atm.management.MyDashboard;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class Bank extends javax.swing.JFrame {

    String cnic, name;
    double balance;
    int pin;
    String accountNo, card;
    Connection con;
    Statement stm;
    PreparedStatement pprds;
    String sqls;

    ResultSet rs;
    LinkedList list = new LinkedList();
    int id;
//    public Object getCnic;
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/inventory";

    public Bank(String cnic, String name, double balance, int pin, String accountNo, String card) {

        this.cnic = cnic;
        this.name = name;
        this.balance = balance;
        this.pin = pin;
        this.accountNo = accountNo;
        this.card = card;
    }

    public boolean withdraw(double amount) {
        if (this.balance - amount >= 0) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    /**
     * Creates new form Bank
     */
    public Bank(int id) {
        initComponents();
//        checkFileName();
//        readFile();
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
    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
    String Date = sdf.format(new Date());

    public void deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public String toString() {
        return cnic + ":" + name + ":" + balance + ":" + pin + ":" + accountNo + ":" + card;
    }

    public String getCnic() {
        return cnic;
    }

    public String getName() {
        return name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getCard() {
        return card;
    }

    public double getBalance() {
        return balance;
    }

    public int getPin() {
        return pin;
    }

    private boolean checkCNIC(String text) {
        if (text.length() == 13) {
            boolean ret = false;
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) >= 48 && text.charAt(i) <= 57) {
                    ret = true;
                } else {
                    ret = false;
                }
            }
            return ret;
        } else {
            return false;
        }
    }

    private void writeFile(String data) {
        try {
            FileWriter output = new FileWriter("E:\\data.txt");
            output.write(data);
            output.close();
            System.out.println("Successfully wrote to the file");
        } catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    public void readFile() {
        try {
            File input = new File("E:\\data.txt");
            Scanner src = new Scanner(input);
            while (src.hasNextLine()) {
                String data = src.nextLine();
                if (data.length() > 5) {
                    String[] cus = data.split(":");
                    list.insert(new Bank(cus[0], cus[1], Double.parseDouble(cus[2]), Integer.parseInt(cus[3]), cus[4], cus[5]));
                }
            }
            src.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    private void checkFileName() {
        try {
            File myObj = new File("E:\\data.txt");
            if (myObj.createNewFile()) {
                System.out.println("File Created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error has been occured.");
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cnic1 = new javax.swing.JTextField();
        name1 = new javax.swing.JTextField();
        deposite = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        accno = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        deposite1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataDis = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        accountType = new javax.swing.JComboBox<>();
        BackButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Noakhali Bank");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bank/atm/management/image/bank sign2.jpg"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("We provide Digital Banking Facility");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CNIC");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Name");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Initial Deposite");

        cnic1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        cnic1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        name1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        name1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        deposite.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        deposite.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton1.setBackground(new java.awt.Color(30, 132, 73));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Registration");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CNIC");

        accno.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        accno.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Deposite Amount");

        deposite1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        deposite1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton2.setBackground(new java.awt.Color(30, 132, 73));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Info");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(30, 132, 73));
        jButton3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Deposite");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        dataDis.setEditable(false);
        dataDis.setColumns(20);
        dataDis.setRows(5);
        jScrollPane1.setViewportView(dataDis);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Account Type");

        accountType.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        accountType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Current account", "Savings account", "Salary account", "Fixed deposit account", "Recurring deposit account", "NRI accounts" }));

        BackButton.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        BackButton.setForeground(new java.awt.Color(153, 153, 153));
        BackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bank/atm/management/image/icons8-back-arrow-30.png"))); // NOI18N
        BackButton.setText("Go Back");
        BackButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6))))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cnic1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                                    .addComponent(name1)
                                    .addComponent(deposite))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(305, 305, 305)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(66, 66, 66)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(deposite1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                                    .addComponent(accno))
                                .addContainerGap())))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(accountType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1037, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(BackButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BackButton)
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cnic1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deposite, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(accno, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deposite1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accountType, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(26, 26, 26)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        myDriver();
        String s = "";
//        
//       
        try {
            stm = con.createStatement();
            System.out.println(con);
            rs = stm.executeQuery("select cnic from account where cnic='" + cnic1.getText() + "'");
            while (rs.next()) {
                s = rs.getString("cnic");
            }
            if (s.equals(cnic1.getText())) {
                JOptionPane.showMessageDialog(this, "Sorry, CNIC is Already Exist", "Enter Value Error!", JOptionPane.ERROR_MESSAGE);
                cnic1.requestFocus();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String accType = accountType.getSelectedItem().toString();
        if (list.isExit(cnic1.getText())) {
            JOptionPane.showMessageDialog(null, "CNIC is Already Exist");

        } else if (cnic1.getText().equals("") || name1.getText().equals("") || deposite.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "All the Feilds Required");
        } else if (cnic1.getText().length() < 13 || cnic1.getText().length() > 13) {
            JOptionPane.showMessageDialog(null, "CNIC is must be 13 number");
        } else {
            Random rand = new Random();
            int pin = (int) (Math.floor(Math.random() * (9999 - 1000 + 1) + 1000));
            int c1, c2, c3, c4;
            do {
                c1 = (int) Math.floor(Math.random() * (9999 - 1000 + 1) + 1000);
                c2 = (int) Math.floor(Math.random() * (9999 - 1000 + 1) + 1000);
                c3 = (int) Math.floor(Math.random() * (9999 - 1000 + 1) + 1000);
                c4 = (int) Math.floor(Math.random() * (9999 - 1000 + 1) + 1000);
            } while (list.check(c1 + " " + c2 + " " + c3 + " " + c4));

            int a1 = (int) Math.floor(Math.random() * (999999 - 100000 + 1) + 100000);
            int a2 = (int) Math.floor(Math.random() * (999999 - 100000 + 1) + 100000);
            try {
                double amount = Double.parseDouble(deposite.getText());
                if (amount < 0) {
                    JOptionPane.showMessageDialog(null, "Amount not be Negative !");
                    return;
                }
                list.insert(new Bank(cnic1.getText(), name1.getText(), amount, pin, "PK00COMSATS0" + a1 + "" + a2, c1 + " " + c2 + " " + c3 + " " + c4));
                //writeFile(list.allData());
                stm = con.createStatement();
                String sqls = "insert into account values('" + cnic1.getText() + "','" + name1.getText() + "'," + amount + ",'PK00COMSATSO" + a1 + a2 + "','" + c1 + " " + c2 + " " + c3 + " " + c4 + "'," + pin + ",'" + accType + "','" + Date + "')";
                stm.executeUpdate(sqls);
                System.out.println(sqls);
                JOptionPane.showMessageDialog(null, "Customer is Registerd Successfully !\nAccount Number = " + "PK00COMSATS0" + a1 + "" + a2);
                name1.setText("");
                cnic1.setText("");
                deposite.setText("");
                accountType.setSelectedIndex(0);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        myDriver();

        try {
            String sqls = "select * from account where cnic='" + accno.getText() + "'";
            stm = con.createStatement();
            rs = stm.executeQuery(sqls);
            while (rs.next()) {
                rs.getString("cnic");
                rs.getString("name");
                rs.getDouble("deposite");
                rs.getString("acc_no");
                rs.getString("card");
                rs.getInt("pin");
                rs.getString("acc_type");
                dataDis.setText("CNIC: \t\t\t" + rs.getString("cnic") + "\nName: \t\t\t" + rs.getString("name") + "\nBalance: \t\t\t" + rs.getDouble("deposite") + "\nAccount#: \t\t\t" + rs.getString("acc_no") + "\nCard#: \t\t\t" + rs.getString("card") + "\nPIN: \t\t\t" + rs.getInt("pin") + "\nAccount Type: \t\t\t" + rs.getString("acc_type"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        myDriver();
        double a = 0;

        try {
            double amount = Double.parseDouble(deposite1.getText());
            if (amount < 0) {
                JOptionPane.showMessageDialog(null, "Amount not be Negative !");
                deposite1.setText("");
                return;
            }
            String s = "select deposite from account where cnic='" + accno.getText() + "'";
            stm = con.createStatement();
            rs = stm.executeQuery(s);
            while (rs.next()) {
                a = rs.getDouble("deposite");
            }
            double sum = a + Double.parseDouble(deposite1.getText());

            String sqls = "update account set deposite=? where cnic='" + accno.getText() + "'";
            pprds = con.prepareStatement(sqls);
            pprds.setDouble(1, sum);
            pprds.executeUpdate();
            dataDis.setText(list.Deposit(accno.getText(), amount));
            dataDis.setText(list.CnicInfo(accno.getText()));
//                writeFile(list.allData());
            JOptionPane.showMessageDialog(null, "Successfully Updated");
            deposite1.setText("");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please Enter Valid amount");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void BackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackButtonMouseClicked
        setVisible(false);
        dispose();
        new MyDashboard(id).setVisible(true);
    }//GEN-LAST:event_BackButtonMouseClicked

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
            java.util.logging.Logger.getLogger(Bank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new Bank().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackButton;
    private javax.swing.JTextField accno;
    private javax.swing.JComboBox<String> accountType;
    private javax.swing.JTextField cnic1;
    private javax.swing.JTextArea dataDis;
    private javax.swing.JTextField deposite;
    private javax.swing.JTextField deposite1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name1;
    // End of variables declaration//GEN-END:variables
byte[] photo = null;
    String filename = null;
}
