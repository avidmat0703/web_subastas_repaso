package DAO;

import model.Auction;
import model.Category;
import model.Product;
import model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAOImplementes extends AbstractDAOImpl implements UserDAO{
    @Override
    public void create(User user) {

    }

    @Override
    public List<User> getAll() {

        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<User> list = new ArrayList<>();

        try{
            conn = connectDB();

            s =  conn.createStatement();

            rs = s.executeQuery("""
               SELECT * from auction_house.user u ;
           """);

            while(rs.next()){
                User u = new User();
                u.setUser_id(rs.getInt("u.user_id"));
                u.setPassword(rs.getString("u.password"));
                u.setEmail(rs.getString("u.email"));
                u.setUsername(rs.getString("u.username"));

                list.add(u);
            }

            return list;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }



    }

    @Override
    public Optional<User> find(int id) {
        return Optional.empty();
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(int id) {

    }
}
