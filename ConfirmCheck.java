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
public class ConfirmCheck extends javax.swing.JFrame {
    String ID,user,pass;
    
    /**
     * Creates new form Confirm
     */
    public ConfirmCheck() {
        ArrayList<String> studentNames = new ArrayList<>();
        loadInforTicket(studentNames);
    }
//    public void getQuantity(){
//        this.quantity = (int) txtQuantity.getValue();
//        System.out.println("Quantity: "+this.quantity);
//    }
    public ConfirmCheck(String ID,String user, String pass) {
        this.ID = ID;
        this.user = user;
        this.pass = pass;
        ArrayList<String> studentNames = new ArrayList<>();
        loadInforTicket(studentNames);
    }
//    public void Total(){
//        double total = 0;
//        this.quantity = (int) txtQuantity.getValue();
//        total = quantity * price;
////        this.total = String.valueOf(total);
//        this.total = total;
//    }
    public void loadInforTicket(ArrayList<String> studentNames){
        studentNames= new ArrayList<>();
        String connectionUrl = new ConnectionProvider().getConnection();
        try (Connection con = DriverManager.getConnection(connectionUrl); java.sql.Statement stmt = con.createStatement();) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS selected_students ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "Student_name VARCHAR(255),"
                    + "is_checked BOOLEAN)";
            stmt.executeUpdate(createTableSQL);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    /*
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

 */
    public static void main(String args[]) {
        ArrayList<String> studentNames = new ArrayList<>();
        String connectionUrl = new ConnectionProvider().getConnection();
        String ID = "ticket_id";
        try (Connection con = DriverManager.getConnection(connectionUrl); java.sql.Statement stmt = con.createStatement();) {
            String SQL = "SELECT s.Student_name FROM stadium_booking_2.student s JOIN stadium_booking_2.ticket t ON s.Student_class = t.list_class where t.ticket_id = 4"; //'"+ID+"'
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next()){
                studentNames.add(rs.getString("Student_name"));
            }
            JFrame frame = new JFrame("Checkbox List Example");
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
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
   
            
    }
}
   

/*
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
*/

