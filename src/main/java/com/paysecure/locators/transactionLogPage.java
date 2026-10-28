package com.paysecure.locators;

public class transactionLogPage {

    //Navigate up to Transaction Log Page
    public static final String analytics = "//span[text()='Analytics']";
    public static final String report = "(//span[text()='Report'])[2]";
    public static final String transactionLog = "//span[text()='Transaction Log']";
    public static final String transactionLog1 = "//h5[text()='Transaction Log ']"; // If you really need a duplicate

    // search transaction log through purchase ID
    public static final String searchFieldPurchaseId = "//input[@id='purchaseId']";
    public static final String purchaseId = "(//a[contains(@onclick,'getBank')])[1]";
    public static final String closeButton = "(//button[@class='btn-close'])[5]";


    //verify json
    public static final String json = "(//a[contains(@onclick,'showTText')])[1]";

    //search button
    public static final String searchButton = "//button[text()='Search']";

    // verify transaction details
    public static final String purchaseInfo = "//span[@id='purchaseInfo']";

























}
