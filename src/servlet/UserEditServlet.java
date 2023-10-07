package servlet;

import db.UserDBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;

@WebServlet(value = "/editUser")
public class UserEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        User user = UserDBManager.getUserById(id);
        req.setAttribute("user", user);
        req.getRequestDispatcher("editUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String fullName = req.getParameter("fullName");
        User user = UserDBManager.getUserById(id);
        user.setEmail(email);
        user.setPassword(password);
        user.setFullName(fullName);
        UserDBManager.editUser(user);
        HttpSession session = req.getSession(false);
        session.setAttribute("account", user);
        resp.sendRedirect("/");
    }
}
