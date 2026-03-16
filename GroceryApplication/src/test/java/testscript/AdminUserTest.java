package testscript;

import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import mainProject.Base;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtilities;
import utility.RandomDataUtility;

public class AdminUserTest extends Base {
	HomePage home;
	AdminUserPage admin;
	
	@Test
	public void verifyWhetheUserCanCreateNewUser() throws IOException
	{
		String usernameValue = ExcelUtilities.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtilities.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernameValue).enterPassword(passwordValue);
		home = login.clickSignInButton();
		
		
		admin = home.clickAdminUsersMoreInfoButton();
		
		RandomDataUtility random = new RandomDataUtility();
		
		String newusernamevalue = random.randomUsername();
		String newpasswordvalue = random.randomPassword();
		
		admin.clickNewButton().enterUsername(newusernamevalue).enterPassword(newpasswordvalue).selectUserType().clickSaveButton();
		
		boolean alertValue = admin.isSuccessAlertDisplayed();
		Assert.assertTrue(alertValue,Constant.UNABLETOADDUSERERROR);
		
	}
	
	@Test
	public void verifyWhetheUserCanSearchAdminUser() throws IOException 
	{
		String usernameValue = ExcelUtilities.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtilities.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernameValue);
		login.enterPassword(passwordValue);
		home = login.clickSignInButton();
		
		
		admin = home.clickAdminUsersMoreInfoButton();
		
		String usernameForSearchValue = ExcelUtilities.getStringData(0, 0, "AdminUserPage");
		admin.clickSearchButton().enterUsernameForSearch(usernameForSearchValue).selectUserTypeForSearch().clickAdminUserSearchButton();
		
		String expected = "thaslima";
		String actual = admin.isUsername1Displayed();
		Assert.assertEquals(actual, expected,Constant.SEARCHERROR);
		
	}
	

}
