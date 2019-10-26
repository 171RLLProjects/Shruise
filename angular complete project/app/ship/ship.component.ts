import { Component, OnInit } from '@angular/core';
import { Ship } from '../ship';
import { Router } from '@angular/router';
import { ShruiseService } from '../shruise.service';

@Component({
  selector: 'app-ship',
  templateUrl: './ship.component.html'
})
export class ShipComponent implements OnInit {
  ship: Ship[];
  constructor(private _shruiseService: ShruiseService, private router: Router) { }

  ngOnInit() {
    this._shruiseService.getShip().subscribe( ship => {
      this.ship= ship;
     });
  }
  delete(ship: Ship): void {
    this._shruiseService.deleteShip(ship.shipId).subscribe( data => {
      //this.router.navigate(['/addLocation'])
      this.ship = this.ship.filter(u => u !== ship);
    });
  }
  edit(ship: Ship): void{
    console.log('edit called');
    this.router.navigate(['/adminHome/addShip/', ship]);
  }

}
