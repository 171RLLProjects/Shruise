package com.mphasis.ship.daos;

import java.util.Set;

import com.mphasis.ship.entities.Route;
import com.mphasis.ship.exceptions.BusinessException;

public interface RouteDao {
	 public void addRoute(Route route);
	    public void updateRoute(Route route);
	    public void deleteRoute(String rid);
	    public Route getRouteById(String rid);
	    public Set<Route> getRoutes();

}
