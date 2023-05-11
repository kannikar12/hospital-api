package com.it.dto;

import javax.persistence.JoinColumn;

import lombok.Data;

@Data
public class DistrictDto {
	private Integer disId;
	private String disCode;
	private String disNameTh;
	private String disNameEn;
	private String pvnId;
}
