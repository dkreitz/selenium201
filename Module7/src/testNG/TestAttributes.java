package testNG;

import org.testng.annotations.Test;

public class TestAttributes {

	@Test
	public void f() {

	}

	@Test(enabled = false)
	public void g() {

	}

	@Test
	public void a() {

	}

	@Test(invocationCount=3)
	public void j() {

	}

}
