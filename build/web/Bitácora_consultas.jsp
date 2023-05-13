<%-- 
    Document   : Bitácora_principal
    Created on : 8/11/2021, 12:18:54 PM
    Author     : Alumno
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String pac=(String)request.getAttribute("pac");%>
<%String usu=(String)request.getAttribute("usua");%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="Css/Bit3.css" rel="stylesheet">
        <title>Kuxttal || Bitácoras</title>
    </head>
    <body>
        <div class="bit_titulo">Bitácora</div>
        <div>
            <p class="med">Médico: <%=usu%></p>
            <p class="med">Paciente: <%=pac%></p>
            <hr size="5" color="#5df505">
        </div>
            <div>
                <hr color="#FFFFFF">
                <%
                    try {
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/kuxttal?useSSL=false&zeroDateTimeBehavior=convertToNull&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "n0m3l0");
                        if (!conexion.isClosed()) {
                            Statement st = conexion.createStatement();
                            ResultSet rs = st.executeQuery("select bitacora.descripcion, bitacora.tipo_bit, bitacora.fecha_bit from bitacora inner join paciente_bitacora on bitacora.id_bitacora=paciente_bitacora.id_bitacora inner join medico_bitacora on bitacora.id_bitacora=medico_bitacora.id_bitacora inner join medico on medico.id_medico=medico_bitacora.id_medico inner join paciente on paciente.id_paciente=paciente_bitacora.id_paciente where paciente.usuario_p='"+pac+"' and medico.usuario_m='"+usu+"';");
                            out.println("<table border=/1/>");
                            while (rs.next()) {
                                out.println("<section class='contenedor'>");
                                out.println("<tr>");

                                out.println("<td>" + rs.getObject("fecha_bit") + ("</td>"));
                                out.println("<td>" + rs.getObject("descripcion") + ("</td>"));
                                out.println("<td>" + rs.getObject("tipo_bit") + ("</td>"));
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
            </div>
            <div class="cancel">
                <a href="Bitacora1?pac=<%=pac%>&accion=prin">REGRESAR</a>
            </div>
        <hr size="5" color="#5df505">
    </body>
</html>