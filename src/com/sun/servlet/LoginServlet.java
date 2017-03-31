package com.sun.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.controller.ProductController;
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = -1428426644907957580L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.debug("[loginCheck]------ Start ");
		System.out.println("[loginCheck]------ Start ");
		
		//編碼部分應該用Filter統一處理
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
//		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
//		String account=request.getParameter("account");
		String password=request.getParameter("password");
		
        //直接當作通過
        HttpSession session = request.getSession();
		session.setAttribute("account", request.getParameter("account"));
		session.setAttribute("userName","db output name");
		
		//範例的判斷以後再說
		if("123".equals(password)){
			out.print("Welcome, "+ session.getAttribute("userName") );
			request.getRequestDispatcher("\\pages\\productInfo.jsp").forward(request,response);
		}
		else{
			out.print("Sorry, username or password error!");
			response.sendRedirect("\\pages\\error\\errorSimple.jsp");
//			request.getRequestDispatcher("index.jsp").include(request, response);
		}
		out.close();
	}

}
