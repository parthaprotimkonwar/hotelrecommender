package com.viz.model;

import java.util.List;

public class Section {

	private int id;
	private String name;
	private List<Area> areaList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Area> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<Area> areaList) {
		this.areaList = areaList;
	}

	@Override
	public String toString() {
		return "Section [id=" + id + ", name=" + name + ", areaList="
				+ areaList + "]";
	}

}
