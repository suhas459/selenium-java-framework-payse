package com.paysecure.locators;

public class errorLogPage {

    //navigate up to API LOG
    public static final String analytics = "//span[text()='Analytics']";
    public static final String report = "(//span[text()='Report'])[2]";
    public static final String errorLog = "//span[text()='Error Log']";
    public static final String ERRORLOG = "//h1[text()='Error Log']";

    // filter through select merchant
    public static final String selectmerchant = "//span[text()='Select Merchant']";
    public static final String searchmerchant = "//input[@class='select2-search__field']";

    //search through - Merchant Ref Id
    public static final String merchantRefId = "//input[@id='merRefId']";

    //search through - Purchase Id
    public static final String purchaseId = "//input[@id='purchaseId']";

    //search button
    public static final String search = "//button[text()='Search']";


}
