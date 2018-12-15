package com.scp.java.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.scp.java.bean.Customer;
import com.scp.java.dao.CustomerDao;
import com.scp.java.dao.impl.CustomerDaoImpl;
import com.scp.java.entity.CustomerEntity;
import com.scp.java.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	CustomerDao customerDao = new CustomerDaoImpl();

	
	public boolean addCustomer(Customer cust) {
		return customerDao.insertCustomer(getCustomerEntity(cust));

	}

	public Customer getCustomer(int custId) {
		return getCustomerPojo(customerDao.fetchCustomer(custId));
	}

	public boolean deleteCustomer(int custId) {
		return customerDao.removeCustomer(custId);
	}

	public List<Customer> getAllCustomers() {
		return getListOfCustomers(customerDao.fetchAllCustomers());

	}
	private List<Customer> getListOfCustomers(List<CustomerEntity> fetchAllCustomers) {
		List<Customer> customers = new ArrayList<Customer>();
		for(CustomerEntity entity :fetchAllCustomers){
			customers.add(getCustomerPojo(entity));
		}
		return customers;
	}

	public Customer updateCustomer(Customer cust) {
		return getCustomerPojo(customerDao.modifyCustomer(getCustomerEntity(cust)));

	}

	private CustomerEntity getCustomerEntity(Customer pojo){
		CustomerEntity entity = new CustomerEntity();
		entity.setCustAddress(pojo.getAddress());
		entity.setCustAge(pojo.getAge());
		entity.setCustBalance(pojo.getBalance());
		entity.setCustEmail(pojo.getEmail());
		entity.setCustId(pojo.getCustId());
		entity.setCustName(pojo.getFirstname()+" " +pojo.getLastname());
		return entity;
	}	
	
	private Customer getCustomerPojo(CustomerEntity entity){
		Customer pojo = new Customer();
		pojo.setAddress(entity.getCustAddress());
		pojo.setAge(entity.getCustAge());
		pojo.setBalance(entity.getCustBalance());
		pojo.setCustId(entity.getCustId());
		pojo.setEmail(entity.getCustEmail());
		String fullname = entity.getCustName();
		String []names = fullname.split(" ");
		pojo.setFirstname(names[0]);
		pojo.setLastname(names[1]);
		return pojo;
	}
}
