package week3.day2.jira;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class CreateBug extends JiraBaseClass{
	
	@Test
	public void CreateBugTest() {	
		RequestSpecification inputRequest = RestAssured
		   		  .given()
		   		  .contentType(ContentType.JSON)
		   		  .body("{\r\n"
		   		  		+ "    \"fields\": {\r\n"
		   		  		+ "       \"project\":\r\n"
		   		  		+ "       {\r\n"
		   		  		+ "          \"id\": \"10001\"\r\n"
		   		  		+ "       },\r\n"
		   		  		+ "       \"summary\": \"No REST for the Wicked.\",\r\n"
		   		  		+ "       \"issuetype\": {\r\n"
		   		  		+ "          \"id\": \"10008\"\r\n"
		   		  		+ "       }\r\n"
		   		  		+ "   }\r\n"
		   		  		+ "}");
		        
	
	response = inputRequest.post("issue");
	key = response.jsonPath().get("key");
	System.out.println(key);
	response.then().assertThat().statusCode(201);
	}
}
