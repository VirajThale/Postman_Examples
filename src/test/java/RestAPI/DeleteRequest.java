package restAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequest {
	
	
	@Test
	public void DeleteCall() {
		
		RestAssured.baseURI = "http://localhost:7000";
		RequestSpecification request = RestAssured.given();
		Response Response = request.delete("employees/10");
		
//++++Verify the response Code++++++++//
		
		int ActResponse = Response.statusCode();
				int ExpectResponse =200;
				Assert.assertEquals(ActResponse, ExpectResponse);
		
	}

}
