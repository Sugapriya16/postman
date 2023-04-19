package week4.assignment2.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features="src/test/java/week4/assignment2/features/Incident.feature",
		glue="week4.assignment2.steps",
		tags = "@IntegrationTest")

public class TestRunner extends AbstractTestNGCucumberTests{
}
	
	//Assignment 2(cucumber) - a) tag some of the already created scripts and run only those tags 
	//b) Run any two feature files from the runner
	//c) Run all the feature files from the runner
	

	



