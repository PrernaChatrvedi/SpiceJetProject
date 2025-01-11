package base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.UtilityClass;

public class ProjectSpecificMethods extends UtilityClass{
	@BeforeSuite
	public void reportInitilization() {
		
		String path="F:\\C data\\eclipse-workspace\\SpiceJetPOM\\Report\\SpicejetReport.html";
		// To create report in the given location
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Spicejet Report");
		// To capture test data
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	@BeforeClass
	public void testDetails() {
		test = extent.createTest(testName,testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
	}
	@BeforeMethod
	public void lunchBrowser() {
		browser_Launch();
		
	}
	
	@DataProvider(name ="readData")
	public String[][] readData() throws Exception {
		String[][] data =readExcel(sheename);
		return data;
	}
	@AfterMethod
	public void closeBrowser() {
		close_Browser();
	}
	
	@AfterSuite
	public void reportClose() {
		extent.flush();
		
	}
	

}
