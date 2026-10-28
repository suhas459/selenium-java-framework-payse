package com.paysecure.bankPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import com.paysecure.locators.allBanks;
import com.paysecure.utilities.testData_CreateRoll;






public class viewMids_allBanks {

	// create MID
	private By createMID = By.xpath(allBanks.createMID);
	private By midName = By.xpath(allBanks.midName);
	private By allotedMID = By.xpath(allBanks.allotedMID);
	private By authKey = By.xpath(allBanks.authKey);
	
	//view details button
	private By viewDetailsUpdateButton = By.xpath(allBanks.viewDetailsUpdateButton);
	
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
	private By mid__Name=By.xpath(allBanks.midName);
	@FindBy(xpath="//input[@id='mid']")private WebElement MIDNAME;
	private By bankNameOnAddMidPage=By.xpath(allBanks.bankNameOnAddMidPage);
//	=========================Mid Product List ========================================
	private By midProductList = By.xpath(allBanks.midProductList);
	private By midnameOnMidProductList = By.xpath(allBanks.midnameOnMidProductList);
	private By uploadCsvFile = By.xpath(allBanks.uploadCsvFile);
	private By upload = By.xpath(allBanks.upload);
	private By downloadSampleCsv = By.xpath(allBanks.downloadSampleCsv);
	private By enterProductname = By.xpath(allBanks.enterProductname);
	private By enterProductPrice = By.xpath(allBanks.enterProductPrice);
	private By add = By.xpath(allBanks.add);
	
	private By ok = By.xpath(allBanks.ok);
	private By uploadFileText = By.xpath(allBanks.uploadFileText);
	private By fillCompleteDataError = By.xpath(allBanks.fillCompleteDataError);
	private By fillValidValues = By.xpath(allBanks.fillValidValues);
	private By expectedHeaders=By.xpath(allBanks.headersProductList);
	private By productAddPopUp = By.xpath(allBanks.productAddPopUp);
	private By deleteProductName = By.xpath(allBanks.deleteProductName);
	private By deleteSuccessfullyMessage=By.xpath(allBanks.deleteProductSuccessfully);
	private By deleteOkButton = By.xpath(allBanks.deleteOkButton);
	
	
	private ActionDriver actionDriver;
	private WebDriver driver;
	
	public viewMids_allBanks(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.actionDriver = new ActionDriver(driver);
	}
	
	public void clickOnAddMid() {
		actionDriver.click(createMID);
		
		  Reporter.log("User clicked on Add MID Button", true);
	}
	
public static String mid__name;

	public String addMidToBank() {

		mid__name = testData_CreateRoll.createMidNameAndAllotedMid();
		String auth_Key = "4197a83kt1qgqav51hflqpm1t4##s650foqq3fcmd9po47lp5q3n4b39431l2vtj85g18aqpcvkb3cl##fead5d6f-0945-44e0-a26c-1b7daab89bf1##5d9fde44-7b03-48fc-bdf8-751322db0600##2afc4c62-78ae-480c-ad72-c7edeb74c105";

		actionDriver.clearText(createMID);
		Reporter.log("User click on Add Mid Button", true);

		actionDriver.enterText(midName, mid__name);
		Reporter.log("User enter mid name in mid name textfield" + mid__name, true);

		actionDriver.enterText(allotedMID, mid__name);
		Reporter.log("User enter Alloted mid name in Alloted mid name textfield" + mid__name, true);

		actionDriver.enterText(authKey, auth_Key);
		Reporter.log("User enter auth key in auth key text field" + auth_Key, true);

		return mid__name;

	}
	
	
	public void allowedCurrencyForcreateMID(String currency) throws InterruptedException {

//		actionDriver.scrollToElement(authKeyText);
		Thread.sleep(1000);

		// actionDriver.scrollToElement(selectCurrency);
		actionDriver.click(selectCurrency);
		Reporter.log("User click on select currency ", true);

		actionDriver.clickUsingJS(searchCurrency);
		actionDriver.enterText(searchCurrency, currency);
		Reporter.log("User enter currency in search currency textfield" + currency, true);

		// actionDriver.click(selectAllCurrency);
		actionDriver.clickUsingJS(selectAllCurrency);
		Reporter.log("User click on select all currency checkbox", true);
	}
	
	
	public void allowedCardsForCreateMID() {

		actionDriver.clickUsingJS(allowedCards);

		// actionDriver.click(allowedCards);
		Reporter.log("User click on allowed card  ", true);

		actionDriver.clickUsingJS(selectAllCards);

		// actionDriver.click(selectAllCards);
		Reporter.log("User click on select all card checkbox", true);

	}
	
	public void submitMID() throws InterruptedException {

		actionDriver.scrollToElement(submit);
		Thread.sleep(1200);

		actionDriver.click(submit);
		Reporter.log("User click on submit button", true);
	}
	
	public String bname;
	public String viewDetails() {
		actionDriver.clickUsingJS(viewDetailsUpdateButton);
		Reporter.log("User click on the View Details button", true);
		
		 bname =MIDNAME.getAttribute("value");
		return bname;
		
	}
	
	//=============================== MID PRODUCT LIST =============================================================
	
	
	public void verifyThatBankNameOnAddMidPage() {
		actionDriver.scrollToElement(midProductList);
		actionDriver.clickUsingJS(midProductList);
		Reporter.log("User click on the Mid Product List", true);
		String bn = actionDriver.getText(midnameOnMidProductList);
		Assert.assertEquals(bname, bn);

	}
	
	
	public void uploadCsvFile() throws InterruptedException {
		actionDriver.enterText(uploadCsvFile, "C:\\Users\\LENOVO\\Downloads\\am\\Automation-main\\src\\main\\resources\\productcsv.csv");
		Reporter.log("User upload csv file", true);
		
		actionDriver.clickUsingJS(upload);
		Reporter.log("User Click on the Upload Button", true);
	}
	
	public void handleFileUploadPopUp() throws InterruptedException {
		WebDriver driver=baseClass.getDriver();
		Assert.assertTrue(actionDriver.isDisplayed(uploadFileText), "If not displays then our TC is in failed condition");
		Reporter.log("Validate file upload successfull message", true);
		By okButton = By.xpath("//button[contains(@class,'swal2-confirm')]");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement okBtn = wait.until(ExpectedConditions.elementToBeClickable(okButton));

		// optional: small sleep for animation stability
		Thread.sleep(300); 

		// use JS click to avoid overlay issues
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", okBtn);
		Reporter.log("User click on the OK Button on the file upload pop up", true);
		
		
	}
	
	
	public void validateDownloadSampleCSVFileLink() {
		actionDriver.clickUsingJS(downloadSampleCsv);
		Reporter.log("User Click on the Download sample csv link", true);
	}
	
	public void captureAllErrorsWhileAddingProduct() {
		actionDriver.click(add);
		Reporter.log("User Click on the Add button", true);
		
		actionDriver.isDisplayed(fillCompleteDataError);
		Reporter.log("Validate That If User directly Click on The Add Button then This pop up is display to User", true);
		
		String enterProductnname = testData_CreateRoll.createRandom5CharWord();
		
		actionDriver.enterText(enterProductname,enterProductnname);
		Reporter.log("User Enter any product name", true);
		
		int a=testData_CreateRoll.createRandomIntUpto3Digits();
		String abc = String.valueOf(a);
		
		actionDriver.enterText(enterProductPrice,abc);
		Reporter.log("User Enter any product price", true);


	}
	
	
	public void verifyProductAddedPopUp() throws InterruptedException {
		actionDriver.click(add);
		Reporter.log("User Click on the Add button", true);
		
		String popUp = actionDriver.getText(productAddPopUp);
		Assert.assertEquals(popUp, "Product Added Successfully");

		actionDriver.clickUsingJS(ok);
		Reporter.log("User click on the OK Button on the file upload pop up", true);
		
	}
	
	
	public void verifyProductListHeader() {
		WebDriver driver=baseClass.getDriver();
		
		
		List<String> actualheaders=Arrays.asList("Product Name","Product Price","Action");
		
		List<WebElement> allHeaders = driver.findElements(expectedHeaders);
		
		List<String>  addedheaders=new ArrayList<String>();
		

		for (WebElement header : allHeaders) {
			addedheaders.add(header.getText().trim());
		}
		
		
		Assert.assertEquals(
				addedheaders.stream().map(String::toLowerCase).toList(),
			    actualheaders.stream().map(String::toLowerCase).toList(),
			    "Table headers do not match by name (case-insensitive)!"
			);
			Reporter.log("Table header verification PASSED. Headers match exactly by name (case-insensitive).", true);

		
	}
	
	public void deleteProductNameFromProductList() {
		actionDriver.click(deleteProductName);
		Reporter.log("User click on the Delete Product button", true);
	}
	
	public void deleteProductSuccessfullyMessagePopUp() throws InterruptedException {
		Thread.sleep(2000);
		String deleteMessage = actionDriver.getText(deleteSuccessfullyMessage);
		Assert.assertEquals(deleteMessage, "Product Deleted Successfully", "If message is not same then our TC is in failed condition");
	    Reporter.log("Validate delete message successfully", true);
	    
	    actionDriver.click(deleteOkButton);
	    Reporter.log("User click on the OK button on delete pop up", true);
	    
	
	}
	
}
