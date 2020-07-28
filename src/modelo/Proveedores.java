/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Luis Pava
 */
public class Proveedores {
    public int proI;
    public String proNombre;
    public String proDireccion;
    public String proTelefono;
    public String proCorreo;
    public int tblestados_estId;

    public Proveedores(int proI, String proNombre, String proDireccion, String proTelefono, String proCorreo, int tblestados_estId) {
        this.proI = proI;
        this.proNombre = proNombre;
        this.proDireccion = proDireccion;
        this.proTelefono = proTelefono;
        this.proCorreo = proCorreo;
        this.tblestados_estId = tblestados_estId;
    }

    public int getProI() {
        return proI;
    }

    public void setProI(int proI) {
        this.proI = proI;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public String getProDireccion() {
        return proDireccion;
    }

    public void setProDireccion(String proDireccion) {
        this.proDireccion = proDireccion;
    }

    public String getProTelefono() {
        return proTelefono;
    }

    public void setProTelefono(String proTelefono) {
        this.proTelefono = proTelefono;
    }

    public String getProCorreo() {
        return proCorreo;
    }

    public void setProCorreo(String proCorreo) {
        this.proCorreo = proCorreo;
    }

    public int getTblestados_estId() {
        return tblestados_estId;
    }

    public void setTblestados_estId(int tblestados_estId) {
        this.tblestados_estId = tblestados_estId;
    }
    
    public void registarProveedores(){
    }
    public void consultarProveedores(){
    }
    public void actualizarProveedores(){
    }
    public void eliminarProveedores(){
    }
    
}
