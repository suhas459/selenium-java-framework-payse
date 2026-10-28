package com.paysecure.bankPage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList; 
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.paysecure.actiondriver.ActionDriver;
import com.paysecure.base.baseClass;
import com.paysecure.locators.allBanks;
import com.paysecure.utilities.testData_CreateRoll;







public class allbankspage {

	// navigate upto bank
	private By bank = By.xpath(allBanks.banks);

	@FindBy(xpath = allBanks.BANK)
	private WebElement BANK;

	private By allBank = By.xpath(allBanks.allBank);
	private By banks = By.xpath(allBanks.banks);
	private By bankQuantity = By.xpath(allBanks.bankQuantity);

	// // Select MID
	private By mid = By.xpath(allBanks.mid);
	private By searchBank = By.xpath(allBanks.searchBank);

	// Select bank
	private By selectbankArrow = By.xpath(allBanks.selectbankArrow);
	private By selectBank = By.xpath(allBanks.selectBank);

	// Search bank name - Bank
	private By searchBankName = By.xpath(allBanks.searchBankName);
	private By searchButton = By.xpath(allBanks.searchButton);

	// search Bank - transaction
	private By searchBankName_Transaction = By.xpath(allBanks.searchBankName_Transaction);
	private By selectFirstMatch = By.xpath(allBanks.selectFirstMatch);
	private By getOptionsMID = By.xpath(allBanks.getOptionsMID);
	private By selectMID = By.xpath(allBanks.selectMID);

	// view MID
	private By viewMID = By.xpath(allBanks.viewMID);
	private By getAllMids = By.xpath(allBanks.getAllMids);

	@FindBy(xpath = allBanks.getAllMids)
	private List<WebElement> GETALLMIDS;

	private By paymentProcessor = By.xpath(allBanks.paymentProcessor);
	private By backButton = By.xpath(allBanks.backButton);

	private By bankNames = By.xpath(allBanks.bankNames);	

	@FindBy(xpath = allBanks.bankNames)
	private WebElement BANKNAMES;
	@FindBy(xpath = "//input[@id='mid']")
	private WebElement MIDNAME;

	// create MID
	private By createMID = By.xpath(allBanks.createMID);
	private By midName = By.xpath(allBanks.midName);
	private By allotedMID = By.xpath(allBanks.allotedMID);
	private By authKey = By.xpath(allBanks.authKey);

	// allowed currency
	private By selectCurrency = By.xpath(allBanks.selectCurrency);
	private By searchCurrency = By.xpath(allBanks.searchCurrency);
	private By selectAllCurrency = By.xpath(allBanks.selectAllCurrency);

	// Allowed Cards
	private By allowedCards = By.xpath(allBanks.allowedCards);
	private By selectAllCards = By.xpath(allBanks.selectAllCards);
	private By submit = By.xpath(allBanks.submit);

	// Auth Key
	private By authKeyText = By.xpath(allBanks.authKeyText);

	// Add bank
	private By addbank = By.xpath(allBanks.addbank);
	private By bankDetails = By.xpath(allBanks.bankDetails);

	// Search
	private By noRecordsAreFound = By.xpath(allBanks.noRecordsAreFound);
	private By showingEntries = By.xpath(allBanks.showingEntries);

	private By showAll = By.xpath(allBanks.showAll);
	private By activeBanks = By.xpath(allBanks.activeBank);
	private By inactiveBank = By.xpath(allBanks.inactiveBank);
	private By tableHeader = By.xpath(allBanks.tableHeader);

	@FindBy(xpath = allBanks.showAll)
	private WebElement SHOWALL;

	// block unblock bank
	private By block = By.xpath(allBanks.block);
	private By unblock = By.xpath(allBanks.unblock);

	// MID details
	private By viewDetailsUpdateButton = By.xpath(allBanks.viewDetailsUpdateButton);
	private By getMidName = By.xpath(allBanks.getMidName);

	// Select country
	private By selectCountry = By.xpath(allBanks.selectCountry);
	private By updateButton = By.xpath(allBanks.updateButton);

	// Delete MID
	private By deleteMID = By.xpath(allBanks.deleteMID);
	private By deleteMidMessage = By.xpath(allBanks.deleteMidMessage);
	private By cancelButton = By.xpath(allBanks.cancelButton);
	private By confirmButton = By.xpath(allBanks.confirmButton);

	// Block / Unblock MID
	private By blockMid = By.xpath(allBanks.blockMid);
	private By unblockMid = By.xpath(allBanks.unblockMid);
	
	private By bankNameOnMidP=By.xpath("(//h3[@class='text-primary d-inline'])[2]");

	public static int num;
	int quantity;

	private ActionDriver actionDriver;
	private WebDriver driver;

	// page factory constructor
	public allbankspage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.actionDriver = new ActionDriver(driver);
	}

	private By viewBankDetails = By.xpath("//button[@class='btn btn-primary btn-sm ng-scope']");
	private By getBankName = By.xpath("(//span[@class='ng-binding'])[1]");
	public static String bank_Name;

	public String view_Bank_Details() throws InterruptedException {
		bank_Name = actionDriver.getText(getBankName);
		if (actionDriver.isDisplayed(viewBankDetails) && actionDriver.isEnabled(viewBankDetails)) {
			actionDriver.scrollToElement(viewBankDetails);
			Thread.sleep(1200);
			actionDriver.click(viewBankDetails);
			Reporter.log("User click on Add MID Button", true);
		}
		return bank_Name;
	}
	

	public void navigateUptoAllBanks() throws IOException, InterruptedException {
		WebDriver driver = baseClass.getDriver();

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
		



		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Banks']")));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		
		String html = driver.getPageSource();
	//	System.out.println(html); // print in console

		// Define the folder and file name
		String folderPath = "C:\\Downloads";
		String filePath = folderPath + "\\page.html";

		try {
		    // Create the folder if it doesn't exist
		    File folder = new File(folderPath);
		    if (!folder.exists()) {
		        folder.mkdirs(); // Create all necessary directories
		        System.out.println("Created folder: " + folderPath);
		    }

		    // Write the HTML content to file
		    try (FileWriter writer = new FileWriter(filePath)) {
		        writer.write(html);
		        System.out.println("HTML saved at: " + filePath);
		    }

		} catch (IOException e) {
		    e.printStackTrace();
		}

		// actionDriver.click(bank);
		// Reporter.log("", true);
		Reporter.log("User Click on Banks Main  Module", true);
		
	//	actionDriver.scrollToElement(allBank);
		driver.manage().window().setSize(new Dimension(1280,720));
		
		Thread.sleep(300);

		actionDriver.clickUsingJS(allBank);
		//actionDriver.safeClick(allBank, driver, 30);
		Reporter.log("User Click on All Bank Sub Module", true);

	//	BanksPageName =actionDriver.safeGetText(bank, driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(banks));

		Reporter.log("User is on the Banks Page", true);

		
	}

	public int getQuantityOfAllBank() {

		actionDriver.scrollToElement(bankQuantity);
		Reporter.log("User navigate upto bank of quantity", true);

		String quantity = actionDriver.getText(bankQuantity);

		num = Integer.parseInt(quantity);
		System.err.println("Total banks quantity :- " + num);

		return num;
	}

	public void getAllBankName(WebDriver driver) throws InterruptedException {

		actionDriver.click(selectBank);
		Thread.sleep(3000);
		actionDriver.click(selectBank);
		Select s = new Select(BANKNAMES);
		List<WebElement> name = s.getOptions();
		// System.out.println(name.size());
		for (WebElement bankName : name) {
			System.err.println("All bank name Is :- " + bankName.getText());

		}

		quantity = name.size();
		System.out.println("Total bank name Quantity :- " + quantity);
	}

	public void verifyQuantityOfBanks() {

		int totalQuantity = quantity - 1;
		System.err.println(totalQuantity);

		int finalQuantity = allbankspage.num;

		System.out.println();

		Assert.assertEquals(totalQuantity, finalQuantity);

	}

	public void searchBank(String bank_Name) {

		boolean banknameIsEnabled = actionDriver.isEnabled(searchBankName);
		Assert.assertTrue(banknameIsEnabled, "❌ Search field is not enabled — cannot enter any values.");

		Reporter.log("Verify search text fiels is enable and ready to recive input from user ", true);
		actionDriver.enterText(searchBankName, bank_Name);
		Reporter.log("User Enter Bank name on the Search Bank name field :- " + bank_Name, true);
		actionDriver.click(searchButton);
		Reporter.log("User click on search button", true);

	}

	public List<String> mids_bank;

	public List<String> viewMID(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		actionDriver.click(viewMID);
		Reporter.log("User clicked on View MID button", true);

		// Wait until all MID elements are visible
		List<WebElement> midElements = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='bnk-sts']")));

		mids_bank = new ArrayList<>();

		// Extract and trim text from each element
		for (WebElement el : midElements) {
			mids_bank.add(el.getText().trim());
		}

		// Debug log to inspect raw MID values
		for (String s : mids_bank) {
			System.out.println("MID (raw): [" + s + "]");
		}

		mids_bank.removeIf(s -> {
			String trimmed = s.trim();
			return trimmed.equalsIgnoreCase("Select MID");
		});

		// Final output
		System.err.println("Bank MIDs: " + mids_bank);
		System.err.println("mids_Transaction" + mids_Transaction);
		System.err.println("mids_bank" + mids_bank);
		return mids_bank;
	}

	public List<String> mids_Transaction;

	public List<String> selectbank_Transaction(String bank_Name) throws InterruptedException {
		WebDriver driver = baseClass.getDriver();

		actionDriver.click(selectBank);
		Thread.sleep(3000);

		actionDriver.enterText(searchBankName_Transaction, bank_Name);
		Reporter.log("User Enter bank name in transaction sub module  :- " + bank_Name, true);

		actionDriver.click(selectFirstMatch);
		Reporter.log("User click on first match Bank", true);

		actionDriver.click(selectMID);
		Reporter.log("User click on Select MID", true);
		Thread.sleep(3000);

		List<WebElement> mid = driver.findElements(By.xpath("(//div[@class='custom-select'])[2]/descendant::option"));
		mids_Transaction = new ArrayList<>();

		for (WebElement el : mid) {
			mids_Transaction.add(el.getText().trim());
		}

		// 🔍 Optional debug to see exact values
		for (String s : mids_Transaction) {
			System.out.println("MID (raw): [" + s + "]");
		}

		// ✅ Remove any "Select MID" values regardless of spaces/case
		mids_Transaction.removeIf(s -> s.trim().equalsIgnoreCase("Select MID"));

		System.err.println("Transaction Mids :- " + mids_Transaction);

		return mids_Transaction;
	}

	public boolean compareBankAndTransactionMIDs() throws InterruptedException {
		Set<String> setMids = new HashSet<>(mids_bank);

		for (String mid : mids_Transaction) {
			if (setMids.contains(mid) == false)
				return false;
		}

		return true;

	}

//	String mid__name;
//
//	public String addMidToBank() {
//
//		mid__name = testData_CreateRoll.createMidNameAndAllotedMid();
//		String auth_Key = "4197a83kt1qgqav51hflqpm1t4##s650foqq3fcmd9po47lp5q3n4b39431l2vtj85g18aqpcvkb3cl##fead5d6f-0945-44e0-a26c-1b7daab89bf1##5d9fde44-7b03-48fc-bdf8-751322db0600##2afc4c62-78ae-480c-ad72-c7edeb74c105";
//
//		actionDriver.clearText(createMID);
//		Reporter.log("User click on Add Mid Button", true);
//
//		actionDriver.enterText(midName, mid__name);
//		Reporter.log("User enter mid name in mid name textfield" + mid__name, true);
//
//		actionDriver.enterText(allotedMID, mid__name);
//		Reporter.log("User enter Alloted mid name in Alloted mid name textfield" + mid__name, true);
//
//		actionDriver.enterText(authKey, auth_Key);
//		Reporter.log("User enter auth key in auth key text field" + auth_Key, true);
//
//		return mid__name;
//
//	}

//	public void allowedCurrencyForcreateMID(String currency) throws InterruptedException {
//
////		actionDriver.scrollToElement(authKeyText);
//		Thread.sleep(4000);
//
//		// actionDriver.scrollToElement(selectCurrency);
//		actionDriver.click(selectCurrency);
//		Reporter.log("User click on select currency ", true);
//
//		actionDriver.enterText(searchCurrency, currency);
//		Reporter.log("User enter currency in search currency textfield" + currency, true);
//
//		// actionDriver.click(selectAllCurrency);
//		actionDriver.clickUsingJS(selectAllCurrency);
//		Reporter.log("User click on select all currency checkbox", true);
//	}

//	public void allowedCardsForCreateMID() {
//
//		actionDriver.clickUsingJS(allowedCards);
//
//		// actionDriver.click(allowedCards);
//		Reporter.log("User click on allowed card  ", true);
//
//		actionDriver.clickUsingJS(selectAllCards);
//
//		// actionDriver.click(selectAllCards);
//		Reporter.log("User click on select all card checkbox", true);
//
//	}

//	public void submitMID() throws InterruptedException {
//
//		actionDriver.scrollToElement(submit);
//		Thread.sleep(1200);
//
//		actionDriver.click(submit);
//		Reporter.log("User click on submit button", true);
//	}

//	public void clickOnAddMid() {
//		actionDriver.click(createMID);
//		Reporter.log("User click on Add MID Button", true);
//	}



	List<String> bankMid;

	public List<String> getAllMidFromBank() {
		WebDriver driver = baseClass.getDriver();

		List<WebElement> md = driver.findElements(getAllMids);

		bankMid = new ArrayList<>();
		for (WebElement m : md) {
			bankMid.add(m.getText().trim());
		}
		for (String ba : bankMid) {
			System.err.println(ba);
		}
		return bankMid;

	}

	public boolean compare_BankAndTransactionMIDs() throws InterruptedException {
		Set<String> setMids = new HashSet<>(bankMid);

		for (String mid : mids_Transaction) {
			if (setMids.contains(mid) == false)
				return false;
		}

		return true;

	}

	// =============================================================================================================================================================================================================================

	public void VerifyAddBank() {
		boolean bankEnable = actionDriver.isEnabled(addbank);
		Assert.assertTrue(bankEnable, "If Add bank is not enable then we can't click on the Add Bank button");
		Reporter.log("Verify that Add ban is enable", true);

		actionDriver.click(addbank);
		Reporter.log("User Click on the Add Bank button", true);

		boolean bankDetail = actionDriver.isDisplayed(bankDetails);
		Assert.assertTrue(bankDetail, "If bank details are not displays then We are not on Add details page  bank");
		Reporter.log("Verify user is on the Bank details Page", true);
	}

	public void checkBankStatusAfterSearchingBank() {
		WebDriver driver = baseClass.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		try {
			// Try to get table rows
			List<WebElement> tableRows = wait
					.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//tr[@class='ng-scope']")));

			if (!tableRows.isEmpty()) {
				System.out.println("✅ Transaction details is displayed on the Transaction table");

			}

		} catch (Exception e) {
			// If table rows not found, check for 'No records found' message
			try {

				// WebElement noRecordElement = driver.findElement(By.xpath("//td[text()='No
				// Records Found']"));
				if (actionDriver.isDisplayed(noRecordsAreFound)) {
					System.out.println("✅ 'No records found' message is displayed.");
				} else {
					System.out.println("⚠️ Neither rows nor 'No records found' message is displayed.");
				}
			} catch (NoSuchElementException ex) {
				System.out.println("❌ Neither table rows nor 'No records found' message were found.");
			}
		}
	}

	public void clearTheSearchFieldAndCheck() throws InterruptedException {

		Thread.sleep(3500);
		// user clear the search field
		actionDriver.clearText(searchBankName);
		checkBankStatusAfterSearchingBank();

	}

	String ShowAllEntries;

	public String showAllBanks() {
		WebDriver driver = baseClass.getDriver();

		actionDriver.click(showAll);
		Reporter.log("User click on the Show All button", true);

		if (actionDriver.isDisplayed(showAll) && actionDriver.isEnabled(showAll)) {
			System.out.println(" Button is Display and clickable.");
		} else {
			System.out.println("Button is Not  Display.");
		}

		String colour = SHOWALL.getCssValue("background-color");
		String expectedColor = "rgba(82, 35, 188, 1)";
		Assert.assertEquals(colour, expectedColor, "❌ Button color is not as expected");

		return ShowAllEntries = actionDriver.getText(showingEntries);
	}

	String activeBank;

	public String checkForActiveButton() {

		if (actionDriver.isDisplayed(activeBanks) && actionDriver.isEnabled(activeBanks)) {

			actionDriver.click(activeBanks);

			activeBank = actionDriver.getText(showingEntries);
			Reporter.log("User clicked on the Active button", true);

		} else {
			System.out.println("Active button is not clickable.");
		}
		return activeBank;
	}

	String InactiveBank;

	public String checkForInactiveButton() {

		if (actionDriver.isDisplayed(inactiveBank) && actionDriver.isEnabled(inactiveBank)) {

			actionDriver.click(inactiveBank);

			InactiveBank = actionDriver.getText(showingEntries);
			Reporter.log("User clicked on the Inactive button", true);

		} else {
			System.out.println("Inactive button is not clickable.");
		}

		return InactiveBank;
	}

	public void totalbanksInAllBanks() {

		System.err.println(ShowAllEntries);
		System.err.println(activeBank);
		System.err.println(InactiveBank);

		int a = Integer.parseInt(ShowAllEntries);
		int b = Integer.parseInt(activeBank);
		int c = Integer.parseInt(InactiveBank);

		int totalbanks = b + c;

		Assert.assertEquals(totalbanks, a,
				"Sum of Active Bank  and Inactive bank should equal with Show All Bank Entries");
	}

	public void verifyActiveStatusForActivePage() throws InterruptedException {
		WebDriver driver = baseClass.getDriver();
		actionDriver.click(activeBanks);
		Thread.sleep(2000); // Wait for data to load

		boolean hasNextPage = true;

		while (hasNextPage) {
			// Get all table rows in the current page
			List<WebElement> rows = driver.findElements(By.xpath("//tr[@class='ng-scope']"));

			for (WebElement row : rows) {
				WebElement statusBtn = row.findElement(By.xpath("//button[text()='Active']"));
				String statusText = statusBtn.getText().trim();

				Assert.assertEquals(statusText, "Active", "❌ Bank status is not 'Active'");
			}

			// Handle pagination using <li> with ng-click
			actionDriver.scrollToElement(showingEntries);
			WebElement nextLi = driver.findElement(By.xpath("//li[a[@ng-click='setCurrent(pagination.current + 1)']]"));

			// Check if the 'Next' <li> is disabled
			String liClass = nextLi.getAttribute("class");

			if (liClass.contains("disabled")) {
				hasNextPage = false; // Stop loop if disabled
			} else {
				// Click the <a> inside <li>
				WebElement nextLink = nextLi.findElement(By.tagName("a"));
				nextLink.click();
				Thread.sleep(2000); // Wait for page to reload
			}
		}

		Reporter.log("✅ All banks on all pages have 'Active' status", true);
	}

	public void verifyInActiveStatusForAllInActivePage() throws InterruptedException {
		WebDriver driver = baseClass.getDriver();

		// Step 1: Click on "Inactive" button
		actionDriver.click(inactiveBank);
		Thread.sleep(2000); // Wait for table to load

		// Step 2: Get all rows on the current page
		List<WebElement> rows = driver.findElements(By.xpath("//tr[@class='ng-scope']"));

		// Step 3: Loop through each row and verify status is "Inactive"
		for (WebElement row : rows) {
			WebElement statusBtn = row.findElement(By.xpath(".//button[text()='Inactive']"));
			String statusText = statusBtn.getText().trim();

			Assert.assertEquals(statusText, "Inactive", "❌ Bank status is not 'Inactive'");
		}

		Reporter.log("✅ All banks on the current page have 'Inactive' status", true);
	}

	public void verifyTableHeaderInAllBanks() {
		WebDriver driver = baseClass.getDriver();

		// Step 1: Define expected header names
		List<String> expectedHeaders = Arrays.asList("BANK NAME", "ACTION");
		Reporter.log("Expected headers: " + expectedHeaders, true);

		// Step 2: Locate the actual table headers
		List<WebElement> actualHeaderElements = driver.findElements(tableHeader);
		List<String> actualHeaders = new ArrayList<>();

		for (WebElement header : actualHeaderElements) {
			actualHeaders.add(header.getText().trim());
		}

		Reporter.log("Actual headers found: " + actualHeaders, true);
		Reporter.log("Expected header count: " + expectedHeaders.size(), true);
		Reporter.log("Actual header count: " + actualHeaders.size(), true);

		// Step 3: Assert the content
		Assert.assertEquals(actualHeaders, expectedHeaders, "Table headers do not match by name!");
		Reporter.log("Table header verification PASSED. Headers match exactly by name.", true);
	}

	public void checkbankNameOnAddMidPage() throws InterruptedException {
		searchBank("Doremon");
		view_Bank_Details();
		String getPaymentProcessor = actionDriver.getText(paymentProcessor);
		Assert.assertEquals(bank_Name, getPaymentProcessor,
				"If both Bank name is mismatch then our TC is in Failed condition");

	}

	String banktext;

	public String BackButtonViewMidPage() {
		banktext = actionDriver.getText(bankNameOnMidP);
		Reporter.log("Bank text retrieved from View MID page: " + banktext, true);

		actionDriver.click(backButton);
		Reporter.log("User clicked on the Back button", true);

		return banktext;
	}

	public void checkbanksNameEvenAfterClickOnBackButtonOnViewMidsPage() {
		Assert.assertEquals(banktext, "Banks", "If not matches then our TC is i failed condition");
		Reporter.log(
				"Validate that if user click on the Back Button on the View Mids page then user is on the banks Page",
				true);
	}

	public void verifyMidNameInSecondTable() {
		
	
		
		WebDriver driver = baseClass.getDriver();

		String dynamicXpath = "(//table[@class='table table-bordered'])[2]/tbody/tr/td[normalize-space()='" + viewMids_allBanks.mid__name
				+ "']";
		By midLocator = By.xpath(dynamicXpath);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement midElement = wait.until(ExpectedConditions.visibilityOfElementLocated(midLocator));                                

		Assert.assertTrue(midElement.isDisplayed(), "MID name not found in second table: " +viewMids_allBanks.mid__name);
		Reporter.log("Verified MID name is displayed in second table: " +viewMids_allBanks.mid__name, true);
	}
    String get_MidName;
	String mdname;
	public void updatePageOfViewMidPage() throws InterruptedException {
	    WebDriver driver = baseClass.getDriver();

	    // Locate the element first
	    WebElement midNameElement = driver.findElement(By.xpath("(//div[@class='bnk-sts'])[1]/span"));
	    
	    get_MidName   =midNameElement.getText();

//	    // Fetch text/value using JS
//	    JavascriptExecutor js = (JavascriptExecutor) driver;
//	    get_MidName = (String) js.executeScript("return arguments[0].value;", midNameElement);
	    Reporter.log("Fetched MID Name from disabled field: " + get_MidName, true);

	    Thread.sleep(2000);//	    // Click "View Details / Update" button
	    actionDriver.clickUsingJS(viewDetailsUpdateButton);
	    Reporter.log("User clicked on the View details button", true);

	    // Now get the updated MID name field
	    mdname = MIDNAME.getAttribute("value");

	}


	public void verifyMidNameIsSameOnUpdatePage() {
		Assert.assertEquals(get_MidName, mdname, "If Mid Name is not same then we are on the Wrong page");
		Reporter.log("Verify Mid name on update mids page", true);
	}

	public void selectCountry() {
		actionDriver.scrollToElement(updateButton);
		Reporter.log("User scroll upto update button", true);
		actionDriver.selectByVisibleText(selectCountry, "Belarus");
		Reporter.log("User select country ", true);
	}

	public void updateMid() throws InterruptedException {
		actionDriver.scrollToElement(updateButton);
		Thread.sleep(300);
		actionDriver.click(updateButton);
		Reporter.log("User click on the Update Button", true);
	}

	public void deleteMid() {
		actionDriver.click(deleteMID);
		Reporter.log("User click on the Delete Button", true);

		actionDriver.isDisplayed(deleteMidMessage);
		Reporter.log(
				"Verify If user click on the Delete Mid button then this Message display :- Do you want to delete BankMID",
				true);

		actionDriver.click(cancelButton);
		Reporter.log("User click on the Cancel button on the Delete pop up", true);

		actionDriver.click(deleteMID);
		Reporter.log("User click on the Delete Button", true);

	}

	public void confirmDeleteMid() {
		actionDriver.click(confirmButton);
		Reporter.log("User click on the Confirm button", true);
	}

	public void blockMid() throws InterruptedException {
		actionDriver.safeClick(blockMid,20);
		Reporter.log("User click on the Block button", true);
        Thread.sleep(5000);		
        if (actionDriver.isDisplayed(unblockMid)) {
			System.err.println("Validate that After click on the Block button then Unblock symbol 'U' is displays");
			Reporter.log("Validate that After click on the Block button then Unblock symbol 'U' is displays", true);
			 Thread.sleep(5000);	
			actionDriver.safeClick(block, 20);
		}

	}
	

	
	
	
	
	
	
	
	
	
	

}
