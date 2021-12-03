package oAuth;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class oAuthRequest {
	
	
	@Test
	public void PostCall() {
		//String token = "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"; 
		
		RestAssured.given()
		.auth()
		.oauth2("")
		.baseUri("https://api.github.com")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		
		.body("{\r\n"
				+ "    \"name\": \"OauthDemo\",\r\n"
				+ "    \"desription\": \"Test Repo\",\r\n"
				+ "    \"homepage\": \"https://github.com/\",\r\n"
				+ "    \"private\": false,\r\n"
				+ "    \"has_issues\": true,\r\n"
				+ "    \"has_projects\": true,\r\n"
				+ "    \"has_wiki\": true\r\n"
				+ "}")
		
		.when()
		.post("/user/repos")
		.then()
		.statusCode(201)								
		.log()
		.all();

	}
}
