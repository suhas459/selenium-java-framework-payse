package com.paysecure.reportPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.paysecure.actiondriver.ActionDriver;
import com.paysecure.base.baseClass;
import com.paysecure.locators.transaction_Page;
import com.paysecure.utilities.DBConnection;

public class transactionPage {

	// scrolling point of view
	private By analytics = By.xpath(transaction_Page.analytics);
	private By lastStatus = By.xpath(transaction_Page.lastStatus);

	// report
	private By report = By.xpath(transaction_Page.report);

	private By transactions = By.xpath(transaction_Page.transactions);

	// filter transaction through select status
	private By selectStatus = By.xpath(transaction_Page.selectStatus);

	@FindBy(xpath = "//select[@id='status']")
	private WebElement SELECT_STATUS;

	private By status = By.xpath(transaction_Page.status);

	// search button
	private By searchButton = By.xpath(transaction_Page.searchButton);

	// filter through select merchant
	private By selectmerchant = By.xpath(transaction_Page.selectmerchant);
	private By searchmerchant = By.xpath(transaction_Page.searchmerchant);
	private By selectSearchmerchantCheckbox = By.xpath(transaction_Page.selectSearchmerchantCheckbox);
	private By getMerchantNameFromTXNPage=By.xpath(transaction_Page.getMerchantNameFromTXNPage);

	// filter through select Bank
	private By selectbank = By.xpath(transaction_Page.selectBank);
	private By searchFieldBank = By.xpath(transaction_Page.searchFieldBank);
	private By selectBankFromSearchFiled = By.xpath(transaction_Page.selectBankFromSearchField);
	private By getbankNameFromBankField=By.xpath(transaction_Page.getbankNameFromBankField);

	// select MID
	private By selectMID = By.xpath(transaction_Page.selectMid);
	private By date = By.xpath(transaction_Page.date);
	private By dateRanges = By.xpath(transaction_Page.dateRanges);

	private By dateFrom = By.xpath(transaction_Page.dateFrom);
	private By dateTo = By.xpath(transaction_Page.dateTo);
	private By notRecordFount = By.xpath(transaction_Page.noRecordFound);
	private By applyButton = By.xpath(transaction_Page.applyButton);

	// select timezone
	private By title = By.xpath(transaction_Page.title);
	private By selectTimeZone = By.xpath(transaction_Page.selectTimeZone);
	private By timeZones = By.xpath(transaction_Page.timeZones);
	private By searchFieldTimeZones = By.xpath(transaction_Page.searchFieldTimeZones);
	private By timeZoneRollBox = By.xpath(transaction_Page.timeZoneRollBox);

	// select currency
	private By selectCurrency = By.xpath(transaction_Page.selectCurrency);
	private By getCurrencyFromCurrencyField = By.xpath(transaction_Page.getCurrencyFromCurrencyField);
	private By getCurrencyFromTable = By.xpath(transaction_Page.getCurrencyFromTable);

	// Last actions in a Transaction page table
	private By lastAction = By.xpath(transaction_Page.lastAction);
	private By transactionId = By.xpath(transaction_Page.transactionId);

	@FindBy(xpath = "(//button[@title='Last Action'])[1]")
	private WebElement TRANSACTION_ID;

	private By appProperties = By.xpath(transaction_Page.appProperties);
	private By cancelButtonOnLastAction = By.xpath(transaction_Page.cancelButtonOnLastAction);

	// Action - Download invoice
	private By downloadInvoice = By.xpath(transaction_Page.downloadInvoice);
	private By generate = By.xpath(transaction_Page.generate);
	private By errorMessageForEmailImage = By.xpath(transaction_Page.errorMessageForEmailImage);
	private By addProduct = By.xpath(transaction_Page.addProduct);
	private By companyName = By.xpath(transaction_Page.companyName);
	private By companyAddress = By.xpath(transaction_Page.companyAddress);
	private By companyEmail = By.xpath(transaction_Page.companyEmail);
	private By companyLogo = By.xpath(transaction_Page.companyLogo);
	private By resizeImage = By.xpath(transaction_Page.resizeImage);
	private By tableErrorMessage = By.xpath(transaction_Page.tableErrorMessage);
	private By description = By.xpath(transaction_Page.description);
	private By quantity = By.xpath(transaction_Page.quantity);
	private By unitPrice = By.xpath(transaction_Page.unitPrice);
	private By amount = By.xpath(transaction_Page.amount);

	@FindBy(xpath = "//input[@class='form-control amount']")
	private WebElement total_amount;
	@FindBy(xpath = "//input[@class='form-control quantity']")
	private WebElement totalQuantity;
	@FindBy(xpath = "//input[@class='form-control unitPrice']")
	private WebElement totalUnitPrice;

	// History button in Transaction Table
	private By history = By.xpath(transaction_Page.history);
	private By statusHistory = By.xpath(transaction_Page.statusHistory);
	private By historyTransaction = By.xpath(transaction_Page.historyTransaction);
	private By cancelButtonOnHistory = By.xpath(transaction_Page.cancelButtonOnHistory);
	@FindBy(xpath = transaction_Page.statusHistory)
	private WebElement STATUS_HISTORY;

	// Remarks button in Transaction table
	private By remarks = By.xpath(transaction_Page.remarks);
	private By remarksTransactionId = By.xpath(transaction_Page.remarksTransactionId);
	private By sendMessageButton = By.xpath(transaction_Page.sendMessageButton);
	private By errorMessage = By.xpath(transaction_Page.errorMessage);
	@FindBy(xpath = transaction_Page.remarksTransactionId)
	private WebElement TRANSACTION_ID_;

	@FindBy(xpath = transaction_Page.errorMessage)
	private WebElement ERROR_MESSAGE;

	private By cancelRemarks = By.xpath(transaction_Page.cancelRemarks);
	private By message = By.xpath(transaction_Page.message);
	private By ok = By.xpath(transaction_Page.ok);
	private By userType = By.xpath(transaction_Page.userType);
	private By selectUserType = By.xpath(transaction_Page.selectUserType);
	private By users = By.xpath(transaction_Page.users);
	private By selectError = By.xpath(transaction_Page.selectError);
	private By errorMessageTextarea = By.xpath(transaction_Page.errorMessageTextarea);
	private By successMessage = By.xpath(transaction_Page.successMessage);

	@FindBy(xpath = "//button[@class='swal2-confirm swal2-styled']")
	private WebElement OKButton;

	@FindBy(xpath = transaction_Page.userType)
	private WebElement USERTYPE;

	@FindBy(xpath = transaction_Page.selectUserType)
	private WebElement SELECT_USERTYPE;

	@FindBy(xpath = transaction_Page.selectError)
	private WebElement SELECT_ERROR;

	private By grandTotal = By.xpath(transaction_Page.grandTotal);

	// nextButton
	private By nextBtn = By.xpath(transaction_Page.nextBtn);
	private By entries = By.xpath(transaction_Page.entries);
	private By reportRange = By.xpath(transaction_Page.reportRange);
	private By multiSelectedMerchant = By.xpath(transaction_Page.multiSelectedMerchant);
	
	//search any transaction
	private By transactionSearch = By.xpath(transaction_Page.transactionSearch);

	// transaction table - element

	private By firsttxnBtn = By.xpath(transaction_Page.firsttxnBtn);
	private By getBankNameFrmTxnInfoPopUp=By.xpath(transaction_Page.getBankNameFrmTxnInfoPopUp);
	@FindBy(xpath = transaction_Page.transactionTableId)
	private WebElement Transaction_;

	@FindBy(xpath = transaction_Page.transactionTableAmount)
	private WebElement Amount_;

	@FindBy(xpath = transaction_Page.transactionTableCurrency)
	private WebElement Currency_;

	@FindBy(xpath = transaction_Page.orderId)
	private WebElement orderID;

	@FindBy(xpath = transaction_Page.currencyLabel)
	private WebElement Curr;

	@FindBy(xpath = transaction_Page.amountLabel)
	private WebElement amt;
	
	@FindBy(xpath = "//input[@id='logoImageforUpload']")
	private WebElement logo;
	
	private By getMerchntNameFromLastAction=By.xpath("(//tbody[@id='lastActionList']//td)[4]");
	private By getStatusFromLastAction=By.xpath("(//tbody[@id='lastActionList']//td)[6]");
	private By merchantNameFromTXNPage = By.xpath(transaction_Page.merchantNameFromTXNPage);
	private By lastStatusFromTxnPage = By.xpath(transaction_Page.lastStatusFromTxnPage);
	// variable directory
	String partialMerchantname = "SuhasM";
	String merchant = "mukesh1";
	String bankName = "Delhi";
	String finalBankName = "Delhi Lo";

	// variable for change status
	final static String status1 = "Error";

	// variable for SELECT MID
	final static String MID = "dvxv";

	// Date Range -- please select from it
	/*
	 * Today Yesterday Last 7 Days This Week Last 30 Days This Month Last Month
	 * Custom Range
	 */
	final static String dateRange = "Last 7 Days";
//	final static String date_To="10";
//	final static String date_From="20";

	// select - time zone
	final static String time_ZOne = "Asia/Hong_Kong";

	// select - currency
	//final static String currency = "USD";

	// Transaction remarks success message
	final static String expectedSuccessMessage = "Message sent successfully";

	private ActionDriver actionDriver;
	DBConnection db;

	// page factory constructor
	public transactionPage(WebDriver driver) {
		// WebDriver driver=baseClass.getDriver();
		PageFactory.initElements(driver, this);
		this.actionDriver = new ActionDriver(driver);
	}

	// code

	public void navigateUptoTransaction() throws InterruptedException {
//		String html = driver.getPageSource();
//	//	System.out.println(html); // print in console
//
//		// Define the folder and file name
//		String folderPath = "C:\\Downloads";
//		String filePath = folderPath + "\\page.html";
//
//		try {
//		    // Create the folder if it doesn't exist
//		    File folder = new File(folderPath);
//		    if (!folder.exists()) {
//		        folder.mkdirs(); // Create all necessary directories
//		        System.out.println("Created folder: " + folderPath);
//		    }
//
//		    // Write the HTML content to file
//		    try (FileWriter writer = new FileWriter(filePath)) {
//		        writer.write(html);
//		        System.out.println("HTML saved at: " + filePath);
//		    }
//
//		} catch (IOException e) {
//		    e.printStackTrace();
//		}

		
		WebDriver driver = baseClass.getDriver();
		Thread.sleep(500);
		driver.manage().window().setSize(new Dimension(1280, 720));// 1920 × 1080

		actionDriver.scrollToElement(analytics);
		actionDriver.clickUsingJS(report);

		actionDriver.clickUsingJS(transactions);
		// Assert.fail();
		driver.manage().window().setSize(new Dimension(1920, 1080));

	}

	public void filterTransactionThroughSelectStatus(String SelectStatus) throws InterruptedException {
		WebDriver driver = baseClass.getDriver();
		Thread.sleep(500);
		driver.manage().window().setSize(new Dimension(1280, 720));
		actionDriver.selectByVisibleText(selectStatus, SelectStatus);

	}

	public void clickOnSearchButton() throws InterruptedException {

		WebDriver driver = baseClass.getDriver();
		Thread.sleep(500);
		driver.manage().window().setSize(new Dimension(1280, 720));
	//	actionDriver.clickUsingJS(searchButton);
		Thread.sleep(2000);	
		actionDriver.clickUsingJS(searchButton);
		Thread.sleep(2000);	
		Reporter.log("User click on Search Buttton", true);
		
	}

	public int uiRowCount = 0; // Number of rows shown in UI table
	public int uiTotalCountFromLabel = 0; // Number extracted from the label text

	public void checkTransactionStatus() throws InterruptedException {
		WebDriver driver = baseClass.getDriver();
		Thread.sleep(500);
		driver.manage().window().setSize(new Dimension(1280, 720));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		try {
			// Wait until either rows or "No records" message appears
			wait.until(ExpectedConditions.or(
					ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//tbody[@id='filterTransStats']/tr")),
					ExpectedConditions.presenceOfElementLocated(By.xpath("//td[text()='No Records Found']"))));

			// Check if 'No Records Found' is displayed
			List<WebElement> noRecordElements = driver.findElements(By.xpath("//td[text()='No Records Found']"));
			if (!noRecordElements.isEmpty() && noRecordElements.get(0).isDisplayed()) {
				System.out.println("'No Records Found' message is displayed.");
				uiRowCount = 0;
				uiTotalCountFromLabel = 0;
				return;
			}

			// Get all rows in the table
			List<WebElement> tableRows = driver.findElements(By.xpath("//tbody[@id='filterTransStats']/tr"));

			if (tableRows.isEmpty()) {
				System.out.println("Table is present but contains no rows.");
				uiRowCount = 0;
				uiTotalCountFromLabel = 0;
			} else {
				uiRowCount = tableRows.size();
				System.out.println("Table has rows: " + uiRowCount);

				if (uiRowCount >= 10) {
					// Only try to fetch paging info if multiple pages exist
					try {
						String totalCountText = driver.findElement(By.xpath("(//span[@class='pagingInfoLbl'])[3]"))
								.getText();
						System.out.println("Total entries (from label): " + totalCountText);

						uiTotalCountFromLabel = Integer.parseInt(totalCountText.trim());
					} catch (NoSuchElementException e) {
						System.out.println("Paging label not found. Defaulting to row count.");
						uiTotalCountFromLabel = uiRowCount;
					} catch (NumberFormatException e) {
						System.out.println("Could not parse total count from label.");
						uiTotalCountFromLabel = uiRowCount;
					}
				} else {
					// If less than 10 rows → total = row count
					uiTotalCountFromLabel = uiRowCount;
				}
			}

		} catch (Exception e) {
			System.out.println("Error while checking transaction status: " + e.getMessage());
			uiRowCount = 0;
			uiTotalCountFromLabel = 0;
		}
	}

	public void selectDashboardusinAllMerchant(String partialMerchantname, String merchant)
		throws InterruptedException {
	//	WebDriver driver = baseClass.getDriver();
		WebDriver driver = baseClass.getDriver();
		Thread.sleep(500);
		driver.manage().window().setSize(new Dimension(1280, 720));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(2000);
		actionDriver.clickUsingJS(selectmerchant);

		
	
		Reporter.log("click on the select merchant filed", true);
		Thread.sleep(2000);
		w.until(ExpectedConditions.elementToBeClickable(searchmerchant)).sendKeys(partialMerchantname);
		Reporter.log("Enter merchant name in a search merchant functioanlity", true);

		Thread.sleep(2000);

		List<WebElement> suggestions = w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//*[text()='Select Merchant']/../following-sibling::ul/li[not(@class)]")));

		for (WebElement s : suggestions) {
			if (merchant.equalsIgnoreCase(s.getText().trim())) {
				Thread.sleep(1000);
				s.click();
				Reporter.log("select merchant name :- " + merchant, true);
				break;

			}
		}
		Reporter.log("select merchant from all merchnat", true);

	}
	
	
	
	/*----------------------Select multiple Merchant --------------------------*/
	
//	private By selecTMerchant=By.xpath("//select[@id='merchantList']");
//	public void selectSecondMerchant() throws InterruptedException {
//		actionDriver.selectByVisibleText(selecTMerchant, "Amitkumar");
//	}

	
	public void selectMerchant(String partialMerchantName, String merchant) {
	    WebDriver driver = baseClass.getDriver();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    
		actionDriver.clickUsingJS(multiSelectedMerchant);
        Reporter.log("click on the select merchant filed", true);

	    // 1. Enter partial text in search
	    WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(searchmerchant));
	    searchBox.clear();
	
		//clearmerchantField();
	    searchBox.sendKeys(partialMerchantName);
	    Reporter.log("Entered merchant search text: " + partialMerchantName, true);

	    // 2. Build dynamic XPath with exact match
	    String xpath = String.format(
	        "//ul[@class='multiselect-container dropdown-menu']//label[normalize-space(text())='%s']/input[@type='checkbox']",
	        merchant
	    );

	    // 3. Wait for that element to appear
	    WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

	    // 4. Click if not already selected
	    if (!checkbox.isSelected()) {
	        checkbox.click();
	    }

	    Reporter.log(" Selected merchant: " + merchant, true);
	}

	

	
	public void clearmerchantField() throws InterruptedException {
      
		Thread.sleep(1500);
		
		actionDriver.clearText(searchmerchant);
		
		
		
		
	}
	


	public void selectDashboardusinAllBank( String bankName, String finalBankName)
			throws InterruptedException {
		WebDriver driver=baseClass.getDriver();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		actionDriver.click(selectbank);

		org.testng.Reporter.log("click on Select Bank", true);

		// actionDriver.sendKeysWithActions(searchFieldBank,bankname);

		actionDriver.enterText(searchFieldBank, bankName);

		Reporter.log("Enter Merchnat bank name in a Search Bank name text field", true);
		List<WebElement> suggestions = w.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='select2-bnk-results']/li")));

		for (WebElement s : suggestions) {
			if (finalBankName.equalsIgnoreCase(s.getText().trim())) {
				Thread.sleep(1000);
				s.click();
				Reporter.log("select merchant name :- " + bankName, true);
				break;

			}
		}
		Reporter.log("select Bank from all Bank", true);

		Reporter.log("select Merchant Bank from all Merchant bank", true);
	}

	public void selectMID(String MID) throws InterruptedException {
		Thread.sleep(2000);
		actionDriver.selectByVisibleText(selectMID, MID);

		Reporter.log("Select MID from MID dropdown"+MID, true);

	}

	public void selectDateRange(String date_Range) throws InterruptedException {
		
		WebDriver driver = baseClass.getDriver();
		Thread.sleep(500);
		driver.manage().window().setSize(new Dimension(1280, 720));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(2000);
		actionDriver.click(date);
		// utility.scrollToElement(driver, applyButton);
		Reporter.log("Click on the Date range", true);
		List<WebElement> suggestions = w.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='ranges']/descendant::li")));

		for (WebElement s : suggestions) {
			if (date_Range.equalsIgnoreCase(s.getText().replaceAll("//s", ""))) {
				Thread.sleep(1000);
				s.click();
				Reporter.log("select date range :- " + date_Range, true);
				break;

			}
		}
	}

	public String reportTime;

	public String getReportrangeForDB() throws InterruptedException {
		WebDriver driver = baseClass.getDriver();
		Thread.sleep(500);
		driver.manage().window().setSize(new Dimension(1280, 720));
		 reportTime = actionDriver.getText(reportRange);
		 System.err.println(reportTime);
		 return reportTime;
	}

	public void selectDate_To(WebDriver driver) throws InterruptedException {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
//		actionDriver.click(dateTo);
//		actionDriver.click(dateFrom);
//		
//				w.until(ExpectedConditions.elementToBeClickable(dateTo)).click();
//				w.until(ExpectedConditions.elementToBeClickable(dateFrom)).click();

		Thread.sleep(2000);
		actionDriver.clickUsingJS(dateFrom);
		Reporter.log("select date range :- " + dateFrom, true);
		Thread.sleep(4000);
		actionDriver.clickUsingJS(dateTo);
		Reporter.log("select date range :- " + dateTo, true);
		Thread.sleep(4000);
//				Actions a=new Actions(driver);
//				a.click(ERROR_MESSAGE)
//				a.click(dateTo).build().perform();

	}

	public void clickOnApplyButton(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		// w.until(ExpectedConditions.elementToBeClickable(applyButton)).click();
		actionDriver.clickUsingJS(applyButton);
	}

	public void selectTimeZone(WebDriver driver) throws InterruptedException {

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(4000);

		actionDriver.selectByVisibleText(selectTimeZone, time_ZOne);
		Thread.sleep(4000);
		Reporter.log("Select Time Zone :- " + time_ZOne, true);

		WebElement tm1 = w.until(ExpectedConditions.presenceOfElementLocated(By.id("select2-tZone-container")));

		String tm = tm1.getAttribute("title");

		// String tm = TimeZoneRollBox.getAttribute("role");
		Assert.assertEquals(time_ZOne, tm, "if this time zone is not match then our TC is should be fail");
		Thread.sleep(4000);
	}

	public void selectCurrency(WebDriver driver,String currency) throws InterruptedException {

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(4000);

		actionDriver.selectByVisibleText(selectCurrency, currency);

		Thread.sleep(4000);
		Reporter.log("Select currency from currency dropdown :- " + currency, true);

		WebElement tm1 = w.until(ExpectedConditions.presenceOfElementLocated(By.id("select2-merCurr-container")));

		String tm = tm1.getAttribute("title");

		Assert.assertEquals(currency, tm, "if this time zone is not match then our TC is should be fail");
		Thread.sleep(4000);
		Reporter.log("Assertion passed: selected currency matches", true);

	}
	public String txnID;
	public String mcName;
	public String lsTxnPage;

	public void getMerchantNameTxnIDAndLastStatusFromTransactionPage() {
	    txnID = actionDriver.getText(firsttxnBtn);
	    mcName = actionDriver.getText(merchantNameFromTXNPage);
	    lsTxnPage = actionDriver.getText(lastStatusFromTxnPage);
	    
	    Reporter.log("Transaction Page Details Captured:", true);
	    Reporter.log("Txn ID: " + txnID, true);
	    Reporter.log("Merchant Name: " + mcName, true);
	    Reporter.log("Last Status (Txn Page): " + lsTxnPage, true);
	}

	public String merchantNameLastAct;
	public String statusLastAct;
    public String txnIDFromTransactionPage;
	public void getMerchantNameStatusAndLastActionFromTxnPage() {
	    merchantNameLastAct = actionDriver.getText(getMerchntNameFromLastAction);
	    statusLastAct = actionDriver.getText(getStatusFromLastAction);
	    txnIDFromTransactionPage=actionDriver.getText(firsttxnBtn);

	    Reporter.log("Last Action Details Captured:", true);
	    Reporter.log("Merchant Name (Last Action): " + merchantNameLastAct, true);
	    Reporter.log("Status (Last Action): " + statusLastAct, true);
	}

	public void verifyMCNameStatusInLastAction() {
	    Reporter.log("Verifying Merchant Name and Status between Transaction Page and Last Action...", true);
	    Reporter.log("Comparing Merchant Name: " + mcName + " == " + merchantNameLastAct, true);
	    Reporter.log("Comparing Status: " + lsTxnPage + " == " + statusLastAct, true);
	    
	    Assert.assertEquals(mcName, merchantNameLastAct, "Merchant Name mismatch!");
	    Assert.assertEquals(statusLastAct, lsTxnPage, "Status mismatch!");

	    Reporter.log("Verification Successful: Merchant Name and Status match between Transaction Page and Last Action.", true);
	}
	
	

	public void lastActionOnTransactionTable(WebDriver driver) throws InterruptedException {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));

		boolean lastAct = actionDriver.isEnabled(lastAction);
		System.out.println("last Action button is enable for clicking:-"+lastAct);
		Reporter.log("Verfi Last Action button is enable for clicking", true);
		
		actionDriver.click(lastAction);

		Reporter.log("Click on the Last Action Button in transaction Table", true);
		
		getMerchantNameStatusAndLastActionFromTxnPage();
		verifyMCNameStatusInLastAction();

		Thread.sleep(2500);
		Assert.assertTrue(actionDriver.isDisplayed(transactionId));

		Reporter.log("Verified transaction id test is present on Last action", true);

		WebElement transaction_Id = w.until(ExpectedConditions.visibilityOf(TRANSACTION_ID));
		if (actionDriver.isDisplayed(transactionId)) {

			System.out.println("Transaction ID is displays on Last Action");

		}
		Thread.sleep(2000);
		List<WebElement> appPropertys = w.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tbody[@id='lastActionList']/tr")));
		for (WebElement app : appPropertys) {
			System.out.println(app.getText());
		}

		actionDriver.click(cancelButtonOnLastAction);

		Reporter.log("Click on the Cancel  Button", true);

	}
	public String txnFromHistoryPopUp;

	public void getTxnIDFromHistoryPopUp() {
	    Reporter.log("Fetching Transaction ID from History Popup...", true);

	    String cjsdc = actionDriver.getText(historyTransaction);
	    Reporter.log("Raw text from History Popup: " + cjsdc, true);

	    txnFromHistoryPopUp = cjsdc.split(":")[1].trim();
	    Reporter.log("Extracted Transaction ID from History Popup: " + txnFromHistoryPopUp, true);

	    Reporter.log("Comparing Transaction ID from History Popup with Transaction Page...", true);
	    Reporter.log("History Popup Txn ID: " + txnFromHistoryPopUp + " | Transaction Page Txn ID: " + txnIDFromTransactionPage, true);

	    Assert.assertEquals(txnFromHistoryPopUp, txnIDFromTransactionPage, "Transaction ID mismatch between History Popup and Transaction Page!");

	    Reporter.log("Verification Successful: Transaction ID matches between History Popup and Transaction Page.", true);
	}


	public void historyOnTransaction(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		//getMerchantNameStatusAndLastActionFromTxnPage();
		boolean histry = actionDriver.isEnabled(history);
		System.out.println("history button is enable for clicking:-"+histry);
		Reporter.log("Verfi history button is enable for clicking", true);
		actionDriver.click(history);
		getTxnIDFromHistoryPopUp();
		Reporter.log("Click on the History Button in transaction Table", true);

		WebElement status_History = w.until(ExpectedConditions.visibilityOf(STATUS_HISTORY));
		Assert.assertTrue(actionDriver.isDisplayed(statusHistory), "element is not displays");

		 //check headers in history tab
        
		// expected headers in History tab
		 List<String> expectedValues = Arrays.asList("DATE", "STATUS", "UPDATED BY");

		 List<WebElement> actualValues = w.until(
		 ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//table[@class='table table-bordered'])[4]//th")));
		 List<String>  actvalues=new ArrayList<>();
		 for(WebElement acv:actualValues) {
			 actvalues.add(acv.getText().trim());
		 }
		 Assert.assertEquals(actvalues, expectedValues, "Mismatch in element listvalues");
//
		// w.until(ExpectedConditions.elementToBeClickable(cancelButtonOnHistory)).click();

		actionDriver.click(cancelButtonOnHistory);

		Reporter.log("Click on the Cancel  Button", true);

	}

	public void remarksOnTransactiontable(WebDriver driver) {

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));

		boolean lastAct = actionDriver.isEnabled(remarks);
		Reporter.log("Verfi remarks button is enable for clicking", true);
		actionDriver.click(remarks);

		Reporter.log("Click on the Remarks Button in transaction Table", true);

		WebElement remarks_TransactionID = w.until(ExpectedConditions.visibilityOf(TRANSACTION_ID_));

		// Assert.assertTrue(!remarks_TransactionID.isEnabled(), "this field is
		// enable");
		Assert.assertFalse(!actionDriver.isDisplayed(remarksTransactionId));

		Reporter.log("Veirifies Transaction ID on Remarks page is disabled", true);

		actionDriver.click(cancelRemarks);

		Reporter.log("Click on the Cancel  Button", true);

	}

	public void verifyErrorInRemarksField(WebDriver driver) {

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));

		actionDriver.click(remarks);

		Reporter.log("Click on the Remarks Button in transaction Table", true);
		// utility.scrollToElement(driver, message);
		actionDriver.scrollToElement(message);

		actionDriver.click(sendMessageButton);
		Reporter.log("Click on the send message Button", true);

		String actualErrorMessage = "All input fields must be completed before submitting.";

		WebElement expectedErrormessage = w.until(ExpectedConditions.visibilityOf(ERROR_MESSAGE));

		Assert.assertEquals(actualErrorMessage, expectedErrormessage.getText(), "Error message is not same as Figma");
		Reporter.log("Verify error message ", true);

		actionDriver.clickUsingJS(cancelRemarks);

		// actionDriver.clickUsingJS(OK);
		OKButton.click();

		Reporter.log("Click on the OK  Button", true);
	}

	public void verifyElementsInUserType(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));


		actionDriver.click(remarks);
		Reporter.log("Click on the Remarks Button in transaction Table", true);

		// Scroll to the message element (custom utility)

		actionDriver.scrollToElement(message);

		// Wait until dropdown is present and visible
		wait.until(ExpectedConditions.visibilityOf(USERTYPE));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='usertype-select']"))); // Replace


		// Wrap the dropdown
		Select dropdown = new Select(USERTYPE);

		// Wait until options are loaded (dropdown must have more than 1 value)
		wait.until(driver1 -> dropdown.getOptions().size() > 1);

		// Expected values
		String[] expectedArray = { "Select a Users", "ADMIN", "FULLADMIN", "SUPERADMIN", "REPORTADMIN", "ACCOUNTADMIN",
				"MERCHANT", "AGENT" };
		List<String> expectedValues = Arrays.asList(expectedArray);

		// Get actual dropdown values
		List<String> actualValues = new ArrayList<>();
		for (WebElement option : dropdown.getOptions()) {
			actualValues.add(option.getText().trim());
		}

		// Log values
		System.out.println("Expected: " + expectedValues);
		System.out.println("Actual:   " + actualValues);

		// Assertions
		Assert.assertEquals(actualValues.size(), expectedValues.size(), "Mismatch in number of dropdown options.");
		for (String expected : expectedValues) {
			Assert.assertTrue(actualValues.contains(expected), "Missing dropdown value: " + expected);
		}
		System.out.println("✅ User type Dropdown values validated successfully.");

		actionDriver.click(cancelRemarks);
		Reporter.log("Click on the Cancel Button", true);

	}

	public void verifyUsers(WebDriver driver) throws InterruptedException {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));

		// w.until(ExpectedConditions.elementToBeClickable(remarks)).click();
		actionDriver.click(remarks);
		Reporter.log("Click on the Remarks Button in transaction Table", true);
		// utility.scrollToElement(driver, message);
		actionDriver.scrollToElement(message);
		Thread.sleep(3500);

		Assert.assertFalse(!SELECT_USERTYPE.isEnabled(), "select user type field is enabled");
		Reporter.log("when user click on Remarks then at initial stage select user type field is disabled", true);
		Thread.sleep(3500);
		actionDriver.selectByVisibleText(userType, "ADMIN");
		// utility.selectByVisibleText(userType, "ADMIN");

		Reporter.log("User select values from user type dropdown", true);
		Thread.sleep(3500);
		Assert.assertTrue(SELECT_USERTYPE.isEnabled(), "select user type field is enabled");

		Reporter.log("After selecting user type values then Select user type field is enabled", true);

		// utility.selectByVisibleText(users, "harshitaadmin");
		actionDriver.selectByVisibleText(users, "harshitaadmin");

	}
	


	public void selectError(WebDriver driver) {
		// utility.selectByVisibleText(selectError, "Expired card");
		actionDriver.selectByVisibleText(selectError, "Expired card");
		Reporter.log("User select a error", true);
	}

	public void checkAll_SelectError(WebDriver driver) throws InterruptedException {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));

		// w.until(ExpectedConditions.elementToBeClickable(remarks)).click();
		// Reporter.log("Click on the Remarks Button in transaction Table", true);
		actionDriver.scrollToElement(message);
		// utility.scrollToElement(driver, message);
		Select dropdown = new Select(SELECT_ERROR);

//	        List<WebElement> opt = dropdown.getOptions();
//	        Thread.sleep(2500);
//	        for(WebElement o:opt) {
//	        	System.out.println(o.getText());
//	        }

		// Using array and converting to list
		String[] expectedArray = { "Select a Error", "Invalid Phone Number", "Bank Decline", "Blocked Payment",
				"Insufficient Funds", "Expired card", "Payment gateway errors", "Security concerns", "Unknown errors" };
		List<String> expectedValues = Arrays.asList(expectedArray);

		// Getting actual values
		List<String> actualValues = new ArrayList<>();
		for (WebElement option : dropdown.getOptions()) {
			actualValues.add(option.getText().trim());
		}

		// Logging
		System.out.println("Expected: " + expectedValues);
		System.out.println("Actual:   " + actualValues);

		// Assertions
		Assert.assertEquals(actualValues.size(), expectedValues.size(), "Mismatch in number of dropdown options.");
		for (String expected : expectedValues) {
			Assert.assertTrue(actualValues.contains(expected), "Missing dropdown value: " + expected);
		}

	}

	public void enterMessage(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));

		w.until(ExpectedConditions.elementToBeClickable(errorMessageTextarea)).sendKeys("Your card hasb been expired");

		actionDriver.sendKeysWithActions(errorMessageTextarea, "Your card hasb been expired");

		Reporter.log("User enter Error message is Message Field", true);
	}

	public void clickOnSubmitButton(WebDriver driver) {

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		// w.until(ExpectedConditions.elementToBeClickable(sendMessageButton)).click();
		actionDriver.click(sendMessageButton);
		Reporter.log("User click on send message button", true);
	}

	public void verifySuccessmessage(WebDriver driver) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement messageElement = w.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Message sent successfully']")));

		String actualMessage = messageElement.getText().trim();
		System.out.println("Displayed Message: " + actualMessage);

		// Assertion
		Assert.assertEquals(actualMessage, expectedSuccessMessage, "❌ Message mismatch");

		Reporter.log("Message sent successfully is verified", true);

		w.until(ExpectedConditions.elementToBeClickable(ok)).click();

		Reporter.log("Click on OK button on success message", true);

	}

//	public void validateTransactiondataWithCSV(WebDriver driver) {
//		String csvPath = "C:\\Users\\LENOVO\\eclipse-workspace\\paySecure\\src\\test\\resources\\csv\\Transaction Report.csv";
//		List<Map<String, String>> csvData = CSVUtils.readCSV(csvPath);
//
//		for (int i = 0; i < csvData.size(); i++) {
//			Map<String, String> row = csvData.get(i);
//			String expectedTxnId = row.get("Transaction ID");
//			String expectedAmount = row.get("Amount");
//			String expectedStatus = row.get("Last Status");
//
//			// Example XPath — modify per your actual table row/column locators
//			String xpathBase = "//tbody[@id='filterTransStats']/tr";
//
//			String uiTxnId = driver.findElement(By.xpath(xpathBase + "/td[4]")).getText().trim();
//			String uiAmount = driver.findElement(By.xpath(xpathBase + "/td[8]")).getText().trim();
//			String uiStatus = driver.findElement(By.xpath(xpathBase + "/td[10]")).getText().trim();
//
//			System.out.println(uiTxnId);
//			System.out.println(expectedTxnId);
//
//			System.out.println(uiAmount);
//			System.out.println(expectedAmount);
//
//			// Assertions
//			Assert.assertEquals(uiTxnId, expectedTxnId, "Mismatch in Transaction ID at row: ");
//			Assert.assertEquals(uiAmount, expectedAmount, "Mismatch in Amount at row: ");
//			Assert.assertEquals(uiStatus.toUpperCase(), expectedStatus.toUpperCase(),
//					"Mismatch in Status at row: " + (i + 2));
//		}

	public void iterateAllTablePages(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		while (true) {
			// Wait and fetch all rows on current page
			List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
					By.xpath("(//table[@class='table table-bordered'])[2]/tbody[2]/tr")));

			System.out.println("Total rows on this page: " + rows.size());

			// Loop through rows (you can extract/validate each row as needed)
			for (WebElement row : rows) {
				String rowText = row.getText();
				System.out.println("Row Data: " + rowText);
			}

			// Check if Next button is disabled
			WebElement nextButtonContainer = driver.findElement(By.xpath("//li[contains(@class,'page-item next')]"));

			String classAttr = nextButtonContainer.getAttribute("class");

			if (classAttr.contains("page-item next disabled")) {
				System.out.println("Reached last page.");
				break;
			}

			actionDriver.clickUsingJS(nextBtn);

			// wait for some indicator that new page has loaded
			// wait.until(ExpectedConditions.stalenessOf(rows.get(0)));

		}

	}

	public void iterateAllTablePages1(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		int totalRowCount = 0;
		while (true) {
			// Wait and fetch all rows on current page
			List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
					By.xpath("(//table[@class='table table-bordered'])[2]/tbody[2]/tr")));

			int currentPageRowCount = rows.size();
			totalRowCount += currentPageRowCount;

			System.out.println("Rows on this page: " + currentPageRowCount);

			// Loop through rows (you can extract/validate each row as needed)
			for (WebElement row : rows) {
				String rowText = row.getText();
				System.out.println("Row Data: " + rowText);
			}

			// Check if Next button is disabled
			WebElement nextButtonContainer = driver.findElement(By.xpath("//li[contains(@class,'page-item next')]"));

			String classAttr = nextButtonContainer.getAttribute("class");

			if (classAttr.contains("page-item next disabled")) {
				System.out.println("Reached last page.");
				break;
			}

			actionDriver.clickUsingJS(nextBtn);

			// wait for some indicator that new page has loaded
			// wait.until(ExpectedConditions.stalenessOf(rows.get(0)));

		}
		System.out.println("🚀 Total rows across all pages: " + totalRowCount);
	}

	public void verifyDownloadInvoice(String Status) {
		Select s = new Select(SELECT_STATUS);
		s.selectByVisibleText(Status);
		Reporter.log("Verify user select status like " + Status, true);

		String st = s.getFirstSelectedOption().getText();

		if (st == "Paid") {
			System.out.println("Verify user selected status like :- " + st);
			Reporter.log("Verify status is selected ", true);
		}
		
		boolean downLoadInvoiCe = actionDriver.isEnabled(downloadInvoice);
		System.out.println("Download Invoice button is enable for clicking:-"+downLoadInvoiCe);
		Reporter.log("Verfi downloadInvoice button is enable for clicking", true);

		actionDriver.click(downloadInvoice);
		Reporter.log("User click on Download Invoice button", true);
	}
	
	public void searchTransaction(String transactionIDS) {
		actionDriver.enterText(transactionSearch, transactionIDS);
		Reporter.log("User enter transaction id in Transaction Field "+transactionIDS, true);
	}
	
	
	
	

	public void verifyErrorInDownloadInvoice_LogoAndComapanyEmail() {

		actionDriver.click(generate);
		Reporter.log("User click on generate button", true);

		actionDriver.scrollToElement(addProduct);

		String text = actionDriver.getText(errorMessageForEmailImage);
		String act = "Please fill logo Image, company Email.";

		Assert.assertEquals(text, act);
		Reporter.log("Verify error message for company Logo and Email", true);

	}



	public void verifyErrorInDownloadInvoice_addProduct() throws InterruptedException {
		WebDriver driver = new baseClass().getDriver();
		actionDriver.enterText(companyName, "Paysecure");
		Reporter.log("User Enter Company name", true);
		actionDriver.enterText(companyEmail, "paysecure@gmail.com");
		Reporter.log("User Enter Company Email address", true);
		actionDriver.enterText(companyAddress, "ganga Heights, jaipur");
		Reporter.log("User Enter Company address", true);

		logo.sendKeys("C:\\Users\\LENOVO\\Downloads\\am\\Automation-main\\src\\main\\resources\\Logo.jpg");

		// actionDriver.uploadFile(companyLogo,
		// ResourcePathUtil.getResourcePath("/paySe/src/main/resources/Logo.jpg"));
		Reporter.log("User Enter Company Logo", true);

		Thread.sleep(1500);

		if (actionDriver.isDisplayed(resizeImage)) {
			actionDriver.click(resizeImage);
		}

		actionDriver.click(addProduct);
		Reporter.log("User click on add product button", true);

		actionDriver.click(generate);
		Reporter.log("User click on generate button", true);

		String text = actionDriver.getText(tableErrorMessage);
		String act = "Please fill all fields correctly in row 1. Quantity and Unit Price must be greater than 0.";

		Assert.assertEquals(text, act);
		Reporter.log("Verify error message for table product", true);
	}

	@FindBy(xpath = "(//input[@class='form-control amount'])[1]")
	private WebElement Amount;

	public void verifyTotalAmountInDownloadInvoice(int qty, int unitPrice) {

		// Enter text and values
		actionDriver.enterText(description, "paysecure");
		totalQuantity.sendKeys(String.valueOf(qty));
		totalUnitPrice.sendKeys(String.valueOf(unitPrice));

		String totalAmountText = Amount.getAttribute("value");
		System.err.println(totalAmountText);

		String grand_Total = actionDriver.getText(grandTotal);
		Assert.assertEquals(totalAmountText, grand_Total);

	}

	

	public void checkCount() throws InterruptedException {
	    WebDriver driver = baseClass.getDriver();

	    filterTransactionThroughSelectStatus("Created");
	    Reporter.log("Filtered transactions by Status: Created", true);

	    selectDateRange("Today");
	    Reporter.log("Selected Date Range: Today", true);

	    clickOnSearchButton();
	    Reporter.log("Clicked on Search button", true);

	    checkTransactionStatus();
	    Reporter.log("Checked transaction status on UI", true);

	    DBConnection db = new DBConnection();
	    db.createConnectionForDB();
	    Reporter.log("DB connection established successfully", true);

	    @SuppressWarnings("static-access")
	    int dbCount = db.getTodaysTransactions("CREATED");

	    Reporter.log("UI total count: " + uiTotalCountFromLabel, true);
	    Reporter.log("DB total count: " + dbCount, true);

	    Assert.assertEquals(uiTotalCountFromLabel, dbCount,
	        "Mismatch between UI and DB transaction counts");

	    Reporter.log("UI and DB transaction counts matched successfully", true);
	}




	public void singleMerchantTodaysTransaction() throws InterruptedException {
		selectDashboardusinAllMerchant("Mnitendra", "Mnitendra");
		Reporter.log("Selected dashboard for merchant: Mnitendra", true);

		clickOnSearchButton();
		Reporter.log("Clicked on search button", true);

		checkTransactionStatus();
		Reporter.log("Checked transaction status from UI", true);

		DBConnection db = new DBConnection();
		db.createConnectionForDB();
		Reporter.log("Database connection created successfully", true);

		int countFromDB = db.getSingleMerchantTransaction("Mnitendra");
		Reporter.log("Fetched transaction count from DB: " + countFromDB, true);

		Reporter.log("Transaction count from UI label: " + uiTotalCountFromLabel, true);

		System.out.println(uiTotalCountFromLabel);
		System.out.println(countFromDB);

		Assert.assertEquals(uiTotalCountFromLabel, countFromDB,
				"Mismatch between UI and DB transaction count for merchant Mnitendra");
		Reporter.log("UI and DB transaction count matched successfully!", true);
	}

	public void singleMerchantAndSelectStatusTodaysTransaction(String staTus,String merchantname) throws InterruptedException {
		selectDashboardusinAllMerchant(merchantname, merchantname);
		Reporter.log("Selected dashboard for merchant:"+merchantname, true);

		filterTransactionThroughSelectStatus(staTus);

		clickOnSearchButton();
		Reporter.log("Clicked on search button", true);

		checkTransactionStatus();
		Reporter.log("Checked transaction status from UI", true);

		DBConnection db = new DBConnection();
		db.createConnectionForDB();
		Reporter.log("Database connection created successfully", true);

		int countFromDB = db.getTodaysTransactionsUsingStatusAndMerchant(staTus,merchantname);
		Reporter.log("Fetched transaction count from DB: " + countFromDB, true);

		Reporter.log("Transaction count from UI label: " + uiTotalCountFromLabel, true);

		System.out.println(uiTotalCountFromLabel);
		System.out.println(countFromDB);

		Assert.assertEquals(uiTotalCountFromLabel, countFromDB,
				"Mismatch between UI and DB transaction count for merchant Mnitendra");
		Reporter.log("UI and DB transaction count matched successfully!", true);
	}

	public void singlemerchantYesterdayTransaction() throws InterruptedException {
		selectDashboardusinAllMerchant("Mnitendra", "Mnitendra");
		Reporter.log("Selected dashboard for merchant: Mnitendra", true);

		selectDateRange("Yesterday");
		Reporter.log("Selected date range: Yesterday", true);

		clickOnSearchButton();
		Reporter.log("Clicked on search button", true);

		checkTransactionStatus();
		Reporter.log("Checked transaction status from UI", true);

		DBConnection db = new DBConnection();
		db.createConnectionForDB();
		Reporter.log("Database connection created successfully", true);

		int countFromDB = db.getYesterdaysTransactionsForSingleMerchant("Mnitendra");
		Reporter.log("Fetched transaction count from DB: " + countFromDB, true);

		Reporter.log("UI total count from label: " + uiTotalCountFromLabel, true);
		Reporter.log("UI row count from table: " + uiRowCount, true);

		System.out.println("UI Total Label: " + uiTotalCountFromLabel);
		System.out.println("DB Count: " + countFromDB);

		// ✅ Condition based on UI row count
		if (uiRowCount < 10) {
			Assert.assertEquals(uiRowCount, countFromDB,
					"Mismatch between UI and DB transaction count for merchant Mnitendra");
			Reporter.log("UI row count (" + uiRowCount + ") matched with DB count (" + countFromDB + ")", true);
		} else {
			Assert.assertEquals(uiTotalCountFromLabel, countFromDB,
					"Mismatch between UI and DB transaction count for merchant Mnitendra");
			Reporter.log("UI total label (" + uiTotalCountFromLabel + ") matched with DB count (" + countFromDB + ")",
					true);
		}
	}

	
	/*-------------------------------------------------------------------*/
	
	public void getStatusForNthDays() throws InterruptedException {

	    filterTransactionThroughSelectStatus("Paid");
	    Reporter.log("Filtered transactions by Status: Paid", true);

	    selectDateRange("Last 7 Days");
	    Reporter.log("Selected Date Range: Last 7 Days", true);

	    clickOnSearchButton();
	    Reporter.log("Clicked on Search button", true);

	    getReportrangeForDB();
	    Reporter.log("Fetched report range for DB validation", true);

	    checkTransactionStatus();
	    Reporter.log("Checked transaction status on UI", true);

	    DBConnection db = new DBConnection();
	    db.createConnectionForDB();
	    Reporter.log("DB connection established successfully", true);

	    db.DateToEpochSeconds(reportTime);
	    Reporter.log("Converted reportTime to epoch for DB query: " + reportTime, true);

	    int dbCount = db.getStatusCountForLastNDays("PAID");

	    Reporter.log("UI total count: " + uiTotalCountFromLabel, true);
	    Reporter.log("DB total count: " + dbCount, true);

	    Assert.assertEquals(uiTotalCountFromLabel, dbCount,
	        "Mismatch between UI and DB transaction counts");

	    Reporter.log("UI and DB transaction counts matched successfully", true);
	}


	
	
	/*-------------------------Transaction status and days -------------------------*/
	//Test case :- Select status and select date one by one and compare with db 
	
	public void selectDateRangeAndStatusAndCompareWithDB(String status, String datERange) throws InterruptedException {

	    filterTransactionThroughSelectStatus(status);
	    Reporter.log("Filtered transactions by Status: " + status, true);

	    selectDateRange(datERange);
	    Reporter.log("Selected Date Range: " + datERange, true);

	    clickOnSearchButton();
	    Reporter.log("Clicked on Search button", true);

	    getReportrangeForDB();
	    Reporter.log("Fetched report range for DB validation", true);

	    checkTransactionStatus();
	    Reporter.log("Checked transaction status on UI", true);

	    DBConnection db = new DBConnection();
	    db.createConnectionForDB();
	    Reporter.log("DB connection established successfully", true);

	    db.DateToEpochSeconds(reportTime);
	    Reporter.log("Converted reportTime to epoch for DB query: " + reportTime, true);

	    int dbCount = db.getStatusCountForLastNDays(status);

	    Reporter.log("UI total count: " + uiTotalCountFromLabel, true);
	    Reporter.log("DB total count: " + dbCount, true);

	    Assert.assertEquals(uiTotalCountFromLabel, dbCount,
	        "Mismatch between UI and DB transaction counts");

	    Reporter.log("UI and DB transaction counts matched successfully", true);
	}


	
	public void selectDateRangeAndStatusAndMerchantAndCompareWithDB(String status, String datERange, String merchantName) throws InterruptedException {
	    String mm = baseClass.getProp().getProperty("merchantName");

	    filterTransactionThroughSelectStatus(status);
	    Reporter.log("Filtered transactions by Status: " + status, true);

	    selectDashboardusinAllMerchant(merchantName, merchantName);
	    Reporter.log("Selected Merchant from dashboard: " + merchantName, true);

	    selectDateRange(datERange);
	    Reporter.log("Selected Date Range: " + datERange, true);

	    clickOnSearchButton();
	    Reporter.log("Clicked on Search button", true);

	    getReportrangeForDB();
	    Reporter.log("Fetched report range for DB validation", true);

	    checkTransactionStatus();
	    Reporter.log("Checked transaction status on UI", true);

	    DBConnection db = new DBConnection();
	    db.createConnectionForDB();
	    Reporter.log("DB connection established successfully", true);

	    db.DateToEpochSeconds(reportTime);
	    Reporter.log("Converted reportTime to epoch for DB query: " + reportTime, true);

	    int dbCount = db.getStatusCountForLastNDaysWithDateStatusMerchant(status, mm);

	    Reporter.log("UI total count: " + uiTotalCountFromLabel, true);
	    Reporter.log("DB total count: " + dbCount, true);

	    Assert.assertEquals(uiTotalCountFromLabel, dbCount,
	        "Mismatch between UI and DB transaction counts");

	    Reporter.log("UI and DB transaction counts matched successfully", true);
	}


	
	
	public void selectDateRangeAndStatusAndMerchantMerchantAndCompareWithDB(
	        String status, String datERange, String partMerch1, String merchantName1,
	        String merchantName2, String partMerch2) throws InterruptedException {

	    filterTransactionThroughSelectStatus(status);
	    Reporter.log("Filtering transactions by Status: " + status, true);

	    selectDashboardusinAllMerchant(partMerch1, merchantName1);
	    Reporter.log("Selecting Dashboard Merchant: " + merchantName1, true);

	    selectDateRange(datERange);
	    Reporter.log("Selecting Date Range: " + datERange, true);

	    selectMerchant(partMerch2, merchantName2);

	    clickOnSearchButton();
	    Reporter.log("Clicking on Search button", true);

	    getReportrangeForDB();
	    Reporter.log("Fetching report range for DB validation", true);

	    checkTransactionStatus();
	    Reporter.log("Checking transaction status on UI", true);

	    DBConnection db = new DBConnection();
	    db.createConnectionForDB();
	    Reporter.log("DB connection established successfully", true);

	    db.DateToEpochSeconds(reportTime);
	    Reporter.log("Converted reportTime to epoch for DB query: " + reportTime, true);

	    int dbCount = db.getStatusCountForLastNDaysWithDateStatusMultipleMerchant(status, merchantName1, merchantName2);

	    Reporter.log("UI total count: " + uiTotalCountFromLabel, true);
	    Reporter.log("DB total count: " + dbCount, true);

	    Assert.assertEquals(uiTotalCountFromLabel, dbCount,
	        "Mismatch between UI and DB transaction counts");

	    Reporter.log("UI and DB transaction counts matched successfully", true);
	}


	
	
	public void getDateFilterWiseData(String datERange) throws InterruptedException {
		Reporter.log("Selecting Date Range: " + datERange, true);
		selectDateRange(datERange);

		Reporter.log("Clicking on Search button", true);
		clickOnSearchButton();

		Reporter.log("Fetching report range for DB validation", true);
		getReportrangeForDB();

		Reporter.log("Checking transaction status on UI", true);
		checkTransactionStatus();

		DBConnection db = new DBConnection();
		db.createConnectionForDB();
		Reporter.log("DB connection established successfully", true);

		db.DateToEpochSeconds(reportTime);
		Reporter.log("Converted reportTime to epoch for DB query: " + reportTime, true);


	    int dbCount = db.getDBDataWithRespectToDateWiseFilter();

	    Reporter.log("UI total count: " + uiTotalCountFromLabel, true);
	    Reporter.log("DB total count: " + dbCount, true);

	    Assert.assertEquals(uiTotalCountFromLabel, dbCount,
	        "Mismatch between UI and DB transaction counts");

	    Reporter.log("UI and DB transaction counts matched successfully", true);

	}

	
	public void bankMidAndDateWiseData(String datERange, String banKName, String MiD) throws InterruptedException {
	    Reporter.log(" Selecting Bank: " + banKName, true);
	    selectDashboardusinAllBank(banKName, banKName);

	    Reporter.log("Selecting MID: " + MiD, true);
	    selectMID(MiD);

	    Reporter.log("Selecting Date Range: " + datERange, true);
	    selectDateRange(datERange);

	    Reporter.log("Clicking on Search button", true);
	    clickOnSearchButton();

	    Reporter.log("Fetching report range for DB validation", true);
	    getReportrangeForDB();

	    Reporter.log("Checking transaction status on UI", true);
	    checkTransactionStatus();

	    DBConnection db = new DBConnection();
	    db.createConnectionForDB();
	    Reporter.log("DB connection established successfully", true);

	    db.DateToEpochSeconds(reportTime);
	    Reporter.log("Converted reportTime to epoch for DB query: " + reportTime, true);

	    int dbCount = db.bankNameBankMidAndDateAndCheckWithDB(banKName, MiD);

	    Reporter.log("UI total count: " + uiTotalCountFromLabel, true);
	    Reporter.log("DB total count: " + dbCount, true);

	    Assert.assertEquals(uiTotalCountFromLabel, dbCount,
	        "❌ Mismatch between UI and DB transaction counts");

	    Reporter.log("UI and DB transaction counts matched successfully", true);
	}

	
	public void bankMidAndDateWiseDataMerchantName(String Merchant, String datERange, String banKName, String MiD) throws InterruptedException {
	   
	    selectDashboardusinAllMerchant(Merchant, Merchant);
	    Reporter.log("Selecting merchant: " + Merchant, true);
	    
	  
	    selectDashboardusinAllBank(banKName, banKName);
	    Reporter.log("Selecting bank: " + banKName, true);
	    
	    selectMID(MiD);
	    Reporter.log("Selecting MID: " + MiD, true);
	    
	    selectDateRange(datERange);
	    Reporter.log("Selecting date range: " + datERange, true);
	   
	    clickOnSearchButton();
	    Reporter.log("Clicking on Search button", true);

	  
	    getReportrangeForDB();
	    Reporter.log("Fetching report range for DB validation", true);

	   
	    checkTransactionStatus();
	    Reporter.log("Checking transaction status on UI", true);

	    DBConnection db = new DBConnection();
	    db.createConnectionForDB();
	    Reporter.log("DB connection created successfully", true);

	    db.DateToEpochSeconds(reportTime);
	    Reporter.log("Converted reportTime to epoch for DB query: " + reportTime, true);

	    int dbCount = db.bankNameBankMidAndDateAndMerchantNameCheckWithDB(Merchant, banKName, MiD);

	    Reporter.log("UI total count: " + uiTotalCountFromLabel, true);
	    Reporter.log("DB total count: " + dbCount, true);

	    Assert.assertEquals(uiTotalCountFromLabel, dbCount, 
	        "Mismatch between UI and DB transaction counts");
	    Reporter.log("UI and DB transaction counts matched successfully", true);
	}

	
	
	public void bankMidWiseData(String banKName, String MiD) throws InterruptedException {
	   
	    selectDashboardusinAllBank(banKName, banKName);
	    Reporter.log("Selecting Bank: " + banKName, true);
	  
	    selectMID(MiD);
	    Reporter.log("Selecting MID: " + MiD, true);

	    clickOnSearchButton();
	    Reporter.log("Clicking on Search button", true);

	    Reporter.log("Fetching report range for DB validation", true);
	    getReportrangeForDB();
	    Reporter.log("Fetching report range for DB validation", true);
	    
	   
	    checkTransactionStatus();
	    Reporter.log("Checking transaction status on UI", true);
	    
	    DBConnection db = new DBConnection();
	    db.createConnectionForDB();
	    Reporter.log("DB connection established successfully", true);

	    db.DateToEpochSeconds(reportTime);
	    Reporter.log("Converted reportTime to epoch for DB query: " + reportTime, true);

	    int dbCount = db.bankNameBankMidAndAndCheckWithDB(banKName, MiD);

	    Reporter.log("UI total count: " + uiTotalCountFromLabel, true);
	    Reporter.log("DB total count: " + dbCount, true);

	    Assert.assertEquals(uiTotalCountFromLabel, dbCount,
	        "Mismatch between UI and DB transaction counts");

	    Reporter.log("UI and DB transaction counts matched successfully", true);
	}
	
	
	
	public void verifyMerchantNameWithDateAndCompareWithDB( String datERange,String Merchant) throws InterruptedException {
	    
	    selectDateRange(datERange);
	    Reporter.log("Selecting date range: " + datERange, true);
	    
		selectDashboardusinAllMerchant(Merchant, Merchant);
		    Reporter.log("Selecting merchant: " + Merchant, true);
		

	    clickOnSearchButton();
	    Reporter.log("Clicking on Search button", true);

	    Reporter.log("Fetching report range for DB validation", true);
	    getReportrangeForDB();
	    Reporter.log("Fetching report range for DB validation", true);
	    
	   
	    checkTransactionStatus();
	    Reporter.log("Checking transaction status on UI", true);
	    
	    DBConnection db = new DBConnection();
	    db.createConnectionForDB();
	    Reporter.log("DB connection established successfully", true);

	    db.DateToEpochSeconds(reportTime);
	    Reporter.log("Converted reportTime to epoch for DB query: " + reportTime, true);

	    int dbCount = db.selectMerchantAndDateAndCheckWithDB(Merchant);

	    Reporter.log("UI total count: " + uiTotalCountFromLabel, true);
	    Reporter.log("DB total count: " + dbCount, true);

	    Assert.assertEquals(uiTotalCountFromLabel, dbCount,
	        "Mismatch between UI and DB transaction counts");

	    Reporter.log("UI and DB transaction counts matched successfully", true);
	}
	
	
	public void verifyTransactionOrPurchaseIDWithDateAndCompareWithDB(String purchaseID, String datERange) throws InterruptedException {
	    
		
		searchTransaction(purchaseID);
		
		selectDateRange(datERange);
	    Reporter.log("🔹 Selecting date range: " + datERange, true);

	    clickOnSearchButton();
	    Reporter.log("🔹 Clicking on Search button", true);

	    Reporter.log("🔹 Fetching report range for DB validation", true);
	    String reportrangeForDB = getReportrangeForDB();
	    Reporter.log("🔹 Fetching report range for DB validation", true);
	    
	   
	    checkTransactionStatus();
	    Reporter.log("🔹 Checking transaction status on UI", true);
	    
	    DBConnection db = new DBConnection();
	    db.createConnectionForDB();
	    Reporter.log("🔹 DB connection established successfully", true);

	    db.DateToEpochSeconds(reportTime);
	    Reporter.log("🔹 Converted reportTime to epoch for DB query: " + reportTime, true);

	    int dbCount = db.selectTransactionIDAndDateAndCheckWithDB(purchaseID);

	    Reporter.log("UI total count: " + uiTotalCountFromLabel, true);
	    Reporter.log("DB total count: " + dbCount, true);

	    Assert.assertEquals(uiTotalCountFromLabel, dbCount,
	        "Mismatch between UI and DB transaction counts");

	    Reporter.log("UI and DB transaction counts matched successfully", true);
	}
	


	public void pagination() {
		WebDriver driver=baseClass.getDriver();
		//driver.manage().window().setSize(new Dimension(600, 800));
		while(true) {
		
			String ssdcdv =actionDriver.getAttribute(nextBtn, "class");
			
			if(ssdcdv.contains("page-item next disabled")) {
				System.out.println("user reached last page");
				break;
			}
			
			
			
		}
	}
	

	public void verifyStatusAccordingToSelections(String status, String checkStatus) {
		WebDriver driver=baseClass.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// Wait for at least one matching element to appear
		List<String> statusPaidList = new ArrayList<>();
		while(true) {
		List<WebElement> paidStatusElements = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//td[@class='padtd']/a[text()='" + status + "']")));

		for (WebElement element : paidStatusElements) {
			String currentStatus = element.getText().trim();
			System.out.println(currentStatus);
			statusPaidList.add(currentStatus);
		}
		
	
		String ssdcdv =actionDriver.getAttribute(nextBtn, "class");
		
//		if(!actionDriver.isDisplayed(nextBtn)) {
//			driver.quit();
//			Reporter.log("Pagination is not there - quit the b");
//		}
		
		if(ssdcdv.contains("page-item next disabled")) {
			System.out.println("user reached last page");
			break;
		}
		
		actionDriver.clickUsingJS(nextBtn);
		
		
		}
		if (statusPaidList.contains(checkStatus)) {
			System.out.println("Status matches the selected: " + checkStatus);
		} else {
			System.out.println("Random status shown. Expected: " + checkStatus);
		
	}
	
	}
	
	String checkMerchanrName;
	public void getMerchantNameAfterSelectingMerchantField() {
		checkMerchanrName=actionDriver.getAttribute(getMerchantNameFromTXNPage, "title");
	}
	
	
	public void verifyMerchantAccordingToSelections() {
		WebDriver driver=baseClass.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// Wait for at least one matching element to appear
		List<String> merchantNameList = new ArrayList<>();
		
		
		while(true) {
		List<WebElement> allMerchantNames = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("(//th[text()='Transaction ID'])[1]/ancestor::table//td[5]")));

		for (WebElement element : allMerchantNames) {
			String getMerchantNames = element.getText().trim();
			System.out.println(getMerchantNames);
			merchantNameList.add(getMerchantNames);
		}
		
	
		String ssdcdv =actionDriver.getAttribute(nextBtn, "class");
		
		if(ssdcdv.contains("page-item next disabled")) {
			System.out.println("user reached last page");
			break;
		}
		
		actionDriver.clickUsingJS(nextBtn);
		
		
		}
		if (merchantNameList.contains(checkMerchanrName)) {
			System.out.println("Status matches the selected: " + checkMerchanrName);
		} else {
			System.out.println("Random status shown. Expected: " + checkMerchanrName);
		
	}
	
	}
	
	String BAnkName;
	public void getBankNameFromBankFields() {
		BAnkName= actionDriver.getAttribute(getbankNameFromBankField, "title");
	}
	
	String bankNameTransactionInformationPopUp;
	public void checkBankNameOnTheTxnInformationPopUp() {
		actionDriver.click(firsttxnBtn);
		bankNameTransactionInformationPopUp=actionDriver.getText(getBankNameFrmTxnInfoPopUp);
		
	}
	
	String currencyFromtxnPage;
	public void getCurrencyAfterselectingCurrencyFromCurrencyField() {
	currencyFromtxnPage = actionDriver.getText(getCurrencyFromCurrencyField);
	}
	
	public void verifyCurrencyAccordingToSelections() {
		WebDriver driver=baseClass.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// Wait for at least one matching element to appear
		List<String> currencyNameList = new ArrayList<>();
		
		
		while(true) {
		List<WebElement> allCurrencies = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("(//th[text()='Transaction ID'])[1]/ancestor::table//td[9]")));

		for (WebElement element : allCurrencies) {
			String getMerchantNames = element.getText().trim();
			System.out.println(getMerchantNames);
			currencyNameList.add(getMerchantNames);
		}
		
	
		String ssdcdv =actionDriver.getAttribute(nextBtn, "class");
		
		if(ssdcdv.contains("page-item next disabled")) {
			System.out.println("user reached last page");
			break;
		}
		
		actionDriver.clickUsingJS(nextBtn);
		
		
		}
		if (currencyNameList.contains(currencyFromtxnPage)) {
			System.out.println("Currency matches the selected: " + currencyFromtxnPage);
		} else {
			System.out.println("Random currency shown. Expected: " + currencyFromtxnPage);
		
	}
	
	}
	
}
	
	