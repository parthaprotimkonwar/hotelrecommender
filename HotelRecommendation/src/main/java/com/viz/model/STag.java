package com.viz.model;

import java.util.List;

public class STag {

	private int id;
	private String name;
	private PTag primaryTag;
	private List<STag> relatives;

	public STag() {

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

	public PTag getPrimaryTag() {
		return primaryTag;
	}

	public void setPrimaryTag(PTag primaryTag) {
		this.primaryTag = primaryTag;
	}

	@Override
	public String toString() {
		return "STag [id=" + id + ", name=" + name + ", primaryTag="
				+ primaryTag + ", relatives=" + relatives + "]";
	}

}
