package com.pom.hrm.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
class ActionsMethods_Two {
	public WebDriver driver;
	public Actions actions;

	public ActionsMethods_Two() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		actions = new Actions(driver);

	}
	public void dragDropActionsOnWebElement()
	{
		
	
	driver.get("https://jqueryui.com/droppable/");
	driver.manage().window().maximize();
	WebElement drappable = driver.findElement(By.xpath("//a[text()='Droppable']"));
	clickOnWebElement(drappable);
	WebElement iframe_elt=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
	driver.switchTo().frame(iframe_elt);
	WebElement draggable_elt=driver.findElement(By.id("draggable"));
	WebElement droppable_elt=driver.findElement(By.id("droppable"));
	dragDropWebElements(draggable_elt,droppable_elt);
	
	}
	public void clickOnWebElement(WebElement element)
	{
		actions.click(element).build().perform();
	}
	public void dragDropWebElements(WebElement source,WebElement target)
	{
		actions.dragAndDrop(source, target).build().perform();
	}
	
}
public class DragAndDropEx {
	public static void main(String args[])  {
		ActionsMethods_Two actionsTwo = new ActionsMethods_Two();
		actionsTwo.dragDropActionsOnWebElement();
	}
	
}
