package Test1;

import org.testng.annotations.Test;
import io.restassured.response.*;
import io.restassured.*;
import static io.restassured.RestAssured.*;
import java.io.File;

public class File_upload 
{
	@Test
	public void file_upload()
	{
		File myfile = new File("D:\\dwsample1-json.json");
		
		given()
		.multiPart("file",myfile)
		.contentType("multipart/form-data")	
		.when()
		.post("https://postman-echo.com/post")
		
		.then()
		.statusCode(200);
	}
}
