package com.demoaut.newtours.TestScripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BookTicketTest extends BaseTest {
		
	@Test
	public void bookTicket() throws Exception{
		login.applicationLogin("mercury", "mercury");
		flightFinder.findFlights();
		selectFlight.flightSelection();
		bookAFlight.bookFlight("FirstName", "LastName", "12345");
		takeScreenshot();
		
		String expectedMessage = "Your itinerary has been booked!";
		String actualMessage = driver.findElement(By.xpath("//tr[3]/td/p/font/b/font[2]")).getText();
		
		Assert.assertEquals(expectedMessage, actualMessage);
		
	}

}
