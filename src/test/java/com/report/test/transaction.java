package com.report.test;


import org.testng.annotations.Test;


import com.paysecure.base.baseClass;
import com.paysecure.loginPage.loginPage;
import com.paysecure.reportPage.cardsummarytransactionPage;
import com.paysecure.reportPage.emailtransactionPage;
import com.paysecure.reportPage.transactionPage;
import com.paysecure.reportPage.txnClass;
import com.paysecure.utilities.DBConnection;
import com.paysecure.utilities.DataProviders;
import com.paysecure.utilities.dbForEmail;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


import org.openqa.selenium.WebDriver;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;


public class transaction extends baseClass {

	private WebDriver driver;

	private transactionPage ts;
	private loginPage lp;
	emailtransactionPage email;
	cardsummarytransactionPage card;
	txnClass tc;

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		lp = new loginPage(getDriver());
		lp.login();
		ts = new transactionPage(getDriver());
		ts.navigateUptoTransaction();
		email = new emailtransactionPage(getDriver());
		card = new cardsummarytransactionPage(getDriver());
		tc=new txnClass(getDriver());
	}

	@Test(priority = -1, enabled = true)

	public void transactionUsingSelectStatus() throws InterruptedException, TimeoutException {
		ts.filterTransactionThroughSelectStatus("Error");
		ts.selectDateRange("Last 7 Days");
		ts.clickOnSearchButton();
		ts.checkTransactionStatus();
		ts.verifyStatusAccordingToSelections("ERROR", "error");

	}
	

	@Test(priority = 0, enabled = true)

	public void transactionUsingSelectMerchant() throws InterruptedException, TimeoutException {

		ts.selectDashboardusinAllMerchant("ni", "Mnitendra");
		ts.selectDateRange("Last 7 Days");
		ts.clickOnSearchButton();
		ts.getMerchantNameAfterSelectingMerchantField();
		ts.checkTransactionStatus();
        ts.verifyMerchantAccordingToSelections();
	}

	@Test(enabled = true, priority = 1)
	public void transactionUsingSelectBank() throws InterruptedException, TimeoutException {
		ts.selectDashboardusinAllMerchant("mn", "Mnitendra");
		ts.selectDashboardusinAllBank("fy", "fyst");
		ts.selectDateRange("Last 7 Days");
		ts.clickOnSearchButton();
		ts.checkTransactionStatus();
		ts.getBankNameFromBankFields();
		ts.checkBankNameOnTheTxnInformationPopUp();
	}

	@Test(enabled = true, priority =2)
	public void selectMIDBasedOnBank() throws InterruptedException, TimeoutException {
		ts.filterTransactionThroughSelectStatus("Paid");
		ts.selectDashboardusinAllMerchant("mn", "Mnitendra");
		ts.selectDashboardusinAllBank("Payu", "Payu");
		ts.selectDateRange("Today");
		ts.selectMID("fystMid");
		ts.clickOnSearchButton();
		ts.checkTransactionStatus();
	//	tc.handleStatusCount();


	}

	@Test(priority = 3, enabled = true)

	public void selectDate() throws InterruptedException, TimeoutException {

		ts.selectDateRange("Yesterday");

		ts.clickOnSearchButton();
		ts.checkTransactionStatus();
		//ts.pagination();

	}

	@Test(priority = 4, enabled = true)

	public void selectDateRangeToAndFrom() throws InterruptedException, TimeoutException {
		ts.selectDateRange("Custom Range");

		ts.selectDate_To(getDriver());

		ts.clickOnApplyButton(getDriver());

		// ts.clickOnSearchButton(driver);
		// ts.checkStatus(driver);
	}

	@Test(priority = 5, enabled = true)

	public void selectTimeZoneAndVerify() throws InterruptedException, TimeoutException {

		ts.selectTimeZone(getDriver());
		ts.clickOnSearchButton();
		ts.checkTransactionStatus();

	}

	@Test(priority = 6, enabled = true)

	public void selectCurrency() throws InterruptedException, TimeoutException {
		ts.selectCurrency(getDriver(),"EUR");
		ts.selectDateRange("Last 7 Days");
		ts.clickOnSearchButton();
		ts.checkTransactionStatus();
		ts.getCurrencyAfterselectingCurrencyFromCurrencyField();
		ts.verifyCurrencyAccordingToSelections();
	}


	@Test(priority = 8, enabled = true)
	public void allActionOnTransactionPage() throws InterruptedException {
		ts.selectDateRange("Last 7 Days");
		ts.getMerchantNameTxnIDAndLastStatusFromTransactionPage();
		
		ts.lastActionOnTransactionTable(getDriver());
				ts.historyOnTransaction(getDriver());
		ts.remarksOnTransactiontable(getDriver());

		ts.verifyErrorInRemarksField(getDriver());
		ts.verifyElementsInUserType(getDriver());

		ts.verifyUsers(getDriver());

		ts.selectError(getDriver());

		ts.checkAll_SelectError(getDriver());

		ts.enterMessage(getDriver());

		ts.clickOnSubmitButton(getDriver());

		ts.verifySuccessmessage(getDriver());

	}

	@Test(priority = 9, enabled = true)
	public void endToEndFlowOfTransaction() throws InterruptedException, TimeoutException {

		ts.filterTransactionThroughSelectStatus("Error");
		ts.selectDashboardusinAllMerchant("SuhasM", "SuhasM");
		ts.selectDashboardusinAllBank("Payu", "Payu");
		ts.selectMID("cardPayment");
		ts.selectDateRange("Yesterday");
		ts.selectTimeZone(getDriver());
		ts.selectCurrency(getDriver(),"USD");
		ts.clickOnSearchButton();
		ts.checkTransactionStatus();

	}

//	@Test(enabled =false)
//	public void validatetransactiondataWithCSV() throws InterruptedException {
//		ts.selectDateRange(driver,"Yesterday");
//		ts.clickOnSearchButton(driver);
//		ts.validateTransactiondataWithCSV(driver);
//		
//}
//	

	@Test(priority = 10, enabled = true)
	public void iterateAllTable_Pages() throws InterruptedException, TimeoutException {

		ts.filterTransactionThroughSelectStatus("Error");
		ts.selectDateRange("Yesterday");
		ts.clickOnSearchButton();

		ts.iterateAllTablePages(getDriver());

	}

	// in transaction page - verify purchase ID on transaction table and Transaction
	// page
	@Test(priority = 11, enabled = true)
	public void filter_Transaction_And_Open_Detail_Page() throws InterruptedException {
		ts.filterTransactionThroughSelectStatus("Paid");
		ts.selectDateRange("Yesterday");
		ts.clickOnSearchButton();

	}

	@Test(priority = 12, enabled = true)
	public void verify_downloadInvoice() throws InterruptedException {
		ts.filterTransactionThroughSelectStatus("Paid");
		ts.clickOnSearchButton();
		ts.verifyDownloadInvoice("Paid");

	}

	@Test(priority = 13, enabled = true)
	public void verifyErrorIn_downloadInvoice() throws InterruptedException {
		ts.filterTransactionThroughSelectStatus("Paid");
		ts.clickOnSearchButton();
		ts.verifyDownloadInvoice("Paid");
	
		ts.verifyErrorInDownloadInvoice_LogoAndComapanyEmail();
		ts.verifyErrorInDownloadInvoice_addProduct();
		ts.verifyTotalAmountInDownloadInvoice(6, 78);
		

		}
	

	@Test(priority = 14,enabled = false)
	public void verifyPurchaseID_EmailSummaryPage() throws InterruptedException {
		ts.filterTransactionThroughSelectStatus("Paid");
		email.clickOnEmail();
		email.clickOnTotal();
		email.verifyTransactionIDOnEmailSummeryPage();

	}

	@Test(priority = 15)
	public void verifyTransaCTIONidIn_ActionPage() {

		email.clickOnEmail();
		email.clickOnTotal();
		email.validatePurchaseIDWithActions();

	}

	@Test(priority = 16)
	public void validtePaginationInEmailSummaryPage() {
		email.clickOnEmail();
		email.clickOnTotal();
		email.iterateAllTablePages(getDriver());

	}

	@Test(priority = 17, enabled = false)
	public void testClickFirstEmailOccurrence() {
		String targetEmail = "go************0 ...";
		email.clickOnSpecificEmail(getDriver(), targetEmail);
	}

	@Test(dataProvider = "EmailID", dataProviderClass = DataProviders.class, priority = 18,enabled = false)
	public void testClickFirstEmailOccurrenceOf_Card(String email_id) throws InterruptedException {

		ts.selectDateRange("Last 7 Days");
		ts.clickOnSearchButton();
		email.clickOnSpecificEmail(getDriver(), email_id);
		email.verifydayFrequesncy(getDriver());
		email.verifyMonthFrequesncy(getDriver());
		email.verifyWeekFrequesncy(getDriver());
		email.verifyYearFrequesncy(getDriver());
		email.verifyCustomerMerchantFrequency(getDriver());
		email.verifyCustomerCardFrequency(getDriver());
		email.verifyCustomerCountriesFrequency(getDriver());
		email.verifyCustomerIPSFrequency(getDriver());
		email.verifyAmountFrequency(getDriver());
		email.verifyCustomerDeviceID(getDriver());
		email.verifyTotal(getDriver());

	}

	@Test(priority = 19)
	public void testClickFirstValid_TransactionOnCardOage() {
		String targetCard = "PAYID";
		card.clickOnCard(getDriver(), targetCard);
		card.clickFirstValidTransaction(getDriver());
		card.verifyTransactionIN_CardPage();

	}

	@Test(dataProvider = "cardNames", dataProviderClass = DataProviders.class, priority = 20,enabled = false)
	public void testTIDInActionCardSummarypage(String targetCard) throws InterruptedException {
		ts.selectDateRange("Last 7 Days");
		ts.clickOnSearchButton();

		card.clickOnCard(getDriver(), targetCard);
		card.clickOnActionColumn(getDriver());
		card.verifyPurchaseIDOnActionPage();

	}

	@Test(dataProvider = "cardNames", dataProviderClass = DataProviders.class, priority = 21,enabled = false)
	public void testTIDInHistoryCardSummarypage(String targetCard) throws InterruptedException {
		ts.selectDateRange("Today");
		ts.clickOnSearchButton();

		card.clickOnCard(getDriver(), targetCard);
		card.clickOnHistoryColumn(getDriver());
		card.verifyPurchaseIDOnHistoryPage();

	}

	@Test(priority = 22)
	public void getPaidTransaction() throws InterruptedException {
		ts.filterTransactionThroughSelectStatus("Paid");
		ts.selectDateRange("Yesterday");
		ts.clickOnSearchButton();
		ts.checkTransactionStatus();

		DBConnection db = new DBConnection();
		db.createConnectionForDB();
		@SuppressWarnings("static-access")

		int c = db.getYesterdaysTransactions("PAID");

		System.out.println(c);
		
	}

	@Test(dataProvider = "StatusWithMerchantName", dataProviderClass = DataProviders.class, priority = 23)
	
	public void checkTodaysTransactions(String staTus, String merchantname)
			throws InterruptedException, TimeoutException {

		ts.singleMerchantAndSelectStatusTodaysTransaction(staTus, merchantname);

	}

	
	
	
	@Test(dataProvider = "statusAndDateRangeMerchant", dataProviderClass = DataProviders.class, priority = 24)
	public void checkDBCountForLast7days(String status, String dateERange, String merchantName)
			throws InterruptedException {

		ts.selectDateRangeAndStatusAndMerchantAndCompareWithDB(status, dateERange, merchantName);

	}
	

	@Test(dataProvider = "dateFilter", dataProviderClass = DataProviders.class, priority = 25)
	public void selectOnlyDatesAndCheckWithDB(String dateRange) throws InterruptedException {
		Reporter.log("Starting test: selectOnlyDatesAndCheckWithDB with dateRange = " + dateRange);
		ts.getDateFilterWiseData(dateRange);
		Reporter.log("Completed test: selectOnlyDatesAndCheckWithDB with dateRange = " + dateRange);
	}

	@Test(dataProvider ="bankMidDateMerchant", dataProviderClass = DataProviders.class, priority = 26)
	public void selectMerchantNameAndBanknameMidAndDateAndMerchantcheckWithDB(String Merchant, String datERange,
			String banKName, String MiD) throws InterruptedException {
		Reporter.log("Starting test: selectMerchantNameAndBanknameMidAndDateAndMerchantcheckWithDB with Merchant="
				+ Merchant + ", dateRange=" + datERange + ", bankName=" + banKName + ", MID=" + MiD);
		ts.bankMidAndDateWiseDataMerchantName(Merchant, datERange, banKName, MiD);
		Reporter.log("Completed test: selectMerchantNameAndBanknameMidAndDateAndMerchantcheckWithDB");
	}

	@Test(dataProvider = "bankMidDate", dataProviderClass = DataProviders.class, priority = 27)
	public void selectMerchantNameAndBanknameMidAndDateAndcheckWithDB(String datERange, String banKName, String MiD)
			throws InterruptedException {
		Reporter.log("Starting test: selectMerchantNameAndBanknameMidAndDateAndcheckWithDB with dateRange=" + datERange
				+ ", bankName=" + banKName + ", MID=" + MiD);
		ts.bankMidAndDateWiseData(datERange, banKName, MiD);
		Reporter.log("Completed test: selectMerchantNameAndBanknameMidAndDateAndcheckWithDB");
	}

	@Test(dataProvider = "bankMid", dataProviderClass = DataProviders.class, priority = 28)
	public void selectBanknameMidAndcheckWithDB(String banKName, String MiD) throws InterruptedException {
		Reporter.log("Starting test: selectBanknameMidAndcheckWithDB with bankName=" + banKName + ", MID=" + MiD);
		ts.bankMidWiseData(banKName, MiD);
		Reporter.log("Completed test: selectBanknameMidAndcheckWithDB");
	}

	@Test(dataProvider = "daterangeWithMerchantName", dataProviderClass = DataProviders.class, priority = 29)
	public void selectDateRangeWithMerchantNameAndCompareWithDB(String datERange, String Merchant)
			throws InterruptedException {
		Reporter.log("Starting test: selectDateRangeWithMerchantNameAndCompareWithDB with dateRange=" + datERange
				+ ", Merchant=" + Merchant);
		ts.verifyMerchantNameWithDateAndCompareWithDB(datERange, Merchant);
		Reporter.log("Completed test: selectDateRangeWithMerchantNameAndCompareWithDB");
	}

	@Test(dataProvider = "daterange", dataProviderClass = DataProviders.class, priority = 30)
	public void searchTransactionIDAndCompareWithDB(String datERange) throws InterruptedException {
		String transactionID = "676a88c3097549490352e2b0";
		Reporter.log("Starting test: searchTransactionIDAndCompareWithDB with transactionID=" + transactionID
				+ ", dateRange=" + datERange);
		ts.verifyTransactionOrPurchaseIDWithDateAndCompareWithDB(transactionID, datERange);
		Reporter.log("Completed test: searchTransactionIDAndCompareWithDB");
	}

	@Test(priority = 31)
	public void selectMultipleMerchantAndCompareWithDB() throws InterruptedException {
		Reporter.log("Starting test: selectMultipleMerchantAndCompareWithDB", true);

		ts.selectDateRangeAndStatusAndMerchantMerchantAndCompareWithDB("Error", "Today", "Mnitendra", "Mnitendra",
				"Amitkumar", "Amitkumar");

		Reporter.log("Completed test: selectMultipleMerchantAndCompareWithDB", true);
	}

	@Test(priority = 32)
	public void selectDateRangeAndStatusAndCompareWithDB() throws InterruptedException {
		Reporter.log("Starting test: selectDateRangeAndStatusAndCompareWithDB", true);

		ts.selectDateRangeAndStatusAndCompareWithDB("Paid", "Yesterday");

		Reporter.log("Completed test: selectDateRangeAndStatusAndCompareWithDB", true);
	}

	@SuppressWarnings("static-access")
	@Test(priority = 33)
	public void verifyCustomerStatsFromDB() {
	    dbForEmail ed = new dbForEmail();
	    String eml = "ajayqa7@gmail.com";
	    
	    Reporter.log("Starting verification of customer stats from DB for email: " + eml, true);
	    
	    // Create DB connection
	    ed.createConnectionForDB();
	    Reporter.log("Database connection established successfully.", true);

	    // Fetch all required stats
	    int dayFrequency = ed.getdaysInYearCount(eml);
	    Reporter.log("Distinct days in year count: " + dayFrequency, true);

	    int monthInYear = ed.getmonthInYearCount(eml);
	    Reporter.log("Distinct months in year count: " + monthInYear, true);

	    int yearFrequency = ed.getYearCount(eml);
	    Reporter.log("Distinct years count: " + yearFrequency, true);

	    int weeklYCount = ed.getWeeklyCount(eml);
	    Reporter.log("Weekly count: " + weeklYCount, true);

	    int merchantCount = ed.getMerchantFrequency(eml);
	    Reporter.log("Merchant frequency: " + merchantCount, true);

	    int ips = ed.getCustomersIPCount(eml);
	    Reporter.log("Unique IP addresses: " + ips, true);

	    int ccFrequency = ed.getCustomersCardFrequency(eml);
	    Reporter.log("Card frequency: " + ccFrequency, true);

	    int countryFrequency = ed.getCustomersCountryFrequency(eml);
	    Reporter.log("Country frequency: " + countryFrequency, true);

	    int amtFrequency = ed.getAmtFrequency(eml);
	    Reporter.log("Amount frequency: " + amtFrequency, true);

	    int totalPaidTransactions = ed.getTotalPaidTransactions(eml);
	    Reporter.log("Total paid transactions: " + totalPaidTransactions, true);

	    int totalCountTransactionForThisEmailID = ed.getCountOfEmail(eml);
	    Reporter.log("Total transaction documents for emailId: " + totalCountTransactionForThisEmailID, true);
        
	    int getcount = ed.getCountOfMerchantEmailIDS(eml, "603");
	    Reporter.log("Total transaction documents for merchant: " + getcount, true);
	    
	    Reporter.log("Completed fetching all customer statistics successfully.", true);
	    
	    // Also print to console for visibility during debug runs
	    System.err.println("dayFrequency :- " + dayFrequency);
	    System.out.println("monthInYear:- " + monthInYear);
	    System.out.println("yearFrequency :- " + yearFrequency);
	    System.out.println("weeklYCount :- " + weeklYCount);
	    System.out.println("merchantCount :- " + merchantCount);
	    System.out.println("ips :- " + ips);
	    System.out.println("ccFrequency :- " + ccFrequency);
	    System.out.println("countryFrequency :- " + countryFrequency);
	    System.out.println("amtFrequency :- " + amtFrequency);
	    System.out.println("totalPaidTransactions:- " + totalPaidTransactions);
	    System.out.println("totalCountTransactionForThisEmailID :- " + totalCountTransactionForThisEmailID);
	    System.out.println("getCOunt :- "+getcount);
	}


	// payment flow
	// mid
	// Issuerbank
	// MDR
	// PSP -payout/payin/accuring bank
	// Risk factor
	// rolling reserver

}
