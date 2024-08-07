package Test1;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import net.minidev.json.JSONObject;

public class pst_method
{
	@Test
	public void post_method()
	{
		HashMap<String,String> data = new HashMap<String,String>();
		data.put("name","Raj");
		data.put("job","teacher");
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users")
		
		.then()
		.statusCode(201)
		.log().cookies();
	}
}
