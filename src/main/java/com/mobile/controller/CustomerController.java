package com.mobile.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.dao.CustomerDAO;
import com.mobile.dao.MobileDAO;
import com.mobile.model.Customer;
import com.mobile.model.Mobile;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerDAO dao;
	ResponseEntity responseEntity;
	@PostMapping("/addCustomer")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
		boolean flag = dao.addCustomer(customer);
		if(flag) {
			responseEntity = new ResponseEntity<Customer>(customer,HttpStatus.CREATED);
		}
		else {
			responseEntity = new ResponseEntity<String>("Error Occurred",HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	@PostMapping("/login")
	public ResponseEntity<?> loginCustomer(@RequestBody Customer customer,HttpSession session){
		boolean flag = dao.validate(customer);
		if(flag) {
			session.setAttribute("customerName", customer.getCustomerName());
			responseEntity = new ResponseEntity<String>("Logged In Successfully",HttpStatus.CREATED);
		}
		else {
			responseEntity = new ResponseEntity<String>("Error Occurred",HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	@GetMapping("/logout")
	public ResponseEntity<?> logout(HttpSession session){
		if(session!=null&&session.getAttribute("customerName")!=null) {
			session.invalidate();
			responseEntity = new ResponseEntity<String>("Logged Out Successfully",HttpStatus.CREATED);
		}
		else {
			responseEntity = new ResponseEntity<String>("Error Occurred",HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
		
	}
	

}
