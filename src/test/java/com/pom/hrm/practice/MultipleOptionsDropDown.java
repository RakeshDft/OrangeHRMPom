package com.pom.hrm.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

class SelectMultipleOptions
{
	public static WebDriver driver;
	
	public SelectMultipleOptions()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	public void selectMultipleDD()
	{
		driver.get("https://letcode.in/dropdowns");
		driver.manage().window().maximize();
		WebElement selectHero=driver.findElement(By.id("superheros"));
		Select select=new Select(selectHero);
		boolean multi=select.isMultiple();
		System.out.println("multi is allow"+multi);
		select.selectByValue("am");
		select.selectByValue("bt");
		driver.close();
		
	}
	public void multipleOptionsWithoutSelect() throws InterruptedException
	{
		driver.get("https://semantic-ui.com/modules/dropdown.html#multiple-selection");
		driver.manage().window().maximize();
		WebElement Skill=driver.findElement(By.xpath("(//select[@name='skills'])[1]"));
		Skill.click();
		List<WebElement> select_course=driver.findElements(By.xpath("//div[@class='menu transition visible']/div"));
		
		for(WebElement course:select_course)
		{
			String optiontext=course.getText();
			System.out.println(optiontext+"\n");
			if(optiontext.equals("CSS")||(optiontext.equals("HTML")))
			{
				 if (!course.isSelected()) {
					 course.click(); 
					 Thread.sleep(2000);
			}
		}
		
		
	}
}
}
public class MultipleOptionsDropDown {
	public static void main(String args[]) throws InterruptedException
	{
		SelectMultipleOptions smo=new SelectMultipleOptions();
		smo.selectMultipleDD();
		SelectMultipleOptions smo1=new SelectMultipleOptions();
		smo1.multipleOptionsWithoutSelect();
		
	}

}
