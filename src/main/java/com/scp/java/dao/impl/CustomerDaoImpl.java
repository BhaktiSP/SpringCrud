package com.scp.java.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.scp.java.config.SeesionFactoryUtil;
import com.scp.java.dao.CustomerDao;
import com.scp.java.entity.CustomerEntity;

public class CustomerDaoImpl implements CustomerDao {
	static SessionFactory sessionFactory = null;
	static{
		sessionFactory = SeesionFactoryUtil.getSessionFactory();
	}
	
	public boolean insertCustomer(CustomerEntity cust) {
		Session session =null;
		Transaction tr =null;
		try{
			session = sessionFactory.openSession();
			tr = session.beginTransaction();
			int id = (Integer) session.save(cust);
			System.out.println("Customer Added Successfully....!");
			return id>0;
		}catch(Exception e){
			System.out.println("Customer not added...!");
			e.printStackTrace();
			return false;
		}finally{
			SeesionFactoryUtil.resourceCleanUp(session,tr);
		}
	}


	public CustomerEntity fetchCustomer(int custId) {
		Session session =null;
		try{
			session = sessionFactory.openSession();
			CustomerEntity customerEntity = (CustomerEntity)session.get(CustomerEntity.class, custId);
			System.out.println("Customer from DB.." +customerEntity);
			return customerEntity;
		}catch(Exception e){
			System.out.println("Error while getting a customer.....!");
			e.printStackTrace();
			return null;
		}finally{
			SeesionFactoryUtil.resourceCleanUp(session,null);
		}
	}


	public List<CustomerEntity> fetchAllCustomers() {
		Session session =null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(CustomerEntity.class);
			return criteria.list();
		}catch(Exception e){
			System.out.println("Error while getting all customers.....!");
			e.printStackTrace();
			return null;
		}finally{
			SeesionFactoryUtil.resourceCleanUp(session,null);
		}
	}


	public CustomerEntity modifyCustomer(CustomerEntity cust) {
		Session session =null;
		Transaction tr =null;
		CustomerEntity dbCust = fetchCustomer(cust.getCustId());
		if(dbCust==null){
			System.out.println("Cannot update a customer...not present");
			return null;
		}
		try{
			session = sessionFactory.openSession();
			tr = session.beginTransaction();
			CustomerEntity updatedEntity = (CustomerEntity)session.merge(cust);
			System.out.println("Customer updated Successfully....!");
			return updatedEntity;
		}catch(Exception e){
			System.out.println("Customer not updated...!");
			e.printStackTrace();
			return null;
		}finally{
			SeesionFactoryUtil.resourceCleanUp(session,tr);
		}
	}


	public boolean removeCustomer(int custId) {
		Session session =null;
		Transaction tr = null;
		CustomerEntity dbEntity = fetchCustomer(custId);
		if(dbEntity==null){
			System.out.println("Customer not present in db...");
			return false;
		}
		try{
			session = sessionFactory.openSession();
			tr = session.beginTransaction();
			session.delete(dbEntity);
			System.out.println("customer deleted succefully.."+dbEntity.getCustId());
			return true;
		}catch(Exception e){
			System.out.println("Error while deleting a customer.....!");
			e.printStackTrace();
			return false;
		}finally{
			SeesionFactoryUtil.resourceCleanUp(session,tr);
		}
	}

}


