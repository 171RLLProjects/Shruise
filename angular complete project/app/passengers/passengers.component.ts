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
passengers:Passenger[];
bookingId:string;
  constructor(private _passengerService:ShruiseService,private _router:Router) { }

  ngOnInit() {
    this._passengerService.getPassenger().subscribe(
      passenger=>{this.passengers=passenger});

      
  }

}
