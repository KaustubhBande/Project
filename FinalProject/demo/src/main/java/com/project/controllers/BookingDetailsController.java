package com.project.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.BookingDetails;
import com.project.services.BookingDetailsService;

@RestController
@RequestMapping("/api/bookings")
public class BookingDetailsController {

	@Autowired
	private BookingDetailsService bookingDetailsService;
	
	@PostMapping("/add")
	public ResponseEntity<BookingDetails> addBooking(@RequestBody BookingDetails bookingDetails) {
		BookingDetails addedBookingDetails = bookingDetailsService.addBooking(bookingDetails);
		return new ResponseEntity<BookingDetails>(addedBookingDetails, HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{bookingId}")
	public ResponseEntity<BookingDetails> getBooking(@PathVariable Integer bookingId){
		BookingDetails bookingDetails = bookingDetailsService.getBooking(bookingId);
		return ResponseEntity.ok(bookingDetails);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<BookingDetails>> getAllBookings(){
		List<BookingDetails> bookingList = bookingDetailsService.getAllBookings();
		return ResponseEntity.ok(bookingList);
	}
	
	@PutMapping("/update/{bookingId}")
	public ResponseEntity<BookingDetails> updateBooking(@RequestBody BookingDetails bookingDetails, @PathVariable Integer bookingId){
		BookingDetails updatedBookingDetails = bookingDetailsService.updateBooking(bookingDetails, bookingId);
		return new ResponseEntity<BookingDetails>(updatedBookingDetails, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{bookingId}")
	public void deleteBooking(@PathVariable Integer bookingId) {
		bookingDetailsService.deleteBooking(bookingId);
	}
}
