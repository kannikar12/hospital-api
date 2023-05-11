package com.it.dto;
 

import lombok.Data;

@Data
public class BookingDto {
	private Integer bookId;
	private String bookDate;
	private String bookPre;
	private String bookStatus;
	private Integer custId;
}
