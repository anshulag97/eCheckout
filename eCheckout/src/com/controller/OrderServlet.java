package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.OrderBO;
import com.dao.OrderDAO;
import com.google.gson.Gson;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
    	
    	InputStreamReader reader = new InputStreamReader(request.getInputStream());
		BufferedReader br = new BufferedReader(reader);
		String jsonString = br.readLine();
		
		String[] str = jsonString.split("&");

		
		String orderNo = str[0].substring(str[0].indexOf("=")+1);
		String customerId = str[1].substring(str[1].indexOf("=")+1);
		String productId = str[2].substring(str[2].indexOf("=")+1);
		int quantity = Integer.parseInt(str[3].substring(str[3].indexOf("=")+1));
		long millis=System.currentTimeMillis();  
	    Date date=new java.sql.Date(millis);  
		int orderStatus =1;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/eCheckout", "root", "tiger");
			String sql = "SELECT price FROM eCheckout.product WHERE productId = \"" + productId + "\"";
			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			rs.next();
			Double price = rs.getDouble(1)*quantity;
			OrderBO order = new OrderBO(orderNo, customerId, productId, quantity, date, orderStatus, price);
			int i = OrderDAO.addOrder(order);
			if(i>0) {
				System.out.println("added");
				response.getWriter().write(order.getOrderNo());
			}else {
				response.getWriter().write("-1");
			}
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
   	
   	response.setContentType("application/json");
   	PrintWriter out = response.getWriter();    	
		Gson gson = new Gson();
   	
   		    	try {
   		    		List<OrderBO> list = OrderDAO.viewAllOrders();
   			    	for(OrderBO order :list)
   			    	{
   			    	   String jsonStr = gson.toJson(order);
   			           out.println(jsonStr);
   			       }
   		    	} catch (ClassNotFoundException e) {
   					// TODO Auto-generated catch block
   					e.printStackTrace();
   				} catch (SQLException e) {
   					// TODO Auto-generated catch block
   					e.printStackTrace();
   				}
    }	

    
}
