var ws;
var mensajes=[];
function connect() {
    var username = document.getElementById("userName").innerHTML;
    console.log(username);
    ws = new WebSocket("ws://"+document.location.host+"/Kuxttalinicia_3/chat/" + username);
    console.log(username);
    ws.onmessage = function(event) {
    var log = document.getElementById("log");
        console.log(event.data);
        var message = JSON.parse(event.data);
        if (message.envia === document.getElementById("to").innerHTML)
            render(message.content, message.envia);
            //log.innerHTML += message.envia + " : " + message.content + "\n";
        else
            if(message.content!=="Conectado!" && message.content!=="DESCONECTADO!"){
                alert("nuevo mensaje de: " + message.envia);
            }
        var mensajito={
        'envia': message.envia,
        'recibe': username,
        'mensaje': message.content
    };
    mensajes.push(mensajito);
    var envia= message.envia;
    console.log(mensajes.filter(function(mensajito,envia){
        return mensajito.envia === envia;
    }));
    console.log(mensajes.length);
    mensajes.forEach(function(elemento,indice,array){
        console.log(elemento.envia,indice);
    });
    };
}

function send() {
    var content = document.getElementById("message-to-send").value;
    var username = document.getElementById("userName").innerHTML;
    var to = document.getElementById("to").innerHTML;
    console.log(username);
    console.log(to);
    var json = JSON.stringify({
        "to":to,
        "content":content
    });

    ws.send(json);
    var mensajito={
        'envia': username,
        'recibe': to,
        'mensaje': content
    };
    mensajes.push(mensajito);
}
function listar(to){
    console.log("dd");
    var lista=[];
    var lista2=[];
    var sa,sa2;
    console.log(to);
    mensajes.forEach(function(elemento,indice,array){
        console.log("enviado"+elemento.envia,indice);
        console.log("mensajsss"+elemento.mensaje,indice);
        lista2.push(elemento.mensaje);
    });
    console.log("tamaño lista primera"+lista2.length);
    ca=lista2.length;
    var lista3=[];
    for (i=0; i<ca;i++){
        if (mensajes[i].envia===to || mensajes[i].recibe===to){
            lista.push(mensajes[i]);
            lista3.push(mensajes[i].recibe);
        }
    }
    console.log("tamaño lista"+lista.length);
    var ca2= lista3.length;
    console.log("tamaño lista3" +ca2);
    cleanscreen();
    for (i=0; i<ca2;i++){
        console.log(to);
        if (lista[i].envia===to){
            console.log("1"+lista[i].mensaje);
            render2(lista[i].mensaje,to);
        }
        else{
            console.log("2"+lista[i].mensaje);
            sendMessage2(lista[i].mensaje);
        }
    }

}

function seleccionar(userName) {
                $chatHistory = $('.chat-history');
                $chatHistoryList = $chatHistory.find('ul');
                console.log("selecting users: " + userName);
                selectedUser = userName;
                $('#selectedUserId').html('');
                $('#selectedUserId').append(userName);
                $('#to').html('');
                $('#to').append(userName);
                listar(userName);
                //$chatHistoryList.html('');                
}
