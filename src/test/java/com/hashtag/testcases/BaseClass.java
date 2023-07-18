package com.hashtag.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.hashtag.utilities.Readconfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	Readconfig readconfig=new Readconfig();
	
     String url=readconfig.getbaseUrl();
     String browser=readconfig.getbrowser();
     
     public static WebDriver driver;
     
     
     @BeforeClass
     public void setup()
      {
    	 ChromeOptions op=new ChromeOptions();
    	 op.addArguments("--remote-allow-origins=*");
    	 driver=new ChromeDriver(op);
    	 WebDriverManager.chromedriver().setup();
    	     	 
    	 
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	 
    	 
      }
     @AfterClass
    public void Quit()
      {
    	 driver.close();
      }
    
    public void capturescreenshot(WebDriver driver,String testname) throws IOException
     {
    	TakesScreenshot screenshot=((TakesScreenshot)driver);
    	File src = screenshot.getScreenshotAs(OutputType.FILE);
    	File dest=new File(System.getProperty("user.dir"+"//screenshot//"+testname+"png"));
    	
    	FileUtils.copyFile(src, dest);
    	 
     }
    

	
	
	
	
	
	
	
	
	
	
}


