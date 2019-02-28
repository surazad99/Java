package com.suraj;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sql = "insert into login (username, password)" + "values(?, ?)";
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "";
		String uname = request.getParameter("username");
		String pass = request.getParameter("password");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2, pass);
			boolean es = st.execute();
			if(!es)
			{
				HttpSession session = request.getSession();
				session.setAttribute("message", "account created now you can login");
				
				response.sendRedirect("login.jsp");
			}
			
		} catch(Exception e)
		{
			System.out.println("error in creating account");
		}
	}

}
