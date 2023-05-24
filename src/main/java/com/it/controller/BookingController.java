package com.it.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.jfree.util.Log;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.it.dto.BookingDto;
import com.it.dto.CustomersDto;
import com.it.entity.BookingEntity;
import com.it.entity.CustomersEntity;
import com.it.repository.BookingRepository;
import com.it.repository.CustomersRepository;
import com.it.service.BookingService;

@RestController
@RequestMapping("/v1/booking")
public class BookingController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private CustomersRepository customersRepository;

	@Autowired
	private BookingService bookingService;

	private BookingDto convertToResponse1(BookingEntity entity) {
		BookingDto response = modelMapper.map(entity, BookingDto.class);

		// set
		Optional<CustomersEntity> custEntity = customersRepository.findById(Integer.valueOf(entity.getCustId()));
		if (custEntity.isPresent()) {
			response.setCust(modelMapper.map(custEntity.get(), CustomersDto.class));
		}

		return response;
	}

	@GetMapping
	public ResponseEntity<Object> getBookingAll() {
		return ResponseEntity.ok(bookingService.findBookingAll());

	}

	@GetMapping("/by-customers")
	public ResponseEntity<List<Object>> getbookingsByUserId(@RequestParam(name = "custId") Integer custId) {
		List<BookingEntity> entities = bookingRepository.findAll();
		if (CollectionUtils.isNotEmpty(entities)) {
			return ResponseEntity.ok(entities.stream().filter(data -> (data.getCustId()) == custId)
					.map(this::convertToResponse).collect(Collectors.toList()));
		} else {
			return ResponseEntity.badRequest().body(null);
		}

	}

	@GetMapping("/bookId")
	public ResponseEntity<BookingDto> getBookingBybookId(@RequestParam("bookId") Integer bookId) {
		Optional<BookingEntity> entity = bookingRepository.findById(bookId);
		if (entity.isPresent()) {
			return ResponseEntity.ok(this.convertToResponse(entity.get()));
		} else {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@GetMapping("/booking/by-status")
	public ResponseEntity<List<Object>> getbookingByStatus(@RequestParam(name = "bookStatus") String bookStatus) {
		List<BookingEntity> entities = bookingRepository.findAll();
		if (CollectionUtils.isNotEmpty(entities)) {
			return ResponseEntity.ok(entities.stream().filter(data -> data.getBookStatus().equals(bookStatus))
					.map(this::convertToResponse1).collect(Collectors.toList()));
		} else {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@PostMapping("/booking/save")
	public ResponseEntity<BookingEntity> saveBooking(@RequestBody BookingEntity request) {
		if (request != null) {
			Log.info("saveBooking : " + request.toString());
			BookingEntity entity = new BookingEntity();
			entity.setBookId(request.getBookId());
			entity.setCustId(request.getCustId());
			entity.setServiceId(request.getServiceId());
			entity.setBookDate(request.getBookDate());
			entity.setBookStatus(request.getBookStatus());
			entity.setBookSumTime(request.getBookSumTime());
			entity.setBookTime(request.getBookTime());
			entity.setBookEtime(request.getBookEtime());
			return ResponseEntity.ok(bookingRepository.save(entity));
		} else {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@PutMapping("/{bookId}")
	public ResponseEntity<Object> updateBooking1(@PathVariable(name = "bookId") Integer bookId,
			@RequestBody BookingDto bookingDto) {
		return ResponseEntity.ok(bookingService.updateBooking(bookId, bookingDto));
	}

	@PutMapping("/booking/update/{bookId}")
	public ResponseEntity<BookingEntity> updateBookingStatus(@RequestBody BookingEntity request) {
		if (request.getBookId() != null) {
			Optional<BookingEntity> entity = bookingRepository.findById(request.getBookId());
			if (entity.isPresent()) {
				// set update data form request
				BookingEntity updateEntities = entity.get();
				updateEntities.setBookStatus(request.getBookStatus());
				return ResponseEntity.ok(bookingRepository.save(updateEntities));
			} else {
				return ResponseEntity.badRequest().body(null);
			}
		} else {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@DeleteMapping("/booking/{bookId}")
	public ResponseEntity<Object> deleteBookingByBookId(@PathVariable(name = "bookId") Integer bookId) {
		return ResponseEntity.ok(bookingService.deleteBookungBybookId(bookId));
	}

	private <R> R convertToResponse(BookingEntity bookingentity1) {
		return null;
	}

}