package com.paysecure.locators;

public class cardSummaryPage {




    // navigate upto Bank Transaction Time Report
    public static final String analytics = "//span[text()='Analytics']";
    public static final String report = "(//span[text()='Report'])[2]";
    public static final String showing = "//label[@id='dailypagtext']";

    // card summary page
    public static final String TID = "//h5[@id='purchaseInfo']";
    public static final String lastAction_ID = "//span[@id='lAhistory']";


    // cancel button - transaction --card summary page
    public static final String cancelButton = "//h5[@id='purchaseInfo']/following-sibling::button";


    //purchaseID
    public static final String pid = "//span[@id='phistory']";
    public static final String phid = "//tbody[@id='analyticTransStats1']//button[contains(@onclick,'showStatusHistory')]";



}
