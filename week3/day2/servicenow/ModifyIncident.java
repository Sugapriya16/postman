package week3.day2.servicenow;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ModifyIncident extends SevicenowBaseClass {
	
	@Test(dependsOnMethods = { "week3.day2.servicenow.CreateIncident.createIncidentTest"})
	public void ModifyIncidentTest() {		
	
	 RequestSpecification inputRequest = RestAssured
   		  .given()
   		  .contentType(ContentType.JSON)
   		  .body("{\r\n"
   		  		+ "    \"short_description\": \"using put method for hamcrest\"\r\n"
   		  		+ "}")
   		  .queryParam("sysparm_exclude_ref_link", "true");
	 System.out.println(sys_id);
	 response = inputRequest.put("incident/"+sys_id);
	 response.then().assertThat().body("result.short_description", Matchers.equalTo("using put method for hamcrest"));
	 response.then().assertThat().statusCode(200);
	 
	}
}


