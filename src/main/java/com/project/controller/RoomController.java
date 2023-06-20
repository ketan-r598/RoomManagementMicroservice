package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Room;
import com.project.service.RoomService;

@RestController
public class RoomController {

	@Autowired
	private RoomService service;
	
	@PostMapping("/admin/rooms/addRoom")
	public void addRoom(@RequestBody Room room) {
		service.addRoom(room);
	}
	
	@PutMapping("/admin/rooms/updateRoom")
	public void updateRoom(@RequestBody Room room) {
		service.updateRoom(room);
	}
	
	@DeleteMapping("/admin/rooms/delete/{id}")
	public void deleteRoom(@PathVariable int id) {
		service.deleteRoom(id);
	}
	
	@GetMapping("/admin/rooms/getHotel/{id}")
	public Room getRoom(@PathVariable int id) {
		return service.getRoom(id).get();
	}
	
	@GetMapping("/admin/rooms/getRooms")
	public List<Room> getRooms() {
		return service.getRooms();
	}
}
