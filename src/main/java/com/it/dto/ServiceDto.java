package com.it.dto;

import javax.persistence.JoinColumn;

import lombok.Data;

@Data
public class ServiceDto {
	private Integer serviceId;
	private String serviceName;
	private String serviceStatus;
}