<%-- 
    Document   : Notas
    Created on : 31/10/2021, 07:15:49 PM
    Author     : Admin
--%>

<%@ page language="java"%>
<%@ page import = "java.sql.Connection"%>
<%@ page import = "java.sql.DriverManager"%>
<%@ page import = "java.sql.ResultSet"%>
<%@ page import = "java.sql.Statement"%>
<%String usu=(String)request.getAttribute("usua");%>
<html>
    <head>
        <title>Kuxttal || Notas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="Css/css_notas.css">
    </head>
    <body>
        <div id="titulo" class="titulo">
            <%-- <img src="IMG/logopagina.JPG" alt="logo" align="left" width="350" height="90" title="KUXTTAL">--%>
            Notas personales
            <%-- <img src="IMG/user.png" alt="usu" align="right" width="200" height="200" title="Cuenta">--%>
        </div>
    <center>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <div class="table">
            <%
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/kuxttal?useSSL=false&zeroDateTimeBehavior=convertToNull&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "n0m3l0");
                    if (!conexion.isClosed()) {
                        Statement st = conexion.createStatement();
                        ResultSet rs = st.executeQuery("select notas.* from notas inner join paciente_notas on notas.id_notas=paciente_notas.id_notas inner join paciente on paciente.id_paciente=paciente_notas.id_paciente where paciente.usuario_p='"+usu+"';");

                        out.println("<table border=/1/>");
                        while (rs.next()) {
                            out.println("<section class='contenedor'>");
                            out.println("<tr>");

                            out.println("<td>" + rs.getObject("contenido") + ("</td>"));
                            out.println("<td>" + rs.getObject("fecha_nota") + ("</td>"));
                            out.println("<td>" + "<a href='Control?accion=eliminar&nota="+rs.getString("id_notas")+"'><button>Eliminar nota</button></a>" + ("</td>"));
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
    </center>
    <div>
        <center>
            <form class="form" method="get" action="Control?accion=Agregar">
                <input type="text" name="nota" id="nota" size="40" required="required" placeholder="Escriba su nota" class="form-nota"/>
                <button type="submit" value="Agregar" name="accion" class="form-subir">+</button>
            </form>
        </center>
    </div>
        <div class="cancel">
                <a href="Menu?cargo=pac">REGRESAR</a>
            </div>
</body>
</html>