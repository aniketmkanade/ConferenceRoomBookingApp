package com.springrest.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.entities.Booking;

public interface BookingDao extends JpaRepository<Booking, Integer>{
	
}
