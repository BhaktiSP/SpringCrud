package com.scp.java.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_information")
public class CustomerEntity {
	@Id
	private int custId;
	private String custName;
	private String custAddress;
	private double custBalance;
	private int custAge;
	private String custEmail;
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public double getCustBalance() {
		return custBalance;
	}
	public void setCustBalance(double custBalance) {
		this.custBalance = custBalance;
	}
	public int getCustAge() {
		return custAge;
	}
	public void setCustAge(int custAge) {
		this.custAge = custAge;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	@Override
	public String toString() {
		return "\n CustomerEntity [custId=" + custId + ", custName=" + custName + ", custAddress=" + custAddress
				+ ", custBalance=" + custBalance + ", custAge=" + custAge + ", custEmail=" + custEmail + "]";
	}
	public CustomerEntity(int custId, String custName, String custAddress, double custBalance, int custAge,
			String custEmail) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custAddress = custAddress;
		this.custBalance = custBalance;
		this.custAge = custAge;
		this.custEmail = custEmail;
	}
	public CustomerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
