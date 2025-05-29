package DAO;

import model.Auction;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AuctionDAOImplements extends AbstractDAOImpl implements AuctionDAO{


    @Override
    public void create(Auction auction) {

    }

    @Override
    public List<Auction> getAll() {
        return List.of();
    }

    @Override
    public Optional<Auction> find(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("SELECT * FROM auction_house.auction" +
                    " join auction_house.user u" +
                    " on u.user_id = auction.user_id WHERE auction_id = ?");

            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                Auction a = new Auction();

                a.setAuction_id(rs.getInt("auction_id"));
                a.setStatus(rs.getInt("status"));
                a.setTitle(rs.getString("title"));
                a.setDescription(rs.getString("description"));
                a.setEnd_date(rs.getDate("end_date").toLocalDate());
                a.setStart_date(rs.getDate("start_date").toLocalDate());

                User u = new User();
                u.setUser_id(rs.getInt("u.user_id"));
                u.setUsername(rs.getString("u.username"));
                u.setPassword(rs.getString("u.password"));
                u.setEmail(rs.getString("u.email"));
                a.setUser(u);

                return Optional.of(a);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

        return Optional.empty();
    }

    @Override
    public void update(Auction auction) {

    }

    @Override
    public void delete(int id) {

    }
}
