package week3.day2.servicenow;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SevicenowBaseClass {
	
	static RequestSpecification request=null;
	 static String sys_id=null;
	 static Response response=null;
	 static String incident_number = null;
	 
	@BeforeMethod
	public void setup() {
		RestAssured.baseURI = "https://dev120185.service-now.com/api/now/v1/table/";
		RestAssured.authentication = RestAssured.basic("admin", "6DnO8-FiAzk/");
		request = RestAssured.given().contentType(ContentType.JSON).log().all();
	}
	@AfterMethod
	public void tearDown() {
		response.then().log().all();
		}

}
