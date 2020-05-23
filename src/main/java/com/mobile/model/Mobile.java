package com.mobile.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Mobile {
	@Id
	private String mobileId;
	private String mobileBrand;
	private double price;
	@OneToMany
	private List<Sim> simList;
	public Mobile() {
		super();
	}
	public List<Sim> getSimList() {
		return simList;
	}
	public void setSimList(List<Sim> simList) {
		this.simList = simList;
	}
	public Mobile(String mobileId, String mobileBrand, double price, List<Sim> simList) {
		super();
		this.mobileId = mobileId;
		this.mobileBrand = mobileBrand;
		this.price = price;
		this.simList= simList;
	}

	public String getMobileId() {
		return mobileId;
	}
	public void setMobileId(String mobileId) {
		this.mobileId = mobileId;
	}
	public String getMobileBrand() {
		return mobileBrand;
	}
	public void setMobileBrand(String mobileBrand) {
		this.mobileBrand = mobileBrand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Mobile [mobileId=" + mobileId + ", mobileBrand=" + mobileBrand + ", price=" + price + ", simList="
				+ simList + "]";
	}
	
	
	

}
