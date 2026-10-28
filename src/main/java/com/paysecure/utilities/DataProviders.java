package com.paysecure.utilities;

import java.util.Arrays;
import java.util.List;
//hsgd kkqx jjho zghz
import org.testng.annotations.DataProvider;

import com.paysecure.base.baseClass;

public class DataProviders {

	@DataProvider(name = "cardNames")
	public Object[][] getCardNames() {
		return new Object[][] {

				{ "52000000****0015" }
//
//				{ "55320440****4659" },
//
//				{ "54312400****4007" },
//
//				{ "52000000****0015" },

		};
	}

	@DataProvider(name = "EmailID")
	public Object[][] getEmailID() {
		return new Object[][] { 
			//{ "tw*@m*********. ..." },

				{ "aj******0@g**** ..." }

//				{ "cu*****r@e****. ..." }, { "te*****9@g****. ..." }, { "lo*********1@g* ..." }
		};
	}

	@DataProvider(name = "expectedHeadersProvider")
	public Object[][] expectedHeadersProvider() {
		return new Object[][] {
				{ Arrays.asList("DATE", "BANK NAME", "TRANSACTION ID", "MERCHANT NAME", "TRANSACTION PROCESS TIME") } };
	}

	@DataProvider(name = "HeadersProvider")
	public Object[][] expectedHeadersProvider_APILog() {
		return new Object[][] { { Arrays.asList("DATE", "API PARAMETER", "RESPONSE", "REDIRECT API") } };
	}

	@DataProvider(name = "Headers")
	public Object[][] expectedHeadersProvider_transactionLog() {
		return new Object[][] { { Arrays.asList("DATE", "PURCHASE ID", "TEXT") } };
	}

	@DataProvider(name = "usernameTestData")
	public Object[][] getUsernameTestData() {
		return new Object[][] { { "", "This field is required",
				"//input[@id='username1']/following-sibling::span[contains(normalize-space(), 'field is required')]" },
				{ "abc", "Username should be min 5 character", "(//span[@class='text-danger'])[1]" },
				{ "abc der", "Space not allowed",
						"//input[@id='username1']/following-sibling::span[contains(normalize-space(), 'not allowed')]" } };
	}

	@DataProvider(name = "passwordTestData")
	public Object[][] getPasswordTestData() {
		return new Object[][] { { "", "This field is required",
				"//input[@id='password1']/ancestor::div[@class='form-group col-md-12']/div/following-sibling::span" },
				{ "a", "At least one small and one capital letter, one digit, one special character",
						"//input[@id='password1']/ancestor::div[@class='form-group col-md-12']//span[contains(normalize-space(), 'one small and one capital letter')]" },
				{ "a  r", "Space not allowed", "(//span[@class='text-danger ng-scope'])[3]" } };

	}

	@DataProvider(name = "emailIDTestData")
	public Object[][] emailProvider() {

		String requiredLocator = "//input[@id='emailaddress1']/following-sibling::span"
				+ "[contains(normalize-space(),'field is required')]";
		String invalidLocator = "//input[@id='emailaddress1']/following-sibling::span"
				+ "[contains(normalize-space(),'Email address')]";

		List<String> invalidEmails = Arrays.asList(

				"suhas@.com", "@gmail.com", "suhas@", "suhas", "suhas@ gmail.com", "suhas @gmail.com",
				"suhas@gmail..com", "suhas@gmail.c", "suhas@gmail,com", "suhas@#mail.com", "suhas@@gmail.com",
				".suhas@gmail.com", "suhas.@gmail.com", "suhas..patil@gmail.com", "suhas@-gmail.com",
				"suhas@gmail-.com", "suhas@.gmail.com", "suhas@g_mail.com");

		/* +1 row for the “required” test case */
		Object[][] data = new Object[invalidEmails.size() + 1][3];

		// row 0 → required‑field case
		data[0] = new Object[] { "", "This field is required", requiredLocator };

		// the rest → invalid formats
		for (int i = 0; i < invalidEmails.size(); i++) {
			data[i + 1] = new Object[] { invalidEmails.get(i), "Invalid Email address", invalidLocator };
		}
		return data;
	}

	@DataProvider(name = "status")
	public Object[][] getStatus() {
		return new Object[][] { { "Error" }, { "Expired" }, { "Created" }, { "Payment_in_process" },

		};
	}

	@DataProvider(name = "status_PRC")
	public Object[][] getStatus_Paid_Refunded_Chargeback() {
		return new Object[][] {

				{ "Paid" }, { "Refunded" }, { "Chargeback" } };
	}

	@DataProvider(name = "bankName") // ✅ matches Test
	public Object[][] getbankName() {
		return new Object[][] { { "a55" }, { "a55pix" }, { "a55pixpayout" } };
	}

	@DataProvider(name = "cardName")
	public Object[][] getCreditCard() {
		return new Object[][] {

				{ "49004900****0618" },

				{ "MOBILEMONEY" },

				{ "PAYID" },

				{ "BANKTRANSFER" },

				{ "52000000****0015" },

		};
	}

	@DataProvider(name = "cardNameText")
	public Object[][] getCreditCardText() {
		return new Object[][] {

				{ "SPEI" },

				{ "PAYID" },

		};

	}

	@DataProvider(name = "statusAction")
	public Object[][] Laststatus() {
		return new Object[][] {

				{ "Created" },

				{ "Pendingexecute" }, { "Payment_in_process" }, { "Paid" }, { "Viewed" }, { "Refunded" },

		};

	}

	@DataProvider(name = "Roles") // ✅ matches Test
	public Object[][] displayByRole_AdminPage() {
		return new Object[][] { { "SUPERADMIN" }, { "MERCHANT" }, { "P2PMERCHANT" }, { "AGENT" }, { "WHITELABEL" },
				{ "P2PAGENT" }, { "P2PMERCHANT" }, { "REPORTADMIN" }, { "ADMIN" }, { "MIDADMIN" }, { "ACCOUNTADMIN" },
				{ "FULLADMIN" }, { "WHITELABELMERCHANT" }

		};
	}

	@DataProvider(name = "statusAndDateRange")
	public Object[][] getData() {
		return new Object[][] {

				{ "Paid", "Today" }, { "Paid", "Yesterday" }, { "Paid", "Last 7 Days" }, { "Paid", "This Week" },
				{ "Paid", "Last 30 Days" }, { "Paid", "Last Month" }, { "Paid", "This Month" }, { "Expired", "Today" },
				{ "Expired", "Yesterday" }, { "Expired", "Last 7 Days" }, { "Expired", "This Week" },
				{ "Expired", "Last 30 Days" }, { "Expired", "Last Month" }, { "Expired", "This Month" },
				{ "Error", "Today" }, { "Error", "Yesterday" }, { "Error", "Last 7 Days" }, { "Error", "This Week" },
				{ "Error", "Last 30 Days" }, { "Error", "Last Month" }, { "Error", "This Month" },
				{ "Refunded", "Today" }, { "Refunded", "Yesterday" }, { "Refunded", "Last 7 Days" },
				{ "Refunded", "This Week" }, { "Refunded", "Last 30 Days" }, { "Refunded", "Last Month" },
				{ "Refunded", "This Month" }, { "Overdue", "Today" }, { "Overdue", "Yesterday" },
				{ "Overdue", "Last 7 Days" }, { "Overdue", "This Week" }, { "Overdue", "Last 30 Days" },
				{ "Overdue", "Last Month" }, { "Overdue", "This Month" }, { "Payment_in_process", "Today" },
				{ "Payment_in_process", "Yesterday" }, { "Payment_in_process", "Last 7 Days" },
				{ "Payment_in_process", "This Week" }, { "Payment_in_process", "Last 30 Days" },
				{ "Payment_in_process", "Last Month" }, { "Payment_in_process", "This Month" }, { "Created", "Today" },
				{ "Created", "Yesterday" }, { "Created", "Last 7 Days" }, { "Created", "This Week" },
				{ "Created", "Last 30 Days" }, { "Created", "Last Month" }, { "Created", "This Month" },

		};
	}

	@DataProvider(name = "statusAndDateRangeMerchant")
	public Object[][] GETStatusDateMerchant() {

		String z = baseClass.getProp().getProperty("merchantName");

		return new Object[][] {
			{ "Paid", "Today", z }, 
			{ "Paid", "Yesterday", z }, 
			{ "Paid", "Last 7 Days", z },
				{ "Paid", "This Week", z }, { "Paid", "Last 30 Days", z }, { "Paid", "Last Month", z },
		
				
				{ "Paid", "This Month", z }, { "Expired", "Today", z }, { "Expired", "Yesterday", z },
				{ "Expired", "Last 7 Days", z }, { "Expired", "This Week", z }, { "Expired", "Last 30 Days", z },
				{ "Expired", "Last Month", z }, { "Expired", "This Month", z }, { "Error", "Today", z },
			{ "Error", "Yesterday", z },
			{ "Error", "Last 7 Days", z }, { "Error", "This Week", z },
				{ "Error", "Last 30 Days", z }, { "Error", "Last Month", z }, { "Error", "This Month", z },
				{ "Refunded", "Today", z }, { "Refunded", "Yesterday", z }, { "Refunded", "Last 7 Days", z },
				{ "Refunded", "This Week", z }, { "Refunded", "Last 30 Days", z }, { "Refunded", "Last Month", z },
				{ "Refunded", "This Month", z }, { "Overdue", "Today", z }, { "Overdue", "Yesterday", z },
				{ "Overdue", "Last 7 Days", z }, { "Overdue", "This Week", z }, { "Overdue", "Last 30 Days", z },
				{ "Overdue", "Last Month", z }, { "Overdue", "This Month", z }, { "Payment_in_process", "Today", z },
				{ "Payment_in_process", "Yesterday", z }, { "Payment_in_process", "Last 7 Days", z },
				{ "Payment_in_process", "This Week", z }, { "Payment_in_process", "Last 30 Days", z },
				{ "Payment_in_process", "Last Month", z }, { "Payment_in_process", "This Month", z },
				{ "Created", "Today", z }, { "Created", "Yesterday", z }, { "Created", "Last 7 Days", z },
				{ "Created", "This Week", z }, { "Created", "Last 30 Days", z }, { "Created", "Last Month", z },
				{ "Created", "This Month", z },
				// {"", ""}
		};
	}

	@DataProvider(name = "dateFilter")
	public Object[][] DateFilter() {

		return new Object[][] {

				{ "today" },

		//		{ "Yesterday" }, { "Last7Days" }, { "ThisWeek" }, { "Last30Days" }, { "ThisMonth" }, { "LastMonth" }

		};

	}

	@DataProvider(name = "bankMidDateMerchant")
	public Object[][] SelectBankMidAndDateMerchant() {

		String bank = baseClass.getProp().getProperty("BankName");
		String mid = baseClass.getProp().getProperty("BankMid");
		String MerchantName = baseClass.getProp().getProperty("merchantName");

		return new Object[][] {

				{ MerchantName, "Today", bank, mid },

				{ MerchantName, "Yesterday", bank, mid }, { MerchantName, "Last 7 Days", bank, mid },
				{ MerchantName, "This Week", bank, mid }, { MerchantName, "Last 30 Days", bank, mid },
				{ MerchantName, "This Month", bank, mid }, { MerchantName, "Last Month", bank, mid }

		};

	}

	@DataProvider(name = "bankMidDate")
	public Object[][] SelectBankMidAndDate() {

		String bank = baseClass.getProp().getProperty("BankName");
		String mid = baseClass.getProp().getProperty("BankMid");

		return new Object[][] {

				{ "Today", bank, mid },

				{ "Yesterday", bank, mid }, { "Last 7 Days", bank, mid }, { "This Week", bank, mid },
				{ "Last 30 Days", bank, mid }, { "This Month", bank, mid }, { "Last Month", bank, mid }

		};

	}

	@DataProvider(name = "bankMid")
	public Object[][] bankMidSelect() {
		return new Object[][] {

				{ "paysafe", "paysafeMid" },

		};

	}

	@DataProvider(name = "daterangeWithMerchantName")
	public Object[][] SelectMerchantAndDateRange() {

		String MerchantName = baseClass.getProp().getProperty("merchantName");

		return new Object[][] {

				{ "Today", MerchantName },

				{ "Yesterday", MerchantName }, { "Last 7 Days", MerchantName }, { "This Week", MerchantName },
				{ "Last 30 Days", MerchantName }, { "This Month", MerchantName }, { "Last Month", MerchantName }

		};

	}

	@DataProvider(name = "StatusWithMerchantName")
	public Object[][] selectStatusAndMerchant() {

		String MerchantName = baseClass.getProp().getProperty("merchantName");

		return new Object[][] {

				{ "Cancelled", MerchantName },

				{ "Created", MerchantName }, { "Error", MerchantName }, { "Expired", MerchantName },
				{ "Overdue", MerchantName }, { "Paid", MerchantName }, { "Payment_in_process", MerchantName }

		};

	}

	@DataProvider(name = "daterange")
	public Object[][] SelectDateRange() {

		return new Object[][] {

				{ "Today" },

				{ "Yesterday" }, { "Last 7 Days" }, { "This Week" }, { "Last 30 Days" }, { "This Month" },
				{ "Last Month" }

		};

	}
	
	@DataProvider(name = "merchantName")
	public Object[][] getMerchantnameD() {
		return new Object[][] { 
			{"gouris"},
			{"suhasm"}
		};
	}

}
