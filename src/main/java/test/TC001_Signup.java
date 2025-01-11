package test;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.ProjectSpecificMethods;
import pages.HomePage;

public class TC001_Signup extends ProjectSpecificMethods{
	@BeforeTest
	public void setup() throws IOException {
		testName = "SignupPageValidation";
		testDescription ="Testing login functionality with the help of excelsheet";
		testCategory ="Functional Testing";
		testAuthor ="Prerna Chaturvedi";	
	}
	@Test
	public void SignupTest() throws IOException {
		HomePage obj = new HomePage(driver);
		obj.click_signup()
		.Validate_SignupPageTitle()
		.Select_title()
		.Enter_FirstName()
		.Enter_LastName()
		.Select_country()
		.Enter_DateOfBirth()
		//.ScrollDown()
		.Enter_Phone()
		.Enter_Email()
		.Enter_Pass()
		.Enter_CPass()
		.Enter_CheckBox()
		.Submit()
		.screenshot(testName);
}
}