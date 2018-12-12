package assignment1to4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assignment2 {

	public static void main(String[] args) throws IOException {

		String monthNumber = getMonthNumber();
		printMonthName(monthNumber);

	}

	private static String getMonthNumber() throws IOException {

		System.out.print("Please enter a number 1-12: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String number = reader.readLine();
		return number;

	}

	public static void printMonthName(String monthNumber) {

		String monthName = null;

		switch (monthNumber) {

		case "1":
			monthName = "January";
			break;

		case "2":
			monthName = "February";
			break;

		case "3":
			monthName = "March";
			break;

		case "4":
			monthName = "April";
			break;

		case "5":
			monthName = "May";
			break;

		case "6":
			monthName = "June";
			break;

		case "7":
			monthName = "July";
			break;

		case "8":
			monthName = "August";
			break;

		case "9":
			monthName = "September";
			break;

		case "10":
			monthName = "October";
			break;

		case "11":
			monthName = "November";
			break;

		case "12":
			monthName = "December";
			break;

		default:
			break;

		}

		System.out.println("The month you entered was " + monthName);

	}

}
