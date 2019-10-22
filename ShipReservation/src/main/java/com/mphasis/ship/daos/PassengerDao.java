package com.mphasis.ship.daos;

import java.util.List;

import com.mphasis.ship.entities.Passenger;

public interface PassengerDao {
	public void addPassenger(Passenger passenger);
	public List<Passenger> getPassengers(String bookingId);
}
