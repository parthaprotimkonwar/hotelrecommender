package com.viz.model;

import java.util.List;

public class Suggestions {

	private Venue venue;
	private double dfactor;
	private double cfactor;
	private List<STag> listOfTags;

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	public List<STag> getListOfTags() {
		return listOfTags;
	}

	public void setListOfTags(List<STag> listOfTags) {
		this.listOfTags = listOfTags;
	}

	public double getDfactor() {
		return dfactor;
	}

	public void setDfactor(double dfactor) {
		this.dfactor = dfactor;
	}

	public double getCfactor() {
		return cfactor;
	}

	public void setCfactor(double cfactor) {
		this.cfactor = cfactor;
	}

	@Override
	public String toString() {
		return "Suggestions [venue=" + venue + ", dfactor=" + dfactor
				+ ", cfactor=" + cfactor + ", listOfTags=" + listOfTags + "]";
	}

}
