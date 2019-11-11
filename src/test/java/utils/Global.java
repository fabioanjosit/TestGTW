package utils;

import static org.junit.Assert.assertTrue;
import static utils.Helper.getDateHour;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Global.Identify;


	public class Global extends Setup{

		public Global() {
			// TODO Auto-generated constructor stub
		}

		public enum Identify {
			ID, NAME, XPATH, LINKTEXT, CSS, CLASSNAME;
		}

		public enum Technology {
			SELENIUM_WEB, APPIUM;
		}
		Actions action = new Actions(driver);

		public void fillField(Identify by, String identify_value, String value) {

			WebElement webElement = getElementApplication(by, identify_value);
			webElement.sendKeys(value);
		}

		public String getField(Identify by, String identify_value) {

			WebElement webElement = getElementApplication(by, identify_value);
			return webElement.getText();
		}

		
		public void clickButton(Identify by, String identify_value) {

			WebElement webElement = getElementApplication(by, identify_value);
			webElement.click();
		}

		public void selectComboBox(Identify by, String identify_value, String value) {

			WebElement comboBox = getElementApplication(by, identify_value);
			Select combo = new Select(comboBox);
			combo.selectByVisibleText(value);
		}

		public boolean waitElementVisible(Identify by, String identify_value, int seconds) {

			WebDriverWait wait = new WebDriverWait(driver, seconds);

			try {

				switch (by) {

				case ID:
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(identify_value)));
					break;

				case NAME:
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(identify_value)));
					break;

				case XPATH:
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(identify_value)));
					break;

				case LINKTEXT:
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(identify_value)));
					break;

				case CSS:
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(identify_value)));
					break;

				case CLASSNAME:
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(identify_value)));
					break;

				default:
					break;
				}

			} catch (Exception e) {
				return false;
			}

			return true;
		}

		public boolean elementExist(Identify by, String identify_value, int seconds) {

			List<WebElement> elementos = null;

			for (int i = 0; i < seconds; i++) {

				switch (by) {

				case ID:
					elementos = driver.findElements(By.id(identify_value));
					break;

				case NAME:
					elementos = driver.findElements(By.name(identify_value));
					break;

				case XPATH:
					elementos = driver.findElements(By.xpath(identify_value));
					break;

				case LINKTEXT:
					elementos = driver.findElements(By.linkText(identify_value));
					break;

				case CSS:
					elementos = driver.findElements(By.cssSelector(identify_value));
					break;

				case CLASSNAME:
					elementos = driver.findElements(By.className(identify_value));
					break;

				default:
					break;
				}

				if (elementos.size() > 0)
					return true;

				wait(1);
			}

			return false;
		}

		public void wait(int seconds) {

			try {
				Thread.sleep(seconds * 1000);
			} catch (Exception e) {
			}
		}

		public WebElement getElementApplication(Identify by, String identify_value) {
			WebElement webElement = null;

			try {

				switch (by) {

				case ID:
					webElement = driver.findElement(By.id(identify_value));
					break;

				case NAME:
					webElement = driver.findElement(By.name(identify_value));
					break;

				case XPATH:
					webElement = driver.findElement(By.xpath(identify_value));
					break;

				case LINKTEXT:
					webElement = driver.findElement(By.linkText(identify_value));
					break;

				case CSS:
					webElement = driver.findElement(By.cssSelector(identify_value));
					break;

				case CLASSNAME:
					webElement = driver.findElement(By.className(identify_value));
					break;

				default:
					break;
				}

			} catch (Exception e) {
				Assert.fail("Elemento '" + identify_value + "' N�O encontrado.");
			}

			return webElement;
		}

		public boolean checkElement(String xpath) {
			try {
				return driver.findElement(By.xpath(xpath)).isDisplayed();

			} catch (Exception e) {
				return false;
			}
		}
		
		public boolean waitElement(String xpath) {
			
			WebDriverWait aguardar = new WebDriverWait(driver, 10);
			return aguardar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).isDisplayed();
//			return aguardar.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).isDisplayed();					
		}
		
		
		public void PageUP(String textLink){				
			try {
				action.moveToElement(getElementApplication(Identify.NAME,textLink));
				action.sendKeys(Keys.PAGE_UP).build().perform();
			} catch (Exception e) {			
				assertTrue("Não encontrou o Xpath (pageup) no Link ' " +textLink.toString() + " '", false);			
			}

		}
		
		public void screanshot(String path) {

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			try {
				FileUtils.copyFile(scrFile, new File(path + "\\" + getDateHour() + ".png"));
			} catch (Exception e) {
				Assert.fail("Erro ao gerar o Screenshot '" + path + "'.");
			}
		}
	
}
