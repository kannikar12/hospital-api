package com.it.dto;

import javax.persistence.JoinColumn;

import lombok.Data;

@Data
 class ProvinceDto {
	private Integer pvnId;
	private String pvnNameTh;
	private String pvnNameEng;
	private String pvnArea;
	
}
