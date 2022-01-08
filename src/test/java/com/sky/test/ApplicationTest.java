package com.sky.test;

import org.testng.annotations.Test;

import com.nasa.framework.basetest.TestBasePage;
import com.sky.pages.ApplicationPage;

import io.restassured.RestAssured;

public class ApplicationTest extends TestBasePage {
	
	@Test(priority = 1, dataProvider = "ApplicationTestData")
	public void VerifyAstronomyPictureOfTheDay(String endpoint, String statuscode,String api_key,String startdate,String enddate)
			throws InterruptedException, Exception {
		initiateTestReport("Verify Astronomy Picture Of The Day API");
		ApplicationPage page = new ApplicationPage();
		RestAssured.baseURI =page.getApiBaseUrl();
		page.verifyApiRequest(endpoint, statuscode,api_key,startdate,enddate);
	}	
}
