package com.te.electionmanagement.service;

import java.util.List;

import com.te.electionmanagement.bean.CandidateDetails;

public interface CandidateService {
	
	public CandidateDetails authenticate(int id, String password);

	public boolean addData(CandidateDetails details);
	
	public boolean deleteData(int id);
	
	public CandidateDetails getData(int id);
	
	public boolean update(CandidateDetails details, int id);
	
	public List<CandidateDetails> getAll();

}
