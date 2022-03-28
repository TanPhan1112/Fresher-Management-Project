/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Student;

import Dao.ScoreDao;
import Dao.StudentDao;
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
public class Statistics_Student_Servlet extends HttpServlet {

    private StudentDao st = new StudentDao();
    private ScoreDao scDao = new ScoreDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stId = req.getParameter("stId");
        String courseId = req.getParameter("makh");
        System.out.println("iddd ============== " + stId);
        System.out.println("ma khoa hoc  ====== " + courseId);
        HttpSession loginSession = req.getSession(false);
        if (loginSession == null || loginSession.getAttribute("username") == null) {
            resp.sendRedirect(req.getContextPath() + "/LoginServlet");
        } else {
            String userName = (String) loginSession.getAttribute("username");
            req.setAttribute("username", userName);
            if (!st.listOne(Integer.valueOf(stId)).isEmpty()) {
                List<Object[]> listsv = scDao.listBangdiem(Integer.valueOf(stId));
                if (!listsv.isEmpty()) {
                    req.setAttribute("listsv", listsv);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/Student/student_statistics.jsp");
                    rd.forward(req, resp);
                } else {
                    Object staError = "Student not found!";
                    req.setAttribute("staError", staError);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/Student/student_statistics.jsp");
                    rd.forward(req, resp);
                }
            } else {
                Object staError = "Student not found!";
                req.setAttribute("staError", staError);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/Student/student_statistics.jsp");
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
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Student/student_statistics.jsp");
            rd.forward(req, resp);
        }
    }

}
