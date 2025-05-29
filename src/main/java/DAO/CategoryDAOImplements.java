package DAO;

import model.Product;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CategoryDAOImplements extends AbstractDAOImpl implements Category{


    @Override
    public void create(model.Category category) {

    }

    @Override
    public List<model.Category> getAll() {
        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<model.Category> listCategories = new ArrayList<>();

        try{
            conn = connectDB();
            s = conn.createStatement();
            rs = s.executeQuery("SELECT * from auction_house.category c");

            while (rs.next()){
                model.Category category = new model.Category();

                category.setCategory_id(rs.getInt("category_id"));
                category.setTitle(rs.getString("title"));
                category.setDescription(rs.getString("description"));

                listCategories.add(category);
            }
            return listCategories;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<model.Category> find(int id) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("SELECT * FROM auction_house.category WHERE category_id = ?");

            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                model.Category pedido = new model.Category();

                pedido.setCategory_id(rs.getInt("category_id"));
                pedido.setDescription(rs.getString("description"));
                pedido.setTitle(rs.getString("title"));
                return Optional.of(pedido);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

        return Optional.empty();


    }

    @Override
    public void update(model.Category category) {

    }


    @Override
    public void delete(int id) {

    }
}
