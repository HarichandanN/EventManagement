package com.invensis.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String mobile = null;
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<title>Event Cards</title>");
        out.println("<style>");
        out.println("body {");
        out.println("  background-image: url('https://www.visionvivaah.com/blog/wp-content/uploads/2019/11/Top-10-Event-Management-Companies-In-India.jpg');");
        out.println("  background-size: cover;");
        out.println("  display: flex;");
        out.println("  justify-content: center;");
        out.println("  align-items: center;");
        out.println("  height: 100vh;");
        out.println("  margin: 0;");
        out.println("}");
        out.println(".card-container {");
        out.println("  display: flex;");
        out.println("  flex-wrap: wrap;");
        out.println("  justify-content: center;");
        out.println("  gap: 20px;");
        out.println("}");
        out.println(".card {");
        out.println("  width: 300px;");
        out.println("  padding: 20px;");
        out.println("  border: 1px solid #ccc;");
        out.println("  border-radius: 8px;");
        out.println("  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);");
        out.println("  background-color: rgba(255, 255, 255, 0.8);");
        out.println("  transition: all 0.3s ease;");
        out.println("}");
        out.println(".card h3 {");
        out.println("  margin-top: 0;");
        out.println("  font-size: 20px;");
        out.println("  color: #333;");
        out.println("}");
        out.println(".card p {");
        out.println("  font-size: 16px;");
        out.println("  color: #666;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hari", "root", "Hari");

            PreparedStatement stmt2 = con.prepareStatement("SELECT Mobile FROM eventregister where Name=?");
            stmt2.setString(1, username);
            ResultSet rs2 = stmt2.executeQuery();

            while (rs2.next()) {
                mobile = rs2.getString("Mobile"); 
                System.out.println(mobile);
            }
            
            
            PreparedStatement stmt1 = con.prepareStatement("SELECT * FROM event");
            ResultSet rs = stmt1.executeQuery();
            
            out.println("<div class=\"card-container\">");

            while (rs.next()) {
                int id = rs.getInt("Id");
                String name = rs.getString("EventName");
                String price = rs.getString("EventPrice");
                
                
                out.println("<div class=\"card\">");
                out.println("<h3>ID: " + id + "</h3>");
                out.println("<p>Name: " + name + "</p>");
                out.println("<p>Price: " + price + "</p>");
                out.println("<a href='BookPage.html?id=" + id + "&name=" + name + "&price=" + price + "&username=" + username + "&mobile=" + mobile+  "'>Book</a>");
                out.println("</div>");
            }

            out.println("</div>");
            con.close();
        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }

        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}
