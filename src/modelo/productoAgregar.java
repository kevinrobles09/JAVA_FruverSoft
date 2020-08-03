/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JTextField;

/** METODO DE PRUEBA no está terminada
 *
 * @author Kevin Robles
 */
public class productoAgregar {
    public void agregar (JTextField txtproductoId, JTextField txtproductoNombre, JTextField txtproductoFecha,
                        JTextField txtproductoPrecio, JTextField txtproductoClasifiacion, JTextField txtunidadMedida,
                        JTextField txtproductoProveedor){
        
        Connection miConexion;
        Conexion cn = new Conexion();
        PreparedStatement miCursor;
        
        try {
            
        } catch (Exception e) {
        }
    
    }
    
}
