package com.it.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "tb_role")
public class RoleEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer roleId;
	private String roleName;
	private String roleDes;
	private String roleStatus;

}
