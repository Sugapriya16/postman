package week3.day2.servicenow;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class GetIncident extends SevicenowBaseClass {
	@Test(dependsOnMethods = { "week3.day2.servicenow.DeleteIncident.DeleteIncidentTest"})
	public void GetIncidentTest() {		
	
	 RequestSpecification inputRequest = RestAssured
   		  .given()
   		  .contentType(ContentType.JSON);
	 response = inputRequest.get("incident/"+sys_id);
	 response.then().assertThat().statusCode(404);
	}

}
