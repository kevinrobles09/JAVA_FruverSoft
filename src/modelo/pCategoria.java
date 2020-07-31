
package modelo;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import com.mysql.cj.jdbc.result.ResultSetImpl;
import controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin Robles
 */
public class pCategoria {
    public void verCategoria (){
        Conexion cc = new Conexion();
        Connection miConexion;
        PreparedStatement miCurso;
        ResultSet rs;
        
        try {
              miConexion=cc.obtenerConexion();
              miCurso=miConexion.prepareStatement("SELECT * FROM tblproveedores");
              rs=miCurso.executeQuery();
              
              while (rs.next()){
                  String aa=rs.getString(1);
                  JOptionPane.showMessageDialog(null, aa);
              }
             
              
        } catch (Exception e) {
        }
      
        
    }
    public static void main(String[] args) {
        pCategoria vv = new pCategoria();
        vv.verCategoria();
    }
}
