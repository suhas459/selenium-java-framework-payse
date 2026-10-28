package com.paysecure.reportPage;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.paysecure.actiondriver.ActionDriver;
import com.paysecure.base.baseClass;
import com.paysecure.locators.downloadPage;






public class downloadPages {

    // navigate upto Bank Transaction Time Report
    private By analytics = By.xpath(downloadPage.analytics);
    private By report = By.xpath(downloadPage.report);
    private By download = By.xpath(downloadPage.download);
    private By DOWNLOAD = By.xpath(downloadPage.DOWNLOAD);


    // currency
    private By selectCurrency = By.xpath(downloadPage.selectCurrency);
    private By searchCurrencytextfield = By.xpath(downloadPage.searchCurrencytextfield);
    private By listOfAllCurrencies = By.xpath(downloadPage.listOfAllCurrencies);


    // download -- select class -- purchase or Bank Transactions
    private By downloadSelect = By.xpath(downloadPage.downloadSelect);
    private By noRecordsFound = By.xpath(downloadPage.noRecordsFound);
    private By okButton = By.xpath(downloadPage.okButton);

    @FindBy(xpath = downloadPage.noRecordsFound)
    private WebElement NO_RECORDS_FOUND;


    private ActionDriver actionDriver;


    // page factory constructor
    public downloadPages(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.actionDriver = new ActionDriver(driver);
    }


    public void verifyUserIsOnDownloadPage(WebDriver driver) throws InterruptedException {
       WebDriver driver1=baseClass.getDriver();
    	WebDriverWait w = new WebDriverWait(driver1, Duration.ofSeconds(30));
      
        
    	 driver.manage().window().setSize(new Dimension(1366, 720));
        Thread.sleep(400);
     
        // scroll to element
        actionDriver.scrollToElement(analytics);

       

        actionDriver.click(report);
        Reporter.log("Click on Report Module", true);

        actionDriver.click(download);
        Reporter.log("Click on download Sub Module", true);

        Assert.assertTrue(actionDriver.isDisplayed(DOWNLOAD), "user is not on the Api Report Report this page");
        Reporter.log("Verify user is on the Download page", true);
    }

    public void downloadPurchaseOrBanktransaction(String downloadType) {
        actionDriver.selectByVisibleText(downloadSelect, downloadType);

        Reporter.log("user select values " + downloadType, true);

    }

    public void selectCurrency(WebDriver driver, String partialNameCurrency, String Currency)
            throws InterruptedException {
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
        Thread.sleep(2000);

        actionDriver.click(selectCurrency);
        Reporter.log("click on the select currency filed", true);
        Thread.sleep(2000);
        w.until(ExpectedConditions.elementToBeClickable(searchCurrencytextfield)).sendKeys(partialNameCurrency);


        Reporter.log("Enter currency name in a search currency functioanlity", true);

        Thread.sleep(2000);

        List<WebElement> suggestions = w.until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='select2-merCurr-results']/li")));

        for (WebElement s : suggestions) {
            if (Currency.equalsIgnoreCase(s.getText().trim())) {
                Thread.sleep(1000);
                s.click();
                Reporter.log("select merchant name :- " + Currency, true);
                break;

            }
        }
        Reporter.log("select Currency from all Currency", true);

    }


    public WebElement noRecordsFound(WebDriver driver) throws InterruptedException {

        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
        Thread.sleep(2000);
        WebElement NoRecordFound = w.until(ExpectedConditions.visibilityOf(NO_RECORDS_FOUND));

        if (NO_RECORDS_FOUND.isDisplayed()) {
            System.out.println("There is no records found on Download Page");
        }

        Reporter.log("click on the select currency filed", true);

        return NO_RECORDS_FOUND;
    }

    public void clickONOKButton(WebDriver driver) throws InterruptedException {
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));

        actionDriver.click(okButton);

        Thread.sleep(3000);
        Reporter.log("click on the OK button", true);

    }


}
