package com.mphasis.ship.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

import com.mphasis.ship.daos.PassengerDao;
import com.mphasis.ship.entities.Passenger;
import com.mphasis.ship.exceptions.BusinessException;

@Service
public class PassengerServiceImpl implements PassengerService{
	@Autowired
	PassengerDao passengerDao;
    
	public void addPassenger(Passenger passenger) throws BusinessException {
		passengerDao.addPassenger(passenger);
		
	}

	public List<Passenger> getPassengers(String bookingId) throws BusinessException {
		
		return passengerDao.getPassengers(bookingId);
	}


	
}
