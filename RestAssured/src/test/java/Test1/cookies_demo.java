package Test1;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.*;
import static io.restassured.RestAssured.*;
import java.util.Map;

public class cookies_demo 
{
	@Test
	void test_cookies() 
	{
		given()
			
		.when()
		.get("https://www.google.com/")
		
		.then()
		
		.cookie("AEC","AQTF6HwXge1_9DDVoiYRfFyOwswxTz7BP43MvFrFydFZ6DhU4sr-I5G0oQ")
		.log().all();
	}
	
	@Test(priority=1)
	void get_cookies() 
	{
		Response res= given()
			
		.when()
		.get("https://www.google.com/");
		
		String cookie_val =res.getCookie("AEC");
		System.out.println("The value of cookie is====>"+cookie_val);
		
		Assert.assertEquals(res.statusCode(),200);
		Assert.assertEquals(res.cookie(cookie_val),"pass the cookievalue here");
		
		
		
		// to get all cookies
		
		Map <String,String> allcookies =res.getCookies();
		System.out.println("The cookies present are "+allcookies);
		
		for(String each:allcookies.keySet())
		{
			String cookies=res.getCookie(each);
			System.out.println("cookie is"+cookies);
		}
	}
}
