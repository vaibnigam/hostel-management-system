package com.hostel.main;

import java.util.List;
import java.util.Scanner;

import com.hostel.loader.DataLoader;
import com.hostel.model.Room;
import com.hostel.model.Student;
import com.hostel.service.HostelService;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HostelService hostelService = new HostelService();
		boolean running = true;
		DataLoader dataLoader = new DataLoader();
		dataLoader.loadRoomsFromFile("data/rooms.txt", hostelService);
		dataLoader.loadStudentsFromFile("data/students.txt", hostelService);
		while (running) {
			System.out.println("\n===== Hostel Management System =====");
			System.out.println("1. Add Student");
			System.out.println("2. Add Room");
			System.out.println("3. Allocate Room to Student");
			System.out.println("4. Vacate Student");
			System.out.println("5. Search Student by Name");
			System.out.println("6. Search Student by ID");
			System.out.println("7. View All Students");
			System.out.println("8. View All Rooms");
			System.out.println("9. Remove Student");
			System.out.println("10. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				System.out.print("Enter Student ID: ");
				String studentId = scanner.nextLine();

				System.out.print("Enter Name: ");
				String name = scanner.nextLine();

				System.out.print("Enter Age: ");
				int age = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Enter Contact Number: ");
				long contactNumber = scanner.nextLong();
				scanner.nextLine();

				hostelService.addStudent(studentId, name, age, contactNumber);
				System.out.println("Student added successfully!");
				break;

			case 2:
				System.out.print("Enter Room Number: ");
				String roomNumber = scanner.nextLine();
				System.out.print("Enter Capacity: ");
				int capacity = scanner.nextInt();
				scanner.nextLine();
				hostelService.addRoom(roomNumber, capacity);
				break;
			case 3:
				System.out.print("Enter Room Number: ");
				String allocateRoomNumber = scanner.nextLine();
				System.out.print("Enter Student ID: ");
				String allocateStudent = scanner.nextLine();
				boolean allocated = hostelService.allocateRoom(allocateStudent, allocateRoomNumber);
				System.out.println(allocated ? "Room allocated successfully!"
						: "Allocation failed. Check student ID, room number, or room capacity.");
				break;
			case 4:
				System.out.println("Enter Student ID: ");
				String vacateStudentId = scanner.nextLine();
				boolean vacated = hostelService.vacateStudent(vacateStudentId);
				System.out.println(vacated ? "Student vacated successfully" : "Failed to Vacate");
				break;
			case 5:
				System.out.println("Enter name of student:");
				String searchStudent = scanner.nextLine();
				List<Student> matchingStudentName = hostelService.searchStudentByName(searchStudent);
				if (matchingStudentName.isEmpty()) {
					System.out.println("No students found.");
				} else {
					for (Student s : matchingStudentName) {
						System.out.println(s);
					}
				}
				break;

			case 6:
				System.out.println("Enter Student ID: ");
				String matchingID = scanner.nextLine();

				Student matchingStudentId = hostelService.searchStudentById(matchingID);
				if (matchingStudentId == null) {
					System.out.println("No students found.");
				} else {
					System.out.println(matchingStudentId.toString());
				}
				break;

			case 7:
				List<Student> allStudents = hostelService.getAllStudents();
				if (allStudents.isEmpty()) {
					System.out.println("No students found.");
				} else {
					for (Student s : allStudents) {
						System.out.println(s);
					}
				}
				break;

			case 8:
				List<Room> allRooms = hostelService.getAllRooms();
				if (allRooms.isEmpty()) {
					System.out.println("No rooms found.");
				} else {
					for (Room r : allRooms) {
						System.out.println(r);
					}
				}
				break;

			case 9:
				System.out.println("Enter Student ID: ");
				String studentId5 = scanner.nextLine();
				boolean removed = hostelService.removeStudent(studentId5);
				System.out.println(removed ? "Student removed Succesfully " : "Failed to remove ");
				break;
			case 10:
				System.out.println("Exiting...Bye");
				running = false;
				break;
			default:
				System.out.println("Invalid choice, try again.");
			}
		}
		scanner.close();
	}
}
