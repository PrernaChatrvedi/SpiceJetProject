package pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.ProjectSpecificMethods;

public class BookingPage extends ProjectSpecificMethods{
	
	@FindBy(xpath = "//div[@data-testid='one-way-radio-button']")
	WebElement OneWay;
	@FindBy(xpath = "//div[contains(text(),'Welcome aboard')]")
	WebElement BookingPageText;
	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement Source;
	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement Destination;
	@FindBy(xpath = "//div[@class='css-76zvg2 r-jwli3a r-ubezar r-16dba41']")
	WebElement DateForDeparture;
	//@FindBy(xpath = "//div[text()='Return Date']")
	@FindBy(xpath = "//div[@data-testid='return-date-dropdown-label-test-id']")
	WebElement ReturnDate;
	@FindBy(xpath = "//div[contains(text(),'Passengers')]")
	WebElement Passengers;
	@FindBy(xpath = "//div[@data-testid='Adult-testID-plus-one-cta']")
	WebElement Adult;
	@FindBy(xpath = "//div[@data-testid='Children-testID-plus-one-cta']")
	WebElement Children;
	@FindBy(xpath = "//div[@data-testid='home-page-flight-cta']")
	WebElement SearchFlight;
	@FindBy(xpath = "//div[contains(text(),'Please search again with a different date.')]")
	WebElement SearchResult;
	@FindBy(xpath = "//div[contains(text(),'round trip')]")
	WebElement RoundTrip;
	@FindBy(xpath = "//div[@class='css-76zvg2 r-jwli3a r-ubezar r-16dba41'][text()='29']")
	WebElement SelectReturnDate;
	@FindBy(xpath = "(//div[contains(text(),'check-in')])[1]")
	WebElement CheckIn;
	@FindBy(xpath = "(//div[contains(text(),'flight status')])[1]")
	WebElement FlightStatus;
	@FindBy(xpath = "(//div[contains(text(),'manage booking')])[1]")
	WebElement ManageBooking;
	@FindBy(xpath = "//span[contains(text(),'One Way :')]")
	WebElement OneWayText;
	@FindBy(xpath = "//span[contains(text(),'Round Trip :')]")
	WebElement RoundWayText;
	@FindBy(xpath = "//div[@data-testid='continue-search-page-cta']")
	WebElement Continue;
	@FindBy(xpath = "//div[contains(text(),'Passengers')]")
	WebElement PassengerPage;
	//@FindBy(xpath = "//div[@data-testid='title-contact-detail-card']")
	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'])[1]")
	WebElement Title;
	@FindBy(xpath = "//div[contains(text(),'Miss')]")
	WebElement TitleMiss;
	@FindBy(xpath = "(//div[@class='css-76zvg2 r-homxoj r-poiln3 r-ubezar'])[3]")
	WebElement TitleMisss;
	@FindBy(xpath = "//input[@data-testid='first-inputbox-contact-details']")
	WebElement FirstName;
	@FindBy(xpath = "//input[@data-testid='last-inputbox-contact-details']")
	WebElement LastName;
	@FindBy(xpath = "//input[@data-testid='contact-number-input-box']")
	WebElement PhoneNumber;
	@FindBy(xpath = "//input[@data-testid='emailAddress-inputbox-contact-details']")
	WebElement Email;
	@FindBy(xpath = "//div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-tmtnm0 r-1777fci r-ymttw5 r-5njf8e r-1otgn73 r-13qz1uu']")
	WebElement Country;
	@FindBy(xpath = "//input[@data-testid='city-inputbox-contact-details']")
	WebElement City;
	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep'])[4]")
	WebElement FirstPassengerTitle;
	@FindBy(xpath = "//input[@data-testid='traveller-0-first-traveller-info-input-box']")
	WebElement FirstPassengerFirstName;
	@FindBy(xpath = "//input[@data-testid='traveller-0-last-traveller-info-input-box']")
	WebElement FirstPassengerLastName;
	@FindBy(xpath = "//input[@data-testid='sc-member-mobile-number-input-box']")
	WebElement FirstPassengerPhone;
	@FindBy(xpath = "//div[contains(text(),'Next')]")
	WebElement Next;
	@FindBy(xpath = "//div[@data-testid='traveller-info-continue-cta']")
	WebElement ContinueWithBooking;
	@FindBy(xpath = "//div[@data-testid='add-ons-continue-footer-button']")
	WebElement ContinueForPayment;
	@FindBy(xpath = "//*[name()='polygon' and @id='close']")
	WebElement Close;
	@FindBy(xpath = "//div[text()='Payment']")
	WebElement PaymentPage;
	@FindBy(xpath = "//input[@id='card_number']")
	WebElement CardNumber;
	@FindBy(xpath = "//input[@id='name_on_card']")
	WebElement NameOnCard;
	@FindBy(xpath = "//input[@id='card_exp_month']")
	WebElement MonthOnCard;
	@FindBy(xpath = "//input[@id='card_exp_year']")
	WebElement YearOnCard;
	@FindBy(xpath = "//input[@id='security_code']")
	WebElement CVV;
	
	public BookingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public BookingPage Select_Source() {
		Source.sendKeys("BOM");
		return this;
	}
	public BookingPage Select_Destination() {
		Destination.sendKeys("DEL");
		return this;
	}
	public BookingPage OneWaySelect() {
		if (OneWay.isSelected()) {
			System.out.println("Radio button is selected");
		}else{
			System.out.println("Radio button is not selected");
			 }
		return this;
	}
	public BookingPage ValidateBookingPage() {
		String text = BookingPageText.getText();
		Assert.assertEquals(text,"Welcome aboard");
		return this;
	}
	public BookingPage Select_DateForDeparture() {
		String expecteddate = "15";
		String expectedmonth = "January 2025";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)", "");
		while(true) {
			String actualmonth = driver.findElement(By.xpath("(//div[contains(text(),'January ')])[1]")).getText();
			System.out.println(actualmonth);
			if(expectedmonth.contains(actualmonth)) {
				break;
			}else {
				driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1loqt21 r-u8s1d r-11xbo3g r-1v2oles r-1otgn73 r-16zfatd r-eafdt9 r-1i6wzkk r-lrvibr r-184en5c']//*[name()='svg']//*[name()='g' and contains(@fill,'none')]//*[name()='circle' and contains(@cx,'24.5')]")).click();
			}
		}
		driver.findElement(By.xpath("//div[text()='"+expecteddate+"']")).click();
		return this;
	}
	public void visibilityOfElement(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	public BookingPage Select_DateForReturn(){
		String expecteddate = "29";
		String expectedmonth = "January 2025";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ReturnDate));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)", "");
		while(true) {
			String actualmonth = driver.findElement(By.xpath("(//div[contains(text(),'January ')])[1]")).getText();
			System.out.println(actualmonth);
			if(expectedmonth.contains(actualmonth)) {
				break;
			}else {
				driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1loqt21 r-u8s1d r-11xbo3g r-1v2oles r-1otgn73 r-16zfatd r-eafdt9 r-1i6wzkk r-lrvibr r-184en5c']//*[name()='svg']//*[name()='g' and contains(@fill,'none')]//*[name()='circle' and contains(@cx,'24.5')]")).click();
			}
		}
		driver.findElement(By.xpath("//div[text()='"+expecteddate+"']")).click();
		return this;
	}
	public BookingPage Click_Passenger() {
		Passengers.click();
		return this;
	}
	public BookingPage Select_Passengers() {
		Adult.click();
		Children.click();
		return this;
	}
	public BookingPage SearchFlight() {
		SearchFlight.click();
		return this;
	}
	public BookingPage ValidateStatus() {
		String ActualResult=OneWayText.getText();
		System.out.println(ActualResult);
		Assert.assertEquals(ActualResult, "One Way :");
		return this;
	}
	public BookingPage ValidateStatusForRoundTrip() {
		String ActualResult=RoundWayText.getText();
		System.out.println(ActualResult);
		Assert.assertEquals(ActualResult, "Round Trip :");
		return this;
	}
	public BookingPage Select_RoundTrip() {
		RoundTrip.click();
		return this;
	}
	public BookingPage Continue() {
		if(Continue.isDisplayed()) {
		Continue.click();
		}else {
			System.out.println("No Flights available");
		}
		return this;
	}
	public BookingPage Validate_CheckIn() {
		String ActualText=CheckIn.getText();
		System.out.println(ActualText);
		Assert.assertEquals(ActualText, "Check-In");
		return this;
	}
	public BookingPage Validate_FlightStatus() {
		String ActualText=FlightStatus.getText();
		System.out.println(ActualText);
		Assert.assertEquals(ActualText, "Flight Status");
		return this;
	}
	public BookingPage Validate_ManageBooking() {
		String ActualText=ManageBooking.getText();
		System.out.println(ActualText);
		Assert.assertEquals(ActualText, "Manage Booking");
		return this;
	}
	public BookingPage Validate_PassengerPage() {
		String ActualText=PassengerPage.getText();
		System.out.println(ActualText);
		Assert.assertEquals(ActualText, "Passengers");
		return this;
	}
	public BookingPage Select_Title() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(Title));
		Title.click();
		TitleMiss.click();
		return this;
	}
	public BookingPage Select_FirstName(String firstname) {
		FirstName.sendKeys(firstname);
		return this;
	}
	public BookingPage Select_LastName(String lastname) {
		LastName.sendKeys(lastname);
		return this;
	}
	public BookingPage Select_PhoneNumber(String phone) {
		PhoneNumber.sendKeys(phone);
		return this;
	}
	public BookingPage Select_Email(String email) {
		Email.sendKeys(email);
		return this;
	}
	/*public BookingPage Select_Country(String country) {
		
		
		return this;
	}*/
	public BookingPage Select_City(String city) {
		City.sendKeys(city);
		return this;
	}
	public BookingPage ScrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", "");
		return this;
	}
	public BookingPage Select_PassengerTitle() {
		FirstPassengerTitle.click();
		TitleMisss.click();
		return this;
	}
	public BookingPage FirstPassengerFirstName() {
		FirstPassengerFirstName.sendKeys("PRERNA");
		return this;
	}
	public BookingPage FirstPassengerLastName() {
		FirstPassengerLastName.sendKeys("CHATURVEDI");
		return this;
	}
	public BookingPage FirstPassengerPhone() {
		FirstPassengerPhone.sendKeys("9713955727");
		return this;
	}
	public BookingPage ContinueWithBooking() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ContinueWithBooking));
		ContinueWithBooking.click();
		return this;
	}
	public BookingPage ContinueForPayment() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ContinueForPayment));
		ContinueForPayment.click();
		return this;
	}
	public BookingPage Close() {
		Close.click();
		return this;
	}
	public BookingPage PaymentPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(PaymentPage));
		String ActualResult=PaymentPage.getText();
		System.out.println(ActualResult);
		Assert.assertEquals(ActualResult, "Payment");
		return this;
	}
	public BookingPage CardNumber() {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='payment_form']")));
         WebElement cardNumberIframe = driver.findElement(By.xpath("//iframe[@class='card_number_iframe']"));
         driver.switchTo().frame(cardNumberIframe);
		CardNumber.sendKeys("12345678900");
		driver.switchTo().defaultContent();
		return this;
	}
	public BookingPage NameOnCard() {
		WebElement cardNameIframe = driver.findElement(By.xpath("//iframe[@class='name_on_card_iframe']"));
        driver.switchTo().frame(cardNameIframe);
		NameOnCard.sendKeys("PRERNA CHATURVEDI");
		driver.switchTo().defaultContent();
		return this;
	}
	public BookingPage MonthOnCard() {
		WebElement month = driver.findElement(By.xpath("//iframe[@class='card_exp_month_iframe']"));
        driver.switchTo().frame(month);
		MonthOnCard.sendKeys("09");
		driver.switchTo().defaultContent();
		return this;
	}
	public BookingPage YearOnCard() {
		WebElement year = driver.findElement(By.xpath("//iframe[@class='card_exp_year_iframe']"));
        driver.switchTo().frame(year);
		YearOnCard.sendKeys("27");
		driver.switchTo().defaultContent();
		return this;
	}
	public BookingPage CVV() {
		WebElement cvv = driver.findElement(By.xpath("//iframe[@class='security_code_iframe']"));
        driver.switchTo().frame(cvv);
		CVV.sendKeys("222");
		driver.switchTo().defaultContent();
		return this;
	}
}
