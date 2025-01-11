package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.BookingPage;

public class TC007_AddPassengersDetails extends ProjectSpecificMethods{
	@BeforeTest
	public void setup() throws IOException {
		sheename ="ContactDetails";
		testName = "PaymentPage";
		testDescription ="Testing One Way Trip functionality till payment page";
		testCategory ="Functional Testing";
		testAuthor ="Prerna Chaturvedi";	
	}
	@Test(dataProvider = "readData")
	public void FlightBooking(String firstname,String lastname,String phone,String email,String city) throws IOException {
		BookingPage obj = new BookingPage(driver);
		obj.ValidateBookingPage()
		.OneWaySelect()
		.Select_Source()
		.Select_Destination()
		.Select_DateForDeparture()
		.SearchFlight()
		.ValidateStatus()
		.Continue()
		.Validate_PassengerPage()
		.Select_Title()
		.Select_FirstName(firstname)
		.Select_LastName(lastname)
		.Select_PhoneNumber(phone)
		.Select_Email(email)
		.Select_City(city)
		.ScrollDown()
		.Select_PassengerTitle()
		.FirstPassengerFirstName()
		.FirstPassengerLastName()
		.FirstPassengerPhone()
		.ContinueWithBooking()
		.ContinueForPayment()
		.Close()
		.PaymentPage()
		.CardNumber()
		.NameOnCard()
		.MonthOnCard()
		.YearOnCard()
		.CVV()
		.screenshot(testName);
		
	}

}
