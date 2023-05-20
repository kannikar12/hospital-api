package com.it.dto;

import lombok.Data;

@Data
public class ServiceDetailDto {
	private Integer serviceDetailId;
	private Integer serviceId;
	private String serviceDetailStime;
	private String serviceDetailEtime;
	private String serviceDetailStatus;

}
