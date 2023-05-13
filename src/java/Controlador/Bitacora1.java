/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cruzf
 */
public class Bitacora1 extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String paciente= request.getParameter("pac");
            String accion= request.getParameter("accion");
            Cookie[] cookie=request.getCookies();
            String usua="";
            for(int i=0;i<cookie.length;i++){
               if(cookie[i].getName().equals("ID")){
                   usua=cookie[i].getValue();
               }
            }
            request.setAttribute("pac", paciente);
            request.setAttribute("usua", usua);
            if(accion.equals("prin"))
                request.getRequestDispatcher("Bitácora_principal.jsp").forward(request, response);
            else if(accion.equals("ver")){
                request.getRequestDispatcher("Bitácora_consultas.jsp").forward(request, response);
                System.out.println("genial");
            }
            else if(accion.equals("agregar")){
                System.out.println("genilaida");
                request.getRequestDispatcher("Bitácora_agregar.jsp").forward(request, response);
            }
            else if(accion.equals("vitales")){
                System.out.println("genilaida32");
                request.getRequestDispatcher("Bitácora_vitales.jsp").forward(request, response);
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
