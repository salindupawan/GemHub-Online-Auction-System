package lk.gemhub.project.Bean;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import lk.gemhub.project.model.Auction;
import lk.gemhub.project.model.Product;
import lk.gemhub.project.remote.ProductService;
import lk.gemhub.project.repositary.ProductRepo;

import java.util.List;

@Stateless
public class ProductServiceBean implements ProductService {
    @Inject
    private ProductRepo productRepo;

    @Override
    public void saveProduct(Product product) {
        productRepo.addProduct(product);
    }

    @Override
    public List<Product> getProducts() {
        return productRepo.getProducts();
    }

    @Override
    public Product getProduct(int id) {
        return productRepo.getProduct(id);
    }

    @Override
    public boolean addNewBid(Auction auction, Integer productId) {
        System.out.println("createBid called form productServiceBean");

       return productRepo.addBid(auction, productId);

    }


}
