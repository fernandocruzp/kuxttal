package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Clases.UsChat;
import java.util.ArrayList;

public final class ChatPrincipal_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
 String usu = (String) request.getAttribute("usu");
      out.write('\n');
 ArrayList<UsChat> usua = (ArrayList<UsChat>) request.getAttribute("contactos");
      out.write('\n');
int largo= usua.size();
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("      <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.0/handlebars.min.js\"></script>\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/list.js/1.1.1/list.min.js\"></script>\n");
      out.write("    <!--    libs for stomp and sockjs-->\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.js\"></script>\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js\"></script>\n");
      out.write("    <!--    end libs for stomp and sockjs-->\n");
      out.write("    <link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css\" rel=\"stylesheet\"\n");
      out.write("          type=\"text/css\">\n");
      out.write("    <link href=\"css1/style.css\" rel=\"stylesheet\">\n");
      out.write("        <title>Kuxttal || Chat</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"bit_titulo\">Mis chats</div>\n");
      out.write("        <div>\n");
      out.write("            <hr size=\"5\" color=\"#5df505\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"container clearfix\">\n");
      out.write("    <div class=\"people-list\" id=\"people-list\">\n");
      out.write("        <div class=\"search\">\n");
      out.write("            <p id=\"userName\">");
      out.print(usu);
      out.write("</p>\n");
      out.write("            <p type=\"text\" id=\"to\"></p>\n");
      out.write("            <button type=\"button\" onclick=\"connect();\" >Conectar</button>\n");
      out.write("        </div>\n");
      out.write("        <ul class=\"list\" id=\"usersList\">\n");
      out.write("            ");

                for (int i=0; i< largo;i++){
                    out.println("<a href='javascript:seleccionar("+'"'+usua.get(i).getUsu()+'"'+")'><li><img src='IMG/user.png' id='ima' height='20px'>"+usua.get(i).getUsu()+"</li></a>");
                }
            
      out.write("\n");
      out.write("        </ul>\n");
      out.write("        <a href='javascript:seleccionar(\"lalodoc\")'><p>edd</p></a>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"chat\">\n");
      out.write("        <div class=\"chat-header clearfix\">\n");
      out.write("            <img src='IMG/user.png' id='ima' height='20px'>\n");
      out.write("\n");
      out.write("            <div class=\"chat-about\">\n");
      out.write("                <div class=\"chat-with\" id=\"selectedUserId\"></div>\n");
      out.write("                <div class=\"chat-num-messages\"></div>\n");
      out.write("            </div>\n");
      out.write("            <i class=\"fa fa-star\"></i>\n");
      out.write("        </div> <!-- end chat-header -->\n");
      out.write("\n");
      out.write("        <div class=\"chat-history\" id=\"chat-history\">\n");
      out.write("            <ul>\n");
      out.write("                <p>Solo puedes chatar con tus doctores</p>\n");
      out.write("            </ul>\n");
      out.write("\n");
      out.write("        </div> <!-- end chat-history -->\n");
      out.write("\n");
      out.write("        <div class=\"chat-message clearfix\">\n");
      out.write("            <textarea id=\"message-to-send\" name=\"message-to-send\" placeholder=\"Type your message\" rows=\"3\"></textarea>\n");
      out.write("\n");
      out.write("            <i class=\"fa fa-file-o\"></i> &nbsp;&nbsp;&nbsp;\n");
      out.write("            <i class=\"fa fa-file-image-o\"></i>\n");
      out.write("\n");
      out.write("            <button id=\"sendBtn\">Send</button>\n");
      out.write("\n");
      out.write("        </div> <!-- end chat-message -->\n");
      out.write("\n");
      out.write("    </div> <!-- end chat -->\n");
      out.write("\n");
      out.write("</div> <!-- end container -->\n");
      out.write("\n");
      out.write("<script id=\"message-template\" type=\"text/x-handlebars-template\">\n");
      out.write("    <li class=\"clearfix\">\n");
      out.write("        <div class=\"message-data align-right\">\n");
      out.write("            <span class=\"message-data-time\">{{time}}, Hoy</span> &nbsp; &nbsp;\n");
      out.write("            <span class=\"message-data-name\"Tu</span> <i class=\"fa fa-circle me\"></i>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"message other-message float-right\">\n");
      out.write("            {{messageOutput}}\n");
      out.write("        </div>\n");
      out.write("    </li>\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<script id=\"message-response-template\" type=\"text/x-handlebars-template\">\n");
      out.write("    <li>\n");
      out.write("        <div class=\"message-data\">\n");
      out.write("            <span class=\"message-data-name\"><i class=\"fa fa-circle online\"></i> {{userName}}</span>\n");
      out.write("            <span class=\"message-data-time\">{{time}}, Hoy</span>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"message my-message\">\n");
      out.write("            {{response}}\n");
      out.write("        </div>\n");
      out.write("    </li>\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<script src=\"JS/custom.js\"></script>\n");
      out.write("<<script src=\"JS/script.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
