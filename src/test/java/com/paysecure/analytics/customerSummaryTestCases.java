package com.paysecure.analytics;

import org.testng.annotations.Test;

import com.paysecure.Analyticals.CustomerSummaryPage;
import com.paysecure.base.baseClass;
import com.paysecure.loginPage.loginPage;
import com.paysecure.reportPage.transactionPage;
import com.paysecure.utilities.RetryAnalyzer;
import com.paysecure.utilities.dbForEmail;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;

public class customerSummaryTestCases extends baseClass {
	loginPage lp;
	CustomerSummaryPage cs;
	transactionPage ts;
	dbForEmail ed;

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		lp = new loginPage(getDriver());
		lp.login();
		cs = new CustomerSummaryPage(getDriver());
		cs.navigateUptoCustomerSummaryPage();
		ts = new transactionPage(getDriver());
		ed=new dbForEmail();
		

	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void f() throws InterruptedException {
		cs.verifyCustomerEmailIsAlreadySelectInGroupByDropdown();
		cs.submitButtonFunctionality();
		cs.verifyCustomersEmailOnTable();
		cs.selectDashboardusinAllMerchant("arunnew", "arunnew");
		cs.submitButtonFunctionality();
		cs.verifyEmailISShouldBedisplysAfterSelectingCustomersEmailFromGroupBy();
	}

	@Test
	public void getEmailIDTotalCount() throws InterruptedException {
		cs.selectDashboardusinAllMerchant("AJay", "AjayChoudhary");
		cs.submitButtonFunctionality();
		cs.getAllFrqFromEmailID();
		cs.getALLCountFromEmailID();
		cs.verifyAllCounts();

	}
	
	
	public void gettingAllEmailRealatedvaluesFromUI() {
		
	}
	
	
	
	
	
	
}
