package Servlet;

import DAO.AuctionDAOImplements;
import DAO.ProductDAOImplementes;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Auction;
import model.Product;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "editarSubasta", urlPatterns = "/editarSubasta")
public class editarSubastaServelt extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        AuctionDAOImplements auctionDAOImplementes = new AuctionDAOImplements();

        Optional<Auction> a = auctionDAOImplementes.find(id);
        Integer valor = a.get().getUser().getUser_id();

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/editarSubasta.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
