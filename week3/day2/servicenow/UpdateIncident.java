package week3.day2.servicenow;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class UpdateIncident extends SevicenowBaseClass{
	@Test(dependsOnMethods = { "week3.day2.servicenow.ModifyIncident.ModifyIncidentTest"})
	public void UpdateIncidentTest() {		
	
	 RequestSpecification inputRequest = RestAssured
   		  .given()
   		  .contentType(ContentType.JSON)
   		  .body("{\r\n"
   		  		+ "    \"short_description\": \"using patch method for hamcrest\"\r\n"
   		  		+ "    \r\n"
   		  		+ "}");
	 response = inputRequest.patch("incident/"+sys_id);
	 response.then().assertThat().body("result.short_description", Matchers.containsString("hamcrest"));
	 response.then().assertThat().body("result.number", Matchers.equalTo(incident_number));
	 response.then().assertThat().statusCode(200);
	 
	}

}
