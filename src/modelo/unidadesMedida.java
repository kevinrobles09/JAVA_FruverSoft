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
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Javier
 */
public class unidadesMedida {
    
    Conexion conector = new Conexion();
   
    //REGISTRAR UNIDAD MEDIDAS
    public void registrarUnidadMedidas(JTextField txtCodigo, JTextField txtDenominacion, JTextField txtAbreviatura, JTextArea JarObservaciones) {
        int codigo = Integer.parseInt(txtCodigo.getText());
        String denominacion = txtDenominacion.getText();    
        String abreviatuta = txtAbreviatura.getText();  
        String observacion = JarObservaciones.getText();  
        
        try {
            //Usar el buffer para ejecutar transacciones
            Statement s = conector.obtenerConexion().createStatement(); 
            s.executeUpdate(" INSERT INTO `bd_fruversoft`.`tblunidadmedidas` (uniID, uniDenominacion, uniAbreviatura, uniObservaciones) VALUES ("+codigo+", '"+denominacion+"', '"+abreviatuta+"', '"+observacion+"') ");
            JOptionPane.showMessageDialog(null, "UNIDAD DE MEDIDA REGISTRADA", "", -1);      

        } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR 2: "+e.getMessage(), "", -1);
        }
    }
    
    //ACTUALIZAR UNIDAD MEDIDAS
    public void actualizarUniMed( JTextField txtCodigo, JTextField txtDenominacion, JTextField txtAbreviatura, JTextArea JarObservaciones) {
        int codigo = Integer.parseInt(txtCodigo.getText());
        String denominacion = txtDenominacion.getText();    
        String abreviatuta = txtAbreviatura.getText();  
        String observacion = JarObservaciones.getText();  
      
        
        try {
            //Usar el buffer para ejecutar transacciones
            Statement s = conector.obtenerConexion().createStatement(); 
            s.executeUpdate(" UPDATE `bd_fruversoft`.`tblunidadmedidas` SET `uniID` = "+codigo+", `uniDenominacion`= '"+denominacion+"', `uniAbreviatura` = '"+abreviatuta+"', `uniObservaciones`= '"+observacion+"' WHERE `uniId` = "+codigo+" ");
            JOptionPane.showMessageDialog(null, "UNIDAD DE MEDIDA ACTUALIZADA", "", -1);      

        } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR 2: "+e.getMessage(), "", -1);
        }
    }

    //ELIMINAR UNNIDAD DE MEDIDAS
    public void EliminarUniMed(JTextField txtCodigo, JTextField txtDenominacion, JTextField txtAbreviatura, JTextArea JarObservaciones) {
        int codigo = Integer.parseInt(txtCodigo.getText());
        
        try {
            //Usar el buffer para ejecutar transacciones
            Statement s = conector.obtenerConexion().createStatement(); 
            s.executeUpdate(" DELETE FROM `bd_fruversoft`.`tblunidadmedidas` WHERE uniId = "+codigo+" ");
            JOptionPane.showMessageDialog(null, "UNIDAD DE MEDIDA ELIMINADA", "", -1);   
            txtCodigo.setText("");
            txtAbreviatura.setText("");
            txtDenominacion.setText("");
            JarObservaciones.setText("");

        } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR 2: "+e.getMessage(), "", -1);
        }

    }
        //CONSULTAR UNNIDAD DE MEDIDAS
    public void consultarUniMedUniMed( JTextField txtCodigo, JTextField txtDenominacion, JTextField txtAbreviatura, JTextArea JarObservaciones) {
        int codigo = Integer.parseInt(txtCodigo.getText());
        
        try {
            //Usar el buffer para ejecutar transacciones
            Statement s = conector.obtenerConexion().createStatement(); 
            ResultSet rs = s.executeQuery(" SELECT uniId, uniDenominacion, uniAbreviatura, uniObservaciones FROM `bd_fruversoft`.`tblunidadmedidas` WHERE `uniId` = "+codigo+" ");
            
            while(rs.next()){
                txtCodigo.setText(rs.getString(1));
                txtDenominacion.setText(rs.getString(2));
                txtAbreviatura.setText(rs.getString(3));
                JarObservaciones.setText(rs.getString(4));
            }

        } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR 2: "+e.getMessage(), "", -1);
        }
    }    


    
}
