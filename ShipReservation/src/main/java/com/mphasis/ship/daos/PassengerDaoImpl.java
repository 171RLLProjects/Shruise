package com.mphasis.ship.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.ship.entities.Passenger;
import com.mphasis.ship.entities.Reservation;

@Repository
public class PassengerDaoImpl implements PassengerDao {
	@Autowired
	SessionFactory sessionFactory;

	public void addPassenger(Passenger passenger) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(passenger);
		session.getTransaction().commit();
		session.close();
	}

	public List<Passenger> getPassengers(String bookingId) {
		Session session=sessionFactory.openSession();
		Reservation reservation=session.get(Reservation.class, bookingId);
		System.out.println("reservaltion");
		System.out.println(reservation.getBookingId()+" "+reservation.getCardNo());
		Criteria cr=session.createCriteria(Passenger.class);
		cr.add(Restrictions.eq("reservation", reservation));
		List<Passenger> passengers=cr.list();
		/*List<Passenger> passengers=session.createCriteria(Passenger.class).add(Restrictions.eq("reservation", reservation)).list();*/
		System.out.println("passengers in dao"+passengers.size());
		//passengers.forEach((p)->System.out.println(p.getAadharNumber()));
		return passengers;
	}
}
