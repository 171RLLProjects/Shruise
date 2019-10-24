import { Component, OnInit } from '@angular/core';

import { ShruiseService } from '../shruise.service';
import { Router } from '@angular/router';
import { Passenger } from '../passenger';

@Component({
  selector: 'app-passengers',
  templateUrl: './passengers.component.html',
  styleUrls: ['./passengers.component.css']
})
export class PassengersComponent implements OnInit {
passenger:Passenger[];
bookingId:string;
  constructor(private _passengerService:ShruiseService,private _router:Router) { }

  ngOnInit() {
    this._passengerService.getPassengers(this.bookingId).subscribe(
      passenger=>{this.passenger=passenger;})
  }

}
