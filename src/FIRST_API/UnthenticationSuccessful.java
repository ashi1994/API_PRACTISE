package FIRST_API;
import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 
public class UnthenticationSuccessful {
 
	@Test(description="this test vaildate the suceessful authentication")
	public void validateSuccessful()
	{   
		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("email", "peter@klaven");
		requestParams.put("password", "cityslicka");
		// Add a header stating the Request body is a JSON
				httpRequest.header("Content-Type", "application/json");

				// Add the Json to the body of the request
				httpRequest.body(requestParams.toJSONString());

				// Post the request and check the response
				Response response = httpRequest.post("/api/register");

		         int statusCode = response.getStatusCode();
		 
		     	System.out.println("The status code recieved: " + statusCode);
		      
		     	System.out.println("Response body: " + response.body().asString());
		     	
		     	assertEquals(statusCode, 201,"something wrong");
			
	}
 
}