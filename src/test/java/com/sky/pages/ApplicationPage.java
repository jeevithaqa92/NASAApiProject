package com.sky.pages;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import com.nasa.framework.commons.ApiBasePage;

import io.restassured.response.Response;

public class ApplicationPage extends ApiBasePage {

	public void verifyApiRequest(String endpoint, String expectedStatusCode, String api_key, String startdate,
			String enddate) throws IOException {
		Response response = given().contentType("application/json").when()
				.queryParam("api_key", api_key)
				.queryParam("start_date", startdate)
				.queryParam("end_date", enddate)
				.get(endpoint);
		
		verifyStatusCode(response, Integer.parseInt(expectedStatusCode));
		getResponseTime(response);	
		getValueFromResponse(response, "url");
		getValueFromResponse(response, "hdurl");
		getResponseBody(response);
	}
}
