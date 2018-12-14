package classroom;

import java.io.FileNotFoundException;

public class EH1 {
	
	EH2 obj2;
	
	public void f1() {
		
		try {
			
			obj2 = new EH2();
			obj2.f2();
			throw new Exception("Just like that...");
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}

	public static void main(String[] args) {

	}

}
