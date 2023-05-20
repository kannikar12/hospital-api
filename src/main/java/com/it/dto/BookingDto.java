package com.it.dto;
 

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.it.entity.CustomersEntity;

import lombok.Data;

@Data
public class BookingDto {
	private Integer bookId;
	private String bookDate;
	private Integer serviceId;
	private String bookStatus;
	private Integer custId;
	private Integer bookSumTime;
	private String bookTime;
	private String bookEtime;
	
	@ManyToOne
	@JoinColumn(name = "custId", nullable = true, insertable = false, updatable = false)
	private CustomersEntity customers;
	
	@ManyToOne
	@JoinColumn(name = "serviceId", nullable = true, insertable = false, updatable = false)
	private CustomersEntity service;
}
