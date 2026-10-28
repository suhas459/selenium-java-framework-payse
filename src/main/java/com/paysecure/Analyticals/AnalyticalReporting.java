package com.paysecure.Analyticals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.paysecure.actiondriver.ActionDriver;
import com.paysecure.base.baseClass;
import com.paysecure.locators.AnalyticaLReporting;
import com.paysecure.locators.allBanks;
import com.paysecure.locators.transaction_Page;
import com.paysecure.reportPage.transactionPage;

public class AnalyticalReporting {
	// navigate upto the - Analytical Reporting
	private By Analytics = By.xpath(AnalyticaLReporting.analytics);
	private By analyticalReporting = By.xpath(AnalyticaLReporting.analyticalReporting);

	// submit and Hadle Alert
	private By submit = By.xpath(AnalyticaLReporting.submit);
	private By ok = By.xpath(AnalyticaLReporting.ok);

	private By selectbank = By.xpath(transaction_Page.selectBank);
	private By searchFieldBank = By.xpath(transaction_Page.searchFieldBank);

	// select currency
	private By selectCurrency = By.xpath(AnalyticaLReporting.selectCurrency);

	// select from and to
	private By amountFrom = By.xpath(AnalyticaLReporting.amountFrom);
	private By amountTo = By.xpath(AnalyticaLReporting.amountTo);

	// sort by
	private By sortby = By.xpath(AnalyticaLReporting.sortBy);
	private By sorTOrder = By.xpath(AnalyticaLReporting.sortOrder);

	// group by
	private By selectGroupBy = By.xpath(AnalyticaLReporting.GroupBy);
	private By searchGroupBy = By.xpath(AnalyticaLReporting.searchGroupBy);
	private By gb = By.xpath(AnalyticaLReporting.gb);
	private By merchantnameFromTable = By.xpath(AnalyticaLReporting.merchantnameFromTable);

	private By getMerchant = By.xpath(AnalyticaLReporting.getMerchant);
	private By getMerchantFromTable = By.xpath(AnalyticaLReporting.getMerchantFromTable);

	// validations on the table
	private By allAttempt = By.xpath(AnalyticaLReporting.allAttempt);
	private By all_Attempt = By.xpath(AnalyticaLReporting.all_Attempt);
	private By noRecord = By.xpath(AnalyticaLReporting.noRecord);

	private By approvedAmount = By.xpath(AnalyticaLReporting.approvedAmount);
	private By approvedAttempt = By.xpath(AnalyticaLReporting.approvedAttempt);
	private By successrate = By.xpath(AnalyticaLReporting.successrate);

	private By getBankName = By.xpath(AnalyticaLReporting.getBankName);
	private By txnId = By.xpath(AnalyticaLReporting.txnId);
	private By getBankNameFromTxnDetails = By.xpath(AnalyticaLReporting.getBankNameFromTxnDetails);

	private By getCurrencyFromSelected = By.xpath(AnalyticaLReporting.getCurrencyFromSelected);
	private By getCurrencyFromTXN = By.xpath(AnalyticaLReporting.getCurrencyFromTXN);
	private By filter = By.xpath(AnalyticaLReporting.filter);
	private By allMerchantName = By.xpath(AnalyticaLReporting.allMerchantName);
	private By nextButton = By.xpath(AnalyticaLReporting.nextButton);
	
	private By selectColumns = By.xpath(AnalyticaLReporting.selectColumns);
	//private By totalHeaders = By.xpath(AnalyticaLReporting.totalHeaders);
	@FindBy(xpath ="//table[@class='rightTable table table-bordered']//thead//th[@class='text-center colheader']") private List<WebElement> totalHeaders;
	
	private By selectColumnAllAttempt = By.xpath(AnalyticaLReporting.selectColumnAllAttempt);
	private By searchColumnName = By.xpath(AnalyticaLReporting.searchColumnName);
	
	private ActionDriver actionDriver;
	private WebDriver driver;

	// page factory constructor
	public AnalyticalReporting(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.actionDriver = new ActionDriver(driver);
	}

	public void navigateUptoAnalyticalReporting() throws InterruptedException {
		WebDriver driver = baseClass.getDriver();

		Reporter.log("Starting navigation to Analytical Reporting...", true);

		Thread.sleep(500);

		// Set custom browser window size (slightly above 800x600)
		driver.manage().window().setSize(new Dimension(1280, 720));
		Reporter.log("Browser window resized to 1024x640 for low-resolution testing.", true);

		// Scroll to the Analytics section
		actionDriver.scrollToElement(Analytics);
		Reporter.log("Scrolled to 'Analytics' section.", true);

		// Click Analytics (twice if needed)
		actionDriver.clickUsingJS(Analytics);
		Reporter.log("Clicked on 'Analytics' menu.", true);

		// Navigate to Analytical Reporting page
		actionDriver.click(analyticalReporting);
		Reporter.log("Clicked on 'Analytical Reporting' sub-menu.", true);

		Reporter.log("Navigation to Analytical Reporting completed successfully.", true);

		//driver.manage().window().setSize(new Dimension(1920, 1080));
		//Reporter.log("Browser window resized to 1920*1080 for low-resolution testing.", true);
	}

	public void handleAlertInAnalyticReport() throws InterruptedException {
		WebDriver driver = baseClass.getDriver();
		Reporter.log("Attempting to click on 'Submit' button in Analytic Report.", true);
		actionDriver.click(submit);
		Reporter.log("Clicked on 'Submit' button.", true);
		actionDriver.safeClick(ok, 10);
		Reporter.log("Clicked on 'OK' button in alert popup.", true);
	}

	// --------------------------------------------------------------

	public void selectDashboardusinAllBank(String bankName, String finalBankName) throws InterruptedException {
		WebDriver driver = baseClass.getDriver();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));

		Reporter.log("Attempting to click on 'Select Bank' dropdown.", true);
		actionDriver.click(selectbank);
		Reporter.log("Clicked on 'Select Bank' dropdown.", true);

		Reporter.log("Clearing existing text in bank search field.", true);
		actionDriver.clearText(searchFieldBank);

		Reporter.log("Entering partial bank name: " + bankName, true);
		actionDriver.enterText(searchFieldBank, bankName);

		Reporter.log("Waiting for bank name suggestions to appear.", true);
		List<WebElement> suggestions = w.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='select2-bankname-results']/li")));

		for (WebElement s : suggestions) {
			if (finalBankName.equalsIgnoreCase(s.getText().trim())) {
				Thread.sleep(1000);
				s.click();
				Reporter.log("Selected bank name: " + finalBankName, true);
				break;
			}
		}

		Reporter.log("Completed bank selection from list.", true);
	}

	// --------------------------------------------------------------

	public void selectCurrency(WebDriver driver, String currency) throws InterruptedException {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		Reporter.log("Waiting for 'Currency' dropdown to become interactable.", true);
		Thread.sleep(4000);

		Reporter.log("Selecting currency: " + currency, true);
		actionDriver.selectByVisibleText(selectCurrency, currency);

		Thread.sleep(4000);
		Reporter.log("Successfully selected currency: " + currency, true);
	}

	// --------------------------------------------------------------

	public void enterAmountFromAndTo(String AmountFrom, String AmountTo) {
		Reporter.log("Entering 'Amount From': " + AmountFrom, true);
		actionDriver.sendKeysWithActions(amountFrom, AmountFrom);

		Reporter.log("Entering 'Amount To': " + AmountTo, true);
		actionDriver.sendKeysWithActions(amountTo, AmountTo);

		Reporter.log("Entered amount range successfully (From: " + AmountFrom + ", To: " + AmountTo + ")", true);
	}

	// --------------------------------------------------------------

	public void selectSortByDropdown(String sortBy) {
		Reporter.log("Selecting Sort By option: " + sortBy, true);
		actionDriver.selectByVisibleText(sortby, sortBy);
		Reporter.log("Sort By option selected successfully: " + sortBy, true);
	}

	// --------------------------------------------------------------

	public void selectSortOrderDropdown(String sortOrder) {
		Reporter.log("Selecting Sort Order option: " + sortOrder, true);
		actionDriver.selectByVisibleText(sorTOrder, sortOrder);
		Reporter.log("Sort Order option selected successfully: " + sortOrder, true);
	}

	// --------------------------------------------------------------

	public void selectGroupByDropdown(String partialGroupByName, String groupBy) throws InterruptedException {
		WebDriver driver = baseClass.getDriver();
		Reporter.log("Clicking on 'Group By' dropdown.", true);
		actionDriver.click(selectGroupBy);

		Reporter.log("Typing partial group name: " + partialGroupByName, true);
		actionDriver.sendKeysWithActions(searchGroupBy, partialGroupByName);

		Reporter.log("Fetching list of available group options.", true);
		List<WebElement> allGroupBy = driver
				.findElements(By.xpath("(//ul[@class='multiselect-container dropdown-menu'])[1]/li/a/label"));

		for (WebElement all : allGroupBy) {
			if (groupBy.equalsIgnoreCase(all.getText().trim())) {
				Thread.sleep(1000);
				all.click();
				Reporter.log("Selected group by name: " + groupBy, true);
				break;
			}
		}

		Reporter.log("Completed selection of Group By dropdown option.", true);
	}

	// --------------------------------------------------------------

	public void clickOnSubmitButton() {
		Reporter.log("Attempting to click on 'Submit' button.", true);
		actionDriver.click(submit);
		Reporter.log("Clicked on 'Submit' button successfully.", true);
	}

	// --------------------------------------------------------------

	public void clickOnTheGroupBy() {
		Reporter.log("Attempting to click on 'Group By' button.", true);
		actionDriver.click(gb);
		Reporter.log("Clicked on 'Group By' button successfully.", true);
	}

	// --------------------------------------------------------------

	public void verifyMerchantnameInTable() {
		Reporter.log("Verifying Merchant Name displayed in table.", true);
		String merchantnameFromTableText = actionDriver.getText(merchantnameFromTable);
		Reporter.log("Fetched Merchant Name from table: " + merchantnameFromTableText, true);
		Assert.assertEquals(merchantnameFromTableText, "MERCHANTNAME");
		Reporter.log("Merchant Name verification passed successfully.", true);
	}

	// --------------------------------------------------------------

	public void getMerchant() {
		// Get merchant name from the main page/input
		String typeMerchant = actionDriver.getText(getMerchant);
		Reporter.log("Fetched merchant from input field: " + typeMerchant, true);

		// Get merchant name from the table
		String getMerchantFromTableText = actionDriver.getText(getMerchantFromTable);
		Reporter.log("Fetched merchant from table: " + getMerchantFromTableText, true);

		// Compare and log result
		try {
			Assert.assertEquals(typeMerchant, getMerchantFromTableText);
			Reporter.log("✅ Merchant names match successfully. Expected = Actual = " + typeMerchant, true);
		} catch (AssertionError e) {
			Reporter.log(
					"❌ Merchant names mismatch! Expected: " + typeMerchant + ", but found: " + getMerchantFromTableText,
					true);
			throw e; // rethrow to mark the test failed
		}
	}

	// -----------------If User select only group by and Select merchant
	// only---------------------------------------------
	/*
	 * 1)Verify if status count is paid then check count of All attempt is same
	 * 2)Verify If According to count of paid check amount is same or not 3)Verify
	 * if Transaction is succeeded then Approved rate is 100 % 4)Verify All
	 * transaction amount is same as total amount and approved amount 5)Verify that
	 * if user select x merchant name then in merchant field same name displays or
	 * not.
	 * 
	 * 10/15/2025 1)Verify if User select any bank from select Bank then verify that
	 * that perticular bank is should be present in to that purchaseID 2)Verify that
	 * if user selected bank 'x' then check if data is not displays then No record
	 * found
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public int attemptCount;

	public void checkStatusOfTable() {
		if (actionDriver.isDisplayed(allAttempt)) {
			String attemptText = actionDriver.getText(allAttempt);
			attemptCount = Integer.parseInt(attemptText);

			Reporter.log("Table record found: " + attemptText, true);
			System.out.println(attemptText);
		} else {
			String noRecordText = actionDriver.getText(noRecord);
			Reporter.log("No records found in the table: " + noRecordText, true);
			System.out.println(noRecordText);
		}
	}

	public void getTransactionCountFromTransactionPage() throws InterruptedException {
		transactionPage tp = new transactionPage(driver);
		tp.navigateUptoTransaction();
		tp.filterTransactionThroughSelectStatus("Paid");
		tp.selectDashboardusinAllMerchant("Suhas", "SuhasM");
		tp.clickOnSearchButton();
		tp.checkTransactionStatus();

	}

	public void verifyPaidCountFromtransactionPageAndAnalyticalReport() throws InterruptedException {
		transactionPage ts = new transactionPage(driver);
		navigateUptoAnalyticalReporting();
		selectGroupByDropdown("Mer", "MerchantName");
		ts.selectDashboardusinAllMerchant("suhas", "SuhasM");
		clickOnSubmitButton();
		verifyMerchantnameInTable();
		getMerchant();
		checkStatusOfTable();
		Assert.assertEquals(ts.uiRowCount, attemptCount);
	}

	public double totalAmount;

	public void fetchAmounts() {
		WebDriver driver = baseClass.getDriver();
		actionDriver.scrollToElement(getMerchantFromTable);
		actionDriver.click(getMerchantFromTable);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[@id='analyticTransStats']/tr/td[5]")));
		List<WebElement> amountElements = driver.findElements(By.xpath("//tbody[@id='analyticTransStats']/tr/td[5]"));

		totalAmount = 0.0;
		List<String> amountList = new ArrayList<>();

		for (WebElement element : amountElements) {
			String text = element.getText().trim();
			amountList.add(text);
			try {
				double amount = Double.parseDouble(text.replaceAll("[^\\d.]", ""));
				totalAmount += amount;
			} catch (NumberFormatException e) {
				System.out.println("Skipping invalid value: " + text);
			}
		}

		System.out.println("All Amounts: " + amountList);
		System.out.println("Total Amount: " + totalAmount);

	}

	public double aprvAmt;

	public void getAmountFromAprroveAmount() {
		String apprvAmount = actionDriver.getText(approvedAmount);

		// Logging the retrieved approval amount
		Reporter.log("Retrieved approved amount: " + apprvAmount, true); // true for adding the log to the console
																			// output

		aprvAmt = Double.parseDouble(apprvAmount);

		// Logging the parsed approval amount
		Reporter.log("Parsed approval amount: " + aprvAmt, true);

		System.out.println(aprvAmt);
	}

	public void verifyAmt() {
		// Logging the verification step
		Reporter.log("Verifying approval amount against total amount", true);

		try {
			Assert.assertEquals(aprvAmt, totalAmount);
			// Logging a success message
			Reporter.log("Approval amount matches total amount: " + aprvAmt, true);
		} catch (AssertionError e) {
			// Logging failure message in case of mismatch
			Reporter.log("Verification failed: Approval amount (" + aprvAmt + ") does not match total amount ("
					+ totalAmount + ")", true);
			throw e; // Rethrow the exception after logging it
		}
	}

	public void verifySuccesRateFor100Percet() {
		String appAmt = actionDriver.getText(approvedAttempt);
		String alLAttempt = actionDriver.getText(allAttempt);

		// Logging the retrieved values
		Reporter.log("Retrieved approved attempt: " + appAmt, true);
		Reporter.log("Retrieved all attempts: " + alLAttempt, true);

		// Compare the values and log the result
		if (appAmt.equals(alLAttempt)) {
			// Logging success when values match
			Reporter.log("Approved attempt matches all attempts. Retrieving success rate.", true);

			String successRate = actionDriver.getText(successrate);
			// Logging the success rate value
			Reporter.log("Success rate: " + successRate, true);

			System.out.println(successRate); // Optionally print the success rate as well
		} else {
			// Logging failure if values do not match
			Reporter.log("Approved attempt does not match all attempts. No success rate available.", true);
		}
	}

	public void verifySuccessRate() {
		// Step 1: Fetch text values from UI
		String appAmt = actionDriver.getText(approvedAttempt);
		String alLAttempt = actionDriver.getText(allAttempt);
		String sr = actionDriver.getText(successrate);

		Reporter.log("Approved Attempts (from UI): " + appAmt, true);
		Reporter.log("All Attempts (from UI): " + allAttempt, true);
		Reporter.log("Success Rate (from UI): " + sr, true);

		// Step 2: Clean and parse success rate value
		String tr = sr.replace("%", "").trim();
		double successRateFromUI = Double.parseDouble(tr);
		Reporter.log("Parsed Success Rate (numeric): " + successRateFromUI, true);

		// Step 3: Convert attempts to numeric values
		double approvedAttemptVal = Double.parseDouble(appAmt);
		double allAttemptVal = Double.parseDouble(alLAttempt);
		Reporter.log("Approved Attempt (numeric): " + approvedAttemptVal, true);
		Reporter.log("All Attempt (numeric): " + allAttemptVal, true);

		// Step 4: Calculate expected success rate
		double calculated = (approvedAttemptVal / allAttemptVal) * 100;
		double rounded = Math.round(calculated * 100.0) / 100.0;
		Reporter.log("Calculated Success Rate (Rounded): " + rounded, true);

		// Step 5: Assertion
		Assert.assertEquals(successRateFromUI, rounded, "❌ Mismatch between UI and calculated success rate!");

		Reporter.log("✅ Success rate verification passed. Expected and Actual: " + rounded + "%", true);
	}

	public void getTextFromSelectBank() {
		// Step 1: read title attribute from table row (bank name)
		String bankTitle = actionDriver.getAttribute(getBankName, "title");
		Reporter.log("Read bank title attribute (from list): " + bankTitle, true);
		System.out.println(bankTitle);

		// Step 2: navigate to merchant row and open txn details

		actionDriver.scrollToElement(getMerchantFromTable);
		Reporter.log("Scrolling to merchant row element...", true);

		actionDriver.click(getMerchantFromTable);
		Reporter.log("Clicking merchant row to open details...", true);

		actionDriver.clickUsingJS(txnId);

		Reporter.log("Clicking txnId (using JS) to open transaction details...", true);

		// Step 3: read bank name from transaction details and compare
		String bankNameFromTxnDetails = actionDriver.getText(getBankNameFromTxnDetails);
		Reporter.log("Bank name from transaction details: " + bankNameFromTxnDetails, true);
		System.out.println(bankNameFromTxnDetails);

		// Assertion with logging
		Reporter.log("Asserting that bank title from list equals bank name in transaction details...", true);
		Assert.assertEquals(bankTitle, bankNameFromTxnDetails,
				"Bank name mismatch between list and transaction details");

		Reporter.log("Assertion passed: bank name matches.", true);
	}

	public void verifySelectedCurrencyIsPresentOnTheTXNID() {

		String getCurrencyFromCurrencyField = actionDriver.getAttribute(getCurrencyFromSelected, "title");
		actionDriver.scrollToElement(getMerchantFromTable);
		Reporter.log("Scrolling to merchant row element...", true);

		actionDriver.click(getMerchantFromTable);
		Reporter.log("Clicking merchant row to open details...", true);

		actionDriver.clickUsingJS(txnId);
		Reporter.log("Clicking txnId (using JS) to open transaction details...", true);

		String getcrnFromFreqency = actionDriver.getText(getCurrencyFromTXN);

		Assert.assertEquals(getCurrencyFromCurrencyField, getcrnFromFreqency);

	}

	List<String> merchanTNames;
    public void verifyCheckStatusAccordingToAnalyticalAndReport() {
		WebDriver driver = baseClass.getDriver();
		merchanTNames = new ArrayList<>();
		List<WebElement> listOfAllMerchant = driver
				.findElements(By.xpath("//table[@class='leftTable table table-bordered']/tbody/tr/td/div/a[1]"));

		for (WebElement merchant : listOfAllMerchant) {
			String name = merchant.getText().trim();
			if (!name.isEmpty()) {
				merchanTNames.add(name);
			}
		}

		Reporter.log("Fetched merchant names: " + merchanTNames, true);
	}

	public void getApprovedAttempt() {
		WebDriver driver = baseClass.getDriver();
		List<String> paidTransactions = new ArrayList<>();
		
		
		List<WebElement> allAprvdAtmpt = driver.findElements(By.xpath("//table[@class='rightTable table table-bordered']/tbody//td[6]"));
		
		for(WebElement a:allAprvdAtmpt) {
			String ffwf = a.getText().trim();
			
			if(!ffwf.isEmpty()) {
				paidTransactions.add(ffwf);
			}
		}
		Reporter.log("Fetched Approved attempts: " + paidTransactions, true);
		
		
		List<Integer> intList=new ArrayList<>();
		
		for(String p:paidTransactions) {
			intList.add(Integer.parseInt(p));
		}
		
		System.out.println("convert string list into Integer List :- "+intList);
		
		
		

	}
	
	
	public void verifySortingAndCheckAnalyticalReporting() {
		
		
		
		
		
	}
	
	
	public void verifySortByForAllAttempt() {

	    WebDriver driver = baseClass.getDriver();

	    Reporter.log("---- Starting verification for All_Attempt sorting ----", true);

	    // Locate all the cells in the "Approved Attempt" column
	    List<WebElement> ApprovedAttempt = driver.findElements(
	        By.xpath("//table[@class='rightTable table table-bordered']//tbody/tr/td[1]")
	    );

	    // Log the values before sorting
	    for (WebElement a : ApprovedAttempt) {
	        Reporter.log("Unsorted All_Attempt value: " + a.getText(), true);
	    }

	    // Convert text values to integers
	    List<Integer> aprvdAttempt = new ArrayList<>();
	    for (WebElement a : ApprovedAttempt) {
	        String text = a.getText().trim();
	        if (!text.isEmpty()) {
	            aprvdAttempt.add(Integer.parseInt(text));
	        }
	    }

	    Reporter.log("Original list from UI: " + aprvdAttempt, true);

	    // Create a copy and sort descending
	    List<Integer> newArrayList = new ArrayList<>(aprvdAttempt);
	    Collections.sort(newArrayList, Collections.reverseOrder());

	    Reporter.log("Expected (Descending) list: " + newArrayList, true);

	    // Assertion
	    Assert.assertEquals(aprvdAttempt, newArrayList, 
	        "❌ All_Attempt column is NOT sorted in descending order.");

	    Reporter.log("✅ All_Attempt column is correctly sorted in descending order.", true);
	    Reporter.log("---- Verification completed for All_Attempt ----", true);
	}


	public void verifySortedForAmountApproved() {

	    WebDriver driver = baseClass.getDriver();

	    Reporter.log("---- Starting verification for Amount_Approved sorting ----", true);

	    // Locate the column for Amount Approved
	    List<WebElement> ApprovedAttempt = driver.findElements(
	        By.xpath("//table[@class='rightTable table table-bordered']//tbody/tr/td[2]")
	    );

	    // Log raw UI values
	    for (WebElement a : ApprovedAttempt) {
	        Reporter.log("Unsorted Amount_Approved value:  " + a.getText(), true);
	    }

	    List<Double>   amtAprvd=new ArrayList<>();
	    for(WebElement a:ApprovedAttempt) {
	    	String text = a.getText().trim();
	    	if(!text.isEmpty()) {
	    		String cleantext = text.replace(",", "");
	    		amtAprvd.add(Double.parseDouble(cleantext));
	    	}
	    }
	 
	    List<Double> newApprovedAMount = new ArrayList<>(amtAprvd);
	    Collections.sort(newApprovedAMount,Collections.reverseOrder());
	    
	    Assert.assertEquals(amtAprvd, newApprovedAMount);

	    Reporter.log("✅ Amount_Approved column is correctly sorted in descending order.", true);
	    Reporter.log("---- Verification completed for Amount_Approved ----", true);
	}
	
	public void afterSortedAmountRefundedCheckCorrectlySortedORNot() {
	    WebDriver driver = baseClass.getDriver();
	    
	    Reporter.log("---- Starting verification for Amount_Refunded sorting ----", true);

	    List<WebElement> unsoretedListOfAmountRefunded = driver.findElements(By.xpath("//table[@class='rightTable table table-bordered']//tbody/tr/td[4]"));

	    Reporter.log("Fetching Amount_Refunded values from the table...", true);
	    
	    for(WebElement unsortedAmountRefunded : unsoretedListOfAmountRefunded) {
	        Reporter.log("Unsorted Amount_Refunded value: " + unsortedAmountRefunded.getText().trim(), true);
	    }

	    Reporter.log("Parsing and cleaning Amount_Refunded values...", true);
	    
	    List<Double> amountRefunded = new ArrayList<>();

	    for(WebElement and : unsoretedListOfAmountRefunded) {
	        String text = and.getText().trim();
	        String cleanText = text.replace(",", "");
	        if(!text.isEmpty()) {
	            amountRefunded.add(Double.parseDouble(cleanText));
	        }
	    }
	    

	    Reporter.log("Total Amount_Refunded values parsed: " + amountRefunded.size(), true);
	    Reporter.log("Creating sorted copy for comparison...", true);
	    
	    List<Double> sortAmountRefunded = new ArrayList<>(amountRefunded);

	    Collections.sort(sortAmountRefunded, Collections.reverseOrder());

	    Reporter.log("Verifying if Amount_Refunded is sorted in descending order...", true);
	    
	    Assert.assertEquals(amountRefunded, sortAmountRefunded);

	    Reporter.log("✅ Amount_Refunded column is correctly sorted in descending order.", true);
	    Reporter.log("---- Verification completed for Amount_Refunded ----", true);
	}
	
	
	public void verifySortByForAllAttemptWithPagination() {

	    WebDriver driver = baseClass.getDriver();
	    driver.manage().window().maximize();
	    Reporter.log("---- Starting verification for All_Attempt sorting (with pagination) ----", true);

	    List<Integer> allPageValues = new ArrayList<>();

	    while (true) {

	        // Step 1: Collect all rows from the current page
	        List<WebElement> ApprovedAttempt = driver.findElements(
	            By.xpath("//table[@class='rightTable table table-bordered']//tbody/tr/td[1]")
	        );

	        for (WebElement a : ApprovedAttempt) {
	            String text = a.getText().trim();
	            if (!text.isEmpty()) {
	                allPageValues.add(Integer.parseInt(text));
	            }
	        }

	        Reporter.log("Fetched values so far: " + allPageValues.size(), true);

	        // Step 2: Locate the 'Next' button container
	        WebElement nextButtonContainer = driver.findElement(By.xpath("//li[contains(@class,'page-item next')]"));
	        String classAttr = nextButtonContainer.getAttribute("class");

	        // Step 3: Check if 'Next' button is disabled
	        if (classAttr.contains("disabled")) {
	            Reporter.log("Reached last page. No more pagination.", true);
	            break;
	        }

	        // Step 4: Click the actual <a> inside the li element
	        WebElement nextButton = nextButtonContainer.findElement(By.tagName("a"));
	       actionDriver.clickUsingJS(this.nextButton);

	        Reporter.log("Navigating to next page...", true);

	    }

	    Reporter.log("Total records fetched across all pages: " + allPageValues.size(), true);
	    Reporter.log("Collected list from UI: " + allPageValues, true);

	    // Step 5: Validate sorting (Descending)
	    List<Integer> sortedList = new ArrayList<>(allPageValues);
	    Collections.sort(sortedList, Collections.reverseOrder());

	    Reporter.log("Expected (Descending) list: " + sortedList, true);

	    Assert.assertEquals(allPageValues, sortedList, "❌ All_Attempt column is NOT sorted in descending order.");

	    Reporter.log("✅ All_Attempt column is correctly sorted in descending order across all pages.", true);
	    Reporter.log("---- Verification completed ----", true);
	}
	
	
	public void verifySortByForAmountApproveddWithPagination() {
		
		  WebDriver driver = baseClass.getDriver();
		  driver.manage().window().maximize();
		  
		  List<Double> amountAprv = new ArrayList<>();
		
		  while(true) {
			List<WebElement> AmtApprove = driver.findElements(By.xpath("//table[@class='rightTable table table-bordered']//tbody/tr/td[2]"));
			
			for(WebElement rejAprv:AmtApprove) {
			String text = rejAprv.getText().trim();
			if(!text.isEmpty()) {
				String cleantext = text.replace(",", "");
				amountAprv.add(Double.parseDouble(cleantext));
			}
			}
			
		       Reporter.log("Fetched values so far: " + amountAprv.size(), true);

		        // Step 2: Locate the 'Next' button container
		        WebElement nextButtonContainer = driver.findElement(By.xpath("//li[contains(@class,'page-item next')]"));
		        String classAttr = nextButtonContainer.getAttribute("class");

		        // Step 3: Check if 'Next' button is disabled
		        if (classAttr.contains("disabled")) {
		            Reporter.log("Reached last page. No more pagination.", true);
		            break;
		        }

		        // Step 4: Click the actual <a> inside the li element
		        WebElement nextButton = nextButtonContainer.findElement(By.tagName("a"));
		       actionDriver.clickUsingJS(this.nextButton);

		        Reporter.log("Navigating to next page...", true);
			
			
		 }
		    Reporter.log("Total records fetched across all pages: " + amountAprv.size(), true);
		    Reporter.log("Collected list from UI: " + amountAprv, true);

		    // Step 5: Validate sorting (Descending)
		    List<Double> sortedList = new ArrayList<>(amountAprv);
		    Collections.sort(sortedList, Collections.reverseOrder());

		    Reporter.log("Expected (Descending) list: " + sortedList, true);

		    Assert.assertEquals(amountAprv, sortedList, "❌ All_Attempt column is NOT sorted in descending order.");

		    Reporter.log("✅ amountAprv column is correctly sorted in descending order across all pages.", true);
		    Reporter.log("---- Verification completed ----", true);
		
	}
	
	
	public void verifySortByForAmountRefundedWithPagination() {
		WebDriver driver=baseClass.getDriver();
		driver.manage().window().maximize();
		
		List<Double> amtRefunded=new ArrayList<Double>();
		
		while(true) {
		List<WebElement> AmountRefunded = driver.findElements(By.xpath("//table[@class='rightTable table table-bordered']//tbody/tr/td[4]"));    
		
		for(WebElement ar:AmountRefunded) {
			String text = ar.getText().trim();
			String cleanText = text.replace(",", "");
			if(!cleanText.isEmpty()) {
				amtRefunded.add(Double.parseDouble(cleanText));
			}
		}
		
		 Reporter.log("Fetched values so far: " + amtRefunded.size(), true);

	        // Step 2: Locate the 'Next' button container
	        WebElement nextButtonContainer = driver.findElement(By.xpath("//li[contains(@class,'page-item next')]"));
	        String classAttr = nextButtonContainer.getAttribute("class");

	        // Step 3: Check if 'Next' button is disabled
	        if (classAttr.contains("disabled")) {
	            Reporter.log("Reached last page. No more pagination.", true);
	            break;
	        }

	        // Step 4: Click the actual <a> inside the li element
	        WebElement nextButton = nextButtonContainer.findElement(By.tagName("a"));
	       actionDriver.clickUsingJS(this.nextButton);

	        Reporter.log("Navigating to next page...", true);
		
		
	}
	    Reporter.log("Total records fetched across all pages: " + amtRefunded.size(), true);
	    Reporter.log("Collected list from UI: " + amtRefunded, true);

	    // Step 5: Validate sorting (Descending)
	    List<Double> sortedList = new ArrayList<>(amtRefunded);
	    Collections.sort(sortedList, Collections.reverseOrder());

	    Reporter.log("Expected (Descending) list: " + sortedList, true);

	    Assert.assertEquals(amtRefunded, sortedList, "❌ All_Attempt column is NOT sorted in descending order.");

	    Reporter.log("✅ amtRefunded column is correctly sorted in descending order across all pages.", true);
	    Reporter.log("---- Verification completed ----", true);
	
	
	}
	
	public void verifySortByForAmountRejectedWithPagination() {
		WebDriver driver=baseClass.getDriver();
		driver.manage().window().maximize();
		
		List<Double> amtRejected=new ArrayList<>();
		
		while(true) {
		List<WebElement> AmountRej = driver.findElements(By.xpath("//table[@class='rightTable table table-bordered']//tbody/tr/td[5]"));    
		
		for(WebElement ar:AmountRej) {
			String text = ar.getText().trim();
			String cleanText = text.replace(",", "");
			if(!cleanText.isEmpty()) {
				amtRejected.add(Double.parseDouble(cleanText));
			}
		}
		
		 Reporter.log("Fetched values so far: " + amtRejected.size(), true);

	        // Step 2: Locate the 'Next' button container
	        WebElement nextButtonContainer = driver.findElement(By.xpath("//li[contains(@class,'page-item next')]"));
	        String classAttr = nextButtonContainer.getAttribute("class");

	        // Step 3: Check if 'Next' button is disabled
	        if (classAttr.contains("disabled")) {
	            Reporter.log("Reached last page. No more pagination.", true);
	            break;
	        }

	        // Step 4: Click the actual <a> inside the li element
	        WebElement nextButton = nextButtonContainer.findElement(By.tagName("a"));
	       actionDriver.clickUsingJS(this.nextButton);

	        Reporter.log("Navigating to next page...", true);
		
		
	}
	    Reporter.log("Total records fetched across all pages: " + amtRejected.size(), true);
	    Reporter.log("Collected list from UI: " + amtRejected, true);

	    // Step 5: Validate sorting (Descending)
	    List<Double> sortedList = new ArrayList<>(amtRejected);
	    Collections.sort(sortedList, Collections.reverseOrder());

	    Reporter.log("Expected (Descending) list: " + sortedList, true);

	    Assert.assertEquals(amtRejected, sortedList, "❌ All_Attempt column is NOT sorted in descending order.");

	    Reporter.log("✅ amtRejected column is correctly sorted in descending order across all pages.", true);
	    Reporter.log("---- Verification completed ----", true);
	
	
	}
	
	public void verifySortByForAprvd_AttemptWithPagination() {
		WebDriver driver=baseClass.getDriver();
		driver.manage().window().maximize();
		
		List<Integer> AprvdAttempt=new ArrayList<>();
		
		while(true) {
		List<WebElement> aprdAttempt = driver.findElements(By.xpath("//table[@class='rightTable table table-bordered']//tbody/tr/td[6]"));    
		
		for(WebElement ar:aprdAttempt) {
			String text = ar.getText().trim();
			String cleanText = text.replace(",", "");
			if(!cleanText.isEmpty()) {
				AprvdAttempt.add(Integer.parseInt(cleanText));
			}
		}
		
		 Reporter.log("Fetched values so far: " + AprvdAttempt.size(), true);

	        // Step 2: Locate the 'Next' button container
	        WebElement nextButtonContainer = driver.findElement(By.xpath("//li[contains(@class,'page-item next')]"));
	        String classAttr = nextButtonContainer.getAttribute("class");

	        // Step 3: Check if 'Next' button is disabled
	        if (classAttr.contains("disabled")) {
	            Reporter.log("Reached last page. No more pagination.", true);
	            break;
	        }

	        // Step 4: Click the actual <a> inside the li element
	        WebElement nextButton = nextButtonContainer.findElement(By.tagName("a"));
	       actionDriver.clickUsingJS(this.nextButton);

	        Reporter.log("Navigating to next page...", true);
		
		
	}
	    Reporter.log("Total records fetched across all pages: " + AprvdAttempt.size(), true);
	    Reporter.log("Collected list from UI: " + AprvdAttempt, true);

	    // Step 5: Validate sorting (Descending)
	    List<Integer> sortedList = new ArrayList<>(AprvdAttempt);
	    Collections.sort(sortedList, Collections.reverseOrder());

	    Reporter.log("Expected (Descending) list: " + sortedList, true);

	    Assert.assertEquals(AprvdAttempt, sortedList, "❌ AprvdAttempt column is NOT sorted in descending order.");

	    Reporter.log("✅ AprvdAttempt column is correctly sorted in descending order across all pages.", true);
	    Reporter.log("---- Verification completed ----", true);
	
	
	}
	
	public void verifySortByForFailed_AttemptWithPagination() {
		WebDriver driver=baseClass.getDriver();
		driver.manage().window().maximize();
		
		List<Integer> FailedAttempt=new ArrayList<>();
		
		while(true) {
		List<WebElement> fldAttempt = driver.findElements(By.xpath("//table[@class='rightTable table table-bordered']//tbody/tr/td[10]"));    
		
		for(WebElement ar:fldAttempt) {
			String text = ar.getText().trim();
			String cleanText = text.replace(",", "");
			if(!cleanText.isEmpty()) {
				FailedAttempt.add(Integer.parseInt(cleanText));
			}
		}
		
		 Reporter.log("Fetched values so far: " + FailedAttempt.size(), true);

	        // Step 2: Locate the 'Next' button container
	        WebElement nextButtonContainer = driver.findElement(By.xpath("//li[contains(@class,'page-item next')]"));
	        String classAttr = nextButtonContainer.getAttribute("class");

	        // Step 3: Check if 'Next' button is disabled
	        if (classAttr.contains("disabled")) {
	            Reporter.log("Reached last page. No more pagination.", true);
	            break;
	        }

	        // Step 4: Click the actual <a> inside the li element
	        WebElement nextButton = nextButtonContainer.findElement(By.tagName("a"));
	       actionDriver.clickUsingJS(this.nextButton);

	        Reporter.log("Navigating to next page...", true);
		
		
	}
	    Reporter.log("Total records fetched across all pages: " + FailedAttempt.size(), true);
	    Reporter.log("Collected list from UI: " + FailedAttempt, true);

	    // Step 5: Validate sorting (Descending)
	    List<Integer> sortedList = new ArrayList<>(FailedAttempt);
	    Collections.sort(sortedList, Collections.reverseOrder());

	    Reporter.log("Expected (Descending) list: " + sortedList, true);

	    Assert.assertEquals(FailedAttempt, sortedList, "❌ AprvdAttempt column is NOT sorted in descending order.");

	    Reporter.log("✅ AprvdAttempt column is correctly sorted in descending order across all pages.", true);
	    Reporter.log("---- Verification completed ----", true);
	
	
	}
	
	public void verifySortByForTotalAmountWithPagination() {
		WebDriver driver=baseClass.getDriver();
		driver.manage().window().maximize();
		
		List<Double> TotalAmount=new ArrayList<>();
		
		while(true) {
		List<WebElement> fldAttempt = driver.findElements(By.xpath("//table[@class='rightTable table table-bordered']//tbody/tr/td[12]"));    
		
		for(WebElement ar:fldAttempt) {
			String text = ar.getText().trim();
			String cleanText = text.replace(",", "");
			if(!cleanText.isEmpty()) {
				TotalAmount.add(Double.parseDouble(cleanText));
			}
		}
		
		 Reporter.log("Fetched values so far: " + TotalAmount.size(), true);

	        // Step 2: Locate the 'Next' button container
	        WebElement nextButtonContainer = driver.findElement(By.xpath("//li[contains(@class,'page-item next')]"));
	        String classAttr = nextButtonContainer.getAttribute("class");

	        // Step 3: Check if 'Next' button is disabled
	        if (classAttr.contains("disabled")) {
	            Reporter.log("Reached last page. No more pagination.", true);
	            break;
	        }

	        // Step 4: Click the actual <a> inside the li element
	        WebElement nextButton = nextButtonContainer.findElement(By.tagName("a"));
	       actionDriver.clickUsingJS(this.nextButton);

	        Reporter.log("Navigating to next page...", true);
		
		
	}
	    Reporter.log("Total records fetched across all pages: " + TotalAmount.size(), true);
	    Reporter.log("Collected list from UI: " + TotalAmount, true);

	    // Step 5: Validate sorting (Descending)
	    List<Double> sortedList = new ArrayList<>(TotalAmount);
	    Collections.sort(sortedList, Collections.reverseOrder());

	    Reporter.log("Expected (Descending) list: " + sortedList, true);

	    Assert.assertEquals(TotalAmount, sortedList, "❌ TotalAmount column is NOT sorted in descending order.");

	    Reporter.log("✅ TotalAmount column is correctly sorted in descending order across all pages.", true);
	    Reporter.log("---- Verification completed ----", true);
	
	
	}
	
	public void checkSelectedColumns() {
	    WebDriver driver = baseClass.getDriver();
	    driver.manage().window().maximize();

	    // Get header text (if any from selectColumns element)
	    String totalHeader = actionDriver.getText(selectColumns);
	    Reporter.log("Total Header Text (from selectColumns): " + totalHeader, true);
	    
	    String th = totalHeader.replaceAll("[^0-9]", "");
	    int totalTh = Integer.parseInt(th);
	    
	    System.out.println("th :- "+th);

	    // Locate all <th> headers
	    List<WebElement> totalHeaders = driver.findElements(
	        By.xpath("//table[@class='rightTable table table-bordered']//thead//th[@class='text-center colheader']")
	    );
	    int thQuantity = totalHeaders.size();
	    
	    Reporter.log("Total number of headers found: " + totalHeaders.size(), true);
	    
	    Reporter.log("Expected header count: " + totalTh, true);
	    Reporter.log("Actual header count found: " + thQuantity, true);

	    Assert.assertEquals(thQuantity, totalTh, 
	        "❌ Header count mismatch! Expected: " + totalTh + " but found: " + thQuantity);

	    Reporter.log("✅ Header count verified successfully — Found exactly " + totalTh + " headers.", true);

	}

	public void verifyIfUserUnSelectedAnyColumnAndCheckForItsSize() {
		actionDriver.clickUsingJS(selectColumns);
		Reporter.log("User click on the again All Columns", true);
		
		actionDriver.enterText(searchColumnName, " ALL_ATTEMPT");
		
		actionDriver.clickUsingJS(selectColumnAllAttempt);
	    Reporter.log("Clicked on 'Select Columns' and unselected 'All Attempt'.", true);
	    
	    clickOnSubmitButton();
	    
	 // Get column text
	    String totalColumns = actionDriver.getText(selectColumns);
	    Reporter.log("Select Columns Text: " + totalColumns, true);

	    // Verify if '11' is present in the text (for debugging)
	    boolean contains11 = totalColumns.contains("11");
	    System.out.println(contains11);
	    Reporter.log("Does Select Columns text contain '11'? : " + contains11, true);

	    // Store all table headers
	    List<String> totalHeadersAnalyticalReporting = new ArrayList<>();
	    for (WebElement th : totalHeaders) {
	        totalHeadersAnalyticalReporting.add(th.getText());
	        Reporter.log("Captured Header: " + th.getText(), true);
	    }

	    // Log header count
	    Reporter.log("Total Header Count Found: " + totalHeadersAnalyticalReporting.size(), true);
	    Reporter.log("All Headers: " + totalHeadersAnalyticalReporting, true);

	    // Assertion
	    Assert.assertEquals(totalHeadersAnalyticalReporting.size(), 11, 
	        "Header count mismatch — Expected 11 but found " + totalHeadersAnalyticalReporting.size());
	    Reporter.log("Assertion Passed: Header count matches expected 11", true);

		
	}
	
	/*
	 * Validate if user directly use sort order then first column will be sorted - depends on the sort order
	 * Validate if user selected sort by then apply sort order then selected column from sort by this column will be sorted - depends upon sort order
	 */
	public void validateSortOrder() {
		WebDriver driver=baseClass.getDriver();
	    // Step 1: Select Ascending or Descending order
	    selectSortOrderDropdown("Ascending"); // or "Ascending" as needed
	    clickOnSubmitButton();
	    List<Integer> allPageValues = new ArrayList<>();

	    // Step 2: Collect all numeric values from the column
	    List<WebElement> AllAttempt = driver.findElements(
	        By.xpath("//table[@class='rightTable table table-bordered']//tbody/tr/td[1]")
	    );

	    for (WebElement a : AllAttempt) {
	        String text = a.getText().trim();
	        if (!text.isEmpty()) { // ensure numeric
	            allPageValues.add(Integer.parseInt(text));
	        }
	    }

	    Reporter.log("Fetched values from UI: " + allPageValues, true);

	    // Step 3: Create a copy and sort descending
	    List<Integer> expectedList = new ArrayList<>(allPageValues);
	    Collections.sort(expectedList);

	    Reporter.log("Expected (Descending) order: " + expectedList, true);

	    // Step 4: Assertion
	    Assert.assertEquals(allPageValues, expectedList,
	        "❌ The column is NOT sorted in descending order.");

	    Reporter.log("✅ The column is correctly sorted in descending order.", true);
	    Reporter.log("---- Verification completed for All_Attempt ----", true);
	}
	

}
