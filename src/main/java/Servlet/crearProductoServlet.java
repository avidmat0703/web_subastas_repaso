package Servlet;

import DAO.CategoryDAOImplements;
import DAO.ProductDAOImplementes;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;
import model.Product;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "crearProducto", urlPatterns = "/crearProducto")
public class crearProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CategoryDAOImplements c = new CategoryDAOImplements();
        List<Category> lista = c.getAll();

        req.setAttribute("lista", lista);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/crearProducto.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nombre = req.getParameter("nombre");
        String descripcion = req.getParameter("descripcion");
        String urlImagen = req.getParameter("urlImagen");
        Double puja = Double.valueOf(req.getParameter("pujaInicio"));
        Integer c = Integer.valueOf(req.getParameter("categoria"));
        Product p = new Product();
        p.setTitle(nombre);
        p.setDescription(descripcion);
        p.setImg_url(urlImagen);
        p.setStarting_bid(puja);

        ProductDAOImplementes productDAOImplementes = new ProductDAOImplementes();
        CategoryDAOImplements categoryDAOImplements = new CategoryDAOImplements();
        Optional<Category> c2 = categoryDAOImplements.find(c);
        if(c2.isPresent()){
            Category c3 = new Category();
            c3.setTitle(c2.get().getTitle());
            c3.setCategory_id(c2.get().getCategory_id());
            c3.setDescription(c2.get().getDescription());

            p.setCategory_id(c3);
            productDAOImplementes.create(p);
        }

        resp.sendRedirect(req.getContextPath() + "/listarProductos");
    }
}
