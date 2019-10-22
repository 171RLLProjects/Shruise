package com.mphasis.ship.services;

import java.util.Set;

import com.mphasis.ship.entities.Route;
import com.mphasis.ship.exceptions.BusinessException;

public interface RouteService {
	public void addRoute(Route route)throws BusinessException;
    public void updateRoute(Route route)throws BusinessException;
    public void deleteRoute(String rid)throws BusinessException;
    public Route getRouteById(String rid)throws BusinessException;
    public Set<Route> getRoutes()throws BusinessException;

}
