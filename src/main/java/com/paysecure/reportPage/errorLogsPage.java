package com.paysecure.reportPage;

import java.time.Duration;
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

import com.paysecure.actiondriver.ActionDriver;
import com.paysecure.base.baseClass;
import com.paysecure.locators.errorLogPage;



//import com.paysecure.reportPage.errorLogPage;


public class errorLogsPage {

    //navigate uptoAPI LOG
	
    private By analytics = By.xpath(errorLogPage.analytics);
    private By report = By.xpath(errorLogPage.report);
    private By errorLog = By.xpath(errorLogPage.errorLog);
    private By ERRORLOG = By.xpath(errorLogPage.ERRORLOG);

    @FindBy(xpath="//input[@id='logoImageforUpload']") private WebElement logoUpload;

    // filter through select merchant
    private By selectmerchant = By.xpath(errorLogPage.selectmerchant);
    private By searchmerchant = By.xpath(errorLogPage.searchmerchant);


    //search through - Merchant Ref Id
    private By merchantRefId = By.xpath(errorLogPage.merchantRefId);


    //search through - Purchase Id
    private By purchaseId = By.xpath(errorLogPage.purchaseId);


    //search button
    private By search = By.xpath(errorLogPage.search);


    private ActionDriver actionDriver;
    private WebDriver driver;

    // page factory constructor
    public errorLogsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.actionDriver = new ActionDriver(driver);
    }

    public void navigateUptoErrorLog() {
       WebDriver driver=baseClass.getDriver();
    	 driver.manage().window().setSize(new Dimension(1280, 720));
    	
        actionDriver.scrollToElement(analytics);
        Reporter.log("User navigate upto Analytics", true);

        actionDriver.click(report);
        Reporter.log("User click on Report Main Module", true);


        actionDriver.click(errorLog);
        Reporter.log("User click on Error Log Sub Module", true);

        Assert.assertTrue(actionDriver.isDisplayed(ERRORLOG), "If Error Log is not displays on Error log page then user is not on the Error log page");
        Reporter.log("User is on the Error Log Sub Module", true);

    }

    public void selectDashboardusinAllMerchant(WebDriver driver, String partialMerchantname, String merchant) throws InterruptedException {
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
        Thread.sleep(2000);
        actionDriver.click(selectmerchant);


        Reporter.log("click on the select merchant filed", true);
        Thread.sleep(2000);
        w.until(ExpectedConditions.elementToBeClickable(searchmerchant)).sendKeys(partialMerchantname);
        Reporter.log("Enter merchant name in a search merchant functioanlity", true);

        Thread.sleep(2000);

        List<WebElement> suggestions = w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//ul[@id='select2-merchantList-results']/li")));

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


    public void search_Merchant_Ref_Id() {
        actionDriver.enterText(merchantRefId, "686cc3549e34dc5662676bf0");
        Reporter.log("User enter Merchant Ref ID in merchant ref ID Text Field", true);

    }

    public void search_Purchase_Id() {
        actionDriver.enterText(purchaseId, "686cc3549e34dc5662676bf0");
        Reporter.log("User enter Purchase Id in Purchase Id Text Field", true);

    }

    public void searchButton() {
        actionDriver.click(search);
        Reporter.log("User click on search button", true);
        
        logoUpload.sendKeys("C:\\Users\\LENOVO\\Downloads\\am\\Automation-main\\src\\main\\resources\\Logo.jpg");

    }


}
