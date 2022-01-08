package com.nasa.framework.commons;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.ExtentTest;
import com.nasa.framework.basetest.TestBasePage;

public class ApiBasePage {
	
	public static ExtentTest Logger = TestBasePage.getLogger();

	private Response response = null;

	// Method to get API Base URL
	public String getApiBaseUrl() throws IOException {
		String baseUrl = TestBasePage.appProperties().getProperty("api_base_url");
		return baseUrl;
	}

	// Method to get response for API call
	public Response ApiCall(String requesttype, String cookievalue, String endpointUrl, String requestbody) {
		boolean apiCallStatus = true;
		Response response = null;
		try {
			if (requesttype.equalsIgnoreCase("GET")) {
				response = given().header("Cookie", cookievalue).contentType("application/json").when()
						.get(endpointUrl);
				return response;
			} else if (requesttype.equalsIgnoreCase("POST")) {
				response = given().header("Cookie", cookievalue).contentType("application/json").body(requestbody)
						.when().post(endpointUrl);
				return response;
			} else if (requesttype.equalsIgnoreCase("PUT")) {
				response = given().header("Cookie", cookievalue).contentType("application/json").body(requestbody)
						.when().put(endpointUrl);
				return response;
			} else if (requesttype.equalsIgnoreCase("DELETE")) {
				response = given().header("Cookie", cookievalue).contentType("application/json").when()
						.delete(endpointUrl);
				return response;
			}
		} catch (Throwable em) {
			em.printStackTrace();
		}
		return response;
	}

	// Method to get status code for API call
	public void verifyStatusCode(Response response, int expectedStatusCode) {
		Logger = TestBasePage.getLogger();
		int statuscode = response.statusCode();
		if (response.statusCode() == expectedStatusCode )
			Logger.pass("Response Status Code : " + response.statusCode());
		else
			Logger.fail("Response Status Code : " + response.statusCode());
	}

	// Method to get response time for API Call
	public void getResponseTime(Response response) {
		Logger = TestBasePage.getLogger();
		long responsetime = response.getTimeIn(TimeUnit.SECONDS);
		if (!(responsetime >= 10))
			Logger.pass("Response Time : " + responsetime);
		else
			Logger.fail("Response Time : " + responsetime + "  ; Response time is more than expected");
	}

	// Method to get response body for API Call
	public void getResponseBody(Response response) {
		Logger = TestBasePage.getLogger();
		String responsebody = response.getBody().asString();
		if (!(responsebody == null))
			Logger.pass("Response  : " + responsebody);
		else
			Logger.fail("No Response");
	}

	// Method to get specific parameter value from response
	public String[] getValueFromResponse(Response response, String key) throws IOException {
		String[] values = null;
		Logger = TestBasePage.getLogger();
		String value = response.getBody().jsonPath().getString(key);
		if (!(value == null)) {
			Logger.pass(key + " = " + value);
		} else {
			Logger.fail("No Response From Api");
		}
		return values;
	}

}
