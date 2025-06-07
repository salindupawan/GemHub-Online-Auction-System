package lk.gemhub.project.notification;

import lk.gemhub.project.model.Product;

public class BroadcatUtil {
    private static BidNotificationBroadcaster broadcaster;

    public static void setBroadcaster(BidNotificationBroadcaster obj) {
        broadcaster = obj;
    }

    public static void updateAllUsers(Product product) {
        if(broadcaster != null) {
            broadcaster.updateAllUsers(product);
        }
    }

    public static void notifyBidder(String email, Integer messageType, String message) {
        if(broadcaster != null) {
            broadcaster.sendNotification(email, messageType, message);
        }
    }
}
