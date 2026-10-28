package com.paysecure.merchant;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.paysecure.actiondriver.ActionDriver;
import com.paysecure.base.baseClass;
import com.paysecure.locators.detailsMerchant;
import com.paysecure.locators.merchantLimitAndCharges;

public class detailsPage {

	// navigate upto details page
	private By merchant = By.xpath(detailsMerchant.merchants);
	private By details = By.xpath(detailsMerchant.details);
	private By limitCharges = By.xpath(merchantLimitAndCharges.limitCharges);

	// select merchant
	private By selectMerchant = By.xpath(merchantLimitAndCharges.sm);
	private By searchMerchant = By.xpath(merchantLimitAndCharges.searchMerchant);
	private By selectOption = By.xpath(detailsMerchant.selectOptions);
	
	//Allowed payment methods
	private By allowedPaymentMethod=By.xpath(detailsMerchant.allowedPaymentMethod);
    private By selectedPaymentmethod=By.xpath(detailsMerchant.selectedPaymentmethod);
    @FindBy(xpath = "//ul[@id='paymentMethodsList']/li")private List<WebElement> paymentMethods;
    @FindBy(xpath = "//ul[@id='select2-currencySel-results']/li")private List<WebElement> selectCurrncy;
    @FindBy(xpath = "//ul[@id='select2-payMethodSel-results']/li")private List<WebElement> pmt;
    private By selectCurrency=By.xpath(merchantLimitAndCharges.selectCurrency);
    private By selectPaymentMethod=By.xpath(merchantLimitAndCharges.selectPaymentMethod);
    
    
    //allowed currency
    private By allowedCurrency=By.xpath(detailsMerchant.allowedCurrency);
    
    
    
    
	private ActionDriver actionDriver;

	public detailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.actionDriver = new ActionDriver(driver);
	}

	public void navigateUptoDetails() throws InterruptedException {
		WebDriver driver = baseClass.getDriver();
		Thread.sleep(500);
		driver.manage().window().setSize(new Dimension(1280, 720));// 1920 × 1080

		actionDriver.clickUsingJS(merchant);
		actionDriver.clickUsingJS(details);

	}

	public void selectMerchantFromDetailsPage(String merchant) {
		Reporter.log("🔍 Selecting merchant: " + merchant, true);
	    actionDriver.click(selectMerchant);
	    actionDriver.enterText(searchMerchant, merchant);
	    actionDriver.click(selectOption);
	    Reporter.log("✅ Merchant selected: " + merchant, true);
	}
	
	List<String> methodNames;
	   public List<String> getAllPaymentMethodNames() {
		   actionDriver.clickUsingJS(allowedPaymentMethod);
		   methodNames= new ArrayList<>();
	        for (WebElement method : paymentMethods) {
	            methodNames.add(method.getText());
	        }
	        return methodNames;
	    }
	   
	    List<String> checkedCurrencies;
	   public  List<String> collectCheckedCurrencies(WebDriver driver) {
        actionDriver.scrollToElement(allowedCurrency);
        actionDriver.clickUsingJS(allowedCurrency);
		   checkedCurrencies = new ArrayList<>();

		    List<WebElement> currencyBlocks = driver.findElements(By.xpath("//div[@class='col currcnyAlw ng-scope']"));

		    for (WebElement block : currencyBlocks) {
		        WebElement checkbox = block.findElement(By.xpath(".//input[@type='checkbox']"));
		        WebElement label = block.findElement(By.xpath(".//label"));

		        if (checkbox.isSelected()) {
		            checkedCurrencies.add(label.getText().trim());
		        }
		    }

		    return checkedCurrencies;
		}
	   
	   List<String> curr;
	   public List<String> getAllCurrencies() {
		   
		   curr  = new ArrayList<>();
		   for(WebElement sc:selectCurrncy) {
			   curr.add(sc.getText().trim());
			   
		   }
		   
		   if(!curr.isEmpty()) {
			   curr.remove(0);
		   }
		   return curr;
	   }


	   public void compareCurrencies() {
		   System.out.println(curr);
		   Assert.assertEqualsNoOrder(curr.toArray(), checkedCurrencies.toArray());
	   }
	   
	   public void clickOnLimitAndCharges() {
		   actionDriver.clickUsingJS(limitCharges);
		 
	   }
	   
	   public void clickOnSelectCurrency() {
		   actionDriver.click(selectCurrency);
	   }
	   
	   public void clickOnSelectPaymentMethod() {
		   actionDriver.click(selectPaymentMethod);
	   }
	   
	   List<String> paymenTMethods;
	   public  List<String> getAllSelectedPaymentMethods() {
		   paymenTMethods =new ArrayList<>();
		   for(WebElement p:pmt) {
			   paymenTMethods.add(p.getText().trim());
		   }
		   
		   if(!paymenTMethods.isEmpty()) {
			   paymenTMethods.remove(0);
		   }
		   return paymenTMethods;
	   }
	   
	   public void comparePaymentMethod() {
		   System.out.println(methodNames);
		   System.out.println(paymenTMethods);
		   Assert.assertEquals(methodNames, paymenTMethods);
	   }
	   
}
