package com.it.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_customers")
public class CustomersEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
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
	
//	เพิ่ม
	@ManyToOne
	@JoinColumn(name = "roleId", nullable = true, insertable = false, updatable = false)
	private RoleEntity role;
}
