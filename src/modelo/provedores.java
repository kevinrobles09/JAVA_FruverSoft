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
import javax.swing.JTextField;

/**
 *
 * @author Javier sepulveda
 */
public class provedores {
    Conexion conector = new Conexion();
 
        //registrar provedores
        public void RegistrarProveedores(JTextField txtProid , JTextField txtProNombre, JTextField txtProDireccion, JTextField txtProTelefono, JTextField txtProCorrreo, JTextField txtProEstado ) {
        //almacenamos los datos en las variables
        int idPro = Integer.parseInt(txtProid.getText());
        String nombreProveedor = txtProNombre.getText();
        String Direccion = txtProDireccion.getText();
        String Telefono = txtProTelefono.getText();
        String Correo = txtProCorrreo.getText();
        int estado = Integer.parseInt(txtProEstado.getText());
        
        
        
        try {
            //transaccion de datos por el bufer
            Statement s = conector.obtenerConexion().createStatement(); 
            s.executeUpdate(" INSERT INTO `bd_fruversoft`.`tblproveedores` (proId, proNombre, proDireccion, proTelefono, proCorreo, tblestados_estId) VALUES ("+idPro+", '"+nombreProveedor+"', '"+Direccion+"', '"+Telefono+"', '"+Correo+"', "+estado+") ");
            JOptionPane.showMessageDialog(null, "PROVEEDOR REGISTRADO", "", -1);      

        } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR 2: "+e.getMessage(), "", -1);
        }
    }
        
        // consultar provedores
        public void ConsultarProveedor(JTextField txtProid , JTextField txtProNombre, JTextField txtProDireccion, JTextField txtProTelefono, JTextField txtProCorrreo, JTextField txtProEstado) {
        int idpro = Integer.parseInt(txtProid.getText());
        
        try {
            //transaccion de datos por el bufer
            Statement s = conector.obtenerConexion().createStatement(); 
            ResultSet rs = s.executeQuery(" SELECT proId, proNombre, proDireccion, proTelefono, proCorreo, tblestados_estId FROM bd_fruversoft.tblproveedores WHERE proId = "+idpro+" ");
            
            // matriz temporal
            while (rs.next()){
                 txtProid.setText(rs.getString(1)); 
                 txtProNombre.setText(rs.getString(2)); 
                 txtProDireccion.setText(rs.getString(3)); 
                 txtProTelefono.setText(rs.getString(4)); 
                 txtProCorrreo.setText(rs.getString(5)); 
                 txtProEstado.setText(rs.getString(6)); 
            }
        } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR 2: "+e.getMessage(), "", -1);
        }

    }
        
    //ACTUALIZAR DE PROVEEDORES
    public void ActualizarProveedor(JTextField txtProid , JTextField txtProNombre, JTextField txtProDireccion, JTextField txtProTelefono, JTextField txtProCorrreo, JTextField txtProEstado) {
        int idActualizar = Integer.parseInt(txtProid.getText());
        
        String nombreProveedor = txtProNombre.getText();
        String Direccion = txtProDireccion.getText();
        String Telefono = txtProTelefono.getText();
        String Correo = txtProCorrreo.getText();
        int estado = Integer.parseInt(txtProEstado.getText());
        try {
            //transaccion de datos por el bufer
            Statement s = conector.obtenerConexion().createStatement(); 
            s.executeUpdate(" UPDATE `bd_fruversoft`.`tblproveedores` SET `proNombre` = '"+nombreProveedor+"', `proDireccion` = '"+Direccion+"', `proTelefono` = '"+Telefono+"', `proCorreo` = '"+Correo+"', `tblestados_estId` = "+estado+" WHERE `proId` = "+idActualizar+" ");
            
            JOptionPane.showMessageDialog(null, "PROVEDOR ACTUALIZADO!", "", -1);
            
        } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR 2: "+e.getMessage(), "", -1);
        }
    }
    
        //ELIMINAR DE PROVEEDORES
    public void eliminarproveedor(JTextField txtProid) {
        int idproeliminar = Integer.parseInt(txtProid.getText());
        
        try {
            //transaccion de datos por el bufer
            Statement s = conector.obtenerConexion().createStatement(); 
            s.executeUpdate(" DELETE FROM `bd_fruversoft`.`tblproveedores` WHERE proId = "+idproeliminar+" ");
            
            JOptionPane.showMessageDialog(null, "PROVEEDOR ELIMINADO!!", "", -1);
            
        } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR 2: "+e.getMessage(), "", -1);
        }
    }
    
}
