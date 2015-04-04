package com.viz.model;

import java.util.HashSet;
import java.util.Set;

public class Venue {

	private int id;
	private String name;
	private String address;
	private Location location;
	private Section section;
	private Area area;
	private Set<STag> aplicableTags = new HashSet<STag>();

	private double rating;
	private String url;
	private String iUrl;

	public Venue() {
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Set<STag> getAplicableTags() {
		return aplicableTags;
	}

	public void setAplicableTags(Set<STag> aplicableTags) {
		this.aplicableTags = aplicableTags;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getiUrl() {
		return iUrl;
	}

	public void setiUrl(String iUrl) {
		this.iUrl = iUrl;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Venue [id=" + id + ", name=" + name + ", address=" + address
				+ ", location=" + location + ", section=" + section + ", area="
				+ area + ", aplicableTags=" + aplicableTags + ", rating="
				+ rating + ", url=" + url + ", iUrl=" + iUrl + "]";
	}

	/*-public void setLocation(Location l) {
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
	 */
}
