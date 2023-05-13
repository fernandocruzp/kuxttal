<%-- 
    Document   : Paciente
    Created on : 21/11/2021, 06:31:29 PM
    Author     : cruzf
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Clases.*"%>
<%@page import="Controlador.Citas"%>
<%@page import="Clases.citas"%>
<%ArrayList<Usuario>usua=(ArrayList<Usuario>)request.getAttribute("paciente");%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="Css/Bitácora_est.css" rel="stylesheet">
        <title> Pacientes</title>
    </head>
    <body>
        <div class="bit_titulo">Mis pacientes</div>
        <div>
            <hr size="5" color="#5df505">
        </div>
                <hr color="#FFFFFF">
                <table align='center' border="1" width="800px">
                    <tr>
                        <td>Pacientes</td>
                    </tr>
                   <c:forEach var="pa" items="${paciente}">
                       <tr>
                           <td height="200px" align="middle">
                           <p>${pa.getNombre()}</p>
                           <p>${pa.getApellido()}</p>
                           <p>${pa.getNotele()}</p>
                           <p>${pa.getCorreo()}</p>
                           <p>${pa.getenfermedad()}</p>
                           <p>${pa.getSeguridad()}</p>
                           <p>${pa.getNac()}</p>
                           <p>${pa.getUsu()}</p>
                           <a href="Bitacora1?pac=${pa.getUsu()}&accion=prin"><button>ver bitácora</button></a>
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
