package week3.day2.jira;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JiraBaseClass {
	static RequestSpecification request=null;
	 static String key=null;
	 static Response response=null;
	@BeforeMethod
	public void setup() {
		RestAssured.baseURI = "https://sugapriyams.atlassian.net/rest/api/3/";
		RestAssured.authentication = RestAssured.preemptive().basic("sugapriyams16@gmail.com", "ATATT3xFfGF0SJCfhwgA0L4yCzkBg-8pYCbuEMOU46dKdn2txd3l2zXg9KfFK20b7Owgf72IveZQqZ6fvLG1HZwibOLuCDfStbPY19iiyLFoe1uyD24XzeUfZtYfSvsmHV1OqpG143VFGNuvrvONAnTcPP6f3DRDnqUEVEK7-tlnvtzFnEzG2BE=353A00ED");
		request = RestAssured.given().contentType(ContentType.JSON).log().all();
	}
	@AfterMethod
	public void tearDown() {
		response.then().log().all();
		}

}
