package week3.day2.servicenow;

import org.testng.annotations.Test;

public class CreateIncident extends SevicenowBaseClass{
	@Test
	public void createIncidentTest() {		
	response = request.post("incident");
	sys_id = response.jsonPath().get("result.sys_id");
	incident_number = response.jsonPath().get("result.number");
	response.then().assertThat().statusCode(201);
}
}
