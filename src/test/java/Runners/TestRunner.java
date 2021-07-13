package Runners;
		
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
		
	@RunWith(Cucumber.class)
	@io.cucumber.junit.CucumberOptions(
		      features = "src/test/resources/APIAutomationTests",
		      glue = {"stepDefinitions"},
		      monochrome = true,
		      strict = true
		)
	public class TestRunner {
		
		}
