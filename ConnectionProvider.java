/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package booking_stadium_prj_pdm;

/**
 *
 * @author Admin
 */
public class ConnectionProvider {
    String connection = "jdbc:mysql://localhost:3306/stadium_booking_2?user=root&password=123456789";

    public String getConnection() {
        return connection;
    }
    
}
