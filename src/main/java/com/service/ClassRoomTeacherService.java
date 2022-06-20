package com.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bean.ClassRoomTeacher;
import com.bean.ClassTeacherSubjects;
import com.bean.Subjects;
import com.dao.ClassRoomTeacherDao;
import com.dao.SubjectsDao;
import com.dao.TeachersDao;

public class ClassRoomTeacherService {

	ClassRoomTeacherDao cr = new ClassRoomTeacherDao();
	SubjectsDao sd = new SubjectsDao();
	TeachersDao t = new TeachersDao();

	public String ClassWithTeacher(ClassRoomTeacher c) {

		int id = c.getSubid();
		int id2 = c.getTid();
		int id3 = c.getClassroomid();

		if (sd.validateSubjectId(id) > 0) {
			System.out.println("Passed firt validataion -1");
			if (t.validateEmp(id2) != 0) {
				System.out.println("Passed second validataion - 2");

				// class number validations
				System.out.println("class room id is " + id3);
				if (cr.validateClassNum(id3) == 0) {
					System.out.println("Passed Third  validataion - 3");
					return "Class is not configured in the Classes Object";

				}

				System.out.println("message after return");

				// in a given class subject assigned or not
				if (cr.validatPerClasPerSubj(c) != 9999) {

					// for given class teacher assigned or not
					if (cr.validatPerClasPerTeacher(c) == 0)

					{
						int r = cr.StroreClassTeachers(c);
						// System.out.println("Result of insert with seq " + r);
						return "Class with teacher details configured successfully";
					} else {
						return ("Teacher already assigned to this class");
					} // end of validatPerClasPerTeach

				} else {
					return ("For This class Subject ID already assinged");
				} // end if validateClassNum

			} else {
				return "Teacher ID should be part of Teacher config";
			} // end of teacher id validation

		} else {
			return "Subject ID should be part of Subject config";
		} // end of Subject id validaion

	}

	public List<ClassRoomTeacher> getClassTeachers() {
		List<ClassRoomTeacher> ClassList = cr.getClassRooms();
		Iterator<ClassRoomTeacher> li = ClassList.iterator();

		while (li.hasNext()) {
			ClassRoomTeacher s = li.next();
		}

		return ClassList;
	}

	public List<ClassTeacherSubjects> getSubjectTeacherClass() {
		List<ClassTeacherSubjects> tlist = cr.getAllClassTeacherSubj();
		Iterator<ClassTeacherSubjects> li = tlist.iterator();

		while (li.hasNext()) {
			ClassTeacherSubjects s = li.next();
		}
		return tlist;
	}

}
