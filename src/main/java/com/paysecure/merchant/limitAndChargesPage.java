package com.paysecure.merchant;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.paysecure.actiondriver.ActionDriver;
import com.paysecure.base.baseClass;
import com.paysecure.locators.merchantLimitAndCharges;

public class limitAndChargesPage {

	
	private By merchants = By.xpath(merchantLimitAndCharges.merchants);
	private By limitCharges = By.xpath(merchantLimitAndCharges.limitCharges);

	//select merchant
	private By sM=By.xpath(merchantLimitAndCharges.sm);
	private By searchMerchant=By.xpath(merchantLimitAndCharges.searchMerchant);
	private By selectOption=By.xpath(merchantLimitAndCharges.selectOption);
	private By selectCurrency=By.xpath(merchantLimitAndCharges.selectCurrency);
	private By searchCurrency=By.xpath(merchantLimitAndCharges.searchCurrency);
	private By selectCurrencyFromOption=By.xpath(merchantLimitAndCharges.selectCurrencyFromOption);
	private By selectPaymentMethod=By.xpath(merchantLimitAndCharges.selectPaymentMethod);
	private By selectPaymentMethodFromOptions=By.xpath(merchantLimitAndCharges.selectPaymentMethodFromOptions);
	private By get=By.xpath(merchantLimitAndCharges.get);
	
	private ActionDriver actionDriver;
	public limitAndChargesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.actionDriver = new ActionDriver(driver);
	}
	
	
	public void navigateUptoLimitAndCharges() throws InterruptedException {
		WebDriver driver = baseClass.getDriver();
		Thread.sleep(500);
		driver.manage().window().setSize(new Dimension(1280, 720));// 1920 × 1080

		actionDriver.clickUsingJS(merchants);
		actionDriver.clickUsingJS(limitCharges);
		

	}
	

	public void selectMerchantFromMerchantLimitAndCharges(String merchant) {
		Reporter.log("🔍 Selecting merchant: " + merchant, true);
	    actionDriver.click(sM);
	    actionDriver.enterText(searchMerchant, merchant);
	    actionDriver.click(selectOption);
	    Reporter.log("✅ Merchant selected: " + merchant, true);
	}

	public void selectCurrencyFromMerchantLimitAndCharges(String currency) {
	    Reporter.log("💱 Selecting currency: " + currency, true);
	    actionDriver.click(selectCurrency);
	    actionDriver.enterText(searchCurrency, currency);
	    actionDriver.click(selectCurrencyFromOption);
	    Reporter.log("✅ Currency selected: " + currency, true);
	}

	public void selectPaymentmethodFromMerchantLimitAndCharges(String paymentmethod) {
	    Reporter.log("💳 Selecting payment method: " + paymentmethod, true);
	    actionDriver.click(selectPaymentMethod);
	    actionDriver.enterText(searchCurrency, paymentmethod);
	    actionDriver.click(selectPaymentMethodFromOptions);
	    Reporter.log("✅ Payment method selected: " + paymentmethod, true);
	}
	
	
	

	public void getDetailsForLimitAndCharges() {
	    Reporter.log("📋 Fetching details for Limit and Charges", true);
	    actionDriver.click(get);
	    Reporter.log("✅ Details fetched successfully", true);
	}
	
	
	
	
	
	
	
	
	
	
}
