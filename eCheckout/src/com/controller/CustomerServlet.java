package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bo.CustomerBO;
import com.dao.CustomerDAO;
import com.google.gson.Gson;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 2L;
       
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
    
	    InputStreamReader reader = new InputStreamReader(request.getInputStream());
		BufferedReader br = new BufferedReader(reader);
		String jsonString = br.readLine();
		String[] str = jsonString.split("&");
		String id = str[0].substring(str[0].indexOf("=")+1);		//
		String name = str[1].substring(str[1].indexOf("=")+1);		//	
		String mobile = str[2].substring(str[2].indexOf("=")+1);	//
		String eMail = str[3].substring(str[3].indexOf("=")+1);		//					for creating object of CustomerBO
		String address = str[4].substring(str[4].indexOf("=")+1);	//					gson.fromGson not working
		String password = str[5].substring(str[5].indexOf("=")+1);	//
		CustomerBO customer = new CustomerBO(id, name, mobile, eMail, address, password);

		try {
			int i = CustomerDAO.addCustomer(customer);
			if(i>0) {
				System.out.println("added");
				response.getWriter().write(customer.getCustId());
			}else {
				response.getWriter().write("-1");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
   	String command = request.getParameter("command");
   	System.out.println(command);
   	
   	response.setContentType("application/json");
   	PrintWriter out = response.getWriter();    	
		Gson gson = new Gson();
   	
   		    	try {
   		    		List<CustomerBO> list = CustomerDAO.viewAllCustomers();
   			    	for(CustomerBO customer :list)
   			    	{
   			    	   String jsonStr = gson.toJson(customer);
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