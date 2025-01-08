package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = "src/test/featureFiles"
        ,glue= "stepDefinition",
        dryRun = false,
        monochrome = true,
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
//        plugin = {"html:target/cucumber.html"},
        tags= "@login")



public class TestngRunner extends AbstractTestNGCucumberTests {
}
