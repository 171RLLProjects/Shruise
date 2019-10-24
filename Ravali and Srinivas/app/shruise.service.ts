import { Injectable } from '@angular/core';
import { HttpHeaders,HttpClient } from '@angular/common/http';
import{Observable,throwError} from 'rxjs';
import { Route } from './route';
import { Schedule } from './schedule';
import { Ship } from './ship';
import { retry, catchError } from 'rxjs/operators';
import { Passenger } from './passenger';
import { Reservation } from './reservation';
import {UserProfile} from './user-profile';

@Injectable({
  providedIn: 'root'
})
export class ShruiseService {
  headers={
    headers: new HttpHeaders({
      'Content-Type':'application/json'
    })
  };

  constructor(private _http:HttpClient) { }
  handleError(error) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // client-side error
      errorMessage = `Error: ${error.error.message}`;
    } else {
      // server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    window.alert(errorMessage);
    return throwError(errorMessage);
  }
  addLocation(location: Location){
    console.log(location);
    return this._http.post('http://172.21.41.52:8881/ShipReservation/locations',JSON.stringify(location),this.headers);
  }
  addRoute(route: Route){
    console.log(route);
    return this._http.post('http://172.21.41.52:8881/ShipReservation/routes',JSON.stringify(route),this.headers);
  }
  addSchedule(schedule: Schedule){
    console.log(schedule);
    return this._http.post('http://172.21.41.52:8881/ShipReservation/schedules',JSON.stringify(schedule),this.headers);
  }
  addShip(ship: Ship){
    console.log(ship);
    return this._http.post('http://172.21.41.52:8881/ShipReservation/ships',JSON.stringify(ship),this.headers);
  }
  addPassenger(passenger: Passenger){
    console.log(passenger);
    return this._http.post('http://172.21.41.52:8881/ShipReservation/passengers',JSON.stringify(passenger),this.headers);
  }
  book(book: Reservation){
    console.log(book);
    return this._http.post('http://172.21.41.52:8881/ShipReservation/book',JSON.stringify(book),this.headers);
  }
  deleteLocation(locId:string){
    return this._http.delete(`http://172.21.41.52:8881/ShipReservation/locations/`+locId);
  }
  deleteRoute(routeId:string){
    return this._http.delete(`http://172.21.41.52:8881/ShipReservation/routes/`+routeId);
  }
  deleteSchedule(scheduleId:string){
    return this._http.delete(`http://172.21.41.52:8881/ShipReservation/schedules/`+scheduleId);
  }
  deleteShip(shipId:string){
    return this._http.delete(`http://172.21.41.52:8881/ShipReservation/ships/`+shipId);
  }
  getLocation():Observable<Location[]>{
    console.log('service for location');
    return this._http.get<Location[]>('http://172.21.41.52:8881/ShipReservation/locations');
  }
  getRoute():Observable<Route[]>{
    console.log('service for route');
    return this._http.get<Route[]>('http://172.21.41.52:8881/ShipReservation/routes');
  }
  getSchedule():Observable<Schedule[]>{
    console.log('service for schedule');
    return this._http.get<Schedule[]>('http://172.21.41.52:8881/ShipReservation/schedules');
  }

  getShip():Observable<Ship[]>{
    console.log('service for ship');
    return this._http.get<Ship[]>('http://172.21.41.52:8881/ShipReservation/ships');
  }
  getPassengers(bookingId:string):Observable<Passenger[]>{
    console.log('service for passenger');
    return this._http.get<Passenger[]>(`http://172.21.41.52:8881/ShipReservation/passengers/`+bookingId);
  }
  getTickets(userId :string):Observable<Reservation[]>{
    console.log('service for reservation');
    return this._http.get<Reservation[]>(`http://172.21.41.52:8881/ShipReservation/tickets/`+userId);
  }
  
  getLocationById(locId:string):Observable<Location>{
    console.log('service for location');
    return this._http.get<Location>(`http://172.21.41.52:8881/ShipReservation/locations/`+locId);
  }
  getRouteById(routeId:string):Observable<Route>{
    console.log('service for route');
    return this._http.get<Route>(`http://172.21.41.52:8881/ShipReservation/routes/`+routeId);
  }
  getScheduleById(scheduleId:string):Observable<Schedule>{
    console.log('service for schedule');
    return this._http.get<Schedule>(`http://172.21.41.52:8881/ShipReservation/schedules/`+scheduleId);
  }
  getShipById(shipId:string):Observable<Ship>{
    console.log('service for ship');
    return this._http.get<Ship>(`http://172.21.41.52:8881/ShipReservation/ships/`+shipId);
  }
  getPassengerById(passengerId:string):Observable<Passenger>{
    console.log('service for ship');
    return this._http.get<Passenger>(`http://172.21.41.52:8881/ShipReservation/passenger/`+passengerId);
  }
  getTicketbyId(bookingId:string):Observable<Reservation>{
    console.log('service for reservation');
    return this._http.get<Reservation>(`http://172.21.41.52:8881/ShipReservation/ticket/`+bookingId);
  }
  updateLocation(location: Location){
    console.log(location);
    return this._http.put('http://172.21.41.52:8881/ShipReservation/locations',JSON.stringify(location),this.headers);
  }
  updateRoute(route: Route){
    console.log(route);
    return this._http.put('http://172.21.41.52:8881/ShipReservation/routes',JSON.stringify(route),this.headers);
  }
  updateSchedule(schedule: Schedule){
    console.log(schedule);
    return this._http.put('http://172.21.41.52:8881/ShipReservation/schedules',JSON.stringify(schedule),this.headers);
  }
  updateShip(ship: Ship){
    console.log(ship);
    return this._http.put('http://172.21.41.52:8881/ShipReservation/ships',JSON.stringify(ship),this.headers);
  }
  cancelTicket(bookingId:string,status:string,reservation:Reservation){
    console.log(reservation);
return this._http.put(`http://172.21.41.52:8881/ShipReservation/cancel/`+bookingId+status,JSON.stringify(reservation),this.headers);
  }
  updateSeats(shipId:string,ship:Ship){
    console.log(ship);
    return this._http.put(`http://172.21.41.52:8881/ShipReservation/update/`+shipId,JSON.stringify(ship),this.headers);
  }
  getuser():Observable<UserProfile[]>{
    return this._http.get<UserProfile[]>('http://172.21.41.52:8881/ShipReservation/users'); 
  }
  
}
