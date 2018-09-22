package test;

import page_objects.AccountPage;
import page_objects.HomePage;
import page_objects.InvoicePage;
import page_objects.LoginPage;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckInvoiceTest extends BaseTest {
	
	@DataProvider(name = "Invoice")
	 
	  public static Object[][] datas() {
	        return new Object[][] { { "user@phptravels.com", "demouser", "Rendezvous Hotel", "10/09/2018", "11/09/2018",
	        						  "114", "4259", new String[] { "CUSTOMER DETAILS", "JOHNY SMITH", "R2, AVENUE DU MAROC", "123456"},
	        						  "Junior Suites", "10/09/2018", "11/09/2018", new String[] {"1", "$250"}, "USD $27.50",
	        						  "USD $25", "USD $275"}};
	  }
	
	@Test(dataProvider = "Invoice")
	public void checkInvoiceTest(String username, String password, String hotelName, String invoiceDate, String dueDate,
								 String invoiceNumber, String bookingCode, String[] customerDetails, String room, String checkin,
								 String checkout, String[] totalStay, String depositeNow, String taxEVat, String totalAmount) {
		
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = homePage.accessLogin();
		AccountPage accountPage = loginPage.login(username, password);
		InvoicePage invoicePage = accountPage.ClickInvoice(1);
	    
		Assert.assertEquals(invoicePage.getHotelName(), hotelName);
		Assert.assertEquals(invoicePage.getInvoiceDate(), invoiceDate);
		Assert.assertEquals(invoicePage.getDueDate(), dueDate);
		Assert.assertEquals(invoicePage.getInvoiceNumber(), invoiceNumber);
		Assert.assertEquals(invoicePage.getBookingCode(), bookingCode);
		List<String> actualCustomerDetails = invoicePage.getCustomerDetails();
		for (int i=0; i < customerDetails.length; i++) {
			Assert.assertEquals(actualCustomerDetails.get(i), customerDetails[i]);	
		}
		Assert.assertEquals(invoicePage.getRoom(), room);
		Assert.assertEquals(invoicePage.getCheckin(), checkin);
		Assert.assertEquals(invoicePage.getCheckout(), checkout);
		
		List<String> actualTotalStay = invoicePage.getTotalStay();
		for (int i=0; i < totalStay.length; i++) {
			Assert.assertEquals(actualTotalStay.get(i), totalStay[i]);	
		}
		Assert.assertEquals(invoicePage.getDepositoNow(), depositeNow);
		Assert.assertEquals(invoicePage.getTaxEVat(), taxEVat);
		Assert.assertEquals(invoicePage.getTotalAmount(), totalAmount);
	}
}
