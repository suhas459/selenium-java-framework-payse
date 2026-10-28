package com.paysecure.locators;

public class allBanks {
	// navigate upto bank
	    public static final String banks = "//span[text()='All Banks']";
	    public static final String BANK = "//span[text()='Banks']";

	    public static final String allBank = "//span[text()='All Banks']";//span[text()='All Banks']
	    public static final String bank_s = "//h1[text()='Banks']";
	    public static final String bankQuantity = "//span[@id='llb3']";
	
	

	    // Select MID
	    public static final String mid = "(//button[@class='btn btn-primary btn-sm ng-scope'])[1]";
	    public static final String searchBank = "//input[@placeholder='Search bank name']";

	    // Select bank
	    public static final String selectbankArrow = "(//span[@class='select2-selection__arrow'])[4]";
	    public static final String selectBank = "//span[text()='Select Bank']";

	    // Search bank name - Bank
	    public static final String searchBankName = "//input[@placeholder='Search bank name']";
	    public static final String searchButton = "//button[@id='bank-search']";
	
	 // search Bank - transaction
	    public static final String searchBankName_Transaction = "//input[@class='select2-search__field']";
	    public static final String selectFirstMatch = "(//ul[@id='select2-bnk-results']/li)[1]";
	    public static final String getOptionsMID = "//select[@id='midn']/option";
	    public static final String selectMID = "//select[@id='midn']";
	
	    // View MID
	    public static final String viewMID = "//button[@class='btn btn-primary btn-sm ng-scope']";
	    public static final String getAllMids = "//div[@class='bnk-sts']";
	    public static final String paymentProcessor = "(//h3[@class='text-primary d-inline'])[2]";
	    public static final String backButton = "//span[text()='Back']";

	    // Bank names
	    public static final String bankNames = "//select[@id='bnk']";
	
		// create MID
	    public static final String createMID = "//span[text()='Add MID']";
	    public static final String midName = "//input[@id='mid']";
	    public static final String allotedMID = "//input[@id='mid_desc']";
	    public static final String authKey = "//input[@id='mid_auth_key']";
	
	
	 // allowed currency
	    public static final String selectCurrency = "(//span[text()='ALL'])[1]";
	    public static final String searchCurrency = "(//input[@class='form-control multiselect-search'])[1]";
	    public static final String selectAllCurrency = "(//label[normalize-space()='Select all']/input[1])[1]";
	
	    // Allowed Cards
	    public static final String allowedCards = "(//button[@title='ALL'])[1]";
	    public static final String selectAllCards = "(//span[text()='ALL'])[2]";
	    public static final String submit = "//span[text()='Submit']";

	    // Auth Key
	    public static final String authKeyText = "//label[text()='Auth Key']";
	
	    // Add bank
	    public static final String addbank = "//a[@class='btn btn-success mb-4']/i";
	    public static final String bankDetails = "//h1[text()='Bank Details']";

	    // Search
	    public static final String noRecordsAreFound = "//td[text()='No Records Found']";
	    public static final String showingEntries = "//span[@id='llb3']";
	
	    // Show all button
	    public static final String showAll = "//span[text()='Show all ']";
	    public static final String activeBank = "//span[text()='Active ']";
	    public static final String inactiveBank = "//span[text()='Inactive ']";

	    // Table header in all banks
	    public static final String tableHeader = "(//table[@class='table table-bordered'])[2]/descendant::th";
	
 
	    // Block / Unblock
	    public static final String block = "(//a[contains(@ng-click,'blockUnblock')])[1]";
	    public static final String unblock = "(//a[contains(@ng-click,'blockUnblock')])[1]";
	    
	    public static final String facebookFirstName="firstname";

	    // MID details
	    public static final String viewDetailsUpdateButton = "(//a[@class='btn btn-primary btn-sm'])[1]";
	    public static final String getMidName ="(//div[@class='bnk-sts'])[1]";
	
	    // Select country
	    public static final String selectCountry = "//select[@id='country']";
	    public static final String updateButton = "//span[text()='Update']";

	    // Delete MID
	    public static final String deleteMID = "(//a[@title='Delete'])[1]";
	    public static final String deleteMidMessage = "//div[contains(text(),'Do you want to delete')]";
	    public static final String cancelButton = "//button[text()='cancel']";
	    public static final String confirmButton = "//button[text()='confirm']";

	    // Block / Unblock MID
	    public static final String blockMid = "(//a[@title='Block'])[1]";
	    public static final String unblockMid = "(//a[contains(@ng-click,'blockUnblock')])[1]";
	    
	    //get bank name
	    public static final String bankNameOnViewMidPage="(//h3[@class='text-primary d-inline'])[2]";
	    public static final String bankNameOnAddMidPage="(//span[@class='badge bg-primary'])[1]"; 
	    
	    
	   // =======================MID PRODUCT LIST Page==================================================
	    public static final String midProductList= "//span[text()='Mid Product List']";	
	    public static final String midnameOnMidProductList = "//span[@id='midName']";
	    public static final String uploadCsvFile= "//input[@id='CSVfile']";
	    public static final String upload="//button[@id='midProductlistUpload']";
	    public static final String ok="//button[@class='swal2-confirm swal2-styled']";
	    public static final String uploadFileText="//button[@id='midProductlistUpload']";
	    
	    public static final String downloadSampleCsv= "//a[@id='downloadLink']";
	    public static final String enterProductname= "//input[@id='productName']";
	    public static final String enterProductPrice= "//input[@id='productPrice']";
	    public static final String add= "//button[@id='addSingleProductbutton']";
	    public static final String fillCompleteDataError="//span[@id='incompleteProductdataWarning']";
	    public static final String fillValidValues="//span[contains(text(),'Complete data for')]";
	    public static final String headersProductList="(//table[@class='table table-bordered'])[2]//th";
	    public static final String productAddPopUp="//div[text()='Product Added Successfully']";
	    public static final String deleteProductName="(//button[@class='btn btn-success btn-sm'])[1]";
	    public static final String deleteProductSuccessfully="//div[text()='Product Deleted Successfully']";
	    public static final String deleteOkButton= "//button[@class='swal2-confirm swal2-styled']";
	    
	    //view bank details
	    public static final String viewBankDetails="(//button[@title='View Bank Details'])[1]";
	    public static final String getBankName="//div[@class='bnk-sts']/span";
	    public static final String bank_Details="//h1[text()='Bank Details']";
	    public static final String getBankNameFromBankDetails="//input[@id='bankname']";
	    
	    //update state field - Bank details page
	   
	    public static final String state="//input[@id='state']";
	    public static final String update="//button[@type='submit']";
	    public static final String getPopUpSuccessOnBankDetailsPage="//span[@data-notify='message']";
	    public static final String back="//button[@class='btn btn-primary ']";
	    
	    
	    //setting -> 
	    public static final String setting="//button[@ng-click='setting(bank.id)']";
	    public static final String configureApi="//h1[text()='Configure API']";
	    public static final String paypemtProcessor="//h1[text()='Configure API']";
	    
	   // setting -verify header
	    public static final String configureApiHeader="(//table[@class='table table-bordered'])[2]//th"; 
	    
	    //add api
	    public static final String addApi="//span[text()='Add API']";
	    public static final String merchantMasterPayemtProcessor="//span[@class='badge bg-primary']";
	    
	    //notify pop up
	    public static final String notifyButton="//button[@id='notifyBtn']";
	    public static final String notifyPopup="//button[@id='notifyBtn']";
	    
	    
	    //url type--setting 
	    public static final String urlTypeDropdown="//select[@id='urltype']";
	    public static final String RequestTypeDropdown="//select[@id='reqtype']";
	    
	    //validate error in URL / Base URL
	    public static final String submitButton="(//button[@class='btn btn-primary '])[2]";
	    public static final String urlError="//label[@id='url-error']";
	    public static final String baseUrl="//input[@id='url']";
	    public static final String duplicateEntry="//span[@data-notify='message']";
	 //   public static final String backButton="//button[@ng-click='goBack()']";
	    public static final String deleteButtonMerchantmaster="//a[@class='btn btn-danger btn-sm']";  
	    public static final String confirm="//button[text()='confirm']"; 
	    public static final String noRecordsAvailable="//td[text()='No Records Available']"; 
	    public static final String viewDetails="//a[@class='btn btn-primary btn-sm']";
	    public static final String getAPIName="(//div[@class='bnk-sts'])[1]";
	    public static final String getURLTYPEName="(//div[@class='bnk-sts'])[2]";
	
	   // --------------------------- JSON TRANSFORMER ---------------------------
	    public static final String jsonTransformer="//button[@ng-click='jsonformatter(bank.id)']";
	    public static final String PaymentBankJsonData="//h1[@id='topBarMsg12']";
	    public static final String bankName="//span[@class='ng-binding']";
	    public static final String PaymentBankJsonDataHeaders="(//table[@class='table table-bordered'])[2]//th";
	    public static final String addJson="//a[@onclick='handleAddJsonClick()']";
	    public static final String json_Transformer="//h1[text()='Json Transformer']";
	    public static final String bank_name_display="//span[@id='bank_name_display']";
	    public static final String submitButtonJsonTransformer="//button[@id='submitBtn']";
	    public static final String configueJson="//div[@class='custom-select custom-Merchant']/textarea";
	    public static final String flowType="//div[@class='custom-select custom-Merchant']/input";
	    
	    //json transformer --action
	    public static final String action="//a[contains(normalize-space(@onclick), 'handleView')]";
	    public static final String updatEButton="//button[@id='updateBtn']";
	    
	    
	    /*------------Error Code Mapping --------------------------*/
	    public static final String responseCodeError="//span[@class='text-danger']";
	    public static final String successMsg="//span[@data-notify='message']";
	    public static final String errorCodeMapping="(//button[@ng-click='mapping(bank.id)'])[1]";
	    public static final String payMentProcessor="(//h3[@class='text-primary d-inline'])[3]";
	    public static final String tableHeadersInECM="//table[@id='tabel22']//tr/th";
	    public static final String bacKButton="//button[@onclick='goBack()']";
	    public static final String addBankMapping="//span[text()='Add Bank Mapping']";
	    public static final String bankNameonECM="//span[@class='badge bg-primary']";
	    public static final String requesTTypeDropdown="//select[@id='request_type']";
	    public static final String responseTypeDropdown="//select[@id='response_type']";
	    public static final String errorInResponseCode="//span[@class='text-danger']";
	    public static final String submiTButton="//span[text()='Submit']";
	    public static final String responseCode="(//input[@name='response_code']//preceding-sibling::label)[2]";
	    public static final String actionBnakMapping="(//a[@class='btn btn-primary btn-sm'])[1]";
	    public static final String rsCode="//input[@name='response_code']";
	    public static final String code="((//table[@class='table table-bordered'])[2]//descendant::tr[2]/td[1])[1]";
	    public static final String requestType="((//table[@class='table table-bordered'])[2]//descendant::tr[2]/td[2])[1]";                                                             
	    public static final String responseType="((//table[@class='table table-bordered'])[2]//descendant::tr[2]/td[3])[1]";
	    public static final String getTextFromResponseCode="//label[text()='Response Code']//following-sibling::label";
	    
	    public static final String requesTTypeDropdownValue="//span[@id='select2-request_type-container']";
	    public static final String requesDropdownValue="//span[@id='select2-request_type-container']";
	    
	    public static final String deleteMessage="//div[contains(@id,'jconfirm-box')]";
	    public static final String cancel="//button[text()='cancel']";
	    public static final String confirMButton="//button[text()='confirm']";
	    public static final String deleteButton="(//a[@class='btn btn-danger btn-sm text-white'])[1]";
	    
	    
	    
	    
	    
	    
	    
}








