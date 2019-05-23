package com.demoaut.newtours.TestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ValidateCredentialsTest extends BaseTest {
		
	@Test
	public void credentialVerification() throws Exception {
		login.applicationLogin("mercury", "mercury");
		String expectedTitle = "Find a Flight: Mercury Tours:";
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(expectedTitle, actualTitle);
		takeScreenshot();
	}
}
