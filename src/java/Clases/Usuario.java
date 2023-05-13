/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author cruzf
 */
public class Usuario {
    private String Nombre;
    private String Apellido;
    private String Usu;
    private String Contra;
    private String Correo;
    private String Cargo;
    private String ecronica;
    private String Notele;
    private String Seguridad;
    private String nac;
    private String especialidad;
    private byte[] certificado;

    public byte[] getCertificado() {
        return certificado;
    }

    public void setCertificado(byte[] certificado) {
        this.certificado = certificado;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    private int id;

    public Usuario(String Nombre, String Apellido, String Correo, String Cargo, 
            String Notele, String ecronica, String Seguridad, String nac, String Usu, String Contra,int id) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Usu=Usu;
        this.Contra=Contra;
        this.Correo=Correo;
        this.Cargo=Cargo;
        this.ecronica=ecronica;
        this.Notele=Notele;
        this.Seguridad=Seguridad;
        this.nac=nac;
        this.id=id;

    }

    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String Nombre){
        this.Nombre=Nombre;
    }
    public String getApellido(){
        return Apellido;
    }
    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }
    
    public void setNotele(String tele) {
        this.Notele = tele;
    }
    
        public String getNotele() {
        return Notele;
    }
    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    public String getenfermedad() {
        return ecronica;
    }

    public void setenfermedad(String enfermedad) {
        this.ecronica= enfermedad;
    }
    public String getSeguridad() {
        return Seguridad;
    }

    public void setSeguridad(String Seguridad) {
        this.Seguridad = Seguridad;
    }
    public String getNac() {
        return nac;
    }

    public void setNac(String nac) {
        this.nac = nac;
    }
    public String getUsu() {
        return Usu;
    }

    public void setUsu(String Usu) {
        this.Usu = Usu;
    }
    public String getContra() {
        return Contra;
    }

    public void setContra(String Contra) {
        this.Contra = Contra;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
}
