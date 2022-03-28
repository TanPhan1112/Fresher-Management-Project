/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Student;

import Dao.ScoreDao;
import Dao.StudentDao;
import Entity.Student;
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
public class Delete_Student_Servlet extends HttpServlet {

    private StudentDao st = new StudentDao();
    private ScoreDao sc = new ScoreDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession loginSession = req.getSession(false);
        if (loginSession == null || loginSession.getAttribute("username") == null) {
            resp.sendRedirect(req.getContextPath() + "/LoginServlet");
        } else {
            String userName = (String) loginSession.getAttribute("username");
            req.setAttribute("username", userName);
            String stId = req.getParameter("mahv");
//            System.out.println("ma hoc vien = " + stId);
            Student s = new Student();
            s.setMahv(Integer.valueOf(stId));
            sc.deleteScore(Integer.valueOf(stId));
            st.deleteStudent(s);
            Object delMess = "Deleted student successfully!";
            req.setAttribute("delMess", delMess);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Student/student_delete.jsp");
            rd.forward(req, resp);
        }
    }

}
