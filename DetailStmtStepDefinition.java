package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DetailStmtStepDefinition extends AbstractPageStepDefinition{
	
	WebDriver driver = getDriver();
	
	private CharSequence sDate = "01/25/2018";
	private CharSequence sFromDate = "02/25/2018";
	private CharSequence sToDate = "01/25/2017"; 

	@When("^Click on Detail statement TAB$")
	public void click_on_Detail_statement_TAB() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Detail Statement')]")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@Then("^Default Detail statement should get generated successfully$")
	public void default_Detail_statement_should_get_generated_successfully() throws Throwable {
		if (driver.findElement(By.className("table-container")).isDisplayed())
		{
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			System.out.println("Detailed statement  is displayed");
		}
	}

	/*@Then("^Validate the Detailed statement against the data from DB$")
	public void validate_the_Detailed_statement_against_the_data_from_DB() throws Throwable {
	  //Add validation od DB against the UI data  
	}*/

	@Then("^Detailed statement should get generated for valid transaction dates$")
	public void detailed_statement_should_get_generated_for_valid_transaction_dates() throws Throwable {
	    driver.findElement(By.xpath("//input[contains(text(),'date')]")).sendKeys(sDate );
	    {
			System.out.println("Detailed statement is displayed");
		}
	}

	/*@Then("^provide Future date in From date$")
	public void provide_Future_date_in_From_date() throws Throwable {
		driver.findElement(By.xpath("//input[contains(text(),'date')]")).sendKeys(sFromDate  );
	    {
			System.out.println("Detailed statement is not displayed");
		}
	}*/

	/*@Then("^there should not be any transactions shown$")
	public void there_should_not_be_any_transactions_shown() throws Throwable {
	    //No Transactions found!
	if (driver.findElement(By.className("rt-noData")).isDisplayed()){
		System.out.println("'No Transactions found!' message is displayed as there is not data when future date is provided i From  date");
	}
	}

	@Then("^Provide TO date lesser to FROM date$")
	public void provide_TO_date_lesser_to_FROM_date() throws Throwable {
		driver.findElement(By.xpath("//input[contains(text(),'date')]")).sendKeys(sToDate  );
	    {
			System.out.println("Detailed statement is not displayed");
		}
	    	}

	@Then("^Verify the detailed statement generated against data from DB$")
	public void verify_the_detailed_statement_generated_against_data_from_DB() throws Throwable {
	    //Add code to verify the data from DB
	}
*/
	@Then("^verify the Next and Previous Button works as expected$")
	public void verify_the_Next_and_Previous_Button_works_as_expected() throws Throwable {
		if (driver.findElement(By.className("next")).isEnabled()) {
	    {
	    	driver.findElement(By.className("next")).click();
	    	System.out.println("User is able to click on Next button");
		}
	    	}
		if (driver.findElement(By.className("previous")).isEnabled()) {
		    {
		    	driver.findElement(By.className("previous")).click();
		    	System.out.println("User is able to click on previous button");
			}
		    	}
	}
}
