package RestAPI;



import java.util.List;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithJsonObject {
	
	@Test
	public void PostCall() {
		
		RestAssured.baseURI = "http://localhost:7000";
		RequestSpecification request = RestAssured.given();
		
//+++++++++++++++Creating PostBody= To Post New data in ++++++++++++++//		
		
		JSONObject PostBody =new JSONObject();
		PostBody.put("name", "Navin");
		PostBody.put("salary", "1000");
		
		
		Response Response = request.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(PostBody.toString())
				.post("employees/create");
		
		String ResponseBody = Response.body().asString();
		System.out.println(ResponseBody);
		
		
//++++Verify the response Code++++++++//
		
		int ActResponse = Response.statusCode();
		int ExpectResponse =201;
		Assert.assertEquals(ActResponse, ExpectResponse);
		
//++++++++check Name in jpath +++++++++++++//
		
		JsonPath jpath = Response.jsonPath();
		String ActualName = jpath.get("name");
		String ExpName ="Navin";
		Assert.assertEquals(ActualName,ExpName);
		
	}

}
