package com.springrest.springrest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Booking;
import com.springrest.springrest.services.BookingService;

@RestController
public class ConferenceRoomController {
	
	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/bookings")
	public List<Booking> getBookings()
	{
		return this.bookingService.getBookings();
	}
	
	@GetMapping("/bookings/{bookingId}")
	public Booking getBooking(@PathVariable String bookingId)
	{
		return this.bookingService.getBooking(Integer.parseInt(bookingId));
	}
	
	@PostMapping(path="/bookings")
	public Booking addBooking(@RequestBody Booking booking)
	{
		return this.bookingService.addBooking(booking);
	}
	
	@PutMapping("/bookings")
	public Booking updateBooking(@RequestBody Booking booking)
	{
		return this.bookingService.updateBooking(booking);
	}
	
	@DeleteMapping("/bookings/{bookingId}")
	public ResponseEntity<HttpStatus> deleteBooking(String bookingId)
	{
		try {
			this.bookingService.deleteBooking(Integer.parseInt(bookingId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
}
