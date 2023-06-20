package com.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Room")
public class Room {

	@Id
	private int roomId;
	
	private int hotelId;
	private String roomNumber;
	private String roomType;
	private double price;
	private String availability;
	
	public Room() {

	}

	public Room(int roomId, int hotelId, String roomNumber, String roomType, double price, String availability) {

		this.roomId = roomId;
		this.hotelId = hotelId;
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.price = price;
		this.availability = availability;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", hotelId=" + hotelId + ", roomNumber=" + roomNumber + ", roomType="
				+ roomType + ", price=" + price + ", availability=" + availability + "]";
	}
}