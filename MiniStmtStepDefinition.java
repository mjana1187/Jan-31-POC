package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MiniStmtStepDefinition extends AbstractPageStepDefinition{
	WebDriver driver = getDriver();
	@When("^Click on Mini statement TAB$")
	public void click_on_Mini_statement_TAB() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Mini Statement')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	   
	}

	@Then("^Mini statement should get generated successfully$")
	public void mini_statement_should_get_generated_successfully() throws Throwable {
		driver.findElement(By.className("table-container")).isDisplayed();
		//Need to validate the Database with the statement on the UI
	}
	
	@Then("^Validate the mini statement generated against the data from DB$")
	public void validate_the_mini_statement_generated_against_the_data_from_DB() throws Throwable {
	    
	}
}
