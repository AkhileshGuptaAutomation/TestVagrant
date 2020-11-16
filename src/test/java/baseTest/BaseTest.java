package baseTest;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
	
	static public WebDriver driver;
	static public Properties config;
	static public Properties ObjectRepo;
	static public FileInputStream fis ;
	static public FileInputStream locator ;
	
	@BeforeMethod
	public void init() throws IOException{
		
		String userPath = System.getProperty("user.dir");
		
		config = new Properties(); 
		ObjectRepo = new Properties(); 
		
		System.out.println(userPath);
		
		fis = new FileInputStream(userPath+"\\Config\\config.properties");
		
		config.load(fis);
		
		String browserValue = config.getProperty("browser");
		
		System.out.println(browserValue);
		
		if(browserValue.equalsIgnoreCase("firefox")){
			
			System.setProperty("webdriver.gecko.driver", userPath+"\\Driver\\geckodriver.exe");
			
			driver = new FirefoxDriver();		
		}
		
		else if(browserValue.equalsIgnoreCase("Chrome")){
			
			System.setProperty("webdriver.chrome.driver", userPath+"\\Driver\\chromedriver.exe");
		
		    driver = new ChromeDriver();
		    
		}
		
		else if(browserValue.equalsIgnoreCase("ie")){
			
			System.setProperty("webdriver.ie.driver", userPath+"\\Driver\\IEDriverServer.exe");
			
		    driver = new InternetExplorerDriver();
		}
		
		String url = config.getProperty("url");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		driver.get(url);
		
		
				
	}
	
	
	@AfterMethod
	public void closeBrowser(){
		
		driver.quit();
		
	}
	
	
	

}
