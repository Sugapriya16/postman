package week3;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AssignmentDay1 {
	
	 @Test(priority =1 )
		public void AllIncident() {

		RestAssured.baseURI = "https://dev120185.service-now.com/api/now/v1/table/incident";    
	      RestAssured.authentication = RestAssured.basic("admin", "6DnO8-FiAzk/");	      
	      Response response = RestAssured.get();	      
	      response.prettyPrint();

		}
	 @Test(priority =2 )
	 public void AllIncidentWithQueryParams() {
		
			RestAssured.baseURI = "https://dev120185.service-now.com/api/now/v1/table/incident";
	        
	      RestAssured.authentication = RestAssured.basic("admin", "6DnO8-FiAzk/");
	      Map<String,String> queryMap = new HashMap<String,String>();
			queryMap.put("sysparm_fields", "sys_id,category");
			queryMap.put("category", "hardware");
			RequestSpecification inputRequest = RestAssured.given()
					   .contentType(ContentType.JSON)
					   .queryParams(queryMap);
	      
	      Response response = inputRequest.get();
	      
	      response.prettyPrint();

		}
	 @Test(priority =3)
	 public void CreateIncidentWithString() {
		 RestAssured.baseURI = "https://dev120185.service-now.com/api/now/v1/table/incident";       

	      RestAssured.authentication = RestAssured.basic("admin", "6DnO8-FiAzk/");
	      RequestSpecification inputRequest = RestAssured
	    		  .given()
	    		  .contentType(ContentType.JSON)
	    		  .body("{\r\n"
	    		  		+ "    \"description\": \"My first test with Rest Assured\",\r\n"
	    		  		+ "    \"short_description\" : \"Success\"	\r\n"
	    		  		+ "}");
	      
	      Response response = inputRequest.post();	     
	      String sys_id = response.jsonPath().getString("result.sys_id");
	      System.out.println(sys_id);
	      response.prettyPrint();
	 
	 }
	
	 @Test(priority =4 )
	 public void CreateIncidentWithFile() {
		 RestAssured.baseURI = "https://dev120185.service-now.com/api/now/v1/table/incident";
		 
		 File file = new File("./src/test/resources/data.json");

	      RestAssured.authentication = RestAssured.basic("admin", "6DnO8-FiAzk/");
	      RequestSpecification inputRequest = RestAssured
	    		  .given()
	    		  .contentType(ContentType.JSON)
	    		  .body(file);
	      
	      Response response = inputRequest.post();
	      
	      response.prettyPrint();
	 
	 }

}
