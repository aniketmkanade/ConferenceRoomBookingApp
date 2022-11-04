package com.springrest.springrest.services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.BookingDao;
import com.springrest.springrest.entities.Booking;


@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingDao bookingDao;
	
	public BookingServiceImpl(){}
	
	/*
	 * the name of the booker, the surname of the booker, booking ID, a room to book
	 */
	@Override
	public List<Booking> getBookings() {
		List<Booking> list = bookingDao.findAll();
		list.remove(4);
		list.remove(5);
		
		return list; 
	}
	
	/*
	 * Getting details of specific bookingId
	 */
	@Override
	public Booking getBooking(int bookingId) {
		return bookingDao.getOne(bookingId);
	}

	/*
	 * Booking conference room with some constraints
	 */
	@Override
	public Booking addBooking(Booking booking) {
		
		List<Booking> bookings = bookingDao.findAll();
		for(Booking book: bookings)
		{
			if(book.getRoomId() == booking.getRoomId())
			{
				Timestamp start = booking.getStartTime();
				Timestamp end = booking.getEndTime();
				
				Timestamp earlier_start = book.getStartTime();
				Timestamp earlier_end = book.getEndTime();
				
				/*
				 * start time from request should be less than end time from request
				 * Conference room can be booked between 8:00 to 17:00
				 */
				if((start.getHours() < end.getHours()) && (start.getHours() >= 8) && (end.getHours() <= 17))
				{
					
					/*
					 * time from request shouldn't intersect with specific rooms previous booked times
					 */
					int b1 = end.compareTo(earlier_start);
					int b2 = start.compareTo(earlier_end);
					
					if((b1 < 0) && (b2 > 0))
					{
						bookingDao.save(booking);
					}
				}
			}
		}
		return null;
	}

	/*
	 * Updating Conference room booking details after checking the details
	 */
	@Override
	public Booking updateBooking(Booking booking) {
		List<Booking> bookings = bookingDao.findAll();
		for(Booking book: bookings)
		{
			if(book.getRoomId() == booking.getRoomId())
			{
				Timestamp start = booking.getStartTime();
				Timestamp end = booking.getEndTime();
				
				Timestamp earlier_start = book.getStartTime();
				Timestamp earlier_end = book.getEndTime();
				
				/*
				 * start time from request should be less than end time from request
				 * Conference room can be booked between 8:00 to 17:00
				 */
				if((start.getHours() < end.getHours()) && (start.getHours() >= 8) && (end.getHours() <= 17))
				{
					
					/*
					 * time from request shouldn't intersesct with specific rooms previous booked times
					 */
					int b1 = end.compareTo(earlier_start);
					int b2 = start.compareTo(earlier_end);
					
					if((b1 < 0) && (b2 > 0))
					{
						bookingDao.save(booking);
					}
				}
			}
		}
		return null;
	}
	
	
	/*
	 * Deleting Conference room booking details
	 */
	@Override
	public void deleteBooking(int parseInt) {
		Booking entity = bookingDao.getOne(parseInt);
		bookingDao.delete(entity);
	}
}
