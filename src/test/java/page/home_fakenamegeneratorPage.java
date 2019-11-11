package page;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;

import utils.Global;
import utils.Setup;
import utils.Global.Identify;

public class home_fakenamegeneratorPage extends Setup{
	
	public home_fakenamegeneratorPage (WebDriver driver) { 
		super(driver);		
	}
	Global global = new Global();	

	public void selecionar_gender(String gender) { 
		global.selectComboBox(Identify.XPATH, "//select[@id='gen']", gender);
	}
	
	public void selecionar_nameSet(String nameSet) { 
		global.selectComboBox(Identify.XPATH, "//select[@id='n']", nameSet);
	}

	public void selecionar_country(String country) { 
		global.selectComboBox(Identify.XPATH, "//select[@id='c']", country);
	}
	
	public void click_generate() { 
		global.clickButton(Identify.XPATH,"//input[@id='genbtn']");
	}

	public String[] NameComplete(){
		String[] nameSeparado = global.getField(Identify.XPATH, "//div[contains(@class,'address')]//following::h3").split(" ");
		return nameSeparado;
	}
	
	
}
