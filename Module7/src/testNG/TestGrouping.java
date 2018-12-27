package testNG;

import org.testng.annotations.Test;

public class TestGrouping {

	@Test(groups = { "A" })
	public void f1() {
	}

	@Test(groups = { "B" })
	public void f2() {
	}

	@Test(groups = { "B" })
	public void f3() {
	}

	@Test(groups = { "C" })
	public void f4() {
	}

	@Test(groups = { "A" })
	public void f5() {
	}
}
