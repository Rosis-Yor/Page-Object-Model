package coolschool.PageOModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageBlueprints.CookiePage;
import PageBlueprints.HomePage;
import PageBlueprints.LoginPage;

public class LoginTest extends Start {

	LoginTest() throws IOException, FileNotFoundException {
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
	public void wrongMailMessage() throws InterruptedException, IOException {
		
		CookiePage cp = new CookiePage(dr) ;
		cp.getCookiesBtn().click();
		
		HomePage hp = new HomePage(dr) ;
		hp.clickMail().click();
		
		LoginPage lp = new LoginPage(dr) ;
		
		
		
		lp.getUserField().sendKeys("rosi@rosi.com");
		lp.nextBtn().submit();
		
		System.out.println(dr.getTitle());	
		
		// Thread.sleep(3000);
		
		WebDriverWait pause = new WebDriverWait(dr, 5);
		pause.until(ExpectedConditions.visibilityOfElementLocated(lp.getUserError()));
		 
		 String msg = lp.wrongMail().getText() ;
	
		Assert.assertTrue(msg.contains("Sorry, we don't re") );
		
		File src=	 ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(src,new File(currentDir + "\\src\\main\\java\\resources\\screenshot.png"));
		System.out.println(msg);
		
		
	}
	
	@AfterTest
	public void goodBye() {
		
		dr.close();
		dr = null;
	}

}
