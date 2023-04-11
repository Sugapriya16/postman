package week3.day2.jira;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class EditBug extends JiraBaseClass {
	@Test(dependsOnMethods = { "week3.day2.jira.CreateBug.CreateBugTest"})
	public void EditBugTest()  {	
		RequestSpecification inputRequest = RestAssured
		   		  .given()
		   		  .contentType(ContentType.JSON)
		   		  .body("{\r\n"
		   		  		+ "    \"fields\": {\r\n"
		   		  		+ "       \"project\":\r\n"
		   		  		+ "       {\r\n"
		   		  		+ "          \"id\": \"10001\"\r\n"
		   		  		+ "       },\r\n"
		   		  		+ "       \"summary\": \"Using Rest summary was edited.\",\r\n"
		   		  		+ "       \"issuetype\": {\r\n"
		   		  		+ "          \"name\": \"Bug\"\r\n"
		   		  		+ "       }\r\n"
		   		  		+ "   }\r\n"
		   		  		+ "}");
		response = inputRequest.put("issue/"+key);
		response.then().assertThat().statusCode(204);
	}

}
