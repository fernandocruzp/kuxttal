<%-- 
    Document   : medicoin
    Created on : 8/11/2021, 09:06:58 AM
    Author     : cruzf
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String usu = (String) request.getAttribute("cosa");
%>
<!DOCTYPE html>
<link rel="stylesheet" href="Css/medin.css">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Medico</title>
    </head>
    <body>
        <div>
            <h1 class="titulo_prin">
                Bienvenido: <%=usu%>          
            <a href="Modifica?cargo=med&accion=ver"><img src="IMG/user.png" alt="usu" align="right" width="56" height="56" title="Cuenta" href="Modifica?cargo=med&accion=ver"></a>
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
                        <td id="doc"><a href="Citas?cargo=med&accion=ver">Mis pacientes</a></td>
                        <td id="cit"><a href="Citasmenu_1.jsp">Mis citas</a></td>
                    </tr>
                    <tr>                
                        <td id="chat"><a href="ChatL?accion=listar&cargo=med">Mis chats</a></td>
                        <td id="docu"><a href="documento?accion=listar&cargo=med">Mis documentos</a></td>
                    </tr>            
                    <tr>                
                        <td id="rec"><a href="receta?cargo=med&accion=listar">Mis Recetas</a></td>
                    </tr>            
                </table>        
            </center>
        </div>
    </body>
</html>

