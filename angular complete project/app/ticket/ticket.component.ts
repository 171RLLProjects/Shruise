import { Component, OnInit } from '@angular/core';
import { ShruiseService } from '../shruise.service';
import { Router } from '@angular/router';
import { Passenger } from '../passenger';
import { Reservation } from '../reservation';

@Component({
    selector: 'app-ticket',
    templateUrl: './ticket.component.html'
})
export class TicketComponent implements OnInit{
    passengerId:string;
    passengers:Passenger[];
    bookingId:string;
    status:string;
    status1:string;
    reservation:Reservation;
    constructor(private _shruiceService: ShruiseService,private _passengerService:ShruiseService, private _router:Router){}
    ngOnInit() {
      this._passengerService.getPassenger().subscribe(
        passenger=>{this.passengers=passenger});
    
     
    }
    cancel( bookingId1:string, status:string){
        this._shruiceService.cancelTicket(this.bookingId,this.status).subscribe(
            data => {
     
                this._router.navigate(['customerHome/ticket']);
              },
              error => {
                alert(error);
              }
        );
      
    }
   
}