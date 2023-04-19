package week4.assignment1.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features="src/test/java/week4/assignment1/features/CreateIncident.feature",
		glue="week4.assignment1.steps")
public class TestRunner extends AbstractTestNGCucumberTests{
	
}
