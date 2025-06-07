package lk.gemhub.project.repositary;

import jakarta.ejb.Singleton;
import lk.gemhub.project.model.Auction;
import lk.gemhub.project.model.Product;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class ProductRepo {
    private List<Product> products;

    public ProductRepo() {
        products = new ArrayList<Product>();
        products.add(new Product(1,"Blue sapphire","Blue Sapphire 2.44ct Unheated",122.));
        products.add(new Product(2,"Blue sapphire","Blue Sapphire 3.14ct Unheated",242.));
    }
    public List<Product> getProducts() {
        return products;
    }
    public void addProduct(Product product) {
        products.add(product);
    }
    public Product getProduct(int id) {
        Product found = null;
        for (Product product : products) {
            if (product.getId().equals(id)) {
                found = product;
                break;
            }
        }
        return found;
    }
    public boolean addBid(Auction auction, Integer productId) {
        boolean result = false;
        for (Product product : products) {
            if (product.getId().equals(productId)) {
                product.addAuction(auction);
                product.setHighestBid(auction.getPrice());
                product.setBidOwner(auction.getBidder());
                result = true;
                System.out.println("createBid called form bidservice");
            }
        }

        return result;
    }
}
