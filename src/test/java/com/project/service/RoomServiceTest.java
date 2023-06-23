package com.project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.project.model.Room;
import com.project.repository.RoomRepository;

class RoomServiceTest {

    @Mock
    private RoomRepository roomRepository;

    @InjectMocks
    private RoomServiceImpl roomService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddRoom() {
        Room room = new Room();
//        room.setRoomId(1);
//        room.setRoomNumber("101");
//        room.setCapacity(2);
//        room.setPrice(100.0);
        room.setRoomId(1);
        room.setHotelId(101);
        room.setRoomType("Double Bed");
        room.setPrice(455.44);
        room.setAvailability("Yes");
        roomService.addRoom(room);

        verify(roomRepository, times(1)).save(room);
    }

    @Test
    void testUpdateRoom() {
        Room room = new Room();
        room.setRoomId(2);
        room.setHotelId(102);
        room.setRoomType("Single Bed");
        room.setPrice(200);
        room.setAvailability("No");

        when(roomRepository.existsById(room.getRoomId())).thenReturn(true);
        when(roomRepository.save(room)).thenReturn(room);

        roomService.updateRoom(room);

        verify(roomRepository, times(1)).save(room);
    }

    @Test
    void testDeleteRoom() {
        int roomId = 1;

        when(roomRepository.existsById(roomId)).thenReturn(true);

        roomService.deleteRoom(roomId);

        verify(roomRepository, times(1)).deleteById(roomId);
    }

    @Test
    void testGetRoomById() {
        int roomId = 1;

        Room room = new Room();
        room.setRoomId(roomId);
        room.setHotelId(101);
        room.setRoomType("Double Bed");
        room.setPrice(455.44);
        room.setAvailability("Yes");

        when(roomRepository.findById(roomId)).thenReturn(Optional.of(room));

        Optional<Room> result = roomService.getRoom(roomId);

        assertEquals(Optional.of(room), result);
    }

    @Test
    void testGetRooms() {
        Room room1 = new Room();
        room1.setRoomId(1);
        room1.setHotelId(101);
        room1.setRoomType("Double Bed");
        room1.setPrice(455.44);
        room1.setAvailability("Yes");

        Room room2 = new Room();
        room2.setRoomId(2);
        room2.setHotelId(103);
        room2.setRoomType("Single Bed");
        room2.setPrice(200);
        room2.setAvailability("No");

        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);

        when(roomRepository.findAll()).thenReturn(rooms);

        List<Room> result = roomService.getRooms();

        assertEquals(rooms, result);
    }
}