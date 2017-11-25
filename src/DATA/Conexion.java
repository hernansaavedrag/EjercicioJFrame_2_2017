/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author desarrollo
 */
public class Conexion {
    public  static String url="jdbc:mysql://localhost:3306/escuela";
    public static String user="root";
    public static String pass="root";
    public static Statement s;
    public static  String query;
    public static Connection con;
    public Conexion() {
        
    }
    
    public static void conectar(){
        try {
            con=DriverManager.getConnection(url,user,pass);
            JOptionPane.showMessageDialog(null, "Conectado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error conexion BD");
        }
    }
}
