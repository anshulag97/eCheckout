package com.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bo.ProductBO;

public class ProductDAO {
	public static int addProduct(ProductBO product) throws ClassNotFoundException, SQLException, IOException
	{
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con =DriverManager.getConnection("jdbc:mysql://localhost/eCheckout", "root", "tiger");		
		 String sql = "INSERT INTO eCheckout.product VALUES(?,?,?,?,?,?,?,?,?,?)";
		 int result = 0;
		 PreparedStatement ps = con.prepareStatement(sql);
		 ps.setString(1, product.getProductId());
		 ps.setString(2, product.getProductName());
		 ps.setString(3, product.getMaterial());
		 ps.setString(4, product.getCollection());
		 ps.setDouble(5, product.getLength());
		 ps.setDouble(6, product.getWidth());
		 ps.setString(7, product.getColour());
		 ps.setString(8, product.getDescription());
		 ps.setBlob(9, product.getImage());
		 ps.setDouble(10, product.getPrice());
		 result = ps.executeUpdate();
		 return result;
	}
	public static List<ProductBO> viewAllProducts() throws ClassNotFoundException, SQLException
	{
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con =DriverManager.getConnection("jdbc:mysql://localhost/eCheckout", "root", "tiger");
		String sql = "SELECT productId, productName, material, collection, length, width, colour, description, image, price FROM eCheckout.product";
		List<ProductBO> list= new ArrayList<>(); 
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			String productId = rs.getString(1);
			String productName = rs.getString(2);
			String material = rs.getString(3);
			String collection = rs.getString(4);
			double length = rs.getDouble(5);
			double width = rs.getDouble(6);
			String colour = rs.getString(7);
			String description = rs.getString(8);
			double price = rs.getDouble(10);
			InputStream image = rs.getBinaryStream(9);
			
			ProductBO product = new ProductBO(productId, productName, material, collection, length, width, colour, description, price, image);
			list.add(product);
		}
		return list;		
	}
	public static List<ProductBO> viewAllShawls() throws ClassNotFoundException, SQLException
	{
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con =DriverManager.getConnection("jdbc:mysql://localhost/eCheckout", "root", "tiger");
		String sql = "SELECT productId, productName, material, collection, length, width, colour, description, image, price FROM eCheckout.product";
		List<ProductBO> list= new ArrayList<>(); 
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			String productId = rs.getString(1);
			if(productId.charAt(0)!='S') continue;
			String productName = rs.getString(2);
			String material = rs.getString(3);
			String collection = rs.getString(4);
			double length = rs.getDouble(5);
			double width = rs.getDouble(6);
			String colour = rs.getString(7);
			String description = rs.getString(8);
			double price = rs.getDouble(10);
			InputStream image = rs.getBinaryStream(9);
			
			ProductBO product = new ProductBO(productId, productName, material, collection, length, width, colour, description, price, image);
			list.add(product);
		}
		return list;		
	}
	public static List<ProductBO> viewAllCarpets() throws ClassNotFoundException, SQLException
	{
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con =DriverManager.getConnection("jdbc:mysql://localhost/eCheckout", "root", "tiger");
		String sql = "SELECT productId, productName, material, collection, length, width, colour, description, image, price FROM eCheckout.product";
		List<ProductBO> list= new ArrayList<>(); 
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			String productId = rs.getString(1);
			if(productId.charAt(0)!='C') {continue;}
			String productName = rs.getString(2);
			String material = rs.getString(3);
			String collection = rs.getString(4);
			double length = rs.getDouble(5);
			double width = rs.getDouble(6);
			String colour = rs.getString(7);
			String description = rs.getString(8);
			InputStream image = rs.getBinaryStream(9);
			double price = rs.getDouble(10);
			
			ProductBO product = new ProductBO(productId, productName, material, collection, length, width, colour, description, price, image);
			list.add(product);
		}
		return list;		
	}
	public static void deleteProduct(String id) throws ClassNotFoundException, SQLException {
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con =DriverManager.getConnection("jdbc:mysql://localhost/eCheckout", "root", "tiger");
		String sql = "DELETE FROM product WHERE id = (?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
	}

}