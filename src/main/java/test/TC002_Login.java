package test;
import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.ProjectSpecificMethods;
import pages.HomePage;

public class TC002_Login extends ProjectSpecificMethods{
	@BeforeTest
	public void setup() throws IOException {
		sheename ="Login";
		testName = "LoginValidation";
		testDescription ="Testing login functionality with the help of excelsheet";
		testCategory ="Functional Testing";
		testAuthor ="Prerna Chaturvedi";	
	}
	@Test(dataProvider = "readData")
	public void LoginTestWithValidcredentials(String Number, String Password, String credentialtype) throws IOException {
		HomePage obj = new HomePage(driver);
		obj.click_login()
		.Enter_Number(Number)
		.Enter_Password(Password)
		.Submit()
		.ValidateLogin(credentialtype)
		.screenshot(testName);
	}
	
	
}
