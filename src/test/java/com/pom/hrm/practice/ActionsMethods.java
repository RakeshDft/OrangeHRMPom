package com.pom.hrm.practice;

import static org.testng.Assert.assertEquals;

import java.awt.Point;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

class ActionsMethods_One {
	public WebDriver driver;
	public Actions actions;

	public ActionsMethods_One() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		actions = new Actions(driver);

	}

	public void clickOnWebElement() throws InterruptedException {

		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		
		  WebElement lgin_Link = driver.findElement(By.xpath("//a[text()='Log in']"));
		  clickWebElement(lgin_Link); 
		  WebElement reg_link=driver.findElement(By.xpath("//a[text()='Register']"));
		  //contextClickOnWebElement(reg_link); 
		  WebElement forgotpassword_link=driver.findElement(By.xpath("//a[text()='Forgot password?']"));
		  doubleClickOnWebElement(forgotpassword_link);
		  WebElement coordinates_element= driver.findElement(By.xpath("//input[@value='Recover']"));
		  moveToWebElementPage(coordinates_element);
		  WebElement register_link=driver.findElement(By.xpath("//a[text()='Register']")); 
		  // Getthe element's coordinates (location)
		  org.openqa.selenium.Point point =register_link.getLocation(); 
		  int xCoordinate = point.getX(); 
		  int yCoordinate = point.getY(); System.out.println("X Coordinate: " + xCoordinate);
		  System.out.println("Y Coordinate: " + yCoordinate);
		  moveWebElementByOffset(register_link,xCoordinate,yCoordinate); 
		  WebElement tricentis=driver.findElement(By.xpath("//a[text()='Tricentis']"));
		  clickAndHoldOnWebElement(tricentis);
		  WebElement whishlist=driver.findElement(By.xpath("//a[text()='Wishlist']"));
		  scrollToEle(whishlist);
		 
	    
	  
	    
	   // actions.sendKeys(Keys.HOME).build().perform();
	    //actions.sendKeys(Keys.END).build().perform();
		//driver.close();
	}

	
	  public void clickWebElement(WebElement webElement) {
	  actions.click(webElement).build().perform();
	  
	  }
	  
	  public void contextClickOnWebElement(WebElement webElement) {
	  actions.contextClick(webElement).build().perform();
	  
	  }
	  
	  public void doubleClickOnWebElement(WebElement element) {
	  actions.doubleClick(element).perform(); }
	  
	  public void moveToWebElementPage(WebElement element) {
	  actions.moveToElement(element).click().build().perform(); }
	  
	  public void moveWebElementByOffset(WebElement element,int x,int y) {
	  actions.moveByOffset(x, y).click(element).build().perform();
	  System.out.println("the move by Offset Values are done"+x +"and"+y); }
	  
	  public void clickAndHoldOnWebElement(WebElement element) {
	  
	  actions.clickAndHold(element).release().build().perform();
	  //System.out.println("The element is Click and hold"+element.getText());
	  }
	  public void scrollToEle(WebElement element) throws InterruptedException {
	  Thread.sleep(2000);
	  actions.scrollToElement(element).click().build().perform();
	  System.out.println("the scrolled is done  :"+element.getText());
	  Thread.sleep(2000);
	  
	  }
	 
	
	
	  public void testBrowserHistory() throws Exception { // Load web page
	  driver.navigate().to("https://www.selenium.dev/"); // Verify page title
	  assertEquals(driver.getTitle(),"Selenium"); // Click on Downloads
	  driver.findElement(By.linkText("Downloads")).click(); Thread.sleep(2000);
	  driver.navigate().back(); Thread.sleep(2000); driver.navigate().forward();
	  Thread.sleep(2000); driver.navigate().refresh(); Thread.sleep(2000);
	  driver.close(); }
	 
	
}

public class ActionsMethods {
	public static void main(String args[]) throws Exception {
		ActionsMethods_One actionsOne = new ActionsMethods_One();
		actionsOne.clickOnWebElement();
		//actionsOne.testBrowserHistory();
	}
}
