package com.pom.hrm.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.pom.hrm.base.ActionEngine;
import com.pom.hrm.Pages.HRMApplyLeavePage;
import com.pom.hrm.Pages.HRMDashboardPage;
import com.pom.hrm.Pages.HRMLeavePage;
import com.pom.hrm.Pages.HRMLoginPage;
import com.pom.hrm.Pages.HRMMyLeavePage;
import com.pom.hrm.utilities.PojoReader;

public class HRM_LoginTests extends ActionEngine{
	@Test
	public void testLogin() throws IOException, InterruptedException
	{
		enterUrl(PojoReader.getPrConf().getValue("qa_hrm_url"));
		Thread.sleep(2000);
		HRMLoginPage.enterUserName();
		HRMLoginPage.enterPassword();
		HRMLoginPage.enterLoginBtn();
		String exmsg=PojoReader.getExcelObj().getCellData("sheetname","Sheet4", 2, 0);
		HRMLoginPage.validateDasboardMsg(exmsg);
		HRMDashboardPage.clickLeaveMenu();
		String expleavemsg=PojoReader.getExcelObj().getCellData("sheetname","Sheet4",3,0);
		HRMDashboardPage.validateLeavePage(expleavemsg);
		HRMLeavePage.clickApplyLeave();
		String expLeavemsg=PojoReader.getExcelObj().getCellData("sheetname","Sheet4",4,0);
		HRMApplyLeavePage.validateApplyLeaveMsg(expLeavemsg);
		HRMLeavePage.clickMyLeave();
		HRMMyLeavePage.clickMyLeaveCalender();
					Thread.sleep(3000);
		
	}

}
