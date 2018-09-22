package test;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import static utils.CommonUtils.getValueFromConfigFile;

public class BaseTest {
	
	protected WebDriver driver;
	
	public BaseTest() {
		createDriver();
	}
	
	private void createDriver() {
		DriverManager driverManager = new DriverManager("chrome");
	    this.driver = driverManager.getDriver();
	}

    @BeforeMethod
    
    public void preCondition() {
    	if (driver == null) {
    		createDriver();
    	}
       driver.manage().window().maximize();
       driver.navigate().to(getValueFromConfigFile("url.base"));
    }

    @AfterMethod
    public void postCondition() {
    	 if (driver == null) {
    	        return;
    	    }
    	 driver.quit();
    	 driver = null;
    }
}
