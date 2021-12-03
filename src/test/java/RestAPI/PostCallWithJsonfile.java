package restAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostCallWithJsonfile {
	
	@Test
	public void PostCall() throws IOException 
	{
		
		RestAssured.baseURI = "http://localhost:7000";
		RequestSpecification request = RestAssured.given();
		
//+++++++++++++++Creating PostBody= To Post New data in ++++++++++++++//		
		
		String JsonBody = ReadJsonFile("data.json");
		
		Response Response = request.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(JsonBody)
				.post("employees/create");
		
		String ResponseBody = Response.body().asString();
		System.out.println(ResponseBody);
		
//++++++++check Name in jpath +++++++++++++//
		
		JsonPath jpath = Response.jsonPath();
		String ActualName = jpath.get("name");
		String ExpName ="JamesP";
		Assert.assertEquals(ActualName,ExpName);		
		
	}

	public String ReadJsonFile(String Filename) throws IOException {
		// TODO Auto-generated method stub
//
//		public String ReadJsonFile(String Filename) throws IOException 
//		{
//		String data =new String(Files.readAllBytes(Paths.get(Filename)));
//		return data;
//		}
		
		String data =new String(Files.readAllBytes(Paths.get(Filename)));
		return data;
	}

}
