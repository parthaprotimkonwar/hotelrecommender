package com.viz.handlers;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import com.viz.common.Constants;
import com.viz.model.Location;
import com.viz.model.Suggestions;
import com.viz.model.Venue;
import com.viz.utils.Helper;
import com.viz.utils.Loader;

public class ParseHandler {

	public List<Suggestions> suggestMeSomething(String status, Location location)
			throws Exception {
		// Loader.initializeCache();
		// ParseHandler ps = new ParseHandler();
		// Location location = new Location(12.9697220d, 77.6430061d);
		List<String> possible = parseDialogue("Having Italian at Truffles at Koramangala.");
		System.out.println(possible);
		List<Suggestions> suggestions = Helper.suggest(location, possible);
		Comparator<Suggestions> compr = new Comparator<Suggestions>() {
			@Override
			public int compare(Suggestions o1, Suggestions o2) {
				if (o1.getCfactor() > o2.getCfactor())
					return -1;
				return 1;
				/*-if (o1.getMfactor() < o2.getMfactor())
					return -1;
				if (o1.getMfactor() > o2.getMfactor())
					return 1;
				if (o1.getVenue().getRating() > o2.getVenue().getRating())
					return -1;
				return 1;*/
			}
		};
		Collections.sort(suggestions, compr);
		System.out.println("Sugestions are: ");
		for (Suggestions sug : suggestions) {
			Venue cur = sug.getVenue();
			System.out.println(cur.getId() + "|" + cur.getRating() + "|"
					+ cur.getArea() + "|" + sug.getDfactor() + "|"
					+ sug.getCfactor());
		}
		// List<Hotel> hotels = Helper.getListOfHotels(possible);
		// ps.getSentences("Hi. How are you? This is Mike.");
		// ps.findTags();
		
		return suggestions;
	}

	public List<String> parseDialogue(String para) throws Exception {
		List<String> possible = new ArrayList<String>();
		InputStream is = new FileInputStream(Constants.path + "en-token.bin");
		TokenizerModel model = new TokenizerModel(is);
		Tokenizer tokenizer = new TokenizerME(model);
		String tokens[] = tokenizer.tokenize(para);
		for (String a : tokens)
			possible.add(a);
		is.close();
		return possible;
	}
	/*-private String[] getSentences(String para) throws Exception {
		InputStream is = new FileInputStream(Constants.path + "en-sent.bin");
		SentenceModel model = new SentenceModel(is);
		SentenceDetectorME sdetector = new SentenceDetectorME(model);
		String sentences[] = sdetector.sentDetect(para);
		System.out.println(sentences[0]);
		System.out.println(sentences[1]);
		is.close();
		return sentences;
	}
	private void findTags() throws Exception {
		InputStream is = new FileInputStream(Constants.path
				+ "en-ner-person.bin");
		TokenNameFinderModel model = new TokenNameFinderModel(is);
		is.close();
		NameFinderME nameFinder = new NameFinderME(model);
		String[] sentence = new String[] { "Steve", "x", "Smith", "is", "a",
				"good" };
		Span nameSpans[] = nameFinder.find(sentence);
		for (Span s : nameSpans)
			System.out.println(s.toString() + "|" + s.getStart() + "|"
					+ s.getEnd() + "|" + s.getType());
	}*/
}