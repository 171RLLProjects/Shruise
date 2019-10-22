package com.mphasis.ship.services;

import java.util.List;

import com.mphasis.ship.entities.Passenger;
import com.mphasis.ship.exceptions.BusinessException;

public interface PassengerService {
	public void addPassenger(Passenger passenger) throws BusinessException;
	public List<Passenger> getPassengers(String bookingId) throws BusinessException;
}
