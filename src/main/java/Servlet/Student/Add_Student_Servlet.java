/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet.Student;

import Dao.StudentDao;
import Entity.Student;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Add_Student_Servlet extends HttpServlet {

    private StudentDao st = new StudentDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String birthday = req.getParameter("birthday");
        String gender = req.getParameter("gender");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int p = Integer.valueOf(phone);
        Student s = new Student();
        Date birthd;
        try {
            birthd = sdf.parse(birthday);
            s.setTen(name);
            s.setNgaysinh(birthd);
            s.setGioitinh(gender);
            s.setDiachi(address);
            s.setDt(p);
            s.setEmail(email);
            HttpSession loginSession = req.getSession(false);
            if (loginSession == null || loginSession.getAttribute("username") == null) {
                resp.sendRedirect(req.getContextPath() + "/LoginServlet");
            } else {
                String userName = (String) loginSession.getAttribute("username");
                req.setAttribute("username", userName);
                List<Student> listsv = st.checkPhoneEmail(p, email);
                if (listsv.isEmpty()) {
                    st.add(s);
                    Object addMess = "Added student successfully!";
                    req.setAttribute("addMess", addMess);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/Student/student_add.jsp");
                    rd.forward(req, resp);
                } else {
                    Object addError = "Duplicated phone or email!";
                    req.setAttribute("addError", addError);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/Student/student_add.jsp");
                    rd.forward(req, resp);
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(Add_Student_Servlet.class.getName()).log(Level.SEVERE, null, ex);
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
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Student/student_add.jsp");
            rd.forward(req, resp);
        }
    }

}
