package com.pom.hrm.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

class TestJSMethods
 {
	 public static WebDriver driver;
	 public TestJSMethods()
	 {
		 WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
	 }
	 public void clickAndEnterByJS() throws InterruptedException
	 {
		 driver.get("https://demowebshop.tricentis.com/");
		 driver.manage().window().maximize();
		// To Get the Title of the Login Page Using JavaScript:
		         JavascriptExecutor js = (JavascriptExecutor) driver;
				 String expected_title = (String) js.executeScript("return document.title;");
				 String actualTitle="Demo Web Shop";
				 Assert.assertEquals(actualTitle, expected_title);
				 System.out.println("HomePage Title:   " + expected_title+ "  is equal to:   "+actualTitle);
		 //Click on an Element using JavaScript:
		 WebElement login_link = driver.findElement(By.xpath("//a[text()='Log in']"));
		 
		 Assert.assertTrue(login_link.isDisplayed()&&login_link.isEnabled());
		 js.executeScript("arguments[0].click();", login_link);
		WebElement login_Title=driver.findElement(By.xpath("//h1[text()='Welcome, Please Sign In!']"));
		String loginTitleText = (String) js.executeScript("return arguments[0].innerText;", login_Title);
		System.out.println("Inner Text: " + loginTitleText);
		String actual_logintitle="Welcome, Please Sign In!";
		Assert.assertEquals(actual_logintitle, loginTitleText);
		System.out.println("LoginPage Title:   " + actual_logintitle+ "  is equal to:   "+loginTitleText);
		 WebElement textEmail=driver.findElement(By.xpath("//input[@id='Email']"));
		 js.executeScript("arguments[0].value='rakesh.charana@gmail.com'",textEmail);
		
		 js.executeScript("window.scrollBy(985, 800)");
		 System.out.println("Scroll done");
		 WebElement twitter=driver.findElement(By.xpath("//a[text()='Twitter']"));
		 js.executeScript("arguments[0].click()", twitter);
		 Thread.sleep(5000);
		 driver.close();
	 }
 }
public class JavaScriptMethodsTest {
	public static void main(String args[]) throws InterruptedException
	{
		TestJSMethods testJSMethods=new TestJSMethods();
		testJSMethods.clickAndEnterByJS();
	}

}
