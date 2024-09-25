package com.pom.hrm.practice;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

class AllWaits{
	public static WebDriver driver;
	public Actions actions;
	WebDriverWait wait;
	
	public AllWaits()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		actions = new Actions(driver);
		
		
	}
	public void testWaits()
	{
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
			 
		WebElement desktop=driver.findElement(By.xpath("//a[text()='Log in']"));
		
		testWaitBy(desktop);
		String register="//input[@value='Register']";
		testvisibilityOfElementLocatedWait();
		
		}
	
	
		public void testvisibilityOfElementLocatedWait()
		{
			try {
				WebDriverWait wait=new WebDriverWait(driver, 10);
			WebElement ele1=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//input[@value='Register']"))));
			ele1.click();
			System.out.println("wait performed by visibilityOfElementLocated By");
			}catch (TimeoutException e) {
	            System.out.println("TimeoutException: Element not visible within the given time.visibilityofElementLocated method");

	        } catch (NoSuchElementException e) {
	            System.out.println("NoSuchElementException: Element not found in the DOM.");

	        }  catch (ElementClickInterceptedException e) {
			    System.out.println("Element is blocked by another element.");
			}
			driver.close();
		}
		
		public void testStaleElementReferenceExceptionTest()
		{
			driver.get("https://bstackdemo.com/signin");
			driver.manage().window().maximize();
			WebElement button=driver.findElement(By.xpath("//button[@id='login-btn']"));
			WebElement overlay=driver.findElement(By.xpath("//div[text()='Select Username']"));
			 try {
				 overlay.click();
				 WebDriverWait wait=new WebDriverWait(driver, 1);
					wait.until(ExpectedConditions.stalenessOf(button));
					
		           
		            // Trying to interact with the stale element
					button.click(); 
					System.out.println("staleness performed");// This will throw StaleElementReferenceException

		        }
			 catch (TimeoutException e) {
		            System.out.println("TimeoutException: Element stale element  method");

		        }catch (StaleElementReferenceException e) {
		            System.out.println("StaleElementReferenceException: Element is no longer attached to the DOM.");
		        }

		        try {
		            // Example 3: ElementClickInterceptedException (element is covered by another element)
		             
		            // Suppose this overlay is blocking the button
		        	WebDriverWait wait= new WebDriverWait(driver, 10);
		            // Wait until the button is clickable
		             wait.until(ExpectedConditions.elementToBeClickable(button));
		            button.click();  // Might throw ElementClickInterceptedException if overlay is still present

		        } catch (ElementClickInterceptedException e) {
		            System.out.println("ElementClickInterceptedException: Click was intercepted by another element.");
		        }
		        driver.close();
		        
		    }
		public void elementClickableTest()
		{
			driver.get("https://bstackdemo.com/signin");
		driver.manage().window().maximize();
		WebElement button=driver.findElement(By.xpath("//button[@id='login-btn']"));
		WebElement overlay=driver.findElement(By.xpath("//div[text()='Select Username']"));
			
			 try {
				 overlay.click();
				 System.out.println("click overlay from elementClickableTest method");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		    wait.until(ExpectedConditions.elementToBeClickable(button));
			 }
		catch (TimeoutException e) {
		    System.out.println("Element not clickable within the time limit");
		}
			    driver.close();
		}
			public void presenceOfElementLocatedtest()
			{
				driver.get("https://bstackdemo.com/signin");
				driver.manage().window().maximize();
				
				WebElement overlay=driver.findElement(By.xpath("//div[text()='Select Username']"));
					
					 try {
						 overlay.click();
						 System.out.println("presence of element located method");
				WebDriverWait wait = new WebDriverWait(driver, 10);
				
				    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='login-btn']")));
					 }
				catch (TimeoutException e) {
				    System.out.println("Element not clickable within the time limit  "+e.getMessage());
				}
					    driver.close();
				
			}
			public void invisibilityOfElementLoadedTest()
			{
				driver.get("https://bstackdemo.com/signin");
				driver.manage().window().maximize();
				try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				Boolean isInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@id='login-bt']")));
				System.out.println("the invisible element loaded method");
				}catch(NoSuchElementException e)
				{
					System.out.println("Element invisible or not in DOM  "+e.getMessage());
				}
			}
			
		
		public void testWaitBy(WebElement webElement)
		{
			try
			{
				 wait=new WebDriverWait(driver,5);
				WebElement ele=wait.until(ExpectedConditions.visibilityOf(webElement));
				ele.click();
					//invisibilityOfElementLocated((By)webElement);
			System.out.println("wait performed in visibilityOf webelement.............");
			}
			catch(TimeoutException e) {
	            System.out.println("TimeoutException: Element not visible within the given time.int testwait by method");
		}
	
	
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			System.out.println("alert present method");
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
}
}

public class WaitsTest {
	public static void main(String args[])
	{
		AllWaits alwaits=new AllWaits();
		alwaits.testWaits();
		AllWaits alwaits1=new AllWaits();
		alwaits1.testStaleElementReferenceExceptionTest();
		AllWaits alwaits2=new AllWaits();
		alwaits2.elementClickableTest();
		AllWaits alwaits3=new AllWaits();
		alwaits3.presenceOfElementLocatedtest();
		AllWaits alwaits4=new AllWaits();
		alwaits3.invisibilityOfElementLoadedTest();
	}
	
		
	

}
