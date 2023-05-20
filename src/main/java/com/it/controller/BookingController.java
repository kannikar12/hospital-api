package com.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.dto.BookingDto;
import com.it.service.BookingService;

@RestController
@RequestMapping("/v1/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@GetMapping("/booking/{bookId}")
	public ResponseEntity<Object> getBillorderByBillId(@PathVariable(name = "bookId") Integer bookId) {
		return ResponseEntity.ok(bookingService.findBookingByBookId(bookId));
	}

	@PostMapping("/booking/save")
	public ResponseEntity<Object> saveBooking(@RequestBody BookingDto bookingDto) {
		return ResponseEntity.ok(bookingService.saveBooking(bookingDto));
	}

	@PutMapping("/booking/update/{bookId}")
	public ResponseEntity<Object> updateBooking(@PathVariable(name = "bookId") Integer bookId,
			@RequestBody BookingDto bookingDto) {
		return ResponseEntity.ok(bookingService.updateBooking(bookId, bookingDto));
	}

	@DeleteMapping("/booking/{bookId}")
	public ResponseEntity<Object> deleteBookingByBookId(@PathVariable(name = "bookId") Integer bookId) {
		return ResponseEntity.ok(bookingService.deleteBookungBybookId(bookId));
	}

}