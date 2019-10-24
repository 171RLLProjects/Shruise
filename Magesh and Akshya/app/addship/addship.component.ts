import { Component, OnInit } from '@angular/core';
import { ShruiceService } from '../shruice.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Ship } from '../ship';

@Component({
  selector: 'app-addship',
  templateUrl: './addship.component.html',
  styleUrls: ['./addship.component.css']
})
export class AddshipComponent implements OnInit {
ship = new Ship
  constructor(private _shruiceService : ShruiceService,private _router :Router,private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    const shipId = this.activatedRoute.snapshot.paramMap.get('this.shipId');
     
   }
   
addship(){
  console.log('addship called');
  if (this.ship.shipId !== null) {
    this._shruiceService.addShip(this.ship).subscribe(

      data => {
        this._router.navigate(['/shiplist']);
      },
      error => {
        alert(error);
      });
  }
  
}
}
