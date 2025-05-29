package Servlet;

import DAO.AuctionDAOImplements;
import DAO.ProductDAOImplementes;
import DAO.UserDAOImplementes;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Auction;
import model.Product;
import model.User;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@WebServlet(name = "editarSubasta", urlPatterns = "/editarSubasta")
public class editarSubastaServelt extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        AuctionDAOImplements auctionDAOImplementes = new AuctionDAOImplements();
        ProductDAOImplementes productDAOImplementes = new ProductDAOImplementes();
        UserDAOImplementes userDAOImplementes = new UserDAOImplementes();
        List<User> list = userDAOImplementes.getAll();
        Optional<Auction> a = auctionDAOImplementes.find(id);
        Integer valor = a.get().getUser().getUser_id();

        req.setAttribute("lista", list);
        req.setAttribute("a", a);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/editarSubasta.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nombre = req.getParameter("nombre");
        Integer id = Integer.valueOf(req.getParameter("usuario"));
        String estado = req.getParameter("estado");
        String descripcion = req.getParameter("descripcion");
        LocalDate startDate = LocalDate.parse(req.getParameter("fecha_inicio"));
        LocalDate endDate = LocalDate.parse(req.getParameter("fecha_fin"));
        Integer valor = null;
        switch (estado){
            case "inactivo":
            {
                valor = 0;
            }break;
            case "pendiente":
            {
                valor = 1;
            }break;
            case "activo":{
                valor =2;
            }break;
        }

        User u = new User();
        u.setUsername(nombre);
        u.setUser_id(id);
        Auction a = new Auction();
        a.setUser(u);
        a.setTitle(nombre);
        a.setStart_date(startDate);
        a.setEnd_date(endDate);
        a.setDescription(descripcion);
        a.setAuction_id(id);
        a.setStatus(valor);

        AuctionDAOImplements auctionDAOImplements = new AuctionDAOImplements();
        auctionDAOImplements.update(a);

        resp.sendRedirect(req.getContextPath() + "/listarProductos");
    }
}
