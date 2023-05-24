package com.it.dto;

import com.it.entity.ServiceDetailEntity;

import lombok.Data;

@Data
public class ServiceDetailDto {
	private Integer serviceDetailId;
	private Integer serviceId;
	private String serviceDetailStime;
	private String serviceDetailEtime;
	private String serviceDetailStatus;
	public void save(ServiceDetailEntity entity) {
		// TODO Auto-generated method stub
		
	}

}
