package com.it.dto;


import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import lombok.Data;

@Data
public class SuddistrictDto {
	private Integer sdtId;
	private String zipCode;
	private String sdtNameTh;
	private String sdtNameEng;
	private Integer disId;

	@ManyToOne
	@JoinColumn(name = "disId", nullable = true, insertable = false, updatable = false)
	private DistrictDto district;

}
