package test;

import page_objects.HomePage;
import page_objects.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import org.testng.Assert;

public class UnsuccessfulLogin extends BaseTest {
	
	@DataProvider(name = "FailAuthentication")
	 
	  public static Object[][] credentials() {
	        return new Object[][] { { "user@phptravels.com", "Demouser" },
	        						{ "user@phptravels.com", "demouser_"},
	        						{ "user@phptravels.com.br", "demouser"},
	        						{ "_user@phptravels.com", "Demouser"}};
	  }
	
	@Test(dataProvider = "FailAuthentication")
    public void unsuccessfulLogin(String username, String password) {
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = homePage.accessLogin();
		loginPage.login(username, password);
		Assert.assertEquals(loginPage.getErrorText(), "Invalid Email or Password");
    }
}
