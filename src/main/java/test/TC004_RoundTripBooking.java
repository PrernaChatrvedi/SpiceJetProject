package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.BookingPage;

public class TC004_RoundTripBooking extends ProjectSpecificMethods{
	@BeforeTest
	public void setup() throws IOException {
		testName = "RoundTripBooking";
		testDescription ="Testing Two Way Trip functionality";
		testCategory ="Functional Testing";
		testAuthor ="Prerna Chaturvedi";	
	}
	@Test
	public void RoundTripTest() throws IOException {
		BookingPage obj = new BookingPage(driver);
		obj.ValidateBookingPage()
		.Select_RoundTrip()
		.Select_Source()
		.Select_Destination()
		.Select_DateForDeparture()
		.Select_DateForReturn()
		.Click_Passenger()
		.Select_Passengers()
		.SearchFlight()
		.ValidateStatusForRoundTrip()
		.screenshot(testName);
		
	}
}
