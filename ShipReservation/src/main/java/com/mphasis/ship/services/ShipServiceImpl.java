package com.mphasis.ship.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.ship.daos.ShipDao;
import com.mphasis.ship.entities.Ship;
import com.mphasis.ship.exceptions.BusinessException;
@Service
public class ShipServiceImpl implements ShipService {
	@Autowired
	ShipDao shipDao;
	public void addShip(Ship ship) throws BusinessException {
		shipDao.addShip(ship);
	}

	public void updateShip(Ship ship) throws BusinessException {
		shipDao.updateShip(ship);

	}

	public void deleteShip(String shipId) throws BusinessException {
		shipDao.deleteShip(shipId);

	}

	public Ship getShipById(String shipId) throws BusinessException {
		
		return shipDao.getShipById(shipId);
	}

	public Set<Ship> viewShips(String source, String destination) throws BusinessException {
		return shipDao.viewShips(source, destination);
	}

	public Set<Ship> getShips() throws BusinessException {
		// TODO Auto-generated method stub
		return shipDao.getShips();
	}

	

}
