package com.mphasis.ship.services;

import java.util.ArrayList;
import java.util.List;

import com.mphasis.ship.entities.Location;
import com.mphasis.ship.entities.Passenger;
import com.mphasis.ship.entities.Reservation;
import com.mphasis.ship.entities.Ship;
import com.mphasis.ship.exceptions.BusinessException;

public interface ReservationService {
	public void book(Reservation reservation)throws BusinessException;
    public Reservation getTicket(String bookingId)throws BusinessException;
    public void cancelTicket(String bookingId,String status)throws BusinessException;
    public List<Reservation> getTicketDetails(String userId)throws BusinessException;
    public String payment(String cardNo, int pin) throws BusinessException;
    public void updateSeats(String shipId) throws BusinessException;
}
