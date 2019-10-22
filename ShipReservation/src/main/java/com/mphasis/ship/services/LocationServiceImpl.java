package com.mphasis.ship.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.ship.daos.LocationDao;
import com.mphasis.ship.entities.Location;
import com.mphasis.ship.exceptions.BusinessException;
@Service
public class LocationServiceImpl implements LocationService {
@Autowired
LocationDao locationDao;
	public void addLocation(Location location) throws BusinessException {
		locationDao.addLocation(location);
	}
	

	public void updateLocation(Location location) throws BusinessException {
		locationDao.updateLocation(location);

	}

	public void deleteLocation(String lid) throws BusinessException {
		locationDao.deleteLocation(lid);

	}

	public Location getLocationById(String lid) throws BusinessException {
	
		return locationDao.getLocationById(lid);
	}

	public Set<Location> getLocations() throws BusinessException {
		
		return locationDao.getLocations();
	}

}
