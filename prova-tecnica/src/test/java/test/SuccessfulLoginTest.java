package test;

import page_objects.AccountPage;
import page_objects.HomePage;
import page_objects.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import org.testng.Assert;

public class SuccessfulLoginTest extends BaseTest {
	
	@DataProvider(name = "Authentication")
	 
	  public static Object[][] credentials() {
	        return new Object[][] { { "user@phptravels.com", "demouser", "Johny Smith" }};
	  }
	
	@Test(dataProvider = "Authentication")
    public void successfulLogin(String username, String password, String name) {
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = homePage.accessLogin();
		AccountPage accountPage = loginPage.login(username, password);
		Assert.assertEquals(accountPage.getWelcomeUser(), "Hi, " + name);
    }
}
