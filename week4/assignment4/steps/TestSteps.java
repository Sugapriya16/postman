package week4.assignment4.steps;

import java.util.Map;
import java.util.Map.Entry;

import org.hamcrest.Matchers;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestSteps {
//	Assignment 1(cucumber) - Create 3 incidents using the same scenario (Hint - use Scenario Outline)
//	(Short-desc - "This is First" and category -"software") and verify the category is software
//	(Short-desc - "This is Second" and category -"hardware") and verify the category is not software nor inquiry
//	(Short-desc - "This is Third" and category -"inquiry") and verify the short-desc is not empty
	
	static RequestSpecification request=null;
	 static Response response=null;
	 
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
	@When("post the request with short description  as {string} and category as {string}")
	public void addBodyInPost(String short_desc , String category) {
	response = request.body("{\"short_description\":\"" + short_desc + "\",\"category\":\"" + category + "\"}").post("incident");
	
	}
	@Then("validate the response for below")
	public void validateResposeStringForMulti(DataTable dt) {
		Map<String,String> validation_data = dt.asMap();
		for (Entry<String,String> eachEntry : validation_data.entrySet()) {
			response.then().body(eachEntry.getKey(), Matchers.containsString(eachEntry.getValue()));
			//equalTo(eachEntry.getValue()));
		}
	}
	}


