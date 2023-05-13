/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.Conexion;
import Clases.procesoker;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class IniciaSes1 extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            procesoker autentifica= new procesoker();
            Connection con = null;
            Statement st;
            ResultSet rs;
            String mensajeEntrada="";
            System.out.println("jp");
            String caso=request.getParameter("caso");
            String ID = request.getParameter("usua");
            String contra= request.getParameter("contra");
            String contra1= autentifica.getHash(contra);
            con= Conexion.conectar();
            st=con.createStatement();
            
            rs=st.executeQuery("select*from paciente where usuario_p='"+ID+"' and contraseña_p='"+contra1+"';");
            if(!rs.next()){
                st=con.createStatement();
                rs=st.executeQuery("select*from medico where usuario_m='"+ID+"' and contraseña_m='"+contra1+"';");
                if(!rs.next()){
                    if(caso.equals("web")){
                        request.setAttribute("mensaje", "No existe el usuario o contraseña incorrecta");
                        request.getRequestDispatcher("InicioSesion.jsp").forward(request, response);
                    }
                    else{
                        System.out.println(caso);
                        out.println("acceso denegado");
                    }
                    
                }
                else{
                    
                    mensajeEntrada="medico";
                }
            }else{
                mensajeEntrada="paciente";
            }
            Cookie c;
            c= new Cookie("ID",ID);
            c.setMaxAge(1*24*60*60);
            System.out.println("1"+c.getValue());
            response.addCookie(c);
            if(caso.equals("web")){
                if(mensajeEntrada.equals("paciente")){
                request.setAttribute("cosa", ID);
                request.getRequestDispatcher("Pacientein.jsp").forward(request, response);
            }
            else if(mensajeEntrada.equals("medico")){
               request.setAttribute("cosa", ID);
               request.getRequestDispatcher("medicoin.jsp").forward(request, response);
            }
            }
            else{
                out.println(mensajeEntrada);
        }
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
            Logger.getLogger(IniciaSes1.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(IniciaSes1.class.getName()).log(Level.SEVERE, null, ex);
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
