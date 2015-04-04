package testing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * Servlet implementation class HelloWorldServlet
 */
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorldServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("GET Method Called");
		response.getWriter().println("Welcome welcome");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			JSONObject obj = Util.requestParamsToJSON(request);
			System.out.println(obj);
			System.out.println("Data :" + obj.get("data"));
			System.out.println("Lat :" + obj.get("lat"));
			System.out.println("Lon :" + obj.get("long"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String request11 = Util.getBody(request);
		System.out.println(request11);
		
		
		//JSONObject jsonObject = new JSONObject();
		/*JSONArray jsonArray = new JSONArray();
		JSONObject jsonEntry;
		for(int i=0;i<10;i++) {
			
			jsonEntry = new JSONObject();
			try {
				jsonEntry.put("hotelID", "hotel" + i);
				jsonEntry.put("imageURl", "image" + i);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			jsonArray.put(jsonEntry);
		}*/
		List<String> hotels = new ArrayList<String>();
		List<String> image = new ArrayList<String>();
		
		for(int i=0;i<10;i++) {
			hotels.add("My HOtel" + i);
		}
		for(int i=0;i<10;i++) {
			image.add("My image" + i);
		}
		
		JSONArray jsonArray = Util.generateResponseJSON(hotels, image);
		response.setContentType("application/json");
		response.getWriter().write(jsonArray.toString());
		
	}

}
