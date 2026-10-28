package com.paysecure.locators;



public class apiLogPage{

	// navigate up to API LOG

	public static final String analytics = "//span[text()='Analytics']";
	public static final String report = "(//span[text()='Report'])[2]";
	public static final String apiLog = "//span[text()='Api Log']";
	public static final String apiReport = "//h1[text()='Api Report']";

    //select merchant
	public static final String selectmerchant = "//span[text()='Select Merchant']";
	public static final String searchmerchant = "//input[@class='select2-search__field']";
	public static final String selectSearchmerchantCheckbox = "(//input[@type='checkbox'])[2]";

	// select API
	public static final String selectAPI = "//select[@id='sapi']";

	// search button
	public static final String searchButton = "//button[text()='Search']";

    //download button
	public static final String downloadButton = "//button[@onclick='downloadReport()']";
	public static final String alertDownload = "//div[text()='No records to download.']";

    //download API Report
	public static final String noRecordFound = "//td[text()='No Records Found']";
	public static final String OK = "//button[text()='ok']";

	// check status
	public static final String notRecordFount = "//td[text()='No Records Found']";
	public static final String status = "(//a[contains(@class,'colorpid lstStatusBtn')])[1]";

}
