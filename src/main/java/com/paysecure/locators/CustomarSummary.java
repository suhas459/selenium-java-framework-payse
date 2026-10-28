package com.paysecure.locators;

public class CustomarSummary {
    //navigate upto Customer summary page
	public static final String customerSummary ="//span[text()='Customer Summary']";
	public static final String sideBar ="//div[@class='sideBar-close']/div";
	
	//Group By dropdown
	public static final String groupByDropodwn ="//select[@id='group_by']";
	
	//submit button
	public static final String submitButton ="//button[text()='Submit']";
	
	//select merchant
	public static final String selectmerchant ="//span[@id='select2-mid-container']";
	public static final String searchMerchant ="//input[@class='select2-search__field']";
	//table 
	public static final String customersEmail ="(//th[@class='text-center'])[2]";
	
	public static final String total ="(//th[text()='Total']/ancestor::table//td[2])[1]";
	public static final String dayFrq ="(//th[text()='Total']/ancestor::table//td[3])[1]";
	public static final String monthFrq ="(//th[text()='Total']/ancestor::table//td[4])[1]";
	public static final String weekFrq ="(//th[text()='Total']/ancestor::table//td[5])[1]";
	public static final String customersMerchantFrq ="(//th[text()='Total']/ancestor::table//td[7])[1]";
	public static final String customersCardsfrq="(//th[text()='Total']/ancestor::table//td[8])[1]";
	public static final String customersCounriesFrq="(//th[text()='Total']/ancestor::table//td[9])[1]";
	public static final String customersIpsFrq="(//th[text()='Total']/ancestor::table//td[10])[1]";
	public static final String customersAmountFrq="(//th[text()='Total']/ancestor::table//td[11])[1]";
	
	
	
	
	
	
	
	
}
