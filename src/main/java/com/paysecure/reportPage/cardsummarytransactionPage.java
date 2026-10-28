package com.paysecure.reportPage;

import java.time.Duration;
import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.paysecure.actiondriver.ActionDriver;
import com.paysecure.locators.cardSummaryPage;







public class cardsummarytransactionPage {

	public String clickedTxnId ="";
	public static String clickedTxn___Id ="";

	// navigate upto Bank Transaction Time Report
	private By analytics = By.xpath(cardSummaryPage.analytics);
	private By report = By.xpath(cardSummaryPage.report);
	private By showing = By.xpath(cardSummaryPage.showing);


	// card summary page

	private By TID = By.xpath(cardSummaryPage.TID);
	private By lastAction_ID = By.xpath(cardSummaryPage.lastAction_ID);


	// cancel button - transaction --card summary page
	private By cancelButton = By.xpath(cardSummaryPage.cancelButton);


	//purchaseID
	private By pid = By.xpath(cardSummaryPage.pid);
	private By phid = By.xpath(cardSummaryPage.phid);

	private ActionDriver actionDriver;

	// page factory constructor
	public cardsummarytransactionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.actionDriver = new ActionDriver(driver);
	}

	public void clickOnCard(WebDriver driver, String targetCard) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean card = false;

		while (true) {
			List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
					By.xpath("(//th[text()='Transaction ID'])[1]/ancestor::table//td[7]")));

			for (WebElement row : rows) {
				actionDriver.scrollToElement(showing);

				List<WebElement> columns = row
						.findElements(By.xpath("(//th[text()='Transaction ID'])[1]/ancestor::table//td[7]"));

				for (WebElement cell : columns) {
					String cellText = cell.getText().trim();

					if (cellText.equalsIgnoreCase(targetCard)) {
						System.out.println("✅ Found card: " + cellText + " - Clicking on first occurrence.");

						try {
							if (cell.findElements(By.tagName("a")).size() > 0) {
								cell.findElement(By.tagName("a")).click();
							} else {
								cell.click();
							}
						} catch (Exception e) {
							System.out.println("⚠️ Error clicking on card: " + e.getMessage());
						}

						card = true;
						break;
					}
				}

				if (card)
					break;
			}

			if (card)
				break;

			List<WebElement> nextButtonList = driver.findElements(By.xpath("//li[contains(@class,'page-item next')]"));

			if (nextButtonList.isEmpty()) {
				System.out.println("❌ Next button not found at all.");
				break;
			}

			WebElement nextButtonContainer = nextButtonList.get(0);
			String classAttr = nextButtonContainer.getAttribute("class");

			if (classAttr.contains("page-item next disabled")) {
				System.out.println("❌ Card '" + targetCard + "' not found — reached last page.");
				break;
			}

			try {
				WebElement nextBtn = nextButtonContainer.findElement(By.xpath(".//a[text()='Next']"));
				nextBtn.click();
			} catch (Exception e) {
				System.out.println("⚠️ Unable to click Next button: " + e.getMessage());
				break;
			}
		}

		// ❗ Final check after loop ends
		if (!card) {
			Assert.fail("❌ Card '" + targetCard + "' not found in any page.");
		}
	}

	public void clickFirstValidTransaction(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean clicked = false;

		while (true) {
			List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
					By.xpath("//table[@id='tabel22']/tbody[@id='analyticTransStats1']/tr")));

			for (WebElement row : rows) {
				// Get LastStatus text (10th column)
				String status = row.findElement(By.xpath("(//th[text()='Transaction ID'])[2]/ancestor::table//td[10]"))
						.getText().trim();

				// Skip EXPIRED rows
				if (status.equalsIgnoreCase("EXPIRED")) {
					continue;
				}

				// Get Transaction ID cell (3rd column)
				WebElement txnIdCell = row
						.findElement(By.xpath("(//th[text()='Transaction ID'])[2]/ancestor::table//td[3]"));
				List<WebElement> links = txnIdCell.findElements(By.tagName("a"));

				if (!links.isEmpty()) {
					WebElement txnLink = links.get(0);

					// Store Transaction ID text
					this.clickedTxnId = txnLink.getText().trim();

					// Print before clicking
					System.out.println("Clicking Transaction ID: " + clickedTxnId);
					txnLink.click();
					clicked = true;
					break;
				}
			}

			if (clicked) {
				break;
			}

			// Check if there's a next page
			WebElement nextButtonContainer = driver.findElement(By.xpath("//li[@class='page-item next']"));
			String classAttr = nextButtonContainer.getAttribute("class");

			if (classAttr.contains("disabled")) {
				System.out.println("❌ No valid transaction found.");
				break;
			}

			// Go to next page
			nextButtonContainer.findElement(By.tagName("a")).click();
		}

		Assert.assertTrue(clicked, "❌ No clickable Transaction ID with valid status found.");
	}

	public void verifyTransactionIN_CardPage() {

		String tran_ID = actionDriver.getText(TID);

		Assert.assertEquals(tran_ID, this.clickedTxnId, "If Both transaction ID is not match then our TC is fail");

		actionDriver.click(cancelButton);
	}

	 // Global to compare later

	public void clickOnActionColumn(WebDriver driver) {
	    WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(15));
	    boolean actionClicked = false;

	    List<WebElement> rows = w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
	        By.xpath("//table[@id='tabel22']//tbody[@id='analyticTransStats1']/tr")));

	    for (WebElement r : rows) {
	        // ✅ Get Last Status from the current row's 10th column
	        String statusText = r.findElement(By.xpath("./td[10]")).getText().trim();

	        if (!statusText.equalsIgnoreCase("EXPIRED")) {
	            // ✅ Get Purchase ID from 3rd column of current row
	        	clickedTxnId = r.findElement(By.xpath("./td[3]")).getText().trim();
	            System.out.println("✅ Found Purchase ID: " +clickedTxnId);

	            // ✅ Click Action button from same row
	            WebElement actionBtn = r.findElement(By.xpath("./td[1]//button[@class='btn btn-white btnMargin11']/i"));
	            System.out.println("🛠 Clicking Action for Purchase ID: " +clickedTxnId);
	            actionBtn.click();

	            actionClicked = true;
	            break;
	        }
	    }

	    // ✅ Assert outside loop
	    Assert.assertTrue(actionClicked, "❌ No Action button clicked — all transactions were expired.");
	}



	
	public void verifyPurchaseIDOnActionPage() {

		
		
		String p= actionDriver.getText(lastAction_ID);
		String p_ID= p.split(":")[1].trim();
		
		System.out.println("p_ID:-"+p_ID);
		
		Assert.assertEquals(clickedTxnId,p_ID, "If Both purchase ID is not matching then our TC is Failed");

	}
	
	
	
	public void clickOnHistoryColumn(WebDriver driver) {
	    WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(15));
	    boolean actionClicked = false;

	    List<WebElement> rows = w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
	        By.xpath("//tbody[@id='analyticTransStats1']/tr")));

	    for (WebElement r : rows) {
	        // ✅ Get Last Status from the 10th column (relative to current row)
	        String statusText = r.findElement(By.xpath("./td[10]")).getText().trim();

	        if (!statusText.equalsIgnoreCase("EXPIRED")) {
	            // ✅ Get Purchase ID from 3rd column (Transaction ID)
	        	clickedTxn___Id = r.findElement(By.xpath("./td[3]")).getText().trim();
	            System.out.println("✅ Found clickedTxn___Id: " +clickedTxn___Id);

	            // ✅ Click History button (assuming 2nd button in 1st column)
	            WebElement historyBtn = r.findElement(By.xpath(".//button[@title='History']"));
	            System.out.println("🛠 Clicking History button for clickedTxn___ID: " +clickedTxn___Id);
	            historyBtn.click();

	            actionClicked = true;
	            break;
	        }
	    }

	    // ✅ Final assertion
	    Assert.assertTrue(actionClicked, "❌ No Action button clicked — all transactions were expired.");
	}


	
public void verifyPurchaseIDOnHistoryPage() {

	String p= actionDriver.getText(pid);
	String p_ID= p.split(":")[1].trim();
	
	System.out.println("p_ID:-"+p_ID);
	
	Assert.assertEquals(clickedTxn___Id,p_ID, "If Both purchase ID is not matching then our TC is Failed");

	}
	

}
