package com.paysecure.locators;

public class emailTransactionPage {


    //navigate up to email transaction page
    public static final String analytics = "//span[text()='Analytics']";
    public static final String report = "(//span[text()='Report'])[2]";
    public static final String transactions = "//span[text()='Transactions']";
    public static final String email = "((//th[text()='Transaction ID'])[1]/ancestor::table//td[6])[1]";

// verify day frequency

    public static final String dayFrequency = "//a[contains(@onclick,'dayFrequenc')]";
    public static final String totalDayFrequency = "//div[@id='mdlinfo']/span";
    public static final String cancelDayfrequncy = "//h5[text()='Day Frequency']/following-sibling::button";

    // verify monthly frequency
    public static final String monthFrequency = "//a[contains(@onclick,'monthFrequen')]";
    public static final String totalMonthFrequency = "//div[@id='mdlinfo']/span";
    public static final String cancelMonthfrequncy = "//h5[text()='Month Frequency']/following-sibling::button";

    // verify Week frequency
    public static final String weekFrequency = "//a[contains(@onclick,'weakFreaquenc')]";
    public static final String cancelWeekFrequency = "//h5[text()='Week Frequency']/following-sibling::button";

    // verify year frequency
    public static final String yearFrequency = "//a[contains(@onclick,'yearFrequenc')]";
    public static final String cancelYearfrequncy = "//h5[text()='Year Frequency']/following-sibling::button";

    // verify customer frequency
    public static final String customersMerchant = "//a[contains(@onclick,'merchantAssociated')]";
    public static final String cancelButton = "//h5[@id='mdltitle']/following-sibling::button";

    // verify customer card
    public static final String customersCards = "//a[contains(@onclick,'cardAssociat')]";

    //verify  Customer's Countries
    public static final String customersCountries = "//a[contains(@onclick,'cardAssociat')]";

    //verify  Customer's IPS
    public static final String customersIps = "//a[contains(@onclick,'ipCountry')]";

    //verify Amount
    public static final String amount = "//a[contains(@onclick,'denominatio')]";

    //verify  user device
    public static final String userDevice = "//a[contains(@onclick,'userDevice')]";

    //Verify total
    public static final String total = "//a[contains(@onclick,'emailHistory')]";
    public static final String totalFrequency = "//label[@id='pagtext1']//following-sibling::span[3]";
    public static final String canceEmaillButton = "//h5[text()='Email Summary']/following-sibling::button";
    public static final String showing = "//label[text()='Showing ']";
    public static final String showing_1 = "(//label[text()='Showing '])[2]";

    //email summary page
    public static final String transactionId = "((//th[text()='Transaction ID'])[2]/ancestor::table//td[3])[1]";
    public static final String purchaseInfo = "//h5[@id='purchaseInfo']";
    public static final String canButtonpurchaseInfo = "//h5[@id='purchaseInfo']/following-sibling::button";

    //email summary action
    public static final String action = "((//th[text()='Transaction ID'])[2]/ancestor::table//td[1])[2]";
    public static final String tran_ID = "//span[@id='lAhistory']";
    public static final String nextBtn = "(//a[text()='Next'])[2]";


}
