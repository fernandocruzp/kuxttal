/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class Citas extends HttpServlet {

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
            ArrayList<Usuario>paciente=new ArrayList<Usuario>();
            citas pac= new citas();
            String cargo= request.getParameter("cargo");
            String accion= request.getParameter("accion");
            Cookie[] cookie=request.getCookies();
            String usua="";
            for(int i=0;i<cookie.length;i++){
                if(cookie[i].getName().equals("ID")){
                    usua=cookie[i].getValue();
                }
            }
            System.out.println(usua);
            if(accion.equals("ver")){
                if(cargo.equals("med")){
                paciente=pac.listapac(usua);
//                System.out.println(paciente.get(1).getApellido());
                request.setAttribute("paciente",paciente);
                request.getRequestDispatcher("Paciente.jsp").forward(request, response);
                }
                else{
                    paciente=pac.listamed(usua);
                    request.setAttribute("medico", paciente);
                    request.getRequestDispatcher("Medico.jsp").forward(request, response);
                }
            }
            else if(accion.equals("citas")){
                request.setAttribute("usua", usua);
                if(cargo.equals("pac"))
                    request.getRequestDispatcher("CitasPac.jsp").forward(request, response);
                else
                    request.getRequestDispatcher("Citasmed.jsp").forward(request, response);
            }
            else if(accion.equals("completar")){
                String id_cita=request.getParameter("cita");
                request.setAttribute("usua", usua);
                pac.completar(id_cita);
                if(cargo.equals("pac"))
                    request.getRequestDispatcher("CitasPac.jsp").forward(request, response);
                else
                    request.getRequestDispatcher("Citasmed.jsp").forward(request, response);
            }
            else if(accion.equals("eliminar")){
                String id_cita=request.getParameter("cita");
                String correo_r=request.getParameter("correo_r");
                System.out.println(correo_r);
                String correo_e=request.getParameter("correo_e");
                System.out.println(correo_e);
                request.setAttribute("usua", usua);
                pac.eliminar(id_cita);
                if(cargo.equals("pac")){
                    pac.mandarcorreo("cancela_c", correo_e, correo_r, usua);
                    request.getRequestDispatcher("CitasPac.jsp").forward(request, response);
                }
                else{
                    pac.mandarcorreo("cancela_m", correo_e, correo_r, usua);
                    request.getRequestDispatcher("Citasmed.jsp").forward(request, response);
                }
                
            }
            else if(accion.equals("checar")){
                request.setAttribute("usua", usua);
                request.getRequestDispatcher("Citasaceptar.jsp").forward(request, response);
            }
            else if(accion.equals("aceptar")){
                String id_cita=request.getParameter("cita");
                request.setAttribute("usua", usua);
                pac.aceptar(id_cita);
                request.getRequestDispatcher("Citasaceptar.jsp").forward(request, response);
            }
            else if(accion.equals("agregar")){
                ArrayList<ArrayList<String>>medicos=pac.medicos();
                //System.out.println(medicos.get(1).get(0));
                String[]jaja={"adad","dad","dada"};
                request.setAttribute("medicos", medicos);
                request.setAttribute("m", jaja);
                request.getRequestDispatcher("NuevaCita.jsp").forward(request, response);
            }
            else if(accion.equals("nueva")){
                String espe=request.getParameter("espe");
                String doctor=request.getParameter("doctor");
                String fecha=request.getParameter("fecha");
                String hora=request.getParameter("hora");
                String urgen=request.getParameter("urgencia");
                pac.nueva(espe, doctor, fecha, hora, urgen, usua);
                request.getRequestDispatcher("Citas?accion=agregar&cargo=pac").forward(request, response);
                
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
            Logger.getLogger(Citas.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Citas.class.getName()).log(Level.SEVERE, null, ex);
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
