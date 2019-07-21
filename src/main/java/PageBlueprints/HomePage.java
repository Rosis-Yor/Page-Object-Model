package PageBlueprints;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	private WebDriver drv;
	
	public HomePage(WebDriver dri) {
		
		this.drv = dri ;
	}
	
	By mailBtn = By.cssSelector("a#uh-signin") ;
	
	public WebElement clickMail() {
		
		return drv.findElement(mailBtn) ;
	}

}
