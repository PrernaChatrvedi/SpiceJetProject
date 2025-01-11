package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.BookingPage;

public class TC005_ValidateBookingMenu extends ProjectSpecificMethods{
	@BeforeTest
	public void setup() throws IOException {
		testName = "TwoWayTrip";
		testDescription ="Testing Two Way Trip functionality";
		testCategory ="Functional Testing";
		testAuthor ="Prerna Chaturvedi";	
	}
	@Test
	public void ManuValidationTest() throws IOException {
		BookingPage obj = new BookingPage(driver);
		obj.Validate_CheckIn()
		.Validate_FlightStatus()
		.Validate_ManageBooking()
		.screenshot(testName);
	}
}
