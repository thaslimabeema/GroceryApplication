package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {
	public void getScreenshot(WebDriver driver, String failedTestCase) throws IOException  // String failedTestCase stores method name of failed testcase
	{
		TakesScreenshot scrShot = (TakesScreenshot) driver; //TakesScreenshot is an interface. here we are calling the interface.screenshot is captured now
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE); //temporarily we will store the captures ss in the file
		
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date()); //inorder to store timestamp
		
		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenshot"); //(System.getProperty("user.dir") this is called to fetch projects current local path 
																				 //OutputScreenshot folder would be created
		if(!f1.exists()) //if not created via above method,create via mkdirs
		{
			f1.mkdirs();
		}
		
		String destination = System.getProperty("user.dir") + "//OutputScreenshot//" + failedTestCase + timeStamp + ".png"; // how should the file name be saved
		//System.getProperty("user.dir") to fetch projects local directory
		File finalDestination = new File(destination);
		FileHandler.copy(screenShot, finalDestination);
		
	}

}
