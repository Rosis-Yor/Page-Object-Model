package PageBlueprints;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	private WebDriver drv;
	
	public LoginPage(WebDriver dri) {
		
		this.drv= dri;
	}
	
	By userField = By.id("login-username") ;
	By nextBtn = By.xpath("//*[@id=\"login-signin\"]") ;
	By userError = By.cssSelector("#username-error") ;
	
	public WebElement getUserField() {
		
		return drv.findElement(userField) ;
	}
	
	public WebElement nextBtn() {
		
		
		return drv.findElement(nextBtn) ;
	}
	
	public WebElement wrongMail() {
		
		return drv.findElement(userError) ;
	}
	
	public By getUserError() {
		
		return userError;
	}
	
	

}
