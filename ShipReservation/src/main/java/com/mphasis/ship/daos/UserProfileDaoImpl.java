package com.mphasis.ship.daos;


import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.ship.entities.UserProfile;
import com.mphasis.ship.exceptions.BusinessException;

@Repository
public class UserProfileDaoImpl implements UserProfileDao {
	@Autowired
	SessionFactory sessionFactory;

	public UserProfile login(String username, String pass)  {
		/*Session session=sessionFactory.openSession();       
		Transaction transaction = null;        
		transaction = session.beginTransaction();         
		CriteriaBuilder builder = session.getCriteriaBuilder();    
		CriteriaQuery <UserProfile> query = builder.createQuery(UserProfile.class);     
		query.from(UserProfile.class);
		UserProfile userProfile= session.createQuery(query).uniqueResult();
		session.close();*/
		Session session=sessionFactory.openSession();
		Criteria cr=session.createCriteria(UserProfile.class);
		Criterion uname=Restrictions.eq("userName",username);
		Criterion password=Restrictions.eq("pass",pass);
		LogicalExpression andExperssion=Restrictions.and(uname,password);
		cr.add(andExperssion);
		UserProfile userProfile=(UserProfile) cr.uniqueResult();

		return userProfile;

	}


	public void register(UserProfile userProfile) {
		/*
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		String UserId= (String) session.save(userProfile);
		session.getTransaction().commit();
		session.close();*/
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(userProfile);
		session.getTransaction().commit();
		session.close();
	}

	public void deleteUser(String UserId) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		UserProfile userProfile=(UserProfile)session.get(UserProfile.class,UserId);
		session.delete(userProfile);
		session.getTransaction().commit();
		session.close();
		/*public void deleteUser(String userId){
	        Session session=sessionFactory.openSession();
	        session.beginTransaction();
	        UserProfile userProfile= (UserProfile)session.get(UserProfile.class,userId);
	        session.delete(userProfile);
	        session.getTransaction().commit();
	        session.close();*/
	}

	public UserProfile getUserById(String userId) {

		Session session=sessionFactory.openSession();     
		UserProfile userProfile=(UserProfile)session.get(UserProfile.class,userId);
		return userProfile;

	}


	@Override
	public List<UserProfile> getAll() {
		Session session=sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<UserProfile> users=session.createCriteria(UserProfile.class).list();
		return users;

	}


}
