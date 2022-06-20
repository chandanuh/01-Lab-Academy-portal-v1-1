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

import com.bean.ClassRoomTeacher;
import com.bean.ClassTeacherSubjects;
import com.service.ClassRoomTeacherService;

/**
 * Servlet implementation class ClassRoomTeacherController
 */
public class ClassRoomTeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassRoomTeacherController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    //define service class object
    ClassRoomTeacherService ct = new ClassRoomTeacherService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter pw = response.getWriter();
    	HttpSession hs = request.getSession();
		response.setContentType("text/html");
		
		
		List<ClassRoomTeacher> ll= ct.getClassTeachers();
		hs.setAttribute("rooms", ll);
		RequestDispatcher rd = request.getRequestDispatcher("dispalyClassRoomTeacher.jsp");
		
		/*
		List<ClassRoomTeacher> l= ct.getClassTeachers();
		hs.setAttribute("rooms2", l);			
		RequestDispatcher rd1 = request.getRequestDispatcher("dispalyClassRoomTeacher2.jsp");
		*/
		rd.include(request, response);	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		int classroomid =  Integer.parseInt( request.getParameter("classroomid"));
		int subid = Integer.parseInt( request.getParameter("subid"));
		int tid = Integer.parseInt( request.getParameter("tid"));
		response.setContentType("text/html");
		
		//define object 
		ClassRoomTeacher cr = new  ClassRoomTeacher();
		
		cr.setClassroomid(classroomid);
		cr.setSubid(subid);
		cr.setTid(tid);
		
		String result = ct.ClassWithTeacher(cr);
		out.println(result); ////result shown on UI thru response 
		RequestDispatcher rd = request.getRequestDispatcher("StoreClassRoomTeacher.jsp");
		rd.include(request, response); 
		doGet(request, response);
	}

}
