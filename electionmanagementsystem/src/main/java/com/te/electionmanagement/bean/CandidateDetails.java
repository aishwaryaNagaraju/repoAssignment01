package com.te.electionmanagement.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="emp_info")
public class CandidateDetails implements Serializable{
	@Id
	@Column(name="candidate_id")
	private int id;
	
	@Column(name="candidate_name")
	private String name;
	
	@Column(name="candidate_password")
	private String password;
	
	@Column(name="candidate_address")
	private String address;
	
	@Column(name="contesting_from")
	private int wardNo;
	
}
