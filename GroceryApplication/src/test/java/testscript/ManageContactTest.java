package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import mainProject.Base;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import utility.ExcelUtilities;

public class ManageContactTest extends Base {
	HomePage home ;
	ManageContactPage contact ;

	@Test(description="user is trying to edit contact us detail")
	public void verifyWhetherUserCanEditContactUsDetail() throws IOException {
		String usernameValue = ExcelUtilities.getStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtilities.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsername(usernameValue).enterPassword(passwordValue);
		home = login.clickSignInButton();
		
		
		contact = home.clickManageContactMoreInfoButton();
		
		
		
		
		String phoneValue = ExcelUtilities.getStringData(0, 0, "ManageContactUsPage");
		String emailValue = ExcelUtilities.getStringData(0, 1, "ManageContactUsPage");
		String addressValue = ExcelUtilities.getStringData(0, 2, "ManageContactUsPage");
		
		 contact.clickEditButton().enterPhone(phoneValue).enterEmail(emailValue).enterAddress(addressValue).clickUpdateButton();
		
		boolean alertValue = contact.isSuccessAlertDisplayed();
		Assert.assertTrue(alertValue,Constant.UNABLETOUPDATECONTACTERROR);
		
		
		
		
	}
}
