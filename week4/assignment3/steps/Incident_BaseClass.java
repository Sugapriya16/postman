package week4.assignment3.steps;

import java.util.Map;

import org.hamcrest.Matchers;
import org.apache.commons.lang3.RandomStringUtils;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Incident_BaseClass {
	
	 RequestSpecification request=null;
	  Response response=null;
	 String sys_id = null;
	
		@When("post the request with short description as {string} and category as {string}")
		public void addBodyInPost(String short_desc , String category) {
		request = RestAssured.given()
				.contentType(ContentType.JSON)
				.body("{\"short_description\":\"" + short_desc + "\",\"category\":\"" + category + "\"}");
		response = request.post();
		sys_id = response.jsonPath().get("result.sys_id");
		}
		
		@Then("validate the response as {int}")
		public void validatePostRespose(int value) {
			response.then().log().all().assertThat().statusCode(value);
			response.then().body("result.task_effective_number", Matchers.hasLength(10));
			
			}	
		
		@When("put the request with short description as random alphanumberic")
		public void modifyIncident() {
			
			String valueToField =  RandomStringUtils.randomAlphanumeric(6);
			request = RestAssured.given()
					.contentType(ContentType.JSON);
			response = request.body("{\"short_description\":\""+ valueToField +"\"}" ).put("a56302954796211087c17af3836d437b");
			}
		
		@Then("validate put response")
		public void validatePutRespose() {
			response.then().assertThat().statusCode(200);
			response.then().body("result.short_description",Matchers.hasLength(6));
			
		}	
		
		@When ("delete request")
		public void deleteIncident() {
			request = RestAssured.given().contentType(ContentType.JSON);
			
		}
		@Then("validate delete incident")
		public void validateDeleteRespose() {
			response = request.delete("4aa879294716611087c17af3836d4375");
			response.then().assertThat().statusCode(204);
			
			}	
//			


}
