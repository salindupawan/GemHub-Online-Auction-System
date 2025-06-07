package lk.gemhub.project.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.annotation.Resource;
import jakarta.jms.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.gemhub.project.dto.AuctionDTO;
import lk.gemhub.project.model.Auction;
import lk.gemhub.project.model.User;

import java.io.IOException;
import java.util.Date;

@WebServlet("/placeBid")
public class PlaceBid extends HttpServlet {

    @Resource(lookup = "gemhub/bidConnectionFactory")
    private QueueConnectionFactory factory;

    @Resource(lookup = "gemhub/bidQueue")
    private Queue bidQueue;



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        JsonObject data = gson.fromJson(request.getReader(), JsonObject.class);
        int id = data.get("id").getAsInt();
        double amount = data.get("amount").getAsDouble();

        User user = (User) request.getSession(false).getAttribute("user");
        if(user != null) {
            AuctionDTO auctionDTO = new AuctionDTO(id, amount, user, new Date());
            try {
                QueueConnection connection = factory.createQueueConnection();
                connection.start();

                QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
                MessageProducer producer = session.createProducer(bidQueue);
                ObjectMessage message = session.createObjectMessage();
                message.setObject(auctionDTO);
                producer.send(message);
                connection.close();


            } catch (JMSException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }else {
            System.out.println("user is null");
        }


    }
}
