package com.invensis.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.invensis.dao.LoginCheck;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("Name");
        String password = request.getParameter("pword");
        HttpSession session = request.getSession();
        session.setAttribute("username", username);

        LoginCheck loginCheck = new LoginCheck();
        String role = loginCheck.getRole(username, password);

        if (role != null) {
            if (role.equals("Admin")) {
                response.sendRedirect("AdminPage.html");
            } else if (role.equals("User")) {
                response.sendRedirect("UserPage.html");
            }
        } else {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Invalid username or password');");
            out.println("location='Login.html';");
            out.println("</script>");
        }
    }
}
