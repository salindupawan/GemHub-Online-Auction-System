package lk.gemhub.project.controller;

import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/placeBid")
public class WebSocketTest  {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("opened");
    }
}
