package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SmokeTest {
	WebDriver driver;
	@Given("^Launch the URl$")
	public void launch_the_URl() throws Throwable {
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\janaranjani.m\\Downloads\\CucumberPoC\\CucumberPoC\\jars\\geckodriver.exe");
		//driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		 driver.get("http://f1bde196.ngrok.io");
	}

	@When("^Click on Mini statement TAB$")
	public void click_on_Mini_statement_TAB() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Mini Statement')]")).click();
	   
	}

	@Then("^Mini statement should get generated successfully$")
	public void mini_statement_should_get_generated_successfully() throws Throwable {
		driver.findElement(By.className("table-container")).isDisplayed();
		//Need to validate the Database with the statement on the UI
	}
	@Then("^Close the application$")
	public void close_the_application() throws Throwable {
	    driver.close();
	}
}
