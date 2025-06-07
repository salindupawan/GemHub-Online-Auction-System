package lk.gemhub.project.endpoint;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import lk.gemhub.project.model.Product;
import lk.gemhub.project.notification.BidNotificationBroadcaster;
import lk.gemhub.project.notification.BroadcatUtil;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/addNewBid")
public class AddNewBid implements BidNotificationBroadcaster {

    private static final Set<Session> sessions = ConcurrentHashMap.newKeySet();
    private static final Map<String,Session> sessionMap = new ConcurrentHashMap<>();

    static {
        BroadcatUtil.setBroadcaster(new AddNewBid());
    }



    @Override
    public void sendNotification(String email, Integer messageType, String message) {
        Session session = sessionMap.get(email);
        if(session != null && session.isOpen()) {
            session.getAsyncRemote().sendText(String.format("{\"code\": %d,\"type\": %d,\"message\": \"%s\"}", BidNotificationBroadcaster.NOTIFICATION,messageType,message));
        }
    }

    @Override
    public void updateAllUsers(Product product) {
        String message = String.format("{\"code\": %d,\"id\": %d, \"currentPrice\": %.2f, \"bidOwner\": \"%s\", \"auctionCount\": %d}",
                BidNotificationBroadcaster.BROADCAST,product.getId(), product.getHighestBid(), product.getBidOwner().getName(), product.getAuctionCount());
        for (Session session : sessions) {
            session.getAsyncRemote().sendText(message);
        }

    }

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
        System.out.println("session opened");
    }
    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
        System.out.println("session closed");
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(message, JsonObject.class);
        sessionMap.put(jsonObject.get("email").getAsString(), session);
    }
}
