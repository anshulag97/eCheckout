package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bo.CustomerBO;

public class CustomerDAO {

	public static int addCustomer(CustomerBO cust) throws ClassNotFoundException, SQLException
	{
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con =DriverManager.getConnection("jdbc:mysql://localhost/eCheckout", "root", "tiger");
		
		String sql = "INSERT INTO eCheckout.customer VALUES(?,?,?,?,?,?)";
		int result = 0;
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cust.getCustId());
			ps.setString(2, cust.getCustName());
			ps.setString(3, cust.getMobile());
			ps.setString(4, cust.geteMail());
			ps.setString(5, cust.getAddress());
			ps.setString(6, cust.getPassword());
		
			result = ps.executeUpdate();
			return result;
	}

	public static List<CustomerBO> viewAllCustomers() throws ClassNotFoundException, SQLException
	{
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con =DriverManager.getConnection("jdbc:mysql://localhost/eCheckout", "root", "tiger");
		String sql = "SELECT * FROM eCheckout.customer";
		List<CustomerBO> list= new ArrayList<>(); 
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			String id = rs.getString(1);
			String name = rs.getString(2);
			String mobile = rs.getString(3);
			String eMail = rs.getString(4);
			String address = rs.getString(5);
			String password = rs.getString(6);
			CustomerBO emp = new CustomerBO(id, name, mobile, eMail, address, password);
			list.add(emp);
		}
		return list;		
	}
	
	public static boolean customerLogin(String email, String password) throws SQLException, ClassNotFoundException
	{
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con =DriverManager.getConnection("jdbc:mysql://localhost/eCheckout", "root", "tiger");
		 String sql = "SELECT password FROM eCheckout.customer where eMail = \"" + email + "\"";
		 //PreparedStatement ps = con.prepareStatement(sql);
		 //ps.setString(1, email);
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
	public static CustomerBO selectCustomer(String customerId) throws ClassNotFoundException, SQLException
	{
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con =DriverManager.getConnection("jdbc:mysql://localhost/eCheckout", "root", "tiger");
		 String sql = "SELECT custName, mobile, email, address, password FROM eCheckout.customer WHERE  custId = (?)";
		 Statement st = con.createStatement();
		 ResultSet rs = st.executeQuery(sql);
		 rs.next();
		 String id = rs.getString(1);
		 String name = rs.getString(2);
		 String mobile = rs.getString(3);
		 String eMail = rs.getString(4);
		 String address = rs.getString(5);
		 String password = rs.getString(6);
		 CustomerBO cust = new CustomerBO(id, name, mobile, eMail, address, password);
		 return cust;		
	}
}
