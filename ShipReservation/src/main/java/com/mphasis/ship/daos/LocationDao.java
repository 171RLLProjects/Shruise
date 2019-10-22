package com.mphasis.ship.daos;

import java.util.Set;

import com.mphasis.ship.entities.Location;
import com.mphasis.ship.exceptions.BusinessException;

public interface LocationDao {
	public void addLocation(Location location);
	public void updateLocation(Location location);
	public void deleteLocation(String lid);
	public Location getLocationById(String lid);
	public Set<Location> getLocations();
}
