package week5.assignment1;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class IncidentWithFiles {
	
	 @Test (dataProvider="FetchData")
	public void CreateIncident(File Filename) {
		RestAssured.baseURI = "https://dev158367.service-now.com/api/now/v1/table/";
			RestAssured.authentication = RestAssured.basic("admin", "wFN*%0q8oUaW");
				RequestSpecification request = RestAssured
						.given()
						.contentType(ContentType.JSON)
						.body(Filename);	
				Response response = request.post("incident");
				response.prettyPrint();
	 }
		
		@DataProvider(name="FetchData")
		public File[] sendData() {
			//folder path
			File folder = new File("./src/test/resources/BodyData");
			//getting list of files in folder(3 files in folder)
			File[] listOfFiles = folder.listFiles();
			//creating object 
			 File data[]= new File[listOfFiles.length];
			 int i=0;
			 //getting each file from for each loop
			 for (File file : listOfFiles) {
				data[i] = file;
				i++;
			 }
			 return data;
			
				 
		}
}
