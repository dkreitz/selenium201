package testNG;

import org.testng.annotations.*;

public class TestAnnotations {

	@Test
	public void f2() {
		System.out.println("Inside F2");
	}

	@Test
	public void f3() {
		System.out.println("Inside F3");
	}

	@Test
	public void f1() {
		System.out.println("Inside F1");
	}

	
	@BeforeMethod
	public void beforeEveryMethod() {
		System.out.println("Before every test method.");
	}
	
	@AfterMethod
	public void afterEveryMethod() {
		System.out.println("After every test method.");
	}
	
	@BeforeTest
	public void beforeAnyTest() {
		System.out.println("Before any test method is run.");
	}
	
	@AfterTest
	public void afterAllTests() {
		System.out.println("After all test methods have run.");
	}
}
