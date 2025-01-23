package BaseApiLayer;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseApi{
	
	protected static RequestSpecification httpRequest;

	public static void reqSpec() {
		
		// get Request Specification object
		httpRequest = RestAssured.given();
		
		// add content type header
	    httpRequest.contentType(ContentType.JSON);
	   // httpRequest.header("Content-Type","application/json");
	    
	    //generate request log
	    httpRequest.log();
     }
}