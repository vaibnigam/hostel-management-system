package com.hostel.model;

public class Student {
	private String id;
	private String name;
	private int age;
	private String roomNumber;
	private long contactNumber;

	public Student(String id, String name, int age, String roomNumber, long contactNumber) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.roomNumber = roomNumber;
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", roomNumber=" + roomNumber
				+ ", contactNumber=" + contactNumber + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

}