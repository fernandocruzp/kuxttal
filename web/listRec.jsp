<%-- 
    Document   : listRec
    Created on : 10/02/2022, 01:54:43 PM
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
        <link href="Css/RecDigit..css" rel="stylesheet">
        <title> Pacientes</title>
    </head>
    <body>
        <div class="bit_titulo">Mis Recetas</div>
                <table align='center' border="1" width="800px">
                    <tr align='center'>
                        <td>Documentos</td>
                        <td>Nombre del paciente</td>
                        <td>Fecha</td>
                    </tr>
                    <c:forEach var="pa" items="${documento}">
                       <tr>
                           <td height="5px" align="middle">
                               <a href="PDF2?id=${pa.getDoc()}&accion=rec"><img src="Imagenes/receta.jpg" id="ima" height="60px"></a>
                           </td>
                           <td height="5px" align="middle">
                               <p>${pa.getDoctor()}</p>
                           </td>
                           <td height="5px" align="middle">
                               <p>${pa.getFecha()}</p>
                           </td>
                       </tr>
                   </c:forEach>
                   </table>
                
                <form action="receta?accion=nuevo" method="post" enctype="multipart/form-data" align='center'>
                <p>Escriba usuario del paciente:</p>
                <p><input type="text" name="nomdoct" id="nomdoct" size="40" required="required" placeholder="Escriba el usuario del paciente" autofocus></p>
                <p>Introduzca su documento en formato PDF:</p>
                <p><input type="file" name="docume" id="docume" size="40" required="required" placeholder="Suba su archivo"></p>
                <button type="submit" class="boton">Subir</button>
            </form>
               
            <div class="cancel">
                <a href="Menu?cargo=med">REGRESAR</a>
            </div>
    </body>
</html>