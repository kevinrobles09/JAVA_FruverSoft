/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Conexion;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Javier sepulveda
 */
public class usuariosCrud {
    // instancia de la clase conexion conector
    Conexion conector = new Conexion();
    
        // registro de usuariosCrud 

    public void registrarusuario(JTextField txtusuId , JPasswordField txtusucontrasena, JTextField txtusutipoId , JTextField txtusuNombre , JTextField txtusuApellido , JTextField txtusuDireccion , JTextField txtusuCorreo , JTextField txtusuTelefono , JTextField txtusuEstado , JTextField txtusuRol ){
        
        // variables de ingreso a la bd
        int usuId=Integer.parseInt(txtusuId.getText());
        String usucontrasena=txtusucontrasena.getText();
        String usutipoId=txtusutipoId.getText();
        String usuNombre=txtusuNombre.getText();
        String usuApellido=txtusuApellido.getText();
        String usuDireccion=txtusuDireccion.getText();
        String usuCorreo=txtusuCorreo.getText();
        String usuTelefono=txtusuTelefono.getText();
        int usuEstado=Integer.parseInt(txtusuEstado.getText());
        int usuRol=Integer.parseInt(txtusuRol.getText());
        
        //apertura del bufer para transaccion de datos
        try {
            Statement s = conector.obtenerConexion().createStatement();
            s.executeUpdate(" INSERT INTO `bd_fruversoft`.`tblusuarios` (usuId, usuContrasena, usuTipoId, usuNombres, usuApellidos, usuDireccion, usuCorreo, usuTelefono, tblestados_estId, tblroles_rolId) VALUES ("+usuId+", '"+usucontrasena+"', '"+usutipoId+"', '"+usuNombre+"', '"+usuApellido+"', '"+usuDireccion+"', '"+usuCorreo+"', '"+usuTelefono+"', "+usuEstado+","+usuRol+") ");
            JOptionPane.showMessageDialog(null, "USUARIO REGISTRADO CORRECTAMENTE", "", -1);
        } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: "+e.getMessage(), "", -1);
        }
    }
    
    
    public void eliminarUSuario(JTextField txtusuId){
        
        //variable de ingreso a la bd
        int usuId1=Integer.parseInt(txtusuId.getText());
        
                try {
                //apertura del bufer para transaccion de datos
                Statement s = conector.obtenerConexion().createStatement();
                s.executeUpdate(" DELETE FROM `bd_fruversoft`.`tblusuarios` WHERE usuId = "+usuId1+" ");
                JOptionPane.showMessageDialog(null, "USUARIO ELIMINADO CORRECTAMENTE", "", -1);
        } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: "+e.getMessage(), "", -1);
        }
    }
    
    
    public void actualizarUsuario(JTextField txtusuId , JPasswordField txtusucontrasena, JTextField txtusutipoId , JTextField txtusuNombre , JTextField txtusuApellido , JTextField txtusuDireccion , JTextField txtusuCorreo , JTextField txtusuTelefono , JTextField txtusuEstado , JTextField txtusuRol){
    
        // variables de ingreso a la bd
        int usuId2=Integer.parseInt(txtusuId.getText());
        String usucontrasena1=txtusucontrasena.getText();
        String usutipoId1=txtusutipoId.getText();
        String usuNombre1=txtusuNombre.getText();
        String usuApellido1=txtusuApellido.getText();
        String usuDireccion1=txtusuDireccion.getText();
        String usuCorreo1=txtusuCorreo.getText();
        String usuTelefono1=txtusuTelefono.getText();
        int usuEstado1=Integer.parseInt(txtusuEstado.getText());
        int usuRol1=Integer.parseInt(txtusuRol.getText());


        try {
                //apertura del bufer para transaccion de datos
                Statement s = conector.obtenerConexion().createStatement();
                s.executeUpdate(" UPDATE `bd_fruversoft`.`tblusuarios` SET usuId = "+usuId2+", usuContrasena = '"+usucontrasena1+"', usuTipoId = '"+usutipoId1+"', usuNombres = '"+usuNombre1+"', usuApellidos = '"+usuApellido1+"', usuDireccion = '"+usuDireccion1+"', usuCorreo = '"+usuCorreo1+"', usuTelefono = '"+usuTelefono1+"', tblestados_estId = "+usuEstado1+",tblroles_rolId="+usuRol1+"  WHERE usuId = "+usuId2+" ");
                JOptionPane.showMessageDialog(null, "USUARIO ACTUALIZADO CORRECTAMENTE!!!", "", -1);
        } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: "+e.getMessage(), "", -1);
        }        
    }
    
    public void consultarUsuario(JTextField txtusuId , JPasswordField txtusucontrasena, JTextField txtusutipoId , JTextField txtusuNombre , JTextField txtusuApellido , JTextField txtusuDireccion , JTextField txtusuCorreo , JTextField txtusuTelefono , JTextField txtusuEstado , JTextField txtusuRol){
        
        int usuId3=Integer.parseInt(txtusuId.getText());
        String usuNombre2=txtusuNombre.getText();
        String usuApellido2=txtusuApellido.getText();
        
                try {
                //apertura del bufer para transaccion de datos
                Statement s = conector.obtenerConexion().createStatement();
                ResultSet rs = s.executeQuery(" SELECT usuId, usuContrasena, usuTipoId, usuNombres, usuApellidos, usuDireccion, usuCorreo, usuTelefono, tblestados_estId, tblroles_rolId FROM `bd_fruversoft`.`tblusuarios` WHERE usuId = "+usuId3 );
                
                while(rs.next()){
                    txtusuId.setText(rs.getString(1));
                    txtusucontrasena.setText(rs.getString(2));
                    txtusutipoId.setText(rs.getString(3));                    
                    txtusuNombre.setText(rs.getString(4));
                    txtusuApellido.setText(rs.getString(5));
                    txtusuDireccion.setText(rs.getString(6));
                    txtusuCorreo.setText(rs.getString(7));
                    txtusuTelefono.setText(rs.getString(8));                   
                    txtusuEstado.setText(rs.getString(9));
                    txtusuRol.setText(rs.getString(10));
                }
                
        } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR: "+e.getMessage(), "", -1);
        }

        
    }
    
    
}
