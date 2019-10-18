package com.mphasis.ship.daos;

import java.util.Set;

import com.mphasis.ship.entities.Location;
import com.mphasis.ship.exceptions.BusinessException;

public interface LocationDao {
	public String addLocation(Location location)throws BusinessException;
	public void updateLocation(Location location)throws BusinessException;
	public void deleteLocation(String lid)throws BusinessException;
	public Location getLocationById(String lid)throws BusinessException;
	public Set<Location> getLocations()throws BusinessException;
}
