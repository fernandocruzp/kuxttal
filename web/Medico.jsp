<%-- 
    Document   : Medico
    Created on : 22/11/2021, 12:51:47 PM
    Author     : cruzf
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Clases.Usuario"%>
<%@page import="Controlador.Citas"%>
<%@page import="Clases.citas"%>
<%ArrayList<Usuario>usua=(ArrayList<Usuario>)request.getAttribute("medico");%>
<!DOCTYPE html>
<html>
    <head>
        <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="Css/Bitácora_est.css" rel="stylesheet">
        <title> Medicos</title>
    <body>
        <div class="bit_titulo">Mis Medicos</div>
        <div>
            <hr size="5" color="#5df505">
        </div>
                <hr color="#FFFFFF">
         <table align='center' border="1" width="800px">
             <tr>
                 <td>Medicos</td>
             </tr>
            <c:forEach var="pa" items="${medico}">
                <tr>
                    <td height="200px" align="middle">
                    <p>${pa.getNombre()}</p>
                    <p>${pa.getApellido()}</p>
                    <p>${pa.getNotele()}</p>
                    <p>${pa.getCorreo()}</p>
                    <p>${pa.getEspecialidad()}</p>
                    <p>${pa.getNac()}</p>
                    <p>${pa.getUsu()}</p>
                    <p><a href="PDF?id=${pa.getUsu()}"><img src="Imagenes/pdf.png" id="ima"></p>
                    </td>
                </tr>
            </c:forEach>
                
            </table>
                <div class="cancel">
                <a href="Menu?cargo=pac">REGRESAR</a>
            </div>
        <hr size="5" color="#5df505">
    </body>
</html>
