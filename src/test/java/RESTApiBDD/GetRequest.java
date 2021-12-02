package RESTApiBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetRequest {
	
	@Test
	public void GetCall() {
		
		RestAssured.given()
					.baseUri("http://localhost:7000")
					.when()
					.get("/employees")
					.then()
					.statusCode(200)//validation by code always added after then()
					.log()
					.all();
		
	}
}
