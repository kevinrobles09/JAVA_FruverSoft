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
public class Estados {
    int estId;
    String estDescripcion;
    //Objeto para gestionar conexión
    Conexion conector=new Conexion();
    
    public void registrarEstado(JTextField txtCodigo, JTextField txtDescripcion){
        try {
            Statement s = conector.obtenerConexion().createStatement();
            s.executeUpdate("INSERT INTO tblestados (estId, estDescripcion) VALUES ("+Integer.parseInt(txtCodigo.getText())+",'"+txtDescripcion.getText()+"')");
            JOptionPane.showConfirmDialog(null, "Estado Registrado.");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, "Error: "+e);
        }
    }
    
    public void consultarEstado(JTextField txtCodigo, JTextField txtDescripcion){
        try {
            Statement s = conector.obtenerConexion().createStatement();
            ResultSet rs = s.executeQuery ("SELECT estId, estDescripcion FROM tblestados WHERE estId="+Integer.parseInt(txtCodigo.getText()));
            while (rs.next()){
                     txtDescripcion.setText(rs.getString(2));
                   }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, "Error: "+e);
        }
    }
    
    public void eliminarEstado(JTextField txtCodigo, JTextField txtDescripcion){
        try {
            Statement s = conector.obtenerConexion().createStatement();
                        
            int res=JOptionPane.showConfirmDialog(null,"¿Desea eliminar el estado: "+txtDescripcion.getText()+"?");
            
            if (res==JOptionPane.OK_OPTION) {
                //txtCodigo.setText("");
                //txtDescripcion.setText("");
                s.executeUpdate("DELETE FROM tblestados where estId="+Integer.parseInt(txtCodigo.getText()));
                JOptionPane.showConfirmDialog(null, "Estado Eliminado.");
            } else {
                JOptionPane.showConfirmDialog(null, "Proceso Cancelado");
            }
           
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, "Error: "+e);
        }
    }
    
    public void actualizarEstado(JTextField txtCodigo, JTextField txtDescripcion){
        try {
            int res=JOptionPane.showConfirmDialog(null,"¿Desea Actualizar el estado: "+txtDescripcion.getText()+"?");
            
            if (res==JOptionPane.OK_OPTION) {
                Statement s = conector.obtenerConexion().createStatement();
                s.executeUpdate("UPDATE tblestados SET estDescripcion='"+txtDescripcion.getText()+"' WHERE estId="+Integer.parseInt(txtCodigo.getText()));
                txtCodigo.setText("");
                txtDescripcion.setText("");
                JOptionPane.showConfirmDialog(null, "Estado Actualizado.");
            } else {
                JOptionPane.showConfirmDialog(null, "Proceso Cancelado");
            }
           
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, "Error: "+e);
        }
    }
    
}
