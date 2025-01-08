package runner;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import org.testng.annotations.Listeners;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/featureFiles"
        ,glue= "stepDefinition",
        dryRun = false,
        monochrome = true,
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
//        plugin = {"html:target/cucumber.html"},
        tags= "@login"
)
public class TestRunner {
}
