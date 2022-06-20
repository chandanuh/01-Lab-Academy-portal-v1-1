package com.main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bean.ClassRoomTeacher;
import com.bean.ClassTeacherSubjects;
import com.bean.StudentDets;
import com.bean.Teachers;
import com.dao.ClassRoomTeacherDao;
import com.dao.StudentDetsDao;
import com.dao.TeachersDao;
import com.resource.DbResource;

public class DemoDBTest {

	public static void main(String[] args) {

		DbResource d = new DbResource();

		Connection con = DbResource.getDbConnection();

		System.out.println("DB connected");

		TeachersDao td = new TeachersDao();

		Teachers t1 = new Teachers();

		t1.setTid(45);
		t1.setTname("Anoop");

		int result = td.StroreTeahers(t1);
		System.out.println("Result is " + result);

		List<Teachers> listOfTeacheers = new ArrayList();
		// Iterator<Teachers> li = listOfTeacheers.iterator();

		listOfTeacheers = td.getTeacgers();
		System.out.println("teachers list " + listOfTeacheers);

		int tmp = td.validateEmp(45);
		System.out.println("validatation of the employee ID " + tmp);

		ClassRoomTeacherDao cr = new ClassRoomTeacherDao();
		ClassRoomTeacher c = new ClassRoomTeacher();

		c.setClassroomid(10); // class room id
		c.setSubid(2); //
		c.setTid(3);
		
		
		List<ClassRoomTeacher> listOfRooms = new ArrayList(); 
		listOfRooms = cr.getClassRooms();
		System.out.println("class with Subject list " + listOfRooms);
		
		
		List<ClassTeacherSubjects> listOfTes= new ArrayList();		
		listOfTes = cr.getAllClassTeacherSubj();
		
		System.out.println("list of details are " + listOfTes);
		
		StudentDetsDao sr = new StudentDetsDao();
		List<StudentDets> listStd = new ArrayList();
		
		listStd = sr.getStudents(); 
		System.out.println("List of students " + listStd );
		
		// class number validations
		if (cr.validateClassNum(10) != 0) {

			// in a given class subject assigned or not
			if (cr.validatPerClasPerSubj(c) != 9999) {

				// for given class teacher assigned or not
				if (cr.validatPerClasPerTeacher(c) == 0)

				{
					int r = cr.StroreClassTeachers(c);
					System.out.println("Result of insert with seq " + r);
				} else {
					System.out.println("Teacher already assigned to this class");
				} // end of validatPerClasPerTeach

			} else {
				System.out.println("For given class Subject id alredy associated ");
			} // end of validatPerClasPerSubj

		} else {
			System.out.println("Accpeted Claass Should be 10 OR 11 OR 12");
		} // end if validateClassNum

	}

}
