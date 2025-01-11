package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.BookingPage;

public class TC006_ValidateFlightBooking extends ProjectSpecificMethods{
	@BeforeTest
	public void setup() throws IOException {
		testName = "OneWayTripTillBooking";
		testDescription ="Testing One Way Trip functionality";
		testCategory ="Functional Testing";
		testAuthor ="Prerna Chaturvedi";	
	}
	@Test
	public void FlightBooking() throws IOException {
		BookingPage obj = new BookingPage(driver);
		obj.ValidateBookingPage()
		.OneWaySelect()
		.Select_Source()
		.Select_Destination()
		.Select_DateForDeparture()
		.Click_Passenger()
		.Select_Passengers()
		.SearchFlight()
		.ValidateStatus()
		.Continue()
		.screenshot(testName);
		
	}

}
