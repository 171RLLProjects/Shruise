import { Component, OnInit } from '@angular/core';
import { ShruiceService } from '../shruice.service';
import { Ship } from '../ship';

@Component({
  selector: 'app-shiplist',
  templateUrl: './shiplist.component.html',
  styleUrls: ['./shiplist.component.css']
})
export class ShiplistComponent implements OnInit {
ships :Ship[];
  constructor(private _shruiceService: ShruiceService) { }

  ngOnInit()
  {this._shruiceService.getShip().subscribe( shiplist =>{
  
    this.ships = shiplist;
   });
  
   
  }
 
  
}