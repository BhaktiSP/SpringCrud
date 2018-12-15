package com.scp.java.dao;

import java.util.List;

import com.scp.java.entity.CustomerEntity;

public interface CustomerDao {
	public boolean insertCustomer(CustomerEntity cust);
	public CustomerEntity fetchCustomer(int custId);
	public boolean removeCustomer(int custId);
	public List<CustomerEntity> fetchAllCustomers();
	public CustomerEntity modifyCustomer(CustomerEntity cust);

}
