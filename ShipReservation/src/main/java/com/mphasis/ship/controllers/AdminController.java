package com.mphasis.ship.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.ship.entities.Location;
import com.mphasis.ship.entities.Route;
import com.mphasis.ship.entities.Schedule;
import com.mphasis.ship.entities.Ship;
import com.mphasis.ship.exceptions.BusinessException;
import com.mphasis.ship.services.LocationService;
import com.mphasis.ship.services.RouteService;
import com.mphasis.ship.services.ScheduleService;
import com.mphasis.ship.services.ShipService;

@RestController
public class AdminController {
	@Autowired
	LocationService locationService;
	@Autowired
	RouteService routeService;
	@Autowired
	ScheduleService scheduleService;
	@Autowired
	ShipService shipService;
	@RequestMapping(value="/locationsadd",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String,String>> addLocation(@RequestBody Location l){
		Map<String,String> response =new HashMap<>();
		try {
			locationService.addLocation(l);
			response.put("ok", "success saving data");
			return ResponseEntity.accepted().body(response);
		} catch (Exception ex) {
			response.put("error", ex.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}

	@RequestMapping(value="/routes",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<Map<String,String>>  addRoute(@RequestBody Route r){
		Map<String,String> response =new HashMap<>();
		try {
			routeService.addRoute(r);
			response.put("ok", "success saving data");
			return ResponseEntity.accepted().body(response);
		} catch (Exception ex) {
			response.put("error", ex.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}
	@RequestMapping(value="/schedules",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String,String>>   addSchedule(@RequestBody Schedule s){
		Map<String,String> response =new HashMap<>();
		try {
			scheduleService.addSchedule(s);
			response.put("ok", "success saving data");
			return ResponseEntity.accepted().body(response);
		} catch (Exception ex) {
			response.put("error", ex.getMessage());
			return ResponseEntity.badRequest().body(response);
		}

	}
	@RequestMapping(value="/ships",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String,String>>  addShip(@RequestBody Ship s){
		Map<String,String> response =new HashMap<>();
		try {
			shipService.addShip(s);
			response.put("ok", "success saving data");
			return ResponseEntity.accepted().body(response);
		} catch (Exception ex) {
			response.put("error", ex.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}
	@RequestMapping(value="/locationsDelete/{locId}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void>  deleteLocation(@PathVariable("locId") String locId){
		try {
			locationService.deleteLocation(locId);
			return new ResponseEntity<Void>(HttpStatus.OK);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

		}
	}
	@RequestMapping(value="/routes/{routeId}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteRoute(@PathVariable("routeId") String routeId){
		try {
			routeService.deleteRoute(routeId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	@RequestMapping(value="/schedules/{scheduleId}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteSchedule(@PathVariable("scheduleId") String scheduleId){
		try {
			scheduleService.deleteSchedule(scheduleId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	@RequestMapping(value="/ships/{shipId}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteShip(@PathVariable("shipId") String shipId){
		try {
			shipService.deleteShip(shipId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}


	@RequestMapping(value="/locations", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set<Location>> getUser(){
		Set<Location> location=null;
		try {
			location=locationService.getLocations();
		} catch (Exception e) {
			try {
				throw new BusinessException("no location found");
			} catch (BusinessException e1) {
				e1.getMessage();
			}
			return new ResponseEntity<Set<Location>>(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.ok().body(location);
	}

	@RequestMapping(value="/routes", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set<Route>> getRoute(){
		Set<Route> route=null;
		try {
			route=routeService.getRoutes();
		} catch (Exception e) {
			try {
				throw new BusinessException("no route found");
			} catch (BusinessException e1) {
				e1.getMessage();
			}
			return new ResponseEntity<Set<Route>>(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.ok().body(route);
	}


	@RequestMapping(value="/schedules", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set<Schedule>> getSchedules(){
		Set<Schedule> schedule=null;
		try {
			schedule=scheduleService.getSchedules();
		} catch (Exception e) {
			try {
				throw new BusinessException("no schedule found");
			} catch (BusinessException e1) {
				e1.getMessage();
			}
			return new ResponseEntity<Set<Schedule>>(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.ok().body(schedule);
	}


	@RequestMapping(value="/ships", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set<Ship>> getShips(){
		Set<Ship> ship=null;
		try {
			ship=shipService.getShips();
		} catch (Exception e) {
			try {
				throw new BusinessException("no ship found");
			} catch (BusinessException e1) {
				e1.getMessage();
			}
			return new ResponseEntity<Set<Ship>>(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.ok().body(ship);
	}


	@RequestMapping(value="/location/{locId}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Location> getCustomerById(@PathVariable ("locId") String locId) throws BusinessException {
		Location location;
		try {
			location=locationService.getLocationById(locId);
			return new ResponseEntity<Location>(location,HttpStatus.OK);   
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Location>(HttpStatus.NOT_FOUND);
		}

	}


	@RequestMapping(value="/routes/{routeId}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Route> getRouterById(@PathVariable ("routeId") String routeId) throws BusinessException {
		Route route;
		try {
			route=routeService.getRouteById(routeId);
			return new ResponseEntity<Route>(route,HttpStatus.OK);   
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Route>(HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value="/schedules/{scheduleId}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Schedule> getScheduleById(@PathVariable ("scheduleId") String scheduleId) throws BusinessException {
		Schedule schedule;
		try {
			schedule=scheduleService.getScheduleById(scheduleId);
			return new ResponseEntity<Schedule>(schedule,HttpStatus.OK);   
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Schedule>(HttpStatus.NOT_FOUND);
		}

	}
	@RequestMapping(value="/ships/{shipId}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ship> getShipById(@PathVariable ("shipId") String shipId) throws BusinessException {
		Ship ship;
		try {
			ship=shipService.getShipById(shipId);
			return new ResponseEntity<Ship>(ship,HttpStatus.OK);   
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Ship>(HttpStatus.NOT_FOUND);
		}

	}
	@RequestMapping(value="/locationsUpdate",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String,String>> updateLocation(@RequestBody Location loc){
		Map<String,String> response =new HashMap<>();

		try {
			locationService.updateLocation(loc);
			response.put("ok", "success updating data");
			return ResponseEntity.accepted().body(response);

		} catch (Exception ex) {
			response.put("error", ex.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}
	@RequestMapping(value="/routes",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String,String>> updateRoute(@RequestBody Route rou){
		Map<String,String> response =new HashMap<>();

		try {
			routeService.updateRoute(rou);
			response.put("ok", "success updating data");
			return ResponseEntity.accepted().body(response);
		} catch (Exception ex) {
			response.put("error", ex.getMessage());
			return ResponseEntity.badRequest().body(response);		}
	}	
	@RequestMapping(value="/schedules",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String,String>> updateSchedule(@RequestBody Schedule sche){
		Map<String,String> response =new HashMap<>();

		try {
			scheduleService.updateSchedule(sche);
			response.put("ok", "success updating data");
			return ResponseEntity.accepted().body(response);
		} catch (Exception ex) {
			response.put("error", ex.getMessage());
			return ResponseEntity.badRequest().body(response);			}
	}
	@RequestMapping(value="/ships",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String,String>> updateShip(@RequestBody Ship ship){
		Map<String,String> response =new HashMap<>();

		try {
			shipService.updateShip(ship);
			response.put("ok", "success updating data");
			return ResponseEntity.accepted().body(response);
		} catch (Exception ex) {
			response.put("error", ex.getMessage());
			return ResponseEntity.badRequest().body(response);			}
	}	

}
