package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bo.OrderBO;

public class OrderDAO {
	
	public static int addOrder(OrderBO order) throws ClassNotFoundException, SQLException
	{
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con =DriverManager.getConnection("jdbc:mysql://localhost/eCheckout", "root", "tiger");
		
		String sql = "INSERT INTO orders VALUES(?,?,?,?,?,?,?)";
		int result = 0;
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, order.getOrderNo());
			ps.setString(2, order.getCustomerId());
			ps.setString(3, order.getProductId());
			ps.setInt(4, order.getQuantity());
			ps.setDate(5, order.getDate());
			ps.setInt(6, order.getOrderStatus());
			ps.setDouble(7, order.getPrice());
		
			result = ps.executeUpdate();
			return result;
	}
	
	
	public static List<OrderBO> viewAllOrders() throws ClassNotFoundException, SQLException
	{
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con =DriverManager.getConnection("jdbc:mysql://localhost/eCheckout", "root", "tiger");
		String sql = "SELECT * FROM eCheckout.orders";
		List<OrderBO> list= new ArrayList<>(); 
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			String orderNo = rs.getString(1);
			String customerId = rs.getString(2);
			String productId = rs.getString(3);
			int quantity = rs.getInt(4);
			Date date = rs.getDate(5);
			int orderStatus = rs.getInt(6);
			Double price = rs.getDouble(7);
			OrderBO order = new OrderBO(orderNo, customerId, productId, quantity, date, orderStatus, price);
			list.add(order);
		}
		return list;		
	}
	public static void deleteOrder(String id) throws ClassNotFoundException, SQLException {
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con =DriverManager.getConnection("jdbc:mysql://localhost/eCheckout", "root", "tiger");
		String sql = "DELETE FROM eCheckout.orders WHERE orderNo = (?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
	}

}
