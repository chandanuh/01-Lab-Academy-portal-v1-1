package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Login;
import com.service.LoginService;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession hs = request.getSession();

		// initialize the login class object
		Login ll = new Login();

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String typeOfUser = request.getParameter("typeOfUser");

		// read input from the above and pass to the class varaibale to hold these
		// values
		ll.setEmail(email);
		ll.setPassword(password);
		ll.setTypeOfUser(typeOfUser);

		// impliment biz logic to progress the pages

		LoginService ls = new LoginService();

		RequestDispatcher rd1 = request.getRequestDispatcher("adminHome.jsp"); //
		RequestDispatcher rd2 = request.getRequestDispatcher("index.jsp");

		// call the method and capture output
		String result = ls.validateAdmin(ll);

		if (result.equals("Valid_Admin")) {

			hs.setAttribute("user", ll.getEmail());
			// out.println("User validated ");

			// need to implement logic for adminHome JSP page
			rd1.forward(request, response);

		} else if (result.equals("Invalid_Admin")) {
			out.println("<color=red/>Invalid Credentials and please try Again ");
			 rd2.include(request, response);
		} else {
			out.println("Not Admin Role of the user ");
			 rd2.include(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
