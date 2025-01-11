package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods{
	@FindBy(xpath ="//div[contains(text(),'Signup')]")
	WebElement Signup;
	@FindBy(xpath ="//div[contains(text(),'Login')]")
	WebElement Login;
	
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public SignupPage click_signup() {
		Signup.click();
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> AllWindowHandles = driver.getWindowHandles();
		Iterator<String> iterator = AllWindowHandles.iterator();
		while(iterator.hasNext()) {
			String childWindow = iterator.next();
			if(!mainWindowHandle.equals(childWindow)) {
				driver.switchTo().window(childWindow);
			}
		}
		return new SignupPage(driver);
	}
	public LoginPage click_login() {
		Login.click();
		return new LoginPage(driver);
	}
	
	
	
	
}
