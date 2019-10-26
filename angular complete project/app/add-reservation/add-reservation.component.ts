import { Component, OnInit } from '@angular/core';
import { Reservation } from '../reservation';
import { ShruiseService } from '../shruise.service';
import { Router, ActivatedRoute } from '@angular/router';
import { UserProfile } from '../user-profile';
import { Ship } from '../ship';

@Component({
  selector: 'app-add-reservation',
  templateUrl: './add-reservation.component.html',
  styleUrls: ['./add-reservation.component.css']
})
export class AddReservationComponent implements OnInit {
users:UserProfile[];
ships:Ship[];
userId:string;
shipId:string;
scheduleId:string;
routeId:string;
locId:string;
reservation=new Reservation;
  constructor(private _reservationService:ShruiseService,private _router:Router,private _activatedRoute:ActivatedRoute) { }

  ngOnInit() {
this.reservation.bookingId=this._activatedRoute.snapshot.paramMap.get('bookingId');
if(this.reservation.bookingId!==null){
  this._reservationService.getTicketbyId(this.reservation.bookingId).subscribe(reservation=>{
    this.reservation=reservation;
    this.userId=this.reservation.user.userId;
    this.shipId=this.reservation.ship.shipId;
}
  )
  }
  this._reservationService.getShip().subscribe(ship=>{
    this.ships=ship;
  },error=>{
    alert(error);
  });

  this._reservationService.getuser().subscribe(user=>{
    this.users=user;
  },error=>{
    alert(error);
  });
}

addReservation(){
  console.log('hii');
  this.reservation={
    'bookingId':this.reservation.bookingId,
    'totalFare':this.reservation.totalFare,
    'noOfSeats':this.reservation.noOfSeats,
    'cardNo':this.reservation.cardNo,
    'pin':this.reservation.pin,
    'status':this.reservation.status,
    'ship':{
      'shipId': this.shipId,
      'shipName' : 'ravali',
      'seatingCapacity' : 1,
      'wListCapacity' : 11,
      'reserveCapacity' : 5,
      'route': {
        'routeId': this.routeId,
        'distance': 56,
        'duration':'57',
        'costPerkm':70,
        'source':
      {
        'locId': this.locId,
        'locName': 'testing'
      },
     'destination':{
        'locId': this.locId,
        'locName': 'testing'
      },
      },
      'schedule':
    {
      'scheduleId': this.scheduleId,
      'startDate': 'gjkg',
      'endDate':'hfff'
    },
    },
    'user':{
      'userId':this.userId,
      'userName':'RAVALI',
      'pass':'fgjf',
      'gender':'fhfja',
      'role':'gdfs',
      'phoneNo':31424234,
      'address':'gkjfhilugadifj',
      'age':11
    }
  }
  
   this._reservationService.book(this.reservation).subscribe(
    
    data => {
      console.log(this.reservation);
      this._router.navigate(['customerHome/addPassenger']);
    },
    error => {
      alert(error);
   });
}
}


