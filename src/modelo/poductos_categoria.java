
package modelo;

import com.mysql.cj.conf.ConnectionUrl;
import controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Kevin Robles
 */
public class poductos_categoria {
    public void verCategoia(String tipodeproducto){
        Conexion cc = new Conexion();
        Connection miConexion;
        PreparedStatement miCurso;
        ResultSet rs;
        String catedoria= tipodeproducto;
        
        String sql= "";
        
        try {
            
        } catch (Exception e) {
        }
        
        
    }
}
