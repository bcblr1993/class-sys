package com.baizhi.entity;

import java.util.Date;

public class User {
	private String id;
	private String username;
	private String password;
	private String photopath;
	private Date createDate;
	private String role;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhotopath() {
		return photopath;
	}
	public void setPhotopath(String photopath) {
		this.photopath = photopath;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String id, String username, String password, String photopath,
			Date createDate, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.photopath = photopath;
		this.createDate = createDate;
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", photopath=" + photopath + ", createDate="
				+ createDate + ", role=" + role + "]";
	}
	
	
}
