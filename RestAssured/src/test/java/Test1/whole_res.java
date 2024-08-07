package Test1;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.*;
import static io.restassured.RestAssured.*;


public class whole_res 
{	
	@Test
	void whole_response()
	{
		Response res = given()
			
		.when()
		.get("https://reqres.in/api/users");
		
//		String res_body = res.getBody().asString();
//		Assert.assertTrue(res_body.contains("Zeeshan"));
		
		String total_res = res.asString();
		System.out.println(total_res);
				
	}
}
