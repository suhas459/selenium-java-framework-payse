package com.paysecure.reportPage;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.paysecure.actiondriver.ActionDriver;
import com.paysecure.locators.emailTransactionPage;





public class emailtransactionPage {

    // scrolling point of view
    private By analytics = By.xpath(emailTransactionPage.analytics);
    private By report = By.xpath(emailTransactionPage.report);
    private By transactions = By.xpath(emailTransactionPage.transactions);
    private By email = By.xpath(emailTransactionPage.email);

    // verify day frequency
    private By dayFrequency = By.xpath(emailTransactionPage.dayFrequency);
    private By totalDayFrequency = By.xpath(emailTransactionPage.totalDayFrequency);
    private By cancelDayfrequncy = By.xpath(emailTransactionPage.cancelDayfrequncy);


    // verify monthly frequency
    private By monthFrequency = By.xpath(emailTransactionPage.monthFrequency);
    private By totalMonthFrequency = By.xpath(emailTransactionPage.totalMonthFrequency);
    private By cancelMonthfrequncy = By.xpath(emailTransactionPage.cancelMonthfrequncy);


    // verify Week frequency
    private By weekFrequency = By.xpath(emailTransactionPage.weekFrequency);
    private By cancelweekfrequncy = By.xpath(emailTransactionPage.cancelWeekFrequency);


    // verify year frequency
    private By yearFrequency = By.xpath(emailTransactionPage.yearFrequency);
    private By cancelYearfrequncy = By.xpath(emailTransactionPage.cancelYearfrequncy);

    // verify customer frequency
	private By customersMerchant = By.xpath(emailTransactionPage.customersMerchant);
	private By cancelButton = By.xpath(emailTransactionPage.cancelButton);



	// verify customer card
    private By CustomersCards = By.xpath(emailTransactionPage.customersCards);

    //verify  Customer's Countries
    private By customersCountries = By.xpath(emailTransactionPage.customersCountries);


    //verify  Customer's IPS
    private By customersIps = By.xpath(emailTransactionPage.customersIps);


    //verify  Amount
    private By amount = By.xpath(emailTransactionPage.amount);


    //verify  user device
    private By userDevice = By.xpath(emailTransactionPage.userDevice);


    //Verify total
    private By total = By.xpath(emailTransactionPage.total);
    @FindBy(xpath = emailTransactionPage.total)
    private WebElement TOTAL;

    private By totalFrequency = By.xpath(emailTransactionPage.totalFrequency);
    @FindBy(xpath = emailTransactionPage.totalFrequency)
    private WebElement TOTAL_FREQ;

    private By canceEmaillButton = By.xpath(emailTransactionPage.canceEmaillButton);

    private By showing = By.xpath(emailTransactionPage.showing);
    private By showing_1 = By.xpath(emailTransactionPage.showing_1);


    //email summery page
    private By transactionId = By.xpath(emailTransactionPage.transactionId);
    private By purchaseInfo = By.xpath(emailTransactionPage.purchaseInfo);
    private By canButtonpurchaseInfo = By.xpath(emailTransactionPage.canButtonpurchaseInfo);


    //email summary action

    private By action = By.xpath(emailTransactionPage.action);
    private By tran_ID = By.xpath(emailTransactionPage.tran_ID);


    private By nextBtn = By.xpath(emailTransactionPage.nextBtn);
    @FindBy(xpath = emailTransactionPage.nextBtn)
    private WebElement NEXT_BTN;


    private ActionDriver actionDriver;

    // page factory constructor
    public emailtransactionPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.actionDriver = new ActionDriver(driver);
    }

//	public void navigateUptoTransaction(WebDriver driver) throws InterruptedException {
//
//		actionDriver.scrollToElement(analytics);
//		Reporter.log("User navigate upto Analytics", true);
//		actionDriver.click(report);
//		Reporter.log("User click on Report Module", true);
//		actionDriver.click(transactions);
//		Reporter.log("User Click on Transaction sub module", true);
//	}

    public void clickOnEmail() {

        actionDriver.click(email);
        Reporter.log("User Click on email field in a Transaction table", true);

    }

    public void verifydayFrequesncy(WebDriver driver) {

        String day = actionDriver.getText(dayFrequency);
        System.out.println("Total Month frequency :- " + day);

        Reporter.log(" day frequency :- " + day, true);

        actionDriver.click(dayFrequency);
        Reporter.log("User click on Day frequency", true);

        // String totalDay = actionDriver.getText(totalDayFrequency);
        List<WebElement> allSpans = driver.findElements(By.xpath("//div[@id='mdlinfo']/span"));
        int count = allSpans.size();
        String totalDay = String.valueOf(count);
        System.out.println("Total day frequency :- " + totalDay);

        Reporter.log("Total day frequency :- " + totalDay, true);

        Assert.assertEquals(day, totalDay);

        Reporter.log("Verify total days are perfectly matching", true);

        actionDriver.click(cancelDayfrequncy);
        Reporter.log("user click on cancel button on day frequency page", true);
    }

    public void verifyMonthFrequesncy(WebDriver driver) {

        String month = actionDriver.getText(monthFrequency);
        System.out.println("Total day frequency :- " + month);

        Reporter.log("Month frequency :- " + month, true);

        actionDriver.click(monthFrequency);
        Reporter.log("User click on Month frequency", true);

        // String totalDay = actionDriver.getText(totalDayFrequency);
        List<WebElement> allSpans = driver.findElements(By.xpath("//div[@id='mdlinfo']/span"));
        int count = allSpans.size();
        String totalMonth = String.valueOf(count);
        System.out.println("Total month frequency :- " + totalMonth);

        Reporter.log("Total month frequency :- " + totalMonth, true);

        Assert.assertEquals(month, totalMonth);

        Reporter.log("Verify total month are perfectly matching", true);

        actionDriver.click(cancelMonthfrequncy);
        Reporter.log("user click on cancel button on month frequency page", true);
    }

    public void verifyWeekFrequesncy(WebDriver driver) {

        String week = actionDriver.getText(weekFrequency);
        System.out.println("Total week frequency :- " + week);

        Reporter.log("week frequency :- " + week, true);

        actionDriver.click(weekFrequency);
        Reporter.log("User click on week frequency", true);

        // String totalDay = actionDriver.getText(totalDayFrequency);
        List<WebElement> allSpans = driver.findElements(By.xpath("//div[@id='mdlinfo']/span"));
        int count = allSpans.size();
        String totalweek = String.valueOf(count);
        System.out.println("Total week frequency :- " + totalweek);

        Reporter.log("Total week frequency :- " + totalweek, true);

        Assert.assertEquals(week, totalweek);

        Reporter.log("Verify total week are perfectly matching", true);

        actionDriver.click(cancelweekfrequncy);
        Reporter.log("user click on cancel button on week frequency page", true);
    }

    public void verifyYearFrequesncy(WebDriver driver) {

        String year = actionDriver.getText(yearFrequency);
        System.out.println("Total year frequency :- " + year);

        Reporter.log("year frequency :- " + year, true);

        actionDriver.click(yearFrequency);
        Reporter.log("User click on year frequency", true);

        // String totalDay = actionDriver.getText(totalDayFrequency);
        List<WebElement> allSpans = driver.findElements(By.xpath("//div[@id='mdlinfo']/span"));
        int count = allSpans.size();
        String totalyear = String.valueOf(count);
        System.out.println("Total year frequency :- " + totalyear);

        Reporter.log("Total year frequency :- " + totalyear, true);

        Assert.assertEquals(year, totalyear);

        Reporter.log("Verify total year are perfectly matching", true);

        actionDriver.click(cancelYearfrequncy);
        Reporter.log("user click on cancel button on year frequency page", true);
    }

    public void verifyCustomerMerchantFrequency(WebDriver driver) {

        String Customers_Merchant = actionDriver.getText(customersMerchant);
        System.out.println("Total Customers_Cards frequency :- " + Customers_Merchant);

        Reporter.log("Customers_Merchant :- " + Customers_Merchant, true);

        actionDriver.click(customersMerchant);
        Reporter.log("User click on Customers_Merchant frequency", true);

        // String totalDay = actionDriver.getText(totalDayFrequency);
        List<WebElement> allSpans = driver.findElements(By.xpath("//div[@id='mdlinfo']/span"));
        int count = allSpans.size();
        String Customers_merchant_Frequency = String.valueOf(count);
        System.out.println("Customers_Cards frequency :- " + Customers_merchant_Frequency);

        Reporter.log("Customers_merchant_Frequency frequency :- " + Customers_merchant_Frequency, true);

        Assert.assertEquals(Customers_Merchant, Customers_merchant_Frequency);

        Reporter.log("Verify Customers_merchant_Frequency are perfectly matching", true);

        actionDriver.click(cancelButton);
        Reporter.log("user click on cancel button on Customers_Merchant frequency page", true);
    }

    public void verifyCustomerCardFrequency(WebDriver driver) {

        String Customers_Cards = actionDriver.getText(CustomersCards);
        System.out.println("Total Customers_Cards frequency :- " + Customers_Cards);

        Reporter.log("Customers_Cards frequency :- " + Customers_Cards, true);

        actionDriver.click(CustomersCards);
        Reporter.log("User click on Customers_Cards frequency", true);

        // String totalDay = actionDriver.getText(totalDayFrequency);
        List<WebElement> allSpans = driver.findElements(By.xpath("//div[@id='mdlinfo']/span"));
        int count = allSpans.size();
        String Customers_Cards_Frequency = String.valueOf(count);
        System.out.println("Customers_Cards frequency :- " + Customers_Cards_Frequency);

        Reporter.log(" Customers_Cards_Frequency frequency :- " + Customers_Cards_Frequency, true);

        Assert.assertEquals(Customers_Cards, Customers_Cards_Frequency);

        Reporter.log("Verify Customers_Cards_Frequency are perfectly matching", true);

        actionDriver.click(cancelButton);
        Reporter.log("user click on cancel button on Customers Cards page", true);
    }

    public void verifyCustomerCountriesFrequency(WebDriver driver) {

        String Customers_Countries = actionDriver.getText(customersCountries);
        System.out.println("Total Customers_Countries frequency :- " + Customers_Countries);

        Reporter.log("Customers_Countries frequency :- " + Customers_Countries, true);

        actionDriver.click(customersCountries);
        Reporter.log("User click on Customers_Countries frequency", true);

        // String totalDay = actionDriver.getText(totalDayFrequency);
        List<WebElement> allSpans = driver.findElements(By.xpath("//div[@id='mdlinfo']/span"));
        int count = allSpans.size();
        String Customers_Countries_Frequency = String.valueOf(count);
        System.out.println("Customers_Countries_Frequency:- " + Customers_Countries_Frequency);

        Reporter.log("Customers_Countries_Frequency frequency :- " + Customers_Countries_Frequency, true);

        Assert.assertEquals(Customers_Countries, Customers_Countries_Frequency);

        Reporter.log("Verify Customers_Countries_Frequency are perfectly matching", true);

        actionDriver.click(cancelButton);
        Reporter.log("user click on cancel button on Customers countries page", true);
    }


    public void verifyCustomerIPSFrequency(WebDriver driver) {

        String Customers_IPS = actionDriver.getText(customersIps);
        System.out.println("Total Customers_Countries frequency :- " + Customers_IPS);

        Reporter.log("Customers_IPS frequency :- " + Customers_IPS, true);

        actionDriver.click(customersIps);
        Reporter.log("User click on Customers_IPS frequency", true);

        // String totalDay = actionDriver.getText(totalDayFrequency);
        List<WebElement> allSpans = driver.findElements(By.xpath("//div[@id='mdlinfo']/span"));
        int count = allSpans.size();
        String Customers_IPS_Frequency = String.valueOf(count);
        System.out.println("Customers_IPS_Frequency:- " + Customers_IPS_Frequency);

        Reporter.log("Customers_Countries_Frequency frequency :- " + Customers_IPS_Frequency, true);

        Assert.assertEquals(Customers_IPS, Customers_IPS_Frequency);

        Reporter.log("Verify Customers_IPS_Frequency are perfectly matching", true);

        actionDriver.click(cancelButton);
        Reporter.log("user click on cancel button on Customers IPS page", true);
    }

    public void verifyAmountFrequency(WebDriver driver) {

        String amount_Frequency = actionDriver.getText(amount);
        System.out.println("amount_Frequency :- " + amount_Frequency);

        Reporter.log("amount_Frequency :- " + amount_Frequency, true);

        actionDriver.click(amount);
        Reporter.log("User click on amount_Frequency", true);

        // String totalDay = actionDriver.getText(totalDayFrequency);
        List<WebElement> allSpans = driver.findElements(By.xpath("//div[@id='mdlinfo']/span"));
        int count = allSpans.size();
        String Amount_Frequency = String.valueOf(count);
        System.out.println("Amount_Frequency:- " + Amount_Frequency);

        Reporter.log("Customers_Countries_Frequency frequency :- " + Amount_Frequency, true);

        Assert.assertEquals(amount_Frequency, Amount_Frequency);

        Reporter.log("Verify Amount_Frequency are perfectly matching", true);

        actionDriver.click(cancelButton);
        Reporter.log("user click on cancel button on Amount_Frequency page", true);
    }

    public void verifyCustomerDeviceID(WebDriver driver) {

        String user_Device = actionDriver.getText(userDevice);
        System.out.println("CustomerDeviceID:- " + user_Device);

        Reporter.log("CustomerDeviceID " + user_Device, true);

        actionDriver.click(userDevice);
        Reporter.log("User click on CustomerDeviceID", true);

        // String totalDay = actionDriver.getText(totalDayFrequency);
        List<WebElement> allSpans = driver.findElements(By.xpath("//div[@id='mdlinfo']/span"));
        int count = allSpans.size();
        String Customer_Device_ID_Frequency = String.valueOf(count);
        System.out.println("user_Device_Frequency:- " + Customer_Device_ID_Frequency);

        Reporter.log("Customer_Device_ID_Frequency :- " + Customer_Device_ID_Frequency, true);

        Assert.assertEquals(user_Device, Customer_Device_ID_Frequency);

        Reporter.log("Verify user_Device_Frequency are perfectly matching", true);

        actionDriver.click(cancelButton);
        Reporter.log("user click on cancel button on user_Device_Frequency page", true);
    }

    public void verifyTotal(WebDriver driver) {

        String tota = actionDriver.getText(total);
        System.out.println("total:- " + tota);

        Reporter.log("total :- " + tota, true);

        actionDriver.click(total);
        Reporter.log("User click on Total", true);


        //String total_Frequency = actionDriver.getText(totalFrequency);
        actionDriver.scrollToElement(showing_1);

        String TOTAL_Freq =TOTAL_FREQ.getText();
        Assert.assertEquals(tota, TOTAL_Freq);

        Reporter.log("Verify TotalFrequency are perfectly matching", true);


        actionDriver.click(canceEmaillButton);
        Reporter.log("user click on cancel button on Total page", true);
    }


    public void clickOnTotal() {


        actionDriver.click(total);
        Reporter.log("User click on Total", true);


    }

    public void verifyTransactionIDOnEmailSummeryPage() {
        //get transaction ID
        String Transaction_Id = actionDriver.getText(transactionId);
        System.out.println("get transaction id :-" + Transaction_Id);
        Reporter.log("get transaction id :-" + Transaction_Id, true);


        if (actionDriver.isEnabled(transactionId)) {
            //click on transaction ID
            actionDriver.click(transactionId);
            Reporter.log("Click on transaction id", true);
            //get text from purchase info page - email summary
            String purchase_info = actionDriver.getText(purchaseInfo);

            System.out.println(purchase_info);

            Assert.assertEquals(Transaction_Id, purchase_info, "if Purchase ID doesn't match then our TC is should be failed");

            Reporter.log("verify  transaction id/ purchase ID is successfully matching", true);

            actionDriver.click(canButtonpurchaseInfo);
            Reporter.log("user click on cancel button in purchase Info page", true);
        } else {


            System.out.println("This transaction ID is not clickable");
        }


    }


    public void validatePurchaseIDWithActions() {

        //get transaction ID
        String Transaction_Id = actionDriver.getText(transactionId);
        System.out.println("get transaction id :-" + Transaction_Id);
        Reporter.log("get transaction id :-" + Transaction_Id, true);

        //click on transaction ID
        actionDriver.click(action);
        Reporter.log("Click on Action", true);


        //get text from tansaction ID

        String Tr_Id = actionDriver.getText(tran_ID);
        System.out.println("get transaction id :-" + Tr_Id);
        Reporter.log("get Tr_Id :-" + Tr_Id, true);

    }


    public void iterateAllTablePages(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        int totalRowCount = 0;

        while (true) {
            // Wait and fetch all rows on the current page
//            List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
//                    By.xpath("(//table[@class='table table-bordered'])[3]/tbody[2]/tr")));
//
//            int currentPageRowCount = rows.size();
//            totalRowCount += currentPageRowCount;
//
//            System.out.println("Rows on this page: " + currentPageRowCount);
//
//            // Process each row
//            for (WebElement row : rows) {
//                String rowText = row.getText();
//                System.out.println("Row Data: " + rowText);
//            }

            // Check if 'Next' is disabled
            WebElement nextButtonContainer = driver.findElement(By.xpath("(//li[contains(@class,'page-item next')])[2]"));
            String classAttr = nextButtonContainer.getAttribute("class");

            if (classAttr.contains("page-item next disabled")) {
                System.out.println("Reached last page.");
                break;
            }

            // Click the next button using JS
         //   WebElement nextBtn = nextButtonContainer.findElement(By.tagName("a"));
           // wait.until(ExpectedConditions.elementToBeClickable(NEXT_BTN)).click();
          // NEXT_BTN.click();
            // Wait for table to refresh (avoid stale elements)
        //    wait.until(ExpectedConditions.stalenessOf(rows.get(0)));
        }

        // Final output
        System.out.println("🚀 Total rows across all pages: " + totalRowCount);
    }


    public void clickOnSpecificEmail(WebDriver driver, String targetEmail) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean emailClicked = false;

        while (true) {
            // Wait and get all rows in the current page
            List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.xpath("(//th[text()='Transaction ID'])[1]/ancestor::table//td[6]")));

            for (WebElement row : rows) {

                actionDriver.scrollToElement(showing);

                List<WebElement> columns = row.findElements(By.xpath("(//th[text()='Transaction ID'])[1]/ancestor::table//td[6]"));

                for (WebElement cell : columns) {
                    String cellText = cell.getText().trim();

                    if (cellText.equalsIgnoreCase(targetEmail)) {
                        System.out.println("✅ Found email: " + cellText + " - Clicking on first occurrence.");

                        try {
                            // Try clicking the element (plain cell or anchor)
                            if (cell.findElements(By.tagName("a")).size() > 0) {
                                cell.findElement(By.tagName("a")).click(); // If it's a link
                            } else {
                                cell.click(); // Otherwise, click the cell itself
                            }
                        } catch (Exception e) {
                            System.out.println("⚠️ Error clicking on email: " + e.getMessage());
                        }

                        emailClicked = true;
                        break; // Exit inner loop
                    }
                }

                if (emailClicked) break; // Exit row loop
            }

            if (emailClicked) break; // Exit page loop

            // Go to next page if email not found yet
            WebElement nextButtonContainer = driver.findElement(By.xpath("//li[@class='page-item next']"));
            String classAttr = nextButtonContainer.getAttribute("class");

            if (classAttr.contains("page-item next disabled")) {
                System.out.println("❌ Email not found in any page.");
                break;
            }

            // Click on Next button
            WebElement nextBtn = nextButtonContainer.findElement(By.tagName("a"));

            nextBtn.click();

            // Wait for table refresh
            //     wait.until(ExpectedConditions.stalenessOf(rows.get(0)));
        }

        Assert.assertTrue(emailClicked, "❌ Email '" + targetEmail + "' not found in any page.");
    }

}
