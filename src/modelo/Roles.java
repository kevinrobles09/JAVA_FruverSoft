package modelo;

import controlador.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Luis Pava
 */
public class Roles {
    int estId;
    String estDescripcion;
    //Objeto para gestionar conexión
    Conexion conector=new Conexion();
    
    public void registrarRol(JTextField txtCodRol, JTextField txtDesRol){
        try {
            Statement s = conector.obtenerConexion().createStatement();
            s.executeUpdate("INSERT INTO tblroles (rolId, rolNombre) VALUES ("+Integer.parseInt(txtCodRol.getText())+",'"+txtDesRol.getText()+"')");
            JOptionPane.showConfirmDialog(null, "Rol Registrado.");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, "Error: "+e);
        }
    }
    
    public void consultarRol(JTextField txtCodRol, JTextField txtDesRol){
        try {
            Statement s = conector.obtenerConexion().createStatement();
            ResultSet rs = s.executeQuery ("SELECT rolId, rolNombre FROM tblroles WHERE rolId="+Integer.parseInt(txtCodRol.getText()));
            while (rs.next()){
                     txtDesRol.setText(rs.getString(2));
                   }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, "Error: "+e);
        }
    }
    
    public void eliminarRol(JTextField txtCodRol, JTextField txtDesRol){
        try {
            Statement s = conector.obtenerConexion().createStatement();
                        
            int res=JOptionPane.showConfirmDialog(null,"¿Desea eliminar el Rol: "+txtDesRol.getText()+"?");
            
            if (res==JOptionPane.OK_OPTION) {
                //txtCodigo.setText("");
                //txtDescripcion.setText("");
                s.executeUpdate("DELETE FROM tblroles where rolId="+Integer.parseInt(txtCodRol.getText()));
                JOptionPane.showConfirmDialog(null, "Rol Eliminado.");
            } else {
                JOptionPane.showConfirmDialog(null, "Proceso Cancelado");
            }
           
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, "Error: "+e);
        }
    }
    
    public void actualizarRol(JTextField txtCodRol, JTextField txtDesRol){
        try {
            int res=JOptionPane.showConfirmDialog(null,"¿Desea Actualizar el Rol: "+txtDesRol.getText()+"?");
            
            if (res==JOptionPane.OK_OPTION) {
                Statement s = conector.obtenerConexion().createStatement();
                s.executeUpdate("UPDATE tblroles SET rolNombre='"+txtDesRol.getText()+"' WHERE rolId="+Integer.parseInt(txtCodRol.getText()));
                txtCodRol.setText("");
                txtDesRol.setText("");
                JOptionPane.showConfirmDialog(null, "Rol Actualizado.");
            } else {
                JOptionPane.showConfirmDialog(null, "Proceso Cancelado");
            }
           
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, "Error: "+e);
        }
    }
    
}
