package com.it.dto;

import javax.persistence.JoinColumn;

import lombok.Data;

@Data
public class RoleDto {
	private Integer roleId;
	private String roleName;
	private String roleDes;
	private String roleStatus;
	
}
