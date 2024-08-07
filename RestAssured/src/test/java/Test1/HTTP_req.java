package Test1;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import com.jayway.jsonpath.JsonPath;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HTTP_req 
{
	@Test
	void getUser()
	{
		Response res=given()
	
		.when()
			.get("https://reqres.in/api/users?page=2");
		
		String All_id =res.jsonPath().get("data.firstname").toString();
		System.out.println(All_id);
		
		
	}
}

	