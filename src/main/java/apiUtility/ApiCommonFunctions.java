package apiUtility;


import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ApiCommonFunctions {
	
	
	public Response getAPIResponse(String baseUri, String resourcePath, String location, String unit){

		Response response = given().queryParam("q",location).queryParam("appid", "7fe67bf08c80ded756e598d6f8fedaea").queryParam("units", unit).header("Content-Type","application/json").baseUri(baseUri).when().get(resourcePath)
				.then().extract().response();
		
		return response;
	}
	
	public JsonPath getJsonPath(Response response)
	{
		String resp=response.asString();
		JsonPath   js = new JsonPath(resp);
		return js;	
	}
	
	public String getCurrentTemp(Response response){
		
		return getJsonPath(response).getString("main.temp");
		
	}
	

}
