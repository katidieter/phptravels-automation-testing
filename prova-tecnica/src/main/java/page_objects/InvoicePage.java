package page_objects;


import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvoicePage extends PageObject{
	
	@FindBy(css = "#invoiceTable>tbody>tr:nth-child(4)>td>table>tbody>tr:nth-child(2)>td>table:nth-child(1)>tbody>tr:nth-child(1)>td:nth-child(1)")
    private WebElement hotelName;
	
	@FindBy(xpath = "//*[@id=\"invoiceTable\"]/tbody/tr[2]/td/div[1]/table/tbody/tr/td/div[1]")
    private WebElement invoiceDate;
	
	@FindBy(css = "#invoiceTable>tbody>tr:nth-child(2)>td>div:nth-child(1)>table>tbody>tr>td>div:nth-child(2)")
    private WebElement dueDate;
	
	@FindBy(css = "#invoiceTable>tbody>tr:nth-child(2)>td>div:nth-child(1)>table>tbody>tr>td>div:nth-child(4)")
    private WebElement invoiceNumber;
	
	@FindBy(css = "#invoiceTable>tbody>tr:nth-child(2)>td>div:nth-child(1)>table>tbody>tr>td>div:nth-child(5)")
    private WebElement bookingCode;
	
	@FindBy(css = "#invoiceTable>tbody>tr:nth-child(2)>td>div:nth-child(2)>table>tbody>tr>td>div")
    private  List<WebElement> custumerDetails;
	
	@FindBy(css = "")
    private WebElement room;
	
	@FindBy(css = "#invoiceTable>tbody>tr:nth-child(4)>td>table>tbody>tr:nth-child(2)>td>table:nth-child(1)>tbody>tr:nth-child(3) >td:nth-child(2)")
    private WebElement checkIn;
	
	@FindBy(css = "#invoiceTable>tbody>tr:nth-child(4)>td>table>tbody>tr:nth-child(2)>td>table:nth-child(1)>tbody>tr:nth-child(4)>td:nth-child(2)")
    private WebElement checkout;

	@FindBy(css = "#invoiceTable>tbody>tr:nth-child(4)>td>table>tbody>tr:nth-child(2)>td>table:nth-child(1)>tbody>tr:nth-child(5)>td")
    private  List<WebElement> totalStay;

	@FindBy(css = "#invoiceTable>tbody>tr:nth-child(4)>td>table>tbody>tr:nth-child(2)>td>table.table.table-bordered>tbody>tr>td:nth-child(1)")
    private WebElement depositeNow;
	
	@FindBy(css = "#invoiceTable>tbody>tr:nth-child(4)>td>table>tbody>tr:nth-child(2)>td>table.table.table-bordered>tbody>tr>td:nth-child(2)")
    private WebElement taxEVat;
	
	@FindBy(css = "#invoiceTable>tbody>tr:nth-child(4)>td>table>tbody>tr:nth-child(2)>td>table.table.table-bordered>tbody>tr>td:nth-child(3)")
    private WebElement totalAmout;

	public InvoicePage(WebDriver driver) {
    	super(driver);
    	PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeout), this);	
    	
    	for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
    	
    	WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(hotelName));
    }

    public String getHotelName() {
    	return this.hotelName.getText();
    }
    
    public String getInvoiceDate() {
    	return this.invoiceDate.getText();
    }
    
    public String getDueDate() {
    	return this.dueDate.getText();
    }

	public String getInvoiceNumber() {
		return this.invoiceNumber.getText();
	}

	public String getBookingCode() {
		return this.bookingCode.getText();
	}
	
	public List<String> getCustomerDetails() {
		List<String> details = new  ArrayList<String>();
		
		for (WebElement custumerDetail : this.custumerDetails)
         {
            details.add(custumerDetail.getText());
         }
		return details;
	}

	public String getRoom() {
		return this.room.getText();
	}
	
	public String getCheckin() {
		return this.checkIn.getText();
	}

	public String getCheckout() {
		return this.checkout.getText();
	}
	
	public List<String> getTotalStay() {
		List<String> totalStay = new  ArrayList<String>();
		
		for (WebElement info : this.totalStay)
         {
            totalStay.add(info.getText());
         }
		return totalStay;
	}

	public String getDepositoNow() {
		return this.depositeNow.getText();
	}

	public String getTaxEVat() {
		return this.taxEVat.getText();
	}

	public String getTotalAmount() {
		return this.totalAmout.getText();
	}
}
