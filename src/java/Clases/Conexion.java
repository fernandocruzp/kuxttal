/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author cruzf
 */
public class Conexion {
    public static Connection con;
    
    public static Connection conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/kuxttal?useSSL=false&zeroDateTimeBehavior=convertToNull&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","n0m3l0");
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println("Error en la conexion");
            e.printStackTrace();
        }
        return con;
    }
    
    public static void desconectar(){
        try{
            if(con!=null){
                if(con.isClosed()==false){
                    con.isClosed();
                }
            }
        }
        catch (Exception e){
            System.out.println("Error: No se logro cerrar conexion:\n"+e);
        }
        
    }
}
