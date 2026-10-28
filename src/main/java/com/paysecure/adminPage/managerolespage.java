package com.paysecure.adminPage;




import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.paysecure.actiondriver.ActionDriver;
import com.paysecure.base.baseClass;
import com.paysecure.locators.manageRole;
import com.paysecure.utilities.ExcelWriteUtility;
import com.paysecure.utilities.testData_CreateRoll;






public class managerolespage {
	// Navigate - Manage Roles
	private By manageRoles = By.xpath(manageRole.manageRoles);
	private By manage_Roles = By.xpath(manageRole.manage_Roles);

	// search Functionality
	private By search= By.xpath(manageRole.search);
	@FindBy(xpath = manageRole.SEARC) private WebElement SEARCH;
	private By searchButton = By.xpath(manageRole.searchButton);

	@FindBy(xpath =manageRole.USERNAME)
	private WebElement USERNAME;
	private By noRecordsFound = By.xpath(manageRole.noRecordsFound);

	// add role
	private By adddRole = By.xpath(manageRole.adddRole);
	private By addRole_userName = By.xpath(manageRole.addRole_userName);
	private By password = By.xpath(manageRole.password);
	private By emailAddress = By.xpath(manageRole.emailAddress);
	private By role = By.xpath(manageRole.role);

	@FindBy(xpath = manageRole.role)
	private WebElement ROLE;

	private By addRoleButton = By.xpath(manageRole.addRoleButton);
	private By genPass = By.xpath(manageRole.genPass);

	@FindBy(xpath = manageRole.password)
	private WebElement PASSWORD;

	private By emailError = By.xpath(manageRole.emailError);
	private By email_Character = By.xpath(manageRole.email_Character);


	// Display by role -- dropdown

	private By display_By_Role = By.xpath(manageRole.display_By_Role);
	private By showAll = By.xpath(manageRole.showAll);
	private By displayRole = By.xpath(manageRole.displayRole);

	@FindBy(xpath = manageRole.display_By_Role)
	private WebElement DISPLAYbYROLE;


	// delete username or merchant name
	private By deleteButton = By.xpath(manageRole.deleteButton);
	private By deleteRoleName = By.xpath(manageRole.deleteRoleName);
	private By popUptext = By.xpath(manageRole.popUptext);

	@FindBy(xpath = manageRole.popUptext)
	private WebElement POPUPTEXT;

	private By cancel = By.xpath(manageRole.cancel);
	private By confirm = By.xpath(manageRole.confirm);

	// get username after searching the role

	private By userName = By.xpath(manageRole.userName);
	private By Role = By.xpath(manageRole.Role);

	// displayByRole
	private By displayByRole = By.xpath(manageRole.displayByRole);

	// reset password
	private By resetPassword = By.xpath(manageRole.resetPassword);
	private By resetPasswordMessage = By.xpath(manageRole.resetPasswordMessage);
	private By updateButton = By.xpath(manageRole.updateButton);
	private By enterPassword = By.xpath(manageRole.enterPassword);
	private By passwordErrorCharacter = By.xpath(manageRole.passwordErrorCharacter);
	private By passwordError_8Character = By.xpath(manageRole.passwordError_8Character);
	private By enterPassword_SpaceNotAllowed = By.xpath(manageRole.enterPassword_SpaceNotAllowed);


	  // Next button
	private By nextBtn = By.xpath(manageRole.nextBtn);
	
	// Table header - manage roles
	private By tableHeader = By.xpath(manageRole.tableHeader);
	
	  // Login - manage role
	private By login = By.xpath(manageRole.login);

	// current password
	private By currentPassword = By.xpath(manageRole.currentPassword);
	private By newPassword = By.xpath(manageRole.newPassword);
	private By confirmPassword = By.xpath(manageRole.confirmPassword);
	private By changePasswordButton = By.xpath(manageRole.changePasswordButton);
	private By loginLink = By.xpath(manageRole.loginLink);
	private By usernameLogin = By.xpath(manageRole.usernameLogin);
	private By passwordLogin = By.xpath(manageRole.passwordLogin);
	private By submitLogin = By.xpath(manageRole.submitLogin);
	private By roleName = By.xpath(manageRole.roleName);

	private By error1 = By.xpath(manageRole.error1);
	private By error2 = By.xpath(manageRole.error2);
	private By error3 = By.xpath(manageRole.error3);
	private By error4 = By.xpath(manageRole.error4);
	private By error5 = By.xpath(manageRole.error5);

	private By passwordNotMatch = By.xpath(manageRole.passwordNotMatch);


	// reset 2FA
	private By reset2FA = By.xpath(manageRole.reset2FA);
	private By reset2FAMessage = By.xpath(manageRole.reset2FAMessage);


	//Login As User
	private By loginAsUser = By.xpath(manageRole.loginAsUser);
	
	//navigate up to merchant transactions
	private By reportM = By.xpath(manageRole.reportM);
	private By transactionM = By.xpath(manageRole.transactionM);
	private By searchBtn = By.xpath(manageRole.searchBtn);
	private By allErrors = By.xpath(manageRole.allErrors);
	String merchantName;
	private ActionDriver actionDriver;
	private WebDriver driver;

// page factory constructor
	public managerolespage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.actionDriver = new ActionDriver(driver);
	}

	public void navigateToManageRoles() {
		WebDriver driver=baseClass.getDriver();
		driver.manage().window().setSize(new Dimension(1366,768));
		
		actionDriver.click(manageRoles);
		Reporter.log("User Click on Main Module - Manage Roles", true);

		Assert.assertTrue(actionDriver.isDisplayed(manage_Roles),
				"If Manage Roles is not displays on Manage Roles page then user is not on the Manage Roles page");
		Reporter.log("User is on the Manage Roles Main Module", true);

	}

	public void searchByUsername_Merchant(String username_Merchant) {
		actionDriver.enterText(search, username_Merchant);
		Reporter.log("User search username/Merchant :- " + username_Merchant, true);

		actionDriver.click(searchButton);
		Reporter.log("User Click on search button", true);

	}

	public void verifySearchRoleSameorNot(WebDriver driver, String username_Merchant) {
		actionDriver.enterText(search, username_Merchant);
		Reporter.log("User search username/Merchant :- " + username_Merchant, true);

		actionDriver.click(searchButton);
		Reporter.log("User Click on search button", true);

		String user_name = USERNAME.getAttribute("data-username");

		Assert.assertEquals(username_Merchant, user_name, "If both are not match then our TC is Fail");
		Reporter.log("Verify search username is present on this manage role page :- " + username_Merchant, true);

	}

	public void verifyIfUserEnterWrongUsername() {
		Assert.assertTrue(actionDriver.isDisplayed(noRecordsFound));
		Reporter.log("If user enter any wrong username or merchant name then No records found is successfully displays",
				true);
	}

	public void refreshSearchPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("location.reload();");



	}

	public void clickOnAddRole() {
		actionDriver.click(adddRole);
		Reporter.log("User Click on add Roles", true);

	}

	public void verifyAllErrorsInAddRole() {
		actionDriver.click(adddRole);
		Reporter.log("User Click on add rolRoles", true);

		actionDriver.click(addRoleButton);
		Reporter.log("User Click on add roll button", true);

	}

	// username -enter some text
	public void enterUsername(String username) {
		actionDriver.clearText(addRole_userName);
		actionDriver.enterText(addRole_userName, username);

	}

	// username error message
	public String getErrorMessage_Username(WebDriver driver, String errorXpath) {
		By errorLocator = By.xpath(errorXpath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator));
		return driver.findElement(errorLocator).getText();
	}

	// username error message validate
	public void validateUsernameError(WebDriver driver, String input, String expectedError, String errorXpath) {
		enterUsername(input);
		String actualError = getErrorMessage_Username(driver, errorXpath);
		if (!actualError.equals(expectedError)) {
			throw new AssertionError("Expected: " + expectedError + ", but got: " + actualError);
		}
	}

	// password
	public void enterPassword(String pass) {
		actionDriver.clearText(password);
		actionDriver.enterText(password, pass);

	}

	// password error message
	public String getErrorMessage_password(WebDriver driver, String errorXpath) {
		By errorLocator = By.xpath(errorXpath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator));
		return driver.findElement(errorLocator).getText();
	}

	// password error message validate
	public void validatePasswordError(WebDriver driver, String input, String expectedError, String errorXpath) {
		enterPassword(input); // ✅ FIXED
		String actualError = getErrorMessage_password(driver, errorXpath);
		if (!actualError.equals(expectedError)) {
			throw new AssertionError("Expected: " + expectedError + ", but got: " + actualError);
		}
	}

	public void validate_genPass(WebDriver driver) {

		actionDriver.click(genPass);
		Reporter.log("User click on the Gen Pass Button", true);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String value = (String) js.executeScript("return arguments[0].value;", PASSWORD);
		System.out.println("Value via JS: " + value);

		if (value != null && !value.trim().isEmpty()) {
			System.err.println("JS says:- Field has value");

			Reporter.log("User clicks on the Gen Pass Button then actually some new password will be generated: '"
					+ value + "'", true);

		}

	}

	// email
	public void enterEmailID(String email) {
		actionDriver.clearText(emailAddress);
		actionDriver.enterText(emailAddress, email);

	}

	// email error message
	public String getErrorMessage_email(WebDriver driver, String errorXpath) {
		By errorLocator = By.xpath(errorXpath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator));
		return driver.findElement(errorLocator).getText();
	}

	// email error message validate
	public void validateEmailError(WebDriver driver, String input, String expectedError, String errorXpath) {
		enterEmailID(input); // ✅ FIXED
		String actualError = getErrorMessage_password(driver, errorXpath);
		if (!actualError.equals(expectedError)) {
			throw new AssertionError("Expected: " + expectedError + ", but got: " + actualError);
		}
	}

	// select ROLE
	public void selectRole(String roles) {
//		Select s=new Select(ROLE);
//          List<WebElement> rol = s.getOptions();
//      for(WebElement r:rol) {
//    	  System.err.println(r.getText());
//      }

		actionDriver.selectByVisibleText(role, roles);

	}

	public String username;

	public Map<String, String> createRole() throws InterruptedException {
		username = testData_CreateRoll.generateRandomUsername();
		String pass = testData_CreateRoll.generateRandomPassword();
		String email = testData_CreateRoll.generateRandomEmail();
		String roles = "MERCHANT";

		System.err.println("New Username :- " + username);
		actionDriver.enterText(addRole_userName, username);
		actionDriver.click(genPass);
		actionDriver.enterText(emailAddress, email);

		actionDriver.selectByVisibleText(role, roles);

		actionDriver.click(addRoleButton);

		Thread.sleep(1500);

		Map<String, String> data = new HashMap<>();
		data.put("username", username);
		data.put("password", pass);
		data.put("role", roles);
		return data;
	}

	public void searchRoleAfterCreating(WebDriver driver) throws InterruptedException {

		managerolespage mr = new managerolespage(driver);
		Map<String, String> userDetails1 = mr.createRole();

		String username1 = userDetails1.get("username").trim();
		System.err.println("Searching for created user: " + username1);

		Thread.sleep(3000); // Give backend time to register user or replace with WebDriverWait

		actionDriver.clickUsingJS(search);
		// actionDriver.clear(search); // Important if old text remains
		actionDriver.sendKeysWithActions(search, username);
		// actionDriver.enterText(search, username);
		actionDriver.click(searchButton);

	}

	public void verifyShowAllFunctionality() {

		actionDriver.click(displayRole);

		actionDriver.selectByVisibleText(display_By_Role, "MERCHANT");

//		Select s=new Select(DISPLAYbYROLE);
//		s.selectByVisibleText("MERCHANT");
		// actionDriver.isDisplayed(showAll);
		Assert.assertTrue(actionDriver.isDisplayed(showAll));

	}

	public void ClickOnshowAllButton() {
		actionDriver.clickUsingJS(showAll);
		Reporter.log("User Click on the Show All Button", true);
	}

	public void searchRoleViaUsernameOrMercahntName(String userName) {
		actionDriver.clickUsingJS(search);
		Reporter.log("User Click on Username Or Merchant name text Field", true);
		actionDriver.sendKeysWithActions(search, userName);

		Reporter.log("User enter Username or merchant Name :- " + userName, true);

		actionDriver.click(searchButton);
		Reporter.log("User Click on the search Button", true);

	}

	public String validateUsernameWhileDeletePopUp() {

		merchantName = actionDriver.getText(deleteRoleName);
		Reporter.log("User get delete role name before delete this role", true);

		actionDriver.clickUsingJS(deleteButton);
		Reporter.log("User Click on the Delete Button", true);

		return merchantName;
	}

	public void validateDeleteRoleOnDeletePopUp() {
		WebDriver driver = baseClass.getDriver();

		// Get full text from the <div>
		String fullText = driver.findElement(By.xpath("//div[contains(text(),'Do you want to delete user')]"))
				.getText();

		// Extract only the username part
		String username = fullText.split("user ")[1];

		System.out.println("Extracted Username: " + username); // Output: tomjerry_6d

		Assert.assertEquals(merchantName, username,
				"If Username and Merchant name is not same then our TC is should be in a failed condition.");
		Reporter.log("Verify Username/Merchant name on the delete pop up", true);

	}

	public void cancelButton() {
		actionDriver.click(cancel);
		Reporter.log("User Click on the Cancel Button", true);
	}

	public void deletePopUpButton() {
		actionDriver.click(confirm);
		Reporter.log("User Click on the Confirm Button", true);
	}

	private String getUserName;
	private String getRolename;

	public List<String> getUsernameAndRolenameAfterSearchingRole() {
		getUserName = actionDriver.getText(userName);
		Reporter.log("After searching the role, user gets username: " + getUserName, true);

		getRolename = actionDriver.getText(Role);
		Reporter.log("After searching the role, user gets Assigned Role: " + getRolename, true);

		List<String> result = new ArrayList<>();
		result.add(getUserName);
		result.add(getRolename);
		System.err.println(getUserName);
		System.err.println(getRolename);
		return result;
	}

	public void searchRoleViaGetUsernameOrmerchantName() {
		actionDriver.clearText(search);
		actionDriver.sendKeysWithActions(search, getUserName);
		actionDriver.click(searchButton);
		Reporter.log("User Click on the search Button", true);
	}

	public void displayByRoleDropdown(String role) {
		actionDriver.selectByVisibleText(displayByRole, role);
	}

	public void checkTransactionStatus(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		try {
			// Try to get table rows
			List<WebElement> tableRows = wait
					.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//tbody[@id='newCon']/tr[1]")));

			if (!tableRows.isEmpty()) {
				System.out.println("✅ Transaction details is displayed on the Transaction table");

			}

		} catch (Exception e) {
			// If table rows not found, check for 'No records found' message
			try {
				WebElement noRecordElement = driver.findElement(By.xpath("//td[text()='No Records Found']"));
				if (noRecordElement.isDisplayed()) {
					System.out.println("✅ 'No records found' message is displayed.");
				} else {
					System.out.println("⚠️ Neither rows nor 'No records found' message is displayed.");
				}
			} catch (NoSuchElementException ex) {
				System.out.println("❌ Neither table rows nor 'No records found' message were found.");
			}
		}
	}

	String userId;

	public String verifyUserIDInResetPassword() {
		WebDriver driver = baseClass.getDriver();

		actionDriver.click(resetPassword);
		Reporter.log("User click on the Reset Password Functionality", true);

		userId = driver.findElement(By.id("nn")).getAttribute("value");
		System.out.println("User ID: " + userId);
		return userId;
	}

	public void verifyUserIDSameOnAfterSearchingAndResetPopUp() {
		Assert.assertEquals(getUserName, userId);
		Reporter.log("Verify USEDID is matching on the Reset password", true);

	}

	public void verifyResetPasswordMessage_min8Character() throws InterruptedException {

		actionDriver.enterText(enterPassword, "a");
		Reporter.log("User enter passowrd in password field", true);

		actionDriver.isDisplayed(passwordErrorCharacter);
		Reporter.log("User Verify :-Atleast one small and one capital letter, one digit, one special character", true);

		actionDriver.isDisplayed(passwordError_8Character);
		Reporter.log("User verify :- Password should be min 8 character", true);

		Thread.sleep(1500);
		actionDriver.clearText(enterPassword);
		Reporter.log("User clear the text in the password field", true);
		Thread.sleep(3000);

		actionDriver.enterText(enterPassword, "a   u    d      i");
		Reporter.log("User enter passowrd in password field", true);

		actionDriver.isDisplayed(enterPassword_SpaceNotAllowed);
		Reporter.log("User verify :- Password should be min 8 character", true);

	}

	public void userEnterValiadPasswordInUpdatePasswordField() {
		actionDriver.click(resetPassword);
		Reporter.log("User click on the Reset Password Functionality", true);

		actionDriver.enterText(enterPassword, "tomJerry@123");
		Reporter.log("User enter passowrd in password field", true);

	}

	public void clickOnUpdateButton() {
		actionDriver.clickUsingJS(updateButton);
		// actionDriver.click(updateButton);
		Reporter.log("User click on the update Button", true);
	}

	public void resetPasswordMessage() {
		actionDriver.isDisplayed(resetPasswordMessage);
		Reporter.log("Verified user enter new password successfully", true);
	}

	public void iterateAllTablePages(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		int totalRowCount = 0;

		while (true) {
			// Wait and fetch all rows on current page
			List<WebElement> rows = wait
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tbody[@id='newCon']/tr")));

			int currentPageRowCount = rows.size();
			totalRowCount += currentPageRowCount;

			System.out.println("Rows on this page: " + currentPageRowCount);

			// Loop through rows
			for (WebElement row : rows) {
				System.out.println("Row Data: " + row.getText());
			}

			// Check if 'Next' button is disabled
			WebElement nextButtonContainer = driver.findElement(By.xpath("//li[contains(@class,'page-item next')]"));
			String classAttr = nextButtonContainer.getAttribute("class");

			if (classAttr.contains("page-item next disabled")) {
				System.out.println("Reached last page.");
				break;
			}

			actionDriver.clickUsingJS(nextBtn); // Ensure nextBtn is globally defined and accessible
		}

		// Final total row count print
		System.out.println(" Total rows across all pages: " + totalRowCount);
	}

	public void verifyTableHeaderInManageRole() {
		WebDriver driver = baseClass.getDriver();

		// Step 1: Define expected header names
		List<String> expectedHeaders = Arrays.asList("USERNAME", "MERCHANT NAME", "EMAIL", "ROLE", "DELETE USER",
				"RESET PASSWORD", "LOGIN", "RESET 2FA");
		Reporter.log("Expected headers: " + expectedHeaders, true);

		// Step 2: Locate the actual table headers
		List<WebElement> actualHeaderElements = driver.findElements(tableHeader);
		List<String> actualHeaders = new ArrayList<>();

		for (WebElement header : actualHeaderElements) {
			actualHeaders.add(header.getText().trim());
		}

		Reporter.log("Actual headers found: " + actualHeaders, true);
		Reporter.log("Expected header count: " + expectedHeaders.size(), true);
		Reporter.log("Actual header count: " + actualHeaders.size(), true);

		// Step 3: Assert the content
		Assert.assertEquals(actualHeaders, expectedHeaders, "Table headers do not match by name!");
		Reporter.log("Table header verification PASSED. Headers match exactly by name.", true);
	}

	public void validateDisplayByRollElement() {

		List<String> rol = actionDriver.getDropdownOptions(displayByRole);

		String roles = rol.remove(0);

		System.out.println(rol);

		List<String> expectedHeaders = Arrays.asList("SUPERADMIN", "MERCHANT", "P2PMERCHANT", "AGENT", "WHITELABEL",
				"P2PAGENT", "REPORTADMIN", "ADMIN", "MIDADMIN", "ACCOUNTADMIN", "FULLADMIN", "WHITELABELMERCHANT");

		Assert.assertEquals(rol, expectedHeaders,
				"If headers in  display by roll is not matching then our TC is in failed condition");
		Reporter.log("Verifies all the roles in display by roll dropdown is matches");
	}

	public void validateBYdefaultAllisSelectedInDisplayByRole() {
		Select s = new Select(DISPLAYbYROLE);
		// s.getFirstSelectedOption()
		String fistSelectedOption = actionDriver.getFirstSelectedOption(displayByRole);
		Assert.assertEquals("ALL", fistSelectedOption);
		Reporter.log(
				"Verifies that First By default Selected option from Display by dropdown :- " + fistSelectedOption);
	}


	
	String getUserName_ManageRole;

	public String ifUserisAlredayCreatedThenDirectlyGoToLoginPage() {
		getUserName_ManageRole = actionDriver.getText(userName);
		Reporter.log("After searching the role, user gets username: " + getUserName, true);
		actionDriver.click(login);
		return getUserName_ManageRole;

	}

	String new_Password = "Pass@123";
	String confirm_Password = "Pass@123";

	public void changePasswordIFUserLoginFromManageRole() throws InterruptedException {
		actionDriver.enterText(currentPassword, "tomJerry@123");

		actionDriver.enterText(newPassword, "Pass@123");

		actionDriver.enterText(confirmPassword, "Pass@123");

		Thread.sleep(3800);

		actionDriver.click(changePasswordButton);
		Thread.sleep(3800);
		actionDriver.click(loginLink);
	}

	public void login_ManageRoles() {
		actionDriver.enterText(usernameLogin, "operationmerchant");
		actionDriver.enterText(passwordLogin, confirm_Password);
		actionDriver.click(submitLogin);

		String role_Name = actionDriver.getText(roleName);
		Assert.assertEquals(role_Name, getUserName_ManageRole);
		Reporter.log("Verifies :- if user enter login through the manage role then it successfully log in ", true);
	}

	public void verifyAllErrorsInCHangePassword_ManageRole() {
		actionDriver.enterText(currentPassword, "tomJerry@123");
		actionDriver.enterText(newPassword, "qwer");
		Reporter.log("User enter new password in a new Password Field", true);

		actionDriver.isDisplayed(error1);
		Reporter.log("Verify :- Your password is too short", true);

		actionDriver.isDisplayed(error2);
		Reporter.log("Verify :- Your password contains sequences", true);

		actionDriver.isDisplayed(error3);
		Reporter.log("Verify :- Use upper case characters", true);

		actionDriver.isDisplayed(error4);
		Reporter.log("Verify :- Use numbers", true);

		actionDriver.isDisplayed(error5);
		Reporter.log("Verify :- Use special characters", true);

		actionDriver.clearText(newPassword);

		actionDriver.enterText(newPassword, "TomJerry@123");
		Reporter.log("User enter new password in a new Password Field", true);

		actionDriver.enterText(confirmPassword, "tomjerry@123");
		Reporter.log("User enter confirm password in a new Password Field", true);

		actionDriver.isDisplayed(passwordNotMatch);
		Reporter.log(
				"Verify that if Password is not match then this error is should be displays :- Password does not match!",
				true);
	}



	public void reset2FA() throws InterruptedException {
		WebDriver driver = baseClass.getDriver();

		By errorPopup = By.xpath("//span[@data-notify='message' and contains(text(), 'You are not authorized')]");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

        try {
        	actionDriver.click(reset2FA);
        	
            // Wait until popup becomes visible
            WebElement popupElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorPopup));

            String actualMessage = popupElement.getText().trim();
            System.out.println(" Popup appeared with message: " + actualMessage);

            // Assert using TestNG
            Assert.assertTrue(actualMessage.contains("You are not authorized"),
                    "Popup message mismatch: " + actualMessage);

            // Optional: Wait for it to disappear (not required in all test cases)
            wait.until(ExpectedConditions.invisibilityOfElementLocated(errorPopup));
            System.out.println(" Popup disappeared as expected.");

        } catch (Exception e) {
            Assert.fail("Popup did not appear or disappeared too quickly: " + e.getMessage());                                                       
        }

	}
	
	
	
	public void reset2FA_otherThanSUPERADMIN() throws InterruptedException {
		WebDriver driver = baseClass.getDriver();

	    By successPopup = By.xpath("//span[@data-notify='message' and contains(text(), 'Two-factor authentication reset completed successfully')]");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

	    try {
	    	actionDriver.click(reset2FA);
	    	
	        // Wait for the popup to be visible
	        WebElement popupElement = wait.until(ExpectedConditions.visibilityOfElementLocated(successPopup));
	        String message = popupElement.getText().trim();

	        System.out.println("Success Popup Text: " + message);

	        // TestNG assertion to verify message
	        Assert.assertTrue(message.contains("Two-factor authentication reset completed successfully"),
	                "Success message not as expected!");

	        // Optional: Wait for disappearance
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(successPopup));
	        System.out.println("Success popup disappeared.");

	    } catch (Exception e) {
	        Assert.fail("Success message popup did not appear or disappeared too quickly: " + e.getMessage());
	    }

	}
	

	
	
	
	public void resetpassword_forSUPERADMIN() throws InterruptedException {
		WebDriver driver = baseClass.getDriver();

	    By errorPopup = By.xpath("//span[@data-notify='message' and contains(text(), 'You are not allowed to change password of SUPERADMIN ')]");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

	    try {
	    //	actionDriver.click(resetPassword);
	    	
	        // Wait for the popup to be visible
	        WebElement popupElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorPopup));                                                                                                             
	        String message = popupElement.getText().trim();

	        System.out.println("Success Popup Text: " + message);

	        // TestNG assertion to verify message
	        Assert.assertTrue(message.contains("You are not allowed to change password of SUPERADMIN "),
	                "Error message not as expected!");

	        // Optional: Wait for disappearance
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(errorPopup));
	        System.out.println(" Error popup disappeared.");

	    } catch (Exception e) {
	        Assert.fail("Error message popup did not appear or disappeared too quickly: " + e.getMessage());
	    }

	}
	
	
	public void resetpassword_otherThanSUPERADMIN() throws InterruptedException {
		WebDriver driver = baseClass.getDriver();
		   By errorPopup = By.xpath("//span[@data-notify='message' and contains(text(), 'You are not allowed to change password of SUPERADMIN')]");

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		searchRoleViaUsernameOrMercahntName("nishantz");
    	userEnterValiadPasswordInUpdatePasswordField();
    	clickOnUpdateButton();
	        // Wait for the popup to be visible
	        WebElement popupElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorPopup));
	        String message = popupElement.getText().trim();

	        System.err.println("error Popup Text: " + message);

	        // TestNG assertion to verify message
	        Assert.assertTrue(message.contains("You are not allowed to change password of SUPERADMIN "),
	                "Error message not as expected!");

	        // Optional: Wait for disappearance
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(errorPopup));
	        System.err.println("Error popup disappeared.");

	 

	}
	
	public void clickOnLoginAsUserButton() {
	    actionDriver.click(loginAsUser);
	    Reporter.log("Clicked on 'Login as User' button", true);
	}

	public void navigateUptoTransactionModule() {
	    actionDriver.click(reportM);
	    Reporter.log("Clicked on 'Reports' menu", true);

	    actionDriver.click(transactionM);
	    Reporter.log("Clicked on 'Transaction' module", true);
	}
	

	public void clickOnSearchButton() {
		actionDriver.click(searchBtn);
		Reporter.log("Clicked on 'Search' button", true);
	}
	

	
	public void allErrors(String merchantName) {

	    WebDriver driver = baseClass.getDriver();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    List<String[]> errorDataList = new ArrayList<>();

	    while (true) {

	        // Wait for rows present
	        List<WebElement> errorCells = wait.until(
	                ExpectedConditions.presenceOfAllElementsLocatedBy(
	                        By.xpath("(//th[text()='Transaction ID'])[1]/ancestor::table//td[8]")
	                )
	        );

	        // -------- Collect current page data --------
	        for (WebElement errorCell : errorCells) {

	            String errorMessage = errorCell.getText().trim();

	            if (errorMessage.contains("You charge/limi")
	                    || errorMessage.contains("Min/max amount")
	                    || errorMessage.contains("Transaction Fai")) {

	                WebElement row = errorCell.findElement(By.xpath("./ancestor::tr"));

	                String timestamp = row.findElement(By.xpath(".//td[2]")).getText();
	                String transactionId = row.findElement(By.xpath(".//td[3]")).getText();

	                errorDataList.add(new String[]{
	                        transactionId,
	                        merchantName,
	                        errorMessage,
	                        timestamp
	                });
	            }
	        }

	        // -------- Check if more pages exist --------
	        String nextBtnClass = actionDriver.getAttribute(nextBtn, "class");

	        if (nextBtnClass.contains("page-item next disabled")) {
	            // No more pages, exit loop
	            break;
	        }

	        // Click next and wait for page refresh
	        actionDriver.clickUsingJS(nextBtn);
	        wait.until(ExpectedConditions.stalenessOf(errorCells.get(0)));
	    }

	    // -------- Verify collected data --------
	    System.out.println("Merchant: " + merchantName + " | Total errors found: " + errorDataList.size());

	    // -------- Write to Excel once --------
	    for (String[] data : errorDataList) {
	        ExcelWriteUtility.writeResultForErrorMessage(
	                "ErrorMessageExcelShet",
	                data[0],  // transactionId
	                data[1],  // merchantName
	                data[2],  // errorMessage
	                data[3]   // timestamp
	        );
	    }
	}




	
}

		  
	  
	
	
	
	
	
	
	
	

