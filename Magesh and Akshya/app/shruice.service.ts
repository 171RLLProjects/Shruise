import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Userprofile } from './userprofile';
import { Observable, throwError } from 'rxjs';
import { retry } from 'rxjs/operators';
import { catchError } from 'rxjs/operators';
import { Ship } from './ship';


@Injectable({
  providedIn: 'root'
})
export class ShruiceService {
  headers = {
    headers: new HttpHeaders(
      { 'content-Type': 'application/json' })
  };
  constructor(private _http: HttpClient) {}
  
  register(userprofile: Userprofile) {
         console.log(userprofile+"service ");
        return this._http.post<Userprofile>('http://172.21.41.52:8881/ShipReservation/register', JSON.stringify(userprofile), this.headers);
  }
  login(userId: string, pass: string) {
            console.log('login called' + userId +' '+pass);
               return this._http.get<Userprofile>(`http://172.21.41.52:8881/ShipReservation/users` + userId + `/` + pass)
               .pipe(
                 retry(1),
                 catchError(this.handleError)
               );
             }
              
  getuser():Observable<Userprofile[]>{
                 console.log('service for getuser');
                   return this._http.get<Userprofile[]>('http://localhost:8123/AkshayaShip/users');  
   }
   getUserById(userId:string){
       return this._http.get<Userprofile>(`http://172.21.41.52:8881/ShipReservation/users` + userId)
       }
     
   deleteUser(userId:string){
     return this._http.delete(`http://172.21.41.52:8881/ShipReservation/users` + userId);
   }
   logout(){
     localStorage.removeItem('currentUser');
    // this.currentUserSubject.next(null);
     //this.currentPassenger.next(null);
     //this.currentTicket.next(null);
   }
 addShip(ship: Ship){
   console.log(ship);
     return this._http.post('http://172.21.41.52:8881/ShipReservation/ships',JSON.stringify(ship),this.headers);
   }
   getShip(): Observable<Ship[]>{
    console.log('service for ship');
    return this._http.get<Ship[]>('http://172.21.41.52:8881/ShipReservation/ships');
    }

    deleteShip(shipId:string){
      return this._http.delete(`http://172.21.41.52:8881/ShipReservation/ships/`+shipId);
    }
    
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
 
 }

 