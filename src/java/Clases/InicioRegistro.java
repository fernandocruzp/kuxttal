/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author cruzf
 */
public class InicioRegistro {
    Connection con = null;
    Statement st;
    ResultSet rs;
    CallableStatement call;
    int id;
    String Nombre, Apellido, Usu,contra,Correo,enf,Notele,seg,nac,cargo;
    String especialidad;
    byte[] certificado;
    
    public boolean revisa(ArrayList<String>datos, String cargo) throws SQLException{
        con= Conexion.conectar();
        st=con.createStatement();
        rs=st.executeQuery("select*from "+cargo+";");
        boolean si=true;
        while(rs.next()){
            System.out.println(rs.getString(4));
            if(datos.get(4).equals(rs.getString(4))){
                si=false;
                break;
            }
        }   
        return si;
    }
    public boolean alta(ArrayList<String>datos){
        int resultado=0;
        try{
            System.out.println("hola");
            hash hash=new hash();
            String Nombre=datos.get(0);
            String Apellido=datos.get(1);
            String Usu=datos.get(4);
            String contra=hash.getHash(datos.get(5));
            String Correo=datos.get(6);
            String enf=datos.get(8); 
            String Notele=datos.get(3);
            System.out.println(Notele.length());
            String seg=datos.get(7);
            String nac=datos.get(2);
            con = Conexion.conectar();
            st = con.createStatement();
            call = con.prepareCall("{call registro_usuario(?,?,?,?,?,?,?,?,?)}");
            call.setString(1, Nombre);
            call.setString(2, Apellido);
            call.setString(3, Usu);
            call.setString(4, contra);
            call.setString(5, Correo);
            call.setString(6, enf);
            call.setString(7, Notele);
            call.setString(8, seg);
            call.setString(9, nac);
            resultado= call.executeUpdate();
            
            System.out.println(resultado);
            if(resultado!=0){
                System.out.println("logrado");
                Conexion.desconectar();
                return true;
            }    
            else{
                System.out.println("fallado");
                Conexion.desconectar();
                return false;
            }
            
        }
        catch(Exception e){
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return false;
        }
    }
    public boolean altamed(ArrayList<String>datos, InputStream doc){
        int resultado=0;
        try{
            System.out.println("hola");
            hash hash=new hash();
            String Nombre=datos.get(0);
            String Apellido=datos.get(1);
            String Usu=datos.get(4);
            String contra=hash.getHash(datos.get(5));
            String Correo=datos.get(6);
            String esp=datos.get(7); 
            String Notele=datos.get(3);
            System.out.println(Notele.length());
            String nac=datos.get(2);
            con = Conexion.conectar();
            st = con.createStatement();
            call = con.prepareCall("{call registro_med(?,?,?,?,?,?,?,?,?)}");
            call.setString(1, Nombre);
            call.setString(2, Apellido);
            call.setString(3, Usu);
            call.setString(5, contra);
            call.setString(4, Correo);
            call.setString(6, esp);
            call.setString(7, Notele);
            call.setString(8, nac);
            call.setBlob(9, doc);
            resultado= call.executeUpdate();
            System.out.println(resultado);
            if(resultado!=0){
                System.out.println("logrado");
                Conexion.desconectar();
                return true;
            }    
            else{
                System.out.println("fallado");
                Conexion.desconectar();
                return false;
            }
            
        }
        catch(Exception e){
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return false;
        }
    }
    public Usuario consulta(String id1, String Cargo){
        try{
            con= Conexion.conectar();
            st=con.createStatement();
            if(Cargo.equals("pac")){
                call = con.prepareCall("{call edita_paciente(?)}");
                call.setString(1, id1);
                rs=call.executeQuery();
                if(!rs.next()){
                    System.out.println("No hay registro");
                    Conexion.desconectar();
                    return null;
                }
                else{
                    Usuario usuario;
                    Nombre=rs.getString("nombre_p");
                    Apellido=rs.getString("apellido_p");
                    Correo=rs.getString("correo_p");
                    cargo=Cargo;
                    enf=rs.getString("e_cronica");
                    seg=rs.getString("seguridad_social");
                    nac=rs.getString("nac_p");
                    Notele=rs.getString("telefono_p");
                    Usu=rs.getString("usuario_p");
                    contra =rs.getString("contraseña_p");
                    id=rs.getInt("id_paciente");
                    usuario= new Usuario(Nombre,Apellido, Correo,cargo,Notele,enf,seg,nac, Usu,contra,id);
                    Conexion.desconectar();
                    return usuario;
                }
            }else{
                call = con.prepareCall("{call edita_medico(?)}");
                call.setString(1, id1);
                rs=call.executeQuery();
                if(!rs.next()){
                    System.out.println("No hay registro");
                    Conexion.desconectar();
                    return null;
                }
                else{
                    Usuario usuario;
                    Nombre=rs.getString("nombre_m");
                    Apellido=rs.getString("apellido_m");
                    Correo=rs.getString("correo_m");
                    cargo=Cargo;
                    enf=null;
                    seg=null;
                    nac=rs.getString("nac_m");
                    Notele=rs.getString("telefono_m");
                    Usu=rs.getString("usuario_m");
                    contra =rs.getString("contraseña_m");
                    id=rs.getInt("id_medico");
                    especialidad=rs.getString("especialidad");
                    certificado=rs.getBytes("certificado");
                    usuario= new Usuario(Nombre,Apellido, Correo,cargo,Notele,enf,seg,nac, Usu,contra,id);
                    usuario.setEspecialidad(especialidad);
                    usuario.setCertificado(certificado);
                    Conexion.desconectar();
                    return usuario;
                }
            }
        }
        catch(Exception e){
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }    
    }
    public boolean borra(String id, String cargo1){
        int resultado=0;
            try{
                con = Conexion.conectar();
                if(cargo1.equals("pac")){
                    call = con.prepareCall("{call borra_paciente(?)}");
                    call.setString(1, id);

                    resultado=call.executeUpdate();

                    if(resultado!=0){
                        Conexion.desconectar();
                        return true;
                    }     
                    else{
                        Conexion.desconectar();
                        return false;
                    }
                }
                else{
                    call = con.prepareCall("{call borra_medico(?)}");
                    call.setString(1, id);
                    resultado=call.executeUpdate();
                    if(resultado!=0){
                        Conexion.desconectar();
                        return true;
                    }     
                    else{
                        Conexion.desconectar();
                        return false;
                    }
                }
            }
            catch(Exception e){
                System.out.println("Error en la base de datos");
                e.printStackTrace();
                return false;
            }
    }
    public boolean editaUsuario(ArrayList<String>datos){
        int resultado=0;
        try{
            String contra=datos.get(3);
            String enf=datos.get(4); 
            String Notele=datos.get(2);
            String seg=datos.get(5);
            String nac=datos.get(1);
            con = Conexion.conectar();
            st = con.createStatement();
            call = con.prepareCall("{call edita_usuario(?,?,?,?,?,?)}");
            call.setString(1, datos.get(0));
            call.setString(2, contra);
            call.setString(3, enf);
            call.setString(4, Notele);
            call.setString(5, seg);
            call.setString(6, nac);
            resultado= call.executeUpdate();
            
            System.out.println(resultado);
            if(resultado!=0){
                System.out.println("logrado");
                Conexion.desconectar();
                return true;
            }    
            else{
                System.out.println("fallado");
                Conexion.desconectar();
                return false;
            }
            
        }
        catch(Exception e){
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return false;
        }
    }
    public boolean editaMedico(ArrayList<String>datos){
        int resultado=0;
        try{
            String contra=datos.get(3);
            String especialidad=datos.get(4); 
            String Notele=datos.get(2);
            String nac=datos.get(1);
            con = Conexion.conectar();
            st = con.createStatement();
            call = con.prepareCall("{call modifica_medico(?,?,?,?,?)}");
            call.setString(1, datos.get(0));
            call.setString(2, contra);
            call.setString(3, especialidad);
            call.setString(4, Notele);
            call.setString(5, nac);
            resultado= call.executeUpdate();
            System.out.println(resultado);
            if(resultado!=0){
                System.out.println("logrado");
                Conexion.desconectar();
                return true;
            }    
            else{
                System.out.println("fallado");
                Conexion.desconectar();
                return false;
            }
        }
        catch(Exception e){
            System.out.println("Error en la base de datos");
            e.printStackTrace();
            return false;
        }
    }    
}
