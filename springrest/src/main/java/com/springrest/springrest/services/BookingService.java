package com.springrest.springrest.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Booking;

public interface BookingService {
	
	public List<Booking> getBookings();

	public Booking getBooking(int parseInt);

	public Booking addBooking(Booking booking);

	public Booking updateBooking(Booking booking);

	public void deleteBooking(int parseInt);
}
