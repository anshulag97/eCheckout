package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.CartBO;
import com.dao.CartDAO;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
    	
    	InputStreamReader reader = new InputStreamReader(request.getInputStream());
		BufferedReader br = new BufferedReader(reader);
		String jsonString = br.readLine();
		
		String[] str = jsonString.split("&");

		
		String customerId = str[0].substring(str[0].indexOf("=")+1);
		String productId = str[1].substring(str[1].indexOf("=")+1);
		int quantity = Integer.parseInt(str[2].substring(str[2].indexOf("=")+1));

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/eCheckout", "root", "tiger");
			String sql = "SELECT price FROM eCheckout.product WHERE productId = \"" + productId + "\"";
			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			rs.next();
			Double price = rs.getDouble(1)*quantity;
			CartBO cart = new CartBO(customerId, productId, quantity, price);
			int i = CartDAO.addToCart(cart);
			if(i>0) {
				System.out.println("added");
				response.getWriter().write("added response");
			}else {
				response.getWriter().write("-1");
			}
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }

}
