package com.viz.common;

import java.util.*;

import com.viz.model.Area;
import com.viz.model.Location;
import com.viz.model.PTag;
import com.viz.model.STag;
import com.viz.model.Section;
import com.viz.model.Venue;

public class Cache {

	/*-public static Map<Location, List<Hotel>> locationToHotel = new HashMap<Location, List<Hotel>>();
	public static Map<Tag, List<Hotel>> tagToHotel = new HashMap<Tag, List<Hotel>>();

	public static Map<Hotel, List<Tag>> hotelToTags = new HashMap<Hotel, List<Tag>>();

	public static List<Tag> listOfTags = new ArrayList<Tag>();
	public static List<Hotel> listOfHotels = new ArrayList<Hotel>();*/

	public static List<PTag> listOfPTags = new ArrayList<PTag>();
	public static List<STag> listOfSTags = new ArrayList<STag>();

	public static Map<String, STag> stagMap = new HashMap<String, STag>();

	public static List<Section> listOfSections = new ArrayList<Section>();
	public static List<Area> listOfAreas = new ArrayList<Area>();
	public static List<Venue> listOfVenues = new ArrayList<Venue>();

	public static Map<String, Area> areaMap = new HashMap<String, Area>();
	public static List<Location> listOfLocations = new ArrayList<Location>();

}
