package Test1;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.*;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

public class Post_method
{
	@Test
	public void post_req()
	{
		JSONObject data = new JSONObject();
		
		data.put("name", "Zeeshan");
		data.put("number","123432");
		String courses[]= {"java","playwright"};
		data.put("courses",courses);
//		HashMap<String,String> wk = new HashMap();
//		wk.put("name", "xve");
//		wk.put("id","1");
//		data.put("work",wk);
		
		 given()
		 
		.contentType("application/JSON")
		.body(data.toString())
		
		.when()
		
		.post("https://reqres.in/api/users")
		
		.then()
		
		.statusCode(201)
		.body("name",equalTo("Zeeshan"))
		.body("number",equalTo("123432"))
		.body("courses[0]",equalTo("java"))
		
		.log().all();

		
	}
	
	public void post_method()
	{
		JSONObject ob = new JSONObject();
		
		
		/*[
		  {
		    "id": 1,
		    "name": "zeeshan",
		    "work": {
		     "name": "mindfire",
		      "address": "bhubaneswar"
		    },
		    "contact": ["9376343432"]
		  },
		  {
		    "id": 1,
		    "name": "sourav",
		    "work": {
		      "name": "mindfire",
		      "address": "bhubaneswar"
		    },
		    "contact": ["9777846444"]
		  }
		]*/
		
		ob.put("id",1);
		ob.put("name","zeeshan");
		
		
		given()
		.header("Content-type","value of header");
		
		
	}
	
	
}
