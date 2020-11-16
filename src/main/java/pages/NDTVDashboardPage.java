package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NDTVDashboardPage {

	public WebDriver driver;

	@FindBy(id = "h_sub_menu")
	public WebElement HeaderSubManu;
	@FindBy(xpath = "//a[text()='WEATHER']")
	public WebElement Weather;

	@FindBy(className = "notnow")
	public WebElement NoThanksPopUp;

	public NDTVDashboardPage(WebDriver driver1) {

		driver = driver1;

		PageFactory.initElements(driver, this);

	}

	public void waitForDashboardPageToLoad() {

		new WebDriverWait(driver, 300).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return (((org.openqa.selenium.JavascriptExecutor) driver).executeScript("return document.readyState")
						.equals("complete"));
			}
		});

	}

	public void clickOnNoThanksPopUp() {
		NoThanksPopUp.click();
	}

	public void clickOnWeather() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(HeaderSubManu));
		HeaderSubManu.click();

		try {Thread.sleep(2000);} catch (InterruptedException e) {}

		Weather.click();

	}

}
