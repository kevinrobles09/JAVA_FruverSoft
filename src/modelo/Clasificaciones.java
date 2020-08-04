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
 * @author Javier
 */
public class Clasificaciones {
    // instancia de la clase conexion 
    Conexion conector = new Conexion();
    
        //REGISTRAR CLASIFICACION
    public void registrarClasificaciones(JTextField txtclaId, JTextField txtclaDes) {
        int id = Integer.parseInt(txtclaId.getText());
        String descripcion= txtclaDes.getText();
        
        try {
            //Usar el buffer para ejecutar transacciones
            Statement s = conector.obtenerConexion().createStatement(); 
            s.executeUpdate(" INSERT INTO `bd_fruversoft`.`tblclasificaciones` (`claId`, `claDenominacion`) VALUES ("+id+", '"+descripcion+"') ");
            JOptionPane.showMessageDialog(null, "CLASIFICACION REGISTRADA", "", -1);      

        } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR 2: "+e.getMessage(), "", -1);
        }
    }
    
    //ELIMINAR CLASIFICACIONES
    public void EliminarClasificaciones(JTextField txtclaId, JTextField txtclaDes) {
        int ID = Integer.parseInt(txtclaId.getText());
        
        try {
            //Usar el buffer para ejecutar transacciones
            Statement s = conector.obtenerConexion().createStatement(); 
            s.executeUpdate(" DELETE FROM `bd_fruversoft`.`tblclasificaciones` WHERE `claId` = "+ID+" ");
            JOptionPane.showMessageDialog(null, "CLASIFICACION ELIMINADA!", "", -1);  
            txtclaId.setText("");
            txtclaDes.setText("");

        } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR 2: "+e.getMessage(), "", -1);
        }

    }    
    
      //CONSULTAR CLASIFICACIONES
    public void consultarClasificaciones(JTextField txtclaId, JTextField txtclaDes) {
        int Id = Integer.parseInt(txtclaId.getText());
        
        try {
            //Usar el buffer para ejecutar transacciones
            Statement s = conector.obtenerConexion().createStatement(); 
            ResultSet rs = s.executeQuery(" SELECT claID, claDenominacion FROM `bd_fruversoft`.`tblclasificaciones` WHERE `claId` = "+Id+" ");
            
            while(rs.next()){
                txtclaId.setText(rs.getString(1));
                txtclaDes.setText(rs.getString(2));
            }
            
        } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR 2: "+e.getMessage(), "", -1);
        }


    }

    //ACTUALIZAR CLASIFICACIONES
    public void actualizarClasificacion(JTextField txtclaId, JTextField txtclaDes) {
        int Id1= Integer.parseInt(txtclaId.getText());
        String denominacion = txtclaDes.getText();
        
        try {
            //Usar el buffer para ejecutar transacciones
            Statement s = conector.obtenerConexion().createStatement(); 
            s.executeUpdate(" UPDATE `bd_fruversoft`.`tblclasificaciones` SET `claID` = "+Id1+", `claDenominacion`= '"+denominacion+"' WHERE `claID` = "+Id1+" ");
            JOptionPane.showMessageDialog(null, "CLASIFICACION ACTUALIZADA", "", -1);      

        } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR 2: "+e.getMessage(), "", -1);
        }
    }    
    
}
