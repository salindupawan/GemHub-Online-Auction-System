package lk.gemhub.project.model;

import java.io.Serializable;
import java.util.Date;

public class Auction implements Serializable {

    private Double price;
    private Date date;
    private User bidder;

    public Auction() {
    }

    public Auction( Double price, Date date, User bidder) {
        this.price = price;
        this.date = date;
        this.bidder = bidder;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getBidder() {
        return bidder;
    }

    public void setBidder(User bidder) {
        this.bidder = bidder;
    }
}
