package com.paysecure.locators;

public class downloadPage {

    // navigate upto Bank Transaction Time Report
    public static final String analytics = "//span[text()='Analytics']";
    public static final String report = "(//span[text()='Report'])[2]";
    public static final String download = "//span[text()='Download']";
    public static final String DOWNLOAD = "//h1[text()='Download']";


    //currency
    public static final String selectCurrency = "//span[@id='select2-merCurr-container']";
    public static final String searchCurrencytextfield = "//input[@class='select2-search__field']";
    public static final String listOfAllCurrencies = "//ul[@id='select2-merCurr-results']/li";


    // download -- select class -- purchase or Bank Transactions
    public static final String downloadSelect = "//select[@id='downloadType']";
    public static final String noRecordsFound = "//h2[text()='No Records Found']";
    public static final String okButton = "//button[text()='OK']";







}
