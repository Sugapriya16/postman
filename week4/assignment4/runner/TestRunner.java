package week4.assignment4.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features="src/test/java/week4/assignment4/features/CreateIncident.feature",
		glue="week4.assignment4.steps")
public class TestRunner extends AbstractTestNGCucumberTests{
	
}
