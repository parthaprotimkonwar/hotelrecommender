package com.viz.model.old;

public class Location {

	private double longitude;
	private double lattitude;
	private String name;

	public Location(double l1, double l2, String s) {
		longitude = l1;
		lattitude = l2;
		name = s;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public double getLattitude() {
		return this.lattitude;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "Location [longitude=" + longitude + ", lattitude=" + lattitude
				+ ", name=" + name + "]";
	}
}
