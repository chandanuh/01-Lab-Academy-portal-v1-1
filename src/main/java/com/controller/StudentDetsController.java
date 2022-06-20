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

import com.bean.StudentDets;
import com.service.StudentDetsService;

/**
 * Servlet implementation class StudentDetsController
 */
public class StudentDetsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDetsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
    StudentDetsService ss = new StudentDetsService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		List<StudentDets> listOfStd = ss.getStudents();
		HttpSession hs = request.getSession();
		hs.setAttribute("stds", listOfStd); //holding the value under subjs variable of List
		RequestDispatcher rd = request.getRequestDispatcher("dispalyStudents.jsp");
		rd.include(request, response);
		
    	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		//define students object and setting the values 
		StudentDets  s= new StudentDets();
		int stdid = Integer.parseInt(request.getParameter("stdid"));
		String stdname = request.getParameter("stdname");
		int clid = Integer.parseInt(request.getParameter("clid"));
		
		s.setStdid(stdid);
		s.setStdname(stdname);
		s.setClid(clid);
		
		
		
		String result = ss.StoreStudent(s);
		out.println(result); 
		
		RequestDispatcher rd = request.getRequestDispatcher("storeStudents.jsp");
		
		
		//s.setStdid(0); storeStudents.jsp
		
		
		doGet(request, response);
	}

}
