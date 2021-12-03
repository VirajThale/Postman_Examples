package restAPIbdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteRequest {
	String call="12";

	@Test
	public void DeleteCall() {
		
		RestAssured.given()
		.baseUri("http://localhost:7000")
		.when()
		.delete("/employees/"+call)
		.then()
		.statusCode(200)
		
		.log()
		.all();
		
		
	}
}
