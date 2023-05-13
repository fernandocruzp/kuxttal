<%-- 
    Document   : InicioSesion
    Created on : 8/11/2021, 08:39:41 AM
    Author     : cruzf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String mensaje=(String)request.getAttribute("mensaje");%>
<%if(mensaje==null){
    mensaje="";
}%>
<!DOCTYPE html>
<html>
    <head>
        <title>Inicio</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Css/cssinicio.css">
    </head>
    <body>
        <br>
        <br>
        <br>
        <div id="bloque">
            <h1>Iniciar Sesión</h1>
            <br>
            <form action="IniciaSes1?caso=web" method="post">
                <p>Usuario:</p>
                <p><input type="text" name="usua" id="usua" size="40" required="required" placeholder="Escriba su usuario" autofocus></p>
                <p>Contraseña:</p>
                <p><input type="password" name="contra" id="contra" size="40" required="required" placeholder="Escriba su contraseña"/></p>
                <p><%=mensaje%></p>
                <button type="submit" class="boton">Iniciar Sesión</button>
            </form>
            <br>
            <br>
            <br>
            <br>
        </div>
    </body>
</html>

