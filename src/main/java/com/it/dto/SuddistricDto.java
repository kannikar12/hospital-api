package com.it.dto;


import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.it.entity.DistrictEntity;

import lombok.Data;

@Data
public class SuddistricDto {
	private Integer sdtId;
	private String sdtZipCode;
	private String sdtNameTh;
	private String sdtNameEng;
	private Integer disId;

	@ManyToOne
	@JoinColumn(name = "disId", nullable = true, insertable = false, updatable = false)
	private DistrictEntity district;
}
