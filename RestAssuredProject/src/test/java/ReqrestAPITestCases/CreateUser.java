package ReqrestAPITestCases;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class CreateUser {
	
	@Test
	public void createUser() {
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification httpRequest=RestAssured.given();
		
		JSONObject reqPayload=new JSONObject();
		reqPayload.put("name", "pola");
		reqPayload.put("job", "leader");
		
		httpRequest.body(reqPayload.toJSONString());
		Response response=httpRequest.post("/api/users");
		
		System.out.println(response.body().asString());
		System.out.println(response.getStatusLine());
		int expectedStatusCode=response.getStatusCode();
		Assert.assertEquals(expectedStatusCode, 201);
		
		
		
	}

}
