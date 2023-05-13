/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clases.Documento;
import Clases.UsChat;
import Clases.citas;
import Clases.documentos;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author cruzf
 */
public class ChatL extends HttpServlet {

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
            String usua="";
          String accion= request.getParameter("accion");
          String cargo= request.getParameter("cargo");
          citas docu= new citas();
          Cookie[] cookie=request.getCookies();
          ArrayList<UsChat>doc=new ArrayList<UsChat>();
          documentos altas= new documentos();
          for(int i=0;i<cookie.length;i++){
            if(cookie[i].getName().equals("ID")){
                usua=cookie[i].getValue();
            }
          }
          if (accion.equals("listar")){
              if(cargo.equals("pac")){
                  doc=docu.listarcont(usua);
                  System.out.println(usua);
                  request.setAttribute("contactos", doc);
                  request.setAttribute("usu", usua);
                  request.getRequestDispatcher("ChatPrincipal.jsp").forward(request, response);
              }
              else{
                  doc=docu.listarcont1(usua);
                  //System.out.println(doc.get(1).getNombre());
                  request.setAttribute("contactos", doc);
                  request.setAttribute("usu", usua);
                  request.getRequestDispatcher("ChatPrincipal_1.jsp").forward(request, response);
              }
              
          }
          else{
              System.out.println("alo");
                String esp=request.getParameter("nomdoc");
                String esp2=request.getParameter("nomdoct");
                InputStream inpustream= null;
                try{
                    Part documento = request.getPart("docume");
                    if(documento.getSize()>0){
                        inpustream=documento.getInputStream();
                        System.out.println("fer");
                    }
                    if(altas.altDoc(esp,esp2,usua,inpustream)){
                        request.getRequestDispatcher("documento?accion=listar&cargo=pac").forward(request, response);
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
