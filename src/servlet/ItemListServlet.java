package servlet;

import db.ItemDBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Item;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/itemList")
public class ItemListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Item> items = ItemDBManager.getItems(null);
        req.setAttribute("items", items);
        req.getRequestDispatcher("itemList.jsp").forward(req, resp);
    }
}
