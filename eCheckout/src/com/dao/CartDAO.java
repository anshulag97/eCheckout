package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bo.CartBO;

public class CartDAO {
	public static int addToCart(CartBO cart) throws ClassNotFoundException, SQLException
	{
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con =DriverManager.getConnection("jdbc:mysql://localhost/eCheckout", "root", "tiger");
		
		String sql = "INSERT INTO cart VALUES(?,?,?,?)";
		int result = 0;
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cart.getCustomerId());
			ps.setString(2, cart.getProductId());
			ps.setInt(3, cart.getQuantity());
			ps.setDouble(4, cart.getPrice());
		
			result = ps.executeUpdate();
			return result;
	}
	public static List<CartBO> viewCart(String custId) throws ClassNotFoundException, SQLException
	{
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con =DriverManager.getConnection("jdbc:mysql://localhost/eCheckout", "root", "tiger");
		String sql = "SELECT * FROM eCheckout.cart";
		List<CartBO> list= new ArrayList<>(); 
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			String customerId = rs.getString(1);
			String productId = rs.getString(2);
			int quantity = rs.getInt(3);
			Double price = rs.getDouble(4);
			if(!customerId.equals(custId)) continue;
			CartBO order = new CartBO(customerId, productId, quantity,price);
			list.add(order);
		}
		return list;		
	}
	public static void deleteFromCart(String prodId) throws ClassNotFoundException, SQLException {
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con =DriverManager.getConnection("jdbc:mysql://localhost/eCheckout", "root", "tiger");
		String sql = "DELETE FROM eCheckout.cart WHERE productId = (?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, prodId);
			ps.executeUpdate();
	}
}
