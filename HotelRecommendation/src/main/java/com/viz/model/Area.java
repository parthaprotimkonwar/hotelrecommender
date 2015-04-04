package com.viz.model;

import java.util.List;

public class Area {

	private int id;
	private String name;
	private List<Venue> venueList;

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

	public List<Venue> getVenueList() {
		return venueList;
	}

	public void setVenueList(List<Venue> venueList) {
		this.venueList = venueList;
	}

	@Override
	public String toString() {
		return "Area [id=" + id + ", name=" + name + ", venueList=" + venueList
				+ "]";
	}

}
