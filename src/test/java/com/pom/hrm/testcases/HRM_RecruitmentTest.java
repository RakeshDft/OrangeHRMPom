package com.pom.hrm.testcases;

import java.io.IOException;
import java.text.ParseException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.pom.hrm.base.ActionEngine;
import com.pom.hrm.Pages.HRMDashboardPage;
import com.pom.hrm.Pages.HRMLoginPage;
import com.pom.hrm.Pages.HRM_RecruitmentPage;
import com.pom.hrm.utilities.PojoReader;

public class HRM_RecruitmentTest extends ActionEngine{
@Test
	public void testRecruitment() throws IOException, InterruptedException, EncryptedDocumentException, ParseException
	{
		enterUrl(PojoReader.getPrConf().getValue("qa_hrm_url"));
		Thread.sleep(2000);
		HRMLoginPage.enterUserName();
		HRMLoginPage.enterPassword();
		HRMLoginPage.enterLoginBtn();
		HRMDashboardPage.clickRecruitmentMenu();
		HRM_RecruitmentPage.selectJobTitle();
		HRM_RecruitmentPage.selectVacancy();
		HRM_RecruitmentPage.selectManager();
		HRM_RecruitmentPage.selectStatus();
		HRM_RecruitmentPage.enterCandidateName();
		HRM_RecruitmentPage.enterKeyWordswithCommaSeperated();
		HRM_RecruitmentPage.selectFromDate();
		HRM_RecruitmentPage.selectToDate();
		HRM_RecruitmentPage.selectModeofApplication();
		HRM_RecruitmentPage.submitSearch();
		Thread.sleep(2000);
	}

}

