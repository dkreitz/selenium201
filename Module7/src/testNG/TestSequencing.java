package testNG;

import org.testng.annotations.Test;

public class TestSequencing {

	@Test(priority = 4, dependsOnMethods = { "a" })
	public void f() {
	}

	@Test(priority = 98)
	public void a() {
	}

	@Test(priority = 67)
	public void h() {
	}

	@Test(priority = 0, dependsOnMethods = { "n" })
	public void k() {
	}

	@Test(priority = 16)
	public void n() {
	}

}
