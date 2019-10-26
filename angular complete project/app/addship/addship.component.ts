import { Component, OnInit } from '@angular/core';
import { Ship } from '../ship';
import { Router, ActivatedRoute } from '@angular/router';
import { Schedule } from '../schedule';
import { Route } from '../route';
import { ShruiseService } from '../shruise.service';

@Component({
  selector: 'app-addship',
  templateUrl: './addship.component.html'
})
export class AddShipComponent implements OnInit {
  ship = new Ship;
  schedules: Schedule[];
  routes : Route[];
  routeId: string;
  scheduleId: string;
  locId1: string;
  locId2: string;



  constructor(private _shruiseService: ShruiseService, private _router: Router, private activatedRoute: ActivatedRoute){}

  ngOnInit() {
    


    this._shruiseService.getRoute().subscribe( route => {
      this.routes = route;
    },
    error =>{
      alert(error);

    });


    this._shruiseService.getSchedule().subscribe( schedule => {
      this.schedules = schedule;
    },
    error =>{
      alert(error);

    });

    const shipId = this.activatedRoute.snapshot.paramMap.get('shipId');
    const shipName = this.activatedRoute.snapshot.paramMap.get('shipName');
    const seatingCapacity = this.activatedRoute.snapshot.paramMap.get('seatingCapacity');
    const reserveCapacity = this.activatedRoute.snapshot.paramMap.get('reserveCapacity');
    const wListCapacity = this.activatedRoute.snapshot.paramMap.get('wListCapacity');

      console.log(shipId);
      this.ship.shipId = shipId;
     // this.ship.shipName = shipName;
      //this.ship.seatingCapacity = +seatingCapacity;
     // this.ship.reserveCapacity = +reserveCapacity;
      //this.ship.wListCapacity = +wListCapacity;



      console.log(this.ship.shipId);
      if(this.ship.shipId !== null) {
        this._shruiseService.getShipById(this.ship.shipId).subscribe(ship => {
        this.ship=ship;
        this.routeId = this.ship.route.routeId;
        this.scheduleId = this.ship.schedule.scheduleId;
        })
      }

  }

  addShip() {
     console.log('addship');  
     if(this.ship.shipId === null){
    this.ship={
      'shipId': this.ship.shipId,
      'shipName' : this.ship.shipName,
      'seatingCapacity' : this.ship.seatingCapacity,
      'wListCapacity' : this.ship.wListCapacity,
      'reserveCapacity' : this.ship.reserveCapacity,
      'route': {
        'routeId': this.routeId,
        'distance': 56,
        'duration':'57',
        'costPerkm':70,
        
        'source':
      {
        'locId': this.locId1,
        'locName': 'testing'
      },
     'destination':{
        'locId': this.locId2,
        'locName': 'testing'
      },
      },
      'schedule':
    {
      'scheduleId': this.scheduleId,
      'startDate': 'gjkg',
      'endDate':'hfff'
    },
    
  };
   this._shruiseService.addShip(this.ship).subscribe(
      data => {
       this._router.navigate(['adminHome/Ship']);
      },error => {
        alert(error);
     });
     }
     else{
      this.ship={
        'shipId': this.ship.shipId,
        'shipName' : this.ship.shipName,
        'seatingCapacity' : this.ship.seatingCapacity,
        'wListCapacity' : this.ship.wListCapacity,
        'reserveCapacity' : this.ship.reserveCapacity,
        'route': {
          'routeId': this.routeId,
          'distance': 56,
          'duration':'57',
          'costPerkm':70,
          
          'source':
        {
          'locId': this.locId1,
          'locName': 'testing',
        },
       'destination':{
          'locId': this.locId2,
          'locName': 'testing',
        },
        },
        'schedule':
      {
        'scheduleId': this.scheduleId,
        'startDate': 'gjkg',
        'endDate':'hfff'
      },
      
    };
     this._shruiseService.updateShip(this.ship).subscribe(
        data => {
         this._router.navigate(['adminHome/Ship']);
        },error => {
          alert(error);
       });
     }
      }
            

}
