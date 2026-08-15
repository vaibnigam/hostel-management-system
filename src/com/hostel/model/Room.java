package com.hostel.model;

public class Room {
	private String roomNumber;
	private int capacity;
	private int occupiedCount;

	@Override
	public String toString() {
		return "Room [roomNumber=" + roomNumber + ", capacity=" + capacity + ", occupiedCount=" + occupiedCount + "]";
	}

	public Room(String roomNumber, int capacity) {
		super();
		this.roomNumber = roomNumber;
		this.capacity = capacity;
		this.occupiedCount = 0;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getOccupiedCount() {
		return occupiedCount;
	}

	public void setOccupiedCount(int occupiedCount) {
		this.occupiedCount = occupiedCount;
	}

}
