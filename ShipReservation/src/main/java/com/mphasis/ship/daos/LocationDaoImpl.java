package com.mphasis.ship.daos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.ship.entities.Location;
import com.mphasis.ship.entities.Schedule;
import com.mphasis.ship.exceptions.BusinessException;
@Repository
public class LocationDaoImpl implements LocationDao {
@Autowired
SessionFactory	sessionFactory;
	public  void addLocation(Location location) {
		Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(location);
        session.getTransaction().commit();
        session.close();
	}

	public void updateLocation(Location location) {
		Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(location);
        session.getTransaction().commit();
        session.close();
	}

	public void deleteLocation(String lid) {
		Session session=sessionFactory.openSession();
        session.beginTransaction();
        Location location=(Location)session.get(Location.class, lid);
        session.delete(location);
        session.getTransaction().commit();
        session.close();

	}

	public Location getLocationById(String lid){
		Session session=sessionFactory.openSession();
		Location location=(Location)session.get(Location.class, lid);
        return location;
	}

	public Set<Location> getLocations() {
		
	        Session session=sessionFactory.openSession();
	        TypedQuery<Location> query = session.createQuery("from Location", Location.class);
	        List<Location> locations=query.getResultList();
	        Set<Location> locationSet=new HashSet<>();
	        locationSet.addAll(locations);
	       // Set<Location> locations = (Set<Location>) query.getResultList();
	        return locationSet;
	    }
	}


