package modelo;


import controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.JTextField;
import vista.Inicio;
import vista.productosVistaPrincipal;

/**
 *
 * @author Kevin Robles
 */
public class iniciarSesion {
    public void entrar(JTextField txtusuId, JTextField txtusuContrasena, JLabel lblMensaje) {
        String usuario  = txtusuId.getText();
        String password = txtusuContrasena.getText();
        
        try {
            String usuarioCorrecto = null;
            String passwordCorrecta = null;
            String tipoUsuario= null;
            
            Conexion cn = new Conexion();
            Connection miConexion=cn.obtenerConexion();
            PreparedStatement miCursor;
            ResultSet rs;
            
            miCursor=miConexion.prepareStatement("SELECT usuId, usuContrasena, tblroles_rolId FROM tblusuarios WHERE usuId= ?");
            miCursor.setString(1, txtusuId.getText());
            rs = miCursor.executeQuery();
                  
            
                 if (rs.next()) {
                    usuarioCorrecto = rs.getString(1);
                    passwordCorrecta = rs.getString(2);
                    tipoUsuario = rs.getString(3);
                    
                 }
                 
                 if (usuarioCorrecto != null && password !=null && password.equals(passwordCorrecta)){                
                       if (tipoUsuario.equals("1")){
                           
                           
                           System.out.println("bienvenido administrador");
                           productosVistaPrincipal llamadaAdmin = new productosVistaPrincipal();
                           llamadaAdmin.setVisible(true);
                         
                           
                            
                       }else{
                           System.out.println("no eres administrador");
                           productosVistaPrincipal llamadaCliente = new productosVistaPrincipal();
                           llamadaCliente.btnInsertar.setVisible(false);
                           llamadaCliente.btneliminar.setVisible(false);
                           llamadaCliente.btnmodificar.setVisible(false);
                           llamadaCliente.setVisible(true);
                                                                               
                       }
                      
                 }else{
                     
                     lblMensaje.setText("Usuario o Contraseña incorrecta");
                 }
            
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }
}
