<%-- 
    Document   : EditarPerfilUsu
    Created on : 18/11/2021, 09:56:45 PM
    Author     : cruzf
--%>

<%@page import="Clases.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%Usuario usuario= (Usuario)request.getAttribute("usuario");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Css/EditPerfiPac.css">
    </head>
    <body>
        <br>
        <br>
        <br>
        <div id="bloque">
            <h1><%=usuario.getNombre()%></h1>
            <h2>Puedes modificar tu información</h2>
            <br>
        <form action="Modifica?cargo=pac&accion=modifica" method="post">
                <p>Nombre(s):&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Apellidos:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Fecha de nacimiento:</p>
                <p><input type="text" name="nombre" id="nombre" size="40" required="required" value="<%=usuario.getNombre()%>" disabled="true"/>&nbsp;&nbsp;<input type="text" name="apellido" id="apellido" size="40" required="required" value="<%=usuario.getApellido()%>"disabled="true"/>&nbsp;&nbsp<input type="date" id="fecha" name="fecha" size="40" value="<%=usuario.getNac()%>" min="1940-01-01" max="2003-12-31"></p>
                <p>Teléfono:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Correo:</p>
                <p><input type="text" name="tele" id="tele" size="40" required="required" value="<%=usuario.getNotele()%>"/>&nbsp;&nbsp<input type="text" id="correo" name="correo" required="required" value="<%=usuario.getCorreo()%>"disabled="true"></p>
                <p>Usuario:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Contraseña:</p>
                <p><input type="text" name="usua" id="usua" size="40" required="required" value="<%=usuario.getUsu()%>" disabled="true"/>&nbsp;&nbsp;<input type="password" name="contra" id="contra" size="40" placeholder="Escriba su contraseña"/>
                <p>Tiene alguna enfermedad crónica:</p>
                <p><input type="text" name="enfe" id="enfe" size="40" required="required" value="<%=usuario.getenfermedad()%>"></p>                <p>Cuenta con seguridad social:</p>
                <p><input type="text" name="seg_soc" id="seg_soc" size="40" required="required" value="<%=usuario.getSeguridad()%>"/></p>
                <center><button type="submit" class="boton">Modificar Usuario</button></center>
            </form>
                <center><a href="Modifica?cargo=pac&accion=borra"><button type="submit" class="boton">Eliminar Usuario</button></a></center>
        </div>
                <div class="cancel">
                <a href="Menu?cargo=pac">REGRESAR</a>
            </div>
    </body>
</html>
