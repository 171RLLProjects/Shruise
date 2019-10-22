package com.mphasis.ship.daos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.mphasis.ship.entities.Location;
import com.mphasis.ship.entities.Passenger;
import com.mphasis.ship.entities.Reservation;
import com.mphasis.ship.entities.Ship;

public interface ReservationDao {
    public void book(Reservation reservation);
    public Reservation getTicket(String bookingId);
    public void cancelTicket(String bookingId,String status);
    public List<Reservation> getTicketDetails(String userId);
    public void updateSeats(String shipId);
}
  