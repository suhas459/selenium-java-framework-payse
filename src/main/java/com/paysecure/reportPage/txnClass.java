package com.paysecure.reportPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.paysecure.actiondriver.ActionDriver;
import com.paysecure.base.baseClass;
import com.paysecure.locators.apiLogPage;

public class txnClass {

	private By totalRows = By.xpath("//tbody[@id='filterTransStats']/tr");
	private By noRecordsFound = By.xpath("//td[text()='No Records Found']");
	private By downText = By.xpath("//label[@id='dailypagtext']");
	private By totalCount = By.xpath("//label[@id='dailypagtext']/span[3]");

	private ActionDriver actionDriver;
	// page factory constructor
	public txnClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.actionDriver = new ActionDriver(driver);
	}
	/*
	 * if there are less than 10 count then print rows size or equal to then also print rows size
	 * if transaction status count is more than 10 then print that count
	 * if there is no records then print - No records found
	 */
	public void handleStatusCount() {
		WebDriver driver=baseClass.getDriver();
		List<WebElement> kjdnjsdh = driver.findElements(By.xpath("//tbody[@id='filterTransStats']/tr"));
		int rowsCount = kjdnjsdh.size();
		
		if(actionDriver.isDisplayed(noRecordsFound)) {
			System.out.println("no records found !!!");
		}
		
		if(rowsCount <=10 ) {
			System.out.println(rowsCount);
		}else if(actionDriver.isDisplayed(totalCount)) {
			String fsrfg = actionDriver.getText(downText).trim();
			System.out.println(fsrfg);
		}else {
			System.out.println(rowsCount);
		}
		
	
	}
	
	
	
	
}
