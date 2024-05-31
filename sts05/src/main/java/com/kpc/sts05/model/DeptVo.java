package com.kpc.sts05.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
@Entity
@Setter
public class DeptVo {
	@Id
	@GeneratedValue
	int deptno;
	String dname,loc;
}
