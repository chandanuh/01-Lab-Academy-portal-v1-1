package com.service;

import java.util.Iterator;
import java.util.List;

import com.bean.StudentDets;
import com.bean.Subjects;
import com.dao.AcamdemicClassDao;
import com.dao.StudentDetsDao;

public class StudentDetsService {

	StudentDetsDao sd = new StudentDetsDao();
	AcamdemicClassDao ad = new AcamdemicClassDao();

	public String StoreStudent(StudentDets s) {

		String tmp = s.getStdname();
		int tmp_length = tmp.length();
		int clid = s.getClid();

		System.out.println("First place--- ");

		if (tmp_length > 30) {
			return "Student Name can not be 30 lenght characters";
		}
		System.out.println("Secod place--- ");

		System.out.println("Class id  " + clid);
		
		
		if (ad.validateClassNum(clid) == 0)
		{
			return "Class number must be part of the classes object";
		}

		/*
		if (clid != 10 || clid != 20 || clid != 30) {
			return "Classes Should 10 or 20  or 30";
		}*/

		System.out.println("Third place--- ");
		
		
		

		// this will store the records into DB table
		int result = sd.storStudent(s);

		if (result > 0) {
			return "Student informtaion stored succesfull ";
		} else {
			return "Error while persistingt Students in DB";
		}

	}

	public List<StudentDets> getStudents() {

		List<StudentDets> listOfStd = sd.getStudents();
		Iterator<StudentDets> li = listOfStd.iterator();

		while (li.hasNext()) {
			StudentDets s = li.next();
		}

		return listOfStd;
	}

}
