package com.it.dto;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.it.entity.CustomersEntity;
import com.it.entity.RoleEntity;

import lombok.Data;

@Data
public class CustomersDto {

	private Integer custId;
	private String custUsername;
	private String custPassword;
	private String custTitleType;
	private String custFistName;
	private String custLastName;
	private String custGender;
	private String custCardId;
	private String custEmail;
	private String custTelephone;
	private String custAddress;
	private String custStatus;
	private String custBirthDate;
	private String sdtId;
	private String sdtZipCode;
	private Integer roleId;
	
	@ManyToOne
	@JoinColumn(name = "roleId", nullable = true, insertable = false, updatable = false)
	private RoleEntity role;

	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}

	public CustomersEntity get() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
