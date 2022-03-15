package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features",
        glue = {"StepDefinition"},
        monochrome = true,
        plugin = {"pretty","html:test-output","json:target/JSONReports/report.json","html:target/HtmlReports"},
        tags = "@login")
public class Runner {


}
