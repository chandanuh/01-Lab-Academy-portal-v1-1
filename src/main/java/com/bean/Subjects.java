package com.bean;

public class Subjects {

	private int subid;
	private String subname;

	public int getSubid() {
		return subid;
	}

	public void setSubid(int subid) {
		this.subid = subid;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	public Subjects() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Subjects [subid=" + subid + ", subname=" + subname + "]";
	}

}
