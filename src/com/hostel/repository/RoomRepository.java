package com.hostel.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hostel.model.Room;

public class RoomRepository {
	private Map<String, Room> rooms = new HashMap<>();

	public void addRoom(Room room) {
		rooms.put(room.getRoomNumber(), room);
	}

	public Room findByRoomNumber(String roomNumber) {
		return rooms.get(roomNumber);
	}
	public List<Room> getAllRooms(){
		return new ArrayList<Room>(rooms.values());
	}

}
