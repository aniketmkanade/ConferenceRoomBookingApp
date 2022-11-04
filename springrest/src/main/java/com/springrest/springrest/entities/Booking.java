package com.springrest.springrest.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Booking {
	
	@Id
	private int bookingId;
	private int roomId;
	private String firstName;
	private String lastname;
	private Timestamp startTime;
	private Timestamp endTime;
	public Booking(int bookingId, int roomId, String firstName, String lastname, Timestamp startTime, Timestamp endTime) {
		super();
		this.bookingId = bookingId;
		this.roomId = roomId;
		this.firstName = firstName;
		this.lastname = lastname;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public Booking() {
		super();
	}

	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", roomId=" + roomId + ", firstName=" + firstName + ", lastname="
				+ lastname + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
}
