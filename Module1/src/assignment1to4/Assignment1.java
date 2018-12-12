package assignment1to4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment1 {

	public static void main(String[] args) throws IOException {

		String name = getName();
		printName(name);

	}
	
	private static String getName() throws IOException {
		
		System.out.print("Please enter your name: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String name = reader.readLine();
		return name;
		
	}

	public static void printName(String name) {

		System.out.println("You have entered your name as " + name);
		
	}


}
