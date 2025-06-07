package lk.gemhub.project.remote;

import jakarta.ejb.Remote;
import lk.gemhub.project.dto.AuctionDTO;

@Remote
public interface BidService {
    public boolean createBid(AuctionDTO auctionDTO);
}
