/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionBD.conexionDB;
import Entidades.Contactos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author nelso
 */
public class DContacto {
    conexionDB con = new conexionDB ();
        Connection conexion = con.getConecction();
    public ArrayList<Contactos>ListadoContatos()       
    { ArrayList<Contactos> listado = null;
      
        try {
             listado = new ArrayList<Contactos>();
            
             
             CallableStatement cb = conexion.prepareCall("select * from contactos");
                ResultSet resultado = cb.executeQuery();
      
             while (resultado.next())
             {  
             Contactos ct = new Contactos();
             ct.setID(resultado.getInt("ID"));
             ct.setNombre(resultado.getString("Nombre"));
             ct.setEdad(resultado.getInt("Edad"));
             ct.setEmail(resultado.getString("Email"));
             ct.setNumeroDeTelefono(resultado.getInt("NumeroDeTelefono"));
             listado.add(ct);
             }   
                
        } catch (Exception e) {
            System.out.println(e.toString());
        }
     return listado;
     
    }
    public void AddContacto(Contactos ct)
    {
            try {
                CallableStatement cb = conexion.prepareCall("insert into contactos( ID, Nombre, Edad , Email, NumeroDeTelefono) values('"+ct.getID()+"','"+ct.getNombre()+"','"+ct.getEdad()+"','"+ct.getEmail()+"','"+ct.getNumeroDeTelefono()+"')");
                cb.execute();
                
                JOptionPane.showMessageDialog(null,"Contacto agregado","Mensaje sistems",1);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error" + ex.toString(),"Mensaje sistems", 1);
            }
    }
    
    public void UpContacto(Contactos ct){
        try {
                CallableStatement cb = conexion.prepareCall("UPDATE contactos SET Nombre='"+ct.getNombre()+"', Edad='"+ct.getEdad()+"',Email='"+ct.getEmail()+"',NumeroDeTelefono='"+ct.getNumeroDeTelefono()+"'  WHERE ID='"+ct.getID()+"'");
                cb.execute();
               
                JOptionPane.showMessageDialog(null,"Contacto actualizado","Mensaje sistems",1);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error" + ex.toString(),"Mensaje sistems", 1);
            }
    } 
}
