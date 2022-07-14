package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/MegaDesktopAppDownload.feature"}, 
glue = {"stepDefinitions"}, 
monochrome = true,
plugin = { "pretty", "html:target/cucumber-reports" }
		)
public class MegaDesktopRunner {

}