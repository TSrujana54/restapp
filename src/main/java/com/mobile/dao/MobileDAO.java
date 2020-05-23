package com.mobile.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobile.model.Mobile;
import com.mobile.model.Sim;

@Repository
@Transactional
public class MobileDAO {
	@Autowired
	SessionFactory sessionFactory;
	public boolean addMobile(Mobile mobile) {
		List<Sim> sim = mobile.getSimList();
		sim.stream().forEach(System.out::println);
		if(mobile==null)
			return false;
		Session session = sessionFactory.getCurrentSession();
		session.save(mobile);
		for (Sim sim2 : sim) {
			session.save(sim2);
		}
		session.flush();
		return true;
		
	}
	public boolean deleteMobile(String mobileId) {
		boolean flag =false;
		if(mobileId!=null) {
			return flag;
		}
		Session session = sessionFactory.getCurrentSession();
		List<Mobile> mobileList = getMobileObjects();
		for (Mobile mobile : mobileList) {
			if(mobile.getMobileId()==mobileId) {
				session.delete(mobile);
				flag = true;
			}
			
		}
		
		return flag;
	}
	public List<Mobile> getMobileObjects(){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Mobile");
		return query.list();
	}

}
