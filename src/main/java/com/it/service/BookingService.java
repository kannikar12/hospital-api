package com.it.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.dto.BookingDto;
import com.it.entity.BookingEntity;
import com.it.repository.BookingRepository;


@Service
public class BookingService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	public List<BookingDto> findAllBooking() {
		List<BookingEntity> bookingEntities = bookingRepository.findAll();
		return modelMapper.map(bookingEntities, new TypeToken<List<BookingDto>>() {
		}.getType());
	}

//	public BookingDto findBookingByBookId(Integer bookId) {
//		Optional<BookingEntity> provinceOtn = bookingRepository.findById(bookId);
//		if (provinceOtn.isPresent()) {
//			BookingDto dto= new BookingDto();
//			dto.setBookId(provinceOtn.get().getBookId());
//			dto.setServiceId(provinceOtn.get().getServiceId());
//			dto.setBookDate(provinceOtn.get().getBookDate());
//			dto.setBookStatus(provinceOtn.get().getBookStatus());
//			dto.setCustId(provinceOtn.get().getCustId());
//			dto.setBookSumTime(provinceOtn.get().getBookSumTime());
//			dto.setBookTime(provinceOtn.get().getBookTime());
//			dto.setBookEtime(provinceOtn.get().getBookEtime());
//			return dto;
//		}
//
//		return null;
//	}

	public BookingDto findBookingByBookId(Integer bookId) {
		Optional<BookingEntity> bookingOtn = bookingRepository.findById(bookId);
		if (bookingOtn.isPresent()) {
			return modelMapper.map(bookingOtn.get(), new TypeToken<BookingDto>() {}.getType());
		}
		
		return null;
	}
	
	public boolean saveBooking(BookingDto bookingDto) {
		boolean saveFig = false;
		try {
			BookingEntity entity = modelMapper.map(bookingDto,BookingEntity.class);
			bookingRepository.save(entity);
			saveFig = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saveFig;
	}

	public boolean updateBooking(Integer bookId, BookingDto bookingDto) {
		boolean updateFig = false;
		try {

			Optional<BookingEntity> provinceOtn = bookingRepository.findById(bookId);
			if (provinceOtn.isPresent()) {
				BookingEntity entity = modelMapper.map(bookingRepository, BookingEntity.class);
				bookingRepository.save(entity);
				updateFig = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updateFig;
	}


	public boolean deleteBookungBybookId(Integer bookId) {
		boolean deleteFig = false;
		try {
			bookingRepository.deleteById(bookId);
			deleteFig = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleteFig;
	}

	public Object findBookingAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
