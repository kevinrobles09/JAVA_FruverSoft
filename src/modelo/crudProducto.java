
package modelo;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Kevin Robles
 */
public class crudProducto {
    public void buscar (JTextField txtbuscarpro, JTextField txtproductoId, JTextField txtproductoNombre,
            JTextField txtproductoFecha, JTextField txtproductoPrecio, JTextField txtproductoClasifiacion,
            JTextField txtunidadMedida, JTextField txtidprovedor){
        
        Conexion cc =new Conexion();
        Connection miConexion;
        Statement miCursor;
        ResultSet rs;
        
         if("".equals(txtbuscarpro.getText())){
             JOptionPane.showMessageDialog(null, "El Campo está vacio");
         }else{
             
         
        try {
            miConexion=cc.obtenerConexion();
            miCursor=miConexion.createStatement();
            rs = miCursor.executeQuery("SELECT * FROM tblproductos WHERE proId="+ txtbuscarpro.getText());     
            
            if(rs.next()){
                txtproductoId.setText(rs.getString(1));
                txtproductoNombre.setText(rs.getString(2));
                txtproductoFecha.setText(rs.getString(3));
                txtproductoPrecio.setText(rs.getString(4));
                txtproductoClasifiacion.setText(rs.getString(5));
                txtunidadMedida.setText(rs.getString(6));
                txtidprovedor.setText(rs.getString(7));
                System.out.println(rs.getString(7));
            }
           
                
            JOptionPane.showMessageDialog(null, "Encontrado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROE");
        }
         }
    }
    
     public void modificar (JTextField txtbuscarpro, JTextField txtproductoId, JTextField txtproductoNombre,
            JTextField txtproductoFecha, JTextField txtproductoPrecio, JTextField txtproductoClasifiacion,
            JTextField txtunidadMedida, JTextField txtidprovedor){
        
         if("".equals(txtbuscarpro.getText())){
             JOptionPane.showMessageDialog(null, "El Campo está vacio");
         }else{
        Conexion cc =new Conexion();
        Connection miConexion;
        PreparedStatement miCursor;
        //ResultSet rs;
        
        String sql = "UPDATE tblproductos\n" +
                     "SET\n" +
                     "proId = ?,\n" +
                     "proNombre = ?,\n" +
                     "proVencimiento = ?,\n" +
                     "prodPrecio = ?,\n" +
                     "tblclasificaciones_claId = ?,\n" +
                     "tblunidadmedidas_uniId = ?,\n" +
                     "tblproveedores_proId = ?\n" +
                     "WHERE proId = ?;";
        
        try {
            miConexion = cc.obtenerConexion();
            miCursor = miConexion.prepareStatement(sql);
                 

                miCursor.setString(1, txtproductoId.getText());
                miCursor.setString(2, txtproductoNombre.getText());
                miCursor.setString(3, txtproductoFecha.getText());
                miCursor.setString(4, txtproductoPrecio.getText());
                miCursor.setString(5, txtproductoClasifiacion.getText());
                miCursor.setString(6, txtunidadMedida.getText());
                miCursor.setString(7, txtidprovedor.getText());
                miCursor.setString(8, txtbuscarpro.getText());
                
                miCursor.executeUpdate();
             
            JOptionPane.showMessageDialog(null, "Registro Actualizado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROE");
        }
         }
    }
     
          public void eliminar (JTextField txtbuscarpro, JTextField txtproductoId, JTextField txtproductoNombre,
            JTextField txtproductoFecha, JTextField txtproductoPrecio, JTextField txtproductoClasifiacion,
            JTextField txtunidadMedida, JTextField txtidprovedor){
        
        Conexion cc =new Conexion();
        Connection miConexion;
        PreparedStatement miCursor;
        //ResultSet rs;
        
        String sql = "DELETE FROM tblproductos WHERE proId= ?";
         if("".equals(txtbuscarpro.getText())){
             JOptionPane.showMessageDialog(null, "Revise los campos");
         }else{
             
         
        try {
            miConexion=cc.obtenerConexion();
            miCursor=miConexion.prepareStatement(sql);
            miCursor.setString(1, txtbuscarpro.getText());
            miCursor.executeUpdate();
            miConexion.close();     

             txtproductoId.setText("");
             txtproductoNombre.setText("");
             txtproductoFecha.setText("");
             txtproductoPrecio.setText("");
             txtproductoClasifiacion.setText("");
             txtunidadMedida.setText("");
             txtidprovedor.setText("");
             txtbuscarpro.setText("");
                
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROE");
        }
         }
    }
          
   public void agregar (JTextField txtproductoId, JTextField txtproductoNombre,
            JTextField txtproductoFecha, JTextField txtproductoPrecio, JTextField txtproductoClasifiacion,
            JTextField txtunidadMedida, JTextField txtidprovedor){
        
        Conexion cc =new Conexion();
        Connection miConexion;
        PreparedStatement miCursor;
        //ResultSet rs;
        
        String sql = "INSERT INTO tblproductos (proId, proNombre, proVencimiento, prodPrecio, \n" +
                     "tblclasificaciones_claId, tblunidadmedidas_uniId, tblproveedores_proId)\n" +
                     "VALUES (?,?,?,?,?,?,?)";
        
         if("".equals(txtproductoId.getText())){
             JOptionPane.showMessageDialog(null, "Revise los campos");
         }else{
             
         
        try {
            miConexion=cc.obtenerConexion();
            miCursor=miConexion.prepareStatement(sql);
               
            
               miCursor.setString(1, txtproductoId.getText());
               miCursor.setString(2, txtproductoNombre.getText());
               miCursor.setString(3, txtproductoFecha.getText());
               miCursor.setString(4, txtproductoPrecio.getText());
               miCursor.setString(5, txtproductoClasifiacion.getText());
               miCursor.setString(6, txtunidadMedida.getText());
               miCursor.setString(7, txtidprovedor.getText());
              
            miCursor.executeUpdate();
            miConexion.close();  
            
             txtproductoId.setText("");
             txtproductoNombre.setText("");
             txtproductoFecha.setText("");
             txtproductoPrecio.setText("");
             txtproductoClasifiacion.setText("");
             txtunidadMedida.setText("");
             txtidprovedor.setText("");
             
                
            JOptionPane.showMessageDialog(null, "Agregado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROE");
        }
         }
    }
        
}
