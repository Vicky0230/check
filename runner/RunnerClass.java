package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		dryRun=false,
		features= {"src/test/java/features/home.feature"},
		glue= {"assignment_home","hooks"},
		monochrome=true)
	
		
public class RunnerClass extends AbstractTestNGCucumberTests
{

}
