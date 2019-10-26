import { Component, OnInit } from '@angular/core';
import { Route } from '../route';
import { Router, ActivatedRoute } from '@angular/router';
import { Location } from '../location';
import { ShruiseService } from '../shruise.service';

@Component({
  selector: 'app-addroute',
  templateUrl: './addroute.component.html'
})
export class AddrouteComponent implements OnInit {
  locations: Location[];
  route =new Route;
  locId1: string;
  locId2: string;
  ;
  constructor(private _shruiseService: ShruiseService, private _router: Router, private activatedRoute: ActivatedRoute ){ }

  ngOnInit() {
    this._shruiseService.getLocation().subscribe(loc=>{
      this.locations=loc;
    },
    error =>{
      alert(error);
    });

    this.route.routeId = this.activatedRoute.snapshot.paramMap.get('routeId');
    //const distance = this.activatedRoute.snapshot.paramMap.get('distance');
    //this.route.distance = +distance;
    //const duration = this.activatedRoute.snapshot.paramMap.get('duration');
    //this.route.duration = duration;
    //const costPerKm = this.activatedRoute.snapshot.paramMap.get('costPerKm');
    //this.route.costPerKm = +costPerKm;
    if(this.route.routeId !== null) {
      this._shruiseService.getRouteById(this.route.routeId).subscribe(route => {
      this.route = route;
      this.locId1 = this.route.source.locId;
      this.locId2 = this.route.destination.locId;
      
      })
    }
  }
   
  addRoute() {
    console.log(this.locId1+' '+this.locId2);
    if(this.route.routeId === null){
    this.route = {
      'routeId':this.route.routeId,
      'distance': this.route.distance,
      'duration':this.route.duration,
      'source':
      {
        'locId': this.locId1,
        'locName': 'testing',
      },
     'destination':{
        'locId': this.locId2,
        'locName': 'testing',
      },
      'costPerkm':this.route.costPerkm,
    };
    console.log(this.locId1);
    this._shruiseService.addRoute(this.route).subscribe(
      route => {
        this._router.navigate(['adminHome/Route']);
      },error => {
        alert(error);
      }
        );
    }
    else{
      this.route = {
        'routeId':this.route.routeId,
        'distance': this.route.distance,
        'duration':this.route.duration,
        'source':
        {
          'locId': this.locId1,
          'locName': 'testing'
        },
       'destination':{
          'locId': this.locId2,
          'locName': 'testing'
        },
        'costPerkm':this.route.costPerkm
      };
      console.log(this.locId1);
      this._shruiseService.updateRoute(this.route).subscribe(
        route => {
          this._router.navigate(['/adminHome/Route']);
        },error => {
          alert(error);
        }
          );

    }
  }
  
} 



