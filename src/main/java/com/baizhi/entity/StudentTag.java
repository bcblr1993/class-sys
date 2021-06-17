package com.baizhi.entity;

import java.io.Serializable;

public class StudentTag implements Serializable{
	private String sid;
	private String tid;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public StudentTag(String sid, String tid) {
		super();
		this.sid = sid;
		this.tid = tid;
	}
	public StudentTag() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "StudentTag [sid=" + sid + ", tid=" + tid + "]";
	}
	
}
