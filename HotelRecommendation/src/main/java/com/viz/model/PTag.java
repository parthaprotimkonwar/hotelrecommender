package com.viz.model;

import java.util.List;

public class PTag {

	private int id;
	private String name;
	private List<STag> relatives;

	public PTag() {

	}

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

	public List<STag> getRelatives() {
		return relatives;
	}

	public void setRelatives(List<STag> relatives) {
		this.relatives = relatives;
	}

}
