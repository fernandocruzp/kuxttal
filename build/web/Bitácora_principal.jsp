<%-- 
    Document   : Bitácora_principal
    Created on : 8/11/2021, 12:18:54 PM
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String pac=(String)request.getAttribute("pac");%>
<%String usu=(String)request.getAttribute("usua");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Css/Bitácora_est.css" rel="stylesheet">
        <title>Kuxttal || Bitácoras</title>
    </head>
    <body>
        <div class="bit_titulo">Bitácora</div>
        <div>
            <p class="med">Médico: <%=usu%></p>
            <p class="med">Paciente: <%=pac%></p>
            <hr size="5" color="#5df505">
        </div>
        <div class="bg">
            <div>
                <hr color="#FFFFFF">
                <p class="subtit">Evaluación del tratamiento</p>
                <p class="agregar"><a href="Bitacora1?pac=<%=pac%>&accion=agregar"><img src="IMG/mas.png" alt="signo" align="left" width="25" height="25" title="KUXTTAL" href="Bitácora_agregar.jsp"></a>Crear nuevo registro de evolución</p>
            </div>
            <div>
                <p class="subtit">Registrar medida de vitales</p>
                <p class="agregar"><a href="Bitacora1?pac=<%=pac%>&accion=vitales"><img src="IMG/mas.png" alt="signo" align="left" width="25" height="25" title="KUXTTAL" href="Bitácora_agregar.jsp"></a> Añadir seguimiento o datos clínicos</p>
            </div>
            <div class="cancel">
                <a href="Bitacora1?pac=<%=pac%>&accion=ver">REVISAR BITÁCORAS</a>
            </div>
        </div>
            <div class="cancel">
                <a href="Menu?cargo=med">REGRESAR</a>
            </div>
        <hr size="5" color="#5df505">
    </body>
</html>