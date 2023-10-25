package stepDefinition;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features", // Path to your feature files
    glue = "stepDefinition", // Package where your step definitions are located
    tags = "@GetRequest or @PostRequest", // Tags to include/exclude scenarios
    plugin = {"pretty", "html:target/cucumber-reports"} // Report formats
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
