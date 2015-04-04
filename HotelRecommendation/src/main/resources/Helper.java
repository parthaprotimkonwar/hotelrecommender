package com.viz.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.viz.common.Cache;
import com.viz.common.Constants;
import com.viz.model.Hotel;
import com.viz.model.Location;
import com.viz.model.Tag;

public class Helper {

	static Helper instance;
	ArrayList<Hotel> allHotels;
	ArrayList<Integer> allTags;
	public double allowedDistance = 33.0;

	private Helper() {
		allHotels = new ArrayList<Hotel>();
		allTags = new ArrayList<Integer>();

	}

	public void populateHotels(ArrayList<Hotel> data) {
		for (Hotel hotel : data) {
			allHotels.add(hotel);
		}
	}

	public void populateTags(ArrayList<Integer> data) {
		for (Integer index : data) {
			allTags.add(index);
		}
	}

	public static Helper getInstance() {
		if (instance == null)
			instance = new Helper();
		return instance;
	}

	public ArrayList<Hotel> suggest(Location location, ArrayList<Integer> tags) {

		ArrayList<Hotel> result = new ArrayList<Hotel>();
		ArrayList<Hotel> nearHotel = nearestHotel(location, allowedDistance);
		System.out.println("we want " + tags);
		if (tags == null || tags.isEmpty())
			return nearHotel;
		for (Hotel cur : nearHotel) {
			System.out.println("near hotel is " + cur);
			System.out.println("it ahs tags " + cur.getTags());
			boolean valid = false;
			Set<Integer> availableTags = cur.getTags();
			for (int tag : tags) {
				if (availableTags.contains(tag)) {
					valid = true;
					break;
				}
			}
			if (valid == true) {
				result.add(cur);
			}
		}

		return result;

	}

	public void addHotel(Hotel cur) {
		allHotels.add(cur);
	}

	private ArrayList<Hotel> nearestHotel(Location location, double distance) {

		ArrayList<Hotel> result = new ArrayList<Hotel>();
		for (Hotel cur : allHotels) {
			Location hotelLocation = cur.getLocation();
			double dis = getDistance(hotelLocation, location);
			if (dis <= distance) {
				result.add(cur);
			}
		}
		return result;
	}

	public void showDistance() {
		int l = allHotels.size();
		int i, j;
		for (i = 0; i < l; i++) {
			for (j = i + 1; j < l; j++) {
				Hotel first, second;
				first = allHotels.get(i);
				second = allHotels.get(j);
				double dis = getDistance(first.getLocation(),
						second.getLocation());
				System.out.println(first.getName() + " and  "
						+ second.getName() + " are at distance  " + dis
						+ " kilometers");
			}
		}
	}

	public void showData() {
		for (Hotel cur : allHotels) {
			System.out.println(cur + " with tags " + cur.getTags());
		}
	}

	public static int minDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();

		// len1+1, len2+1, because finally return dp[len1][len2]
		int[][] dp = new int[len1 + 1][len2 + 1];

		for (int i = 0; i <= len1; i++) {
			dp[i][0] = i;
		}

		for (int j = 0; j <= len2; j++) {
			dp[0][j] = j;
		}

		// iterate though, and check last char
		for (int i = 0; i < len1; i++) {
			char c1 = word1.charAt(i);
			for (int j = 0; j < len2; j++) {
				char c2 = word2.charAt(j);

				// if last two chars equal
				if (c1 == c2) {
					// update dp value for +1 length
					dp[i + 1][j + 1] = dp[i][j];
				} else {
					int replace = dp[i][j] + 1;
					int insert = dp[i][j + 1] + 1;
					int delete = dp[i + 1][j] + 1;

					int min = replace > insert ? insert : replace;
					min = delete > min ? min : delete;
					dp[i + 1][j + 1] = min;
				}
			}
		}

		return dp[len1][len2];
	}

	private static double distance(double lat1, double lon1, double lat2,
			double lon2, String unit) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
				* Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		if (unit == Constants.DIST_IN_KM) {
			dist = dist * 1.609344;
		} else if (unit == Constants.DIST_IN_N) {
			dist = dist * 0.8684;
		}
		return dist;
	}

	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	/* :: This function converts decimal degrees to radians : */
	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	/* :: This function converts radians to decimal degrees : */
	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}

	public static double getDistance(Location one, Location other) {
		return distance(one.getLattitude(), one.getLongitude(),
				other.getLattitude(), other.getLongitude(),
				Constants.DIST_IN_KM);
		// return 0;
	}

	public static void main(String[] args) {

		Set<Integer> x = new HashSet<Integer>();
		x.add(56);
		x.add(4343);
		System.out.println(x);

		System.out
				.println(distance(0, 0, 0, 1, Constants.DIST_IN_KM) + " kilo");
		System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506,
				"M") + " Miles\n");
		System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506,
				Constants.DIST_IN_KM) + " Kilometers\n");
		System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506,
				Constants.DIST_IN_N) + " Nautical Miles\n");

	}

	public static List<Tag> getListOfTags(List<String> possible) {
		List<Tag> fnList = new ArrayList<Tag>();
		for (String pos : possible) {
			Tag tm = new Tag(null, pos);
			int in = Cache.listOfTags.indexOf(tm);
			if (in != -1)
				fnList.add(Cache.listOfTags.get(in));
		}
		return fnList;
	}

	public static List<Hotel> getListOfHotels(List<String> possible) {
		List<Hotel> fnList = new ArrayList<Hotel>();
		for (String pos : possible) {
			Hotel tm = new Hotel(pos, -1);
			int in = Cache.listOfHotels.indexOf(tm);
			if (in != -1)
				fnList.add(Cache.listOfHotels.get(in));
		}
		return fnList;
	}

}
