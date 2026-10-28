package com.paysecure.banks;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.paysecure.adminPage.managerolespage;
import com.paysecure.bankPage.allbankspage;
import com.paysecure.bankPage.errorCodeMapping_allBanks;
import com.paysecure.bankPage.jsonTransformer_allBanks;
import com.paysecure.bankPage.setting_allBanks;
import com.paysecure.bankPage.viewBankDetails_allBanks;
import com.paysecure.bankPage.viewMids_allBanks;
import com.paysecure.base.baseClass;
import com.paysecure.loginPage.loginPage;
import com.paysecure.reportPage.transactionPage;
import com.paysecure.utilities.testData_CreateRoll;

import io.qameta.allure.Step;





public class allbanks extends baseClass {

	private loginPage lp;
	managerolespage mr;
	transactionPage ts;
	allbankspage banks;
	viewMids_allBanks vmd;
	viewBankDetails_allBanks vbd;
	setting_allBanks setting;
	jsonTransformer_allBanks jt;
	errorCodeMapping_allBanks ecm;

	@BeforeMethod
	public void setupPages() throws IOException, InterruptedException {
		lp = new loginPage(getDriver());
		lp.login();

		banks = new allbankspage(getDriver());

		ts = new transactionPage(getDriver());
		mr = new managerolespage(getDriver());
		banks.navigateUptoAllBanks();
		vmd = new viewMids_allBanks(getDriver());
		vbd = new viewBankDetails_allBanks(getDriver());
		setting = new setting_allBanks(getDriver());
		jt = new jsonTransformer_allBanks(getDriver());
		ecm = new errorCodeMapping_allBanks(getDriver());
	}

	@Test(priority = 0, enabled = true)
	@Step("Test cases 001")
	public void verifyAddbank() {
		banks.VerifyAddBank();

	}

	@Test(priority = 1)
	public void clearTheSearchFieldAndCheckIt() throws InterruptedException {
		banks.searchBank("SA3434434");
		banks.checkBankStatusAfterSearchingBank();
		banks.clearTheSearchFieldAndCheck();
		banks.checkBankStatusAfterSearchingBank();
	}

	@Test(priority = 2)
	public void afterSearchingRefreshThePage() {
		banks.searchBank("CA");
		banks.checkBankStatusAfterSearchingBank();
		mr.refreshSearchPage(getDriver());
		banks.checkBankStatusAfterSearchingBank();
	}

	@Test(priority = 3)
	public void validateShowAllButtonIsAlreadySelected() throws InterruptedException {
		banks.verifyTableHeaderInAllBanks();
		banks.showAllBanks();

	}

	@Test(priority = 4)
	public void checkActiveStatusActiveAllBanks() throws InterruptedException {
		banks.verifyTableHeaderInAllBanks();
		banks.verifyActiveStatusForActivePage();
	}

	@Test(priority = 5)
	public void checkInactiveStatusInactiveInAllBanks() throws InterruptedException {
		banks.verifyTableHeaderInAllBanks();
		banks.verifyInActiveStatusForAllInActivePage();
	}

	@Test(priority = 6)
	public void verifyTableHeaderInAllbanks() {

		banks.verifyTableHeaderInAllBanks();
	}

	@Test(priority = 7)
	public void validateForActiveAndInactiveBank() {
		banks.showAllBanks();
		banks.checkForActiveButton();
		banks.checkForInactiveButton();
		banks.totalbanksInAllBanks();

	}

	@Test(enabled = true, priority = 8)
	public void createNewMID() throws InterruptedException {
		banks.searchBank("payhost");
		banks.view_Bank_Details();
		vmd.clickOnAddMid();
		vmd.addMidToBank();
		vmd.allowedCurrencyForcreateMID("USD");
		vmd.allowedCardsForCreateMID();

		vmd.submitMID();
		banks.verifyMidNameInSecondTable();

	}

	// if User click on back button from add mid page then user is on that
	// perticular bank details page --> BUG
	@Test(priority = 9, enabled = false)
	public void viewBankNameOnAddMidsPage() throws InterruptedException {
		banks.checkbankNameOnAddMidPage();
		banks.BackButtonViewMidPage();
		banks.checkbanksNameEvenAfterClickOnBackButtonOnViewMidsPage();

	}
	
	@Test(priority = 10)
	public void verifyBlockUnblockMid()  throws InterruptedException {
		banks.searchBank("doremon");
		banks.view_Bank_Details();
		banks.blockMid();
	}

	@Test(priority = 11)
	public void userUpdateMid() throws InterruptedException {
		banks.searchBank("doremon");
		banks.view_Bank_Details();
		banks.updatePageOfViewMidPage();
		banks.verifyMidNameIsSameOnUpdatePage();
		banks.selectCountry();
		banks.updateMid();
		banks.deleteMid();
		banks.confirmDeleteMid();

	}

	@Test(priority = 12, enabled = true)
	public void verifyMidProductList() throws InterruptedException {

		banks.searchBank("doremon");
		banks.view_Bank_Details();
		vmd.viewDetails();
		vmd.verifyThatBankNameOnAddMidPage();
		vmd.uploadCsvFile();
		vmd.handleFileUploadPopUp();
		vmd.validateDownloadSampleCSVFileLink();
		vmd.captureAllErrorsWhileAddingProduct();
		vmd.verifyProductListHeader();
		vmd.verifyProductAddedPopUp();
		vmd.deleteProductNameFromProductList();
//			vmd.deleteProductSuccessfullyMessagePopUp();
	}

	@Test(priority = 13)
	public void verifyViewBankDetailsPage() throws InterruptedException {
		banks.searchBank("doremon");
		vbd.viewBankDetails();
		vbd.validateBankNameOnBankDetailsPage();
		vbd.updateState();
		vbd.setbackForBackFunctionality();

		vbd.validateIfUserClickOnBackButtonThenUserIsOnTheBanksPage();
	}

	@Test(priority = 14)
	public void verifyConfigureApi() throws InterruptedException {

		banks.searchBank("doremon");
		setting.verifyUserIsOnTheConfigureApiPage();
		setting.verifyConfigureApiHeader();
		//
		setting.validateSamePaymentProcessorOccurOnAddApiPage();
		setting.verifyPopUpMessage();

		setting.checkDropdownValuesAreAlreadySelectedUrlType();
		setting.urlDropdown();
		setting.checkDropdownValuesAreAlreadySelectedRequestUrl();
		setting.validateRequestTypeDropdown();

		setting.validateErrorInUrl();

		setting.userEnterUrlOrBaseUrl();
		setting.userEnterUrlOrBaseUrl();
		setting.validateForDuplicateEntry();
		setting.backButtonFromMerchantMaster();
		Thread.sleep(2000);
		setting.clickOnviewDetails();
		setting.verifyAPINameAndPaymentProcessorOnUpdateActionPage();
		setting.backButtonFromMerchantMaster();
		setting.deleteActionOnMerchantMaster();
		setting.noRecordsDisplays();

	}

	@Test(priority = 15)
	public void updateConfigureApi() throws InterruptedException {
		banks.searchBank("doremon");
		setting.verifyUserIsOnTheConfigureApiPage();
		setting.verifyConfigureApiHeader();
		setting.validateSamePaymentProcessorOccurOnAddApiPage();
		setting.userEnterUrlOrBaseUrl();
		setting.backButtonFromMerchantMaster();
		setting.getUrlTypename();
		setting.getAPINameFromConfigureAPI();
		setting.clickviewDetails();
		setting.updateConfigureAPI();
		setting.validateIfUserHitBackOrUpdateButtonThenUserIsOnTheConfigureAPIPage();

	}

	@Test(priority = 16)
	public void verifyJsonTransformer() throws InterruptedException {

		banks.searchBank("doremon");
		jt.validateJsonTransformerIsClickable();
		jt.verifybankNameAndPaymentBankJsonData();
		jt.validateHeadersInPaymentBankJsonData();
		jt.validateUserisOnJsonTransformerPage();
		jt.getAllErrorsFromJsonTrnsformer();
		jt.userEnterValidJsonFormat();
	}

	@Test(priority = 17)
	public void validateActionInPaymentBankJsonData() {
		banks.searchBank("doremon");
		jt.validateJsonTransformerIsClickable();
		jt.getPayMentProcesor();
		jt.getFlowType();
		jt.clickAction();
		jt.verifyAction();
		jt.clickUpdateButton();
		jt.clickAction();
		jt.clickBackButton();

	}

	@Test(priority = 18)
	public void verifyErrorCodemapping() {
		banks.searchBank("doremon");
		ecm.getBankName();
		ecm.validateErrorCodeMappingIsDisplaysAndClickable();
		ecm.verifyBankName();
		ecm.verifytableHeadersInErrorCodeMapping();
		ecm.verifyIfUserClickOnBackButtonThenUserIsOnTheBanksPage();
		ecm.getPaymentProcessorName();
		ecm.addbankMapping();
		ecm.getBankOnECM();
		ecm.verifybankNameOnErrorCodeBanking();
		ecm.verifyAllElementdInRequestTypeDropdown();
		ecm.verifyAllElementdInResponseTypeDropdown();
		ecm.selectValueFromRequestTypeDropdown("MIR");
		ecm.selectValueFromResponseTypeDropdown("cvv_error");
		ecm.validateErrorInResponseCode();
		ecm.UserEnterResponseCode();
		ecm.geTCode();
		ecm.getRequestType();
		ecm.getResponseTime();
		ecm.clickOnAction();
		ecm.getFirstSelectedOptionFromRequestTypeDropdown();

	}

	@Test(invocationCount = 2, priority = 19)
	public void verifyActionsInErrorMapping() {
		banks.searchBank("a55");
		ecm.validateErrorCodeMappingIsDisplaysAndClickable();
		ecm.verifyCoderequestRsponceOnUpdatePage();
	}

	@Test(priority = 20)
	public void verifyDeleteActionsOnErrorMapping() {
		banks.searchBank("a55");
		ecm.validateErrorCodeMappingIsDisplaysAndClickable();
		ecm.verifyDeleteActionOnErrorCodeMapping();
	}

}
