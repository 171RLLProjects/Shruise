import { Component, OnInit } from '@angular/core';
import { Reservation } from '../reservation';
import { ShruiseService } from '../shruise.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.css']
})
export class ReservationsComponent implements OnInit {
reservations:Reservation[];
userId:string;
  constructor(private _reservationService:ShruiseService,private _router:Router) { }
  ngOnInit() {
    this._reservationService.getTickets(this.userId).subscribe(
      reserve=>{this.reservations=reserve;}
    )
  }
cancel(booking:Reservation,bookingId:string,status:string){
  this._router.navigate(['/cancelTicket/',bookingId,status,booking]);
}
}
