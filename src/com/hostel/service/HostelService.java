package com.hostel.service;

import java.util.List;

import com.hostel.model.Room;
import com.hostel.model.Student;
import com.hostel.repository.RoomRepository;
import com.hostel.repository.StudentRepository;

public class HostelService {
	private StudentRepository studentRepository;
	private RoomRepository roomRepository;

	public HostelService() {
		this.studentRepository = new StudentRepository();
		this.roomRepository = new RoomRepository();
	}

	public void addStudent(String id, String name, int age, long contactNumber) {
		Student newStudent = new Student(id, name, age, "Not Allocated", contactNumber);
		studentRepository.addStudent(newStudent);
	}

	public void addRoom(String roomNumber, int capacity) {
		Room newRoom = new Room(roomNumber, capacity);
		roomRepository.addRoom(newRoom);
	}

	public boolean allocateRoom(String studentId, String roomNumber) {
		Student student = studentRepository.findById(studentId);

		if (student == null) {
			return false;
		}

		Room room = roomRepository.findByRoomNumber(roomNumber);
		if (room == null) {
			return false;
		}
		if (room.getOccupiedCount() >= room.getCapacity()) {
			return false;
		}
		student.setRoomNumber(roomNumber);
		room.setOccupiedCount(room.getOccupiedCount() + 1);
		return true;
	}

	public boolean vacateStudent(String studentId) {
		Student student = studentRepository.findById(studentId);
		if (student == null) {
			return false;
		}
		if (student.getRoomNumber().equals("Not Allocated")) {
			return false;
		}
		Room room = roomRepository.findByRoomNumber(student.getRoomNumber());
		room.setOccupiedCount(room.getOccupiedCount() - 1);
		student.setRoomNumber("Not Allocated");
		return true;
	}

	public List<Student> searchStudentByName(String name) {
		return studentRepository.findByName(name);
	}

	public Student searchStudentById(String id) {
		return studentRepository.findById(id);
	}

	public List<Student> getAllStudents() {
		return studentRepository.getAllStudents();
	}

	public List<Room> getAllRooms() {
		return roomRepository.getAllRooms();
	}

	public boolean removeStudent(String id) {
		return studentRepository.removeStudent(id);
	}
}
