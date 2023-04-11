package week3.day2.jira;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class DeleteBug extends JiraBaseClass {
	@Test(dependsOnMethods = { "week3.day2.jira.EditBug.EditBugTest"})
	public void DeleteBugTest()  {	
		RequestSpecification inputRequest = RestAssured
		   		  .given()
		   		  .contentType(ContentType.JSON);
		response = inputRequest.delete("issue/"+key);
		response.then().assertThat().statusCode(204);
	}
}
