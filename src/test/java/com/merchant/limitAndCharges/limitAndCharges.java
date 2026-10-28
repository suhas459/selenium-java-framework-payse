package com.merchant.limitAndCharges;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.paysecure.base.baseClass;
import com.paysecure.loginPage.loginPage;
import com.paysecure.merchant.limitAndChargesPage;
import com.paysecure.reportPage.apiLogspage;
import com.paysecure.reportPage.banktransactionTime;
import com.paysecure.reportPage.transactionPage;
import com.paysecure.utilities.DataProviders;

import io.qameta.allure.Step;

public class limitAndCharges extends baseClass {

	loginPage lp;
	limitAndChargesPage lcp;

	@BeforeMethod
	public void beforeMethod() throws IOException, Exception {

		lp = new loginPage(getDriver());
		lp.login();

		lcp = new limitAndChargesPage(getDriver());

	}

	@Test(priority = 0, enabled = true)

	public void verifyAddbank() throws InterruptedException {
		lcp.navigateUptoLimitAndCharges();
		lcp.selectMerchantFromMerchantLimitAndCharges("suhasM");
		lcp.selectCurrencyFromMerchantLimitAndCharges("USD");
		lcp.selectPaymentmethodFromMerchantLimitAndCharges("MASTER");
		lcp.getDetailsForLimitAndCharges();
	}

}
