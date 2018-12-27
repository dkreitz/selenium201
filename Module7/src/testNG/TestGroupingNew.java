package testNG;

import org.testng.annotations.Test;

public class TestGroupingNew {

	@Test(groups = { "A" })
	public void g1() {
	}

	@Test(groups = { "D" })
	public void g2() {
	}

	@Test(groups = { "E" })
	public void g3() {
	}

	@Test(groups = { "B" })
	public void g4() {
	}

	@Test(groups = { "D" })
	public void g5() {
	}

}
