package com.paysecure.locators;

public class AnalyticaLReporting {
     //navigate up to the AnalyticalReporting
	 public static final String analytics = "//span[text()='Analytics']";
	 public static final String analyticalReporting = "//li[@data-name='analytical reporting']";
	
	//submit 
	 public static final String submit ="//button[text()='Submit']";
	 public static final String ok ="//button[@class='btn btn-default' or text()='ok']";
	
	//select currency
	 public static final String selectCurrency ="//select[@id='currency']";
	
	//Amount from and to 
	 public static final String amountFrom ="//input[@id='fromamt']";
	 public static final String amountTo="//input[@id='toamt']";
	
	//sort by using select class
	 public static final String sortBy="//select[@id='sortby']";
	 public static final String sortOrder="//select[@id='sortorder']";
	
	//select group by 
	 public static final String GroupBy="(//span[@class='multiselect-selected-text'])[1]";
	 public static final String searchGroupBy="(//input[@class='form-control multiselect-search'])[1]";
	 public static final String gb="//label[text()='Group By']";
	 public static final String merchantnameFromTable="//table[@class='leftTable table table-bordered']//th[text()='merchantName']";
	
	
	//gettext from select merchant dropdown
	 
	 public static final String getMerchant="(//button[@data-toggle='dropdown'])[2]";
	 public static final String getMerchantFromTable="//a[contains(@onclick,'showDetails')]";
	 
	 //table validations
	 public static final String allAttempt="(//td[@class='wsnowrap'])[1]";
	 public static final String all_Attempt="//th[text()='all_Attempt']";
	 public static final String noRecord="//div[@id='norecord']";
	 
	 //gettotalAMount from analytical Report --according to select merchant 
	 public static final String approvedAmount="(//td[@class='wsnowrap'])[2]";
	 public static final String approvedAttempt="(//td[@class='wsnowrap'])[6]";
	 public static final String successrate="(//td[@class='wsnowrap'])[7]";
	 
	 //get bank text from select bank textfield
	 public static final String getBankName="//span[@id='select2-bankname-container']";
	 public static final String txnId="//a[contains(@onclick,'getBankTrans')]";
	 public static final String getBankNameFromTxnDetails="(//td[@class='propValue'])[9]";
	 
	 public static final String getCurrencyFromSelected="//span[@id='select2-currency-container']";
	 public static final String getCurrencyFromTXN="(//td[@class='propValue'])[8]";
	 
	 public static final String filter="//h1[text()='Filter']";
	 
	 public static final String allMerchantName="//table[@class='leftTable table table-bordered']/tbody/tr/td/div/a[1]";
	 public static final String nextButton="//a[contains(text(),'Next')]";
	 
	 public static final String selectColumns="(//span[@class='multiselect-selected-text'])[3]";
	 public static final String totalHeaders="//table[@class='rightTable table table-bordered']//thead//th[@class='text-center colheader']";
	 
	 public static final String selectColumnAllAttempt="//input[@value='all_Attempt']";
	 public static final String searchColumnName="(//input[@class='form-control multiselect-search'])[3]";
	 
	 
	 
	 
	 
	 
}
