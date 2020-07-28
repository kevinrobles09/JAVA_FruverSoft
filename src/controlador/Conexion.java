/*Administación de la conexión con la base de datos bd_fruversoft*/
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Pava
 */
public class Conexion {
    public Connection cnx=null; //Objeto para iniciar la conexion con MYSQL
    
    //Abrir conexion y Retornar un objeto con la conexión abierta
    public Connection obtenerConexion() throws ClassNotFoundException{
          if(cnx==null){ //Validar si la conexión esta cerrada.
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); //Drive de Conexión
                cnx=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_fruversoft?serverTimezone=UTC&useSSL=false","root","1083568082");
                
             } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showConfirmDialog(null, "Error: "+e.getMessage());
                System.out.println("Error: "+e.getMessage());
                
            }
        }
        return cnx;
    }
   
    
}
