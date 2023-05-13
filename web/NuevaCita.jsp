<%-- 
    Document   : NuevaCita
    Created on : 24/11/2021, 04:51:53 PM
    Author     : cruzf
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%ArrayList<ArrayList<String>>medicos=(ArrayList<ArrayList<String>>)request.getAttribute("medicos");%>
<%String[]medico=(String[])request.getAttribute("m");%>

<!DOCTYPE html>
<html>
    <head>
        <title>Registro</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Css/css.css">
        <script> 
    function cambiar(espe, doctor){
        var jsArray = [<% for (int i = 0; i < medicos.get(0).size(); i++) { %>"<%= medicos.get(0).get(i) %>"<%= i + 1 < medicos.get(0).size() ? ",":"" %><% } %>];
        var jsArray1 = [<% for (int i = 0; i < medicos.get(1).size(); i++) { %>"<%= medicos.get(1).get(i) %>"<%= i + 1 < medicos.get(1).size() ? ",":"" %><% } %>];
        var jsArray2 = [<% for (int i = 0; i < medicos.get(2).size(); i++) { %>"<%= medicos.get(2).get(i) %>"<%= i + 1 < medicos.get(2).size() ? ",":"" %><% } %>];
        var jsArray3 = [<% for (int i = 0; i < medicos.get(3).size(); i++) { %>"<%= medicos.get(3).get(i) %>"<%= i + 1 < medicos.get(3).size() ? ",":"" %><% } %>];
        var jsArray4 = [<% for (int i = 0; i < medicos.get(4).size(); i++) { %>"<%= medicos.get(4).get(i) %>"<%= i + 1 < medicos.get(4).size() ? ",":"" %><% } %>];
        var jsArray5 = [<% for (int i = 0; i < medicos.get(5).size(); i++) { %>"<%= medicos.get(5).get(i) %>"<%= i + 1 < medicos.get(5).size() ? ",":"" %><% } %>];
        var jsArray6 = [<% for (int i = 0; i < medicos.get(6).size(); i++) { %>"<%= medicos.get(6).get(i) %>"<%= i + 1 < medicos.get(6).size() ? ",":"" %><% } %>];
        var jsArray7 = [<% for (int i = 0; i < medicos.get(7).size(); i++) { %>"<%= medicos.get(7).get(i) %>"<%= i + 1 < medicos.get(7).size() ? ",":"" %><% } %>];
        var jsArray8 = [<% for (int i = 0; i < medicos.get(8).size(); i++) { %>"<%= medicos.get(8).get(i) %>"<%= i + 1 < medicos.get(8).size() ? ",":"" %><% } %>];
        var jsArray9 = [<% for (int i = 0; i < medicos.get(9).size(); i++) { %>"<%= medicos.get(9).get(i) %>"<%= i + 1 < medicos.get(9).size() ? ",":"" %><% } %>];
        espe=document.getElementById(espe);
        doctor=document.getElementById(doctor);
        doctor.value="";
        doctor.innerHTML="";
        console.log(jsArray[0]);
        if(espe.value =="Neumologia"){
            var opcion=jsArray;
        }
        else if(espe.value=="Oftalmologia"){
            var opcion=jsArray9;
        }
        else if(espe.value=="Cardiologia"){
            var opcion=jsArray1;
        }
        else if(espe.value=="Gastroenterologia"){
            var opcion=jsArray2;
        }
        else if(espe.value=="Pediatria"){
            var opcion=jsArray3;
        }
        else if(espe.value=="Oncologia"){
            var opcion=jsArray5;
        }
        else if(espe.value=="Traumatologia"){
            var opcion=jsArray6;
        }
        else if(espe.value=="Ginecologia"){
            var opcion=jsArray7;
        }
        else if(espe.value=="Internista"){
            var opcion=jsArray8;
        }
        else if(espe.value=="General"){
            var opcion=jsArray4;
        };
        for(i=0;i<opcion.length;i++){
            var opc=opcion[i];
            var newOp=document.createElement("option");
            newOp.value=opc;
            newOp.innerHTML=opc;
            doctor.options.add(newOp);
        }
}
        </script>
    </head>
    <body>
        <br>
        <br>
        <div id="bloque">
            <h1>Nueva Cita</h1>
            <h2>Rellene los siguientes campos</h2>
            <br>
            <form action="Citas?accion=nueva&cargo=pac" method="post">
                <p>Especialidad:</p>
                        <p><select name="espe" id="espe" onchange="cambiar(this.id,'doctor')">
                                <option value="0" selected>Elije una especialidad</option>
                                <option value="Neumologia">Neumologia</option>
                                <option value="Oftalmologia">Oftalmologia</option>
                                <option value="Cardiologia">Cardiología</option>
                                <option value="Gastroenterologia">Gastroenterologia</option>
                                <option value="Pediatria">Pediatria</option>
                                <option value="Oncologia">Oncologia</option>
                                <option value="Traumatologia">Traumatologia</option>
                                <option value="Ginecologia">Ginecologia</option>
                                <option value="Internista">Internista</option>
                                <option value="General">General</option>
                                
                    </select></p>
                    <p><select name="doctor" id="doctor">
                            <option value=""></option>
                        </select></p>
                <p>Fecha:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Horario:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Urgencia:</p>
                <p><input type="date" id="fecha" name="fecha" size="40" value="2021-10-22" min="2021-11-25" max="2022-01-31">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="time" name="hora" id="hora" size="40" required="required" min="8:00 am" max="17:00 pm" placeholder="Escoja la hora de la cita"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="urgencia" id="urgencia">
                                <option value="0" selected>Elija la urgencia de la cita</option>
                                <option value="Malta">Muy alta</option>
                                <option value="alta">Alta</option>
                                <option value="media">Media</option>
                                <option value="baja">Baja</option>
                    </select></p>
                    <br>
                    <br>
                    <br>
                <center><button type="submit" class="boton">Registrarse</button></center>
            </form>
            <br>
            <br>
            <br>
            <br>
        </div>
        <div class="cancel">
                <a href="Citasmenu.jsp">REGRESAR</a>
            </div>
    </body>
</html>
