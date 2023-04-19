package week4.assignment2.steps;

import java.util.Map;

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
	
	static RequestSpecification request=null;
	 static Response response=null;
	 static String sys_id="a56302954796211087c17af3836d437b";
	 
	 @Given("set the endpoint")
	 public void setEndpoint() {
		 RestAssured.baseURI="https://dev120185.service-now.com/api/now/v1/table/";
	 }
	@And("add the auth")
	public void setAuth() {
	  RestAssured.authentication = RestAssured.basic("admin", "6DnO8-FiAzk/");
	}
	  
	  @And("add the queryParams as {string} and {string}")
		public void addQP(String key, String Value) {
		request = RestAssured.given().contentType(ContentType.JSON).log().all().queryParams(key,Value);
		}
		@When("post the request with short description as {string} and category as {string}")
		public void addBodyInPost(String short_desc , String category) {
		response = request.body("{\"short_description\":\"" + short_desc + "\",\"category\":\"" + category + "\"}").post("incident");
		}
		
		@Then("validate the response as {int}")
		public void validatePostRespose(int value) {
			response.then().log().all().assertThat().statusCode(value);
			sys_id = response.jsonPath().get("result.sys_id");
			
			}	
		@When("put the request with short description as {string}")
		public void modifyData(String short_decr ) {	
			response = request.body("{\"short_description\":\""+ short_decr +"\"}" ).put("incident/a56302954796211087c17af3836d437b");
			}
		
		@Then("validate put response")
		public void validatePutRespose() {
			response.then().assertThat().statusCode(200);
			
			}	
		@Then("validate delete incident with number as {string}")
		public void validateDeleteRespose(String sys_id) {
			response = request.delete("incident/"+sys_id);
			response.then().assertThat().statusCode(204);
			}	
			


}
