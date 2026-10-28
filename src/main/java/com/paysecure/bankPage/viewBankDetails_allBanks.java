package com.paysecure.bankPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.paysecure.actiondriver.ActionDriver;
import com.paysecure.locators.allBanks;




public class viewBankDetails_allBanks {

	// view bank details
	private By viewBankDetails = By.xpath(allBanks.viewBankDetails);
	private By getBankName = By.xpath(allBanks.getBankName);
	private By bank_Details = By.xpath(allBanks.bank_Details);
	private By getBankNameFromBankDetails = By.xpath(allBanks.getBankNameFromBankDetails);

	// pop up success message
	private By getPopUpSuccessOnBankDetailsPage = By.xpath(allBanks.getPopUpSuccessOnBankDetailsPage);

	// update any one field --State
	private By state = By.xpath(allBanks.state);
	private By update = By.xpath(allBanks.update);
	private By back = By.xpath(allBanks.back);
	private By banks = By.xpath(allBanks.bank_s);

	private ActionDriver actionDriver;
	private WebDriver driver;

	public viewBankDetails_allBanks(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.actionDriver = new ActionDriver(driver);
	}

	String bankName;

	public String viewBankDetails() {
		bankName = actionDriver.getText(getBankName);
		Reporter.log("User get Text of bank name :- " + bankName, true);
		actionDriver.click(viewBankDetails);
		Reporter.log("User click on the View Bank Details button", true);
		return bankName;

	}

	public void validateBankNameOnBankDetailsPage() {

		Assert.assertTrue(actionDriver.isDisplayed(bank_Details));

		String getBank_Name = actionDriver.getAttribute(getBankNameFromBankDetails, "Value");
		System.err.println(getBank_Name);

		Assert.assertEquals(bankName, getBank_Name, "If both values are not Same Then our TC is in failed condition");

	}

	public void updateState() {
		actionDriver.enterText(state, "Rajsthan");
		Reporter.log("User Update state textfield", true);

		actionDriver.scrollToElement(update);

		actionDriver.clickUsingJS(update);
		Reporter.log("User Click on the update button", true);

		System.out.println(actionDriver.isDisplayed(getPopUpSuccessOnBankDetailsPage));
	}
	
	public void setbackForBackFunctionality() {
		String getBank_Name = actionDriver.getAttribute(getBankNameFromBankDetails, "Value");
		System.err.println(getBank_Name);

		actionDriver.scrollToElement(back);

		actionDriver.clickUsingJS(back);
		Reporter.log("User Click on the back button", true);
	}

	public void validateIfUserClickOnBackButtonThenUserIsOnTheBanksPage() {
	

		Assert.assertTrue(actionDriver.isDisplayed(banks));
		Reporter.log("Validate that If user click on the back button then user is on the Banks page", true);

	}
	
	

	
	

}
