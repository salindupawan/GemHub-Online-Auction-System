package lk.gemhub.project.Bean;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import lk.gemhub.project.dto.AuctionDTO;
import lk.gemhub.project.model.Auction;
import lk.gemhub.project.remote.BidService;
import lk.gemhub.project.remote.ProductService;

@Stateless
public class BidServiceBean implements BidService {
    @EJB
    private ProductService productService;

    @Override
    public boolean createBid(AuctionDTO auctionDTO) {
        System.out.println("createBid called form bidservice");
       return productService.addNewBid(new Auction(auctionDTO.getPrice(),auctionDTO.getDate(),auctionDTO.getBidder()), auctionDTO.getProductId());
    }
}
