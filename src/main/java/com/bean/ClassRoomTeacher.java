package com.bean;

public class ClassRoomTeacher {

	private int classroomid;
	private int subid;
	private int tid;

	// default contructor
	public ClassRoomTeacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ClassRoomTeacher [classroomid=" + classroomid + ", subid=" + subid + ", tid=" + tid + "]";
	}

	public int getClassroomid() {
		return classroomid;
	}
	

	public void setClassroomid(int classroomid) {
		this.classroomid = classroomid;
	}

	public int getSubid() {
		return subid;
	}

	public void setSubid(int subid) {
		this.subid = subid;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

}
