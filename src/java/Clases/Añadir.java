/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Admin
 */
import Clases.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Añadir extends Conexion {
    
    public boolean Altas(String cont, String fecha,String usua) throws SQLException, ParseException {
        try {    
            ResultSet rs;
            Statement st;
            //PreparedStatement ps;
            int id;
            Añadir.conectar();
            int id_usu=0,id_nota=0;
            String alt = "insert into notas (id_notas, contenido, fecha_nota) values (?,?,?)";
            PreparedStatement ps = Añadir.conectar().prepareStatement(alt);
            ps.setString(1, null);
            ps.setString(2, cont);
            ps.setString(3, fecha);
            ps.execute();
            st=con.createStatement();
            rs=st.executeQuery("select id_paciente from paciente where usuario_p='"+usua+"';");
            if(rs.next()){
                id_usu=rs.getInt("id_paciente");
            }
            rs=st.executeQuery("select id_notas from notas where contenido='"+cont+"' and fecha_nota='"+fecha+"';");
            if(rs.next()){
                id_nota=rs.getInt("id_notas");
            }
            String sql1 = "insert into paciente_notas values ('"+ id_usu+ "','" + id_nota+"')";
            ps=con.prepareStatement(sql1);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }
    public boolean bajas(String nota){
        String sql = "delete from notas where id_notas="+nota+";";
        try {
            PreparedStatement ps;
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
          
        }   catch (SQLException ex) {
            Logger.getLogger(Añadir.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}