package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="features",glue={"stepDefinition"},
				plugin={"html:target/cucumber-html-report","json:target/cucumber.json",
						"pretty:target/cucumber-pretty.text","usage:target/cucumber-usage.json",
						"junit:target/cucumber-results.xml"})

public class TestRunner {

}
