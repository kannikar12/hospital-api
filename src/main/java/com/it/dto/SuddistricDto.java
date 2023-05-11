package com.it.dto;

import javax.persistence.JoinColumn;

import lombok.Data;

@Data
public class SuddistricDto {
	private Integer sdtId;
	private String sdtZipCode;
	private String sdtNameTh;
	private String sdtNameEng;
	private Integer disId;

}
