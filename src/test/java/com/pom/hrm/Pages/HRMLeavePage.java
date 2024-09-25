package com.pom.hrm.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.hrm.base.ActionEngine;

public class HRMLeavePage extends ActionEngine{
	static {
		PageFactory.initElements(getWebDriver(),HRMLeavePage.class);
	}
	@FindBy(xpath = "//a[text()='Apply']")
	private static WebElement ApplyBtn;
	public static void clickApplyLeave()
	{
		clickWebElement(ApplyBtn, "applybutton");
	}
	@FindBy(xpath="//a[text()='My Leave']")
	private static  WebElement MyLeaveLink;
	public static void clickMyLeave()
	{
		clickWebElement(MyLeaveLink, "MyLeave");
	}

}
