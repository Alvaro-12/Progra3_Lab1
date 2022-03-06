/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author Alvaro
 */
public class conexionDB { 
     private static Connection ConnectionBD = null;
    public Connection getConecction ()
     {
         try {
             String url = "jdbc:mysql://localhost:3306/lab";
             String user = "root";
             String password = "root";
             ConnectionBD = DriverManager.getConnection(url,user,password);
             System.out.println("Conexion Exitosa");
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error"+ e.toString());
         }
      return ConnectionBD;
      }
}
