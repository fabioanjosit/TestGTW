package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Global.Identify;

public class Helper extends Setup{

	public Helper(WebDriver driver) {
		super(driver);
	}
	Global global = new Global();
	
	public Helper() {
		// TODO Auto-generated constructor stub
	}

	public static String getDateHour() {
		
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
		return dateFormat.format(date);
	}
	
	public static void aguardar_elemento(WebElement elemento, int timeout) { 
		
		WebDriverWait aguardar = new WebDriverWait(Hooks.get_driver(), timeout);
		aguardar.until(ExpectedConditions.visibilityOf(elemento));
	}
	
	public static boolean elemento_existe(WebElement elemento, int timeout) { 
		try {			
			aguardar_elemento(elemento, timeout);
			return true;			
		} catch (Exception e) {
			System.out.println("O elemento não encontrado. Segue Mensagem:");
			System.out.println(e.getMessage());
			return false;
		}		
	}
	
	public void click_remove_frame() throws InterruptedException {
		
		if (Helper.elemento_existe(global.getElementApplication(Identify.XPATH,"//iframe[@name='chat-widget']"), 10)) {
			driver.switchTo().defaultContent();
			//driver.switchTo().frame("chat-widget");
			//global.clickButton(Identify.XPATH,"//iframe[@name='chat-widget']");
		}
	}
	
	public static String removerCaracteresEspeciais(String string) {
		String normalizada="";
		string = Normalizer.normalize(string, Normalizer.Form.NFD);
        string = string.replaceAll("[^\\p{ASCII}]", "");
        string = string.replace("-", "");
        string = string.replace(".", "");
        string = string.replace("'", "");
        string = string.replace("´", "");
        string = string.replace("`", "");
        string = string.replace("ç", "c");
        for(int x=0; x < string.length(); x++){
    		switch (string.charAt(x)) {
    		case 'á':
    		case 'â':
    		case 'à':
    		case 'ã':
    		case 'ä':
    				normalizada+="a";				
    			break;
    		
    		case 'é':
    		case 'ê':
    		case 'è':
    		case 'ë':
    				normalizada+="e";				
    			break;

    		case 'í':
    		case 'î':
    		case 'ì':
    		case 'ĩ':
    		case 'ï':
    				normalizada+="i";				
    			break;
    		case 'ó':
    		case 'ô':
    		case 'ò':
    		case 'õ':
    		case 'ö':
    				normalizada+="o";				
    			break;
    			
    		case 'ú':
    		case 'û':
    		case 'ù':
    		case 'ũ':
    		case 'ü':
    				normalizada+="u";				
    			break;
    			
    		default:
    				normalizada+=string.charAt(x);
    			break;
    		}
        }
        
        return normalizada;
    }
	
}