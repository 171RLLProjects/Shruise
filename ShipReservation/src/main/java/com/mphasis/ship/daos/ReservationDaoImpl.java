package com.mphasis.ship.daos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.ship.entities.Location;
import com.mphasis.ship.entities.Passenger;
import com.mphasis.ship.entities.Reservation;
import com.mphasis.ship.entities.Route;
import com.mphasis.ship.entities.Schedule;
import com.mphasis.ship.entities.Ship;
import com.mphasis.ship.entities.UserProfile;


@Repository
public class ReservationDaoImpl implements ReservationDao {

	@Autowired
	SessionFactory sessionFactory;
	Reservation reservation=new Reservation();
	
	public void book(Reservation reservation) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(reservation);
		session.getTransaction().commit();
		session.close();
	}
	public Reservation getTicket(String bookingId) {
		Session session=sessionFactory.openSession();
		Reservation reservation=(Reservation)session.get(Reservation.class, bookingId);
		return reservation;
	}
	public void cancelTicket(String bookingId,String status) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Reservation reservation=(Reservation)session.load(Reservation.class, bookingId);
		reservation.setStatus(status);
		session.update(reservation);
		session.getTransaction().commit();
		session.close();
		
	}
	

	public List<Reservation> getTicketDetails(String userId) {
		Session session = sessionFactory.openSession();
		List<Reservation> reservations=session.createCriteria(Reservation.class).add(Restrictions.eq("user", userId)).list();
		return reservations;
	}
	
	public void updateSeats(String shipId) {
		 Session session=sessionFactory.openSession();    
	        session.beginTransaction();     
	        Ship ship=session.load(Ship.class,shipId);    
	        int remainingSeats=ship.getSeatingcapacity();
	        int newSeats= remainingSeats-reservation.getNoOfSeats();
	        ship.setReserveCapacity(newSeats);
	        session.update(ship);    
	        session.getTransaction().commit();      
	        session.close();   
	}
}
