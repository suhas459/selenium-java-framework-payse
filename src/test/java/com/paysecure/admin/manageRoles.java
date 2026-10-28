package com.paysecure.admin;

import java.util.Map;
import java.util.Properties;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.paysecure.adminPage.managerolespage;
import com.paysecure.base.baseClass;
import com.paysecure.loginPage.loginPage;
import com.paysecure.reportPage.transactionPage;
import com.paysecure.utilities.DataProviders;



public class manageRoles extends baseClass {

	private loginPage lp;
	managerolespage mr;
	transactionPage tp;

	@BeforeMethod
	public void setupPages() throws InterruptedException {
		lp = new loginPage(getDriver());
		lp.login();
		mr = new managerolespage(getDriver());
		mr.navigateToManageRoles();
		tp= new transactionPage(getDriver());
	}
	

	@Test(priority = 0)
	public void verifySearchFunctionality() {
		mr.searchByUsername_Merchant("gouri_sharma");
		mr.verifySearchRoleSameorNot(getDriver(), "gouri_sharma");

	}

	@Test(priority = 1)
	public void verifySearchFunctionalityIfUserEnterWrongMerchant_Username() {
		mr.searchByUsername_Merchant("(*&^%$#$%^&*hgvhf)(*&^%^&*");
		mr.verifyIfUserEnterWrongUsername();

	}

	@Test(priority = 2)
	public void verifyRefreshPage_SearchFunctionalityIfUserEnterWrongMerchant_Username() {
		mr.searchByUsername_Merchant("gouri_sharma");
		mr.refreshSearchPage(getDriver());

	}

	@Test(dataProvider = "usernameTestData", dataProviderClass = DataProviders.class,priority = 3)
	public void validateUsernameErrorMessages(String inputText, String expectedError, String errorXpath) {
		mr.verifyAllErrorsInAddRole();
		mr.validateUsernameError(getDriver(), inputText, expectedError, errorXpath);
	}

	@Test(dataProvider = "passwordTestData", dataProviderClass = DataProviders.class,priority = 4)
	public void validatePassswordErrorMessages(String inputText, String expectedError, String errorXpath) {
		mr.verifyAllErrorsInAddRole(); // Optional: ensure form is reset
		mr.validatePasswordError(getDriver(), inputText, expectedError, errorXpath); // ✅ Correct now
	}

	@Test(priority = 5)
	public void validateGenpassFunctionality() {

		mr.clickOnAddRole();
		mr.validate_genPass(getDriver());

	}

	@Test(dataProvider = "emailIDTestData", dataProviderClass = DataProviders.class,priority = 6)
	public void validateEmailFieldErrors(String emailInput, String expectedError, String errorXpath) {

		mr.verifyAllErrorsInAddRole();

		mr.validateEmailError(getDriver(), emailInput, expectedError, errorXpath);
	}
	
	@Test(priority = 7)
	public void select_Role() {
		
		mr.clickOnAddRole();
		mr.selectRole("WHITELABEL");
		/*** select or pick up any one from it 
		 MERCHANT	P2PMERCHANT  AGENT  WHITELABEL
		P2PAGENT
		REPORTADMIN
		ADMIN
		MIDADMIN
		ACCOUNTADMIN
		FULLADMIN
		WHITELABELMERCHANT*/

	}
	
	
	@Test(priority = 8)
	public void create_Role() throws InterruptedException {
		mr.clickOnAddRole();
		mr.createRole();
		Thread.sleep(20000);
        mr.searchRoleAfterCreating(getDriver());;
		
	}
	
	
	@Test(priority = 9, dataProvider = "merchantName", dataProviderClass = DataProviders.class)
	public void verifyLoginAsUserUsingSuperAdmin(String MerchantName) throws InterruptedException {
	    Reporter.log("Merchant Name from DataProvider: " + MerchantName, true);
	    mr.searchByUsername_Merchant(MerchantName);
	    mr.clickOnLoginAsUserButton();
	    mr.navigateUptoTransactionModule();

	    tp.filterTransactionThroughSelectStatus("Error");
	    tp.selectDateRange("Last 30 Days");

	    mr.clickOnSearchButton();
	    tp.checkTransactionStatus();
	    mr.allErrors(MerchantName);
	}


	
	
	
	
	
	
	
	

}
