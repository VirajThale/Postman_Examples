package RestAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	
	@Test
	public void PostCall() {
		RestAssured.baseURI = "http://localhost:7000";
		RequestSpecification request = RestAssured.given();
		Response Response = request.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body("{\r\n"
						+ "    \"name\": \"Arjit\",\r\n"
						+ "    \"salary\": 12000\r\n"
						+ "}")
				.post("employees/create");
		
		String ResponseBody = Response.body().asString();
		System.out.println(ResponseBody);
		
		
//++++Verify the response Code++++++++//
		
		int ActResponse = Response.statusCode();
		int ExpectResponse =201;
		Assert.assertEquals(ActResponse, ExpectResponse);
		
	}

}
