package com.pom.hrm.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SendKeys;

import io.github.bonigarcia.wdm.WebDriverManager;

class TestKeys
{
	public WebDriver driver;
	public Actions actions;

	public TestKeys() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		actions = new Actions(driver);

	}
	public void keysOnWebElement() throws InterruptedException {

		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		WebElement computers=driver.findElement(By.xpath("(//div[@class='header-menu']/ul/li[2])[1]"));
	    keyActions(computers);
	}
	public void keyActions(WebElement element)
	{
		actions.moveToElement(element).build().perform();
		actions.click(element).sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN)).perform();  // Press Shift + Left Arrow to select text
	
		//actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.UP).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		
		//actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	}
}

public class KeysActionTest {
	public static void main(String args[]) throws Exception {
		TestKeys actionsOne = new TestKeys();
		actionsOne.keysOnWebElement();
		
	}
}
