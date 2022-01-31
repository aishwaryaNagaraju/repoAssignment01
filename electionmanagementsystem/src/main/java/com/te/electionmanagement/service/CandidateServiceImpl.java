package com.te.electionmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.electionmanagement.bean.CandidateDetails;
import com.te.electionmanagement.dao.CandidateDao;

@Service
public class CandidateServiceImpl implements CandidateService{
	
	@Autowired
    private CandidateDao dao;

	@Override
	public CandidateDetails authenticate(int id, String password) {
		if(id<=0) {
			return null;
		}
		return dao.authenticate(id, password);
	}

	@Override
	public boolean addData(CandidateDetails details) {
		return dao.addData(details);
	}

	@Override
	public boolean deleteData(int id) {
		if(id<=0) {
			return false;
		}
		return dao.deleteData(id);
		
		
	}

	@Override
	public CandidateDetails getData(int id) {
		if(id<=0) {
			return null;
		}
		return dao.getData(id);
		
		
	}

	@Override
	public boolean update(CandidateDetails details, int id) {
		return dao.update(details, id);
	}

	@Override
	public List<CandidateDetails> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	

}
