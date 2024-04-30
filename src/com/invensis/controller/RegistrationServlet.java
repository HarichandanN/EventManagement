package com.invensis.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.invensis.dao.Register;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Register rg = new Register();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String Name = request.getParameter("Name");
		String SurName = request.getParameter("SName");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		String result = "";

		try {
			result = rg.Add(Name, SurName, mobile, email, password, role); 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//response.getWriter().write(result);
		PrintWriter out = response.getWriter();
		if(result.equalsIgnoreCase("Success")) {
			out.println("Your New Record Will be added Successfully");
			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			rd.forward(request,response);
		}
		else {
			out.println("your entering invalid details!");
			RequestDispatcher rd=request.getRequestDispatcher("Registration.html");
			rd.forward(request, response);
		}
	}


}
