<%-- 
    Document   : listDoc
    Created on : 10/02/2022, 01:54:15 PM
    Author     : cruzf
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Clases.*"%>
<%@page import="Controlador.Citas"%>
<%@page import="Clases.citas"%>
<%//ArrayList<Usuario>usua=(ArrayList<Usuario>)request.getAttribute("paciente");%>
<%//String tip="jaj";%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="Css/Bitácora_est.css" rel="stylesheet">
        <title> Pacientes</title>
    </head>
    <body>
        <div class="bit_titulo">Mis Documentos</div>
        <div>
            <hr size="5" color="#5df505">
        </div>
                <hr color="#FFFFFF">
                <table align='center' border="1" width="800px">
                    <tr align='center'>
                        <td>Documentos</td>
                        <td>Nombre del documento</td>
                        <td>Nombre del paciente</td>
                    </tr>
                    <c:forEach var="pa" items="${documento}">
                       <tr>
                           <td height="5px" align="middle">
                               <a href="PDF2?id=${pa.getDoc()}&accion=doc"><img src="Imagenes/pdf1.png" id="ima" height="60px"></a>
                           </td>
                           <td height="5px" align="middle">
                               <p>${pa.getNombre()}</p>
                           </td>
                           <td height="5px" align="middle">
                               <p>${pa.getDoctor()}</p>
                           </td>
                       </tr>
                   </c:forEach>
                   </table>
               
               
            <div class="cancel">
                <a href="Menu?cargo=med">REGRESAR</a>
            </div>
        <hr size="5" color="#5df505">
    </body>
</html>