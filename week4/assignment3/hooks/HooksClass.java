package week4.assignment3.hooks;

import io.cucumber.java.Before;

import io.restassured.RestAssured;
public class HooksClass {
	
	@Before
	 public void setEndpoint() {
		 RestAssured.baseURI="https://dev120185.service-now.com/api/now/v1/table/incident";
         RestAssured.authentication = RestAssured.basic("admin", "6DnO8-FiAzk/");
	}
}
