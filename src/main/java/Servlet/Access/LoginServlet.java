/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Access;

import Dao.UserDao;
import Entity.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author TAN
 */
public class LoginServlet extends HttpServlet {

    private UserDao user = new UserDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String passWord = req.getParameter("password");
        System.out.println("username = " + userName + passWord);
        User u = new User();
        u.setUsername(userName);
        u.setPassword(passWord);
        if (user.valid(u)) {
            HttpSession loginSession = req.getSession();
            loginSession.setMaxInactiveInterval(24 * 60 * 60);
            loginSession.setAttribute("username", userName);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/bar_progress.jsp");
            rd.forward(req, resp);
        } else {
            Object errorMess = "Invalid username or password!";
            req.setAttribute("errorMess", errorMess);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(req, resp);
    }

}
