/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
/**
 *
 * @author Admin
 */
public class Confirm2 extends javax.swing.JFrame {
    String list_id,user,pass;
    
    /**
     * Creates new form Confirm
     */
    public Confirm2() {
        initComponents();

    }
    public Confirm2(String ticket_id,String user, String pass) {
        this.list_id = ticket_id;
        this.user = user;
        this.pass = pass;
        initComponents();
        ArrayList<String> studentNames = new ArrayList<>();
        loadInforTicket(list_id, studentNames);
    }

    public void loadInforTicket(String ID, ArrayList<String> studentNames){
        studentNames= new ArrayList<>();
        String connectionUrl = new ConnectionProvider().getConnection();
        try (Connection con = DriverManager.getConnection(connectionUrl); java.sql.Statement stmt = con.createStatement();) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS selected_students ("
                    + "Student_name VARCHAR(255),"
                    + "is_checked BOOLEAN)"; 
                    stmt.executeUpdate(createTableSQL);
//            String alterTableSQL = "ALTER TABLE selected_students " +
//                       "ADD COLUMN list_date DATE DEFAULT (SELECT list_date FROM ticket)";
//                       stmt.executeUpdate(alterTableSQL);
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void initComponents() {
        ArrayList<String> studentNames = new ArrayList<>();
        String connectionUrl = new ConnectionProvider().getConnection();
        try (Connection con = DriverManager.getConnection(connectionUrl); java.sql.Statement stmt = con.createStatement();) {
            String SQL = "SELECT s.Student_name FROM stadium_booking_2.student s JOIN stadium_booking_2.list t ON s.Student_class = t.list_class where t.list_id = '"+list_id+"'"; //
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
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Confirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Confirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Confirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Confirm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
//            java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new example().setVisible(true);
//            }
//        });
    }
    
 }
    
   
