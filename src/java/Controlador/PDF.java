/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cruzf
 */
public class PDF extends HttpServlet {
    Connection con = null;
    Statement st;
    ResultSet rs;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        con= Conexion.conectar();
        st=con.createStatement();
        
        byte[]b=null;
        response.setContentType("application/pdf");
        try{
           Usuario usuario;
           InicioRegistro mod= new InicioRegistro();
           String id= request.getParameter("id");
           Cookie[] cookie=request.getCookies();
           String usua="";
           for(int i=0;i<cookie.length;i++){
               if(cookie[i].getName().equals("ID")){
                   usua=cookie[i].getValue();
               }
           }
           if(id.equals("salud")){
               usua=usua;
           }
           else
               usua=id;
           
           rs=st.executeQuery("select certificado from medico where usuario_m = '"+usua+"';");
           while(rs.next()){
               b=rs.getBytes(1);
           }
           InputStream bos= new ByteArrayInputStream(b);
           int tamaño= bos.available();
           byte[] datosPDF= new byte[tamaño];
           bos.read(datosPDF,0,tamaño);
           response.getOutputStream().write(datosPDF);
           bos.close();
           rs.close();
           Conexion.desconectar();
           
           
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
