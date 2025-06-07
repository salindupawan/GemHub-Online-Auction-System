package lk.gemhub.project.remote;

import jakarta.ejb.Remote;
import lk.gemhub.project.dto.AuctionDTO;
import lk.gemhub.project.model.Auction;
import lk.gemhub.project.model.Product;

import java.util.List;

@Remote
public interface ProductService {
    public void saveProduct(Product product);
    public List<Product> getProducts();
    public Product getProduct(int id);
    public boolean addNewBid(Auction auction, Integer productId);

}
