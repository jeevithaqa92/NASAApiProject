package com.nasa.framework.basetest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.nasa.framework.utils.NewExcelUtil;
import com.nasa.framework.utils.ReadDataFromProps;

public class TestBasePage {
	
	public static ExtentReports report = null;
	public static ExtentTest logger = null;

	
	public static Properties appProperties() throws IOException {
	    Properties prop = ReadDataFromProps.readPropertiesFile(System.getProperty("user.dir")+"\\Resorces\\application.properties");
		return prop;
		}
	
	@BeforeSuite(alwaysRun = true)
	public void setUpSuite() throws IOException {
		System.out.println("@BeforeSuite");
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/ProjectTestReport_"+uniqueId()+".html"));
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
	
	//Method to generate unique id
	public static String uniqueId() {
		SimpleDateFormat s = new SimpleDateFormat("MMddyyhhmmss");
		String uniqueid = s.format(Calendar.getInstance().getTime());
		return uniqueid;
	}
	
	//Method to read data from Test Data File
	@DataProvider(name = "ApplicationTestData")
	public Iterator<Object[]> testdataprovider(Method method) throws IOException {
		return new NewExcelUtil().readTestDataFromExcel("ApplicationTestData.xlsx", "TestData",method.getName());
	}
}
