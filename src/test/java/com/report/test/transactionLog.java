package com.report.test;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.paysecure.base.baseClass;
import com.paysecure.loginPage.loginPage;
import com.paysecure.reportPage.banktransactionTime;
import com.paysecure.reportPage.transactionPage;
import com.paysecure.reportPage.transactionlogpage;
import com.paysecure.utilities.DataProviders;

public class transactionLog extends baseClass {

	loginPage lp;
	transactionPage ts;
	transactionlogpage tl;

	@BeforeMethod
	public void beforeMethod() throws IOException, Exception {

		lp = new loginPage(getDriver());
		lp.login();
		tl = new transactionlogpage(getDriver());
		ts = new transactionPage(getDriver());
		tl.verifyUserIsOnTransactionLogPage(getDriver());
	}

	@Test
	public void verifyTransactionLog() throws InterruptedException {
	
		ts.selectDateRange("Last 30 Days");
		tl.searchThroughPurchaseID(getDriver());
		tl.searchTransactionLog(getDriver());
		tl.click_downloadButton(getDriver());
		tl.verifyTransactionPurchaseDetails(getDriver());
	}

	
	@Test
	public void verify_purchaseIDJson() throws InterruptedException {
		
		ts.selectDateRange("Last 30 Days");
		tl.searchThroughPurchaseID(getDriver());
		tl.searchTransactionLog(getDriver());
		
		tl.verifyPurchaseID(getDriver());
	}
	
	
	
	@Test(dataProvider ="Headers", dataProviderClass = DataProviders.class)
	public void verifyTableHeaders(List<String> expectedHeaders) {
	    
	    List<String> actualHeaders =tl.verifyHeaders(getDriver());

	    Assert.assertEquals(actualHeaders, expectedHeaders, "❌ Table headers do not match!");
	    System.out.println("✅ Headers match exactly!");
	}
	

}
