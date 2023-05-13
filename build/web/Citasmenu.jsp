<%-- 
    Document   : Citasmenu
    Created on : 22/11/2021, 02:10:20 PM
    Author     : cruzf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Css/Bitácora_est.css" rel="stylesheet">
        <title>Kuxttal || CitasMenu</title>
    </head>
    <body>
        <div class="bit_titulo">Mis Citas</div>
        <div>
            <hr size="5" color="#5df505">
        </div>
        <div class="bg">
            <div>
                <hr color="#FFFFFF">
                <p class="subtit">Nueva Cita</p>
                <p class="agregar"><a href="Citas?accion=agregar&cargo=pac"><img src="IMG/mas.png" alt="signo" align="left" width="25" height="25" title="KUXTTAL" href="Bitácora_agregar.jsp"></a>Solicitar nueva cita</p>
            </div>
            <div>
                <p class="subtit">Citas pendientes</p>
                <p class="agregar"><a href="Citas?accion=citas&cargo=pac"><img src="IMG/lista.jpg" alt="signo" align="left" width="25" height="25" title="KUXTTAL" href="Bitácora_agregar.jsp"></a> Revisar Citas</p>
            </div>
        </div>
        <div class="cancel">
                <a href="Menu?cargo=pac">REGRESAR</a>
            </div>
        <hr size="5" color="#5df505">
    </body>
</html>