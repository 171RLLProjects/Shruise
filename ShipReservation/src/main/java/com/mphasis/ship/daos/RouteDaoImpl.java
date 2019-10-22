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

import com.mphasis.ship.entities.Route;
import com.mphasis.ship.entities.Schedule;
import com.mphasis.ship.exceptions.BusinessException;
@Repository
public class RouteDaoImpl implements RouteDao {
@Autowired
SessionFactory	sessionFactory;
	public void addRoute(Route route) {
		Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(route);
        session.getTransaction().commit();
        session.close();
	}

	public void updateRoute(Route route) {
		Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(route);
        session.getTransaction().commit();
        session.close();

	}

	public void deleteRoute(String rid) {
		Session session=sessionFactory.openSession();
        session.beginTransaction();
        Route route=(Route)session.get(Route.class, rid);
        session.delete(route);
        session.getTransaction().commit();

	}

	public Route getRouteById(String rid)  {
		Session session=sessionFactory.openSession();
		Route route=(Route)session.get(Route.class, rid);
        return route;
	}

	public Set<Route> getRoutes()  {
		
	        Session session=sessionFactory.openSession();
	        TypedQuery<Route> query = session.createQuery("from Route", Route.class);
	        List<Route> routes=query.getResultList();
	        Set<Route> routeSet=new HashSet<>();
	        routeSet.addAll(routes);
	        // Set<Location> locations = (Set<Location>) query.getResultList();
	        return routeSet;
	    }
	

}
