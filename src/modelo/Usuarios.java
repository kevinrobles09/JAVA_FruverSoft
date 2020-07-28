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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Luis Pava
 */
public class Usuarios {
    Conexion conector=new Conexion();
    
    public int usuId;
    public String usuContrasena;
    public String usuTipoId;
    public String usuNombres;
    public String usuApellidos;
    public String usuDireccion;
    public String usuCorreo;
    public String usuTelefono;
    public int tblestados_estId;

    //Constructor de la Clase Usuario
    public Usuarios(int usuId, String usuContrasena, String usuTipoId, String usuNombres, String usuApellidos, String usuDireccion, String usuCorreo, String usuTelefono, int tblestados_estId) {
        this.usuId = usuId;
        this.usuContrasena = usuContrasena;
        this.usuTipoId = usuTipoId;
        this.usuNombres = usuNombres;
        this.usuApellidos = usuApellidos;
        this.usuDireccion = usuDireccion;
        this.usuCorreo = usuCorreo;
        this.usuTelefono = usuTelefono;
        this.tblestados_estId = tblestados_estId;
    }

    public Usuarios() {}
    
    public int getUsuId() {
        return usuId;
    }

    public void setUsuId(int usuId) {
        this.usuId = usuId;
    }

    public String getUsuContrasena() {
        return usuContrasena;
    }

    public void setUsuContrasena(String usuContrasena) {
        this.usuContrasena = usuContrasena;
    }

    public String getUsuTipoId() {
        return usuTipoId;
    }

    public void setUsuTipoId(String usuTipoId) {
        this.usuTipoId = usuTipoId;
    }

    public String getUsuNombres() {
        return usuNombres;
    }

    public void setUsuNombres(String usuNombres) {
        this.usuNombres = usuNombres;
    }

    public String getUsuApellidos() {
        return usuApellidos;
    }

    public void setUsuApellidos(String usuApellidos) {
        this.usuApellidos = usuApellidos;
    }

    public String getUsuDireccion() {
        return usuDireccion;
    }

    public void setUsuDireccion(String usuDireccion) {
        this.usuDireccion = usuDireccion;
    }

    public String getUsuCorreo() {
        return usuCorreo;
    }

    public void setUsuCorreo(String usuCorreo) {
        this.usuCorreo = usuCorreo;
    }

    public String getUsuTelefono() {
        return usuTelefono;
    }

    public void setUsuTelefono(String usuTelefono) {
        this.usuTelefono = usuTelefono;
    }

    public int getTblestados_estId() {
        return tblestados_estId;
    }

    public void setTblestados_estId(int tblestados_estId) {
        this.tblestados_estId = tblestados_estId;
    }
            
    
    public void validarUsuarios(JTextField txtusuId, JTextField txtcontrasena, JLabel lblMensaje){
            //Declarar objetos para iniciar la comparar
            int usuarioBD=0;
            String contrasenaBD = "";
            String nombresBD="", apellidosBD="";
            
            try {
                //Usar el buffer para ejecutar transacciones
                Statement s = conector.obtenerConexion().createStatement();
                
                ResultSet rs = s.executeQuery ("SELECT usuId, usuContrasena, usuNombres, usuApellidos  FROM tblusuarios WHERE usuId="+Integer.parseInt(txtusuId.getText()));

                while (rs.next()){
                     usuarioBD=rs.getInt(1);
                     contrasenaBD=rs.getString(2);
                     nombresBD=rs.getString(3);
                     apellidosBD=rs.getString(4);
                    }
                
                //System.out.println("Usuario: "+usuario+"\nContraseña: "+contrasena);
                if (contrasenaBD.equals(txtcontrasena.getText()) && usuarioBD==Integer.parseInt(txtusuId.getText())) {
                    //JOptionPane.showConfirmDialog(null,"Bienvenido al FruverSoft: "+nombresBD+" "+apellidosBD);
                    lblMensaje.setText("Bienvenido al FruverSoft: "+nombresBD+" "+apellidosBD);
                }else{
                    //JOptionPane.showConfirmDialog(null,"Verificar Contraseña.");
                    lblMensaje.setText("Verificar Contraseña.");
                }
                                
            } catch (HeadlessException | ClassNotFoundException | NumberFormatException | SQLException e) {
                JOptionPane.showConfirmDialog(null,"Error: "+e.getMessage());
            }
        }
}
