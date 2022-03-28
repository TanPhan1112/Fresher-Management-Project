/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Student;

import Dao.StudentDao;
import Entity.Student;
import java.io.IOException;
import java.util.List;
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
public class Show_Student_Delete extends HttpServlet {

    private StudentDao st = new StudentDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stId = req.getParameter("stId");
        HttpSession loginSession = req.getSession(false);
        if (loginSession == null || loginSession.getAttribute("username") == null) {
            resp.sendRedirect(req.getContextPath() + "/LoginServlet");
        } else {
            String userName = (String) loginSession.getAttribute("username");
            req.setAttribute("username", userName);
            List<Student> listsv = st.listOne(Integer.valueOf(stId));
            if (!listsv.isEmpty()) {
                req.setAttribute("listsv", listsv);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/Student/student_delete.jsp");
                rd.forward(req, resp);
            } else {
                Object delError = "Student not found!";
                req.setAttribute("delError", delError);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/Student/student_delete.jsp");
                rd.forward(req, resp);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession loginSession = req.getSession(false);
        if (loginSession == null || loginSession.getAttribute("username") == null) {
            resp.sendRedirect(req.getContextPath() + "/LoginServlet");
        } else {
            String userName = (String) loginSession.getAttribute("username");
            req.setAttribute("username", userName);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Student/student_delete.jsp");
            rd.forward(req, resp);
        }
    }

}
