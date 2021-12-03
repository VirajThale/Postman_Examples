package restAPIbdd;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutRequest {
	
	@Test
	public void PostCall() {
		Map<String ,Object>PutBody =new HashMap<String, Object>();
		PutBody.put("name", "JamesPom");
		PutBody.put("salary", "5100");
		
		RestAssured.given()
		.baseUri("http://localhost:7000")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(PutBody)
		.when()
		.put("/employees/10")
		.then()
		.statusCode(200)								//validation by code always added after then()
		.log()
		.all();
	}


}
