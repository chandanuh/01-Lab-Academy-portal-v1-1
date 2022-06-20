package com.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bean.Subjects;
import com.dao.SubjectsDao;


public class SubjectsService {

	SubjectsDao sd = new SubjectsDao();

	public String storeSubject(Subjects s2) {

		int id = s2.getSubid();
		String sub = s2.getSubname();

		int result;

		if (sub.length() > 30) {
			return "Subject Name Length cannot be 30 ";
		}

		if (sd.validateSubjectId(id) == 0) {
			result = sd.StoreSubjects(s2);
			if (result > 0) {
				return "Subjects Details Stored successfully";
			} else {
				return "Error while storing the teacher record";
			}

		} else if (sd.validateSubjectId(id) > 0) {
			return "Subjects ID already Present";
		} else {
			return "Subjects details not stored";
		}

	}

	public List<Subjects> getAllSubjects() {
		// extract the list from method and capture in list object
		List<Subjects> subList = sd.getSubjects();
		Iterator<Subjects> li = subList.iterator();

		while (li.hasNext()) {
			Subjects s = li.next();
		}

		return subList;
	}

}
