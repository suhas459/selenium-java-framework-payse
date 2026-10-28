package com.paysecure.bankPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.paysecure.actiondriver.ActionDriver;
import com.paysecure.base.baseClass;
import com.paysecure.locators.allBanks;
import com.paysecure.utilities.testData_CreateRoll;

public class jsonTransformer_allBanks {

	private By jsonTransformer = By.xpath(allBanks.jsonTransformer);
	private By PaymentBankJsonData = By.xpath(allBanks.PaymentBankJsonData);
	private By bankName = By.xpath(allBanks.bankName);
	private By paymentProcessor = By.xpath(allBanks.paymentProcessor);
	private By PaymentBankJsonDataHeaders = By.xpath(allBanks.PaymentBankJsonDataHeaders);
	private By addJson = By.xpath(allBanks.addJson);
	private By json_Transformer = By.xpath(allBanks.json_Transformer);
	private By bank_name_display = By.xpath(allBanks.bank_name_display);
	private By submitButtonJsonTransformer = By.xpath(allBanks.submitButtonJsonTransformer);
	private By configueJson = By.xpath(allBanks.configueJson);
	private By flowType = By.xpath(allBanks.flowType);

	
	//action -------------
	private By action = By.xpath(allBanks.action);
	private By getMidName = By.xpath(allBanks.getMidName);
	private By updatEButton = By.xpath(allBanks.updatEButton);
	private By backButton = By.xpath(allBanks.backButton);

	private ActionDriver actionDriver;
	private WebDriver driver;

	public jsonTransformer_allBanks(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.actionDriver = new ActionDriver(driver);
	}

	public void validateJsonTransformerIsClickable() {
		getbankName();
		actionDriver.isEnabled(jsonTransformer);
		actionDriver.click(jsonTransformer);
		Reporter.log("User click on the Json Transformer", true);

	}

	String bank_Name;

	public String getbankName() {
		bank_Name = actionDriver.getText(bankName);
		Reporter.log("Fetched Bank Name from UI: " + bank_Name, true);
		return bank_Name;
	}

	public void verifybankNameAndPaymentBankJsonData() {
		boolean paymentBankJsonData = actionDriver.isDisplayed(PaymentBankJsonData);
		Reporter.log("Checking if 'PaymentBankJsonData' title is displayed on page", true);

		Assert.assertTrue(paymentBankJsonData,
				"If PaymentBankJsonData title is not displayed then user is on the wrong page");
		Reporter.log("'PaymentBankJsonData' title is displayed successfully", true);

		String bnName = actionDriver.getText(paymentProcessor);
		Reporter.log("Fetched Payment Processor from UI: " + bnName, true);

		Assert.assertEquals(bnName, bank_Name, "If bank name is not same then user is on another bank page!!!");
		Reporter.log("Bank name matched successfully: " + bnName, true);
	}

	String banKName;

	public String getPayMentProcesor() {
		banKName = actionDriver.getText(paymentProcessor);
		return banKName;
	}

	public void validateHeadersInPaymentBankJsonData() {
		WebDriver driver = baseClass.getDriver();

		// Fetch headers from UI
		List<WebElement> headers = driver.findElements(PaymentBankJsonDataHeaders);
		List<String> addedHeaders = new ArrayList<>();

		for (WebElement h : headers) {
			addedHeaders.add(h.getText().trim());
		}

		Reporter.log("Fetched Headers from UI: " + addedHeaders, true);

		// Expected headers
		List<String> expHeaders = Arrays.asList("FLOW TYPE", "CONFIG JSON","UPDATED BY", "ACTION");
		Reporter.log("Expected Headers: " + expHeaders, true);

		// Assertion
		Assert.assertEquals(addedHeaders, expHeaders, "Mismatch in PaymentBankJsonData headers!");
		Reporter.log("Header validation successful. Headers matched: " + addedHeaders, true);
	}

	public void validateUserisOnJsonTransformerPage() {

		getPayMentProcesor();

		actionDriver.click(addJson);
		Reporter.log("User click on the Add Json Button", true);

		boolean json = actionDriver.isDisplayed(json_Transformer);
		Assert.assertTrue(json);

		String bnName = actionDriver.getText(bank_name_display);

		Assert.assertEquals(banKName, bnName);
	}

	public void getAllErrorsFromJsonTrnsformer() {
		actionDriver.scrollToElement(submitButtonJsonTransformer);

		actionDriver.click(submitButtonJsonTransformer);
		Reporter.log("User click on the Submit Button", true);

		String alertText = actionDriver.getAlertText();
		Assert.assertEquals(alertText, "Flow Type and Config JSON are required.");
		Reporter.log("User validate Alert message successfully!!!", true);

		actionDriver.acceptAlert();
		Assert.assertEquals(alertText, "Flow Type and Config JSON are required.");
		Reporter.log("User click on the OK button !!!", true);

		actionDriver.enterText(configueJson, ")(*&^%^&*(");
		actionDriver.scrollToElement(submitButtonJsonTransformer);

		actionDriver.click(submitButtonJsonTransformer);
		Reporter.log("User click on the Submit Button", true);

		String alert_Text = actionDriver.getAlertText();
		Assert.assertEquals(alert_Text, "Flow Type and Config JSON are required.");
		Reporter.log("User validate Alert message successfully!!!", true);

		actionDriver.acceptAlert();

	}

	public void userEnterValidJsonFormat() {
		String jsonName = testData_CreateRoll.generateRandomUsername();
		System.out.println(jsonName);

		actionDriver.enterText(flowType, jsonName);
		Reporter.log("User neter flowtype name" + jsonName, true);

		actionDriver.enterText(configueJson,
				"{\r\n" + "  \"expectedHeaders\": [\"FLOW TYPE\", \"CONFIG JSON\", \"ACTION\"],\r\n"
						+ "  \"actualHeaders\": [\"FLOW TYPE\", \"CONFIG JSON\", \"ACTION\"]\r\n" + "}");

		actionDriver.click(submitButtonJsonTransformer);
		Reporter.log("User click on the Submit Button", true);
	}
	
	//----------------------------action-----------------------------
	
	String floWType;
	public String getFlowType() {
		floWType = actionDriver.getText(getMidName);
		System.err.println("I am from PaymentBankJsonData:-"+floWType);
		return floWType;
	}
	

	
	
	public void verifyAction() {
		WebDriver driver=baseClass.getDriver();
		
	
		String ft = actionDriver.getText(flowType);
		System.err.println("ft"+ft);
		
		System.err.println("I am used in json transformer :- "+ floWType);
		String bnName = actionDriver.getText(bank_name_display);
		
		Assert.assertEquals(bnName, banKName);
		actionDriver.getAttribute(PaymentBankJsonData, bnName);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Get the value of the input field by ID
		String flowType = (String) js.executeScript("return document.getElementById('flowValue').value;");
        System.out.println("I used java script for mget text"+flowType);

        Assert.assertFalse(actionDriver.isEnabled(this.flowType));

		Assert.assertEquals(floWType, flowType);
		
		
	}
	
	public void clickAction() {
		if(actionDriver.isDisplayed(action)) {
			actionDriver.clickUsingJS(action);
			Reporter.log("User click on the Action Button", true);
			}
	}
	
	
	public void clickUpdateButton() {
		actionDriver.scrollToElement(updatEButton);
		Reporter.log("User scroll up to  Update Button", true);
		
		actionDriver.clickUsingJS(updatEButton);
		Reporter.log("User click on the Update Button", true);
	}
	
	public void clickBackButton() {
		actionDriver.scrollToElement(backButton);
		Reporter.log("User scroll up to  Back Button", true);
		
		actionDriver.clickUsingJS(backButton);
		Reporter.log("User click on the Back Button", true);
	}

}
