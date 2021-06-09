package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
		(
				//features="Features/DataDrivenExamples.feature",
				//features="Features/Login.feature",
				features="Features/Tagging.feature",
				glue="stepDefinations",
				dryRun=false,
				monochrome=true,
				plugin= {"pretty","html:test-output"},
				 tags = "@SmokeTest or @End2End or @RegressionTest"
				
				
		)

public class testRun {

	
	
}


