package com.hashtag.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentreportsmanager implements  ITestListener
{
	
	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repname;
	
	
	public void onstart(ITestContext TestContext)
	{
		 String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		repname ="test-reports-"+timestamp+".html";
		
		
		sparkreporter =new ExtentSparkReporter("./Reports"+repname);
		
		
		sparkreporter.config().setDocumentTitle("DemoProject_test_result");
		
		
		sparkreporter.config().setReportName("hashtagQAE");
		sparkreporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("application", "hashtagQAE");
		extent.setSystemInfo("operating system", System.getProperty("os.name"));
		extent.setSystemInfo("user name", System.getProperty("user.name"));
		extent.setSystemInfo("environment", "qa");
		extent.setSystemInfo("user", "priya");
	}
		public void onTestSuccess(ITestResult result)
		{
			test=extent.createTest(result.getName());
			test.assignCategory(result.getMethod().getGroups());
			test.createNode(result.getName());
			test.log(Status.PASS, "test passed");
		}
			
		public void ontestfailure(ITestResult result)
		{
			test=extent.createTest(result.getName());
			test.createNode(result.getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.FAIL, "test failed");
			test.log(Status.FAIL, result.getThrowable().getMessage());
			
			
		}
		public void ontestskipped1(ITestResult result)
		{
			test=extent.createTest(result.getName());
			test.createNode(result.getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.SKIP, "test skipped");
			test.log(Status.SKIP, result.getThrowable().getMessage());
			
		}
		public void onfinish(ITestContext testcontext)
		{
			extent.flush();
		}
		
			
			
		}
		
	