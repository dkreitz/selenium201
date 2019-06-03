package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckCredentialsTest extends BaseTest {
		
	@Test
	public void checkCredentials() throws Exception {
		
		login.applicationLogin("jschmoe", "mcnasty");

		String expectedTitle = "Find a Flight: Mercury Tours:";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);

		takeScreenshot();
		
	}
}
