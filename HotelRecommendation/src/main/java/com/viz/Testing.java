package com.viz;

import java.io.IOException;

public class Testing {

	public static void main(String[] ss) throws IOException {

		/*-try {
		Helper help = Helper.getInstance();

		File hotelFile = new File(Constants.path + "hotel.txt");
		FileInputStream hotelfi = new FileInputStream(hotelFile);

		BufferedReader br2 = new BufferedReader(new InputStreamReader(
		hotelfi));

		File tagsFile = new File(Constants.path + "tags.txt");
		FileInputStream tagfi = new FileInputStream(tagsFile);

		BufferedReader br3 = new BufferedReader(
		new InputStreamReader(tagfi));
		String[] my;

		// System.out.println("all tags are ");
		String line;
		HashMap<String, Integer> tagToInteger = new HashMap<String, Integer>();
		HashMap<String, Integer> hotelToInteger = new HashMap<String, Integer>();
		HashMap<Integer, String> integerToTag = new HashMap<Integer, String>();
		HashMap<Integer, String> integerToHotel = new HashMap<Integer, String>();
		int Tagcount = 0;
		int HotelCount = 0;
		while (true) {
		line = br3.readLine();
		if (line == null)
		break;
		// System.out.println(line);
		tagToInteger.put(line.toLowerCase(), Tagcount);
		integerToTag.put(Tagcount, line);
		Tagcount++;
		}
		// System.out.println("total tags found " + Tagcount);
		// System.out.println("all hotels");
		while (true) {
		line = br2.readLine();
		if (line == null)
		break;
		// System.out.println(line);
		my = line.split("\\|");
		// System.out.println("total data is " + Arrays.toString(my));
		String name = my[0];
		hotelToInteger.put(name, HotelCount);
		// System.out.println(" parsing " + my[1]);
		String[] tmp = my[1].split(":");
		String s = "hotel " + name;
		// System.out.println("location is " + Arrays.toString(tmp));
		double lon = Double.parseDouble(tmp[0]);
		double lat = Double.parseDouble(tmp[1]);
		Location loc = new Location(lon, lat, s);
		Hotel tmpHotel = new Hotel(name, HotelCount);
		tmpHotel.setLocation(loc);
		tmp = my[2].split(",");
		ArrayList<Integer> tags = new ArrayList<Integer>();
		// System.out.println("tag to integer is " + tagToInteger);
		for (String tm : tmp) {
		tmpHotel.addDish(Integer.parseInt(tm));
		}
		// System.out.println(tmpHotel);
		help.addHotel(tmpHotel);
		HotelCount++;
		}
		// help.showData();
		// help.showDistance();

		Location mylocation = new Location(1.0, 2.0001, "");
		ArrayList<Integer> mytag = new ArrayList<Integer>();
		mytag.add(21);
		ArrayList<Hotel> myresult = help.suggest(mylocation, mytag);

		System.out.println("possible are ");
		for (Hotel res : myresult) {
		System.out.println(res);
		}

		} finally {

		}
		 */
	}
}
