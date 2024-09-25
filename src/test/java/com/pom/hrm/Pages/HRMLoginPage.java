package com.pom.hrm.Pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.pom.hrm.base.ActionEngine;
import com.pom.hrm.utilities.PojoReader;
import com.relevantcodes.extentreports.LogStatus;

public class HRMLoginPage extends ActionEngine {
	static
	{
		PageFactory.initElements(getWebDriver(),HRMLoginPage.class);
	}
	
	
	@FindBy(xpath = "//input[@name='username']")
	private static WebElement UsenName;
	
	@FindBy(xpath = "//input[@name='password']")
	private static WebElement Password;
	
	@FindBy(xpath="//button[@type='submit']")
	private static WebElement LoginBtn;
	
	@FindBy(xpath = "//h6[text()='Dashboard']")
	private static WebElement DashboardMsg;
	
	public static void enterUserName() throws EncryptedDocumentException, IOException
	{
		//String data_username=PojoReader.getExcelObj().getCellData("sheetname","Sheet4", 1, 0);
		String data_username=PojoReader.getPrConf().getValue("userName");
		enterData(data_username, UsenName, "username");
	}
	public static void enterPassword() throws EncryptedDocumentException, IOException
	{
		//String data_password=PojoReader.getExcelObj().getCellData("sheetname","Sheet4", 1, 1);
		String data_password=PojoReader.getPrConf().getValue("Password");
		
		enterData(data_password,Password,"password");
	}
	public static void enterLoginBtn()
	{
		clickWebElement(LoginBtn, "loginButton");
	}
	public static void validateDasboardMsg(String title)
	{
		String expDashmsg=title;
		String actualDashMsg=DashboardMsg.getText();
		System.out.println("actual msg=  "+actualDashMsg);
		System.out.println("exp msg=  "+expDashmsg);
	
			System.out.println("DashBoard message is passed");
			Assert.assertEquals(actualDashMsg,expDashmsg);
		       
	}

}
