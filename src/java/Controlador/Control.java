/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Clases.Añadir;
import Clases.Nota;
import javax.servlet.http.Cookie;

/**
 *
 * @author Admin
 */
@WebServlet(name = "Control", urlPatterns = {"/Control"})
public class Control extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Añadir add = new Añadir();
        Nota note = new Nota();

        String accion = request.getParameter("accion");
        Cookie[] cookie=request.getCookies();
        String usua="";
        for(int i=0;i<cookie.length;i++){
            if(cookie[i].getName().equals("ID")){
                usua=cookie[i].getValue();
            }
        }
        switch (accion) {
            case "Agregar":
                try {
                    String cont = request.getParameter("nota");
                    String fecha = note.getFechaSQL();
                    if(add.Altas(cont, fecha,usua)){
                        request.getRequestDispatcher("Control?accion=ver").forward(request, response);
                    }
                } catch (ParseException | SQLException ex) {
                    System.out.println("Error: " + ex);
                }
                break;
            case "ver":
                request.setAttribute("usua", usua);
                request.getRequestDispatcher("Notas.jsp").forward(request, response);
                break;
            case "eliminar":
                String nota = request.getParameter("nota");
                if(add.bajas(nota)){
                    request.getRequestDispatcher("Control?accion=ver").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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