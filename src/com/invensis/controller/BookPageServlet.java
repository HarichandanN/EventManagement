package com.invensis.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.invensis.dao.BookPage;

@WebServlet("/BookPageServlet")
public class BookPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    BookPage bp = new BookPage();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Id = request.getParameter("id");
		String Name = request.getParameter("name");
		String Price = request.getParameter("price");
		String UserName = request.getParameter("username");
		String Mobile = request.getParameter("mobile");
		String Date = request.getParameter("date");
		String result = "";
		try {
			result= bp.Add(Id, Name, Price, UserName, Mobile, Date);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//response.getWriter().write(result);
		
		PrintWriter pw = response.getWriter();
		if(result.equalsIgnoreCase("Success")) {
			response.sendRedirect("BookPage.html");
		}
	}

}
