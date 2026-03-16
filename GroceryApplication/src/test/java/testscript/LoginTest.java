package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constant;
import mainProject.Base;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtilities;

public class LoginTest extends Base {
	HomePage home;

	@Test(priority = 1, description = "User is trying to login with valid credentials", groups = { "smoke" })
	public void verifyWhetherUserIsAbleToLoginWithValidCredentials() throws IOException {
		String usernameValue = ExcelUtilities.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtilities.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernameValue).enterPassword(passwordValue);
		home = login.clickSignInButton();
		boolean dashboardValue = login.isDashboardDisplayed();
		Assert.assertTrue(dashboardValue, Constant.VALIDCREDENTIALERROR);
	}

	@Test(priority = 2, description = "User is trying to login with valid username and invalid password", retryAnalyzer = retry.Retry.class)
	public void verifyWhetherUserIsAbleToLoginWithInvalidCredentials() throws IOException {
		String usernameValue = ExcelUtilities.getStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtilities.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernameValue).enterPassword(passwordValue).clickSignInButton();
		String expected = "7rmart supermarket";
		String actual = login.isTextDisplayed();
		Assert.assertEquals(actual, expected, Constant.INVALIDCREDENTIALERROR);
	}

	@Test(priority = 3, description = "User is trying to login with invalid username and valid password")
	public void verifyWhetherUserIsAbleToLoginWithValidUsernameAndInvalidPassword() throws IOException {
		String usernameValue = ExcelUtilities.getStringData(2, 0, "LoginPage");
		String passwordValue = ExcelUtilities.getStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernameValue).enterPassword(passwordValue).clickSignInButton();
		String expected = "7rmart supermarket";
		String actual = login.isTextDisplayed();
		Assert.assertEquals(actual, expected,Constant.INVALIDCREDENTIALERROR);

	}

	@Test(priority = 4, description = "User is trying to login with invalid username and invalid password", groups = {
			"smoke" }, dataProvider = "loginProvider")
	public void verifyWhetherUserIsAbleToLoginWithInvalidUsernameAndValidPassword(String usernameValue,
			String passwordValue) throws IOException {
		// String usernamevalue = ExcelUtilities.getStringData(3, 0, "LoginPage");
		// passwordvalue = ExcelUtilities.getStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernameValue).enterPassword(passwordValue).clickSignInButton();
		String expected = "7rmart supermarket";
		String actual = login.isTextDisplayed();
		Assert.assertEquals(actual, expected, Constant.INVALIDCREDENTIALERROR);

	}

	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
				// new Object[] {
				// ExcelUtility.getStringData(0, "Login"),
				// ExcelUtility.getStringData(1, "Login")
				// }
		};
	}

}
