package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDAO {
	public static boolean adminLogin(String email, String password) throws SQLException, ClassNotFoundException
	{
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con =DriverManager.getConnection("jdbc:mysql://localhost/eCheckout", "root", "tiger");
		 String sql = "SELECT password FROM eCheckout.admin where eMail = \"" + email + "\"";
		 Statement ps = con.createStatement();
		 ResultSet rs = ps.executeQuery(sql);
		 if(rs.next())
		 {
			 String pass = rs.getString(1);
		 if(pass.equals(password))
			 return true;
		 else return false;
		 }
		 else return false;
	}

}
