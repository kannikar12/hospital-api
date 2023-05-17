package com.it.entity;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "tb_booking")
public class BookingEntity implements Serializable{
	private static final long  serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId;
	private String bookDate;
	private String bookPre;
	private String bookStatus;
	private Integer custId;
	
	@ManyToOne
	@JoinColumn(name = "custId", nullable = true, insertable = false, updatable = false)
	private CustomersEntity customers;
}
