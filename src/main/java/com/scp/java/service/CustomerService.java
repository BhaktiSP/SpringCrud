package com.scp.java.service;

import java.util.List;

import com.scp.java.bean.Customer;

public interface CustomerService {
	public boolean addCustomer(Customer cust);
	public Customer getCustomer(int custId);
	public boolean deleteCustomer(int custId);
	public List<Customer> getAllCustomers();
	public Customer updateCustomer(Customer cust);


}
