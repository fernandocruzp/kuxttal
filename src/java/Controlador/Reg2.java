/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.InicioRegistro;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author cruzf
 */
@WebServlet("/upload")
@MultipartConfig
public class Reg2 extends HttpServlet {

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
            String cargo=request.getParameter("cargo");
            String datito =request.getParameter("dato");
            String replace = datito.replace("[","");
            System.out.println(replace);
            String replace2=replace.replace(" ", "");
            String replace1 = replace2.replace("]","");
            System.out.println(replace1);
            ArrayList<String> datos = new ArrayList<String>(Arrays.asList(replace1.split(",")));
            System.out.println(datito);
            InicioRegistro alta = new InicioRegistro();
            if(cargo.equals("pac")){
                String enf=request.getParameter("enfe");
                String seg=request.getParameter("seg_soc");
                datos.add(seg);datos.add(enf);
                if(alta.revisa(datos,"paciente")){
                    if(alta.alta(datos)){
                        request.setAttribute("mensaje", "");
                        request.getRequestDispatcher("InicioSesion.jsp").forward(request, response);
                    }
                    else{
                        System.out.println("hola");
                        request.getRequestDispatcher("index.html").forward(request, response);
                        }
                }
                else{
                    request.setAttribute("mensaje", "Usuario y/o correo registrado anteriormente por favor cambiar");
                    request.getRequestDispatcher("Registro.jsp").forward(request, response);
                }
            }
            else if(cargo.equals("med")){
                System.out.println("alo");
                String esp=request.getParameter("esp");
                datos.add(esp);
                InputStream inpustream= null;
                try{
                    Part doc = request.getPart("cert");
                    if(doc.getSize()>0){
                        inpustream=doc.getInputStream();
                        System.out.println("fer");
                    }
                }
                catch(Exception e){
                    System.out.println(e);
                }
                if(alta.revisa(datos,"medico")){
                    if(alta.altamed(datos,inpustream)){
                        request.setAttribute("mensaje", "");
                        request.getRequestDispatcher("InicioSesion.jsp").forward(request, response);
                    }
                    else{
                        request.getRequestDispatcher("index.html").forward(request, response);
                    }
                }
                else{
                    request.setAttribute("mensaje", "Usuario y/o correo registrado anteriormente por favor cambiar");
                    request.getRequestDispatcher("Registro.jsp").forward(request, response);
                }
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
            Logger.getLogger(Reg2.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Reg2.class.getName()).log(Level.SEVERE, null, ex);
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
