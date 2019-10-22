package com.mphasis.ship.daos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mphasis.ship.entities.Ship;
@Repository
public class ShipDaoImpl implements ShipDao {
	@Autowired
SessionFactory	sessionFactory;

	public void addShip(Ship ship) {
		Session session=sessionFactory.openSession();
	    session.beginTransaction();
	    session.save(ship);
	    session.getTransaction().commit();
	}

	public void updateShip(Ship ship){
		Session session=sessionFactory.openSession();
	    session.beginTransaction();
	    session.update(ship);
	    session.getTransaction().commit();

	}

	public void deleteShip(String shipId)  {
		Session session=sessionFactory.openSession();
        session.beginTransaction();
        Ship ship=(Ship)session.get(Ship.class, shipId);
        session.delete(ship);
        session.getTransaction().commit();
	}

	public Ship getShipById(String shipId) {
		Session session=sessionFactory.openSession();
		Ship ship=(Ship)session.get(Ship.class, shipId);
        return ship;
	}

	public Set<Ship> getShips() {
	        Session session=sessionFactory.openSession();
	        TypedQuery<Ship> query = session.createQuery("from Ship", Ship.class);
	        List<Ship> ships=query.getResultList();
	        Set<Ship> shipSet=new HashSet<>();
	        shipSet.addAll(ships);
	        // Set<Location> locations = (Set<Location>) query.getResultList();
	        return shipSet;
	    }
	

	public Set<Ship> viewShips(String source, String destination) {
		Session session=sessionFactory.openSession();
		Criteria cr=session.createCriteria(Ship.class);
		Criterion source1=Restrictions.eq("source", source);
		Criterion destination1=Restrictions.eq("destination", destination);
		LogicalExpression andExpression=Restrictions.and(source1,destination1);
		cr.add(andExpression);
		Set<Ship> ship=(Set<Ship>)cr.list();
		return ship;
	}

}
