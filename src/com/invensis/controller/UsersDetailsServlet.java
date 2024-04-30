package com.invensis.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.invensis.dao.UserDetails;
import com.invensis.model.Events;

@WebServlet("/UsersDetailsServlet")
public class UsersDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	UserDetails ded = new UserDetails();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Events> e = ded.book();
			PrintWriter pw = response.getWriter();
			String htmlResponse="<html><table border='1'><tr><th>Id</th><th>Name</th><th>LastName</th><th>Mobile</th><th>Email</th><th>Password</th></tr>";

			for(Events event:e) {
				System.out.println(event.toString());
				htmlResponse += "<tr><td>"+event.getId()+"</td><td>"+event.getName()+"</td><td>"+event.getLastName()+"</td><td>"+event.getMobile()+"</td><td>"+event.getEmail()+"</td><td>"+event.getPassword()+"</td>";

				System.out.println(htmlResponse);
			}
			htmlResponse +="</table></html>";

			pw.println(htmlResponse);


		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

