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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cruzf
 */
public class documentos {
    Connection con = null;
    Statement st;
    ResultSet rs;
    CallableStatement call;
    public boolean altDoc(String nombre, String doc, String usu, InputStream documento){
        try {
            int resultado;
            int id=0;
            int id_med=0;
            int id_cit=0;
            con = Conexion.conectar();
            st = con.createStatement();
            call = con.prepareCall("{call registro_doc(?,?)}");
            call.setString(1, nombre);
            call.setBlob(2, documento);
            resultado= call.executeUpdate();
            System.out.println(resultado);
            if(resultado!=0){
                System.out.println("logrado");
                resultado=0;
                System.out.println("logrado");
                Conexion.desconectar();
                rs=st.executeQuery("select id_paciente from paciente where usuario_p='"+usu+"';");
                while(rs.next())
                    id=rs.getInt("id_paciente");
                System.out.println(id);
                rs=st.executeQuery("select id_medico from medico where usuario_m='"+doc+"';");
                while(rs.next())
                    id_med=rs.getInt("id_medico");
                System.out.println(id_med);
                rs=st.executeQuery("select id_documento from documentos where nombre_documento='"+nombre+"';");
                while(rs.next())
                    id_cit=rs.getInt("id_documento");
                System.out.println(id_cit);
                call = con.prepareCall("{call pac_doc(?,?)}");
                call.setInt(1, id);
                call.setInt(2, id_cit);
                resultado= call.executeUpdate();
                if(resultado!=0){
                    System.out.println("laslas");
                    call = con.prepareCall("{call med_doc(?,?)}");
                    call.setInt(1, id_med);
                    call.setInt(2, id_cit);
                    call.executeUpdate();
                    
                }
                return true;
            }    
            else{
                System.out.println("fallado");
                Conexion.desconectar();
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(documentos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean altRec(String nombre, String doc, String usu, InputStream documento){
        try {
            int resultado;
            int id=0;
            int id_med=0;
            int id_cit=0;
            con = Conexion.conectar();
            st = con.createStatement();
            call = con.prepareCall("{call registro_rec(?,?)}");
            call.setString(1, nombre);
            call.setBlob(2, documento);
            resultado= call.executeUpdate();
            System.out.println(resultado);
            if(resultado!=0){
                System.out.println("logrado");
                resultado=0;
                System.out.println("logrado");
                Conexion.desconectar();
                rs=st.executeQuery("select id_paciente from paciente where usuario_p='"+usu+"';");
                while(rs.next())
                    id=rs.getInt("id_paciente");
                System.out.println(id);
                rs=st.executeQuery("select id_medico from medico where usuario_m='"+doc+"';");
                while(rs.next())
                    id_med=rs.getInt("id_medico");
                System.out.println(id_med);
                rs=st.executeQuery("select id_receta from receta where fecha_emision='"+nombre+"';");
                while(rs.next())
                    id_cit=rs.getInt("id_receta");
                System.out.println(id_cit);
                call = con.prepareCall("{call pac_rec(?,?)}");
                call.setInt(1, id);
                call.setInt(2, id_cit);
                resultado= call.executeUpdate();
                if(resultado!=0){
                    System.out.println("laslas");
                    call = con.prepareCall("{call med_rec(?,?)}");
                    call.setInt(1, id_med);
                    call.setInt(2, id_cit);
                    call.executeUpdate();
                    
                }
                return true;
            }    
            else{
                System.out.println("fallado");
                Conexion.desconectar();
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(documentos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
