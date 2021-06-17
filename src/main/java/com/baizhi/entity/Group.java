package com.baizhi.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Group implements Serializable {
	private String id;
	private String name;
	private Date createDate;
	
	private Clazz clazz;//班级关系属性

	private Integer  stuCounts;//学生数量

	private List<String> tagNames = new ArrayList<String>();//处理业务逻辑的属性


	public Integer getStuCounts() {
		return stuCounts;
	}

	public void setStuCounts(Integer stuCounts) {
		this.stuCounts = stuCounts;
	}

	public List<String> getTagNames() {
		return tagNames;
	}
	public void setTagNames(List<String> tagNames) {
		this.tagNames = tagNames;
	}
	public Clazz getClazz() {
		return clazz;
	}
	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Group(String id, String name, Date createDate) {
		super();
		this.id = id;
		this.name = name;
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", createDate="
				+ createDate + "]";
	}
	
}
