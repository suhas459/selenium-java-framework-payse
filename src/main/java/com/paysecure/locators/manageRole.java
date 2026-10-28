package com.paysecure.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class manageRole {

	// navigate up to API LOG

	public static final String manageRoles = "//span[text()='Manage Roles']";
	public static final String manage_Roles = "//h1[text()='Manage Roles']";

	// search
	public static final String search = "//input[@placeholder='Username or Merchant Name']";
	public static final String SEARC = "//input[@placeholder='Username or Merchant Name']";
	public static final String searchButton = "//input[@placeholder='Username or Merchant Name']/following-sibling::button";
	public static final String USERNAME = "//span[@name='fordeleterole']";
	public static final String noRecordsFound = "//td[text()='No Records Found']";

	// add role
	public static final String adddRole = "//button[@title='Add Role']";
	public static final String addRole_userName = "//input[@id='username1']";
	public static final String password = "//input[@id='password1']";
	public static final String emailAddress = "//input[@id='emailaddress1']";
	public static final String role = "//select[@id='role_id1']";
	public static final String addRoleButton = "(//button[text()='Add Role'])[2]";
	public static final String genPass = "//button[text()='GenPass']";
	public static final String emailError = "//input[@id='emailaddress1']/following-sibling::span[contains(normalize-space(),'field is required')]";
	public static final String email_Character = "//input[@id='emailaddress1']/following-sibling::span[contains(normalize-space(),'Email address')]";

	// Display by role -- dropdown
	public static final String display_By_Role = "//select[contains(@class,'form-select form-select-lg')]";
	public static final String showAll = "//button[text()='Show All']";
	public static final String displayRole = "(//div[@class='custom-select'])[1]";

	// delete username or merchant name
	public static final String deleteButton = "(//button[contains(@ng-click,'deleteRole')])[1]";
	public static final String deleteRoleName = "(//span[@name='fordeleterole'])[1]";
	public static final String popUptext = "//div[text()='Do you want to delete user tomjerry_6d']";
	public static final String cancel = "//button[text()='cancel']";
	public static final String confirm = "//button[text()='confirm']";

	// get username after searching the role

	public static final String userName = "//span[@name='fordeleterole']";
	public static final String Role = "//tbody[@id='newCon']//td[4]/span";

	// displayByRole

	public static final String displayByRole = "//select[@id='typeOfRole']";

	// reset password
	 public static final String resetPassword = "(//button[@title='Reset Password'])[1]";
	    public static final String resetPasswordMessage = "//span[@data-notify='message']";
	    public static final String updateButton = "//button[@id='passwordSubmit']";
	    public static final String enterPassword = "//input[@name='newPassword']";
	    public static final String passwordErrorCharacter = "//span[@class='text-danger'][2]";
	    public static final String passwordError_8Character = "//span[@class='text-danger'][1]";
	    public static final String enterPassword_SpaceNotAllowed = "(//span[contains(text(),'not allowed')])[2]";
	
	    // Next button
	    public static final String nextBtn = "//a[text()='Next']";

	    // Table header - manage roles
	    public static final String tableHeader = "(//table[@class='table table-bordered'])[2]/thead/tr/th";

	    // Login - manage role
	    public static final String login = "//button[@title='Login as User']";
	    
	    // Change password page
	    public static final String currentPassword = "//input[@id='currentpassword']";
	    public static final String newPassword = "//input[@name='newpassword']";
	    public static final String confirmPassword = "//input[@name='matchingPassword']";
	    public static final String changePasswordButton = "//button[text()='Change Password']";
	    public static final String loginLink = "//a[text()='click here to login']";
	    public static final String usernameLogin = "//input[@id='exampleFormControlInput1']";
	    public static final String passwordLogin = "//input[@id='floatingPassword']";
	    public static final String submitLogin = "//button[text()='Submit']";
	    public static final String roleName = "//p[@class='fw-bold mb-0']";

	    // Error messages
	    public static final String error1 = "//ul[@class='error-list']/li[1]";
	    public static final String error2 = "//ul[@class='error-list']/li[2]";
	    public static final String error3 = "//ul[@class='error-list']/li[3]";
	    public static final String error4 = "//ul[@class='error-list']/li[4]";
	    public static final String error5 = "//ul[@class='error-list']/li[5]";

	    public static final String passwordNotMatch = "//div[text()='Password does not match!']";
	    
	 // reset 2FA
	    public static final String reset2FA = "(//button[@title='Reset 2FA'])[1]";
	    public static final String reset2FAMessage = "//span[@data-notify='message']/br";
	    
	    
	    //login as user 
	    public static final String loginAsUser = "(//button[@title='Login as User'])[1]";
	    
	    //Merchant - Login 
	    public static final String reportM = "//span[text()='Reports']";
	    public static final String transactionM = "//span[text()='Transactions']";
	    public static final String searchBtn = "//span[text()='Search']";
	    public static final String allErrors = "(//th[text()='Transaction ID'])[1]/ancestor::table//td[8]";

}
