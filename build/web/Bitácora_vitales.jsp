<%-- 
    Document   : Bitácora_vitales
    Created on : 8/11/2021, 12:28:46 PM
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
        <title>Kuxttal || Añadir datos clínicos</title>
    </head>
    <body>
        <div class="bit_titulo">Bitácora</div>
        <div>
            <p class="med">Médico: <%=usu%></p>
            <p class="med">Paciente: <%=pac%></p>
            <hr size="5" color="#5df505">
        </div>
        <div class="bg-bit">
            <form method="post" action="Control_bit?pac=<%=pac%>">
                <hr color="#FFFFFF">
                <p class="subtit">Registrar medida de vitales</p>
                <p>
                    <input type="text" name="cont2" id="cont2" size="70" required="required" placeholder="Escriba el contenido del registro" class="form-bit">
                </p>
                <p>
                    <button name="accion" type="submit" value="AgregarPres">Presión sanguínea</button>
                    <button name="accion" type="submit" value="AgregarGluc">Glucosa en la sangre</button>
                    <button name="accion" type="submit" value="AgregarPulse">Pulso</button>
                    <button name="accion" type="submit" value="AgregarSat">Saturación</button>
                </p>
            </form>
            <div class="cancel">
                <a href="Bitacora1?pac=<%=pac%>&accion=prin">CANCELAR</a>
            </div>    
        </div>                        
        <hr size="5" color="#5df505">
    </body>
</html>