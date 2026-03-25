package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import mainProject.Base;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtilities;

public class HomeTest extends Base {
	HomePage home;
	
	
	@Test(description="user is trying to logout")
	public void verifyIfUserCanLogout() throws IOException
	{
		String usernameValue = ExcelUtilities.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtilities.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernameValue).enterPassword(passwordValue);
		home =login.clickSignInButton();
		
		home.clickAdminButton();
		login = home.clickLogoutButton();
		String expected = "7rmart supermarket";
		String actual = login.isTextDisplayed();
		Assert.assertEquals(actual, expected,Constant.LOGOUTERROR);
	}

}
