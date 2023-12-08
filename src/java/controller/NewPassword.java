package controller;

import dao.UserDB;
import entity.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NewPassword
 */
@WebServlet("/newPassword")
public class NewPassword extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
//                int id = Integer.parseInt(request.getParameter("id"));     
//                UserDB u =new UserDB();
//                User user = u.findUserById(id);
        String newPassword = request.getParameter("password");
        String confPassword = request.getParameter("confPassword");
        if (newPassword.equals(confPassword)) {
            user.setPassword(newPassword);
            UserDB.update(user);
            session.removeAttribute("user");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        else {
            request.setAttribute("message", "wrong");
            request.getRequestDispatcher("newPassword.jsp").forward(request, response);
        }

//              
    }

}
