package RESTAPIChaining;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EndToEndTest {
	@Test
	public void test1() {
		
		RestAssured.baseURI = "http://localhost:7000";
		RequestSpecification PostRequest = RestAssured.given();
		
		
//+++++++++++++++#PostRequest ++++++++++++++++++++++++++++//		
		
		Map<String ,Object>PostBody =new HashMap<String, Object>();
		PostBody.put("name", "Gon");
		PostBody.put("salary", "5000");
		
		
		Response PostResponse = PostRequest.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(PostBody)
				.post("employees/create");
		
		String ResponseBody = PostResponse.body().asString();
		System.out.println(ResponseBody);

//++++++++Get PostResponse ID in jath ++++++++++++++++++//
		
		JsonPath jpath = PostResponse.jsonPath();
		String ResponseID = jpath.get("id").toString();
		
		
		
//++++++++++++++#PutRequest++++++++++++++++++++++++++++++//
		RequestSpecification PutRequest = RestAssured.given();

		Map<String ,Object>PutBody =new HashMap<String, Object>();
		PutBody.put("name", "Bon");
		PutBody.put("salary", "5000");
		
		Response PutResponse = PutRequest.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(PutBody)
				.put("employees/"+ ResponseID);
		
		ResponseBody = PutResponse.body().asString();
		System.out.println(ResponseBody);

		
//++++++++++++++#DeleteRequest+++++++++++++++++++++++++++//
		
		RequestSpecification DeleteRequest = RestAssured.given();
		Response DeleteResponse = DeleteRequest.delete("employees/"+ResponseID);
		
//+++++++++Verify the response Code+++++++++++++++++++++//
		
		int ActResponse = DeleteResponse.statusCode();
		int ExpectResponse =200;
		Assert.assertEquals(ActResponse, ExpectResponse);
		
//++++++++++++++++GetCall++++++++++++++++++++++++++++++++++//
		
		RequestSpecification GetRequest = RestAssured.given();
		
		Response GetResponse = GetRequest.get("/employees/" + ResponseID);
		ActResponse = GetResponse.statusCode();
		ExpectResponse = 404;
		Assert.assertEquals(ActResponse, ExpectResponse);
			

		
	}

}
