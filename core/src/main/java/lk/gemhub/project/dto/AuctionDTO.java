package lk.gemhub.project.dto;

import lk.gemhub.project.model.User;

import java.io.Serializable;
import java.util.Date;

public class AuctionDTO implements Serializable {
    private Integer productId;
    private Double price;
    private User bidder;
    private Date date;

    public AuctionDTO() {
    }

    public AuctionDTO(Integer productId, Double price, User bidder, Date date) {
        this.productId = productId;
        this.price = price;
        this.bidder = bidder;
        this.date = date;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public User getBidder() {
        return bidder;
    }

    public void setBidder(User bidder) {
        this.bidder = bidder;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
