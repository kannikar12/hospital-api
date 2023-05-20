package com.it.dto;


import java.util.List;

import lombok.Data;

@Data
public class ServiceTypeDto {
	private Integer serviceId;
	private String serviceName;
	private String serviceStatus;
	private String serviceDes;
	private List<ServiceDetailDto> serviceDetailDtos;
}
