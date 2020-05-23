package com.mobile.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobile.model.Customer;
@Repository
@Transactional
public class CustomerDAO {
	@Autowired
	SessionFactory sessionFactory;
	public boolean addCustomer(Customer customer) {
		if(customer==null)
			return false;
		Session session = sessionFactory.getCurrentSession();
		session.save(customer);
		return true;
	}
	public boolean validate(Customer customer) {
		boolean flag = false;
		Session session = sessionFactory.getCurrentSession();
		Query query =  session.createQuery("from Customer");
		List<Customer> customerList = query.list();
		for (Customer cust : customerList) {
			if(cust.getCustomerName().equals(customer.getCustomerName())
					&&
					cust.getPassword().equals(customer.getPassword())
					)
				flag =  true;
		}
		return flag;
	}

}
