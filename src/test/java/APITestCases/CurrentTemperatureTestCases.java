package APITestCases;

import org.testng.annotations.Test;

import apiUtility.ApiCommonFunctions;
import io.restassured.response.Response;

public class CurrentTemperatureTestCases {
	
	@Test
	public void testTempUsingAPI(){
		
		ApiCommonFunctions comm = new ApiCommonFunctions();
		Response res = comm.getAPIResponse("http://api.openweathermap.org", "/data/2.5/weather", "Kolkata", "metric");
		System.out.println(comm.getCurrentTemp(res));
		
		
		
	}

}
