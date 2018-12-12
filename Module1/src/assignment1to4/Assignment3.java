package assignment1to4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment3 {

	public static void main(String[] args) throws IOException {

		String myString = getString();
		printReversedString(myString);

	}
	
	private static String getString() throws IOException {
		
		System.out.print("Please enter a string: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		return s;
		
	}

	public static void printReversedString(String myString) {
		
		StringBuilder reversedString = new StringBuilder();
		reversedString.append(myString);
		reversedString = reversedString.reverse();

		System.out.println("Reversed string is: " + reversedString);
		
	}


}
