package com.paysecure.bankPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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




public class setting_allBanks {

	private By setting = By.xpath(allBanks.setting);
	private By getBankName = By.xpath(allBanks.getBankName);
	private By configureApi = By.xpath(allBanks.configureApi);
	private By paymentProcessor = By.xpath(allBanks.paymentProcessor);

	
	//header
	private By configureApiHeader = By.xpath(allBanks.configureApiHeader);
	
	//add api
	private By addApi = By.xpath(allBanks.addApi);
	private By merchantMasterPayemtProcessor=By.xpath(allBanks.merchantMasterPayemtProcessor);
	
	//notify pop up
	private By notifyPopupButton=By.xpath(allBanks.notifyButton);
	private By notifyPopupMessage=By.xpath(allBanks.notifyPopup);
	@FindBy(xpath="//button[@id='notifyBtn']") private WebElement popupButton;
	


	// url tpe dropdown
	private By urlTypeDropdown = By.xpath(allBanks.urlTypeDropdown);
	private By RequestTypeDropdown = By.xpath(allBanks.RequestTypeDropdown);
	private By submitButton = By.xpath(allBanks.submitButton);
	private By urlError = By.xpath(allBanks.urlError);
	private By baseUrl = By.xpath(allBanks.baseUrl);
	private By duplicateEntry = By.xpath(allBanks.duplicateEntry);
	private By backButton=By.xpath(allBanks.backButton);
	private By deleteButtonMerchantmaster=By.xpath(allBanks.deleteButtonMerchantmaster);
	private By confirm=By.xpath(allBanks.confirm);
	private By noRecordsAvailable=By.xpath(allBanks.noRecordsAvailable);
	
	//view  details
	private By viewDetails=By.xpath(allBanks.viewDetails);
	private By getMidName=By.xpath(allBanks.getMidName);
	private By bankNameOnViewMidPage=By.xpath(allBanks.bankNameOnViewMidPage);
	private By getAPIName=By.xpath(allBanks.getAPIName);
	private By getURLTYPEName=By.xpath(allBanks.getURLTYPEName);
	private By bankNameOnAddMidPage=By.xpath(allBanks.bankNameOnAddMidPage);
	private By updateButton=By.xpath(allBanks.updateButton);
	
	
	private ActionDriver actionDriver;
	private WebDriver driver;

	public setting_allBanks(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.actionDriver = new ActionDriver(driver);
	}

	public void verifyUserIsOnTheConfigureApiPage() {

		String bankName = actionDriver.getText(getBankName);

		actionDriver.click(setting);
		Reporter.log("User click on the Bank setting", true);

		String paypemt_Processor = actionDriver.getText(paymentProcessor);

		Assert.assertTrue(actionDriver.isDisplayed(configureApi),
				"If configure Api Is not displays then this TC is in failed condition");
		Reporter.log("User validate that if user click on the setting then user is on the Configure Api", true);

		Assert.assertEquals(bankName, paypemt_Processor,
				"Validate that if user click on setting of bank then user is on the same payment processor page");
		Reporter.log("Validate that if user click on setting of bank then user is on the same payment processor page",
				true);
	}

	
	
	public void verifyConfigureApiHeader() {
		
		WebDriver driver=baseClass.getDriver();
		List<WebElement> headers = driver.findElements(configureApiHeader);
		
		List<String>  addedheaders=new ArrayList<String>();
		
		List<String> actualheaders=Arrays.asList("API","URL TYPE","ACTION");
		
		for(WebElement h:headers) {
			addedheaders.add(h.getText().trim());
		}
		
		Assert.assertEquals(addedheaders, actualheaders);
		Reporter.log("Table header verification PASSED. Headers match exactly by name.", true);
		
	}
	
	
	
	public void validateSamePaymentProcessorOccurOnAddApiPage() {
	    // Get Payment Processor name from API page
	    String paymentProcessor_BankName = actionDriver.getText(paymentProcessor);
	    Reporter.log("Fetched Payment Processor Bank Name from Configure API page: " 
	                 + paymentProcessor_BankName, true);

	    // Click on Add API button
	    actionDriver.click(addApi);
	    Reporter.log("User clicked on the 'Add API' button", true);

	    // Get Payment Processor name from Merchant Master page
	    String merchantMaster_BankName = actionDriver.getText(merchantMasterPayemtProcessor);
	    Reporter.log("Fetched Payment Processor Bank Name from Merchant Master page: " 
	                 + merchantMaster_BankName, true);

	    // Validation
	    Assert.assertEquals(paymentProcessor_BankName, merchantMaster_BankName,
	            "Bank names on Configure API and Merchant Master page do not match!");

	    Reporter.log("Validation successful: Bank name is the same on both Configure API page "
	                 + "and Merchant Master page", true);
	}



	public void verifyPopUpMessage() {
	    WebDriver driver = baseClass.getDriver();

	    Actions a = new Actions(driver);
	    a.clickAndHold(popupButton).build().perform();

	    boolean isPopupDisplayed = actionDriver.isDisplayed(notifyPopupMessage);

	    if (isPopupDisplayed) {
	        Reporter.log("✅ Popup message is displayed successfully.", true);
	    } else {
	        Reporter.log("❌ Popup message is NOT displayed.", true);
	    }
	}
	
	public void checkDropdownValuesAreAlreadySelectedUrlType() {
		String firstSelectedOptions = actionDriver.getFirstSelectedOption(urlTypeDropdown);
		
		System.err.println(firstSelectedOptions);
		String actualValueUrlType="2DPAYMENTNEXT";
		Assert.assertEquals(actualValueUrlType,firstSelectedOptions, "Dropdown default value mismatch!");
		
	}
	
	public void checkDropdownValuesAreAlreadySelectedRequestUrl() {
		String firstSelectedOptions = actionDriver.getFirstSelectedOption(RequestTypeDropdown);
		
		System.err.println(firstSelectedOptions);
		String actualValueUrlType="Get";
		Assert.assertEquals(actualValueUrlType,firstSelectedOptions, "Dropdown default value mismatch!");
		
	}
	
	public void urlDropdown() {
	    // Get dropdown options as text
	    List<String> actualOptions = actionDriver.getDropdownOptions(urlTypeDropdown);
	    Reporter.log("Actual Dropdown Options: " + actualOptions, true);

	    List<String> paymentTypes = Arrays.asList(
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

	    Reporter.log("Expected Dropdown Options: " + paymentTypes, true);

	    // Assertion for values
	    Assert.assertEquals(actualOptions, paymentTypes, "Dropdown options mismatch");
	    Reporter.log("Dropdown values match successfully ✅", true);

	    // Assertion for size
	    int actualSize = actualOptions.size();
	    System.err.println("Total options in URL dropdown are :- "+actualSize);
	    Assert.assertEquals(actualSize, paymentTypes.size(), "Dropdown size mismatch!");
	    Reporter.log("Dropdown size matched. Expected: " + paymentTypes.size() + " | Actual: " + actualSize, true);
	}
	
	public void validateRequestTypeDropdown() {
	    List<String> actualOptions = actionDriver.getDropdownOptions(RequestTypeDropdown);
	    Reporter.log("Actual Dropdown Options: " + actualOptions, true);
	    
	    List<String> expectedOptions=Arrays.asList("Get","Post");
	    
	    Reporter.log("Expected Dropdown Options: " + expectedOptions, true);

	    // Assertion for values
	    Assert.assertEquals(actualOptions, expectedOptions, "Dropdown options mismatch");
	    Reporter.log("Dropdown values match successfully ✅", true);

	    // Assertion for size
	    int actualSize = actualOptions.size();
	    System.err.println("Total options in Request Type dropdown are :- "+actualSize);
	    Assert.assertEquals(actualSize, expectedOptions.size(), "Dropdown size mismatch!");
	    Reporter.log("Dropdown size matched. Expected: " + expectedOptions.size() + " | Actual: " + actualSize, true);
	    
	    
	}

	
	
	public void validateErrorInUrl() {
		actionDriver.click(submitButton);
		Reporter.log("User click on the Submit button", true);
		
		Assert.assertTrue(actionDriver.isDisplayed(urlError));
		Reporter.log("validate error :- This field is required. ", true);
	}
	
	public void userEnterUrlOrBaseUrl() throws InterruptedException {
		String url = testData_CreateRoll.generateRandomBaseUrl();
		System.err.println(url);
		actionDriver.sendKeysWithActions(baseUrl,url);
		Thread.sleep(500);
		Reporter.log("user enter base url :- "+ url, true);
		Thread.sleep(500);
		actionDriver.click(submitButton);
		Reporter.log("User click on the Submit button", true);

		
	}
	
	public void validateForDuplicateEntry() {
		
		actionDriver.isDisplayed(duplicateEntry);
		Reporter.log("If user created entery using Same URL type then :-  Duplicate entry found this message is should be displays", true);
	}

	
	public void backButtonFromMerchantMaster() {

		actionDriver.click(backButton);
		Reporter.log("User click on the back button", true);

	}
	
	public void deleteActionOnMerchantMaster() throws InterruptedException {
		if(actionDriver.isDisplayed(deleteButtonMerchantmaster)) {
			actionDriver.clickUsingJS(deleteButtonMerchantmaster);
			Reporter.log("User click on the Delete button", true);
			Thread.sleep(1000);
			actionDriver.click(confirm);
			Reporter.log("User click on the Confirm button", true);
		}
	}
	
	public void noRecordsDisplays() {
		if(actionDriver.isDisplayed(noRecordsAvailable)) {
			
			Reporter.log("There is no records are displays ", true);
		
		}
	}
	String api;
public String getAPINameFromConfigureAPI() {
	 api = actionDriver.getText(getAPIName);
	 Reporter.log("User API Name"+api, true);
	return api;
}

String payment_Processor;
public String getPaymentProcessorNameFromConfigureAPI() {
	 payment_Processor = actionDriver.getText(paymentProcessor);
	 Reporter.log("User get payment processor name", true);
	return payment_Processor;
}

public void clickOnviewDetails() {
	getAPINameFromConfigureAPI();
	getPaymentProcessorNameFromConfigureAPI();
	actionDriver.click(viewDetails);
	Reporter.log("User click on the View Details button", true);
}

	
	public void verifyAPINameAndPaymentProcessorOnUpdateActionPage() {
		WebDriver driver=baseClass.getDriver();
		
        String urlName = actionDriver.getAttribute(baseUrl, "value");
       String bankNameOnMerchantMaster = actionDriver.getText(bankNameOnAddMidPage);
       System.out.println(urlName);
       System.out.println(bankNameOnMerchantMaster);
       

		    Reporter.log("API from page: " + api, true);
		    Reporter.log("Payment Processor from page: " + bankNameOnMerchantMaster, true);

		  
		    Assert.assertNotNull(api, "API should not be null");
		    Assert.assertEquals(api,urlName, "Unexpected URL name found!");
		    Assert.assertEquals(bankNameOnMerchantMaster,payment_Processor, "Unexpected payment processor found!");

	}
	
	
	public void selectUrlType(String urlType) {
	    actionDriver.selectByVisibleText(urlTypeDropdown, urlType);
	    Reporter.log("✅ Selected URL Type from dropdown: " + urlType, true);
	}

	public void selectRequestType(String requestType) {
	    actionDriver.selectByVisibleText(RequestTypeDropdown, requestType);
	    Reporter.log("✅ Selected Request Type from dropdown: " + requestType, true);
	}
	
	public void updateButtonOnMerchantMaster(String requestType) {
	    actionDriver.selectByVisibleText(updateButton, requestType);
	    Reporter.log("✅ Selected Request Type from dropdown: " + requestType, true);
	}
	
	
	public void clickviewDetails() {

		actionDriver.click(viewDetails);
		Reporter.log("User click on the View Details button", true);
	}
	
	String urlName;
	public String getUrlTypename() {
		urlName = actionDriver.getText(getURLTYPEName);
		return urlName;
	}
	
	
	
	
	public void updateConfigureAPI() throws InterruptedException {
	    Reporter.log("🔍 Starting updateConfigureAPI test flow", true);


	    String apiName = actionDriver.getAttribute(baseUrl, "value");
	    Reporter.log("Extracted API Name: " + apiName, true);

	    String firstSelectedOption = actionDriver.getFirstSelectedOption(urlTypeDropdown);
	    Reporter.log("Extracted First Selected Dropdown Option: " + firstSelectedOption, true);

	    // Validations
	    Assert.assertEquals(apiName, api, "API name did not match!");
	    Reporter.log("✅ API name matches expected: " + api, true);

	    Assert.assertEquals(urlName, firstSelectedOption, "URL Type name did not match!");
	    Reporter.log("✅ URL Type dropdown value matches expected: " + urlName, true);

	    // Check if update button is displayed
	    actionDriver.isDisplayed(updateButton);
	    Reporter.log("Verified 'Update' button is displayed", true);

	    // Click on "Update" button
	    actionDriver.clickUsingJS(updateButton);
	    Reporter.log("User clicked on the 'Update' button", true);


	    Reporter.log("🎯 Completed updateConfigureAPI test flow successfully", true);
	}
	
	
	public void validateIfUserHitBackOrUpdateButtonThenUserIsOnTheConfigureAPIPage() {
	    boolean isConfigureApiVisible = actionDriver.isDisplayed(configureApi);

	    // Assertion
	    Assert.assertTrue(isConfigureApiVisible, "Configure API page is not displayed!");

	    // Log in TestNG report
	    Reporter.log("User is successfully navigated to the Configure API page", true);
	}
	

}
