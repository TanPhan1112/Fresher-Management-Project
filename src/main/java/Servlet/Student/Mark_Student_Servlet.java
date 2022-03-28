/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Student;

import Dao.CourseSubjectDao;
import Dao.ScoreDao;
import Dao.StudentDao;
import Entity.Score;
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
public class Mark_Student_Servlet extends HttpServlet {

    private StudentDao stDao = new StudentDao();
    private ScoreDao scDao = new ScoreDao();
    private CourseSubjectDao csDao = new CourseSubjectDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stId = req.getParameter("stId");
        String courseId = req.getParameter("courseId");
        String subjectId = req.getParameter("subjectId");
        String theory = req.getParameter("theory");
        String practical = req.getParameter("practical");
        try {
            HttpSession loginSession = req.getSession(false);
            if (loginSession == null || loginSession.getAttribute("username") == null) {
                resp.sendRedirect(req.getContextPath() + "/LoginServlet");
            } else {
                String userName = (String) loginSession.getAttribute("username");
                req.setAttribute("username", userName);
                Score sc = new Score();
                sc.setMahv(Integer.valueOf(stId));
                sc.setMakh(courseId);
                sc.setMamon(subjectId);
                sc.setDiemlt(Float.valueOf(theory));
                sc.setDiemth(Float.valueOf(practical));
                if (!stDao.listOne(Integer.valueOf(stId)).isEmpty()) {
                    if (scDao.listOne(Integer.valueOf(stId), courseId, subjectId).isEmpty()) {
                        if (!csDao.checkCourseSubject(courseId, subjectId).isEmpty()) {
                            scDao.addScore(sc);
                            Object markMess = "Added student successfully!";
                            req.setAttribute("markMess", markMess);
                            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Student/student_practical_mark.jsp");
                            rd.forward(req, resp);
                        } else {
                            Object markError = "Invalid course or subject!";
                            req.setAttribute("markError", markError);
                            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Student/student_practical_mark.jsp");
                            rd.forward(req, resp);
                        }
                    } else {
                        Object markError = "Duplicated input information!";
                        req.setAttribute("markError", markError);
                        RequestDispatcher rd = getServletContext().getRequestDispatcher("/Student/student_practical_mark.jsp");
                        rd.forward(req, resp);
                    }
                } else {
                    Object markError = "Not found student!";
                    req.setAttribute("markError", markError);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/Student/student_practical_mark.jsp");
                    rd.forward(req, resp);
                }
            }
        } catch (IOException | NumberFormatException e) {
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
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Student/student_practical_mark.jsp");
            rd.forward(req, resp);
        }
    }

}
