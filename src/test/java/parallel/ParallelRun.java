package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/",
				"rerun:target/failedrun.txt"
				}, 
		tags="not @Skip",
		monochrome = true,
		glue = { "parallel", "appHooks" },
		features = { "src/test/resources/parallel" }
)

public class ParallelRun extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider
	public Object[][] scenarios() {
		return super.scenarios();
	}
}