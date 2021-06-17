package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

public class Tag implements Serializable{
	private String id;
	private String name;
	private String type;
	private Date createDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Tag() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tag(String id, String name, String type, Date createDate) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "Tag [id=" + id + ", name=" + name + ", type=" + type + "]";
	}
	
	
}
