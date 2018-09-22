package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends PageObject {

	@FindBy(css = "h3[class='RTL']")
    private WebElement welcomeUser;
	
	@FindBy(xpath = "//div[@id='bookings']/div[@class='row'][1]/div[4]/a[contains(.,'Invoice')]")
    private WebElement invoice;
	
	public AccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeout), this);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3[class='RTL']")));
	}

	public String getWelcomeUser() {
		return welcomeUser.getText();
	}
	
	public InvoicePage ClickInvoice(int line) {
		this.invoice.click();
		return new InvoicePage(driver);
	}
}