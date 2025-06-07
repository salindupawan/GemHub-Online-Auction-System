package lk.gemhub.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Product implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private Double startingPrice;
    private Double highestBid;
    private User bidOwner;
    private List<Auction> auctions = new ArrayList<Auction>();

    public Product() {

    }

    public Product(Integer id, String name, String description, Double startingPrice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startingPrice = startingPrice;
        bidOwner = null;
        highestBid = startingPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(Double startingPrice) {
        this.startingPrice = startingPrice;
    }

    public Double getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(Double highestBid) {
        this.highestBid = highestBid;
    }

    public User getBidOwner() {
        return bidOwner;
    }

    public void setBidOwner(User bidOwner) {
        this.bidOwner = bidOwner;
    }

    public void addAuction(Auction auction) {
        auctions.add(auction);
    }
    public List<Auction> getAuctions() {
        return auctions;
    }
    public int getAuctionCount(){
        return auctions.size();
    }
}
