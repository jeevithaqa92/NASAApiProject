package com.nasa.framework.basetest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.nasa.framework.utils.ExcelService;
import com.nasa.framework.utils.ReadDataFromProps;

public class TestBasePage {
	
	public static ExtentReports report = null;
	public static ExtentTest logger = null;

	
	public static Properties appProperties() throws IOException {
	    Properties prop = ReadDataFromProps.readPropertiesFile(System.getProperty("user.dir")+"\\Resorces\\Config.properties");
		return prop;
		}
	
	@BeforeSuite
	public void setUpSuite() throws IOException {
		System.out.println("@BeforeSuite");
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/ProjectTestReport.html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		report.setSystemInfo("User Name", appProperties().getProperty("username"));
		report.setSystemInfo("Time Zone", appProperties().getProperty("timezone"));
		report.setSystemInfo("Machine", "Windows 10" + "64 Bit");
		report.setSystemInfo("Maven", "3.8.1");
		report.setSystemInfo("Java Version", "1.8.0_151");
	}
	
	public static void initiateTestReport(String testcasename) {
		logger = report.createTest(testcasename);
	}
	
	public static ExtentTest getLogger() {
		return logger;		
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() throws IOException {
		System.out.println("@AfterMethod");
		report.flush();
	}
	
	//Method to read data from Test Data File
	@DataProvider (name= "ApplicationTestData")
	public Object[][] testData() {
		Object[][] data = new ExcelService().getExcelData(System.getProperty("user.dir") +"\\TestData\\ApplicationTestData.xlsx", "TestData");
		return data;
	}	
}
