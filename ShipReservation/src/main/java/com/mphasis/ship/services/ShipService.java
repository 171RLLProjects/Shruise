package com.mphasis.ship.services;

import java.util.Set;

import com.mphasis.ship.entities.Ship;
import com.mphasis.ship.exceptions.BusinessException;

public interface ShipService {
	 public void addShip(Ship ship)throws BusinessException;
	    public void updateShip(Ship ship)throws BusinessException;
	    public void deleteShip(String shipId)throws BusinessException;
	    public Ship getShipById(String shipId)throws BusinessException;
	    public Set<Ship> getShips()throws BusinessException;
	    public Set<Ship> viewShips(String source,String destination)throws BusinessException;
	    

}
