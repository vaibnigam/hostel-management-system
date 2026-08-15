package com.hostel.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hostel.model.Student;

public class StudentRepository {
	private Map<String, Student> students = new HashMap<String, Student>();

	public void addStudent(Student student) {
		students.put(student.getId(), student);
	}

	public Student findById(String id) {
		return students.get(id);
	}

	public List<Student> findByName(String name) {
		List<Student> result = new ArrayList<Student>();
		for (Student s : students.values()) {
			if (s.getName().toLowerCase().contains(name.toLowerCase())) {
				result.add(s);
			}
		}
		return result;
	}

	public List<Student> getAllStudents() {
		return new ArrayList<Student>(students.values());
	}

	public boolean removeStudent(String id) {
		Student removed = students.remove(id);
		return removed != null;
	}
}