package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {

	public static final ExtentReports extentReports = new ExtentReports(); //object created for extendReports class
 
			
		public synchronized static ExtentReports createExtentReports()
		{
			ExtentSparkReporter reporter = new  ExtentSparkReporter("./extent-reports/extent-report.html");//to get projects local path we use ./
			reporter.config().setReportName("7RMartSuperMarketProject");
			extentReports.attachReporter(reporter);
			
			extentReports.setSystemInfo("Organization","Obsqura");
			extentReports.setSystemInfo("Name","Thaslima");
			return extentReports;

		}
			
}
