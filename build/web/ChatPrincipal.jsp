<%-- 
    Document   : ChatPrincipal
    Created on : 4/03/2022, 12:43:52 PM
    Author     : cruzf
--%>

<%@page import="Clases.UsChat"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String usu = (String) request.getAttribute("usu");%>
<% ArrayList<UsChat> usua = (ArrayList<UsChat>) request.getAttribute("contactos");%>
<%int largo= usua.size();%>
<%System.out.println(largo);%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.0/handlebars.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/list.js/1.1.1/list.min.js"></script>
    <!--    libs for stomp and sockjs-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
    <!--    end libs for stomp and sockjs-->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet"
          type="text/css">
    <link href="css1/style.css" rel="stylesheet">
        <title>Kuxttal || Chat</title>
    </head>
    <body>
        <div class="bit_titulo">Mis chats</div>
        <div>
            <hr size="5" color="#5df505">
        </div>
        <div class="container clearfix">
    <div class="people-list" id="people-list">
        <div class="search">
            <p id="userName"><%=usu%></p>
            <p type="text" id="to"></p>
            <button type="button" onclick="connect();" >Conectar</button>
        </div>
        <ul class="list" id="usersList">
            <%
                for (int i=0; i< largo;i++){
                    out.println("<a href='javascript:seleccionar("+'"'+usua.get(i).getUsu()+'"'+")'><li><img src='IMG/user.png' id='ima' height='20px'>"+usua.get(i).getUsu()+"</li></a>");
                }
            %>
        </ul>
    </div>
    <div class="chat">
        <div class="chat-header clearfix">
            <img src='IMG/user.png' id='ima' height='20px'>

            <div class="chat-about">
                <div class="chat-with" id="selectedUserId"></div>
                <div class="chat-num-messages"></div>
            </div>
            <i class="fa fa-star"></i>
        </div> <!-- end chat-header -->

        <div class="chat-history" id="chat-history">
            <ul>
                <p>Solo puedes chatar con tus doctores</p>
            </ul>

        </div> <!-- end chat-history -->

        <div class="chat-message clearfix">
            <textarea id="message-to-send" name="message-to-send" placeholder="Type your message" rows="3"></textarea>

            <i class="fa fa-file-o"></i> &nbsp;&nbsp;&nbsp;
            <i class="fa fa-file-image-o"></i>

            <button id="sendBtn">Send</button>

        </div> <!-- end chat-message -->

    </div> <!-- end chat -->

</div> <!-- end container -->

<script id="message-template" type="text/x-handlebars-template">
    <li class="clearfix">
        <div class="message-data align-right">
            <span class="message-data-time">{{time}}, Hoy</span> &nbsp; &nbsp;
            <span class="message-data-name"Tu</span> <i class="fa fa-circle me"></i>
        </div>
        <div class="message other-message float-right">
            {{messageOutput}}
        </div>
    </li>
</script>

<script id="message-response-template" type="text/x-handlebars-template">
    <li>
        <div class="message-data">
            <span class="message-data-name"><i class="fa fa-circle online"></i> {{userName}}</span>
            <span class="message-data-time">{{time}}, Hoy</span>
        </div>
        <div class="message my-message">
            {{response}}
        </div>
    </li>
</script>

<script src="JS/custom.js"></script>
<<script src="JS/script.js"></script>
</body>
</html>
