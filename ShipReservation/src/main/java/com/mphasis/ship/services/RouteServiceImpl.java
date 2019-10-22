package com.mphasis.ship.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.ship.daos.RouteDao;
import com.mphasis.ship.entities.Route;
import com.mphasis.ship.exceptions.BusinessException;
@Service
public class RouteServiceImpl implements RouteService {
@Autowired
RouteDao routeDao;
	public void addRoute(Route route) throws BusinessException {
		routeDao.addRoute(route);

	}

	public void updateRoute(Route route) throws BusinessException {
		routeDao.updateRoute(route);
	}

	public void deleteRoute(String rid) throws BusinessException {
	routeDao.deleteRoute(rid);
	}

	public Route getRouteById(String rid) throws BusinessException {
		
		return routeDao.getRouteById(rid);
	}

	public Set<Route> getRoutes() throws BusinessException {
		
		return routeDao.getRoutes();
	}

}
