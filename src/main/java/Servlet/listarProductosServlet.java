package Servlet;

import DAO.ProductDAOImplementes;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "listarProductos", urlPatterns = "/listarProductos")
public class listarProductosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductDAOImplementes p = new ProductDAOImplementes();
        List<Product> lista =  p.getAll();

        req.setAttribute("lista",lista);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/listarProductos.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
