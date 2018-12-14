package classroom;

public class TestConstructors {
	
	String name, address;
	int id;
	TestContructorsNew objNew;
	
	public TestConstructors() {
		name = "Daniel";
		id = 100;
	}
	
	public TestConstructors(String name, int roll_no) {
		this.name = name;
		id = roll_no;
	}
	
	public TestConstructors(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public void printData() {
		objNew = new TestContructorsNew();
		System.out.println("The data is: " + name + " " + id + " " + address);
		int average = objNew.takeAverage(10, 20);
		System.out.println(average);
	}

	public static void main(String[] args) {
		TestConstructors obj1 = new TestConstructors();
		TestConstructors obj2 = new TestConstructors("Michele", 200);
//		TestConstructors obj3 = new TestConstructors("Saskia", "Gainesville, Florida");
		obj1.printData();
		obj2.printData();
//		obj3.printData();
	}

}
