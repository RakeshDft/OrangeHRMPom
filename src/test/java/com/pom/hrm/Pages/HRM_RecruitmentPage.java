package com.pom.hrm.Pages;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.pom.hrm.base.ActionEngine;
import com.pom.hrm.utilities.PojoReader;

public class HRM_RecruitmentPage extends ActionEngine{
	
	  static { PageFactory.initElements(getWebDriver(),HRM_RecruitmentPage.class);
	  }
	 
	@FindBy(xpath="(//div[@class='oxd-select-wrapper'])[1]")                      
	private static WebElement jobTitleSelect;
	
	@FindBys({@FindBy(xpath="//div[@role='option']")})
	  private static List<WebElement> JobTitleList;
	
	
	@FindBy(xpath="(//div[@class='oxd-select-wrapper'])[2]")
	private static WebElement Vacancyelt;
	
	@FindBys({@FindBy(xpath="//div[@role='option']")})
	  private static List<WebElement> Vacancylist;
	
	
	@FindBy(xpath="(//div[@class='oxd-select-wrapper'])[3]")
	private static WebElement hiringManager;
	
	@FindBys({@FindBy(xpath="//div[@role='option']")})
	  private static List<WebElement> hiringMGRlist;
	
	
	@FindBy(xpath="(//div[@class='oxd-select-wrapper'])[4]")
	private static WebElement status;
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	private static WebElement CandidateName;
	
	@FindBy(xpath="//input[@placeholder='Enter comma seperated words...']")
	private static WebElement Keywords;
	
	@FindBy(xpath="//input[@placeholder='From']")
	private static WebElement FromDate;
	
	@FindBy(xpath="//input[@placeholder='To']")
	private static WebElement ToDate;
	
	@FindBy(xpath="(//div[@class='oxd-select-wrapper'])[5]")
	private static WebElement MethodofApp;
	
	@FindBys({@FindBy(xpath="//div[@class='oxd-select-option']")})
	  private static List<WebElement> MethodofApplication;
	
	@FindBy(xpath="//button[@type='submit']")
	private static WebElement search;
	@FindBy(xpath="//span[text()='No Records Found']")
	private static WebElement NoRecordsMsg;
	@FindBy(xpath="//span[text()='(1) Record Found']")
	private static WebElement recordsFound;
	
	
	public static void selectJobTitle() throws InterruptedException
	{
		clickWebElement(jobTitleSelect, "Select Job Title");
		Thread.sleep(2000);
		selectElementActionsKeys("Select the JobTitle");
		//selectTextContains(JobTitleList,"Automaton Tester");
		
		Thread.sleep(2000);
		}
	
	  public static void selectVacancy() throws EncryptedDocumentException, IOException {
	  clickWebElement(Vacancyelt, "VacancyOPtion"); 
	  selectElementActionsKeys("Select Vacancy");
		/*
		 * String datatest=PojoReader.getExcelObj().getCellData("sheetname","Sheet3", 9,
		 * 0); String[] exceldata=splitTheValues(datatest);
		 * selectWithConatinsText(Vacancylist, exceldata);
		 */
		
		
	  }
	  public static void selectManager() throws EncryptedDocumentException, IOException
	  {
		  clickWebElement(hiringManager, "Select Manager");
		  selectElementActionsKeys("Select the hiring manager");
		 // selectTextContains(hiringMGRlist,"Rahul Patil");
		  
	  }
	  public static void selectStatus()
	  {
		  clickWebElement(status, "select the status");
		  selectElementActionsKeys("Select the Status");
	  }
	  public static void enterCandidateName() throws EncryptedDocumentException, IOException, InterruptedException
	  {
		 String data_candidateName=PojoReader.getExcelObj().getCellData("sheetname","Sheet3", 6, 1);
		enterData(data_candidateName, CandidateName, "CandidateName");
		Thread.sleep(2000);
		selectElementActionsKeys("Select candidatename");
	  }
	  public static void enterKeyWordswithCommaSeperated() throws EncryptedDocumentException, IOException
	  {
		  String data_Keywords=PojoReader.getExcelObj().getCellData("sheetname", "Sheet3", 7, 1);
		  enterData(data_Keywords,Keywords,"KEyWords");
	  }
	  public static void selectFromDate() throws ParseException, EncryptedDocumentException, IOException
	  {
		 // clickWebElement(FromDate, "FromDate");
		  
		  String targetDate=PojoReader.getPrConf().getValue(""
		  		+ "FromDate");
		  System.out.println("The date from excel is "+targetDate);

		  
		  SimpleDateFormat targetDateFormat=new SimpleDateFormat("yyyy-dd-mm");
		   
		  targetDateFormat.setLenient(false);
		   
		  Date formattedTargetDate =targetDateFormat.parse(targetDate);
		  System.out.println("The formated date is  "+formattedTargetDate);
		  String fromDate=targetDateFormat.format(formattedTargetDate);
		  enterData(fromDate, FromDate, "FromDate");
		   
	  }
	  public static void selectToDate() throws IOException, ParseException
	  {
		  String targetDate=PojoReader.getPrConf().getValue("ToDate");
		  System.out.println("The date from excel is "+targetDate);

		  
		  SimpleDateFormat targetDateFormat=new SimpleDateFormat("yyyy-dd-mm");
		   
		  targetDateFormat.setLenient(false);
		   
		  Date formattedTargetDate =targetDateFormat.parse(targetDate);
		  System.out.println("The formated date is  "+formattedTargetDate);
		  String fromDate=targetDateFormat.format(formattedTargetDate);
		  enterData(fromDate, ToDate, "ToDate");
	  }
	  public static void selectModeofApplication()
	  {
		  //WebElement moa;
		  clickWebElement(MethodofApp, "method of App Link");
		  for(WebElement moa1:MethodofApplication)
		  {
			 if(moa1.getText().contains("Online"))
			 {
				 moa1.click();
			 }
			  
	  }
	  }
	  public static void submitSearch() throws EncryptedDocumentException, IOException, InterruptedException
	  {
		  clickWebElement(search, "Search");
		  Thread.sleep(2000);
		  String norecord=NoRecordsMsg.getText();
		  System.out.println(norecord);
		  String recordsfound=recordsFound.getText();
		  System.out.println(recordsfound);
		  String expe_NorecordMsg=PojoReader.getExcelObj().getCellData("sheetname","Sheet3",10, 0);
		  System.out.println(expe_NorecordMsg);
		  String expe_RecordMsg=PojoReader.getExcelObj().getCellData("sheetname","Sheet3",11, 0);
		  System.out.println(expe_RecordMsg);
		  if((norecord==expe_NorecordMsg)||(recordsfound==expe_RecordMsg))
		  {
			  Assert.assertTrue(true);
		  }
	  }
	  
	  }

	
	 


