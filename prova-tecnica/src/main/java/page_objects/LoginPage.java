package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends PageObject{
	
	@FindBy(name = "username")
    private WebElement userName;
    
	@FindBy(name = "password")
    private WebElement password;
	
	@FindBy(xpath = "//button[contains(.,'Login')]")
    private WebElement loginButton;
	
	@FindBy(xpath = "//div[@class='alert alert-danger']")
	private WebElement error; 
	
    public LoginPage(WebDriver driver) {
    	super(driver);
    	PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeout), this);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[contains(.,'Login')]")));
    }
    
    public void enterUsername(String username) {
    	this.userName.clear();
    	this.userName.sendKeys(username); 
    }

	public void enterPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}

	public AccountPage ClickLogin() {
		loginButton.click();
		return new AccountPage(driver);
	}
	
	public boolean isErrorVisible() {
		return error.isDisplayed();
	}
	
	public String getErrorText() {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger']")));
		return error.getText();
	}
	
	public AccountPage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        return ClickLogin();
	}
}
