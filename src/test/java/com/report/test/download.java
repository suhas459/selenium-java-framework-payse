package com.report.test;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.paysecure.base.baseClass;
import com.paysecure.loginPage.loginPage;
import com.paysecure.reportPage.apiLogspage;
import com.paysecure.reportPage.banktransactionTime;
import com.paysecure.reportPage.downloadPages;
import com.paysecure.reportPage.transactionPage;
import com.paysecure.reportPage.transactionlogpage;


public class download extends baseClass {
  
	
	loginPage lp;
	transactionPage ts;
	banktransactionTime bank;
	apiLogspage api;
	downloadPages download;
	transactionlogpage tl;
	

	@BeforeMethod
	public void beforeMethod() throws IOException, Exception {

		lp = new loginPage(getDriver());
		lp.login();

		ts = new transactionPage(getDriver());

		download=new downloadPages(getDriver());
	
			tl=new transactionlogpage(getDriver())	;
			

	}
	
	
	
	
	@Test
  public void downloadTransaction() throws InterruptedException {
		download.verifyUserIsOnDownloadPage(getDriver());
		ts.filterTransactionThroughSelectStatus("Error");
		ts.selectDashboardusinAllMerchant("SuhasM", "SuhasM");
		ts.selectDashboardusinAllBank("Payu",  "Payu");
		ts.selectMID("cardPayment");
		ts.selectDateRange("Yesterday");
		ts.selectTimeZone(getDriver());
		download.selectCurrency(getDriver(),"I", "INR");
		download.downloadPurchaseOrBanktransaction("Bank Transactions");
		tl.click_downloadButton(getDriver());
		download.noRecordsFound(getDriver());
		download.clickONOKButton(getDriver());

  }
}
