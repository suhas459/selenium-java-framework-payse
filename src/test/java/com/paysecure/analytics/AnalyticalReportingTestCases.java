package com.paysecure.analytics;

import org.testng.annotations.Test;

import com.paysecure.Analyticals.AnalyticalReporting;
import com.paysecure.adminPage.managerolespage;
import com.paysecure.bankPage.allbankspage;
import com.paysecure.bankPage.errorCodeMapping_allBanks;
import com.paysecure.bankPage.jsonTransformer_allBanks;
import com.paysecure.bankPage.setting_allBanks;
import com.paysecure.bankPage.viewBankDetails_allBanks;
import com.paysecure.bankPage.viewMids_allBanks;
import com.paysecure.base.baseClass;
import com.paysecure.loginPage.loginPage;
import com.paysecure.reportPage.transactionPage;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class AnalyticalReportingTestCases extends baseClass {

	private loginPage lp;
	AnalyticalReporting ar;
	transactionPage ts;

	@BeforeMethod
	public void setupPages() throws IOException, InterruptedException, TimeoutException {
		lp = new loginPage(getDriver());
		lp.login();
	
		ar=new AnalyticalReporting(getDriver());
		ar.navigateUptoAnalyticalReporting();
		ts = new transactionPage(getDriver());

	}

	@Test
	public void endToEndTestCasesForAnalyticalReporting() throws InterruptedException, TimeoutException {

		ts.selectDashboardusinAllMerchant("suhas", "SuhasM");
		ar.selectDashboardusinAllBank("pay", "payu");
		ar.selectCurrency(getDriver(),"USD");
		ar.enterAmountFromAndTo("5", "1000");
		ts.selectDateRange("Yesterday");
		ts.selectTimeZone(getDriver());
		ts.filterTransactionThroughSelectStatus("PAID");
	    ar.selectSortByDropdown("ID");
	    ar.selectSortOrderDropdown("Ascending");
		ar.selectGroupByDropdown("Mer", "MerchantName");
		ar.clickOnTheGroupBy();
		ar.selectGroupByDropdown("Bank", " Bankmid");
		ar.clickOnTheGroupBy();
		ar.selectGroupByDropdown("Bank", "  Bankname");
		ar.clickOnTheGroupBy();
		ar.clickOnSubmitButton();
	}

	@Test
	public void getAnalyticalReportBySelectingMerchantInGroupBy() throws InterruptedException {
		ar.selectGroupByDropdown("Mer", "MerchantName");
		ar.clickOnSubmitButton();
		ar.verifyMerchantnameInTable();

	}

	@Test
	public void gelAnalyticalReportusingSelectMerchant() throws InterruptedException {
		ar.selectGroupByDropdown("Mer", "MerchantName");
		ts.selectDashboardusinAllMerchant("suhas", "SuhasM");
		ar.clickOnSubmitButton();
		ar.verifyMerchantnameInTable();
		ar.getMerchant();
		ar.checkStatusOfTable();

	}
	
	@Test
	public void checkCountOfPaid() throws InterruptedException {
		ts.navigateUptoTransaction();
		ts.filterTransactionThroughSelectStatus("Paid");
		ts.selectDashboardusinAllMerchant("Suhas", "SuhasM");
		ts.clickOnSearchButton();
		ts.checkTransactionStatus();
		ar.navigateUptoAnalyticalReporting();
		ar.selectGroupByDropdown("Mer", "MerchantName");
		ts.selectDashboardusinAllMerchant("suhas", "SuhasM");
		ar.clickOnSubmitButton();
		ar.verifyMerchantnameInTable();
		ar.getMerchant();
		ar.checkStatusOfTable();
		Assert.assertEquals(ts.uiRowCount, ar.attemptCount);
	}
	
	@Test
	public void verifyTotalAMount() throws InterruptedException {
		ar.selectGroupByDropdown("Mer", "MerchantName");
		ts.selectDashboardusinAllMerchant("gauravm", "gauravm");
		ar.clickOnSubmitButton();
		ar.getAmountFromAprroveAmount();
		ar.fetchAmounts();
		ar.verifyAmt();
		
	}
	
	@Test
	public void verifySucccessratePercentage() throws InterruptedException {
		ar.selectGroupByDropdown("Mer", "MerchantName");
		ts.selectDashboardusinAllMerchant("durgeshMerchant", "durgeshMerchant");
		ar.clickOnSubmitButton();
		ar.verifySuccessRate();
	}

	@Test
	public void ValidateUserSelectBankAndCheckANalyticalReport() throws InterruptedException {
		ar.selectGroupByDropdown("Mer", "MerchantName");
		ar.selectDashboardusinAllBank("bitsoclabecollection", "bitsoclabecollection");
		ar.clickOnSubmitButton();
		ar.checkStatusOfTable();
		ar.getTextFromSelectBank();
		
	}

	@Test
	public void verifyUserSelectCurrencyAndcheckANalyticalReports() throws InterruptedException {
		ar.selectGroupByDropdown("Mer", "MerchantName");
		ar.selectCurrency(getDriver(), "MXN");
		ar.clickOnSubmitButton();
		ar.checkStatusOfTable();
		ar.verifySelectedCurrencyIsPresentOnTheTXNID();

	}
	

	@Test
	public void verifyAmountToAndFromAndCheckANalytivcalReport() throws InterruptedException {
		ar.selectGroupByDropdown("Mer", "MerchantName");
		ar.clickOnTheGroupBy();
		ar.enterAmountFromAndTo("5", "1000");
		ar.clickOnSubmitButton();
		ar.checkStatusOfTable();
	}
	
	@Test
	public void verifyDateRangeAndCheckANalyticalReport() throws InterruptedException {
		ar.selectGroupByDropdown("Mer", "MerchantName");
		ts.selectDateRange("Yesterday");
		ar.clickOnSubmitButton();
		ar.checkStatusOfTable();
		
	}
	
	@Test
	public void verifyIfUserSelectStatusThenCheckANalyticalReport() throws InterruptedException {
		ar.selectGroupByDropdown("Mer", "MerchantName");
		ts.filterTransactionThroughSelectStatus("PAID");
		ar.clickOnSubmitButton();
		ar.checkStatusOfTable();
	}
	
	@Test
	public void verifyIfStatusIsPaidThenCheckWithTransctionIsSameOrNot() throws InterruptedException {
		ar.selectGroupByDropdown("Mer", "MerchantName");
		ts.filterTransactionThroughSelectStatus("PAID");
		ar.clickOnSubmitButton();
		ar.verifyCheckStatusAccordingToAnalyticalAndReport();
		ar.getApprovedAttempt();
		
	}
	
	@Test
	public void verifySortBy() throws InterruptedException {
		ar.selectGroupByDropdown("Mer", "MerchantName");
		ts.selectDateRange("Last 30 Days");
		
		ar.selectSortByDropdown("TotalAmount");
		ar.clickOnSubmitButton();
		
		String key="TotalAmount";
		switch (key) {
		case "All_Attempt":
			ar.verifySortByForAllAttemptWithPagination();
			break;
		case "Amount_Approved": {
			ar.verifySortByForAmountApproveddWithPagination();
			break;
		}
		
		case "Amount_Refunded":
              ar.verifySortByForAmountRefundedWithPagination();
			break;
			
		case "Amount_Rejected":
			ar.verifySortByForAmountRejectedWithPagination();
			break;
			
		case "AprvdAttempt":
			ar.verifySortByForAprvd_AttemptWithPagination();
			break;
			
		case "Failed_Attempt":	
			ar.verifySortByForFailed_AttemptWithPagination();
			break;
			
		case"TotalAmount":		
			ar.verifySortByForTotalAmountWithPagination();
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + key);
		}

	}
	
	
	@Test
	public void checkAllColumnsWhenUserUnSelectedCoumns() throws InterruptedException {
		ar.selectGroupByDropdown("Mer", "MerchantName");
	
	    ar.clickOnSubmitButton();
		ar.checkSelectedColumns();
		ar.verifyIfUserUnSelectedAnyColumnAndCheckForItsSize();
	}
	
	
	@Test
	public void validateSortOrder() throws InterruptedException {
		ar.selectGroupByDropdown("Mer", "MerchantName");
		ar.validateSortOrder();
	}
	
	@Test
	public void validateSortOrderWithSortBy() throws InterruptedException {
		ar.selectGroupByDropdown("Mer", "MerchantName");
		ts.selectDateRange("Last 30 Days");
		ar.selectSortByDropdown("All_Attempt");
		ar.validateSortOrder();
	}
	
	
	
	

}
