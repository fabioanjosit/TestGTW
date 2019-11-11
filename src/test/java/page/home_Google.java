package page;

import org.openqa.selenium.WebDriver;

import utils.Global;
import utils.Global.Identify;
import utils.Setup;

public class home_Google  extends Setup  {
	public home_Google (WebDriver driver) { 
		super(driver);		
	}
	
	Global global = new Global();	
	
	public void preencher_first_name(String firstName) { 
		global.fillField(Identify.XPATH,"//input[@id='firstName']",firstName);
	}
	
	public void preencher_last_name(String lastName) { 
		global.fillField(Identify.XPATH,"//input[@id='lastName']",lastName);
	}
	
	// nome + sobrenome
	public void preencher_username(String username) { 
		global.fillField(Identify.XPATH,"//input[@id='username']",username);
	}
	
	public void preencher_passwd(String passwd) { 
		global.fillField(Identify.XPATH,"//input[@name='Passwd']",passwd);
	}
	
	public void preencher_ConfirmPasswd(String ConfirmPasswd) { 
		global.fillField(Identify.XPATH,"//input[@name='ConfirmPasswd']",ConfirmPasswd);
	}
	
	//click proxima
	public void click_proxima() { 
		global.clickButton(Identify.XPATH,"//span[contains(text(),'Próxima')]");
	}
	
	//Numero de telefone inválido
	public void preencher_phoneNumberId(String phoneNumberId) { 
		global.fillField(Identify.XPATH,"//input[@id='phoneNumberId']",phoneNumberId);
	}
	
	//click proxima
	public void click_proxima2() {
		global.clickButton(Identify.XPATH, "//span[contains(text(),'Próxima')]");
	}

	public boolean valida_telefone_invalido() {
		return global.elementExist(Identify.XPATH,
				"//div[contains(text(),'Este formato de número de telefone não é válido. Verifique o país e o número')]",
				20);
	}
	
	
	
}
