package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import utils.Helper;
import utils.Setup;
import utils.Setup.IdentifyNav;

import page.home_fakenamegeneratorPage;
import page.home_Google;

@FixMethodOrder
public class CadastroContaGmailTest {


	public WebDriver driver;
	private String[] arrayNome;

	@Before
	public void createBrowser() {
		driver = Setup.setUp(driver, IdentifyNav.CHROME, "https://www.fakenamegenerator.com");
	}
	
	@Test
	public void fakenamegenerator_contaGmail() {
		home_fakenamegeneratorPage home_fng = new home_fakenamegeneratorPage(driver);
		
		home_fng.selecionar_gender("Male");
		home_fng.selecionar_nameSet("Arabic");
		home_fng.selecionar_country("Portugal");
		
		home_fng.click_generate();
		
		arrayNome = home_fng.NameComplete();
		driver.quit();
		
		//Abrir nova janela com url de cadastro no gmail.com
		driver = Setup.setUp(driver, IdentifyNav.CHROME, "https://accounts.google.com/signup/v2/webcreateaccount?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F%3Fpc%3Dtopnav-about-n-en&flowName=GlifWebSignIn&flowEntry=SignUp");
		//Helper helper = new Helper();
		home_Google home_google = new home_Google(driver);
		home_google.preencher_first_name(arrayNome[0]);

		String lastName = "";
        for (int i=1; i< arrayNome.length; i++)
        {
            lastName = lastName + " " + arrayNome[i];
        }
        home_google.preencher_last_name(lastName);
        
        String username = (arrayNome[0] + lastName).replace(" ", "").toLowerCase();
        username = Helper.removerCaracteresEspeciais(username);
        
        home_google.preencher_username(username);
        
        home_google.preencher_passwd("w1s31234");
        home_google.preencher_ConfirmPasswd("w1s31234");
        home_google.click_proxima();
        
        home_google.preencher_phoneNumberId("11 11111111");
        home_google.click_proxima2();
        
        Assert.assertTrue("Mensagem de número inválido não foi exibida",home_google.valida_telefone_invalido());
	}

	@After
	public void tearDown() {
		driver.quit();
	}		
}
