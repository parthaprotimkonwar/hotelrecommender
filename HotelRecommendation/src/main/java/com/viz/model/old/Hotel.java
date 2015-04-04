package com.viz.model.old;

import java.util.*;

public class Hotel {

	private long id;
	private String name;
	private Set<Integer> aplicableTags;
	private Location loc;

	public Hotel(String name, long id) {
		aplicableTags = new HashSet<Integer>();
		this.name = name;
		this.id = id;
	}

	public void setLocation(Location l) {
		loc = new Location(l.getLongitude(), l.getLattitude(), l.getName());
	}

	public void addDish(Integer x) {
		aplicableTags.add(x);
	}

	public Set<Integer> getTags() {
		return this.aplicableTags;
	}

	public Location getLocation() {
		return this.loc;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", aplicableTags="
				+ aplicableTags + ", loc=" + loc + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Hotel other = (Hotel) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
