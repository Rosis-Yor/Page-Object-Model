package PageBlueprints;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CookiePage {
	
	public WebDriver drv;
	
	By acceptCookies = By.cssSelector("button.btn.primary") ;
	
	public CookiePage(WebDriver dri) {
		
		this.drv = dri;
	}
	
	public WebElement getCookiesBtn() {
		
		return drv.findElement(acceptCookies);
	}

}
