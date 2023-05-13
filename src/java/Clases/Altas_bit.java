/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Clases.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class Altas_bit {

    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    int id;
    

    public void alta(String cont, String tipo, String fecha, String usua, String pac) {
        int id=0;
        int idmed=0;
        int idpac=0;
        String sql = "insert into bitacora values (default,'" + cont + "','" + tipo + "','" + fecha + "')";
        try {
            System.out.println("ya entro");
            System.out.println(pac);
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            st=con.createStatement();
            rs=st.executeQuery("select id_bitacora from bitacora where descripcion='"+cont+"' and tipo_bit='"+tipo+"' and fecha_bit='"+fecha+"'");
            if(rs.next()){
                id= rs.getInt("id_bitacora");
                System.out.println(id);
            }
            st=con.createStatement();
            rs=st.executeQuery("select id_paciente from paciente where usuario_p='"+pac+"'");
            if(rs.next()){
                idpac=rs.getInt("id_paciente");
                System.out.println(idpac);
            }
            st=con.createStatement();
            rs=st.executeQuery("select id_medico from medico where usuario_m='"+usua+"'");
            if(rs.next()){
                idmed=rs.getInt("id_medico");
            }
            String sql1 = "insert into paciente_bitacora values ('"+ idpac + "','" + id+"')";
            String sql2 = "insert into medico_bitacora values ('"+ idmed + "','" + id+"')";
            ps=con.prepareStatement(sql1);
            ps.executeUpdate();
            System.out.println(idmed+id+idpac);
            ps=con.prepareStatement(sql2);
            ps.executeUpdate();
            System.out.println("ya se fue");
            Conexion.desconectar();
            
        } catch (Exception e) {
        }
        
        
    }
}