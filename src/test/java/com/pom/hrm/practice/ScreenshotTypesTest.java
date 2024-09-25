package com.pom.hrm.practice;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pom.hrm.base.BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

 class TypesOfScreenshotTest {
	public static WebDriver driver;
	
	public TypesOfScreenshotTest()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	public void screenShotForWebElementLevel() throws IOException
	{
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		WebElement login_link=driver.findElement(By.xpath("//a[text()='Log in']"));
		TakesScreenshot tst=(TakesScreenshot)driver;
		// Take the screenshot of the specific WebElement
        File screenshot = login_link.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("D:\\Rakesh\\HRM\\Screenshots\\webelement.jpeg");
         
        FileUtils.copyFile(screenshot,destinationFile);
        driver.close();
		
	}
	public void screenShotForPage() throws IOException
	{
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		WebElement login_link=driver.findElement(By.xpath("//a[text()='Log in']"));
		login_link.click();
		TakesScreenshot tstPage=(TakesScreenshot)driver;
		File screenshot=tstPage.getScreenshotAs(OutputType.FILE);
		File destFile=new File("D:\\Rakesh\\HRM\\Screenshots\\page.jpeg");
		FileUtils.copyFile(screenshot, destFile);
		driver.close();
	}
	public void screenShotForFullPage() throws IOException
	{
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		WebElement login_link=driver.findElement(By.xpath("//a[text()='Log in']"));
		login_link.click();
		Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(1000)) // Takes full-page screenshot with a delay of 1000ms
                .takeScreenshot(driver);
		  ImageIO.write(screenshot.getImage(), "JPEG", new File("D:\\Rakesh\\HRM\\Screenshots\\fullpage.jpeg"));

		
	}

}
public class ScreenshotTypesTest 
{
	public static void main(String args[]) throws IOException
	{
		TypesOfScreenshotTest ts=new TypesOfScreenshotTest();
		ts.screenShotForWebElementLevel();
		TypesOfScreenshotTest ts1=new TypesOfScreenshotTest();
		ts1.screenShotForPage();
		TypesOfScreenshotTest ts2=new TypesOfScreenshotTest();
		ts2.screenShotForFullPage();
	}
}
