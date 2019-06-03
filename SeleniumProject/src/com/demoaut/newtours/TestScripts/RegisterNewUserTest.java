package com.demoaut.newtours.TestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;


public class RegisterNewUserTest extends BaseTest {
	
	@Test
	public void registerNewUser() throws Exception{
		login.clickRegisterBtn();
		String actualMessage = registerUser.registerNewUser();
		String expectedMessage = "Thank you for registering. You may now sign-in using the user name and password you've just entered.";
		takeScreenshot();
		Assert.assertEquals(actualMessage, expectedMessage);
	}

}
