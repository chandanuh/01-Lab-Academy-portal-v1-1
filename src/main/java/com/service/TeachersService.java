package com.service;

import java.util.Iterator;
import java.util.List;

import com.bean.Teachers;
import com.dao.TeachersDao;

public class TeachersService {

	TeachersDao td = new TeachersDao();

	public String StoreTeacher(Teachers t) {

		int id = t.getTid();

		if (td.validateEmp(id) > 0) {
			return "Teacher ID Already present";
		} else if (td.StroreTeahers(t) == 0) {
			return "Teahers details stored";
		} else {
			return "Teachers details stored successfully";
		}

	}

	public List<Teachers> getTeachers() {
		List<Teachers> listOfTeachers = td.getTeacgers();
		Iterator<Teachers> li = listOfTeachers.iterator();

		while (li.hasNext()) {
			Teachers t = li.next();
		}
		return listOfTeachers;

	}
}
