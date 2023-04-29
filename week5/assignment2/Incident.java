package week5.assignment2;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;

public class Incident {
	@Test
	public void CreateIncident() {
		RestAssured.baseURI = "https://dev158367.service-now.com/api/now/v1/table/";
			RestAssured.authentication = RestAssured.basic("admin", "wFN*%0q8oUaW");
				RequestSpecification request = RestAssured
						.given()
						.contentType(ContentType.JSON);
				Response response = request.post("incident");
				
				response.then().assertThat().body("result.number", Matchers.containsString("INC"),"result",Matchers.hasKey("correlation_id"))
				.log().ifValidationFails();
										

}

}
