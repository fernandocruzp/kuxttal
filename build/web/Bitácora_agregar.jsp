<%-- 
    Document   : Bitácora_agregar
    Created on : 8/11/2021, 12:19:09 PM
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String pac=(String)request.getAttribute("pac");%>
<%String usu=(String)request.getAttribute("usua");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Css/Bit2.css" rel="stylesheet">
        <title>Kuxttal || Crear registro</title>
    </head>
    <body>
        <div class="bit_titulo">Bitácora</div>
        <div>
            <p class="med">Médico: <%=usu%></p>
            <p class="med">Paciente: <%=pac%></p>
            <hr size="5" color="#5df505">
        </div>
        <div class="bg-bit">
            <form action="Control_bit?pac=<%=pac%>" method="post">
                <hr color="#FFFFFF">
                <p class="subtit">Evolución del tratamiento</p>
                <p>
                    <input type="text" name="cont1" id="cont1" size="70" required="required" placeholder="Escriba el contenido del registro" class="form-bit">
                </p>
                <p>
                    <button  type="submit" name='accion' value="AgregarSem">Semanal</button>
                    <button type="submit" name='accion' value="AgregarDiario">Diario</button>
                </p>
                <div class="cancel">
                    <a href="Bitacora1?pac=<%=pac%>&accion=prin">CANCELAR</a>
                </div>
            </form>
        </div>
        <hr size="5" color="#5df505">
    </body>
</html>