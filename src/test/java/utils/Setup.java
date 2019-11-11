package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import utils.Setup.IdentifyNav;

public class Setup {

	public Setup() {
		// TODO Auto-generated constructor stub
	}
	public enum IdentifyNav {
		CHROME, IE, FIREFOX;
	}

	public static WebDriver driver;

	public static WebDriver setUp(WebDriver driver, IdentifyNav by, String url) {	

		switch (by) {
		
			case CHROME:
				System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
				driver = new ChromeDriver();					
			break;
	
			case IE:
				System.setProperty("webdriver.ie.driver", "src\\test\\resources\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();				
			break;
				
			case FIREFOX:
				System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
				driver = new FirefoxDriver();	
			break;			
			
			default:			
				System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
				driver = new ChromeDriver();
			break;									
		}
	
		driver.manage().window().maximize();			
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}

	public Setup(WebDriver driver) {
		Setup.driver = driver;
	}
	
	
	
}

