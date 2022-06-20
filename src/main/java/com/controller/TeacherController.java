package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Teachers;
import com.service.TeachersService;

/**
 * Servlet implementation class TeacherController
 */
public class TeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	// common to get and post method below object
	TeachersService ts = new TeachersService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		HttpSession hs = request.getSession();
		response.setContentType("text/html");

		List<Teachers> listOfTeachers = ts.getTeachers();
		hs.setAttribute("teachers", listOfTeachers);
		RequestDispatcher rd1 = request.getRequestDispatcher("dispalyTeachers.jsp");
		rd1.include(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		int tid = Integer.parseInt(request.getParameter("tid"));
		String tname = request.getParameter("tname");

		response.setContentType("text/html");
		HttpSession hs = request.getSession();

		// define teachers object
		Teachers teacher = new Teachers();

		teacher.setTid(tid);
		teacher.setTname(tname);

		String result = ts.StoreTeacher(teacher);
		out.println(result);
		RequestDispatcher rd1 = request.getRequestDispatcher("storeTeachers.jsp");
		rd1.include(request, response);
		 doGet(request, response);
	}

}
