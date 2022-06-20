package com.bean;

public class StudentDets {

	private int stdid;
	private String stdname;
	private int clid;

	public int getStdid() {
		return stdid;
	}

	public void setStdid(int stdid) {
		this.stdid = stdid;
	}

	public String getStdname() {
		return stdname;
	}

	public void setStdname(String stdname) {
		this.stdname = stdname;
	}

	public int getClid() {
		return clid;
	}

	public void setClid(int clid) {
		this.clid = clid;
	}

	public StudentDets() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "StudentDets [stdid=" + stdid + ", stdname=" + stdname + ", clid=" + clid + "]";
	}

}
