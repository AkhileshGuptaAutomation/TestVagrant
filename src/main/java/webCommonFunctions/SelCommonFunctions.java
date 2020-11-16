package webCommonFunctions;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

public class SelCommonFunctions {
	
	private WebDriver driver;
	
	public SelCommonFunctions(WebDriver driver){
		
		this.driver = driver;
		
	}
	
	public void ClickOnObject(WebElement ele){
		
		ele.click();
		
	}
	
    public String getObjectText(WebElement ele){
		
		return ele.getText();
		
	}

    public void waitForObject(String locator){
    	FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
    		       .withTimeout(60, TimeUnit.SECONDS)
    		       .pollingEvery(2, TimeUnit.SECONDS)
    		       .ignoring(NoSuchElementException.class);
    	 
    			WebElement element = wait.until(new Function<WebDriver, WebElement>() {
    				public WebElement apply(WebDriver driver) {
    					WebElement element = driver.findElement(By.xpath(locator));
    						return element;
    					}
    			});
    		}
    
   
}
