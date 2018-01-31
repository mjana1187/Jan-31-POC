package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbstractPageStepDefinition {
	protected static WebDriver driver;
	protected WebDriver getDriver(){
		if (driver == null){
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		return driver;
	}

}
