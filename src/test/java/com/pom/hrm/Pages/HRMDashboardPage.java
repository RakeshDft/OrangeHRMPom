package com.pom.hrm.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.pom.hrm.base.ActionEngine;

public class HRMDashboardPage extends ActionEngine {
	static
	{
		PageFactory.initElements(getWebDriver(),HRMDashboardPage.class);
	}
	@FindBy(xpath="//span[text()='Leave']")
	private static WebElement Leave_link;
	@FindBy(xpath = "//h6[text()='Leave']")
	private static WebElement LeaveMsg;
	@FindBy(xpath="//span[text()='Recruitment']")
	private static WebElement Link_Recruitment;
	
	public static void clickLeaveMenu()
	{
		clickWebElement(Leave_link, "leaveMenu");
	}
	public static void validateLeavePage(String title)
	{
		String expmsg=title;
		String actualMsg=LeaveMsg.getText();
		Assert.assertEquals(expmsg,actualMsg);
		System.out.println("validate Leave page success");
	}
	public static void clickRecruitmentMenu()
	{
		clickWebElement(Link_Recruitment, "recritmentLink");
		
	}
}
