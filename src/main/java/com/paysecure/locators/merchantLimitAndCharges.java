package com.paysecure.locators;

public class merchantLimitAndCharges {

	public static final String merchants = "//span[text()='Merchant']";
	public static final String limitCharges = "//span[text()='Limits/Charges']";
	
	
	public static final String sm="//span[text()='Select Merchant']";
	public static final String searchMerchant="//input[@class='select2-search__field']";
	public static final String selectOption="//li[contains(@id,'select2-merchantCharges')]";
	public static final String selectCurrency="//span[text()='Select currency']";
	public static final String searchCurrency="//input[@role='searchbox']";
	public static final String selectCurrencyFromOption="//ul[@id='select2-currencySel-results']";
	public static final String selectPaymentMethod="//span[text()='Select payment method']";
	public static final String selectPaymentMethodFromOptions="//li[contains(@id,'select2-payMethodSel')]";
	public static final String get="//button[text()='Get']";
	
	//set merchant limit and charges ----------------------------
	
	public static final String hourly="//input[@id='cust_max_hourly_trans']";
	public static final String daily="/input[@id='cust_max_daily_trans']";
	public static final String weekly="//input[@id='cust_max_weekly_trans']";
	public static final String monthlu="//input[@id='cust_max_monthly_trans']";
	
	public static final String perDayMaxTxn="//input[@id='per_day_max_trans']";
	public static final String perDayMaxAmt="//input[@id='per_day_max_amount']";
	
	
	
	
	
	
}
