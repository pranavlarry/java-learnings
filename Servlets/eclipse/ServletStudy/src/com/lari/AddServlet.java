package com.lari;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddServlet extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res) {
		
		
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		int k = i+j;
		
		HttpSession session = req.getSession();
		
		session.setAttribute("k", 5);
		
		Cookie cookie = new Cookie("k",5+"");
		res.addCookie(cookie);
		
		//using redirect
		try {
			res.sendRedirect("square");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//using RequestDispatcher
//		RequestDispatcher rd = req.getRequestDispatcher("square");
//		try {
//			rd.forward(req, res);
//		} catch (ServletException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

	}

}
