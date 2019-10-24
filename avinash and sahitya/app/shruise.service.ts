import { Injectable } from "@angular/core";
import {HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from "rxjs/internal/Observable";
import { Location } from "./location";
import { Route } from "./route";
import { Schedule } from "./schedule";
import { Ship } from "./ship";

@Injectable({
  providedIn: 'root'
})
export class ShruiseService {
  headers = {
    headers: new HttpHeaders({
      'Content-Type':'application/json'
    })
  };
  constructor(private _http: HttpClient){}
  addLocation(location:Location){
    console.log(location);
    return this._http.post('http://172.21.41.52:8881/ShipReservation/locations', JSON.stringify(location), this.headers);
  }
  updateLocation(location:Location){
    console.log('update service');
    return this._http.put('http://172.21.41.52:8881/ShipReservation/locations', JSON.stringify(location), this.headers);
  }
  deleteLocation(locId: String){
    console.log('delete service called')
    return this._http.delete(`http://172.21.41.52:8881/ShipReservation/locations/`+locId);
  }
  getLocation(): Observable<Location[]>{
    console.log('service for getlocation');
    return this._http.get<Location[]>('http://172.21.41.52:8881/ShipReservation/locations');
  }
  

  addRoute(route:Route){
    console.log(route);
    return this._http.post('http://172.21.41.52:8881/ShipReservation/routes', JSON.stringify(route), this.headers);
  }
  updateRoute(route:Route){
    return this._http.put('http://172.21.41.52:8881/ShipReservation/routes', JSON.stringify(route), this.headers);
  }
  deleteRoute(routeId: String){
    return this._http.delete(`http://172.21.41.52:8881/ShipReservation/routes/`+routeId);
  }
  getRoute(): Observable<Route[]>{
    console.log('service for getroute');
    return this._http.get<Route[]>('http://172.21.41.52:8881/ShipReservation/routes');
  }
  getRouteById(routeId:string){
    console.log('service for getroutebyid');
    return this._http.get<Route>(`http://172.21.41.52:8881/ShipReservation/routes/`+ routeId);
  }


  addSchedule(schedule:Schedule){
    console.log('schedule called');
    return this._http.post('http://172.21.41.52:8881/ShipReservation/schedules', JSON.stringify(schedule), this.headers);
  }
  updateSchedule(schedule:Schedule){
    return this._http.put('http://172.21.41.52:8881/ShipReservation/schedules', JSON.stringify(schedule), this.headers);
  }
  deleteSchedule(scheduleId: String){
    console.log('service');
    return this._http.delete(`http://172.21.41.52:8881/ShipReservation/schedules/`+scheduleId);
  }
  getSchedule(): Observable<Schedule[]>{
    console.log('service for getschedule');
    return this._http.get<Schedule[]>('http://172.21.41.52:8881/ShipReservation/schedules');
  }


  addShip(ship:Ship){
    console.log(ship);
    return this._http.post('http://172.21.41.52:8881/ShipReservation/ships', JSON.stringify(ship), this.headers);
  }
  updateShip(schedule:Ship){
    return this._http.put('http://172.21.41.52:8881/ShipReservation/ships', JSON.stringify(Ship), this.headers);
  }
  deleteShip(shipId: String){
    console.log('service');
    return this._http.delete(`http://172.21.41.52:8881/ShipReservation/ships/`+shipId);
  }
  getShip(): Observable<Ship[]>{
    console.log('service for getship');
    return this._http.get<Ship[]>('http://172.21.41.52:8881/ShipReservation/ships');
  }
  getShipById(shipId:string): Observable<Ship>{
    console.log('service for getshipbyid');
    return this._http.get<Ship>(`http://172.21.41.52:8881/ShipReservation/ships/`+shipId);
  }
}