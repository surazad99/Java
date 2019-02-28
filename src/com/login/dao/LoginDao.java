package com.login.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class LoginDao {
	
	String sql = "select * from login where username=? and password=?";
	String url = "jdbc:mysql://localhost:3306/test";
	String username = "root";
	String password = "";
	
	public boolean check(String uname, String pass)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection(url, username, password);
			PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2, pass);
			ResultSet rs = st.executeQuery();
			if(rs.next())
				return true;
			
			
		} catch(Exception e)
		{
			System.out.println("error occured");
		}
		
		
		return false;
	}
			
}
