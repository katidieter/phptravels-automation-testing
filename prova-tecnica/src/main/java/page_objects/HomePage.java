package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageObject{

	@FindBy(xpath = "//nav//*[@id='li_myaccount']/a")
    private WebElement myAccount;
	
    public HomePage(WebDriver driver) {
    	super(driver);
    	PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeout), this);
    }

    public void clickMyAccount() {
    	this.myAccount.click();
     }

    public void clickLogin() {
    	WebElement login = driver.findElement(By.xpath("//nav//*[@id='li_myaccount']/ul/li/a[text()=' Login']"));
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(login)).click();
    }    
    
    public LoginPage accessLogin() {
		clickMyAccount();
		clickLogin();
		return new LoginPage(driver);
    }
}
