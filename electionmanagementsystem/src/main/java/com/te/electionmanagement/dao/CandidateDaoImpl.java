package com.te.electionmanagement.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.te.electionmanagement.bean.CandidateDetails;
import com.te.electionmanagement.exception.CandidateException;
import com.te.electionmanagement.service.CandidateService;

@Repository
public class CandidateDaoImpl implements CandidateDao {
	
	@PersistenceUnit
	private EntityManagerFactory factory ;

	@Override
	public CandidateDetails authenticate(int id, String password) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emp");
		EntityManager manager = factory.createEntityManager();
		CandidateDetails details = manager.find(CandidateDetails.class, id);

		if (details != null) {
			if (details.getPassword().equals(password)) {
				return details;
			}else {
				throw new CandidateException("Invalid Password!!");
			}
		}
		throw new CandidateException("Invalid ID!!");
	}

	@Override
	public boolean addData(CandidateDetails details) {

		boolean isAdded = false;
		EntityTransaction transaction = null;

		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("candidate");
			EntityManager manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(details);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		return isAdded;
	}

	@Override
	public boolean deleteData(int id) {
		boolean isDeleted = false;
		EntityTransaction transaction = null;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("candidate");
			EntityManager manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			CandidateDetails details = manager.find(CandidateDetails.class, id);
			manager.remove(details);
			transaction.commit();
			isDeleted = true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		return isDeleted;
	}

	@Override
	public CandidateDetails getData(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("candidate");
		EntityManager manager = factory.createEntityManager();

		CandidateDetails details = manager.find(CandidateDetails.class, id);

		if (details != null) {
			return details;

		}
		throw new CandidateException("Invalid ID!!");

	}

	@Override
	public boolean update(CandidateDetails details,int id) {
		boolean isUpdated = false;
		EntityTransaction transaction = null;

		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("candidate");
			EntityManager manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			CandidateDetails details2 = manager.find(CandidateDetails.class, id);
			if(details2!=null) {
				details2.setName(details.getName());
				details2.setAddress(details.getAddress());
				details2.setPassword(details.getPassword());
			}
			manager.persist(details2);
			transaction.commit();
			isUpdated = true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		return isUpdated;
	}

	@Override
	public List<CandidateDetails> getAll() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("candidate");
		EntityManager manager = factory.createEntityManager();
		Query query= manager.createQuery("from CandidateDetails");
		List<CandidateDetails> list=query.getResultList();
		
		return list;
	}

}
