package com.it.dto;
 

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.it.entity.CustomersEntity;

import lombok.Data;

@Data
public class BookingDto {
	private Integer bookId;
	private String bookDate;
	private String bookPre;
	private String bookStatus;
	private Integer custId;
	
	@ManyToOne
	@JoinColumn(name = "custId", nullable = true, insertable = false, updatable = false)
	private CustomersEntity customers;
}
