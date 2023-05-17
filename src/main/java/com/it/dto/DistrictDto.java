package com.it.dto;



import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.it.entity.ProvinceEntity;

import lombok.Data;

@Data
public class DistrictDto {
	private Integer disId;
	private String disCode;
	private String disNameTh;
	private String disNameEn;
	private String pvnId;
	
	@ManyToOne
	@JoinColumn(name = "pvnId", nullable = true, insertable = false, updatable = false)
	private ProvinceEntity province;
}
