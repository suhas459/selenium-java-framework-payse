package com.report.test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.paysecure.base.baseClass;
import com.paysecure.loginPage.loginPage;
import com.paysecure.reportPage.apiLogspage;
import com.paysecure.reportPage.banktransactionTime;
import com.paysecure.reportPage.transactionPage;
import com.paysecure.utilities.DataProviders;

public class apiLog extends baseClass{
	
	
	loginPage lp;
	transactionPage ts;
	banktransactionTime bank;
	apiLogspage api;
	

	@BeforeMethod
	public void beforeMethod() throws IOException, Exception {

		lp = new loginPage(getDriver());
		lp.login();

		ts = new transactionPage(getDriver());

		api=new apiLogspage(getDriver());
				
		api.verifyUserIsOnApiReportPage(getDriver());
	}
	
	
	
	
	
  @Test
  public void verifyAPILog() throws InterruptedException, TimeoutException {
	
		ts.selectDateRange("This Week");
		api.selectAPI("Check_Customer_TrustScore");
		api.selectMecrchant(getDriver());
		
		api.click_SearchButton(getDriver());
		api.click_DownloadButton(getDriver());
		api.verify_AlertMessageForDownload(getDriver());
	    api.checkTransactionStatus(getDriver());
		
  }
  
	@Test(dataProvider = "HeadersProvider", dataProviderClass = DataProviders.class)
	public void verifyTableHeaders(List<String> expectedHeaders) {
	    
	    List<String> actualHeaders =api.verifyHeaders(getDriver());

	    Assert.assertEquals(actualHeaders, expectedHeaders, "Table headers do not match!");
	    System.out.println("Headers match exactly!");
	    
//	      <class name="com.report.test.transactionLog"/>
//	      <class name="com.report.test.apiLog"/>
//	      <class name="com.paysecure.test.Login"/>
//	      <class name="com.paysecure.banks.allbanks"/>
//	      <class name="com.report.test.bankTransactionTime"/>
//	      <class name="com.paysecure.admin.manageRoles"/>
//	      <class name="com.report.test.errorLog"/>
//	      <class name="com.report.test.download"/>
	}

  
  
  
  
  
  
  
  
}
