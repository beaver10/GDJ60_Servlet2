package com.iu.home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello hayoung");
		
		Soldier soldier = new Soldier();
		Gun gun = new Gun();
		Bullet bullet = new Bullet();
		
		gun.setBullet(bullet);
		soldier.setGun(gun);
		
		soldier.useGun();
		
//		String method =request.getMethod();
//		StringBuffer sb = request.getRequestURL();
//		String uri = request.getRequestURI();
//		Cookie [] cookies =request.getCookies();
//		String context =request.getContextPath();
//		String name = request.getParameter("name");
//		String age = request.getParameter("age");
//		int a = Integer.parseInt(age);			
//		String [] moneys = request.getParameterValues("money");
//		
//		System.out.println("Method : "+ method);
//		System.out.println("Request URL :"+sb);
//		System.out.println("URI :" + uri);
//		for(Cookie cookie : cookies) {
//			System.out.println("cookie name :"+cookie.getName());
//			System.out.println("cookie value : " +cookie.getValue());
//		}
//		System.out.println("ContextPath : " + context);
//		System.out.println("Parameter name :" +name);
//		System.out.println("Parameter age :"+a*2);
//		for(String m : moneys) {
//			System.out.println(m);
//		}
		
//		PrintWriter out = response.getWriter();
//		out.println("<h1>hayoung page</h1>");
//		out.println("<h2>header2</h2>");
//		
//		out.close();
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/home.jsp");
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
