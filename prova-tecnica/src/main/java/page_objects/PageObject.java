package page_objects;

import static utils.CommonUtils.getValueFromConfigFile;
import java.util.Objects;
import org.openqa.selenium.WebDriver;


public class PageObject {
	
	protected WebDriver driver;
	protected int timeout;
	
	public PageObject(WebDriver driver) {
		this.driver = driver;
		this.timeout = Integer.parseInt(Objects.requireNonNull(getValueFromConfigFile("timeout")));
	}

}