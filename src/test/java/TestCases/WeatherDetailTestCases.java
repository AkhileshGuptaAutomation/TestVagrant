package TestCases;

import org.testng.annotations.Test;

import apiUtility.ApiCommonFunctions;
import baseTest.BaseTest;
import commonFunctions.CommonFunctions;
import io.restassured.response.Response;
import pages.NDTVDashboardPage;
import pages.NDTVWeatherPage;

public class WeatherDetailTestCases extends BaseTest {

	@Test
	public void verifyAPIAndWebTeamperatureValue() {

		ApiCommonFunctions comm = new ApiCommonFunctions();
		Response res = comm.getAPIResponse("http://api.openweathermap.org", "/data/2.5/weather", "Kolkata", "metric");
		String APITempValue = comm.getCurrentTemp(res);
		System.out.println("API Temp Value : "+APITempValue);

		NDTVDashboardPage dashboard = new NDTVDashboardPage(driver);
		dashboard.waitForDashboardPageToLoad();
		dashboard.clickOnNoThanksPopUp();
		dashboard.clickOnWeather();

		NDTVWeatherPage weatherPage = new NDTVWeatherPage(driver);
		weatherPage.waitForWeatherPageToLoad();
		String WebTempValue = weatherPage.getTempValueAndClickOnLucknowTempIcon().substring(0, 2);
		System.out.println("Web Temp Value : "+WebTempValue);
		weatherPage.verifyAllWeatherLucknowDetailsDisplayed();

		CommonFunctions.verifyIfDiffrenceIsLessThan2(WebTempValue, APITempValue);

	}

}
