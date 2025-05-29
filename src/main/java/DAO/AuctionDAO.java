package DAO;

import model.Auction;

import java.util.List;
import java.util.Optional;

public interface AuctionDAO {

    public void create(Auction auction);
    public List<Auction> getAll();
    public Optional<Auction> find(int id);
    public void update(Auction auction);

    public void delete(int id);
}
