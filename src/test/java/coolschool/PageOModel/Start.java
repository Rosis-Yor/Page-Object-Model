package coolschool.PageOModel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Start {
	
	public static WebDriver dr; 
	public Properties prop ; 
	
	Start() throws IOException, FileNotFoundException {
		
		String currentDir = System.getProperty("user.dir");
        
		prop = new Properties();
		FileInputStream fis = new FileInputStream(currentDir + "\\src\\main\\java\\resources\\opData.properties");
		prop.load(fis);
	}
	
	public WebDriver driverInit() throws IOException {	
		
		
		switch(prop.getProperty("browser")) {
		
			case "chrome" :
				
				System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");				
				dr = new ChromeDriver();
				break;
				
			case "firefox" :
				
				System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");				
				dr = new FirefoxDriver();
				break;
				
			case "edge" :
				
				System.setProperty("webdriver.edge.driver", "C:\\Selenium\\MicrosoftWebDriver.exe");				
				dr = new EdgeDriver();
				break;
				
			}
		
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
		return dr;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Start st = new Start();
		
		WebDriver drv = st.driverInit();
		
		
		
		
		
		String url = st.prop.getProperty("url") ;
		
		drv.get(url);
		System.out.println(dr.getTitle());
		
		
		
      

	}

}
