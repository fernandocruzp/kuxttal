<%-- 
    Document   : Registro_pac
    Created on : 2/11/2021, 11:20:57 AM
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
            <h1>Registrar Pacientes</h1>
            <h2>Rellene los siguientes campos</h2>
            <br>
            <form action="Reg2?cargo=pac&dato=<%=datos%>" method="post" >
                <p>Tiene alguna enfermedad crónica:</p>
                <p><input type="text" name="enfe" id="enfe" size="40" required="required" placeholder="Escriba el nombre de la enfermedad" autofocus></p>
                <p>Cuenta con seguridad social:</p>
                <p><input type="text" name="seg_soc" id="seg_soc" size="40" required="required" placeholder="Escriba el tipo de seguridad social"/></p>
                <button type="submit" class="boton">Registrarse</button>
            </form>
            <br>
            <br>
            <br>
            <br>
        </div>
    </body>
</html>
