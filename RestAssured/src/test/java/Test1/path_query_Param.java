package Test1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class path_query_Param 
{
	@Test
	void path_qry_para()
	{
		given()
			

		.pathParam("mypath","users") //path parameter
		.queryParam("page",2) //query parameter
		.queryParam("id",5)
		
		.when()
		
		.get("http://reqres.in/api/{mypath}")
			
		.then()
		.statusCode(200)
		.log().all(); 
		
	}
}
