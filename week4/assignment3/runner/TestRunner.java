package week4.assignment3.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features="src/test/java/week4/assignment3/features/Incident.feature",
		glue={"week4.assignment3.steps","week4.assignment3.hooks"})

public class TestRunner extends AbstractTestNGCucumberTests{
}
//Assignment 3(cucumber) - Create, update and delete incident using scenarios (use hooks) 
//Create	
//	- status code Validation
//	- task_effective_number is 10 digits
//update the description with 6 digit random alphanumeric
//	- status code verification
//	- verify the description is updated with the 6 digit random alphanumeric
//delete 
//	- status code verification
//	- validate the record is removed from the system
	

	



