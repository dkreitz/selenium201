package assignment1to4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Assignment4 {

	static String myPIN = "123";
	static int maxAttempts = 3;
	static int attemptNumber;

	public static void main(String[] args) throws IOException {

		boolean pinOK = false;

		for (attemptNumber = 1; attemptNumber < maxAttempts + 1; attemptNumber++) {

			String pin = getPIN();
			pinOK = Objects.equals(pin, myPIN);

			if (pinOK) {
				System.out.println("You have access to your account");
				break;

			} else if (attemptNumber == maxAttempts) {
				System.out.println("You have been locked out");
				break;
				
			} else {
				System.out.println("Please try again");
				
			}

		}

	}

	private static String getPIN() throws IOException {

		System.out.print("Attempt (" + attemptNumber + ") Please enter your PIN: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String pin = reader.readLine();
		return pin;

	}

}
