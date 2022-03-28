/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Course;

import Dao.CourseDao;
import Entity.Course;
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
public class Add_Course_Servlet extends HttpServlet {

    private CourseDao courseDao = new CourseDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String courseId = req.getParameter("courseId");
        String courseName = req.getParameter("courseName");
        HttpSession loginSession = req.getSession(false);
        if (loginSession == null || loginSession.getAttribute("username") == null) {
            resp.sendRedirect(req.getContextPath() + "/LoginServlet");
        } else {
            String userName = (String) loginSession.getAttribute("username");
            req.setAttribute("username", userName);
            if (!courseDao.checkCourseId(courseId, courseName).isEmpty()) {
                Object errorcMess = "Duplicated course added!";
                req.setAttribute("errorcMess", errorcMess);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/Course/course_add.jsp");
                rd.forward(req, resp);
            } else {
                Course c = new Course();
                c.setMakh(courseId);
                c.setTenkh(courseName);
                courseDao.add(c);
                Object addcMess = "Added course successfully!";
                req.setAttribute("addcMess", addcMess);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/Course/course_add.jsp");
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
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Course/course_add.jsp");
            rd.forward(req, resp);
        }
    }

}
