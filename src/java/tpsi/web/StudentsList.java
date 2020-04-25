/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpsi.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alicj
 */
@WebServlet(name = "StudentsList", urlPatterns = {"/StudentsList"})
public class StudentsList extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        
        if (session.getAttribute("counter") == null) {
            session.setAttribute("counter", 1);
        } else {
            int counter = (int) session.getAttribute("counter");
            counter++;
            session.setAttribute("counter", counter);
        }
        
        
        ArrayList<Student> Students = (ArrayList<Student>) session.getAttribute("studentList");
        if (Students == null) {
            Students = new ArrayList<Student>();
        }
        String firstName = request.getParameter("imie");
        String lastName = request.getParameter("nazwisko");
        String email = request.getParameter("email");
        Student student = new Student(firstName, lastName, email);
        Students.add(student);

        session.setAttribute("studentList", Students);

        request.getRequestDispatcher("students.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("counter") == null) {
            session.setAttribute("counter", 1);
        } else {
            int counter = (int) session.getAttribute("counter");
            counter++;
            session.setAttribute("counter", counter);
        }

       // if (session.getAttribute("studentList") == null) {
       //    session.setAttribute("studentList", new ArrayList<Student>());
       //}

        request.getRequestDispatcher("students.jsp").forward(request, response);
    }
}
