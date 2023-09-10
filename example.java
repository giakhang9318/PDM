///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package booking_stadium_prj_pdm;
//
//import java.awt.GridLayout;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import javax.swing.JCheckBox;
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//
//
//public class example extends javax.swing.JFrame {
//    public static void main(String[] args) {
//        ArrayList<String> studentNames = new ArrayList<>();
//        String connectionUrl = new ConnectionProvider().getConnection();
//        try (Connection con = DriverManager.getConnection(connectionUrl); java.sql.Statement stmt = con.createStatement();) {
//            String SQL = "SELECT Student_name FROM student WHERE Student_class='10'";
//            ResultSet rs = stmt.executeQuery(SQL);
//            while (rs.next()) {
//                studentNames.add(rs.getString("Student_name"));
//            }
//            JFrame frame = new JFrame("Checkbox List Example");
//            JPanel checkboxPanel = new JPanel();
//            checkboxPanel.setLayout(new GridLayout(studentNames.size(), 1));
//            for (String studentName : studentNames) {
//                JCheckBox checkbox = new JCheckBox(studentName);
//                checkboxPanel.add(checkbox);
//            }
//            frame.add(checkboxPanel);
//            frame.pack();
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setVisible(true);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
////////////////////////////////////////////////////////////////////////////////////
//
//package booking_stadium_prj_pdm;
//
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import javax.swing.JButton;
//import javax.swing.JCheckBox;
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//
//
//public class example extends javax.swing.JFrame {
//    public static void main(String[] args) {
//        ArrayList<String> studentNames = new ArrayList<>();
//        String connectionUrl = new ConnectionProvider().getConnection();
//        try (Connection con = DriverManager.getConnection(connectionUrl); java.sql.Statement stmt = con.createStatement();) {
//            // Create a new table to store the selected student names
//            String createTableSQL = "CREATE TABLE IF NOT EXISTS selected_students ("
//                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
//                    + "Student_name VARCHAR(255),"
//                    + "is_checked BOOLEAN)";
//            stmt.executeUpdate(createTableSQL);
//
//            String SQL = "SELECT Student_name FROM student WHERE Student_class='10'";
//            ResultSet rs = stmt.executeQuery(SQL);
//            while (rs.next()) {
//                studentNames.add(rs.getString("Student_name"));
//            }
//            JFrame frame = new JFrame("Checkbox List Example");
//            JPanel checkboxPanel = new JPanel();
//            checkboxPanel.setLayout(new GridLayout(studentNames.size(), 1));
//            ArrayList<JCheckBox> checkboxes = new ArrayList<>();
//            for (String studentName : studentNames) {
//                JCheckBox checkbox = new JCheckBox(studentName);
//                checkboxPanel.add(checkbox);
//                checkboxes.add(checkbox);
//            }
//            JButton saveButton = new JButton("Save");
//            saveButton.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    try (Connection con = DriverManager.getConnection(connectionUrl); PreparedStatement stmt = con.prepareStatement("INSERT INTO selected_students (Student_name, is_checked) VALUES (?, ?)");) {
//                        for (JCheckBox checkbox : checkboxes) {
//                            stmt.setString(1, checkbox.getText());
//                            stmt.setBoolean(2, checkbox.isSelected());
//                            stmt.executeUpdate();
//                        }
//                        JOptionPane.showMessageDialog(frame, "Selections saved successfully.");
//                    } catch (Exception ex) {
//                        ex.printStackTrace();
//                        JOptionPane.showMessageDialog(frame, "Error saving selections.");
//                    }
//                }
//            });
//            JPanel buttonPanel = new JPanel();
//            buttonPanel.add(saveButton);
//            frame.add(checkboxPanel);
//            frame.add(buttonPanel, "South");
//            frame.pack();
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setVisible(true);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}

//package booking_stadium_prj_pdm;
//
//import java.awt.GridLayout;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import javax.swing.JCheckBox;
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//
//
//public class example extends javax.swing.JFrame {
//    String ID,user,pass;
//    int number, total;
//    
//    /**
//     * Creates new form Confirm
//     */
//    public example() {
//        initComponents();
//        CheckAttendance();
//    }
//    public void getNumberOfAttendants(){
//       this.number = checkbox.getSelectedObjects().length;
//        System.out.println("Quantity: "+this.number);
//    }
//    public example(String ID,String user, String pass) {
//        initComponents();
//        this.ID = ID;
//        this.user = user;
//        this.pass = pass;
//        CheckAttendance();
//    }
//    
//     public void CheckAttendance(){
//           // Define the SQL query to retrieve student names
//        String connectionUrl = new ConnectionProvider().getConnection();
//        String SQL = "SELECT s.Student_name FROM student s JOIN ticket t ON s.Student_class = t.list_class WHERE ticket_id= '"+ID+"'";
//        try (Connection con = DriverManager.getConnection(connectionUrl);java.sql.Statement stmt = con.createStatement();
//             ResultSet rs = stmt.executeQuery(SQL)) {
//
//            // Create a panel to hold the checkboxes
//            JPanel checkboxPanel = new JPanel();
//            checkboxPanel.setLayout(new GridLayout(0, 1));
//
//            // Create a checkbox for each student name and add it to the panel
//            while (rs.next()) {
//                String studentName = rs.getString("Student_name");
//                JCheckBox checkbox = new JCheckBox(studentName);
//                checkboxPanel.add(checkbox);
//            }
//
//            // Create the frame and add the panel to it
//            JFrame frame = new JFrame("Students List");
//            frame.getContentPane().add(checkboxPanel);
//
//            // Set the size of the frame and make it visible
//            frame.setSize(400, 400);
//            frame.setVisible(true);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
//        }
//     }
// @SuppressWarnings("unchecked")
//    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
//    private void initComponents() {
//
//        btnConfirm = new javax.swing.JToggleButton();
//        btnCancel = new javax.swing.JButton();
//        btnBack = new javax.swing.JButton();
//        checkbox = new JCheckBox();
//        jLabel2.setText("jLabel2");
//
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
//
//
//        btnConfirm.setBackground(new java.awt.Color(134, 89, 45));
//        btnConfirm.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
//        btnConfirm.setForeground(new java.awt.Color(255, 255, 255));
//        btnConfirm.setText("Confirm");
//        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnConfirmActionPerformed(evt);
//            }
//        });
//
//        btnCancel.setBackground(new java.awt.Color(134, 89, 45));
//        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
//        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
//        btnCancel.setText("Cancel");
//        btnCancel.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnCancelActionPerformed(evt);
//            }
//        });
//
//        btnBack.setBackground(new java.awt.Color(134, 89, 45));
//        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
//        btnBack.setForeground(new java.awt.Color(255, 255, 255));
//        btnBack.setText("Back");
//        btnBack.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnBackActionPerformed(evt);
//            }
//        });
//      
//        checkbox.setBackground(new java.awt.Color(255, 255, 255));
//        checkbox.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
//        checkbox.setForeground(new java.awt.Color(153, 77, 0));
//
//        JPrice.setBackground(new java.awt.Color(255, 255, 255));
//        JPrice.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
//        JPrice.setForeground(new java.awt.Color(153, 77, 0));
//
//        JTeamTwo.setBackground(new java.awt.Color(255, 255, 255));
//        JTeamTwo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
//        JTeamTwo.setForeground(new java.awt.Color(153, 77, 0));
//
//        JTeamOne.setBackground(new java.awt.Color(255, 255, 255));
//        JTeamOne.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
//        JTeamOne.setForeground(new java.awt.Color(153, 77, 0));
//
//        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
//        jLabel1.setForeground(new java.awt.Color(167, 105, 42));
//        jLabel1.setText("Confirm Booking Page");
//
//        JTime.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
//        JTime.setForeground(new java.awt.Color(153, 77, 0));
//
//        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
//        jPanel1.setLayout(jPanel1Layout);
//        jPanel1Layout.setHorizontalGroup(
//            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(jPanel1Layout.createSequentialGroup()
//                .addGap(81, 81, 81)
//                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addGap(63, 63, 63)
//                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
//                    .addComponent(checkbox, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(JDate, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(JType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                    .addComponent(JTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                    .addComponent(JPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                    .addComponent(JTeamTwo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                    .addComponent(JTeamOne, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addGap(0, 98, Short.MAX_VALUE))
//            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
//                .addGap(171, 171, 171)
//                .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addGap(165, 165, 165))
//            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
//                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                .addComponent(jLabel1)
//                .addGap(132, 132, 132)
//                .addComponent(btnBack)
//                .addContainerGap())
//        );
//        jPanel1Layout.setVerticalGroup(
//            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
//                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addGroup(jPanel1Layout.createSequentialGroup()
//                        .addGap(11, 11, 11)
//                        .addComponent(btnBack))
//                    .addGroup(jPanel1Layout.createSequentialGroup()
//                        .addGap(40, 40, 40)
//                        .addComponent(jLabel1)))
//                .addGap(27, 27, 27)
//                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
//                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(JTeamOne, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addGap(26, 26, 26)
//                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
//                    .addComponent(jLabel4)
//                    .addComponent(JTeamTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addGap(22, 22, 22)
//                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
//                    .addComponent(JTime, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(jLabel5))
//                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addGroup(jPanel1Layout.createSequentialGroup()
//                        .addGap(18, 18, 18)
//                        .addComponent(JPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
//                    .addGroup(jPanel1Layout.createSequentialGroup()
//                        .addGap(31, 31, 31)
//                        .addComponent(jLabel7)))
//                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addGroup(jPanel1Layout.createSequentialGroup()
//                        .addGap(21, 21, 21)
//                        .addComponent(JType, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
//                        .addGap(35, 35, 35))
//                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
//                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                        .addComponent(jLabel8)
//                        .addGap(27, 27, 27)))
//                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(checkbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(jLabel9))
//                .addGap(21, 21, 21)
//                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
//                    .addComponent(JDate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(jLabel10))
//                .addGap(30, 30, 30)
//                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(btnConfirm)
//                    .addComponent(btnCancel))
//                .addContainerGap(35, Short.MAX_VALUE))
//        );
//
//        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 570));
//
//        pack();
//        setLocationRelativeTo(null);
//    }// </editor-fold>             
//    
//     private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {                                           
//        CheckAttendance();
//        if(checkbox.getSelectedObjects().length > this.total){
//            JOptionPane.showMessageDialog(null, "The Quantity over seats number!", "Message", JOptionPane.ERROR_MESSAGE);
//        }else if(checkbox.getSelectedObjects().length > 0){
//            this.setVisible(false);
//            new transaction(ID,user,pass,checkbox.getSelectedObjects().length).setVisible(true);
//        }
//        else if(checkbox.getSelectedObjects().length <= 0){
//            JOptionPane.showMessageDialog(null, "Please, booking at least 1 ticket!", "Message", JOptionPane.WARNING_MESSAGE);
//        }
//    }
//    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {                                          
//        // TODO add your handling code here:
//        this.setVisible(false);
//        new index(user,pass).setVisible(true);
//    }                                         
//
//    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {                                        
//        // TODO add your handling code here:
//        this.setVisible(false);
//        new index(user,pass).setVisible(true);
//    }  
//        
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Confirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Confirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Confirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Confirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Confirm().setVisible(true);
//            }
//        });
//    }
//
//    // Variables declaration - do not modify                     
//    private javax.swing.JLabel JDate;
//    private javax.swing.JLabel JPrice;
//    private javax.swing.JLabel JTeamOne;
//    private javax.swing.JLabel JTeamTwo;
//    private javax.swing.JLabel JTime;
//    private javax.swing.JLabel JType;
//    private javax.swing.JButton btnBack;
//    private javax.swing.JButton btnCancel;
//    private javax.swing.JToggleButton btnConfirm;
//    private javax.swing.JLabel jLabel1;
//    private javax.swing.JLabel jLabel10;
//    private javax.swing.JLabel jLabel2;
//    private javax.swing.JLabel jLabel3;
//    private javax.swing.JLabel jLabel4;
//    private javax.swing.JLabel jLabel5;
//    private javax.swing.JLabel jLabel7;
//    private javax.swing.JLabel jLabel8;
//    private javax.swing.JLabel jLabel9;
//    private javax.swing.JPanel jPanel1;
//    private javax.swing.JCheckBox checkbox;
//    // End of variables declaration           
//}

package booking_stadium_prj_pdm;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
/**
 *
 * @author Admin
 */
public class example extends JFrame {
    String ticket_id,user,pass;
    
    /**
     * Creates new form Confirm
     */
    public example() {
//        ArrayList<String> studentNames = new ArrayList<>();
//        loadInforTicket(ID, studentNames);
 }
//    public void getQuantity(){
//        this.quantity = (int) txtQuantity.getValue();
//        System.out.println("Quantity: "+this.quantity);
//    }
    public example(String ID,String user, String pass) {
        this.ticket_id = ticket_id;
        this.user = user;
        this.pass = pass;
        ArrayList<String> studentNames = new ArrayList<>();
        loadInforTicket(ID, studentNames);
    }

    public void loadInforTicket(String ID, ArrayList<String> studentNames){
        studentNames= new ArrayList<>();
        String connectionUrl = new ConnectionProvider().getConnection();
        try (Connection con = DriverManager.getConnection(connectionUrl); java.sql.Statement stmt = con.createStatement();) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS selected_students ("
                    + "Student_name VARCHAR(255),"
                    + "is_checked BOOLEAN)";
            stmt.executeUpdate(createTableSQL);
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
   
    public static void main(String args[]) {
        ArrayList<String> studentNames = new ArrayList<>();
        String connectionUrl = new ConnectionProvider().getConnection();
        String ticket_id = "ticket_id";
        try (Connection con = DriverManager.getConnection(connectionUrl); java.sql.Statement stmt = con.createStatement();) {
            String SQL = "SELECT s.Student_name FROM stadium_booking_2.student s JOIN stadium_booking_2.ticket t ON s.Student_class = t.list_class where t.ticket_id = 4 "; //
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next()){
                studentNames.add(rs.getString("Student_name"));
            }
            JFrame frame = new JFrame("Checkbox List");
            JPanel checkboxPanel = new JPanel();
            checkboxPanel.setLayout(new GridLayout(studentNames.size(), 1));
            ArrayList<JCheckBox> checkboxes = new ArrayList<>();
            for (String studentName : studentNames) {
                JCheckBox checkbox = new JCheckBox(studentName);
                checkboxPanel.add(checkbox);
                checkboxes.add(checkbox);
            }
            JButton saveButton = new JButton("Save");
            saveButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try (Connection con = DriverManager.getConnection(connectionUrl); PreparedStatement stmt = con.prepareStatement("INSERT INTO selected_students (Student_name, is_checked) VALUES (?, ?)");) {
                        for (JCheckBox checkbox : checkboxes) {
                            stmt.setString(1, checkbox.getText());
                            stmt.setBoolean(2, checkbox.isSelected());
                            stmt.executeUpdate();
                        }
                        JOptionPane.showMessageDialog(frame, "Selections saved successfully.");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(frame, "Error saving selections.");
                    }
                }
            });
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(saveButton);
            frame.add(checkboxPanel);
            frame.add(buttonPanel, "South");
            frame.revalidate();
            frame.repaint();
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Confirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Confirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Confirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Confirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//            java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new example().setVisible(true);
//            }
//        });
    }
 }
    
   



