package com.bean;

public class ClassTeacherSubjects {

	private int classroomid;
	private String tname;
	private String subname;

	public int getClassroomid() {
		return classroomid;
	}

	public void setClassroomid(int classroomid) {
		this.classroomid = classroomid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	@Override
	public String toString() {
		return "ClassTeacherSubjects [classroomid=" + classroomid + ", tname=" + tname + ", subname=" + subname + "]";
	}

	public ClassTeacherSubjects() {
		super();
		// TODO Auto-generated constructor stub
	}

}
