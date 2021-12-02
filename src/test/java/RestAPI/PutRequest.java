package RestAPI;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequest {
	@Test
	public void PutCall() {
		RestAssured.baseURI = "http://localhost:7000";
		RequestSpecification request = RestAssured.given();
		
		JSONObject PostBody =new JSONObject();
		PostBody.put("name", "JamesPW");
		PostBody.put("salary", "1200");
		
		Response Response = request.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(PostBody.toString())
				.put("employees/10");
				
		
		String ResponseBody = Response.body().asString();
		System.out.println(ResponseBody);
		
//++++Verify the response Code++++++++//
		
		int ActResponse = Response.statusCode();
		int ExpectResponse =200;
		Assert.assertEquals(ActResponse, ExpectResponse);
				
		

	}
}
