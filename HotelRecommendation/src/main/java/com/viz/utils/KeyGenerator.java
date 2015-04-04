package com.viz.utils;

public class KeyGenerator {

	private static int venue;

	public static int getVenueId() {
		return venue++;
	}

	private static int area;

	public static int getAreaId() {
		return area++;
	}

	private static int tag;

	public static int getTagId() {
		return tag++;
	}

}
