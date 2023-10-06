package servlet;

import db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Item> items = new ArrayList<>();
        items = DBManager.getItems();
        req.setAttribute("items", items);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}
