/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Course;

import Dao.CourseDao;
import Entity.Course;
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
public class Show_Course_Delete extends HttpServlet {

    private CourseDao courseDao = new CourseDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String courseId = req.getParameter("courseId");
        HttpSession loginSession = req.getSession(false);
        if (loginSession == null || loginSession.getAttribute("username") == null) {
            resp.sendRedirect(req.getContextPath() + "/LoginServlet");
        } else {
            String userName = (String) loginSession.getAttribute("username");
            req.setAttribute("username", userName);
            List<Course> listcourse = courseDao.listOne(courseId);
            if (!listcourse.isEmpty()) {
                req.setAttribute("listcourse", listcourse);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/Course/course_delete.jsp");
                rd.forward(req, resp);
            } else {
                Object delcError = "Course not found!";
                req.setAttribute("delcError", delcError);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/Course/course_delete.jsp");
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
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Course/course_delete.jsp");
            rd.forward(req, resp);
        }
    }

}
