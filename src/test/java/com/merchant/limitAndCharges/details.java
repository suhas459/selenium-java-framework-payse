package com.merchant.limitAndCharges;

import org.testng.annotations.Test;

import com.paysecure.base.baseClass;
import com.paysecure.loginPage.loginPage;
import com.paysecure.merchant.detailsPage;
import com.paysecure.merchant.limitAndChargesPage;

import java.util.List;

import org.testng.annotations.BeforeMethod;

public class details extends baseClass{
	
	loginPage lp;
	detailsPage dp;
	limitAndChargesPage lcp;
	
	 @BeforeMethod
	  public void beforeMethod() throws InterruptedException {
			lp = new loginPage(getDriver());
			lp.login();
		dp=new detailsPage(getDriver());
		lcp = new limitAndChargesPage(getDriver());
		
	  }
  @Test
  public void f() throws InterruptedException {
	  dp.navigateUptoDetails();
      dp.selectMerchantFromDetailsPage("Arunsinghal");
      List<String> selectedPaymentMethods = dp.getAllPaymentMethodNames();
      System.out.println(selectedPaymentMethods);
      
      List<String> check = dp.collectCheckedCurrencies(getDriver());
      System.out.println(check);
      
      dp.clickOnLimitAndCharges();
      
      lcp.selectMerchantFromMerchantLimitAndCharges("Arunsinghal");
      dp.clickOnSelectCurrency();
      dp.getAllCurrencies();
      dp.compareCurrencies();
      
      dp.clickOnSelectPaymentMethod();
      dp.getAllSelectedPaymentMethods();
      dp.comparePaymentMethod();
      
  }
  
  @Test
  public void g() throws InterruptedException {
	  dp.navigateUptoDetails();
      dp.selectMerchantFromDetailsPage("01Merchant");
      dp.getAllCurrencies();
  }
 

}
