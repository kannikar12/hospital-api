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
@Table (name = "tb_admins")
public class AdiminEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer adiminId;
	private String adiminUesname;
	private String adiminTitle;
	private String roleStatus;
	private String adiminName;
	private String adiminLassname;
	private String adiminPhon;
	private String adiminEmail;
	private String Status;
	private Integer bookIdS;

}
