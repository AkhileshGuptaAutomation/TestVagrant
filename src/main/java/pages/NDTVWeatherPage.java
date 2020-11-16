package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class NDTVWeatherPage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//div[text()='Lucknow']/preceding-sibling::div/span[1]")
	public WebElement iconLucknowWithTemp;
	@FindBy(xpath="//span[contains(text(),'Lucknow, Uttar Pradesh')]")
	public WebElement WeatherDetail_lucknow;
	@FindBy(xpath="//b[contains(text(),'Condition')]")
	public WebElement WeatherDetail_Condition;
	@FindBy(xpath="//b[contains(text(),'Wind')]")
	public WebElement WeatherDetail_Wind;
	@FindBy(xpath="//b[contains(text(),'Humidity')]")
	public WebElement WeatherDetail_Humidity;
	@FindBy(xpath="//b[contains(text(),'Temp in Degrees')]")
	public WebElement WeatherDetail_TempInDegrees;
	@FindBy(xpath="//b[contains(text(),'Temp in Fahrenheit')]")
	public WebElement WeatherDetail_TempInFahrenheit;
	
	
	public NDTVWeatherPage(WebDriver driver1){
		
		driver = driver1;	
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void waitForWeatherPageToLoad(){
		
		new WebDriverWait(driver, 20).until(new ExpectedCondition<Boolean>() {
		      public Boolean apply(WebDriver d) {
		        return (((org.openqa.selenium.JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
		      }
		    });
		
	}
	
	public String getTempValueAndClickOnLucknowTempIcon(){
		
		String tempValue = iconLucknowWithTemp.getText();
	   	iconLucknowWithTemp.click();
	    try {Thread.sleep(2000);} catch (InterruptedException e) {}
	   	return tempValue;	
	}
	
	public void verifyAllWeatherLucknowDetailsDisplayed(){
		
		boolean isFound = WeatherDetail_lucknow.isDisplayed();
		Assert.assertTrue(isFound,"Failed : Lucknow, UP is not displayed");
		isFound = WeatherDetail_Condition.isDisplayed();
		Assert.assertTrue(isFound,"Failed : Condition detail is not displayed");
		isFound = WeatherDetail_Wind.isDisplayed();
		Assert.assertTrue(isFound,"Failed :  Wind detail is not displayed");
		isFound = WeatherDetail_Humidity.isDisplayed();
		Assert.assertTrue(isFound,"Failed : Humidity detail is not displayed");
		isFound = WeatherDetail_TempInDegrees.isDisplayed();
		Assert.assertTrue(isFound,"Failed : Temp In Degrees is not displayed");
		isFound = WeatherDetail_TempInFahrenheit.isDisplayed();
		Assert.assertTrue(isFound,"Failed : Temp In Fahrenheit is not displayed");
		
	}
	

}
