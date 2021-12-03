package restAPIbdd;

import org.hamcrest.Matchers;
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
					.statusCode(200)								//validation by code always added after then()
					.body("[0].name",Matchers.equalTo("David"))		//verify the values in body 
					.body("[0].salary",Matchers.equalTo("5000"))	//verify the values in body 
					.log()
					.all();
		
	}
}
