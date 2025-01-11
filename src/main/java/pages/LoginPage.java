package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods{
	@FindBy(xpath ="//input[@type='number']")
	WebElement LoginNumber;
	@FindBy(xpath ="//input[@type='password']")
	WebElement LoginPass;
	@FindBy(xpath ="//div[@data-testid='login-cta']")
	WebElement LoginButton;
	@FindBy(xpath ="//div[contains(text(),'Hi Prerna')]")
	WebElement LoginText;
	@FindBy(xpath="//div[contains(text(),'Please enter a valid email address')]")
	private WebElement loginErrortext;
	

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public LoginPage Enter_Number(String Number) {
		LoginNumber.sendKeys(Number);
		return this;
	}
	public LoginPage Enter_Password(String Password) {
		LoginPass.sendKeys(Password);
		return this;
	}
	public LoginPage Submit() {
		LoginButton.click();
		return this;
	}
	public LoginPage ValidateLogin(String credentialtype) {
		if (credentialtype=="Valid") {
			Assert.assertEquals(LoginText,"Hi Prerna");
		}else {
		String actualUrl="https://www.spicejet.com/"; 
		String expectedUrl= driver.getCurrentUrl(); 
		Assert.assertEquals(expectedUrl,actualUrl);
		}
		return this;
	}
}
