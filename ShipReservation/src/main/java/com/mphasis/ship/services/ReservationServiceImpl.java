package com.mphasis.ship.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.ship.daos.PassengerDao;
import com.mphasis.ship.daos.PassengerDaoImpl;
import com.mphasis.ship.daos.ReservationDao;
import com.mphasis.ship.daos.ReservationDaoImpl;
import com.mphasis.ship.daos.ShipDao;
import com.mphasis.ship.daos.ShipDaoImpl;
import com.mphasis.ship.entities.Location;
import com.mphasis.ship.entities.Passenger;
import com.mphasis.ship.entities.Reservation;
import com.mphasis.ship.entities.Route;
import com.mphasis.ship.entities.Schedule;
import com.mphasis.ship.entities.Ship;
import com.mphasis.ship.exceptions.BusinessException;

@Service
public class ReservationServiceImpl  implements ReservationService {

	@Autowired
	ReservationDao reservationDao ;
	@Autowired
	ShipDao shipDao;
	@Autowired 
	PassengerDao passengerDao;
	public void book(Reservation reservation)throws BusinessException {
		reservationDao.book(reservation);
		/*Ship ship=new Ship();
		List<Passenger> passengers=null;
		ship.setReserveCapacity(ship.getSeatingcapacity()-passengers.size());
		if(ship.getReserveCapacity()== 30) {
			ship.setwListCapacity(ship.getwListCapacity()+passengers.size());
		}
		*/
		
	}
	public Reservation getTicket(String bookingId)throws BusinessException {

		return reservationDao.getTicket(bookingId);
	}

	public List<Reservation> getTicketDetails(String userId)throws BusinessException {
		return reservationDao.getTicketDetails(userId);
	}
	
	public void cancelTicket(String bookingId,String status) throws BusinessException {
		
		reservationDao.cancelTicket(bookingId,status);
	}
	@Override
	public String payment(String cardNo, int pin) throws BusinessException {
		String msg="Successful payment";
		if(cardNo.length()==16 && pin>=0000 && pin<=9999 ) {
			return msg;
		}
		else {
			throw new BusinessException("Invalid credentials");
		}
	}
	@Override
	public void updateSeats(String shipId)throws BusinessException{
	reservationDao.updateSeats(shipId);
	}
	
}
