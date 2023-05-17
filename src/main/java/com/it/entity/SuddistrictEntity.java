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
@Table(name = "tb_suddistrict")
public class SuddistrictEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer sdtId;
	private String sdtZipCode;
	private String sdtNameTh;
	private String sdtNameEng;
	private Integer disId;
	
	@ManyToOne
	@JoinColumn(name = "disId", nullable = true, insertable = false, updatable = false)
	private DistrictEntity district;
}
