package DAO;

import model.Auction;
import model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDAO {

    public void create(Product product);
    public List<Product> getAll();
    public Optional<Product> find(int id);
    public void update(Product product);
    public void delete(int id);
}
