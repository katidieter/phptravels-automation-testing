package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import exception.BrowserException;

public class DriverManager {

    private WebDriver driver;

    public DriverManager(String browser) {
    	try {
			driver = selectDriver(browser);
		} catch (BrowserException e) {
            System.out.println("Browser:" +  browser + "\n" + e.getMessage());
       }
    }

    public WebDriver getDriver() {
        return  driver;
    }
    
    private static WebDriver selectDriver(String browser) throws BrowserException {
        WebDriver webDriver = null;

        	switch (browser.toLowerCase()) {
        		case "chrome":
        			webDriver = new ChromeDriver();
            		break;
        		case "firefox":
        			webDriver = new FirefoxDriver();
        		case "internetexplorer":
        			webDriver = new InternetExplorerDriver();
        		default:
        		throw new BrowserException("Browser " + browser + "not supported");
        	}    
       
        return webDriver;
    }
}
