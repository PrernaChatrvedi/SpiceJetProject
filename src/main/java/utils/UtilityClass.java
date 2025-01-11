package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class UtilityClass {
	public static WebDriver driver;
	public String sheename;
	public static ExtentReports extent;
	public static ExtentTest test;
	public String testName, testDescription, testCategory, testAuthor;
	
	     public void browser_Launch() {
	    	ChromeOptions options = new ChromeOptions();
	    	options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		
		    Map<String, Object> prefs = new HashMap<String, Object>();
		    prefs.put("profile.default_content_setting_values.notifications", 2); 
		    options.setExperimentalOption("prefs", prefs);
		  
		  
			driver.get("https://www.spicejet.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
			
		}
	     public void close_Browser() {
	 		driver.close();
	 	}
		public static String[][] readExcel(String sheetName) throws Exception {
			
			XSSFWorkbook book = new XSSFWorkbook("F:\\C data\\eclipse-workspace\\SpiceJetPOM\\src\\test\\resources\\TestData\\TestData.xlsx");
			XSSFSheet sheet = book.getSheet(sheetName);	
			int rowCount = sheet.getLastRowNum();
			int columnCount = sheet.getRow(0).getLastCellNum();
		
			String[][] data = new String[rowCount][columnCount];
			for(int i =1 ; i <= rowCount; i++) {
				
				XSSFRow row = sheet.getRow(i);
				
				for(int j =0 ; j<columnCount; j++) {
					
					XSSFCell cell = row.getCell(j);
					data[i-1][j] = cell.getStringCellValue();
					
				}

			}
		
			book.close();	
			return data;
	}
		public  String screenshot(String name) throws IOException {
			String path="F:\\C data\\eclipse-workspace\\SpiceJetPOM\\Report\\Screenshots\\"+name+".png";
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest = new File(path);
			FileUtils.copyFile(src, dest);
			return path;
			
		}
	
}
