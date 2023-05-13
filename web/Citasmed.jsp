<%-- 
    Document   : CitasPac
    Created on : 23/11/2021, 04:11:26 PM
    Author     : cruzf
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String pac=(String)request.getAttribute("usua");%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="Css/Bitácora_est.css" rel="stylesheet">
        <title>Kuxttal || Citas</title>
    </head>
    <body>
        <div class="bit_titulo">Próximas citas</div>
        <div>
            <p class="med">Médico: <%=pac%></p>
            <hr size="5" color="#5df505">
        </div>
        <div class="bg">
            <div>
                <hr color="#FFFFFF">
                <%
                    try {
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/kuxttal?useSSL=false&zeroDateTimeBehavior=convertToNull&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "n0m3l0");
                        if (!conexion.isClosed()) {
                            Statement st = conexion.createStatement();
                            ResultSet rs = st.executeQuery("select paciente.nombre_p, paciente.apellido_p, paciente.usuario_p, paciente.correo_p, citas.id_cita, citas.fecha_registro, citas.horario,medico.correo_m from paciente inner join paciente_citas on paciente.id_paciente=paciente_citas.id_paciente inner join medico_citas on medico_citas.id_cita=paciente_citas.id_cita inner join medico on medico.id_medico=medico_citas.id_medico inner join citas on citas.id_cita=medico_citas.id_cita where medico.usuario_m='"+pac+"' and estado='Confirmada';");
                            out.println("<table border=/1/>");
                            while (rs.next()) {
                                out.println("<section class='contenedor'>");
                                out.println("<tr>");
                                
                                out.println("<td>" + rs.getObject("fecha_registro") + ("</td>"));
                                out.println("<td>" + rs.getObject("horario") + ("</td>"));
                                out.println("<td>" + rs.getObject("nombre_p") + ("</td>"));
                                out.println("<td>" + rs.getObject("apellido_p") + ("</td>"));
                                out.println("<td>" + rs.getObject("correo_p") + ("</td>"));
                                out.println("<td>" + "<a href='Citas?accion=completar&cargo=med&cita="+rs.getString("id_cita")+"'><button>Marcar completada</button></a>" + ("</td>"));
                                out.println("<td>" + "<a href='Citas?accion=eliminar&cargo=med&cita="+rs.getString("id_cita")+"&correo_r="+rs.getString("correo_p")+"&correo_e="+rs.getString("correo_m")+"'><button>Cancelar Cita</button></a>" + ("</td>"));
                                out.println("</tr>");
                            }
                            out.println("</table>");
                            out.println("<section class='contenedor'>");

                            conexion.close();
                        } else {
                            out.println("Fallo");
                        }
                    } catch (Exception e) {
                        out.println("Excepcion " + e);
                        e.printStackTrace();
                    }
                %>    
               <hr color="#FFFFFF">
               <hr color="#FFFFFF">
               <hr color="#FFFFFF">
               <hr color="#FFFFFF">
               <hr color="#FFFFFF">
               <hr color="#FFFFFF">
               <hr color="#FFFFFF">
               <br>
               <br>
               <br>
               <br>
               <br>
               <br>
               <br>
               <br>
               <br>
            </div>
            <div class="cancel">
                <a href="Citasmenu_1.jsp">REGRESAR</a>
            </div>
        </div>
        <hr size="5" color="#5df505">
    </body>
</html>
