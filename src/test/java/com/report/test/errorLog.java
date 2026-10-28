package com.report.test;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.paysecure.base.baseClass;
import com.paysecure.loginPage.loginPage;
import com.paysecure.reportPage.apiLogspage;
import com.paysecure.reportPage.banktransactionTime;
import com.paysecure.reportPage.errorLogsPage;
import com.paysecure.reportPage.transactionPage;

public class errorLog extends baseClass {

	loginPage lp;
	transactionPage ts;
	errorLogsPage error;

	@BeforeMethod
	public void beforeMethod() throws IOException, Exception {

		lp = new loginPage(getDriver());
		lp.login();
		error = new errorLogsPage(getDriver());

		ts = new transactionPage(getDriver());
		error.navigateUptoErrorLog();
	}

	@Test
	public void f() throws InterruptedException {

		ts.selectDateRange("Last 30 Days");
		error.selectDashboardusinAllMerchant(getDriver(),"M","mukesh1");
		error.search_Merchant_Ref_Id();
		error.search_Purchase_Id();
		error.searchButton();

	}
}
