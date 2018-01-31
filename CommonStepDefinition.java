package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CommonStepDefinition extends AbstractPageStepDefinition {
	WebDriver driver = getDriver();
	
	@Given("^Launch the URL$")
	public void launch_the_URL() throws Throwable {
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\janaranjani.m\\Downloads\\CucumberPoC\\CucumberPoC\\jars\\geckodriver.exe");
		//driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//driver=new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		 driver.get("http://f1bde196.ngrok.io");
	}

	//@Then("^Close the application$")
	//public void close_the_application() throws Throwable {
	  // driver.close();
	//}
}
