package com.hashtag.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hashtag.utilities.Readconfig;

import io.reactivex.rxjava3.functions.Action;

public class ApplyPage {
	//create obj f webdriver
	WebDriver ldriver;
	
	
	JavascriptExecutor js;
	
	public ApplyPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	
	}
	//identify webelements

	
	@FindBy(id="logo")WebElement hashtaglogo;
	
	@FindBy(name="name")WebElement EnterName;
	@FindBy(name="email")WebElement email;
	@FindBy(name="phone")WebElement EnterPhone;//phone
	
	@FindBy(name="resume")WebElement ChooseFile;//file
	@FindBy(xpath="//textarea[@placeholder='Briefly Describe Yourself']")WebElement EnterDescription;
	@FindBy(xpath="//button[@class='btn form-button font-12 font-bold']")WebElement ClickOnAply;
	@FindBy(xpath="//p[contains(text(),'something went wrong! ')]")WebElement Errormassage ;//error msg
	
	@FindBy(xpath="//h3[text()='Thank you for your interest']")WebElement pagetitle;
	
	
	
	public void logo()
	{
		boolean hashtag = hashtaglogo.isDisplayed();
		System.out.println("logo of webpage is displayed:"+hashtag); 
		
	}
//	
	
	public void name(String fname)
	{
		EnterName.sendKeys( fname);
		System.out.println("name is:"+fname);
	}
	public void enteremail(String entermail)
	{
		email.sendKeys(entermail);
		System.out.println("email adress is:"+entermail);
	}
	
	public void Phonenumber(String phone)
	{
		EnterPhone.sendKeys(phone);
		System.out.println("enter phone number is:"+phone);
	}
	

	public void file( String path)
	{

		ChooseFile.sendKeys(path);
		//code for file uploading
		System.out.println("path of file is:"+path);
//
		
//		if(!ChooseFile.getAttribute("type").equalsIgnoreCase("file"))
////
//			{
//			//ChooseFile.sendKeys("C:\\Users\\admin\\Desktop\\Priyadarshanih.CV.docx");
//			ChooseFile.sendKeys(path);
//			System.out.println("input type is file .fileupload is  possible");
//		}
//		else {
//			System.out.println("input type is file. fileupload not possible");
//		}
	}

	public void Description(String dscr)
	{
		EnterDescription.sendKeys(dscr);
		System.out.println("description is:"+dscr);
	}
	
	public void Applybutto()
	{
		ClickOnAply.click();
		
	}
	public void Errormsg(String error)
	{
	Errormassage.isDisplayed();
	System.out.println("error massage is:"+Errormassage);
	
}
	public String title()
	{
		String titletext = pagetitle.getText();
	     return titletext;
	}
	
	
	
	
	
	
	
	
	
	

}
