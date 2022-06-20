package com.bean;

public class AcamdemicClass {

	private int clid;
	private int classnum;

	public int getClid() {
		return clid;
	}

	public void setClid(int clid) {
		this.clid = clid;
	}

	public int getClassnum() {
		return classnum;
	}

	public void setClassnum(int classnum) {
		this.classnum = classnum;
	}

	public AcamdemicClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AcamdemicClass [clid=" + clid + ", classnum=" + classnum + "]";
	}

}
