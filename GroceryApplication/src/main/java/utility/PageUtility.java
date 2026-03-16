package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public void selectDragDropWithValue(WebElement element, String value)
	{
		Select object = new Select(element);
		object.selectByValue(value);
	}
	
	public void selectDragDropWithIndex(WebElement element,  int index)
	{
		Select object = new Select(element);
		object.selectByIndex(index);
	}
	
	public void selectDragDropWithVisibleText(WebElement element, String text)
	{
		Select object = new Select(element);
		object.selectByContainsVisibleText(text);
	}
	
	public void clickUsingJavaScriptExecuter(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	}
	
	public void scrollWindow(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, 500)", "");
	}

}
