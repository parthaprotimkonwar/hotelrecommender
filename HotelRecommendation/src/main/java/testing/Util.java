package testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.viz.model.Suggestions;
import com.viz.model.Venue;

public class Util {
	
	
	public static JSONArray generateResponseJSON(List<String> hotels, List<String> imageUrl) {
		
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonEntry;
		for(int i=0;i<hotels.size();i++) {
			
			jsonEntry = new JSONObject();
			try {
				jsonEntry.put("hotelID", hotels.get(i));
				jsonEntry.put("imageURl", imageUrl.get(i));
			} catch (JSONException e) {
				e.printStackTrace();
			}
			jsonArray.put(jsonEntry);
		}
		return jsonArray;
	}
	
	public static JSONArray generateResponseForSuggestionsJSON(List<Suggestions> suggestion) {
		
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonEntry;
		for(Suggestions aSuggestion : suggestion) {
			Venue aVenue = aSuggestion.getVenue();
			String imageUrl = aVenue.getiUrl();
			String url = aVenue.getUrl();
			String distance = String.format("%.2f", aSuggestion.getDfactor());
			jsonEntry = new JSONObject();
			try {
				jsonEntry.put("hotelName", aVenue.getName());
				jsonEntry.put("hotelImageUrl", url);
				jsonEntry.put("hotelUrl", imageUrl);
				jsonEntry.put("hotelAddr", aVenue.getArea().getName());
				jsonEntry.put("hotelRating", aVenue.getRating());
				jsonEntry.put("hotelDist", distance);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			jsonArray.put(jsonEntry);
			
		}
		
		/*for(int i=0;i<hotels.size();i++) {
			
			jsonEntry = new JSONObject();
			try {
				jsonEntry.put("hotelID", hotels.get(i));
				jsonEntry.put("imageURl", imageUrl.get(i));
			} catch (JSONException e) {
				e.printStackTrace();
			}
			jsonArray.put(jsonEntry);
		}*/
		return jsonArray;
	}
	

	public static String getBody(HttpServletRequest request) throws IOException {

	    String body = null;
	    StringBuilder stringBuilder = new StringBuilder();
	    BufferedReader bufferedReader = null;

	    try {
	        InputStream inputStream = request.getInputStream();
	        if (inputStream != null) {
	            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	            char[] charBuffer = new char[128];
	            int bytesRead = -1;
	            while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
	                stringBuilder.append(charBuffer, 0, bytesRead);
	            }
	        } else {
	            stringBuilder.append("");
	        }
	    } catch (IOException ex) {
	        throw ex;
	    } finally {
	        if (bufferedReader != null) {
	            try {
	                bufferedReader.close();
	            } catch (IOException ex) {
	                throw ex;
	            }
	        }
	    }

	    body = stringBuilder.toString();
	    return body;
	}
}
