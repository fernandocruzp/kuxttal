<%-- 
    Document   : Registro_med
    Created on : 2/11/2021, 11:21:24 AM
    Author     : cruzf
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%ArrayList<String> datos=(ArrayList<String>)request.getAttribute("datos");%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Css/cssinicio.css">
    </head>
    <body>
        <br>
        <br>
        <br>
        <div id="bloque">
            <h1>Registrar Medico</h1>
            <h2>Rellene los siguientes campos</h2>
            <br>
            <form action="Reg2?cargo=med&dato=<%=datos%>" method="post" enctype="multipart/form-data">
                <p>Escriba su especialidad:</p>
                <p><input type="text" name="esp" id="esp" size="40" required="required" placeholder="Escriba el nombre de la especialidad" autofocus></p>
                <p>Introduzca su certificado en formato PDF:</p>
                <p><input type="file" name="cert" id="cert" size="40" required="required" placeholder="Suba su archivo"></p>
                <button type="submit" class="boton">Registrarse</button>
            </form>
            <br>
            <br>
            <br>
            <br>
        </div>
    </body>
</html>
