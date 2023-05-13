
package Clases;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Logger;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import Clases.MessageDecoder;
import Clases.MessageEncoder;

@ServerEndpoint(
        value="/chat/{username}",
        decoders = MessageDecoder.class,
        encoders = MessageEncoder.class
)
public class ChatEndpoint {
    private final Logger log = Logger.getLogger(getClass().getName());

    private Session session;
    private String username;
    private static final Set<ChatEndpoint> chatEndpoints = new CopyOnWriteArraySet<>();
    private static HashMap<String,String> users = new HashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) throws IOException, EncodeException {
        
        //log.info(session.getId() + " connected!");
        System.out.println(username);
        this.session = session;
        this.username = username;
        chatEndpoints.add(this);
        users.put(session.getId(), username);
        System.out.println(chatEndpoints.size());
        Message message = new Message();
        message.setFrom(username);
        message.setContent("Conectado!");
        broadcast(message);
    }

    @OnMessage
    public void onMessage(Session session, Message message) throws IOException, EncodeException {
        log.info(message.toString());
        System.out.println("1"+message.getTo());
        message.setFrom(users.get(session.getId()));
        sendMessageToOneUser(message);
    }

    @OnClose
    public void onClose(Session session) throws IOException, EncodeException {
        log.info(session.getId() + " Desconectado!");

        chatEndpoints.remove(this);
        users.remove(this.session.getId());
        Message message = new Message();
        message.setFrom(users.get(session.getId()));
        message.setContent("DESCONECTADO!");
        broadcast(message);
        System.out.println(chatEndpoints.size());
        System.out.println(users.size());
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        log.warning(throwable.toString());
    }

    private static void broadcast(Message message) throws IOException, EncodeException {
        for (ChatEndpoint endpoint : chatEndpoints) {
            synchronized(endpoint) {
                endpoint.session.getBasicRemote().sendObject(message);
            }
        }
    }

    private static void sendMessageToOneUser(Message message) throws IOException, EncodeException {
        System.out.println("5"+message.getTo());
        for (ChatEndpoint endpoint : chatEndpoints) {
            synchronized(endpoint) {
                System.out.println("me " + endpoint.session.getId());
                System.out.println("ma " + users.get(endpoint.session.getId()));
                if (endpoint.session.getId().equals(getSessionId(message.getTo()))) {
                    endpoint.session.getBasicRemote().sendObject(message);
                    System.out.println("nooooo");
                }
            }
        }
    }

    private static String getSessionId(String to) {
        System.out.println("nanan"+ to);
        if (users.containsValue(to)) {
            System.out.println("si señor");
            for (String sessionId: users.keySet()) {
               // System.out.println("colA"+sessionId);
                //System.out.println("mama"+ users.get(sessionId));
                if (users.get(sessionId).equals(to)) {
                    System.out.println(sessionId);
                    System.out.println("nono"+ users.get(sessionId));
                    return sessionId;
                }
            }
        }
        return null;
    }
}
