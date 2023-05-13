package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"es\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("        <title>Inicio | Kuxttal</title>\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Roboto:300&display=swap\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"Css/indexCSS.css\">\n");
      out.write("        <link rel=\"icon\" href=\"IMG/icon.png\" type=\"image/x-icon\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("\n");
      out.write("            <div class=\"menu\">\n");
      out.write("                <nav>\n");
      out.write("                    <p id=\"nom\" align=\"left\">K&nbsp;U&nbspX&nbspT&nbspT&nbspA&nbspL</p>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"Registro.jsp\">Registro</a></li>\n");
      out.write("                        <li><a href=\"InicioSesion.jsp\">Inicio de sesión</a></li>\n");
      out.write("                        <li><a href=\"#servicios\">Conócenos</a></li>\n");
      out.write("                        <li><a href=\"#servicios\">Acerca de</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </nav>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        <div class=\"contenedor\">\n");
      out.write("\n");
      out.write("            <div class=\"slider-contenedor\">\n");
      out.write("\n");
      out.write("                <section class=\"contenido-slider\">\n");
      out.write("                    <div class=\"sizeD\">\n");
      out.write("                        <h1 class=\"s1\">¿Cómo   KUXTTAL  cambia    el  seguimiento  clínico?</h1>\n");
      out.write("                        <center><a href=\"#\">Comienza ahora</a></center>\n");
      out.write("                    </div>\n");
      out.write("                </section>\n");
      out.write("\n");
      out.write("                <section class=\"contenido-slider\">\n");
      out.write("                    <div class=\"sizeD\">\n");
      out.write("                        <h2 class=\"s1\">Útil para cualquier especialidad médica.</h2>\n");
      out.write("                    </div>\n");
      out.write("                </section>\n");
      out.write("\n");
      out.write("                <section class=\"contenido-slider\">\n");
      out.write("                    <div>\n");
      out.write("                        <h2 id=\"nuevo\">Para &nbsp las &nbsp nuevas &nbsp condiciones &nbsp del &nbsp mundo.</h2>\n");
      out.write("                    </div>\n");
      out.write("                </section>\n");
      out.write("\n");
      out.write("                <section class=\"contenido-slider\">\n");
      out.write("                    <div class=\"sizeD\">\n");
      out.write("                        <h1 class=\"s1\">¿Cómo   KUXTTAL  cambia    el  seguimiento  clínico?</h1>\n");
      out.write("                        <center><a href=\"Registro.jsp\">Comienza ahora</a></center>\n");
      out.write("                    </div>\n");
      out.write("                </section>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("\n");
      out.write("        <h1 id=\"servicios\" align=\"center\">Servicios Kuxttal<span class=\"point\">.</span></h1>\n");
      out.write("\n");
      out.write("        <div class=\"flex-container\">\n");
      out.write("            <div><br>\n");
      out.write("                <p align=\"center\" ><img class=\"icons\" src=\"IMG/chat-movil.png\"><br/><br/>\n");
      out.write("                    <b>Comunícate</b><br/><br/><!--\n");
      out.write("                Información veraz y oportuna sobre la COVID-19 y la vacunación.--></p>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div><br>\n");
      out.write("                <p align=\"center\" ><img class=\"icons\" width=\"250px\" src=\"IMG/lapiz.png\">\n");
      out.write("                    <br/><br/>\n");
      out.write("                    <b>Haz tus notas</b><br/><br/><!--\n");
      out.write("                    Apartado de notas individuales.--></p>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div><br>\n");
      out.write("                <p align=\"center\" ><img class=\"icons\" width=\"250px\" src=\"IMG/bitacora.png\">\n");
      out.write("                    <br/><br/>\n");
      out.write("                    <b>Monitorea todo</b><br/><br/> <!--\n");
      out.write("                    Lleva un registro para monitoreo de evolución y signos vitales.--></p>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div><br>\n");
      out.write("                <p align=\"center\" ><img class=\"icons\" width=\"250px\" src=\"IMG/cardiologo.png\">\n");
      out.write("                    <br/><br/>\n");
      out.write("                    <b>Mantente conectado</b><br/><br/><!--\n");
      out.write("                    Mantén comunicación contínua con los médicos con quienes acudes.--></p>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <p id=\"marktg\" align=\"center\">Con esta plataforma tienes eso y más.</p>\n");
      out.write("        <br><br><br>\n");
      out.write("\n");
      out.write("        <section class=\"services\">\n");
      out.write("            <div class=\"containerr\">\n");
      out.write("                <section class=\"projects containerr\">\n");
      out.write("                    <h2 class=\"subtitle\">Contenido adicional<span class=\"point\">.</span></h2>\n");
      out.write("                    <p class=\"copy__section\">Además de sus funciones principales, Kuxttal te ofrece otros beneficios.</p>\n");
      out.write("                    <article class=\"containerr-bg\">\n");
      out.write("                        <div class=\"card\">\n");
      out.write("                            <div class=\"cards__text\">\n");
      out.write("                                <h3 class=\"card__title\">Informaión sobre COVID-19<span class=\"point\">.</span></h3>\n");
      out.write("                                <p class=\"card__date\">Próximamente.</p>\n");
      out.write("                                <p class=\"card__copy\">Ofrecemos un apartado lleno de información sobre la COVID-19, la vacunación y demás cuestiones sobre la pandemia, toda recabada de diversos portales de las más reconocidas organizaciones como la OMS, la OPS, los CDC, entre otros.</p>\n");
      out.write("                                <a href=\"#\" class=\"card__button\">Ir ahora</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"background\">\n");
      out.write("                            <img src=\"IMG/bck1.jpg\" class=\"background__img\">\n");
      out.write("                            <div class=\"background__text\">\n");
      out.write("                                <h3 class=\"background__title\">Infórmate<span class=\"point\">.</span></h3>\n");
      out.write("                                <p class=\"background__copy\">Mantente informado, continúa cuidándote y no bajes la guardia.</p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"card\">\n");
      out.write("                            <div class=\"cards__text\">\n");
      out.write("                                <h3 class=\"card__title\">Test de agudeza visual<span class=\"point\">.</span></h3>\n");
      out.write("                                <p class=\"card__date\">Próximamente.</p>\n");
      out.write("                                <p class=\"card__copy\">Como nuestra prioridad es tu bienestar, aquí podrás encontrar un examen de la vista online. Este enlace te llevará al portal oficial de ZEISS® donde podrás valorar tu nivel de agudeza visual.</p>\n");
      out.write("                                <a href=\"https://visionscreening.zeiss.com/es-MX\" class=\"card__button\">Ir ahora</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"background\">\n");
      out.write("                            <img src=\"IMG/background2.jpg\" class=\"background__img\">\n");
      out.write("                            <div class=\"background__text\">\n");
      out.write("                                <h3 class=\"background__title\">Valora tu visión<span class=\"point\">.</span></h3>\n");
      out.write("                                <p class=\"background__copy\">Recibe una estimación de cuán agudo es el más importante de tus sentidos.</p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </article>\n");
      out.write("                </section>\n");
      out.write("                <footer class=\"pie-pagina\">\n");
      out.write("                    <div class=\"grupo-2\">\n");
      out.write("                        <small>&copy; 2021-2022 <b>Fénix Inc.</b> - Todos los Derechos Reservados.</small>\n");
      out.write("                    </div>\n");
      out.write("                </footer>\n");
      out.write("\n");
      out.write("                <!--Scripts-->\n");
      out.write("                <script src=\"JS/main.js\"></script>\n");
      out.write("                </body>\n");
      out.write("\n");
      out.write("                </html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
