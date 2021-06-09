package webservicesTestcases;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class WeatherReportTestcases {
	
	@Test
	public static void getUserDetails() {
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.request(Method.GET,"/api/users?page=2");
		//Response response=httpRequest.get();
		
		String responseBody=response.getBody().asString();
		System.out.println(responseBody);
		
		int responseStatus=response.getStatusCode();
		System.out.println(responseStatus);
		
		String responseStatusLine=response.getStatusLine();
		System.out.println(responseStatusLine);
		
		
	}

}
