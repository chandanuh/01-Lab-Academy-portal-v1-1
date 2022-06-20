package com.bean;

public class Teachers {

	private int tid;
	private String tname;

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Teachers(int tid, String tname) {
		super();
		this.tid = tid;
		this.tname = tname;
	}

	public Teachers() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Teachers [tid=" + tid + ", tname=" + tname + "]";
	}

}
