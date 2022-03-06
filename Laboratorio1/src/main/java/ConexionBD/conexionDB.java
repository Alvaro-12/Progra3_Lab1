/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionBD;
import javax.swing.JOptionPane;
import java.sql.*;  
/**
 *
 * @author Alvaro
 */
public class conexionDB { 
    
    private static Connection ConnectionDB = null;
    public Connection getConecction ()
     {
         try {
             String url = "jdbc:mysql://localhost:3306/lab";
             String user = "root";
             String password = "root";
             ConnectionDB = DriverManager.getConnection(url,user,password);
             System.out.println("Conexion Exitosa");
             
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error"+ e.toString());
         }
      return ConnectionDB;
      }
}
