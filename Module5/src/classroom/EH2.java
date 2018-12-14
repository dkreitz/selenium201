package classroom;

import java.io.FileNotFoundException;

public class EH2 {
	
	EH3 obj3;
	
	public void f2() throws FileNotFoundException, InterruptedException {
		
		obj3 = new EH3();
		obj3.f3();
		throw new InterruptedException();
		
	}

}
