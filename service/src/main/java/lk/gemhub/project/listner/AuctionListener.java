package lk.gemhub.project.listner;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.EJB;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.ObjectMessage;
import lk.gemhub.project.dto.AuctionDTO;
import lk.gemhub.project.model.Product;
import lk.gemhub.project.notification.BidNotificationBroadcaster;
import lk.gemhub.project.notification.BroadcatUtil;
import lk.gemhub.project.remote.BidService;
import lk.gemhub.project.remote.ProductService;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup",propertyValue = "gemhub/bidQueue")
})
public class AuctionListener implements MessageListener {
    @EJB
    private BidService bidService;

    @EJB
    private ProductService productService;

    @Override
    public void onMessage(Message message) {
        if(message instanceof ObjectMessage) {
            ObjectMessage objectMessage = (ObjectMessage) message;

                try {
                    AuctionDTO auctionDTO = (AuctionDTO) objectMessage.getObject();

                    Product product = productService.getProduct(auctionDTO.getProductId());

                    if(product != null) {
                        if(auctionDTO.getPrice()>product.getHighestBid()){
                            System.out.println(auctionDTO.getBidder().getName());
                            System.out.println(auctionDTO.getPrice());
                            System.out.println(auctionDTO.getProductId());
                            boolean bid = bidService.createBid(auctionDTO);
                            if(bid) {
                                BroadcatUtil.updateAllUsers(productService.getProduct(auctionDTO.getProductId()));
                                BroadcatUtil.notifyBidder(auctionDTO.getBidder().getEmail(), BidNotificationBroadcaster.SUCCESS_MESSAGE,"Your bid is placed successfully.");
                            }else{
                                BroadcatUtil.notifyBidder(auctionDTO.getBidder().getEmail(), BidNotificationBroadcaster.ERROR_MESSAGE,"Something went wrong. Please try again later");

                            }

                            System.out.println(product.getHighestBid());
                            System.out.println(product.getId());
                        }else{
                            BroadcatUtil.notifyBidder(auctionDTO.getBidder().getEmail(), BidNotificationBroadcaster.ERROR_MESSAGE,"Enter valid bid amount");

                            System.out.println("enter valid amount");
                        }

                    }else{
                        BroadcatUtil.notifyBidder(auctionDTO.getBidder().getEmail(), BidNotificationBroadcaster.ERROR_MESSAGE,"Something went wrong. Please try again later");

                    }



                } catch (JMSException e) {
                    throw new RuntimeException(e);
                }


        }else {
            System.out.println("Message is not an ObjectMessage");
        }

    }
}
