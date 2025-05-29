package DAO;

import model.Auction;

import java.util.List;
import java.util.Optional;

public interface Category {
    public void create(model.Category category);
    public List<model.Category> getAll();
    public Optional<model.Category> find(int id);
    public void update(model.Category category);

    public void delete(int id);
}
