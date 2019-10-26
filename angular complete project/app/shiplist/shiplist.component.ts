import { Component, OnInit } from '@angular/core';
import { Ship } from '../ship';
import { ShruiseService } from '../shruise.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-shiplist',
  templateUrl: './shiplist.component.html'
})
export class ShiplistComponent implements OnInit {
ships :Ship[];
  constructor(private _shruiceService: ShruiseService, private _router:Router) { }

  ngOnInit()
  {this._shruiceService.getShip().subscribe( shiplist =>{
  
    this.ships = shiplist;
   });
  
   
  }
  book(){
    this._router.navigate(['customerHome/addReservation']);
  }
 
  
}