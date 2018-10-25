package com.lab16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CountriesTextFile {

	public static void readFromFile(String fileName) {
		Path filePath = Paths.get(fileName);
		File file = filePath.toFile();

		try {
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);

			String line = reader.readLine();

			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			reader.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (IOException e) {
			System.out.println("Contact customer service");
		}

	}

	
	public static void writeToFile(Scanner scnr, String fileName) {
		Path filePath = Paths.get(fileName);
		File file = filePath.toFile();

		try {
			PrintWriter outW = new PrintWriter(new FileOutputStream(file, true));
			// the true parameter appends new info to the end of the text file, false
			// overwrites the whole file
			outW.println(scnr.nextLine());
			outW.close(); // this needs to be closed when you're done, or the text may not render to your
							// file
		} catch (FileNotFoundException e) {
			System.out.println("File was not found!");
		}

	}

	public static void createFile(String fileName) {

		Path filePath = Paths.get(fileName);
		if (Files.notExists(filePath)) {
			try {
				Files.createFile(filePath);
				System.out.println("File was created successfully");
			} catch (IOException e) {
				System.out.println("Something went wrong with file creation");
			}
		} else {
			System.out.println("File already exists");
		}
	}

}
