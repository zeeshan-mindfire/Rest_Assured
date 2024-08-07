package Test1;
import java.io.File;
import java.util.*;
import java.util.logging.FileHandler;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import net.minidev.json.JSONObject;

public class JSON_POST
{
	@Test
	
	void Post_usingJSON()
	{
		JSONObject data = new JSONObject();
		 
		data.put("name", "Zeeshan");
		data.put("Location","India");
		data.put("phone", "1234567890");

		String Courses[]= {"C","C++"};
		data.put("courses", Courses);
		
		given()
		
		.contentType("application/json")
		.body(data.toString())
		
		.when()
			
		.post("https://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name",equalTo("Zeeshan"))
		.body("location",equalTo("India"))
		.body("course[0]",equalTo("C"))
		.body("course[1]",equalTo("C++"))
		.log().all();
		
		
	}
	
	@Test
	void Post_usingHashmap()
	{
		HashMap data = new HashMap();
		
		data.put("name", "Stein");
		data.put("Location","England");
		data.put("phone", "123453421");

		String Courses[]= {"C","C++"};
		data.put("courses", Courses);
		
		given()
		
		.contentType("application/json")
		.body(data.toString())
		
		.when()
			
		.post("https://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name",equalTo("Stein"))
		.body("location",equalTo("England"))
		.body("course[0]",equalTo("C"))
		.body("course[1]",equalTo("C++"))
		.log().all();
		
	}
	
	@Test
	void post_usingPOJO()
	{
		POJO_Post data = new POJO_Post();
		data.setName("Scott");
		data.setPhone("12344232");
		data.setLocation("Spain");
		String Courses[]= {"Java","Selenium","Sql"};
		
		data.setCourses(Courses);
		
		given()
			
			.contentType("application/json")
			.body(data)
			
		.when()
			.post("https://reqres.com")
			
		.then()
		.statusCode(201)
		.body("name",equalTo("Sergio"))
		.body("location",equalTo("Spain"))
		.body("course[0]",equalTo("Java"))
		.body("course[1]",equalTo("Selenium"))
		.body("course[2]",equalTo("Sql"))
		.log().all();
		
	}
	@Test
	void post_usingExtJsonFile()
	{
		File f = new File(".\\body.json");
		FileHandler fr = new FileHandler(f);
		JSONTokener jt = new JSONTokener(fr);    
		JSONObject data = new JSONObject(jt);
		
		given()
			
			.contentType("application/json")
			.body(data)
			 
		.when()
			.post("https://reqres.com")
			
		.then()
		.statusCode(201)
		.body("name",equalTo("Zeeshan"))
		.body("location",equalTo("India"))
		.body("course[0]",equalTo("Java"))
		.body("course[1]",equalTo("Playwright"))
		.body("course[2]",equalTo("Git"))
		.log().all();
		
	}
}
