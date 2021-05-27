package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	//features=".//Features/Login.feature",
	//features=".//Features/Customers1.feature",
	//features=".//Features/", // how to run all features files 
	features= {".//Features/Login.feature",".//Features/Customers1.feature"},
		glue="StepDefinitions",
		//dryRun=true,
		dryRun=false,
		monochrome = true,
		plugin= {"pretty","html:test-output"},
	tags= {"@sanity"}
	//tags={"@sanity , @regression"] or 
		)
public class TestRun {

}
