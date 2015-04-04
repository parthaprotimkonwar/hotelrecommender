package com.viz.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map.Entry;

import com.viz.common.Cache;
import com.viz.common.Constants;
import com.viz.model.Area;
import com.viz.model.Location;
import com.viz.model.STag;
import com.viz.model.Venue;

public class Loader {

	public static void main(String[] args) {
		initializeCache();
	}

	public static void initializeCache() {

		loadVenues();
		System.out.println("listOfAreas: " + Cache.listOfAreas);
		System.out.println("listOfLocations: " + Cache.listOfLocations);
		System.out.println("listOfPTags: " + Cache.listOfPTags);

		System.out.println("listOfSections: " + Cache.listOfSections);
		System.out.println("listOfSTags: " + Cache.listOfSTags);
		System.out.println("listOfVenues: " + Cache.listOfVenues);

		System.out.println("areaMap: " + Cache.areaMap);
		System.out.println("stagMap: " + Cache.stagMap);

		System.out.println("\nSTags: ");
		for (Entry<String, STag> s : Cache.stagMap.entrySet()) {
			System.out.println(s.getKey());
		}

		System.out.println("\nAreas: ");
		for (Entry<String, Area> s : Cache.areaMap.entrySet()) {
			System.out.println(s.getKey());
		}
	}

	private static void loadTags() {
		// File hotelFile = new File(Constants.path + "tags.txt");
		// InputStream hotelFile =
		// Loader.class.getClassLoader().getResourceAsStream("tags.txt");
		try (FileInputStream hotelfi = (FileInputStream) Loader.class
				.getClassLoader().getResourceAsStream("tags.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(
						hotelfi))) {
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] tockens = line.split(Constants.splitter);

				for (int i = 0; i < tockens.length; i++) {

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void loadSections() {
		// File hotelFile = new File(Constants.path + "sections.txt");

		try (FileInputStream hotelfi = (FileInputStream) Loader.class
				.getClassLoader().getResourceAsStream("sections.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(
						hotelfi))) {
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] tockens = line.split(Constants.splitter);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void loadVenues() {
		// File hotelFile = new File(Constants.path + "finaldata.txt");

		// File hotelFile =
		// Loader.class.getClassLoader().getResourceAsStream("tags.txt");

		try /*
			 * (FileInputStream hotelfi = (FileInputStream)
			 * Loader.class.getClassLoader
			 * ().getResourceAsStream("finaldata.txt"); BufferedReader br = new
			 * BufferedReader(new InputStreamReader( hotelfi)))
			 */{
			InputStream io = Loader.class.getClassLoader().getResourceAsStream(
					"finaldata.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(io));
			String line = "";
			while ((line = br.readLine()) != null) {
				line = line.replaceAll("\\s", "");
				String[] tockens = line.split(Constants.splitter);

				Venue venue = new Venue();
				venue.setId(KeyGenerator.getVenueId());
				venue.setName(tockens[0]);

				double lng = Double.parseDouble(tockens[1]);
				double lat = Double.parseDouble(tockens[2]);
				Location location = new Location(lng, lat);
				venue.setLocation(location);

				String areaName = tockens[3];
				Area area = Cache.areaMap.get(areaName);
				if (area == null) {
					area = new Area();
					area.setId(KeyGenerator.getAreaId());
					area.setName(areaName);

					Cache.areaMap.put(areaName, area);
				}

				venue.setArea(area);

				String[] appTags = tockens[4].split(",");
				for (String tagName : appTags) {
					STag tag = Cache.stagMap.get(tagName);
					if (tag == null) {
						tag = new STag();
						tag.setId(KeyGenerator.getTagId());
						tag.setName(tagName);

						Cache.stagMap.put(tagName, tag);
					}
					venue.getAplicableTags().add(tag);
				}

				venue.setRating(Double.parseDouble(tockens[5]));
				venue.setiUrl(tockens[6]);
				venue.setUrl(tockens[7]);
				venue.setAddress(tockens[8]);

				Cache.listOfVenues.add(venue);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
