package runner;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/featureFiles"
        ,glue="stepDefinition",
        dryRun = false,
        monochrome = true,
        plugin = {"pretty", "html:target/report_html.html","json:target/report_json.json","junit:target/report_xml.xml"},
        tags= "@login"
)
public class TestRunner {
}
