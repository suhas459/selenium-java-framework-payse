package com.paysecure.Analyticals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.xml.sax.Parser;

import com.paysecure.actiondriver.ActionDriver;
import com.paysecure.base.baseClass;
import com.paysecure.locators.AnalyticaLReporting;
import com.paysecure.locators.CustomarSummary;
import com.paysecure.utilities.dbForEmail;

import freemarker.core.ParseException;

public class CustomerSummaryPage {

	// navigate up to the - Customer Summary 
	private By Analytics = By.xpath(AnalyticaLReporting.analytics);
	private By CustomerSummary = By.xpath(CustomarSummary.customerSummary);
	private By sideBar = By.xpath(CustomarSummary.sideBar);
	
	//group by Dropdown
	private By groupByDropodwn = By.xpath(CustomarSummary.groupByDropodwn);
	
	//table
	private By customersEmail = By.xpath(CustomarSummary.customersEmail);
	@FindBy(xpath = "(//table[@class='table table-bordered'])[2]//td[1]") private List<WebElement> allEmails;
	private By nextButton = By.xpath(AnalyticaLReporting.nextButton);
	
	//select merchant
	private By selectmerchant = By.xpath(CustomarSummary.selectmerchant);
	private By searchMerchant = By.xpath(CustomarSummary.searchMerchant);

	//submit button
		private By submitButton = By.xpath(CustomarSummary.submitButton);
		
		//count from email
		private By total = By.xpath(CustomarSummary.total);
		private By dayFrq = By.xpath(CustomarSummary.dayFrq);
		private By monthFrq = By.xpath(CustomarSummary.monthFrq);
		private By weekFrq = By.xpath(CustomarSummary.weekFrq);
		private By customersMerchantFrq = By.xpath(CustomarSummary.customersMerchantFrq);
		private By customersCardsfrq = By.xpath(CustomarSummary.customersCardsfrq);
		private By customersCountriesFrq = By.xpath(CustomarSummary.customersCounriesFrq);
		private By customersIpsFrq = By.xpath(CustomarSummary.customersIpsFrq);
		private By customersAmountFrq = By.xpath(CustomarSummary.customersAmountFrq);
		
	
	private ActionDriver actionDriver;
	private WebDriver driver;

	// page factory constructor
	public CustomerSummaryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.actionDriver = new ActionDriver(driver);
	}
	
	public void navigateUptoCustomerSummaryPage() throws InterruptedException {
		WebDriver driver=baseClass.getDriver();
		actionDriver.click(Analytics);
		Reporter.log("Starting navigation to Analytical Reporting...", true);

		Thread.sleep(500);

		// Set custom browser window size (slightly above 800x600)
		driver.manage().window().setSize(new Dimension(900, 720));
		Reporter.log("Browser window resized to 900x720 for low-resolution testing.", true);
		Thread.sleep(400);
		actionDriver.clickUsingJS(sideBar);
		Reporter.log("User click on the side bar menu", true);
		
		// Scroll to the Analytics section
		actionDriver.scrollToElement(CustomerSummary);
		Reporter.log("Scrolled to 'Customer Summary' section.", true);
		
		actionDriver.clickUsingJS(CustomerSummary);
		Reporter.log("User click on the Customer Summary sub module", true);
		
		driver.manage().window().setSize(new Dimension(1280, 720));
		Reporter.log("Browser window resized to 1280x720 for low-resolution testing.", true);
	}
	
	public void verifyCustomerEmailIsAlreadySelectInGroupByDropdown() {
	    Reporter.log("Verifying default selection in 'Group By' dropdown", true);

	    // Get the currently selected option text
	    String csEmail = actionDriver.getFirstSelectedOption(groupByDropodwn);

	    Reporter.log("Currently selected option: " + csEmail, true);
	    System.out.println("Currently selected option in dropdown: " + csEmail);

	    // Assertion to check if the default selection is 'Customer email'
	    Assert.assertEquals(csEmail, "Customer email", 
	        "The default selected option in 'Group By' dropdown is incorrect!");

	    Reporter.log("Verified: 'Customer email' is correctly selected as default in 'Group By' dropdown.", true);
	}

	
	public void submitButtonFunctionality() {
		actionDriver.clickUsingJS(submitButton);
		Reporter.log("User click on the submit button", true);
	}
	
	public void verifyCustomersEmailOnTable() {
	    Reporter.log("Verifying if the 'Customer Email' column header is visible on the table", true);

	    // Check if the customer email table header is displayed
	    boolean csEmailTableHeader = actionDriver.isDisplayed(customersEmail);

	    Reporter.log("'Customer Email' column header displayed status: " + csEmailTableHeader, true);
	    System.out.println("'Customer Email' column header displayed: " + csEmailTableHeader);

	    // Assertion to verify visibility
	    Assert.assertTrue(csEmailTableHeader, "'Customer Email' column header is not visible on the table!");

	    Reporter.log("Verified successfully: 'Customer Email' column header is visible on the table.", true);
	}

	
	public void selectDashboardusinAllMerchant(String partialMerchantname, String merchant)
			throws InterruptedException {
			WebDriver driver = baseClass.getDriver();
			WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
			Thread.sleep(2000);
			actionDriver.click(selectmerchant);

			Reporter.log("click on the select merchant filed", true);
			Thread.sleep(2000);
			w.until(ExpectedConditions.elementToBeClickable(searchMerchant)).sendKeys(partialMerchantname);
			Reporter.log("Enter merchant name in a search merchant functioanlity", true);

			Thread.sleep(2000);

			List<WebElement> suggestions = w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
					By.xpath("//ul[@id='select2-mid-results']/li")));

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
		
	public void verifyEmailISShouldBedisplysAfterSelectingCustomersEmailFromGroupBy() {
	    WebDriver driver = baseClass.getDriver();
	    Reporter.log("Verifying that emails are displayed after selecting 'Customer Email' from Group By dropdown", true);

	    boolean allEmailsValid = true; // Track overall email validity across pages

	    while (true) {
	        // Step 1: Collect all email texts from the current page
	        List<String> mail = new ArrayList<>();
	        for (WebElement email : allEmails) {
	            String emailText = email.getText().trim();
	            mail.add(emailText);
	            Reporter.log("Found email: " + emailText, true);
	        }

	        // Step 2: Check if any email contains ".com"
	        boolean pageHasValidEmail = mail.stream().anyMatch(e -> e.contains(".com"));
	        Reporter.log("Page contains valid email addresses (containing .com): " + pageHasValidEmail, true);

	        // Update overall validity
	        if (!pageHasValidEmail) {
	            allEmailsValid = false;
	        }

	        // Step 3: Locate the 'Next' button
	        WebElement nextButtonContainer = driver.findElement(By.xpath("//li[contains(@class,'page-item next')]"));
	        String classAttr = nextButtonContainer.getAttribute("class");

	        // Step 4: Check if 'Next' button is disabled
	        if (classAttr.contains("disabled")) {
	            Reporter.log("Reached last page. No more pagination.", true);
	            break;
	        }

	        // Step 5: Click the next button
	        WebElement nextButton = nextButtonContainer.findElement(By.tagName("a"));
	        actionDriver.clickUsingJS(this.nextButton);
	        Reporter.log("Navigating to next page...", true);

	    }

	    // Step 6: Final assertion after all pages
	    Reporter.log("Final verification: All pages contain valid email addresses (.com): " + allEmailsValid, true);
	    Assert.assertTrue(allEmailsValid, "Some pages do not contain valid emails (.com)!");
	}
	
	
	public int ctn;
	public int dayFrequency;
	public int monthInYear;
	public int weeklYCount;
	public int merchantCount;
	public int ips;
	public int ccFrequency;
	public int amtFrequency;
	public int countryFrequency;
	
	public void getALLCountFromEmailID() {
		dbForEmail ed = new dbForEmail();
	    // Create DB connection
	    ed.createConnectionForDB();
	    Reporter.log("Database connection established successfully.", true);
		 String emailID = "ajayqa7@gmail.com";
		ctn = ed.getCountOfMerchantEmailIDS(emailID, "603");
		System.out.println(ctn);
		
	  dayFrequency = ed.getdaysInYearCount(emailID);
	    Reporter.log("Distinct days in year count: " + dayFrequency, true);
	    
	  monthInYear = ed.getmonthInYearCount(emailID);
	    Reporter.log("Distinct months in year count: " + monthInYear, true);

//	    int yearFrequency = ed.getYearCount(emailID);
//	    Reporter.log("Distinct years count: " + yearFrequency, true);

	  weeklYCount = ed.getWeeklyCount(emailID);
	    Reporter.log("Weekly count: " + weeklYCount, true);

	     merchantCount = ed.getMerchantFrequency(emailID);
	    Reporter.log("Merchant frequency: " + merchantCount, true);

	   ips = ed.getCustomersIPCount(emailID);
	    Reporter.log("Unique IP addresses: " + ips, true);

	  ccFrequency = ed.getCustomersCardFrequency(emailID);
	    Reporter.log("Card frequency: " + ccFrequency, true);

	    countryFrequency = ed.getCustomersCountryFrequency(emailID);
	    Reporter.log("Country frequency: " + countryFrequency, true);

	    amtFrequency = ed.getAmtFrequency(emailID);
	    Reporter.log("Amount frequency: " + amtFrequency, true);

	    int totalPaidTransactions = ed.getTotalPaidTransactions(emailID);
	    Reporter.log("Total paid transactions: " + totalPaidTransactions, true);

	    int totalCountTransactionForThisEmailID = ed.getCountOfEmail(emailID);
	    Reporter.log("Total transaction documents for emailId: " + totalCountTransactionForThisEmailID, true);
	}
	int 	totalemailCount;
	int dayCount;
	int monthCount;
	int weeklyCount;
	int merchanTCount;
	int cardsCount;
	int countriesCount;
	int ipsCount;
	int amountCount;
	public void getAllFrqFromEmailID() {
		String totalEmailCounT = actionDriver.getText(total);
	totalemailCount =Integer.parseInt(totalEmailCounT);
		String totaldayCounT = actionDriver.getText(dayFrq);
		
		String totalMonthCounT = actionDriver.getText(monthFrq);
		String totalWeeklyCounT = actionDriver.getText(weekFrq);
		String totalcustomersMerchantFrqCounT = actionDriver.getText(customersMerchantFrq);
		String totalcustomersCardsfrqCounT = actionDriver.getText(customersCardsfrq);
		String totalcustomersCountriesFrqCounT = actionDriver.getText(customersCountriesFrq);
		String totalcustomersIpsFrqCounT = actionDriver.getText(customersIpsFrq);
		String totalcustomersAmountFrqCounT = actionDriver.getText(customersAmountFrq);
		
		dayCount = Integer.parseInt(totaldayCounT);
		monthCount =  Integer.parseInt(totalMonthCounT);
	weeklyCount =  Integer.parseInt(totalWeeklyCounT);
		merchanTCount =  Integer.parseInt(totalcustomersMerchantFrqCounT);
		cardsCount =  Integer.parseInt(totalcustomersCardsfrqCounT);
		countriesCount =  Integer.parseInt(totalcustomersCountriesFrqCounT);
		ipsCount =  Integer.parseInt(totalcustomersIpsFrqCounT);
		amountCount = Integer.parseInt(totalcustomersAmountFrqCounT);
	}

	
	public void verifyAllCounts() {
	    Reporter.log("🔍 Verifying UI and DB (or calculated) counts...", true);

	    Assert.assertEquals(totalemailCount, ctn, "Mismatch found in Day Count!");
	    Reporter.log("Day Count verified successfully: " + dayCount, true);

	    Assert.assertEquals(monthCount, monthInYear, "❌ Mismatch found in Month Count!");
	    Reporter.log("Month Count verified successfully: " + monthCount, true);

	    Assert.assertEquals(weeklyCount, weeklYCount, "❌ Mismatch found in Weekly Count!");
	    Reporter.log("Weekly Count verified successfully: " + weeklyCount, true);

	    Assert.assertEquals(merchanTCount, merchantCount, "❌ Mismatch found in Merchant Count!");
	    Reporter.log("Merchant Count verified successfully: " + merchanTCount, true);

	    Assert.assertEquals(cardsCount, ccFrequency, "❌ Mismatch found in Cards Count!");
	    Reporter.log("Cards Count verified successfully: " + cardsCount, true);

	    Assert.assertEquals(countriesCount, countryFrequency, "❌ Mismatch found in Country Count!");
	    Reporter.log("Country Count verified successfully: " + countriesCount, true);

	    Assert.assertEquals(ipsCount, ips, "❌ Mismatch found in IPs Count!");
	    Reporter.log("IPs Count verified successfully: " + ipsCount, true);

	    Assert.assertEquals(amountCount, amtFrequency, "❌ Mismatch found in Amount Count!");
	    Reporter.log("Amount Count verified successfully: " + amountCount, true);

	    Reporter.log("All count verifications completed successfully.", true);
	}
	
}
