/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Conexion;

/**
 *
 * @author Javier
 */
public class crud_usuario {
    
    Conexion conector = new Conexion();
    
   public int  usuId;
   public String usuContrasena;
   public String usuTipoId; 
   public String usuNombres;
   public String usuApellidos;
   public String usuDireccion;
   public String usuCorreo; 
   public String usuTelefono; 
   public int tblestados_estId; 
   public int tblroles_rolId;

    public crud_usuario(int usuId, String usuContrasena, String usuTipoId, String usuNombres, String usuApellidos, String usuDireccion, String usuCorreo, String usuTelefono, int tblestados_estId, int tblroles_rolId) {
        this.usuId = usuId;
        this.usuContrasena = usuContrasena;
        this.usuTipoId = usuTipoId;
        this.usuNombres = usuNombres;
        this.usuApellidos = usuApellidos;
        this.usuDireccion = usuDireccion;
        this.usuCorreo = usuCorreo;
        this.usuTelefono = usuTelefono;
        this.tblestados_estId = tblestados_estId;
        this.tblroles_rolId = tblroles_rolId;
    }

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

    public int getTblroles_rolId() {
        return tblroles_rolId;
    }

    public void setTblroles_rolId(int tblroles_rolId) {
        this.tblroles_rolId = tblroles_rolId;
    }
   
   
   public void registrarUsuario( ){
   }
   public void consultarUsuario(){
   }   
   public void actualizarUsuario(){
   }   
   public void eliminarUsuario(){
   }    
}
