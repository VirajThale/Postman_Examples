package restAPI;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithMap {

	@Test
	public void PostCall() {
		
		RestAssured.baseURI = "http://localhost:7000";
		RequestSpecification request = RestAssured.given();
		
//+++++++++++++++Creating PostBody= To Post New data in ++++++++++++++//		
		
		Map<String ,Object>PostBody =new HashMap<String, Object>();
		PostBody.put("name", "Virat");
		PostBody.put("salary", "3000");
		
		
		Response Response = request.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(PostBody)
				.post("employees/create");
		
		String ResponseBody = Response.body().asString();
		System.out.println(ResponseBody);
		
		
//++++Verify the response Code++++++++//
		
		int ActResponse = Response.statusCode();
		int ExpectResponse =201;
		Assert.assertEquals(ActResponse, ExpectResponse);
		
	}
}
