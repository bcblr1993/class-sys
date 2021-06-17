package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

public class Clazz implements Serializable{
	private String id;
	private String name;
	private String path;

	private Tag tag;//标签关系属性

	private List<Group> groups;//小组关系属性
	
	public List<Group> getGroups() {
		return groups;
	}
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	public Tag getTag() {
		return tag;
	}
	public void setTag(Tag tag) {
		this.tag = tag;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Clazz(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Clazz() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Clazz [id=" + id + ", name=" + name + "]";
	}
	
}
