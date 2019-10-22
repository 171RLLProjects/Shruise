package com.mphasis.ship.daos;

import java.util.Set;

import com.mphasis.ship.entities.Ship;

public interface ShipDao {
	   public void addShip(Ship ship);
	    public void updateShip(Ship ship);
	    public void deleteShip(String shipId);
	    public Ship getShipById(String shipId);
	    public Set<Ship> viewShips(String source,String destination);
	    public Set<Ship> getShips();
	    
   
}
