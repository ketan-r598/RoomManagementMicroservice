package com.project.service;

import java.util.List;
import java.util.Optional;

import com.project.model.Room;

public interface RoomService {
	public void addRoom(Room room);
	public void updateRoom(Room room);
	public void deleteRoom(int id);
	public Optional<Room> getRoom(int id);
	public List<Room> getRooms();
}
