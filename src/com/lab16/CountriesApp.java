package com.lab16;

import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);
		String fileName = "countries.txt";

		System.out.println("Welcome to my country list app!");

		// I set up a loop which will prompt the user to continue

		String cont = "yes";
		while (cont.equalsIgnoreCase("yes")) {

			String userChoice = Validator.getString(scnr,
					"\nWhich option suits you?" + "\n\n1) Show me the list of countries."
							+ "\n2) Let me add a country before showing me the full list." + "\n3) I want to exit.");

			switch (userChoice) {
			case "1":
				CountriesTextFile.readFromFile(fileName);
				break;
			case "2":
				System.out.println("Please enter a country:");
				CountriesTextFile.writeToFile(scnr, fileName);
				CountriesTextFile.readFromFile(fileName);
				break;
			case "3":
				System.out.println("Goodbye!");
				System.exit(0);
			default:
				System.out.println("Please only enter 1, 2, or 3 next time.");
			}

			// I ask if the user if they would like to continue, if "yes", while loop will
			// begin again.

			cont = Validator.getString(scnr, "\nWould you like to continue? (yes/no)");
			while (!cont.equalsIgnoreCase("yes") && !cont.equalsIgnoreCase("no")) {
				System.out.println("\nPlease only enter yes/no: ");
				cont = Validator.getString(scnr, "\nWould you like to continue? (yes/no)");
			}

		}

	}

}
