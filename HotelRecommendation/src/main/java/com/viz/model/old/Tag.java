package com.viz.model.old;

import java.util.List;

public class Tag {

	private String id;
	private String name;
	private List<Tag> relatives;

	public Tag(String id, String name) {
		this.id = id;
		this.name = name;
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

	public List<Tag> getRelatives() {
		return relatives;
	}

	public void setRelatives(List<Tag> relatives) {
		this.relatives = relatives;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", name=" + name + ", relatives=" + relatives
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((relatives == null) ? 0 : relatives.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Tag other = (Tag) obj;
		/*-if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;*/

		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;

		return true;
	}

}
