package com.pom.hrm.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.pom.hrm.base.ActionEngine;

public class HRMApplyLeavePage extends ActionEngine {
	static 
	{
		PageFactory.initElements(getWebDriver(),HRMApplyLeavePage.class);
	}
	@FindBy(xpath = "//h6[text()='Apply Leave']")
	private static WebElement ApplyLeaveMsg;
	
	@FindBy(xpath="//div[text()='CAN - FMLA']")
	private static WebElement LeaveTypeMsg;
	
	
	public static void validateApplyLeaveMsg(String title)
	{
		String expApplyLeave=title;
		String actualLeaveMsg=ApplyLeaveMsg.getText();
		System.out.println(expApplyLeave+" = "+actualLeaveMsg);
		Assert.assertEquals(expApplyLeave,actualLeaveMsg);
	}
	public static void selectLeaveDropDown()
	{
		clickWebElement(LeaveTypeMsg, "leavetype");
	}
	
	
		
	}
			


