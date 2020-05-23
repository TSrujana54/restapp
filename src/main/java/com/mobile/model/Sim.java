package com.mobile.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sim {
	@Id
	private int simNo;
	private String network;
	@ManyToOne
	private Mobile mobile;
	public Sim() {
		super();
	}
	
	public Mobile getMobile() {
		return mobile;
	}

	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

	public Sim(int simNo, String network, Mobile mobile) {
		super();
		this.simNo = simNo;
		this.network = network;
		this.mobile = mobile;
	}

	public int getSimNo() {
		return simNo;
	}
	public void setSimNo(int simNo) {
		this.simNo = simNo;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	@Override
	public String toString() {
		return "Sim [simNo=" + simNo + ", network=" + network + "]";
	}
	

}
