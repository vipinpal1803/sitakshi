package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/java/features"},
		glue= {"stepDefinitions"},
		//dryRun = true,
		monochrome = true,
		//tags = "@Sanity",//scenarios under @sanity tag will be executed
				plugin = {
		                "pretty", // Single pretty plugin
		                "html:target/cucumber-reports/reports1.html",
		                "json:target/cucumber-reports/reports1.json",
		                "testng:target/cucumber-reports/reports1.xml"
		        }

		)

public class TestRunner extends AbstractTestNGCucumberTests  {
	
}
