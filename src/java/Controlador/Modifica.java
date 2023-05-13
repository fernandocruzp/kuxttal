/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cruzf
 */
public class Modifica extends HttpServlet {

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
            ArrayList<String>datos=new ArrayList<>();
            Usuario usuario;
            InicioRegistro mod= new InicioRegistro();
            Cookie[] cookie=request.getCookies();
            String usua="";
            for(int i=0;i<cookie.length;i++){
               if(cookie[i].getName().equals("ID")){
                   usua=cookie[i].getValue();
               }
            }
            System.out.println(usua);
            String cargo =request.getParameter("cargo");
            String accion =request.getParameter("accion");
            usuario=mod.consulta(usua, cargo);
            if(accion.equals("ver")){
                request.setAttribute("usuario", usuario);
                if(cargo.equals("pac"))
                    request.getRequestDispatcher("EditarPerfilUsu.jsp").forward(request, response);
                else
                    request.getRequestDispatcher("EditarPerfilMedico.jsp").forward(request, response);
            }else if(accion.equals("borra")){
                if(mod.borra(usua, cargo)){
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                else{
                    System.out.println("error");
                }
            }else if(accion.equals("modifica")){
                String fecha = request.getParameter("fecha");
                String Notele = request.getParameter("tele");
                String Contra=request.getParameter("contra");
                hash hash=new hash();
                if(Contra.equals(""))
                    Contra=usuario.getContra();
                else
                    Contra=hash.getHash(Contra);
                String Correo = request.getParameter("correo");
                if(cargo.equals("pac")){
                    String enf=request.getParameter("enfe");
                    String seg=request.getParameter("seg_soc");
                    datos.add(usua);datos.add(fecha);datos.add(Notele);datos.add(Contra);
                    datos.add(enf);datos.add(seg);
                    if(mod.editaUsuario(datos)){
                       request.getRequestDispatcher("Modifica?accion=ver&cargo=pac").forward(request, response); 
                    }
                }
                else{
                    String esp=request.getParameter("esp");
                    datos.add(usua);datos.add(fecha);datos.add(Notele);datos.add(Contra);
                    datos.add(esp);
                    if(mod.editaMedico(datos)){
                       request.getRequestDispatcher("Modifica?accion=ver&cargo=medico").forward(request, response); 
                    }
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
