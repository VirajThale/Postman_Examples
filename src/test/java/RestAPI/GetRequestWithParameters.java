package restAPI;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestWithParameters {
	
	@Test
	public void GetCall() {
		
		RestAssured.baseURI = "http://localhost:7000";
		RequestSpecification request = RestAssured.given();
//		Response response = request.get("/employees/2");
		Response response = request.param("id","2").get("/employees");
		
		String ResponseBody = response.body().asString();
		System.out.println(ResponseBody);
		
//++++Verify the response Code++++++++//
		
		int ActResponse = response.statusCode();
		int ExpectResponse =200;
		Assert.assertEquals(ActResponse, ExpectResponse);

//++++Verify the response Code++++++++//

		System.out.println(response.getHeaders());
		
		String ActHeader = response.getHeader("Content-Length");
		System.out.println("[Printed]value of Content-Length"+ActHeader );
		String ExtHeader ="66";
		Assert.assertEquals(ActHeader, ExtHeader);
		
//++++Verify the response body++++++++//
		
		Assert.assertTrue(ResponseBody.contains("David"));
		
		JsonPath jpath = response.jsonPath();
		List <String> Names = jpath.get("name");
		
		String ActName= Names.get(0);
		String ExpName ="David";
		
		Assert.assertEquals(ActName, ExpName);
		
		
	}

}
//