package utils;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.Setup.IdentifyNav;

public class Hooks {
	
	private static WebDriver driver;

		
	@Before
	public void start_test(Scenario scenario) {
		driver = Setup.setUp(driver, IdentifyNav.CHROME, "https://www.fakenamegenerator.com/");
	}	
	
	@After
	public void tear_down(Scenario scenario) { 
		driver.quit();
	}
		
	public static WebDriver get_driver() { 
		return driver;
	}

}
