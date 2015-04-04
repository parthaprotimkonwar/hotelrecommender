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
		
		String request11 = Util.getBody(request);
		JSONObject object = null;
		String data = null;
		String latitude = null;
		String longitude = null;
		System.out.println(request11);
		try {
			object = new JSONObject(request11);
			data = object.getString("name");
			latitude = object.getString("lat");
			longitude = object.getString("lon");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		System.out.println(data);
		System.out.println(latitude);
		System.out.println(longitude);
		
		
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
