package coolschool.PageOModel;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageBlueprints.CookiePage;
import PageBlueprints.HomePage;

public class MailNavigationTest extends Start{
	
	MailNavigationTest() throws IOException {
		
		super();
	}
	
	WebDriver dr;
	
	@BeforeTest
	public void prepare() throws IOException {
		
		dr = driverInit();
		dr.get(prop.getProperty("url"));
		dr.manage().window().maximize();
	}
	
	
	@Test
	public void goToMail() {
		
		CookiePage cp = new CookiePage(dr);
		cp.getCookiesBtn().click();
		
		HomePage hp = new HomePage(dr);
		hp.clickMail().click();
		Assert.assertEquals(dr.getTitle(), "Yahoo - login");
		System.out.println(dr.getTitle());
	}
	
	@AfterTest
	public void goodBye() {
		
		dr.close();
		dr = null ;
	}

}
