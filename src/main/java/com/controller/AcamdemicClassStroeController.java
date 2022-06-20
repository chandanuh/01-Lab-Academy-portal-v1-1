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

import com.bean.AcamdemicClass;
import com.service.AcamdemicClassService;

/**
 * Servlet implementation class AcamdemicClassStroeController
 */
public class AcamdemicClassStroeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcamdemicClassStroeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
    AcamdemicClassService cs = new AcamdemicClassService();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	PrintWriter out= response.getWriter();
    	response.setContentType("text/html");
    	HttpSession hs = request.getSession();
    	
    	//getting the all subjects from DB assigned  to List object
    	
    	List<AcamdemicClass> li = cs.getAcamdemicDetails();
    	hs.setAttribute("acs", li);
    	RequestDispatcher rd = request.getRequestDispatcher("displayAcademicClasses.jsp");
		rd.include(request, response); 
    	
    	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		int clid =  Integer.parseInt(request.getParameter("clid")); 
		int classnum = Integer.parseInt(request.getParameter("classnum")); 
		response.setContentType("text/html");
		
		//defind object
		AcamdemicClass a = new AcamdemicClass();
		a.setClid(clid);
		a.setClassnum(classnum);
		
		String result = cs.storeAcamec(a);
		
		out.println(result);
		RequestDispatcher rd = request.getRequestDispatcher("acamdemicClassStroe.jsp");
		 rd.include(request, response);	 		
		 doGet(request, response);
	}

}
