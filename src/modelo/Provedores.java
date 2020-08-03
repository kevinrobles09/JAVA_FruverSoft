/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JTextField;

/**
 *
 * @author Javier Sepulveda Arboleda
 */
public class Provedores {
    
    public int proId;
    public String proNombre; 
    public String proVencimiento; 
    public String prodPrecio;
    public String tblclasificaciones_claId; 
    public String tblunidadmedidas_uniId; 
    private int tblproveedores_proId;
    
    
    // contructor
    public Provedores(int proId, String proNombre, String proVencimiento, String prodPrecio, String tblclasificaciones_claId, String tblunidadmedidas_uniId, int tblproveedores_proId){
        this.proId = proId;
        this.proNombre = proNombre;
        this.proVencimiento = proVencimiento;
        this.prodPrecio = prodPrecio;
        this.tblclasificaciones_claId = tblclasificaciones_claId;
        this.tblunidadmedidas_uniId = tblunidadmedidas_uniId;
        this.tblproveedores_proId = tblproveedores_proId;
    }

    
    //metodos get y set 
    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public String getProVencimiento() {
        return proVencimiento;
    }

    public void setProVencimiento(String proVencimiento) {
        this.proVencimiento = proVencimiento;
    }

    public String getProdPrecio() {
        return prodPrecio;
    }

    public void setProdPrecio(String prodPrecio) {
        this.prodPrecio = prodPrecio;
    }

    public String getTblclasificaciones_claId() {
        return tblclasificaciones_claId;
    }

    public void setTblclasificaciones_claId(String tblclasificaciones_claId) {
        this.tblclasificaciones_claId = tblclasificaciones_claId;
    }

    public String getTblunidadmedidas_uniId() {
        return tblunidadmedidas_uniId;
    }

    public void setTblunidadmedidas_uniId(String tblunidadmedidas_uniId) {
        this.tblunidadmedidas_uniId = tblunidadmedidas_uniId;
    }

    public int getTblproveedores_proId() {
        return tblproveedores_proId;
    }

    public void setTblproveedores_proId(int tblproveedores_proId) {
        this.tblproveedores_proId = tblproveedores_proId;
    }
    
    public void ingresarProductos( ){
        
    }
    public void actualizarproductos( ){
        
    }    
    public void eliminarProductos( ){
        
    }
    public void consultarProductos( ){
        
    }    
}
