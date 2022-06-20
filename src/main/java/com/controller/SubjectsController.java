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

import com.bean.Subjects;
import com.service.SubjectsService;

/**
 * Servlet implementation class SubjectsController
 */
public class SubjectsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
 // common to get and post method below object
    SubjectsService ss = new SubjectsService();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
    	
    	PrintWriter pw = response.getWriter();
    	HttpSession hs = request.getSession();
		response.setContentType("text/html");
		
		//getting the all subjects from DB assinged to List object
		List<Subjects> listOfSub = ss.getAllSubjects();
		hs.setAttribute("subjs", listOfSub); //holding the value under subjs variable of List
		RequestDispatcher rd = request.getRequestDispatcher("dispalySubjects.jsp");
		rd.include(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out = response.getWriter();
		 
		 int subid  =  Integer.parseInt(request.getParameter("subid"));
		 String subname = request.getParameter("subname");
		 response.setContentType("text/html");
		 
		 //define subjects object 
		 Subjects s1 = new Subjects();
		 
		 s1.setSubid(subid);
		 s1.setSubname(subname);
		 
		 String result = ss.storeSubject(s1);
		 out.println(result); //result shown on UI thru response 
		 RequestDispatcher rd = request.getRequestDispatcher("storeSubjects.jsp");
		 rd.include(request, response);		
		 //with this extract teachers in 
		 doGet(request, response);
	}

}
