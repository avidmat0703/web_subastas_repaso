package DAO;

import model.Auction;
import model.Category;
import model.Product;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDAOImplementes extends AbstractDAOImpl implements ProductDAO{
    @Override
    public void create(Product product) {

        Connection conn = null;
        PreparedStatement ps = null;
        Statement s = null;
        ResultSet rs = null;
        ResultSet rsGenKeys = null;

        List<Product> listaClientes = new ArrayList<>();
        try{
            conn = connectDB();
            ps = conn.prepareStatement("""
                    INSERT INTO auction_house.product
            (title, description, img_url, starting_bid, category_id)
            values (?,?,?,?,?)""", Statement.RETURN_GENERATED_KEYS);


            ps.setString(1, product.getTitle());
            ps.setString(2, product.getDescription());
            ps.setString(3, product.getImg_url());
            ps.setDouble(4, product.getStarting_bid());
            ps.setInt(5, product.getCategory_id().getCategory_id());
            int rows = ps.executeUpdate();
            if (rows == 0)
                System.out.println("INSERT de cliente con 0 filas insertadas.");

            rsGenKeys = ps.getGeneratedKeys();
            if (rsGenKeys.next())
                product.setProduct_id(rsGenKeys.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<Product> getAll() {
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Product> list = new ArrayList<>();

        try{
            conn = connectDB();

            s =  conn.createStatement();

            rs = s.executeQuery("""
            SELECT * from auction_house.product p left join
            auction_house.auction a on a.auction_id = p.auction_id JOIN auction_house.category
            c on p.category_id = c.category_id left join auction_house.user u on a.user_id = u.user_id""");

            while(rs.next()){
                Product p = new Product();

                p.setProduct_id(rs.getInt("product_id"));
                p.setTitle(rs.getString("title"));
                p.setImg_url(rs.getString("img_url"));
                p.setStarting_bid(rs.getDouble("starting_bid"));
                p.setCurrent_bid(rs.getDouble("current_bid"));
                p.setDescription(rs.getString("description"));
                p.setClosing_bid(rs.getDouble("closing_bid"));


                Auction a = new Auction();
                Integer valor = 0;
                valor = rs.getInt("a.auction_id");
                if(valor != 0){
                    a.setAuction_id(rs.getInt("a.auction_id"));
                    a.setDescription(rs.getString("a.description"));
                    a.setTitle(rs.getString("a.title"));
                    a.setStatus(rs.getInt("a.status"));
                    a.setStart_date(rs.getDate("a.start_date").toLocalDate());
                    a.setEnd_date(rs.getDate("a.end_date").toLocalDate());
                }



                User user = new User();
                user.setUser_id(rs.getInt("u.user_id"));
                user.setEmail(rs.getString("u.email"));
                user.setUsername(rs.getString("u.username"));
                user.setPassword(rs.getString("u.password"));
                a.setUser(user);
                p.setAuction_id(a);

                Category c = new Category();
                    c.setCategory_id(rs.getInt("c.category_id"));
                    c.setDescription(rs.getString("c.description"));
                    c.setTitle(rs.getString("c.title"));

                    p.setCategory_id(c);


                    list.add(p);
                }

            return list;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public Optional<Product> find(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(int id) {

    }
}
