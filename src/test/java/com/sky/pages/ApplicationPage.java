package com.sky.pages;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Map;

import com.aventstack.extentreports.ExtentTest;
import com.nasa.framework.basetest.TestBasePage;
import com.nasa.framework.commons.ApiBasePage;

import io.restassured.response.Response;

public class ApplicationPage extends ApiBasePage {
	
	public static ExtentTest Logger = TestBasePage.getLogger();

	public void VerifyAstronomyPictureOfTheDayWithValidKey(Map<String,String> data) throws IOException {
		Response response = given().contentType("application/json").when()
				.queryParam("api_key", data.get("api_key"))
				.queryParam("start_date", data.get("start_date"))
				.queryParam("end_date", data.get("end_date"))
				.get(data.get("ServiceEndpointURL"));
		
		getResponseTime(response);
		verifyStatusCode(response, Integer.parseInt(data.get("ExpectedStatusCode")));
		getResponseBody(response);
		getValueFromResponse(response, "url");
		getValueFromResponse(response, "hdurl");
	}
	
	public void VerifyAstronomyPictureOfTheDayWithInValidKey(Map<String,String> data) throws IOException {
		Response response = given().contentType("application/json").when()
				.queryParam("api_key", data.get("api_key"))
				.queryParam("start_date", data.get("start_date"))
				.queryParam("end_date", data.get("end_date"))
				.get(data.get("ServiceEndpointURL"));
		
		getResponseTime(response);
		verifyStatusCode(response, Integer.parseInt(data.get("ExpectedStatusCode")));
		getResponseBody(response);
		String value = getValueFromResponse(response, "error");
		if(value.contains(data.get("ExpectedResponse"))) {
			Logger.pass("API Response is matching with expected value");
		}else {
			Logger.fail("API Response is not matching with expected value");
		}
	}	
	
	public void VerifyAstronomyPictureOfTheDayWithInValidRequest(Map<String,String> data) throws IOException {
		Response response = given().contentType("application/json").when()
				.queryParam("api_key", data.get("api_key"))
				.queryParam("start_date", data.get("start_date"))
				.queryParam("end_date", data.get("end_date"))
				.get(data.get("ServiceEndpointURL"));
		
		getResponseTime(response);
		verifyStatusCode(response, Integer.parseInt(data.get("ExpectedStatusCode")));
		String responsebody = response.getBody().asString();
		if (responsebody.contains(data.get("ExpectedResponse"))) {
			Logger.info("Response = Page not found");
			Logger.pass("API Response is matching with expected value");
		} else {
			Logger.fail("API Response is not matching with expected value");
		}
	}
	
	public void VerifyAstronomyPictureOfTheDayWithInValidDateFromat(Map<String,String> data) throws IOException {
		Response response = given().contentType("application/json").when()
				.queryParam("api_key", data.get("api_key"))
				.queryParam("start_date", data.get("start_date"))
				.queryParam("end_date", data.get("end_date"))
				.get(data.get("ServiceEndpointURL"));
		
		getResponseTime(response);
		verifyStatusCode(response, Integer.parseInt(data.get("ExpectedStatusCode")));
		getResponseBody(response);
		String value = getValueFromResponse(response, "msg");
		if(value.contains(data.get("ExpectedResponse"))) {
			Logger.pass("API Response is matching with expected value");
		}else {
			Logger.fail("API Response is not matching with expected value");
		}
	}	
	
	public void VerifyAstronomyPictureOfTheDayWithInValidDate(Map<String,String> data) throws IOException {
		Response response = given().contentType("application/json").when()
				.queryParam("api_key", data.get("api_key"))
				.queryParam("start_date", data.get("start_date"))
				.queryParam("end_date", data.get("end_date"))
				.get(data.get("ServiceEndpointURL"));
		
		getResponseTime(response);
		verifyStatusCode(response, Integer.parseInt(data.get("ExpectedStatusCode")));
		getResponseBody(response);
		String value = getValueFromResponse(response, "msg");
		if(value.contains(data.get("ExpectedResponse"))) {
			Logger.pass("API Response is matching with expected value");
		}else {
			Logger.fail("API Response is not matching with expected value");
		}
	}	
	
}
