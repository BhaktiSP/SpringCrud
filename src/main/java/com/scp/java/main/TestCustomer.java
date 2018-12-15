package com.scp.java.main;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.scp.java.bean.Customer;
import com.scp.java.config.SeesionFactoryUtil;
import com.scp.java.service.CustomerService;
import com.scp.java.service.impl.CustomerServiceImpl;

public class TestCustomer {
public static void main(String[] args) {
	

		ApplicationContext context = SeesionFactoryUtil.context;
		Customer customer1 = (Customer)context.getBean("cid");
		Customer customer2 = (Customer)context.getBean("cid");
		customer1.setCustId(1);
		customer2.setCustId(2);
		
		CustomerService service = new CustomerServiceImpl();
		System.out.println("AddCustomer");
		service.addCustomer(customer1);
		service.addCustomer(customer2);
		
		System.out.println("getCustomer");
		service.getCustomer(1);
		System.out.println("getAllCustmers");
		List<Customer> customers = service.getAllCustomers();
		System.out.println(customers);
		
		
		System.out.println("updating...");
		customer1.setFirstname("Shrwan");
		
	
		service.updateCustomer(customer1);
		System.out.println("updated...");
		
		service.getCustomer(1);
		customers = service.getAllCustomers();
		System.out.println(customers);
		
		
		
	}

}
