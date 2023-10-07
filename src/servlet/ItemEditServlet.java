package servlet;

import db.ItemDBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Item;

import java.io.IOException;

@WebServlet(value = "/editItem")
public class ItemEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Item item = ItemDBManager.getItemById(id);
        req.setAttribute("item", item);
        req.getRequestDispatcher("itemEdit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Item item = ItemDBManager.getItemById(id);
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        Double price = null;
        if(!req.getParameter("price").isEmpty()){
            price = Double.parseDouble(req.getParameter("price"));
        }
        if(!name.isEmpty() && !description.isEmpty() && price != null){
            item.setName(name);
            item.setDescription(description);
            item.setPrice(price);
            ItemDBManager.editItemById(item);
        }
        resp.sendRedirect("/itemList");
    }
}
