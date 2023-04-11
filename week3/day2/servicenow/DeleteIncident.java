package week3.day2.servicenow;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class DeleteIncident extends SevicenowBaseClass {
	@Test(dependsOnMethods = { "week3.day2.servicenow.UpdateIncident.UpdateIncidentTest"})
	public void DeleteIncidentTest() {		
	
	 RequestSpecification inputRequest = RestAssured
   		  .given()
   		  .contentType(ContentType.JSON);
	 response = inputRequest.delete("incident/"+sys_id);
	 response.then().assertThat().statusCode(204);
	 response.then().assertThat().statusLine("HTTP/1.1 204 No Content");
	 
	}


}
