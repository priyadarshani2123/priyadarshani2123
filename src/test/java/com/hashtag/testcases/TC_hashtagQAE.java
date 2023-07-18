package com.hashtag.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hashtag.pageobject.ApplyPage;

public class TC_hashtagQAE extends BaseClass {
	
	@Test
	public void verifyApplyNow() throws IOException
	{
		
		
		driver.get(url);
		System.out.println("Url is open");
		driver.manage().window().maximize();
		
		
		
		JavascriptExecutor js =( (JavascriptExecutor)driver);
		js.executeScript("window.scrollBy(80,400)");
		
		
		
		
		
	   ApplyPage ap=new ApplyPage(driver);
	 
		ap.logo();
		
		ap.name("priyadarshani");
		ap.enteremail("priyadarshani2123@gmail.com");
		ap.Phonenumber("9028711321");
		
		ap.file("C:\\Users\\admin\\Desktop\\Priyadarshanih.CV.docx");
		ap.Description("Applying for qa");
		ap.Applybutto();
	  ap.Errormsg("something went wrong! please try again later");
	 
		  
		

		
		String pagetitle = ap.title();
		if(pagetitle.equals("Thank you for your interest"))
		{
			
			Assert.assertTrue(true);
			System.out.println("pagetitle is:"+pagetitle);
			}
		else
		{
			capturescreenshot(driver,"verifyApplyNow");
			Assert.assertTrue(false);
		}
		
		
	}

}
