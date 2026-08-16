package com.hostel.loader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.hostel.service.HostelService;

public class DataLoader {

	public void loadRoomsFromFile(String filePath, HostelService hostelService) {
		try {
			File file = new File(filePath);
			Scanner fileScanner = new Scanner(file);

			int loadedCount = 0;
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();

				if (line.trim().isEmpty()) {
					continue;
				}

				String[] parts = line.split(",");

				if (parts.length != 2) {
					System.out.println("Skipping invalid line: " + line);
					continue;
				}

				String roomNumber = parts[0].trim();
				int capacity = Integer.parseInt(parts[1].trim());

				hostelService.addRoom(roomNumber, capacity);
				loadedCount++;
			}

			fileScanner.close();
			System.out.println(loadedCount + " rooms loaded successfully from file.");

		} catch (FileNotFoundException e) {
			System.out.println("Rooms data file not found. Starting with no rooms.");
		}
	}

	public void loadStudentsFromFile(String filePath, HostelService hostelService) {
		try {
			File file = new File(filePath);
			Scanner fileScanner = new Scanner(file);

			int loadedCount = 0;
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();

				if (line.trim().isEmpty()) {
					continue;
				}

				String[] parts = line.split(",");

				if (parts.length != 4) {
					System.out.println("Skipping invalid line: " + line);
					continue;
				}

				String id = parts[0].trim();
				String name = parts[1].trim();
				int age = Integer.parseInt(parts[2].trim());
				long contactNumber = Long.parseLong(parts[3].trim());

				hostelService.addStudent(id, name, age, contactNumber);
				loadedCount++;
			}

			fileScanner.close();
			System.out.println(loadedCount + " students loaded successfully from file.");

		} catch (FileNotFoundException e) {
			System.out.println("Students data file not found. Starting with no students.");
		}
	}
}