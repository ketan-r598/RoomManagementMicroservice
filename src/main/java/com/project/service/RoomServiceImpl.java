package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Room;
import com.project.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepository repo;
	
	@Override
	public void addRoom(Room room) {
		Optional<Room> r = repo.findById(room.getRoomId());

		if (r.isPresent()) {
			// TODO
			// throw Exception
		}

		repo.save(room);
		System.out.println("------------------------------");
		System.out.println("+  Room Added Successfully   +");
		System.out.println("------------------------------");
	}

	@Override
	public void updateRoom(Room room) {
		Optional<Room> r = repo.findById(room.getRoomId());

		if (r.isEmpty()) {
			// TODO
			// throw Exception
		}

		repo.save(room);
		System.out.println("--------------------------------");
		System.out.println("+  Room Updated Successfully   +");
		System.out.println("--------------------------------");
	}

	@Override
	public void deleteRoom(int id) {
		Optional<Room> r = repo.findById(id);

		if (r.isEmpty()) {
			// TODO
			// throw Exception
		}

		repo.deleteById(id);
		System.out.println("--------------------------------");
		System.out.println("+  Room Deleted Successfully   +");
		System.out.println("--------------------------------");
	}

	@Override
	public Optional<Room> getRoom(int id) {
		Optional<Room> r = repo.findById(id);
		return r;
	}

	@Override
	public List<Room> getRooms() {
		return repo.findAll();
	}

}
