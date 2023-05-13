/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import Clases.*;
import javax.servlet.http.Cookie;

/**
 *
 * @author Admin
 */
@WebServlet(name = "Control_bit", urlPatterns = {"/Control_bit"})
public class Control_bit extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Altas_bit bit = new Altas_bit();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        String paciente = request.getParameter("pac");
        System.out.println(accion);
        Cookie[] cookie=request.getCookies();
        String usua="";
        for(int i=0;i<cookie.length;i++){
            if(cookie[i].getName().equals("ID")){
                usua=cookie[i].getValue();
            }
        }
        Bitacora bite = new Bitacora();
        request.setAttribute("pac", paciente);
        request.setAttribute("usua", usua);
        switch (accion) {
            case "AgregarSem":
                try {
                    System.out.println("kokoko");
                    String cont = request.getParameter("cont1");
                    String tipo = "Semanal";
                    String fecha = bite.getFechaSQL();
                    bit.alta(cont, tipo, fecha,usua,paciente);
                    request.getRequestDispatcher("Bitácora_agregar.jsp").forward(request, response);
                } catch (Exception ex) {
                    System.out.println("Error: " + ex);
                }
                break;

            case "AgregarDiario":
                try {
                    String cont = request.getParameter("cont1");
                    String tipo = "Diario";
                    String fecha = bite.getFechaSQL();
                    bit.alta(cont, tipo, fecha,usua,paciente);
                    request.getRequestDispatcher("Bitácora_agregar.jsp").forward(request, response);
                } catch (Exception ex) {
                    System.out.println("Error: " + ex);
                }
                break;

            case "AgregarPres":
                try {
                    String cont = request.getParameter("cont2");
                    String tipo = "Presión sanguínea";
                    String fecha = bite.getFechaSQL();
                    bit.alta(cont, tipo, fecha,usua,paciente);
                    request.getRequestDispatcher("Bitácora_vitales.jsp").forward(request, response);
                } catch (Exception ex) {
                    System.out.println("Error: " + ex);
                }
                break;

            case "AgregarGluc":
                try {
                    String cont = request.getParameter("cont2");
                    String tipo = "Glucosa en la sangre";
                    String fecha = bite.getFechaSQL();
                    bit.alta(cont, tipo, fecha,usua,paciente);
                    request.getRequestDispatcher("Bitácora_vitales.jsp").forward(request, response);
                } catch (Exception ex) {
                    System.out.println("Error: " + ex);
                }
                break;

            case "AgregarPulse":
                try {
                    String cont = request.getParameter("cont2");
                    String tipo = "Pulso";
                    String fecha = bite.getFechaSQL();
                    bit.alta(cont, tipo, fecha,usua,paciente);
                } catch (Exception ex) {
                    System.out.println("Error: " + ex);
                }
                break;

            case "AgregarSat":
                try {
                    String cont = request.getParameter("cont2");
                    String tipo = "Saturación";
                    String fecha = bite.getFechaSQL();
                    bit.alta(cont, tipo, fecha,usua,paciente);
                    request.getRequestDispatcher("Bitácora_vitales.jsp").forward(request, response);
                } catch (Exception ex) {
                    System.out.println("Error: " + ex);
                }
                break;
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