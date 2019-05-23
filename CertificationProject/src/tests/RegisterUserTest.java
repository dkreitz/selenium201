package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class RegisterUserTest extends BaseTest {
	
	@Test
	public void registerUser() throws Exception {
		login.clickRegisterBtn();
		String actualMessage = registerUser.registerNewUser();
		String expectedMessage = "Thank you for registering. You may now sign-in using the user name and password you've just entered.";
		takeScreenshot();
		Assert.assertEquals(actualMessage, expectedMessage);
	}

}
