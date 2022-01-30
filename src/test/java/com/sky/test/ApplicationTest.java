package com.sky.test;

import java.util.Map;

import org.testng.annotations.Test;

import com.nasa.framework.basetest.TestBasePage;
import com.sky.pages.ApplicationPage;

import io.restassured.RestAssured;

public class ApplicationTest extends TestBasePage {
	
	@Test(priority = 1, dataProvider = "ApplicationTestData",groups= {"Regression","Smoke"})
	public void VerifyAstronomyPictureOfTheDayWithValidKey(Map<String,String> data)
			throws InterruptedException, Exception {
		initiateTestReport("Verify Astronomy Picture Of The Day With Valid API Key");
		ApplicationPage page = new ApplicationPage();
		RestAssured.baseURI =page.getApiBaseUrl();
		page.VerifyAstronomyPictureOfTheDayWithValidKey(data);
	}
	
	@Test(priority = 2, dataProvider = "ApplicationTestData",groups= {"Regression"})
	public void VerifyAstronomyPictureOfTheDayWithInValidKey(Map<String,String> data)
			throws InterruptedException, Exception {
		initiateTestReport("Verify Astronomy Picture Of The Day With Invalid API Key");
		ApplicationPage page = new ApplicationPage();
		RestAssured.baseURI =page.getApiBaseUrl();
		page.VerifyAstronomyPictureOfTheDayWithInValidKey(data);
	}
	
	@Test(priority = 3, dataProvider = "ApplicationTestData",groups= {"Functional"})
	public void VerifyAstronomyPictureOfTheDayWithInValidRequest(Map<String,String> data)
			throws InterruptedException, Exception {
		initiateTestReport("Verify Astronomy Picture Of The Day With Invalid API Request");
		ApplicationPage page = new ApplicationPage();
		RestAssured.baseURI =page.getApiBaseUrl();
		page.VerifyAstronomyPictureOfTheDayWithInValidRequest(data);
	}
	
	@Test(priority = 4, dataProvider = "ApplicationTestData",groups= {"Functional"})
	public void VerifyAstronomyPictureOfTheDayWithInValidDateFormat(Map<String,String> data)
			throws InterruptedException, Exception {
		initiateTestReport("Verify Astronomy Picture Of The Day With Invalid Date Format");
		ApplicationPage page = new ApplicationPage();
		RestAssured.baseURI =page.getApiBaseUrl();
		page.VerifyAstronomyPictureOfTheDayWithInValidDateFromat(data);
	}	
	
	@Test(priority = 5, dataProvider = "ApplicationTestData",groups= {"Regression"})
	public void VerifyAstronomyPictureOfTheDayWithInValidDate(Map<String,String> data)
			throws InterruptedException, Exception {
		initiateTestReport("Verify Astronomy Picture Of The Day With Invalid Date");
		ApplicationPage page = new ApplicationPage();
		RestAssured.baseURI =page.getApiBaseUrl();
		page.VerifyAstronomyPictureOfTheDayWithInValidDate(data);
	}	
}
