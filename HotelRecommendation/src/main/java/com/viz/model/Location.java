package com.viz.model;

public class Location {

	private double longitude;
	private double lattitude;

	public Location(double l1, double l2) {
		longitude = l1;
		lattitude = l2;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public double getLattitude() {
		return this.lattitude;
	}

	@Override
	public String toString() {
		return "Location [longitude=" + longitude + ", lattitude=" + lattitude
				+ "]";
	}

}
