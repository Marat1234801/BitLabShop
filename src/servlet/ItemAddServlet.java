package servlet;

import db.ItemDBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Item;

import java.io.IOException;

@WebServlet(value = "/addItem")
public class ItemAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addItem.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        Double price = null;
        if(!req.getParameter("price").isEmpty()){
            price = Double.parseDouble(req.getParameter("price"));
        }
        if(!name.isEmpty() && !description.isEmpty() && price != null){
            ItemDBManager.addItem(new Item(name, description, price));
        }
        resp.sendRedirect("/itemList");
    }
}
