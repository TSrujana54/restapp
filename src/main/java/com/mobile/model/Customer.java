package com.mobile.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	private String customerName;
	private String password;
	public Customer(String customerName, String password) {
		super();
		this.customerName = customerName;
		this.password = password;
	}
	public Customer() {
		super();
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", password=" + password + "]";
	}
	

}
