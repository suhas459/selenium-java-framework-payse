package com.paysecure.locators;

public class bankTransactionTimePage {

    // navigate upto Bank Transaction Time Report
    public static final String analytics = "//span[text()='Analytics']";
    public static final String report = "(//span[text()='Report'])[2]";
    public static final String bank_Transaction_Time = "//span[contains(text(),'Transaction Time')]";
    public static final String bank_Transaction_Time_Report = "//h1[text()='Bank Transaction Time Report']";


    // todays date verify
    public static final String todaysDate = "//span[@class='settleFont']";

    // verify dates in select bank
    public static final String disableDate = "(//td[text()='2'])[2]";
  //  public static final String todaysDate = "//span[@class='settleFont']";
    public static final String enableDate = "(//td[@data-title='r0c2'])[1]";
    public static final String cancel = "//button[text()='Cancel']";
    public static final String apply = "//button[text()='Apply']";
    public static final String calendar = "//img[@class='left_calander']";

// select bank
public static final String selectbank = "//select[@id='bnk']";

//	// Transaction Time more than
    public static final String enterTime = "//input[@id='moreThanSeconds']";

    // search button
    public static final String searchButton = "//button[text()='Search']";

// verifyTransactionID
public static final String transactionID = "((//th[text()='Transaction ID'])[1]/ancestor::table//td[3])[1]";
    public static final String t_ID = "//h5[@id='purchaseInfo']";
    public static final String cancel_ID = "//h5[@id='purchaseInfo']/following-sibling::button";
    public static final String next_btn = "//a[text()='Next']";

// verify headers
public static final String headers = "//table[@id='searchTable']/descendant::th";




}
