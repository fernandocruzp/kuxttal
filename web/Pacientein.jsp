<%-- 
    Document   : Pacientein
    Created on : 8/11/2021, 09:06:42 AM
    Author     : cruzf
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String usu = (String) request.getAttribute("cosa");
%>
<!DOCTYPE html>
<link rel="stylesheet" href="Css/css_paciente.css">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Paciente</title>
    </head>
    <body>
        <div>
            <h1 class="titulo_prin">
                Bienvenido: <%=usu%>          
            <a href="Modifica?cargo=pac&accion=ver"><img src="IMG/user.png" alt="usu" align="right" width="56" height="56" title="Cuenta" href="Modifica?cargo=pac&accion=ver"></a>
            </h1>  
        </div>
            <div class="cancel">
                <a href="index.jsp"><p align="right">Salir</p></a>
            </div>
        <div>
            <hr>
            <center>
                <br>
                <br>
                <br>
                <table border="0">            
                    <tr>
                        <td id="doc"><a href="Citas?cargo=pac&accion=ver">Mis doctores</a></td>
                        <td id="not"><a href="Control?accion=ver">Mis notas</a></td>
                    </tr>
                    <tr>                
                        <td id="cit"><a href="Citasmenu.jsp">Mis citas</a></td>
                        <td id="chat"><a href="ChatL?accion=listar&cargo=pac">Mis chats</a></td>
                    </tr>            
                    <tr>                
                        <td id="docu"><a href=documento?accion=listar&cargo=pac>Mis documentos</a></td>
                        <td id="rec"><a href="receta?cargo=pac&accion=listar">Mis Recetas</a></td>
                    </tr>            
                </table>        
            </center>
        </div>
    </body>
</html>
