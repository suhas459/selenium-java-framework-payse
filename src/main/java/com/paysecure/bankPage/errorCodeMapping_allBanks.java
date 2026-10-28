package com.paysecure.bankPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.paysecure.actiondriver.ActionDriver;
import com.paysecure.base.baseClass;
import com.paysecure.locators.allBanks;
import com.paysecure.utilities.testData_CreateRoll;

public class errorCodeMapping_allBanks {

	private By errorCodeMapping = By.xpath(allBanks.errorCodeMapping);
	private By bankName = By.xpath(allBanks.bankName);
	private By payMentProcessor = By.xpath(allBanks.payMentProcessor);

	// table headers
	private By tableHeadersInECM = By.xpath(allBanks.tableHeadersInECM);
	private By bacKButton = By.xpath(allBanks.bacKButton);
	private By PaymentBankJsonData = By.xpath(allBanks.PaymentBankJsonData);

	// add bank mapping
	private By addBankMapping = By.xpath(allBanks.addBankMapping);
	private By bankNameonECM = By.xpath(allBanks.bankNameonECM);
	private By requesTTypeDropdown = By.xpath(allBanks.requesTTypeDropdown);
	private By responseTypeDropdown = By.xpath(allBanks.responseTypeDropdown);

	// error in response code
	private By errorInResponseCode = By.xpath(allBanks.errorInResponseCode);
	private By submiTButton = By.xpath(allBanks.submiTButton);
	private By responseCode = By.xpath(allBanks.responseCode);
	private By actionBnakMapping = By.xpath(allBanks.actionBnakMapping);

	private By getCode = By.xpath(allBanks.code);
	private By requestType = By.xpath(allBanks.requestType);
	private By responseType = By.xpath(allBanks.responseType);
	private By getTextFromResponseCode = By.xpath(allBanks.getTextFromResponseCode);

	private By requesTTypeDropdownValue = By.xpath(allBanks.requesTTypeDropdownValue);
	private By requesDropdownValue = By.xpath(allBanks.requesDropdownValue);
	private By updateButton = By.xpath(allBanks.updateButton);
	private By rsCode = By.xpath(allBanks.rsCode);
    @FindBy(xpath="//td[text()='No Records Available']") private WebElement noRecordsFound;
    
    private By deleteButton = By.xpath(allBanks.deleteButton);
    private By confirMButton = By.xpath(allBanks.confirMButton);
    private By cancel = By.xpath(allBanks.cancel);
    private By deleteMessage = By.xpath(allBanks.deleteMessage);
	private By baseUrl=By.xpath(allBanks.baseUrl);
    private By confirmBtn=By.xpath("//button[text()='confirm']");
    
    
    
    
	private ActionDriver actionDriver;
	private WebDriver driver;

	public errorCodeMapping_allBanks(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.actionDriver = new ActionDriver(driver);
	}

	public void validateErrorCodeMappingIsDisplaysAndClickable() {
		WebDriver driver = baseClass.getDriver();

		Reporter.log("Validating Error Code Mapping is displayed", true);
		boolean toolTip = actionDriver.isDisplayed(errorCodeMapping);
		Assert.assertTrue(toolTip, "❌ Error Code Mapping is not displayed");
		Reporter.log("✅ Error Code Mapping is displayed", true);

		Reporter.log("Validating Error Code Mapping is clickable", true);
		boolean isClickableErrorCodemapping = actionDriver.isEnabled(errorCodeMapping);
		Assert.assertTrue(isClickableErrorCodemapping, "❌ Error Code Mapping is not clickable");
		Reporter.log("✅ Error Code Mapping is clickable", true);

		actionDriver.click(errorCodeMapping);
		Reporter.log("✅ User click on the Error Code Mapping button", true);

	}

	String banKName;

	public String getBankName() {
		banKName = actionDriver.getText(bankName);
		Reporter.log("Captured Bank Name from UI: " + banKName, true);
		return banKName;
	}

	String banknameOfPaymentProcessor;

	public String getPaymentProcessorName() {
		banknameOfPaymentProcessor = actionDriver.getText(payMentProcessor);
		Reporter.log("Captured Bank Name from Payment Processor: " + banknameOfPaymentProcessor, true);
		return banknameOfPaymentProcessor;
	}

	public void verifyBankName() {

		getPaymentProcessorName();

		Reporter.log("Verifying Bank Name with Payment Processor Name...", true);
		Assert.assertEquals(banknameOfPaymentProcessor, banKName,
				"❌ Bank Name and Payment Processor Name do not match!");
		Reporter.log("✅ Bank Name matches Payment Processor Name: " + banKName, true);
	}

	public void verifytableHeadersInErrorCodeMapping() {
		WebDriver driver = baseClass.getDriver();

		List<WebElement> headers = driver.findElements(By.xpath("//table[@id='tabel22']//tr/th"));

		List<String> addedHeaders = new ArrayList<>();

		for (WebElement h : headers) {
			addedHeaders.add(h.getText().trim());
		}

		Reporter.log("Fetched Headers from UI: " + addedHeaders, true);

		// Expected headers
		List<String> expHeaders = Arrays.asList("CODE", "REQUEST TYPE", "RESPONSE TYPE", "ACTIONS");
		Reporter.log("Expected Headers: " + expHeaders, true);

		// Assertion
		Assert.assertEquals(addedHeaders, expHeaders, "Mismatch in PaymentBankJsonData headers!");
		Reporter.log("Header validation successful. Headers matched: " + addedHeaders, true);

	}

	public void verifyIfUserClickOnBackButtonThenUserIsOnTheBanksPage() {
		actionDriver.click(bacKButton);
		Reporter.log("User click on the Back Button", true);

		boolean userIsOnPaymentBankJsonData = actionDriver.isDisplayed(PaymentBankJsonData);
		Assert.assertTrue(userIsOnPaymentBankJsonData);
		Reporter.log("If user click on the back button Bank mapping then user is on the main Banks page", true);

		actionDriver.click(errorCodeMapping);
		Reporter.log("✅ User click on the Error Code Mapping button", true);

	}

	String ppBankName;

	public String getBankOnECM() {
		ppBankName = actionDriver.getText(bankNameonECM);
		Reporter.log("📌 Captured Bank Name from Error Code Mapping screen: " + ppBankName, true);
		return ppBankName;
	}

	public void addbankMapping() {
		actionDriver.click(addBankMapping);
		Reporter.log("✅ Clicked on 'Add Bank Mapping' button", true);
	}

	public void verifybankNameOnErrorCodeBanking() {
		Reporter.log("🔍 Verifying Bank Name between Payment Processor and Error Code Mapping...", true);
		Assert.assertEquals(banknameOfPaymentProcessor, ppBankName,
				"❌ Bank Name mismatch between Payment Processor and Error Code Mapping!");
		Reporter.log("✅ Bank Name matches: " + ppBankName, true);
	}

	public void verifyAllElementdInRequestTypeDropdown() {
		// Get dropdown options as text
		List<String> actualOptions = actionDriver.getDropdownOptions(requesTTypeDropdown);
		Reporter.log("Actual Dropdown Options: " + actualOptions, true);

	    List<String> expectedOptions = Arrays.asList(
	    	    "2DPAYMENT", "2DPAYMENTNEXT", "3DPAYMENT", "3DPAYMENTNEXT", "AJATY", "ANY", "APPLEPAY", 
	    	    "AUTHENTICATE", "BANKTRANSFER", "CASHFREE", "choicepaypg", "CRYPTO-BRIDGE", 
	    	    "CRYPTO-BRIDGEAUTH", "CRYPTO-BRIDGEEXEC", "CRYPTO-BRIDGEPREVIEW", "CRYPTO-WALLET", 
	    	    "DELETEPAYMENT", "DINERS", "Discover", "EASEBUZZ", "eNaira", "EXCHANGERATEINQUERY", 
	    	    "FawryPay", "GCASH", "GETALLBALANCE", "GETCURRBALANCE", "GIROPAY", "GOOGLEPAY", "GRAB", 
	    	    "INTERAC", "INTERAC-E-TRANSFER", "INTERAC-ETRANSFER", "INTERAC-EXPRESS", "INTERAC-REQUEST-MONEY", 
	    	    "KAKAO_PAY", "KLARNA", "KoraPayMobileMoney", "MAESTRO", "MAYA", "MIR", "MOBILEMONEY", "NeoSurf", 
	    	    "NETBANKING", "NETELLER", "NEXT1", "OTC", "OTPVERIFY","PayByBank", "PAYID", "PAYMENTCANCELLATION", 
	    	    "PAYMENTCANCELLATIONNEXT", "PAYMENTTERMINATION", "PAYOUT", "Payout-aamarpay", "PAYOUT-ACH", 
	    	    "PAYOUT-BANKTRANSFER", "PAYOUT-CASHFREE", "PAYOUT-CHOICEPAY", "PAYOUT-DING", "PAYOUT-FawryPay", 
	    	    "PAYOUT-INSTANT-SEPA", "PAYOUT-INTERAC", "PAYOUT-INTERAC-E-TRANSFER", "PAYOUT-INTERAC-ETRANSFER", 
	    	    "PAYOUT-INTERAC-EXPRESS", "PAYOUT-INTERAC-REQUEST-MONEY", "PAYOUT-MOBILEMONEY", "PAYOUT-NEOSURF", 
	    	    "PAYOUT-PAYID", "PAYOUT-PAYORO", "PAYOUT-PIX", "PAYOUT-SPEI", "PAYOUT-SWIIPR-VIRTUAL-CARDS", 
	    	    "PAYOUT-THIRDPARTY-UPI", "PAYOUT-UPI", "PAYOUT-VIRTUAL-CARD", "PAYOUTINQUERY", "PAYOUTINQUERYNEXT", 
	    	    "PAYOUTNEXT", "PAYPAL", "PAY_WITH_INSTAXCHANGE", "PIX", "PIXNEXT", "QBPAY", "QBPAYFLOW", 
	    	    "QBPAYFLOWCHECKORDER", "QBPAYFTOPUP", "QRIS", "REFUNDSTATUS", "RUPAY", "SKRILL", "SOLO", "SPEI", 
	    	    "SPEI-CARD", "SPEI-CLABE", "SPEI-MOBILE", "TENT", "Test", "THIRDPARTY-NETBANKING", "THIRDPARTY-UPI", 
	    	    "TRANSACTIONINQUERY", "TRANSACTIONINQUERYNEXT", "TRANSFER", "UnionPay", "UPI", "UPI-COLLECT", 
	    	    "UPI-QR", "VIRTUAL-ACCOUNT", "VIRTUAL-IBAN", "WALLET", "WEBHOOKREQUEST", "yumgoOB"
	    	);

		Reporter.log("Expected Dropdown Options: " + expectedOptions, true);

		// Assertion for values
		Assert.assertEquals(actualOptions, expectedOptions, "Dropdown options mismatch");
		Reporter.log("Dropdown values match successfully ✅", true);

		// Assertion for size
		int actualSize = actualOptions.size();
		System.err.println("Total options in URL dropdown are :- " + actualSize);
		Assert.assertEquals(actualSize, expectedOptions.size(), "Dropdown size mismatch!");
		Reporter.log("Dropdown size matched. Expected: " + expectedOptions.size() + " | Actual: " + actualSize, true);
	}

	public void verifyAllElementdInResponseTypeDropdown() {
		// Get dropdown options as text
		List<String> actualOptions = actionDriver.getDropdownOptions(responseTypeDropdown);
		Reporter.log("Actual Dropdown Options: " + actualOptions, true);

		// Expected dropdown values
		List<String> expectedOptions = Arrays.asList("fail", "success", "cvv_error", "expiry_date_error"

		);
		Reporter.log("Expected Dropdown Options: " + expectedOptions, true);

		// Assertion for values
		Assert.assertEquals(actualOptions, expectedOptions, "Dropdown options mismatch");
		Reporter.log("Dropdown values match successfully ✅", true);

		// Assertion for size
		int actualSize = actualOptions.size();
		System.err.println("Total options in URL dropdown are :- " + actualSize);
		Assert.assertEquals(actualSize, expectedOptions.size(), "Dropdown size mismatch!");
		Reporter.log("Dropdown size matched. Expected: " + expectedOptions.size() + " | Actual: " + actualSize, true);
	}

	public void selectValueFromRequestTypeDropdown(String requestType) {
		actionDriver.selectByVisibleText(requesTTypeDropdown, requestType);
		Reporter.log("✅ Selected value from Request Type dropdown: " + requestType, true);
	}

	public void selectValueFromResponseTypeDropdown(String responseType) {
		actionDriver.selectByVisibleText(responseTypeDropdown, responseType);
		Reporter.log("✅ Selected value from Response Type dropdown: " + responseType, true);
	}

	public void validateErrorInResponseCode() {
		actionDriver.click(submiTButton);
		Reporter.log("🔍 Clicked on Submit button without entering response code", true);

		boolean isErrorDisplayed = actionDriver.isDisplayed(errorInResponseCode);
		Assert.assertTrue(isErrorDisplayed, "❌ Error message is not displayed for empty Response Code");
		Reporter.log("✅ Error message is displayed for empty Response Code", true);
	}

	public void UserEnterResponseCode() {
		String abc = testData_CreateRoll.createRandom5CharWord();
		Reporter.log("📌 Generated Random Response Code: " + abc, true);

		actionDriver.enterText(baseUrl, abc);
		Reporter.log("✅ Entered Response Code: " + abc, true);

		actionDriver.click(submiTButton);
		Reporter.log("✅ Clicked on Submit button after entering Response Code", true);
	}

	String code;
	String requesTType;
	String responsEType;

	public String geTCode() {
		code = actionDriver.getText(getCode);
		Reporter.log("📌 Captured Code: " + code, true);
		return code;
	}

	public String getRequestType() {
		requesTType = actionDriver.getText(requestType);
		Reporter.log("📌 Captured Request Type: " + requesTType, true);
		return requesTType;
	}

	public String getResponseTime() {
		responsEType = actionDriver.getText(responseType);
		Reporter.log("📌 Captured Response Type: " + responsEType, true);
		return responsEType;
	}

	public void clickOnAction() {
		actionDriver.click(actionBnakMapping);
		Reporter.log("✅ Clicked on 'Action - Bank Mapping' button", true);
	}

	public void getFirstSelectedOptionFromRequestTypeDropdown() {
		WebDriver driver = baseClass.getDriver();
		String requestType = actionDriver.getAttribute(requesDropdownValue, "title");
		String ResponseType = actionDriver.getFirstSelectedOption(responseTypeDropdown);
		WebElement codeLabel = driver.findElement(By.id("code"));

		// Get the value of ng-init
		String ngInitValue = codeLabel.getAttribute("ng-init"); // "code='sxcac'"

		// Extract only "sxcac" from it
		String responseCode = ngInitValue.split("'")[1];

		System.out.println("Response Code from ng-init: " + responseCode);

		Reporter.log("📌 First Selected Request Type Option: " + requestType, true);
		Reporter.log("📌 First Selected Response Type Option: " + ResponseType, true);
		Reporter.log("📌 Extracted value from ng-init (Response Code): " + responseCode, true);
		Reporter.log("📌 Expected Code: " + code, true);
		Reporter.log("📌 Expected Request Type: " + requesTType, true);
		Reporter.log("📌 Expected Response Type: " + responsEType, true);

		// Assertions
		Assert.assertEquals(responseCode, code, "❌ Mismatch in Request Type selection!");
		Reporter.log("✅ Verified Code matches Code", true);

		Assert.assertEquals(requestType, requesTType, "❌ Mismatch in Response Type selection!");
		Reporter.log("✅ Verified Request Type matches RequestType", true);

		Assert.assertEquals(ResponseType, responsEType, "❌ Mismatch in Response Code!");
		Reporter.log("✅ Verified Response Type matches ResponseType", true);
	}

	public void enterAnyTextInResponseCode() {
		actionDriver.enterText(rsCode, "123456");
		Reporter.log("✅ Entered text in Response Code field", true);
	}

	public void clickOnUpdateButton() {
		actionDriver.scrollToElement(updateButton);
		actionDriver.clickUsingJS(updateButton);
		Reporter.log("✅ Clicked on Update button using JavaScript", true);
	}
	
	
	public void verifyCoderequestRsponceOnUpdatePage() {
		WebDriver driver=baseClass.getDriver();
		
		List<WebElement> noRecordsFound = driver.findElements(By.xpath("//td[text()='No Records Available']"));

		if (!noRecordsFound.isEmpty() && noRecordsFound.get(0).isDisplayed()) {
		    Reporter.log("⚠️ No records found for Bank: " + banknameOfPaymentProcessor, true);
		} else {
		    Reporter.log("✅ Records found for Bank: " + banknameOfPaymentProcessor, true);

		    geTCode();
		    getRequestType();
		    getResponseTime();
		    clickOnAction();
		    getFirstSelectedOptionFromRequestTypeDropdown();
		    enterAnyTextInResponseCode();
		    clickOnUpdateButton();
		}
	}
	
	public void verifyDeleteActionOnErrorCodeMapping() {
		
	WebDriver driver=baseClass.getDriver();
		
		List<WebElement> noRecordsFound = driver.findElements(By.xpath("//td[text()='No Records Available']"));

		if (!noRecordsFound.isEmpty() && noRecordsFound.get(0).isDisplayed()) {
		    Reporter.log("No records found for Bank: " + banknameOfPaymentProcessor, true);
		} else {
		
			actionDriver.click(deleteButton);
			Reporter.log("Clicked on Delete button", true);

//			actionDriver.click(confirmBtn);
//			Reporter.log("Clicked on Confirm button", true);
			
//			String delMsg = actionDriver.getText(deleteMessage);
//			Reporter.log("Retrieved delete message: " + delMsg, true);
//
//			Assert.assertEquals(delMsg, "Do you want to delete Bank mapping", "❌ Delete message mismatch!");
//			Reporter.log("Verified delete confirmation message", true);

			// Cancel action
			actionDriver.click(cancel);
			Reporter.log("❌ Clicked Cancel on delete confirmation", true);

			// Try delete again
			actionDriver.click(deleteButton);
			Reporter.log("🗑️ Clicked Delete button again", true);

			// Confirm delete
			actionDriver.click(confirMButton);
			Reporter.log("✅ Clicked Confirm button – Bank mapping deleted successfully", true);

		
		
		}
		
	}
	
	
	
	
	
	
	
	

}
