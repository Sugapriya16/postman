package week3;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RetriveRecord {
    @Test
	public void getRecord() {
		// Step 1 - Requirements
		
//     Step2 - Endpoint with resources
		RestAssured.baseURI = "https://dev120185.service-now.com/api/now/v1/table/incident";
        
//      Step 3- construct the request (params, auth, etc)
      RestAssured.authentication = RestAssured.basic("admin", "6DnO8-FiAzk/");
      
//      Step 4 - send the request(http methods)
      Response response = RestAssured.get();
      
//      Step 5 - Validate the response
      response.prettyPrint();

	}

}
