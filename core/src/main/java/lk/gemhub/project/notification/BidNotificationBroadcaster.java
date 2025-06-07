package lk.gemhub.project.notification;

import lk.gemhub.project.model.Product;

public interface BidNotificationBroadcaster {
    public static final Integer NOTIFICATION = 12;
    public static final Integer BROADCAST = 11;
    public static final Integer ERROR_MESSAGE = 10;
    public static final Integer SUCCESS_MESSAGE = 9;


    public void sendNotification(String email, Integer messageType, String message);
    public void updateAllUsers(Product product);

}
