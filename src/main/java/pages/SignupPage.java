package pages;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.Alert;

import base.ProjectSpecificMethods;

public class SignupPage extends ProjectSpecificMethods{
	@FindBy(xpath ="//div[@class='col-sm-4 mt-2 px-sm-4']//select[contains(@class,'form-control form-select')]")
	WebElement SelectTitle;
	@FindBy(xpath ="//input[@id='first_name']")
	WebElement SelectFirstName;
	@FindBy(xpath ="//input[@id='last_name']")
	WebElement SelectLastName;
	@FindBy(xpath ="//select[@class='form-control form-select']")
	WebElement SelectCountry;
	@FindBy(xpath ="//img[@alt='date']")
	WebElement SelectDateOfBirth;
	@FindBy(xpath ="//select[@class='react-datepicker__year-select']")
	WebElement SelectYear;
	@FindBy(xpath ="//select[@class='react-datepicker__month-select']")
	WebElement SelectMonth;
	@FindBy(xpath ="//input[@class=' form-control']")
	WebElement SelectPhoneNumber;
	@FindBy(xpath ="//input[@id='email_id']")
	WebElement SelectEmailId;
	@FindBy(xpath ="//input[@id='new-password']")
	WebElement SelectPassword;
	@FindBy(xpath ="//input[@id='c-password']")
	WebElement SelectConfirmPassword;
	@FindBy(xpath ="//input[@id='defaultCheck1']")
	WebElement SelectCheckbox;
	@FindBy(xpath ="//button[@type='button']")
	WebElement Submit;
	
	public SignupPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public SignupPage Validate_SignupPageTitle() {
		String actualtitle = driver.getTitle();
		System.out.println(actualtitle);
		String expectedtitle = "SpiceClub - The frequent flyer program of SpiceJet";
		Assert.assertEquals(actualtitle, expectedtitle);
		return this;
	}
	public SignupPage Select_title() {
		Select objSelect = new Select(SelectTitle);
		objSelect.selectByValue("MS");
		return this;
	}
	public SignupPage Enter_FirstName() {
		SelectFirstName.sendKeys("Prerna");
		return this;
	}
	public SignupPage Enter_LastName() {
		SelectLastName.sendKeys("Chaturvedi");
		return this;
	}
	public SignupPage Select_country() {
		Select objSelect = new Select(SelectCountry);
		objSelect.selectByVisibleText("India");
		return this;
	}
	public SignupPage Enter_DateOfBirth() {
		SelectDateOfBirth.click();
		Select year = new Select(SelectYear);
		year.selectByVisibleText("2000");
		
		Select month = new Select(SelectMonth);
		month.selectByVisibleText("November");
		
		List<WebElement> days = driver.findElements(By.xpath("//div[@role='button']")); 
        for (WebElement day : days) {
            if (day.getText().equals("27")) { 
                day.click();
                break;
            }
        }
		return this;
	}
	public SignupPage ScrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		return this;
	}
	public SignupPage Enter_Phone() {
		SelectPhoneNumber.sendKeys("9713955727");
		return this;
	}
	public SignupPage Enter_Email() {
		SelectEmailId.sendKeys("prerna27chaturvedi@gmail.com");
		return this;
	}
	public SignupPage Enter_Pass() {
		SelectPassword.sendKeys("Tata@1234");
		return this;
	}
	public SignupPage Enter_CPass() {
		SelectConfirmPassword.sendKeys("Tata@1234");
		return this;
	}
	public SignupPage Enter_CheckBox() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(SelectCheckbox));
		SelectCheckbox.click();
		return this;
	}
	public SignupPage Submit() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(Submit));
		Submit.click();
		return this;
	}
}
