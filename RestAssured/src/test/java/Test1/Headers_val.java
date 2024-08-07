package Test1;
import org.testng.annotations.Test;
import io.restassured.response.*;
import io.restassured.http.*;

import static io.restassured.RestAssured.*;

public class Headers_val 
{
	@Test
	public void test_headers()
	{
		when() 
		
		.get("https://www.google.com/")
		
		.then()
		
		.statusCode(200)
		.header("Content-Type","text/html; charset=ISO-8859-1")
		.log().all();
		
	}
	
	@Test
	public void get_header()
	{
		Response res= given()
				
		.when()
		.get("https://www.google.com/");
		
		String header=res.getHeader("Content-Type");
		System.out.println("header is "+header);
	}
	
	//@Test
	public void get_allheaders()
	{
		Response res= given()
				
		.when()
		.get("https://www.google.com/");
	     Headers hd =res.getHeaders();
	     for(Header each : hd)
	     {
	    	 System.out.println(" Headers are--------------> "+each.getName()+"--->"+each.getValue());
	     }
	}
}




ArrayList <String> data =res.JSONpath().get().asString();
