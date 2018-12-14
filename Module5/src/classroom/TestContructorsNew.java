package classroom;

public class TestContructorsNew {
	
	int number;
	
	public TestContructorsNew() {
		number = 2;
	}
	
	public int takeAverage(int i, int j) {
		int average = (i + j)/number;
		return average;
	}

}
