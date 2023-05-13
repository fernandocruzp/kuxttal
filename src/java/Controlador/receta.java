/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.Documento;
import Clases.Nota;
import Clases.Receta;
import Clases.citas;
import Clases.documentos;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author cruzf
 */
@MultipartConfig
public class receta extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String usua="";
            String accion= request.getParameter("accion");
            String cargo= request.getParameter("cargo");
            citas docu= new citas();
            Cookie[] cookie=request.getCookies();
            ArrayList<Receta>doc=new ArrayList<Receta>();
            documentos altas= new documentos();
            for(int i=0;i<cookie.length;i++){
              if(cookie[i].getName().equals("ID")){
                  usua=cookie[i].getValue();
              }
            }
            if (accion.equals("listar")){
              if(cargo.equals("med")){
                  doc=docu.listarRec(usua);
                 // System.out.println(doc.get(1).getNombre());
                  request.setAttribute("documento", doc);
                  request.getRequestDispatcher("listRec.jsp").forward(request, response);
              }
              else{
                  doc=docu.listarRec1(usua);
                  //System.out.println(doc.get(1).getNombre());
                  request.setAttribute("documento", doc);
                  request.getRequestDispatcher("listRec_1.jsp").forward(request, response);
              }
              
          }
          else{
              Nota fecha= new Nota();
              System.out.println("alo");
                String esp=request.getParameter("nomdoct");
                String esp2=fecha.getFechaSQL();
                System.out.println(esp2);
                InputStream inpustream= null;
                System.out.println(usua);
                try{
                    Part documento = request.getPart("docume");
                    if(documento.getSize()>0){
                        inpustream=documento.getInputStream();
                        System.out.println("fer");
                    }
                    if(altas.altRec(esp2,usua,esp,inpustream)){
                        request.getRequestDispatcher("receta?accion=listar&cargo=med").forward(request, response);
                    }
                }
                catch(Exception e){
                    System.out.println(e);
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
        } catch (ParseException ex) {
            Logger.getLogger(receta.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ParseException ex) {
            Logger.getLogger(receta.class.getName()).log(Level.SEVERE, null, ex);
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
