package coolschool.PageOModel;

import org.testng.annotations.Test;

import PageBlueprints.CookiePage;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class CookiesTest extends Start{

	CookiesTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeTest
	public void prepare() throws IOException {
		
		dr = driverInit();
		dr.get(prop.getProperty("url"));
		dr.manage().window().maximize();
	}
	
	@Test
	public void assertCookies() throws InterruptedException  {
		
		
		Set<Cookie> cooks = dr.manage().getCookies() ;		
		System.out.println(cooks.size());
		
		Iterator<Cookie> circ = cooks.iterator() ;
		Cookie next;
		
		while(circ.hasNext()) {
			
		
			next = circ.next() ;
			System.out.println(next.getName() );
			Assert.assertNotEquals("EuConsent", next.getName());
			
		}
		
		
		CookiePage cp = new CookiePage(dr);
		
		Thread.sleep(3000);
		cp.getCookiesBtn().click();
		
		cooks = dr.manage().getCookies() ;		
		System.out.println(cooks.size());		
		circ = cooks.iterator() ;
		
		while(circ.hasNext()) {
			
			
			next = circ.next();
			System.out.println(next.getName() + " " + next.getValue());
			
		}
		
		Assert.assertEquals(dr.getTitle(), "Yahoo");
	}
	
	@AfterTest
	public void goodBye() {
		
		dr.close();
		dr = null;
	}
}
