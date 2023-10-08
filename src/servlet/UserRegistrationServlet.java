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
import java.util.Objects;

@WebServlet(value = "/registration")
public class UserRegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String fullName = req.getParameter("fullName");
        User user = UserDBManager.getUserByEmail(email);
        if(user == null && !email.isEmpty() && !password.isEmpty() && !fullName.isEmpty()){
            UserDBManager.registerUser(new User(email, password, fullName));
            user = UserDBManager.getUserByEmail(email);
            HttpSession session = req.getSession(false);
            session.setAttribute("account", user);
        }
        resp.sendRedirect("/");
    }
}
